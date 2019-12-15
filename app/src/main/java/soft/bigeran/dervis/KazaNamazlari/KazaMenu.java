package soft.bigeran.dervis.KazaNamazlari;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import soft.bigeran.dervis.R;

public class KazaMenu extends AppCompatActivity implements View.OnClickListener {

    private Button mHesaplayıcı;
    private Button mKazanamazları;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaza_menu);
        initView();

    }

    private void initView() {
        mHesaplayıcı = (Button) findViewById(R.id.hesaplayıcı);
        mHesaplayıcı.setOnClickListener(this);
        mKazanamazları = (Button) findViewById(R.id.kazanamazları);
        mKazanamazları.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.hesaplayıcı:
                startActivity(new Intent(KazaMenu.this, KazaHesaplayici.class));
                Animatoo.animateFade(KazaMenu.this);
                break;
            case R.id.kazanamazları:
                startActivity(new Intent(KazaMenu.this, KazaNamazlari.class));
                Animatoo.animateFade(KazaMenu.this);
                break;
            default:
                break;
        }
    }
}




