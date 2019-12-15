package soft.bigeran.dervis.Splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import soft.bigeran.dervis.R;

public class Giris extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giris);

        startActivity(new Intent(Giris.this, Splash.class));
        Animatoo.animateFade(Giris.this);
        finish();
    }




    @Override
    protected void onPause() {

        super.onPause();
    }


    @Override
    protected void onResume()
    {


        startActivity(new Intent(Giris.this, Splash.class));
        Animatoo.animateFade(Giris.this);
        finish();

        super.onResume();

    }


}


