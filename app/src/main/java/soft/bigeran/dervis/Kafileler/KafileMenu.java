package soft.bigeran.dervis.Kafileler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import soft.bigeran.dervis.R;

public class KafileMenu extends AppCompatActivity implements View.OnClickListener {

    private Button mKafileler;
    private Button mKafileniyayınla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafile_menu);
        initView();
    }

    private void initView() {
        mKafileler = (Button) findViewById(R.id.Kafileler);
        mKafileler.setOnClickListener(this);
        mKafileniyayınla = (Button) findViewById(R.id.Kafileniyayınla);
        mKafileniyayınla.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Kafileler:
                YoYo.with(Techniques.Tada)
                        .duration(200)
                        .repeat(2)
                        .playOn(findViewById(R.id.Kafileler));

                startActivity(new Intent(KafileMenu.this, Kafile_Liste.class));
                Animatoo.animateFade(KafileMenu.this);
                // TODO 19/12/07
                break;
            case R.id.Kafileniyayınla:
                YoYo.with(Techniques.Tada)
                        .duration(200)
                        .repeat(2)
                        .playOn(findViewById(R.id.Kafileniyayınla));

                startActivity(new Intent(KafileMenu.this, Kafile_Yayinla.class));
                Animatoo.animateFade(KafileMenu.this);
                // TODO 19/12/07
                break;
            default:
                break;
        }
    }


}
