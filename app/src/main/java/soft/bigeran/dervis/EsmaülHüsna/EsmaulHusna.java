package soft.bigeran.dervis.EsmaülHüsna;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;

import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.makeramen.roundedimageview.RoundedImageView;

import org.aviran.cookiebar2.CookieBar;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class EsmaulHusna extends AppCompatActivity {
    private TextView SayfaNo,EsmaYazısı;
    private RoundedImageView EsmaGörüntüsü;
    private Button ÖncekiM, SonrakiM;
    private LinearLayout ÖncekiL,SonrakiL;
    SharedPreferences Kaydedici;
    private FloatingActionButton Paylaş;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.esmaul_husna);


        Kaydedici = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SayfaNo = (TextView) findViewById(R.id.SayfaNo);
        EsmaYazısı = (TextView) findViewById(R.id.esmayazı);
        EsmaGörüntüsü = (RoundedImageView) findViewById(R.id.esmagörüntü);
        ÖncekiL = (LinearLayout) findViewById(R.id.ÖnceL);
        SonrakiL = (LinearLayout) findViewById(R.id.SonrakiL);
        ÖncekiM = (Button) findViewById(R.id.öncem);
        SonrakiM = (Button) findViewById(R.id.sonram);
        SayfaNo.setText(Kaydedici.getString("EsmaNo","1"));

        Paylaş = (FloatingActionButton) findViewById(R.id.fab22);

        Paylaş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                String s = EsmaYazısı.getText().toString();
                String a = "\n"+"\n"+"\n"+"Tasavvuf Mektebi";
                String paylas=s+a;
                myIntent.setType("text/plain");
                String shareBody = "⭐⭐⭐";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, paylas);
                startActivity(Intent.createChooser(myIntent, "Share using"));


            }
        });
        if (Kaydedici.getString("EsmaNo","1").equals("1")){
            ÖncekiL.setVisibility(View.INVISIBLE);
        }

        else if (Kaydedici.getString("EsmaNo","1").equals("117")){
            SonrakiL.setVisibility(View.INVISIBLE);
        }
        String ımage = "e" + Kaydedici.getString("EsmaNo","1");
        int resourceIdo = getResources().getIdentifier(ımage, "drawable", getPackageName());
        EsmaGörüntüsü.setBackgroundResource(resourceIdo);
        String deger = getString(getResources().getIdentifier(ımage, "string", getPackageName()));
        EsmaYazısı.setText(deger);
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selektoryavas);
        SayfaNo.startAnimation(fade);

        ÖncekiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SonrakiL.setVisibility(View.VISIBLE);

                if (SayfaNo.getText().toString().equals("1")){
                    ÖncekiL.setVisibility(View.INVISIBLE);
                    EsmaGörüntüsü.setBackgroundResource(R.drawable.e1);
                    EsmaYazısı.setText(R.string.e1);

                }else {
                    ÖncekiL.setVisibility(View.VISIBLE);
                    int Sayı = Integer.parseInt(SayfaNo.getText().toString());
                    SayfaNo.setText(String.valueOf(Sayı - 1));
                    String ımage = "e" +SayfaNo.getText().toString();
                    int resourceIdo = getResources().getIdentifier(ımage, "drawable", getPackageName());
                    EsmaGörüntüsü.setBackgroundResource(resourceIdo);
                    String deger = getString(getResources().getIdentifier(ımage, "string", getPackageName()));
                    EsmaYazısı.setText(deger);
                }
            }
        });

        SonrakiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ÖncekiL.setVisibility(View.VISIBLE);

                if (SayfaNo.getText().toString().equals("117")){
                    SonrakiL.setVisibility(View.INVISIBLE);
                    EsmaGörüntüsü.setBackgroundResource(R.drawable.e117);
                    EsmaYazısı.setText(R.string.e117);
                }else {
                    SonrakiL.setVisibility(View.VISIBLE);
                    int Sayı = Integer.parseInt(SayfaNo.getText().toString());
                    SayfaNo.setText(String.valueOf(Sayı + 1));
                    String ımage = "e" +SayfaNo.getText().toString();
                    int resourceIdo = getResources().getIdentifier(ımage, "drawable", getPackageName());
                    EsmaGörüntüsü.setBackgroundResource(resourceIdo);
                    String deger = getString(getResources().getIdentifier(ımage, "string", getPackageName()));
                    EsmaYazısı.setText(deger);
                }
            }
        });

    }

    @Override
    protected void onResume()
    {
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        String yazıboyutu = mPrefs.getString("SettingYazıboyutu", "21");
        SayfaNo.setText(Kaydedici.getString("EsmaNo","1"));
        EsmaYazısı.setTextSize(TypedValue.COMPLEX_UNIT_SP, Float.parseFloat(yazıboyutu));

        super.onResume();


    }

    @Override
    protected void onPause() {


        SharedPreferences.Editor editor = Kaydedici.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putString("EsmaNo", SayfaNo.getText().toString()); //int değer ekleniyor
        editor.commit(); //Kayıt
        Toasty.success(this, "İsim sırası kaydedildi..", Toast.LENGTH_LONG).show();
        super.onPause();
    }

}
