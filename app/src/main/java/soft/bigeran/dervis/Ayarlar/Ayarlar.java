package soft.bigeran.dervis.Ayarlar;

import android.app.Activity;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import net.colindodd.toggleimagebutton.ToggleImageButton;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;


public class Ayarlar extends Activity implements View.OnClickListener {


    private ToggleImageButton mSest;
    private ToggleImageButton mDilt;
    private ToggleImageButton mHadist;
    private ToggleImageButton mEsmat;
    private ToggleImageButton mKıssat;
    private Button mBoyutazalt;
    private TextView mYazıboyutu;
    private Button mBoyutarttır;
    private int yazımınboyutu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayarlar);
        initView();


    }

    private void Toogle(ToggleButton toggleButton) {
        boolean on = (toggleButton).isChecked();
        clicksesi();
        if (on) {
            Toasty.success(getApplicationContext(), R.string.dilacık, Toast.LENGTH_LONG).show();
        } else {
            Toasty.warning(getApplicationContext(), R.string.dilkapalı, Toast.LENGTH_LONG).show();
        }

    }

    private void clicksesi() {
        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.m);
        ses.start();
    }


    private void initView() {
        mBoyutazalt = (Button) findViewById(R.id.boyutazalt);
        mBoyutazalt.setOnClickListener(this);
        mBoyutarttır = (Button) findViewById(R.id.boyutarttır);
        mBoyutarttır.setOnClickListener(this);
        mSest = (ToggleImageButton) findViewById(R.id.sest);
        mSest.setOnClickListener(this);
        mDilt = (ToggleImageButton) findViewById(R.id.dilt);
        mDilt.setOnClickListener(this);
        mHadist = (ToggleImageButton) findViewById(R.id.hadist);
        mHadist.setOnClickListener(this);
        mEsmat = (ToggleImageButton) findViewById(R.id.esmat);
        mEsmat.setOnClickListener(this);
        mKıssat = (ToggleImageButton) findViewById(R.id.kıssat);
        mKıssat.setOnClickListener(this);
        mYazıboyutu = (TextView) findViewById(R.id.yazıboyutu);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boyutazalt:
                clicksesi();
                yazımınboyutu = Integer.parseInt(mYazıboyutu.getText().toString());
                mYazıboyutu.setText(String.valueOf(yazımınboyutu - 1));

                if (mYazıboyutu.getText().toString().equals("13")){
                    mYazıboyutu.setText("14");
                    Toasty.error(getApplicationContext(),"Yazı boyutu 14'den küçük 27'den büyük olamaz", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.boyutarttır:
                clicksesi();

                yazımınboyutu = Integer.parseInt(mYazıboyutu.getText().toString());
                mYazıboyutu.setText(String.valueOf(yazımınboyutu + 1));

                if (mYazıboyutu.getText().toString().equals("28")){
                    mYazıboyutu.setText("27");
                    Toasty.error(getApplicationContext(),"Yazı boyutu 14'den küçük 27'den büyük olamaz", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.sest:// TODO 19/08/07
                Toogle(mSest);
                break;
            case R.id.dilt:// TODO 19/08/07
                Toogle(mDilt);
                break;
            case R.id.hadist:// TODO 19/08/07
                Toogle(mHadist);
                break;
            case R.id.esmat:// TODO 19/08/07
                Toogle(mEsmat);
                break;
            case R.id.kıssat:// TODO 19/08/07
                Toogle(mKıssat);
                break;
            default:
                break;
        }
    }


    @Override
    protected void onResume() {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        Boolean dildurum = mPrefs.getBoolean("SettingDil", true);
        Boolean hadisdurum = mPrefs.getBoolean("SettingHadis", false);
        Boolean esmadurum = mPrefs.getBoolean("SettingEsma", false);
        Boolean kıssadurum = mPrefs.getBoolean("SettingKıssa", false);
        Boolean sesdurum = mPrefs.getBoolean("SettingSes", false);
        String yazıboyutu = mPrefs.getString("SettingYazıboyutu", "21");


        mSest.setChecked(sesdurum);
        mDilt.setChecked(dildurum);
        mHadist.setChecked(hadisdurum);
        mEsmat.setChecked(esmadurum);
        mKıssat.setChecked(kıssadurum);
        mYazıboyutu.setText(yazıboyutu);
        super.onResume();


    }


    @Override
    protected void onPause() {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putBoolean("SettingSes",mSest.isChecked());
        editorum.putBoolean("SettingDil",mDilt.isChecked());
        editorum.putBoolean("SettingHadis",mHadist.isChecked());
        editorum.putBoolean("SettingEsma",mEsmat.isChecked());
        editorum.putBoolean("SettingKıssa",mKıssat.isChecked());
        editorum.putString("SettingYazıboyutu",mYazıboyutu.getText().toString());
        editorum.commit();

        Toasty.success(getApplicationContext(),"Ayarlar kaydedildi..",Toast.LENGTH_LONG).show();
        super.onPause();
    }

}
