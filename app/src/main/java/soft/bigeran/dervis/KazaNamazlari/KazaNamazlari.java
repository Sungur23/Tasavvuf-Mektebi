package soft.bigeran.dervis.KazaNamazlari;


import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;


public class KazaNamazlari extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences kaydet;
    private Button mSazalt;
    private TextView mSabahtext;
    private Button mSarttır;
    private Button mÖazalt;
    private TextView mÖğletext;
    private Button mÖarttır;
    private Button mİazalt;
    private TextView mİkinditexxt;
    private Button mİarttır;
    private Button mAazalt;
    private TextView mAkşamtext;
    private Button mAarttır;
    private Button mYazalt;
    private TextView mYatsıtext;
    private Button mYarttır;
    private Button mVazalt;
    private TextView mVitrtext;
    private Button mVarttır;
    private Integer  Ssayı, Ösayı, isayı, Asayı, Ysayı, Vsayı;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaza_namazlari);
        initView();
        kaydet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    }

    @Override
    protected void onResume() {
        mSabahtext.setText(kaydet.getString("Sabahkayıt","0"));
        mÖğletext.setText(kaydet.getString("Öğlekayıt","0"));
        mİkinditexxt.setText(kaydet.getString("İkindikayıt","0"));
        mAkşamtext.setText(kaydet.getString("Akşamkayıt","0"));
        mYatsıtext.setText(kaydet.getString("Yatsıkayıt","0"));
        mVitrtext.setText(kaydet.getString("Vitrkayıt","0"));
        super.onResume();
    }

    @Override
    protected void onPause() {
        SharedPreferences.Editor editor = kaydet.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putString("Vitrkayıt", mVitrtext.getText().toString()); //int değer ekleniyor
        editor.putString("Yatsıkayıt", mYatsıtext.getText().toString()); //int değer ekleniyor
        editor.putString("Akşamkayıt", mAkşamtext.getText().toString());//int değer ekleniyor
        editor.putString("İkindikayıt", mİkinditexxt.getText().toString()); //int değer ekleniyor
        editor.putString("Öğlekayıt", mÖğletext.getText().toString()); //int değer ekleniyor
        editor.putString("Sabahkayıt", mSabahtext.getText().toString()); //int değer ekleniyor
        editor.commit(); //Kayıt
        Toasty.success(this, "Kayıt Yapıldı.", Toast.LENGTH_LONG).show();
        super.onPause();
    }


    private void initView() {
        mSazalt = (Button) findViewById(R.id.sazalt);
        mSazalt.setOnClickListener(this);
        mSabahtext = (TextView) findViewById(R.id.sabahtext);
        mSarttır = (Button) findViewById(R.id.sarttır);
        mSarttır.setOnClickListener(this);
        mÖazalt = (Button) findViewById(R.id.öazalt);
        mÖazalt.setOnClickListener(this);
        mÖğletext = (TextView) findViewById(R.id.öğletext);
        mÖarttır = (Button) findViewById(R.id.öarttır);
        mÖarttır.setOnClickListener(this);
        mİazalt = (Button) findViewById(R.id.iazalt);
        mİazalt.setOnClickListener(this);
        mİkinditexxt = (TextView) findViewById(R.id.ikinditexxt);
        mİarttır = (Button) findViewById(R.id.iarttır);
        mİarttır.setOnClickListener(this);
        mAazalt = (Button) findViewById(R.id.aazalt);
        mAazalt.setOnClickListener(this);
        mAkşamtext = (TextView) findViewById(R.id.akşamtext);
        mAarttır = (Button) findViewById(R.id.aarttır);
        mAarttır.setOnClickListener(this);
        mYazalt = (Button) findViewById(R.id.yazalt);
        mYazalt.setOnClickListener(this);
        mYatsıtext = (TextView) findViewById(R.id.yatsıtext);
        mYarttır = (Button) findViewById(R.id.yarttır);
        mYarttır.setOnClickListener(this);
        mVazalt = (Button) findViewById(R.id.vazalt);
        mVazalt.setOnClickListener(this);
        mVitrtext = (TextView) findViewById(R.id.vitrtext);
        mVarttır = (Button) findViewById(R.id.varttır);
        mVarttır.setOnClickListener(this);

    }

    private void ses() {
        mp = MediaPlayer.create(getApplicationContext(), R.raw.m);
        mp.start();
    }
    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }
    private void Kıldım(Integer sint, TextView namaztextvievi) {
        stopPlaying();
        ses();
        sint = Integer.parseInt(namaztextvievi.getText().toString());
        namaztextvievi.setText(String.valueOf(sint - 1));
    }
    private void Kacırdım(Integer sint, TextView namaztextvievi) {
        stopPlaying();
        ses();
        sint = Integer.parseInt(namaztextvievi.getText().toString());
        namaztextvievi.setText(String.valueOf(sint + 1));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sazalt:
                Kacırdım(Ssayı,mSabahtext);
                break;
            case R.id.sarttır:
                Kıldım(Ssayı,mSabahtext);
                break;
            case R.id.öazalt:
                Kacırdım(Ösayı,mÖğletext);
                break;
            case R.id.öarttır:
                Kıldım(Ösayı,mÖğletext);
                break;
            case R.id.iazalt:
                Kacırdım(isayı,mİkinditexxt);
                break;
            case R.id.iarttır:
                Kıldım(isayı,mİkinditexxt);
                break;
            case R.id.aazalt:
                Kacırdım(Asayı,mAkşamtext);
                break;
            case R.id.aarttır:
                Kıldım(Asayı,mAkşamtext);
                break;
            case R.id.yazalt:
                Kacırdım(Ysayı,mYatsıtext);
                break;
            case R.id.yarttır:
                Kıldım(Ysayı,mYatsıtext);
                break;
            case R.id.vazalt:
                Kacırdım(Vsayı,mVitrtext);
                break;
            case R.id.varttır:
                Kıldım(Vsayı,mVitrtext);
                break;
            default:
                break;
        }
    }



}
