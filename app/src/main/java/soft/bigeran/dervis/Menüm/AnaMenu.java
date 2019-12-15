package soft.bigeran.dervis.Menüm;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Ayarlar.Ayarlar;

import soft.bigeran.dervis.BuildConfig;

import soft.bigeran.dervis.Chat.MainActivity;

import soft.bigeran.dervis.Classlar.DosyaDownloader;

import soft.bigeran.dervis.EsmaülHüsna.EsmaulHusna;
import soft.bigeran.dervis.EvliyalarAnksiklopedisi.MainActivitySearchView;
import soft.bigeran.dervis.HadisCarki.HadisCarki;
import soft.bigeran.dervis.HatmeEkrani.HatmeAnaEkrani;
import soft.bigeran.dervis.KazaNamazlari.KazaMenu;


import soft.bigeran.dervis.PdfGörüntüleme.PdfGoruntuleme;
import soft.bigeran.dervis.Quran.Quran;
import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Sadatikiram.SadatlarMenu;

import soft.bigeran.dervis.Sohbetler.SohbetMenü.SohbetMenu;
import soft.bigeran.dervis.Sureler.SurelerMenu;
import soft.bigeran.dervis.Tarikatlar.Tarikatlar;
import soft.bigeran.dervis.Tasavvuf.Tasavvuf;
import soft.bigeran.dervis.Youtube.Youtube;
import soft.bigeran.dervis.Zikirmatik.Zikirsec;

import static soft.bigeran.dervis.Sohbetler.Sohbetler.ApiYoutube;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.Max;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.TaslakKanal;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.TaslakPlaylist;


public class AnaMenu extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "DemoActivity";
    private static final int REQUEST_PERMISSIONS = 20;

    KProgressHUD hud;

    private Button mTarikatlar;
    private Button mKütüphane;
    private Button mSohbetler;
    private Button mKazanamazları;
    private Button mZikirmatik;
    private Button mSadatıkiram;
    private Button mSureler;
    private Button mKuranıkerim;
    private Button mDelalülhayrat;
    private Button mAyarlar;
    private Button mDuyurular;
    private Button mDergahbul;
    private Button mTasavvufbilgisi;
    private Button mHatmehacegan;
    private Button mEzanvakti;
    private Button mHadiscarkı;
    private Button mEsmaülhüsna;
    private Button mEvliyalaransiklopedisi;
    private Button mİletişim;
    private Button mPaylaş;
    private LinearLayout mChatgizleyicilayout;
    private Button mChat;
    private LinearLayout mChatlayout;
    private DatabaseReference ddRefGörünürlük;
    private LinearLayout mSohbetlayout;
    private LinearLayout mDergahlayout;
    private LinearLayout mPaylaslayout;
    private LinearLayout mDuyurulayout;

    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(R.drawable.red).setTitle(R.string.Çıkış)
                .setMessage(R.string.Eminmisin)
                .setPositiveButton(R.string.Evet, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton(R.string.Hayır, null).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ana_menu);
        initView();
        Rateapp();
        Görünürlük();




    }

    public void Rateapp() {

        SharedPreferences preferences = getSharedPreferences("progress", MODE_PRIVATE);
        int appUsedCount = preferences.getInt("appUsedCount", 0);
        appUsedCount++;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("appUsedCount", appUsedCount);
        editor.apply();

        if ((appUsedCount == 10) || (appUsedCount == 50) || (appUsedCount == 100) || (appUsedCount == 200) || (appUsedCount == 300)) {

            new AlertDialog.Builder(this).setIcon(R.drawable.red).setTitle("Görüşünüz nedir?")
                    .setMessage("Uygulamadan Memnun musunuz?")
                    .setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("market://details?id=" + getPackageName()));
                            startActivity(intent);


                        }
                    }).setNegativeButton("Hayır", null).show();

        }


    }


    public void Görünürlük() {

        if (InternetKontrol(true)){
            String Görünürlük = "Görünürlük";
            DatabaseReference ddRefGörünürlük = FirebaseDatabase.getInstance().getReference().child("Duyurular").child(Görünürlük).child("Chatdurum");
            ddRefGörünürlük.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    String value = dataSnapshot.getValue(String.class);
                    if (value.equals("g")) {
                        mChatlayout.setVisibility(View.VISIBLE);
                        mChatgizleyicilayout.setVisibility(View.INVISIBLE);
                    } else {
                        mChatlayout.setVisibility(View.GONE);
                        mChatgizleyicilayout.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }

            });

        } else {


            mDuyurulayout.setVisibility(View.GONE);
            mPaylaslayout.setVisibility(View.GONE);
            mChatlayout.setVisibility(View.GONE);
            mChatgizleyicilayout.setVisibility(View.GONE);
            mSohbetlayout.setVisibility(View.GONE);
            mDergahlayout.setVisibility(View.GONE);
            Toasty.success(getApplicationContext(), "İnternet bağlantısı olmadığı için bazı kısımlar gizlendi", Toast.LENGTH_LONG).show(); }


    }


    private void initView() {
        mTarikatlar = (Button) findViewById(R.id.tarikatlar);
        mTarikatlar.setOnClickListener(this);
        mKütüphane = (Button) findViewById(R.id.kütüphane);
        mKütüphane.setOnClickListener(this);
        mSohbetler = (Button) findViewById(R.id.sohbetler);
        mSohbetler.setOnClickListener(this);
        mKazanamazları = (Button) findViewById(R.id.kazanamazları);
        mKazanamazları.setOnClickListener(this);
        mZikirmatik = (Button) findViewById(R.id.zikirmatik);
        mZikirmatik.setOnClickListener(this);
        mSadatıkiram = (Button) findViewById(R.id.sadatıkiram);
        mSadatıkiram.setOnClickListener(this);
        mSureler = (Button) findViewById(R.id.sureler);
        mSureler.setOnClickListener(this);
        mKuranıkerim = (Button) findViewById(R.id.kuranıkerim);
        mKuranıkerim.setOnClickListener(this);
        mDelalülhayrat = (Button) findViewById(R.id.delalülhayrat);
        mDelalülhayrat.setOnClickListener(this);
        mAyarlar = (Button) findViewById(R.id.Ayarlar);
        mAyarlar.setOnClickListener(this);
        mDuyurular = (Button) findViewById(R.id.duyurular);
        mDuyurular.setOnClickListener(this);
        mDergahbul = (Button) findViewById(R.id.dergahbul);
        mDergahbul.setOnClickListener(this);
        mTasavvufbilgisi = (Button) findViewById(R.id.tasavvufbilgisi);
        mTasavvufbilgisi.setOnClickListener(this);
        mHatmehacegan = (Button) findViewById(R.id.hatmehacegan);
        mHatmehacegan.setOnClickListener(this);
        mEzanvakti = (Button) findViewById(R.id.ezanvakti);
        mEzanvakti.setOnClickListener(this);
        mHadiscarkı = (Button) findViewById(R.id.Hadiscarkı);
        mHadiscarkı.setOnClickListener(this);
        mEsmaülhüsna = (Button) findViewById(R.id.Esmaülhüsna);
        mEsmaülhüsna.setOnClickListener(this);
        mEvliyalaransiklopedisi = (Button) findViewById(R.id.Evliyalaransiklopedisi);
        mEvliyalaransiklopedisi.setOnClickListener(this);
        mİletişim = (Button) findViewById(R.id.iletişim);
        mİletişim.setOnClickListener(this);
        mPaylaş = (Button) findViewById(R.id.paylaş);
        mPaylaş.setOnClickListener(this);
        mChatgizleyicilayout = (LinearLayout) findViewById(R.id.chatgizleyicilayout);
        mChat = (Button) findViewById(R.id.chat);
        mChat.setOnClickListener(this);
        mChatlayout = (LinearLayout) findViewById(R.id.chatlayout);
        mSohbetlayout = (LinearLayout) findViewById(R.id.sohbetlayout);
        mDergahlayout = (LinearLayout) findViewById(R.id.dergahlayout);
        mPaylaslayout = (LinearLayout) findViewById(R.id.paylaslayout);
        mDuyurulayout = (LinearLayout) findViewById(R.id.duyurulayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tarikatlar:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, Tarikatlar.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.kütüphane:

                // TODO 19/08/07
                break;
            case R.id.sohbetler:
                if (InternetKontrol(true)){
                    startActivity(new Intent(AnaMenu.this, SohbetMenu.class));
                    Animatoo.animateFade(AnaMenu.this);
                }
                break;
            case R.id.kazanamazları:
                startActivity(new Intent(AnaMenu.this, KazaMenu.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.zikirmatik:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, Zikirsec.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.sadatıkiram:
                startActivity(new Intent(AnaMenu.this, SadatlarMenu.class));
                Animatoo.animateFade(AnaMenu.this);
                // TODO 19/08/07
                break;
            case R.id.sureler:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, SurelerMenu.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.kuranıkerim:
                File dataDirectory = Environment.getExternalStorageDirectory();
                File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Kur'an-ı Kerim/quraan.pdf");
                if(fileDir.exists()){
                    startActivity(new Intent(AnaMenu.this, Quran.class));
                    Animatoo.animateFade(AnaMenu.this);

                }
                else{
                    if (InternetKontrol(true)){

                        AlertDialog.Builder builder = new AlertDialog.Builder(AnaMenu.this);
                        builder.setTitle("Bir kereye mahsus");
                        builder.setMessage("4 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                        builder.setNegativeButton("Hayır", null);
                        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(AnaMenu.this, Quran.class));
                                Animatoo.animateFade(AnaMenu.this);

                            }
                        });
                        builder.show();

                    }
                }


                break;
            case R.id.delalülhayrat:
                // TODO 19/08/07
                RoundedDelalilulhayrat();
                break;
            case R.id.Ayarlar:

                break;
            case R.id.duyurular:

                break;
            case R.id.dergahbul:

                break;
            case R.id.tasavvufbilgisi:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, Tasavvuf.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.hatmehacegan:
                startActivity(new Intent(AnaMenu.this, HatmeAnaEkrani.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.ezanvakti:

                break;
            case R.id.Hadiscarkı:
                startActivity(new Intent(AnaMenu.this, HadisCarki.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.Evliyalaransiklopedisi:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, MainActivitySearchView.class));
                Animatoo.animateFade(AnaMenu.this);
                break;
            case R.id.iletişim:

                // TODO 19/08/07
                break;
            case R.id.paylaş:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tasavvuf Mektebi");
                    String shareMessage = "\n Tasavvuf ile ilgili güzel bir uygulama buldum, sende yükle bence..\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Seçiniz"));
                } catch (Exception e) {
                    //e.toString();
                }
                // TODO 19/08/07
                break;
            case R.id.Esmaülhüsna:
                // TODO 19/08/07
                startActivity(new Intent(AnaMenu.this, EsmaulHusna.class));
                Animatoo.animateFade(AnaMenu.this);
                break;

            case R.id.chat:// TODO 19/09/08
                if (InternetKontrol(true)){
                    startActivity(new Intent(AnaMenu.this, MainActivity.class));
                    Animatoo.animateFade(AnaMenu.this);
                }
                break;
            case R.id.chatgizleyici:// TODO 19/09/08
                break;
            default:
                break;
        }
    }



    private void YoutubeLink(String Kanalurl,String Playlisturl) {
        Intent intent = new Intent(getApplicationContext(), Youtube.class);
        intent.putExtra("KanalUrl",TaslakKanal+Kanalurl+Max+ApiYoutube );
        //intent.putExtra("CanlıUrl",TaslakCanlıYayın+"UCmdgKI-BG0UP-9mfW6ALp8A"+MaxCanlı+ApiYoutube );
        intent.putExtra("PlaylistUrl",TaslakPlaylist+Playlisturl+Max+ApiYoutube );
        startActivity(intent);

    }


    public void RoundedDelalilulhayrat() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.delalul);


        final Button Deeltr = (Button) dialog.findViewById(R.id.deltr);
        final Button Deelar = (Button) dialog.findViewById(R.id.delar);
        final Button Deelizle = (Button) dialog.findViewById(R.id.delizle);

        //SAVE
        Deeltr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                File dataDirectory = Environment.getExternalStorageDirectory();
                File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Hayrat/delalültr.pdf");
                if(fileDir.exists()){

                    KitapAc("delalültr", "Tasavvuf Mektebi" + "/Hayrat/delalültr.pdf");


                }
                else{



                    AlertDialog.Builder builder = new AlertDialog.Builder(AnaMenu.this);
                    builder.setTitle("Bir kereye mahsus");
                    builder.setMessage("1 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                    builder.setNegativeButton("Hayır", null);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            if (InternetKontrol(true)){

                                new DosyaDownloader(AnaMenu.this).execute("https://drive.google.com/uc?export=download&id=1T--AjzBLRfAS5qaXyMXoZCWudXTuTK4g",".pdf","delalültr","Hayrat", String.valueOf(fileDir));

                            }

                        }
                    });
                    builder.show();


                }


            }
        });


        //SAVE
        Deelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                File dataDirectory = Environment.getExternalStorageDirectory();
                File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Hayrat/delalülar.pdf");
                if(fileDir.exists()){

                    KitapAc("delalülar", "Tasavvuf Mektebi" + "/Hayrat/delalülar.pdf");


                }
                else{


                    AlertDialog.Builder builder = new AlertDialog.Builder(AnaMenu.this);
                    builder.setTitle("Bir kereye mahsus");
                    builder.setMessage("9 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                    builder.setNegativeButton("Hayır", null);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            if (InternetKontrol(true)){

                                new DosyaDownloader(AnaMenu.this).execute("https://drive.google.com/uc?export=download&id=1bvI1O9SC5LuMkRr4QYWlsvN2YsXM7Gfp",".pdf","delalülar","Hayrat", String.valueOf(fileDir));

                            }


                        }
                    });
                    builder.show();



                }


            }
        });

        Deelizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (InternetKontrol(true)) {
                    YoutubeLink("UCXJzzisBppvV1d5nDvI7-2A","PLD_q6ppX76nPpWP8U8aSimJrGccmt1n8-");
                }
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void KitapAc(String Referansadı, String Klasöryolu) {
        Intent i = new Intent(getApplicationContext(), PdfGoruntuleme.class);
        i.putExtra("Kitapklasöryolu", Klasöryolu);
        i.putExtra("KitapReferans", Referansadı);
        startActivity(i);
    }

    public boolean InternetKontrol(boolean b) {
        boolean connected = b;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;


        } else {

            Toasty.error(this, "İnternet bağlantısını kontrol ediniz ve tekrar deneyiniz", Toast.LENGTH_LONG).show();
            connected = false;
        }
        return connected;
    }



}
