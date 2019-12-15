package soft.bigeran.dervis.Zikirmatik;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.droidbyme.dialoglib.DroidDialog;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class Zikirmatik extends AppCompatActivity {

    private int counterZkr,Sayım;
    private Button Basıcı, Temizle,Zikirhakkında;
    private TextView Sayı,Cekilenzikir,Tavsiyesayı,Referanszikir;
    ToggleButton SesKontrolü,TitreşimKontrolü;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zikirhane);


        Basıcı = (Button) findViewById(R.id.basıcı);
        Temizle = (Button) findViewById(R.id.temizle);

        SesKontrolü = (ToggleButton) findViewById(R.id.seskontrolü);
        TitreşimKontrolü = (ToggleButton) findViewById(R.id.titreşimkontrölü);
        Sayı = (TextView) findViewById(R.id.sayı);
        Referanszikir = (TextView) findViewById(R.id.referanszikir);

        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.m);
        final Vibrator kiprasim = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        kiprasim.vibrate(500); //1000 yazarsak 1 saniyelik titreşim yaratır


        Cekilenzikir= (TextView) findViewById(R.id.zikirim);
        Tavsiyesayı= (TextView) findViewById(R.id.tavsiye);
        Zikirhakkında = (Button) findViewById(R.id.zikirhakkında);


        SharedPreferences ZikirAyarları = getSharedPreferences("Ayarlar",0);
        Boolean Sesdurum = ZikirAyarları.getBoolean("SettingSes",true);
        Boolean Titreşimdurum = ZikirAyarları.getBoolean("SettingTitreşim",true);

        String Kayıt = ZikirAyarları.getString("Zikirhane","0");
        Sayı.setText(Kayıt);


        SesKontrolü.setChecked(Sesdurum);
        TitreşimKontrolü.setChecked(Titreşimdurum);




        Bundle extras = getIntent().getExtras();
        String adı = extras.getString("Zikiradı","⭐");
        String sayı = extras.getString("Zikirsayı","⭐");
        String tavsiye = "Tavsiye Edilen Sayı:"+ sayı;

        Cekilenzikir.setText(adı);
        Tavsiyesayı.setText(tavsiye);

        if (adı.equals("Zikir Seçilmedi")){
            Referanszikir.setText("Zikir seçmediğiniz için bilgi yok");
        }else if ((adı.equals("Estağfirullah"))){
            Referanszikir.setText(R.string.zikir1);
        }else if ((adı.equals("Bismillahi Subhanallahi ve Bihamdihi"))){
            Referanszikir.setText(R.string.zikir2);
        }else if ((adı.equals("Lâ ilâhe illallâhu vahdehu lâşerîke leh \n lehu'l mülkü ve lehu'l hamdü ve \n hüve alâ külli şey'in kadîr"))){
            Referanszikir.setText(R.string.zikir3);
        }else if ((adı.equals("Lâ ilâhe illallâhu'l Melikül Hakkul Mübin"))){
            Referanszikir.setText(R.string.zikir4);
        }else if ((adı.equals("Lâ ilâhe illallah"))){
            Referanszikir.setText(R.string.zikir5);
        }else if ((adı.equals("Lâ Havle Velâ Kuvvete İllâ Billâh"))){
            Referanszikir.setText(R.string.zikir6);
        }else if ((adı.equals("Sübhânallahi ve bi–hamdihî sübhânallahi’l–azîm"))){
            Referanszikir.setText(R.string.zikir7);
        }else if ((adı.equals("Sübhânallâhi velhamdülillâhi velâ ilâhe illallahü vallâhü ekber"))){
            Referanszikir.setText(R.string.zikir8);
        }else if ((adı.equals("SubhanAllah"))){
            Referanszikir.setText(R.string.zikir9);
        }else if ((adı.equals("Subhanallahi ve bihamdihi adede halkıhi \n ve rıza nefsihi ve zinete arşihi ve midade kelimatihi"))){
            Referanszikir.setText(R.string.zikir10);
        }else if ((adı.equals("Allâhumme Salli Alâ Muhammed"))){
            Referanszikir.setText(R.string.zikir11);
        }else if ((adı.equals("Estağfirullâhe Ve Etûbu İleyh"))){
            Referanszikir.setText(R.string.zikir13);
        }else if ((adı.equals("İhlas Suresi"))){
            Referanszikir.setText(R.string.zikir12);
        }


        SesKontrolü.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                boolean on = ((ToggleButton) v).isChecked();

                if (on) {

                    SesKontrolü.setChecked(true);
                    Toasty.success(getApplicationContext(),"Tüm sesler Açık",Toast.LENGTH_LONG).show();


                } else {

                    SesKontrolü.setChecked(false);
                    Toasty.warning(getApplicationContext(),"Tüm sesler Kapalı",Toast.LENGTH_LONG).show();

                }

            }

        });
        TitreşimKontrolü.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                boolean on = ((ToggleButton) v).isChecked();

                if (on) {
                    TitreşimKontrolü.setChecked(true);

                    Toasty.success(getApplicationContext(),"Titreşim Açık",Toast.LENGTH_LONG).show();

                } else {

                    TitreşimKontrolü.setChecked(false);

                    Toasty.warning(getApplicationContext(),"Titreşim Kapalı",Toast.LENGTH_LONG).show();


                }

            }

        });
        Temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterZkr = 0;
                Sayı.setText("" + counterZkr);

            }
        });
        Basıcı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean sesk=SesKontrolü.isChecked();
                Boolean titreşimk=TitreşimKontrolü.isChecked();

                if ((sesk==true)&&(titreşimk==true)){

                    ses.start();
                    kiprasim.vibrate(1000);

                }else if ((sesk==false)&&(titreşimk==false)){

                    kiprasim.vibrate(0);

                }else if ((sesk==true)&&(titreşimk==false)){
                    ses.start();
                    kiprasim.vibrate(0);

                }else if ((sesk==false)&&(titreşimk==true)){

                    kiprasim.vibrate(1000);

                }
                Sayım = Integer.parseInt(Sayı.getText().toString());
                Sayı.setText(String.valueOf(Sayım + 1));



            }


        });


        final String yazım=Referanszikir.getText().toString();



        Zikirhakkında.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DroidDialog.Builder(context)
                        .icon(R.drawable.photo13)
                        .title("Bu Zikrin Fazileti!")
                        .content(yazım )
                        .positiveButton("Tamam", new DroidDialog.onPositiveListener() {
                            @Override
                            public void onPositive(Dialog droidDialog) {
                                droidDialog.dismiss();


                                Toasty.warning(getApplicationContext(),"Not:Zikrin hakikatine mürşid-i kamilden alınan zikirle ulaşılır",Toast.LENGTH_LONG).show();
                            }
                        })

                        .show();
            }
        });


    }


    @Override
    protected void onPause() {

        SharedPreferences ZikirAyarları = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = ZikirAyarları.edit();
        editorum.putBoolean("SettingSes",SesKontrolü.isChecked());
        editorum.putBoolean("SettingTitreşim",TitreşimKontrolü.isChecked());
        //editorum.putInt("Zikirkayıt", counterZkr);
        editorum.putString("Zikirhane", Sayı.getText().toString());
        editorum.commit();

        Toasty.success(getApplicationContext(),"Ayarlar kaydedildi..", Toast.LENGTH_LONG).show();
        super.onPause();
    }


}