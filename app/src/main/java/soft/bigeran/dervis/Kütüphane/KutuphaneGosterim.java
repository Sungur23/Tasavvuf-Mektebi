package soft.bigeran.dervis.Kütüphane;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class KutuphaneGosterim extends AppCompatActivity {

    private Integer Yboyut;
    ScrollView ScrollviesS;
    SharedPreferences Kaydedicim;
    public static int scrollX = 0;
    public static int scrollY = -1;
    private TextView RefK;
    private TextView tv;

    private RelativeLayout AnaEkran;

    private FloatingActionButton Ayarlar;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState
        );
        setContentView(R.layout.kutuphane_gosterim);

        Ayarlar = (FloatingActionButton) findViewById(R.id.fab22);

        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.selektoryavas);
        Ayarlar.startAnimation(fade);
        Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anime1);
        Ayarlar.startAnimation(aniRotateClk);

        Ayarlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoundAyarlar();

            }
        });

        Kaydedicim = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        ScrollviesS = (ScrollView) findViewById(R.id.ScrollviewKitaplar);
        AnaEkran = (RelativeLayout) findViewById(R.id.AnaEkranKitaplar);
        RefK = (TextView)findViewById(R.id.refkütüphane);



        final Bundle extras = getIntent().getExtras();
        String Referans = extras.getString("KitapReferans");
        RefK.setText(Referans);
        String value = extras.getString("Kitap");
        final String value2 = value+".txt";


        AssestAcıcı(value2);


        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected void onPreExecute() {

                AnaEkran.setBackgroundResource(R.drawable.ap00001);

            }
            protected Void doInBackground(Void... params)
            {

                try {
                    Thread.sleep(1000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;

            }
            protected void onPostExecute (Void result)
            {
                SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
                int tema = mPrefs.getInt("SettingTema",R.drawable.ap00004);
                int yazırengi = mPrefs.getInt("SettingYazırengi",R.color.siyah);
                AnaEkran.setBackgroundResource(tema);
                tv.setVisibility(View.VISIBLE);
                tv.setTextColor(yazırengi);

            }
        }.execute();

    }



    @SuppressLint("ResourceAsColor")
    private void AssestAcıcı(String value2) {

        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(this.getAssets().open(value2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String s;

        try{

            while ((s = br.readLine()) != null){
                sb.append(s);
                sb.append("\n");

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        tv = (TextView)findViewById(R.id.kitaptext);
        tv.setText(sb.toString());
        YazıBoyutuayarla(tv);

    }

    public void RoundAyarlar(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.round_ayarlar);

        final Button Boyutartır= (Button) dialog.findViewById(R.id.boyutaettır);
        final Button Boyutazalt= (Button) dialog.findViewById(R.id.boyutazaltıcı);
        final TextView Boyuttext= (TextView) dialog.findViewById(R.id.boyuttextim);

        final RoundedImageView Tema1= (RoundedImageView) dialog.findViewById(R.id.tema1);
        final RoundedImageView Tema2= (RoundedImageView) dialog.findViewById(R.id.tema2);
        final RoundedImageView Tema3= (RoundedImageView) dialog.findViewById(R.id.tema3);



        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        String Yaziboyutu = mPrefs.getString("SettingYazıboyutu","21");
        int Boyut = Integer.parseInt(Yaziboyutu);
        Boyuttext.setText(String.valueOf(Boyut));

        Boyutartır.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicksesi();
                Yboyut = Integer.parseInt(Boyuttext.getText().toString());
                Boyuttext.setText(String.valueOf(Yboyut+1));

                if (Boyuttext.getText().toString().equals("28")){
                    Boyuttext.setText("27");
                    Toasty.error(getApplicationContext(),"Yazı boyutu 14'den küçük 27'den büyük olamaz", Toast.LENGTH_LONG).show();
                }

                Yazıboyutukaydedici(Boyuttext);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,Integer.valueOf(Boyuttext.getText().toString()));

            }
        });

        Boyutazalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicksesi();
                Yboyut = Integer.parseInt(Boyuttext.getText().toString());
                Boyuttext.setText(String.valueOf(Yboyut-1));

                if (Boyuttext.getText().toString().equals("13")){
                    Boyuttext.setText("14");
                    Toasty.error(getApplicationContext(),"Yazı boyutu 14'den küçük 27'den büyük olamaz", Toast.LENGTH_LONG).show();
                }
                Yazıboyutukaydedici(Boyuttext);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,Integer.valueOf(Boyuttext.getText().toString()));



            }
        });

        Tema1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicksesi();
                int resourceId0 = getResources().getIdentifier("white", "colors", getPackageName());
                AnaEkran.setBackgroundResource(resourceId0);
                int yazırengi = getResources().getColor(R.color.black);
                tv.setTextColor(yazırengi);
                Temakaydedici(resourceId0,yazırengi);
            }
        });


        Tema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clicksesi();
                int resourceId02 = getResources().getIdentifier("ap00004", "drawable", getPackageName());
                AnaEkran.setBackgroundResource(resourceId02);
                int yazırengi = getResources().getColor(R.color.black);
                tv.setTextColor(yazırengi);
                Temakaydedici(resourceId02,yazırengi);
            }
        });


        Tema3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicksesi();
                int resourceId03 = getResources().getIdentifier("ap00012", "drawable", getPackageName());
                AnaEkran.setBackgroundResource(resourceId03);
                int yazırengi = getResources().getColor(R.color.white);
                tv.setTextColor(yazırengi);
                Temakaydedici(resourceId03,yazırengi);

            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }


    private void clicksesi() {
        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.m);
        ses.start();
    }

    private void YazıBoyutuayarla(TextView textView) {
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        String Yaziboyutu = mPrefs.getString("SettingYazıboyutu","21");
        int Boyut = Integer.parseInt(Yaziboyutu);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
    }

    private void Temakaydedici(int temaadı, int yazırengi) {
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putInt("SettingTema",temaadı);
        editorum.putInt("SettingYazırengi",yazırengi);
        editorum.commit();

    }

    private void Yazıboyutukaydedici(TextView textView) {
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putString("SettingYazıboyutu",textView.getText().toString());
        editorum.commit();

    }

    @Override
    protected void onPause() {
        super.onPause();
        scrollY = ScrollviesS.getScrollY();
        SharedPreferences.Editor editor = Kaydedicim.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putInt(RefK.getText().toString(), scrollY); //int değer ekleniyor
        editor.commit(); //Kayıt
        Toasty.success(this, "En son okunan yer Kayıt Yapıldı.", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        ScrollviesS.post(new Runnable() {
            @Override
            public void run() {
                ScrollviesS.scrollTo(0,Kaydedicim.getInt(RefK.getText().toString(),0));
            }
        });


    }
}

