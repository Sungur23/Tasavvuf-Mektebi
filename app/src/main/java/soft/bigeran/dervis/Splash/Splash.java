package soft.bigeran.dervis.Splash;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.droidbyme.dialoglib.DroidDialog;
import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.GecisEkrani.SalavatEkrani;
import soft.bigeran.dervis.R;
@SuppressLint("Registered")
public class Splash extends AppCompatActivity {
    Button button1, button2;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocaleHelper.setLocale(context,"");
        setContentView(R.layout.splash);
        Ses();

        button1 = findViewById(R.id.btntr);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                new DroidDialog.Builder(context)
                        .icon(R.drawable.photo13)
                        .title("Dil seçimi!")
                        .content("Yapmış olduğun Türkçe dil seçimini kaydetmek ister misin? Not:Bu ekranı görmeden direk geçilecek. Ayarlar bölümünden dili değiştirebilirsin" )
                        .cancelable(true, true)
                        .positiveButton("Evet", new DroidDialog.onPositiveListener() {
                            @Override
                            public void onPositive(Dialog droidDialog) {

                                Salavatgecis();
                                String Dil ="tr";
                                String True ="False";
                                Olumlusecim(Dil,True);
                                Toasty.success(getApplicationContext(),"Ayarlar kaydedildi..",Toast.LENGTH_LONG).show();
                            }
                        })
                        .negativeButton("Hayır", new DroidDialog.onNegativeListener() {
                            @Override
                            public void onNegative(Dialog droidDialog) {

                                Salavatgecis();
                                String Dil ="tr";
                                Olumsuzsecim(Dil);
                                Toasty.success(getApplicationContext(),"Ayarlar kaydedildi..",Toast.LENGTH_LONG).show();

                            }
                        })
                        .neutralButton("Sonra", new DroidDialog.onNeutralListener() {
                            @Override
                            public void onNeutral(Dialog droidDialog) {

                                Salavatgecis();
                                String Dil ="tr";
                                Olumsuzsecim(Dil);
                            }
                        })
                        .show();

                LocaleHelper.setLocale(context,"tr");//for english;




            }
        });


        button2 = findViewById(R.id.btnen);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DroidDialog.Builder(context)
                        .icon(R.drawable.photo13)
                        .title("Language!")
                        .content("Do u want save your choice?  Note:You can change language screen visibility at the settings menu " )
                        .cancelable(true, true)
                        .positiveButton("Yes", new DroidDialog.onPositiveListener() {
                            @Override
                            public void onPositive(Dialog droidDialog) {

                               Salavatgecis();
                                String True ="False";
                                String Dil ="en";
                                Olumlusecim(Dil,True);
                                Toasty.success(getApplicationContext(),"Saved..",Toast.LENGTH_LONG).show();
                            }
                        })
                        .negativeButton("No", new DroidDialog.onNegativeListener() {
                            @Override
                            public void onNegative(Dialog droidDialog) {

                                Salavatgecis();
                                String Dil ="en";
                                Olumsuzsecim(Dil);
                                Toasty.success(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                            }

                        })
                        .neutralButton("Later", new DroidDialog.onNeutralListener() {
                            @Override
                            public void onNeutral(Dialog droidDialog) {
                                String Dil ="tr";
                                Olumsuzsecim(Dil);
                                Salavatgecis();
                            }
                        })
                        .show();

                LocaleHelper.setLocale(context,"en");//for english;


            }
        });


    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume()
    {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        String dilsecimi = mPrefs.getString("SettingSecim","x");
        Boolean dildurum = mPrefs.getBoolean("SettingDil", true);


        if (dildurum==false){

            if (dilsecimi.toString().equals("tr")){

                Salavatgecis();
            }else if (dilsecimi.toString().equals("en")){
                Salavatgecis();

            }
        }
        super.onResume();
    }


    public void Salavatgecis() {
        startActivity(new Intent(Splash.this, SalavatEkrani.class));
        Animatoo.animateFade(Splash.this);
        finish();

    }


    private void Ses() {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        final Boolean sesdurum = mPrefs.getBoolean("SettingSes",true);
        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.sesim1);
        if (sesdurum==true){
            ses.start();
        }else if (sesdurum==false){
            ses.stop();
        }
    }


    private void Olumsuzsecim(String Dil) {
        String True ="True";
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putBoolean("SettingDil",Boolean.valueOf(True));
        editorum.putString("SettingSecim",Dil);

        editorum.commit();

    }


    private void Olumlusecim(String Dil,String True) {
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putBoolean("SettingDil",Boolean.valueOf(True));
        editorum.putString("SettingSecim",Dil);
        editorum.commit();

    }

}

