package soft.bigeran.dervis.Kütüphane.İlmihaller.Safiilmihali;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class Safiİlmihali extends AppCompatActivity {
    private android.webkit.WebView WebView;
    private TextView SayfaNo;
    private int Değer;
    private int Pathdeğerlink;
    private Button ÖncekiM, SonrakiM;
    private int counterZkr;
    private LinearLayout ÖncekiL,SonrakiL;
    SharedPreferences Kaydedici;
    EditText neredenEdittext;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.safi_ilmihali);

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
        String value = "file:///android_asset/safi/safi_ilmihali_"+Kaydedici.getString("SafiSNo","1")+".html";
        Safii(value);
        SayfaNo = (TextView) findViewById(R.id.SayfaNo);
        ÖncekiL = (LinearLayout) findViewById(R.id.ÖnceL);
        SonrakiL = (LinearLayout) findViewById(R.id.SonrakiL);
        ÖncekiM = (Button) findViewById(R.id.öncem);
        SonrakiM = (Button) findViewById(R.id.sonram);

        SayfaNo.setText(Kaydedici.getString("SafiSNo","1"));
        if (Kaydedici.getString("SafiSNo","1").equals("1")){
            ÖncekiL.setVisibility(View.INVISIBLE);
        }

        else if (Kaydedici.getString("SafiSNo","1").equals("276")){
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
                    String value3="file:///android_asset/safi/safi_ilmihali_1.html";
                    Safii(value3);
                }else {
                    ÖncekiL.setVisibility(View.VISIBLE);
                    String value3 = "file:///android_asset/safi/safi_ilmihali_" + SayfaNo.getText().toString() + ".html";
                    Safii(value3);
                }
            }




        });

        SonrakiM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Sayı = Integer.parseInt(SayfaNo.getText().toString());
                SayfaNo.setText(String.valueOf(Sayı + 1));
                ÖncekiL.setVisibility(View.VISIBLE);
                if (SayfaNo.getText().toString().equals("276")){
                    SonrakiL.setVisibility(View.INVISIBLE);
                    String value3="file:///android_asset/safi/safi_ilmihali_276.html";
                    Safii(value3);
                }else {
                    SonrakiL.setVisibility(View.VISIBLE);
                    String value3 = "file:///android_asset/safi/safi_ilmihali_" + SayfaNo.getText().toString() + ".html";
                    Safii(value3);
                }
            }
        });
    }


    private void Safii(String string) {

        WebView = (android.webkit.WebView) findViewById(R.id.webview);
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.setWebChromeClient(new WebChromeClient());
        WebView.getSettings().setDefaultTextEncodingName("utf-8");
        File file = new File(string);
        if (file.exists()) {
            Log.d("WebView", string);
        }
        Log.d("WebView", string);
        WebView.loadUrl(string);
    }

    private void displayInputDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("Sayfaya Git");
        d.setContentView(R.layout.input_dialogsafii);
        neredenEdittext= (EditText) d.findViewById(R.id.neredenEdittext);
        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer nereden= Integer.valueOf(neredenEdittext.getText().toString());
                String strUserName = neredenEdittext.getText().toString();

                if(TextUtils.isEmpty(strUserName)) {
                    Toasty.warning(Safiİlmihali.this, "Bir sayı giriniz", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(((nereden)>0)&&(nereden<277))
                {
                    if (nereden==1){
                        ÖncekiL.setVisibility(View.INVISIBLE);
                        SonrakiL.setVisibility(View.VISIBLE);
                    }
                    else if (nereden==276){
                        SonrakiL.setVisibility(View.INVISIBLE);
                        ÖncekiL.setVisibility(View.VISIBLE);
                    }

                    SharedPreferences.Editor editor = Kaydedici.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
                    editor.putString("SafiSNo", SayfaNo.getText().toString()); //int değer ekleniyor
                    editor.commit(); //Kayıt
                    SayfaNo.setText(neredenEdittext.getText().toString());
                    String value3 = "file:///android_asset/safi/safi_ilmihali_" + SayfaNo.getText().toString() + ".html";
                    Safii(value3);
                    Toasty.success(Safiİlmihali.this, "Sayfaya gidildi", Toast.LENGTH_SHORT).show();

                }else  if(((nereden)<1)||(nereden>276)){
                    Toasty.error(Safiİlmihali.this, "1 ile 276 arasında bir sayı giriniz", Toast.LENGTH_SHORT).show();

                }



            }
        });

        d.show();
    }


    @Override
    protected void onResume()
    {
        SayfaNo.setText(Kaydedici.getString("SafiSNo","1"));
        super.onResume();


    }

    @Override
    protected void onPause() {


        SharedPreferences.Editor editor = Kaydedici.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putString("SafiSNo", SayfaNo.getText().toString()); //int değer ekleniyor
        editor.commit(); //Kayıt
        Toast.makeText(this, "Kayıt Yapıldı.", Toast.LENGTH_LONG).show();
        super.onPause();
    }

}
