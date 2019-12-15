package soft.bigeran.dervis.Kütüphane.Mektubatlar.MektubatıRabbani;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class MektubatiRabbani extends AppCompatActivity {
    EditText neredenEdittext;
    private android.webkit.WebView WebView;
    private TextView SayfaNo;
    private int Değer;
    private int Pathdeğerlink;
    private Button ÖncekiM, SonrakiM;
    private int counterZkr;
    private LinearLayout ÖncekiL,SonrakiL;
    SharedPreferences Kaydedici;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mektubati_rabbani);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog();

            }
        });
        Animation fade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.selektoryavas);
        fab.startAnimation(fade);

        Kaydedici = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        String value = "file:///android_asset/mektubat/mektubat_"+Kaydedici.getString("MektubNo","1")+".html";
        Mektubatım(value);

        SayfaNo = (TextView) findViewById(R.id.SayfaNo);
        ÖncekiL = (LinearLayout) findViewById(R.id.ÖnceL);
        SonrakiL = (LinearLayout) findViewById(R.id.SonrakiL);
        ÖncekiM = (Button) findViewById(R.id.öncem);
        SonrakiM = (Button) findViewById(R.id.sonram);

        SayfaNo.setText(Kaydedici.getString("MektubNo","1"));

        if (Kaydedici.getString("MektubNo","1").equals("1")){
            ÖncekiL.setVisibility(View.INVISIBLE);
        }
        else if (Kaydedici.getString("MektubNo","1").equals("534")){
            SonrakiL.setVisibility(View.INVISIBLE);
        }


        ÖncekiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int Sayı = Integer.parseInt(SayfaNo.getText().toString());

                SayfaNo.setText(String.valueOf(Sayı - 1));
                SonrakiL.setVisibility(View.VISIBLE);

                if (SayfaNo.getText().toString().equals("1")){
                    ÖncekiL.setVisibility(View.INVISIBLE);
                    String value3 = "file:///android_asset/mektubat/mektubat_1.html";
                    Mektubatım(value3);
                }else {
                    ÖncekiL.setVisibility(View.VISIBLE);
                    String value3 = "file:///android_asset/mektubat/mektubat_" +SayfaNo.getText().toString()+ ".html";
                    Mektubatım(value3);
                }

            }




        });

        SonrakiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Sayı = Integer.parseInt(SayfaNo.getText().toString());
                SayfaNo.setText(String.valueOf(Sayı + 1));
                ÖncekiL.setVisibility(View.VISIBLE);
                if (SayfaNo.getText().toString().equals("534")){
                    SonrakiL.setVisibility(View.INVISIBLE);
                    String value3="file:///android_asset/mektubat/mektubat_534.html";
                    Mektubatım(value3);
                }else {
                    SonrakiL.setVisibility(View.VISIBLE);
                    String value3 = "file:///android_asset/mektubat/mektubat_" +SayfaNo.getText().toString()+ ".html";
                    Mektubatım(value3);
                }

            }
        });
    }

    private void displayInputDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Mektuba Git");
        d.setContentView(R.layout.input_dialogmektubatirabbani);
        neredenEdittext= (EditText) d.findViewById(R.id.neredenEdittext);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GET DATA
                Integer nereden= Integer.valueOf(neredenEdittext.getText().toString());

                if(((nereden)>0)&&(nereden<535))
                {
                    if (nereden==1){
                        ÖncekiL.setVisibility(View.INVISIBLE);
                        SonrakiL.setVisibility(View.VISIBLE);


                    }
                    else if (nereden==534){
                        SonrakiL.setVisibility(View.INVISIBLE);
                        ÖncekiL.setVisibility(View.VISIBLE);

                    }
                    SharedPreferences.Editor editor = Kaydedici.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
                    editor.putString("MektubNo", neredenEdittext.getText().toString()); //int değer ekleniyor
                    editor.commit(); //Kayıt
                    SayfaNo.setText(neredenEdittext.getText().toString());


                    String value3 = "file:///android_asset/mektubat/mektubat_" +SayfaNo.getText().toString()+ ".html";
                    Mektubatım(value3);
                    Toasty.success(MektubatiRabbani.this, "Mektuba gidildi", Toast.LENGTH_SHORT).show();

                }else  if((((nereden)<1)||(nereden>534))||(String.valueOf(nereden).equals(""))){
                    Toasty.error(MektubatiRabbani.this, "1 ile 534 arasında bir sayı giriniz", Toast.LENGTH_SHORT).show();

                }
                else

                    Toasty.warning(MektubatiRabbani.this, "Bir sayı giriniz", Toast.LENGTH_SHORT).show();

            }
        });

        d.show();
    }


    private void Mektubatım(String value) {

        WebView = (android.webkit.WebView) findViewById(R.id.webview);
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.setWebChromeClient(new WebChromeClient());
        WebView.getSettings().setDefaultTextEncodingName("utf-8");
        File file = new File(value);
        if (file.exists()) {
            Log.d("WebView", value);
        }
        Log.d("WebView", value);
        WebView.loadUrl(value);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        SayfaNo.setText(Kaydedici.getString("MektubNo","1"));
    }
    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = Kaydedici.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putString("MektubNo", SayfaNo.getText().toString()); //int değer ekleniyor
        editor.commit(); //Kayıt
        Toasty.success(this, "Kayıt Yapıldı.", Toast.LENGTH_LONG).show();
        super.onPause();
    }

}

