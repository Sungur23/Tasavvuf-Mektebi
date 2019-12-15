package soft.bigeran.dervis.Delalül;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.io.File;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Classlar.DosyaDownloader;
import soft.bigeran.dervis.PdfGörüntüleme.PdfGoruntuleme;
import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Youtube.Youtube;

import static soft.bigeran.dervis.Sohbetler.Sohbetler.ApiYoutube;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.Max;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.TaslakKanal;
import static soft.bigeran.dervis.Sohbetler.Sohbetler.TaslakPlaylist;

public class Delalul_hayrat extends AppCompatActivity implements View.OnClickListener {


    private Button mTr;
    private Button mAr;
    private Button mDinle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delalul_hayrat);
        initView();

    }

    private void initView() {

        mTr = (Button) findViewById(R.id.tr);
        mTr.setOnClickListener(this);
        mAr = (Button) findViewById(R.id.ar);
        mAr.setOnClickListener(this);
        mDinle = (Button) findViewById(R.id.dinle);
        mDinle.setOnClickListener(this);
    }


    private void YoutubeLink(String Kanalurl, String Playlisturl) {
        Intent intent = new Intent(getApplicationContext(), Youtube.class);
        intent.putExtra("KanalUrl", TaslakKanal + Kanalurl + Max + ApiYoutube);
        //intent.putExtra("CanlıUrl",TaslakCanlıYayın+"UCmdgKI-BG0UP-9mfW6ALp8A"+MaxCanlı+ApiYoutube );
        intent.putExtra("PlaylistUrl", TaslakPlaylist + Playlisturl + Max + ApiYoutube);
        startActivity(intent);

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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tr:
                File dataDirectory = Environment.getExternalStorageDirectory();
                File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Hayrat/delalültr.pdf");
                if (fileDir.exists()) {

                    KitapAc("delalültr", "Tasavvuf Mektebi" + "/Hayrat/delalültr.pdf");


                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder(Delalul_hayrat.this);
                    builder.setTitle("Bir kereye mahsus");
                    builder.setMessage("1 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                    builder.setNegativeButton("Hayır", null);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            if (InternetKontrol(true)) {

                                new DosyaDownloader(Delalul_hayrat.this).execute("https://drive.google.com/uc?export=download&id=1T--AjzBLRfAS5qaXyMXoZCWudXTuTK4g", ".pdf", "delalültr", "Hayrat", String.valueOf(fileDir));

                            }

                        }
                    });
                    builder.show();
                }
                // TODO 19/12/10
                break;
            case R.id.ar:

                dataDirectory = Environment.getExternalStorageDirectory();
                fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Hayrat/delalülar.pdf");
                if (fileDir.exists()) {

                    KitapAc("delalülar", "Tasavvuf Mektebi" + "/Hayrat/delalülar.pdf");


                } else {


                    AlertDialog.Builder builder = new AlertDialog.Builder(Delalul_hayrat.this);
                    builder.setTitle("Bir kereye mahsus");
                    builder.setMessage("9 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                    builder.setNegativeButton("Hayır", null);
                    builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            if (InternetKontrol(true)) {

                                new DosyaDownloader(Delalul_hayrat.this).execute("https://drive.google.com/uc?export=download&id=1bvI1O9SC5LuMkRr4QYWlsvN2YsXM7Gfp", ".pdf", "delalülar", "Hayrat", String.valueOf(fileDir));

                            }


                        }
                    });
                    builder.show();
                }
                // TODO 19/12/10
                break;
            case R.id.dinle:

                if (InternetKontrol(true)) {
                    YoutubeLink("UCXJzzisBppvV1d5nDvI7-2A", "PLD_q6ppX76nPpWP8U8aSimJrGccmt1n8-");
                }
                // TODO 19/12/10
                break;

            default:
                break;
        }
    }
}