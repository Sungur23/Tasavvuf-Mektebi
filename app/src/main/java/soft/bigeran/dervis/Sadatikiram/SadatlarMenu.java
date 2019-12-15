package soft.bigeran.dervis.Sadatikiram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import soft.bigeran.dervis.R;

public class SadatlarMenu extends AppCompatActivity implements View.OnClickListener {

    private Button mBuhara;
    private Button mMenzil;
    private Button mKonya;
    private Button mHaznevi;
    private Button mYahyalı;
    private Button mMahmut;
    private Button mSüleyman;
    private Button mKıbrisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sadatlar_menu);
        initView();


    }

    private void initView() {
        mBuhara = (Button) findViewById(R.id.buhara);
        mBuhara.setOnClickListener(this);
        mMenzil = (Button) findViewById(R.id.menzil);
        mMenzil.setOnClickListener(this);
        mKonya = (Button) findViewById(R.id.konya);
        mKonya.setOnClickListener(this);
        mHaznevi = (Button) findViewById(R.id.haznevi);
        mHaznevi.setOnClickListener(this);
        mYahyalı = (Button) findViewById(R.id.yahyalı);
        mYahyalı.setOnClickListener(this);
        mMahmut = (Button) findViewById(R.id.mahmut);
        mMahmut.setOnClickListener(this);
        mSüleyman = (Button) findViewById(R.id.süleyman);
        mSüleyman.setOnClickListener(this);
        mKıbrisi = (Button) findViewById(R.id.kıbrisi);
        mKıbrisi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buhara:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.menzil:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe2.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.konya:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe3.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.haznevi:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe4.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.yahyalı:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe7.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.mahmut:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe5.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.süleyman:
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe6.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            case R.id.kıbrisi:// TODO 19/09/09
                startActivity(new Intent(SadatlarMenu.this, SadatlarListe8.class));
                Animatoo.animateFade(SadatlarMenu.this);
                break;
            default:
                break;
        }
    }
}
