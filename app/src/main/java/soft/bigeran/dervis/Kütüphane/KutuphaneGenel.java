package soft.bigeran.dervis.Kütüphane;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Deneme.Folder;
import soft.bigeran.dervis.Deneme.Kitaplar;
import soft.bigeran.dervis.R;

public class KutuphaneGenel extends AppCompatActivity implements View.OnClickListener {

    private Button mSabit;
    private Button mDegisgen;
    private Button mİnmiş;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kutuphane_genel);
        initView();
    }

    private void initView() {
        mSabit = (Button) findViewById(R.id.Sabit);
        mSabit.setOnClickListener(this);
        mDegisgen = (Button) findViewById(R.id.Degisgen);
        mDegisgen.setOnClickListener(this);
        mİnmiş = (Button) findViewById(R.id.inmiş);
        mİnmiş.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Sabit:
                startActivity(new Intent(KutuphaneGenel.this, KutuphaneMenu.class));
                Animatoo.animateFade(KutuphaneGenel.this);
                // TODO 19/10/28
                break;
            case R.id.Degisgen:
                if (InternetKontrol(true)) {
                    startActivity(new Intent(KutuphaneGenel.this, Kitaplar.class));
                    Animatoo.animateFade(KutuphaneGenel.this);
                }
                break;
            case R.id.inmiş:
                startActivity(new Intent(KutuphaneGenel.this, Folder.class));
                Animatoo.animateFade(KutuphaneGenel.this);
                break;
            default:
                break;
        }
    }


    public boolean InternetKontrol(boolean b) {
        boolean connected = b;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;


        } else {

            Toasty.error(this, "İnternet bağlantısını kontrol ediniz ve tekrar deneyiniz", Toast.LENGTH_LONG).show();
            connected = false;
        }
        return connected;
    }

}
