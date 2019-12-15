package soft.bigeran.dervis.GecisEkrani;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

import soft.bigeran.dervis.Admin.BlurBuilder;

import soft.bigeran.dervis.AnaEkran.MainActivity;
import soft.bigeran.dervis.R;


public class EsmaEkrani extends AppCompatActivity {

    private Button Devamet2;
    private TextView Esmayazı;
    private TextView Esmasayı;
    private ImageView EsmaGörüntüsü;
    private LinearLayout EsmaEkranı;
    private FloatingActionButton Paylaş;
    private RelativeLayout mContainerView;


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
        setContentView(R.layout.esma_ekrani);


        mContainerView = (RelativeLayout) findViewById(R.id.esmalayout);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aplan00014);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        mContainerView.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        EsmaGörüntüsü = findViewById(R.id.esmagörüntü);
        Devamet2 = findViewById(R.id.devametb);
        Esmayazı = findViewById(R.id.esmatext);
        EsmaEkranı = findViewById(R.id.Esmaekranı);
        Paylaş = (FloatingActionButton) findViewById(R.id.fab22);

        String yazi = "e";
        int sayi;
        Random r = new Random();
        sayi = 1+r.nextInt(116);
        String yazi2 = yazi + String.valueOf(sayi);
        String Yazıgöster = getString(getResources().getIdentifier(yazi2, "string", getPackageName()));

        int resourceId = getResources().getIdentifier(yazi2, "drawable", getPackageName());
        EsmaGörüntüsü.setBackgroundResource(resourceId);
        Esmayazı.setText(Yazıgöster);
        Devamet2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.selektor));

        Paylaş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                String s = Esmayazı.getText().toString();
                String a = "\n"+"\n"+"\n"+"Tasavvuf Mektebi";
                String paylas=s+a;
                myIntent.setType("text/plain");
                String shareBody = "⭐⭐⭐";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, paylas);
                startActivity(Intent.createChooser(myIntent, "Share using"));
                Snackbar.make(view,R.string.Paylaş, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        Devamet2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(EsmaEkrani.this, MainActivity.class));
                Animatoo.animateFade(EsmaEkrani.this);
                finish();
            }
        });
    }

}
