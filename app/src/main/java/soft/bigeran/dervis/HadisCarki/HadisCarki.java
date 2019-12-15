package soft.bigeran.dervis.HadisCarki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import soft.bigeran.dervis.R;

public class HadisCarki extends AppCompatActivity {
    private Button btnrclock;
    private ImageView img,Mha;
    private TextView Hadis,Kontrol;
    SharedPreferences kaydet;
    private FloatingActionButton Fab,Fabses;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hadis_carki);

        btnrclock = (Button)findViewById(R.id.döndüren);
        img = (ImageView)findViewById(R.id.dönecek);
        Mha = (ImageView)findViewById(R.id.mha);
        Hadis = (TextView) findViewById(R.id.hadisgöster);
        Fab = (FloatingActionButton) findViewById(R.id.fab22);
        Fabses = (FloatingActionButton) findViewById(R.id.fab222);
        Kontrol = (TextView) findViewById(R.id.seskontrol2);
        kaydet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Fabses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String yazi = Kontrol.getText().toString();
                if(yazi.contentEquals("Acıldı")){
                    Kontrol.setText("Kapandı");
                    Fabses.setImageResource(R.drawable.kapa);
                    Snackbar.make(view, R.string.seskapalı, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else if(yazi.contentEquals("Kapandı")){
                    Kontrol.setText("Acıldı");
                    Fabses.setImageResource(R.drawable.ac);
                    Snackbar.make(view, R.string.sesacık, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


        Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                String s = Hadis.getText().toString();
                myIntent.setType("text/plain");
                String shareBody = "Your body is here";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, s);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                Snackbar.make(view,R.string.Paylaş, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        btnrclock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yazi = Kontrol.getText().toString();
                if(yazi.contentEquals("Acıldı")){
                    stopPlaying();
                    mp = MediaPlayer.create(HadisCarki.this, R.raw.sesim1);
                    mp.start();
                }
                else if(yazi.contentEquals("Kapandı")){
                    stopPlaying();
                }

                if(btnrclock.getText().toString().equals("Döndür")){
                    int sayi;
                    Random r = new Random();
                    sayi = 221 + r.nextInt(718);
                    String yazim = "ha";
                    String yazi2 = yazim + String.valueOf(sayi);
                    String deger = getString(getResources().getIdentifier(yazi2, "string", getPackageName()));
                    Hadis.setText(deger);
                }else if (btnrclock.getText().toString().equals("Rotate")){
                    int sayi;
                    Random r = new Random();
                    sayi = 221 + r.nextInt(79);
                    String yazim = "ha";
                    String yazi2 = yazim + String.valueOf(sayi);
                    String deger = getString(getResources().getIdentifier(yazi2, "string", getPackageName()));
                    Hadis.setText(deger);
                }

                Animation fade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.selektoryavas);
                Mha.startAnimation(fade);
                Animation yazıx = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                Animation aniRotateClk = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anime1);
                img.startAnimation(aniRotateClk);
                Hadis.startAnimation(yazıx);



            }
        });

    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor editor = kaydet.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putString("sesim", Kontrol.getText().toString()); //int değer ekleniyor
        editor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Kontrol.setText(kaydet.getString("sesim","Acıldı"));
        if (Kontrol.getText().toString().equals("Kapandı")) {
            Fabses.setImageResource(R.drawable.kapa);
        }
        else {

            Fabses.setImageResource(R.drawable.ac);
        }

    }
}