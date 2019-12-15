package soft.bigeran.dervis.Sohbetler.SohbetMenü;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import soft.bigeran.dervis.R;

public class SohbetMenu extends AppCompatActivity {
    private Button Sohbetler, Diğer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sohbet_menu);
      

        Sohbetler = (Button) findViewById(R.id.hesaplayıcı);
        Diğer = (Button) findViewById(R.id.Diğer);


        Sohbetler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SohbetMenu.this, soft.bigeran.dervis.Sohbetler.Sohbetler.class));
                Animatoo.animateFade(SohbetMenu.this);


            }
        });

        Diğer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SohbetMenu.this, soft.bigeran.dervis.Sohbetler.RisaleSohbet.class));
                Animatoo.animateFade(SohbetMenu.this);


            }
        });
    }
}