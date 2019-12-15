package soft.bigeran.dervis.HatmeEkrani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import soft.bigeran.dervis.R;

public class HatmeAnaEkrani extends AppCompatActivity implements View.OnClickListener {

    private Button mH1hesap;
    private Button mH1;
    private Button mH2;
    private Button mH3;
    private Button mH3adab;
    private Button mH4;
    private Button mH5;
    private Button mH6;
    private Button mH7;
    private Button mH8;
    private Button mH9;
    private Button mH10;
    private Button mH11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatme_ana_ekrani);
        initView();

    }

    private void initView() {
        mH1hesap = (Button) findViewById(R.id.h1hesap);
        mH1hesap.setOnClickListener(this);
        mH1 = (Button) findViewById(R.id.h1);
        mH1.setOnClickListener(this);
        mH2 = (Button) findViewById(R.id.h2);
        mH2.setOnClickListener(this);
        mH3 = (Button) findViewById(R.id.h3);
        mH3.setOnClickListener(this);
        mH3adab = (Button) findViewById(R.id.h3adab);
        mH3adab.setOnClickListener(this);
        mH4 = (Button) findViewById(R.id.h4);
        mH4.setOnClickListener(this);
        mH5 = (Button) findViewById(R.id.h5);
        mH5.setOnClickListener(this);
        mH6 = (Button) findViewById(R.id.h6);
        mH6.setOnClickListener(this);
        mH7 = (Button) findViewById(R.id.h7);
        mH7.setOnClickListener(this);
        mH8 = (Button) findViewById(R.id.h8);
        mH8.setOnClickListener(this);
        mH9 = (Button) findViewById(R.id.h9);
        mH9.setOnClickListener(this);
        mH10 = (Button) findViewById(R.id.h10);
        mH10.setOnClickListener(this);
        mH11 = (Button) findViewById(R.id.h11);
        mH11.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.h1hesap:
                Intent i = new Intent(HatmeAnaEkrani.this, HatmeTasHesaplayici.class);
                startActivity(i);
                break;
            case R.id.h1:
                Hatme("Hatme1");
                break;
            case R.id.h2:
                Hatme("Hatme2");
                break;
            case R.id.h3:
                Hatme("Hatme3");
                break;
            case R.id.h3adab:
                Hatme("Hatme4");
                break;
            case R.id.h4:
                Hatme("Hatme5");
                break;
            case R.id.h5:
                Hatme("Hatme6");
                break;
            case R.id.h6:
                Hatme("Hatme7");
                break;
            case R.id.h7:
                Hatme("Hatme8");
                break;
            case R.id.h8:
                Hatme("Hatme9");
                break;
            case R.id.h9:
                Hatme("Hatme10");
                break;
            case R.id.h10:
                Hatme("Hatme11");
                break;
            case R.id.h11:
                Hatme("Hatme12");
                break;
            default:
                break;
        }
    }
    private void Hatme(String Hatmeno) {
        Intent i = new Intent(getApplicationContext(), HatmeGosterimi.class);
        i.putExtra("Hatme",Hatmeno);
        startActivity(i);
    }
}
