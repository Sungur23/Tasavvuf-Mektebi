package soft.bigeran.dervis.GecisEkrani;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.github.javiersantos.appupdater.AppUpdater;
import com.github.javiersantos.appupdater.enums.UpdateFrom;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jaeger.library.StatusBarUtil;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.AnaEkran.MainActivity;
import soft.bigeran.dervis.R;


public class SalavatEkrani extends AppCompatActivity implements View.OnClickListener {
    private TextView SalavatSayı, Sayıtoplam, KalanSayı;
    private Button SalavatBasıcı, SalavatDevam;

    private int counter, counter2, sayikıssa;
    private SharedPreferences SalavatKaydedici;
    private Integer Saym, Saym2;
    private static final String TAG = "Salavat";
    private static final int REQUEST_PERMISSIONS = 20;

    Boolean sesdurum, hadisdurum, esmadurum;
    private Button mGüncelle;
    private Button mAtla;
    private LinearLayout mUygulamayıgüncelleekranı;
    private LinearLayout mSalavatekranı;

    String Görünürlük;
    private TextView mRef;
    DatabaseReference Güncelle;

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
        setContentView(R.layout.salavat_ekrani);
        initView();
        StatusBarUtil.setTransparent(SalavatEkrani.this);


        Güncelle = FirebaseDatabase.getInstance().getReference().child("Güncellex").child("Yazı");


        Güncelle.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Görünürlük = dataSnapshot.getValue(String.class);

                mRef.setText(Görünürlük);

                if (mRef.getText().toString().equals("Güncelle")) {
                    mUygulamayıgüncelleekranı.setVisibility(View.VISIBLE);
                    mSalavatekranı.setVisibility(View.GONE);
                } else if (mRef.getText().toString().equals("Hayır")) {
                    mUygulamayıgüncelleekranı.setVisibility(View.GONE);
                    mSalavatekranı.setVisibility(View.VISIBLE);


                }else{

                    mUygulamayıgüncelleekranı.setVisibility(View.GONE);
                    mSalavatekranı.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mUygulamayıgüncelleekranı.setVisibility(View.GONE);
                mSalavatekranı.setVisibility(View.VISIBLE);

            }
        });


        Appupteder();
        YoYo.with(Techniques.Pulse)
                .duration(700)
                .repeat(1)
                .playOn(findViewById(R.id.button));

        Toasty.warning(getApplicationContext(), getResources().getString(R.string.SalavatNot), Toast.LENGTH_LONG).show();


        SalavatBasıcı = findViewById(R.id.button);
        SalavatDevam = findViewById(R.id.SalavatDevam);
        SalavatSayı = findViewById(R.id.sayı);
        Sayıtoplam = findViewById(R.id.sayıtum);
        KalanSayı = findViewById(R.id.kal);

        SalavatKaydedici = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        counter2 = SalavatKaydedici.getInt("counter", 0);
        Sayıtoplam.setText("" + counter2);

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        sesdurum = mPrefs.getBoolean("SettingSes", true);
        hadisdurum = mPrefs.getBoolean("SettingHadis", false);
        esmadurum = mPrefs.getBoolean("SettingEsma", false);
        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.m);

        SalavatBasıcı.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sesdurum == true) {
                    ses.start();
                } else if (sesdurum == false) {
                    ses.stop();
                }
                counter++;
                SalavatSayı.setText("" + counter);
                Saym = Integer.parseInt(SalavatSayı.getText().toString());
                Saym2 = Integer.parseInt(Sayıtoplam.getText().toString());
                counter2 = (Saym + Saym2);
                if (Saym == 0) {
                    KalanSayı.setText(R.string.Kalan5);

                } else if (Saym == 1) {
                    SalavatDevam.setBackgroundResource(R.drawable.sagki2);
                    KalanSayı.setText(R.string.Kalan4);
                } else if (Saym == 2) {
                    SalavatDevam.setBackgroundResource(R.drawable.sags);
                    KalanSayı.setText(R.string.Kalan3);
                } else if (Saym == 3) {
                    KalanSayı.setText(R.string.Kalan2);
                } else if (Saym == 4) {
                    KalanSayı.setText(R.string.Kalan1);
                } else if (Saym >= 5) {
                    YoYo.with(Techniques.Tada)
                            .duration(700)
                            .repeat(5)
                            .playOn(findViewById(R.id.SalavatDevam));
                    KalanSayı.setText(R.string.DevamEt);
                    SalavatDevam.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selektor));
                    SalavatDevam.setBackgroundResource(R.drawable.sagy);
                }

            }
        });

        SalavatDevam.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ApplySharedPref")
            @Override
            public void onClick(View v) {
                if ((KalanSayı.getText().toString().equals("Devam Et") || (KalanSayı.getText().toString().equals("Next")))) {

                    if ((hadisdurum == true) && (KalanSayı.getText().toString().equals("Devam Et"))) {
                        hadisekrani();
                    } else if ((esmadurum == true) && (KalanSayı.getText().toString().equals("Devam Et"))) {
                        esmaekrani();
                    } else if ((hadisdurum == false) && (esmadurum == false)) {
                        anamenu();
                    } else if (KalanSayı.getText().toString().equals("Next")) {
                        anamenu();
                    }


                } else {
                    Toasty.error(getApplicationContext(), getResources().getString(R.string.SalavatNot), Toast.LENGTH_LONG).show();


                }
            }
        });
    }

    public boolean InternetKontrol(boolean b) {
        boolean connected = b;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;


        } else {

            mUygulamayıgüncelleekranı.setVisibility(View.GONE);
            mSalavatekranı.setVisibility(View.VISIBLE);

        }
        return connected;
    }

    private void initView() {
        mGüncelle = (Button) findViewById(R.id.güncelle);
        mGüncelle.setOnClickListener(this);
        mAtla = (Button) findViewById(R.id.atla);
        mAtla.setOnClickListener(this);
        mUygulamayıgüncelleekranı = (LinearLayout) findViewById(R.id.uygulamayıgüncelleekranı);
        mSalavatekranı = (LinearLayout) findViewById(R.id.salavatekranı);
        mRef = (TextView) findViewById(R.id.ref);
    }


    public void hadisekrani() {
        startActivity(new Intent(SalavatEkrani.this, HadisEkrani.class));
        Animatoo.animateFade(SalavatEkrani.this);
        finish();
    }

    public void esmaekrani() {
        startActivity(new Intent(SalavatEkrani.this, EsmaEkrani.class));
        Animatoo.animateFade(SalavatEkrani.this);
        finish();
    }

    public void anamenu() {
        startActivity(new Intent(SalavatEkrani.this, MainActivity.class));
        Animatoo.animateFade(SalavatEkrani.this);
        finish();
    }

    private void Appupteder() {

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;

            AppUpdater appUpdater = new AppUpdater(this)
                    .setUpdateFrom(UpdateFrom.GOOGLE_PLAY)
                    .showEvery(5)
                    .setTitleOnUpdateAvailable("Uygulamanı Güncellemelisin")
                    .setContentOnUpdateAvailable("Yeni özelliklerin,kitapların ve videoların eklendiği Tasavvuf Mektebi'nin yeni sürümü Play Storede yayınlandı."
                            + "\n" + "Güncelleyiniz..")
                    .setButtonUpdate("Güncelle")
                    .setButtonDismiss("Sonra")
                    .setIcon(R.mipmap.ic_launcher_round)

                    .setButtonUpdateClickListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Toasty.warning(SalavatEkrani.this, "Wifi bağlantısındayken güncellemeniz tavsiye edilir !", Toast.LENGTH_LONG).show();
                            final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                            } catch (ActivityNotFoundException anfe) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                            }
                        }
                    })
                    .setButtonDismissClickListener(new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dialog.dismiss();
                            Toasty.error(SalavatEkrani.this, "Yeni özellikleri kaçıracaksın..", Toast.LENGTH_LONG).show();
                        }
                    })// Notification icon
                    .setCancelable(true);
            appUpdater.start();


        } else {

            connected = false;
        }


    }


    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = SalavatKaydedici.edit();
        editor.putInt("counter", counter2);
        editor.commit();
        super.onPause();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.güncelle:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" +"soft.bigeran.dervis"));
                startActivity(intent);
                // TODO 19/12/09
                break;
            case R.id.atla:
                mUygulamayıgüncelleekranı.setVisibility(View.GONE);
                mSalavatekranı.setVisibility(View.VISIBLE);
                // TODO 19/12/09
                break;
            case R.id.SalavatDevam:
                // TODO 19/12/09
                break;
            case R.id.button:
                // TODO 19/12/09
                break;
            default:
                break;
        }
    }
}
