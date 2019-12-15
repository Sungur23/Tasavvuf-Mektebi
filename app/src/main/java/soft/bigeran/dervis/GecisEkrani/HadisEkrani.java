package soft.bigeran.dervis.GecisEkrani;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import soft.bigeran.dervis.Admin.BlurBuilder;

import soft.bigeran.dervis.AnaEkran.MainActivity;
import soft.bigeran.dervis.R;


public class HadisEkrani extends AppCompatActivity {

    private Button Devamet3;
    private TextView Sünnetyazı;
    private ImageView Sünnetgörüntü;
    private FloatingActionButton Paylaş;
    private RelativeLayout mContainerView;

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
        setContentView(R.layout.hadis_ekrani);

        mContainerView = (RelativeLayout) findViewById(R.id.hadislayout);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aplan00014);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        mContainerView.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        Paylaş = (FloatingActionButton) findViewById(R.id.fab22);
        Devamet3 = findViewById(R.id.devamets);
        Sünnetyazı = findViewById(R.id.sünnettext);

        Devamet3.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selektor));

        String yazi = "ha";
        int sayi;
        Random r = new Random();
        sayi = 221 + r.nextInt(718);
        String yazi2 = yazi + String.valueOf(sayi);
        String deger = getString(getResources().getIdentifier(yazi2, "string", getPackageName()));
        Sünnetyazı.setText(deger);

        Paylaş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                String s = Sünnetyazı.getText().toString();
                String a = "\n"+"\n"+"\n"+"Tasavvuf Mektebi";
                String paylas=s+a;
                myIntent.setType("text/plain");
                String shareBody = "⭐⭐⭐";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, paylas);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                Snackbar.make(view,R.string.Paylaş, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        final Boolean esmadurum = mPrefs.getBoolean("SettingEsma",true);

        Devamet3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if ((esmadurum==true)){
                 esmaekranim();
                } else if((esmadurum==false)){
                    startActivity(new Intent(HadisEkrani.this, MainActivity.class));
                    Animatoo.animateFade(HadisEkrani.this);
                    finish();
                }
            }
        });


    }

    public void esmaekranim () {
        startActivity(new Intent(HadisEkrani.this, EsmaEkrani.class));
        Animatoo.animateFade(HadisEkrani.this);
        finish();
    }

}
