package soft.bigeran.dervis.EvliyalarAnksiklopedisi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.io.InputStream;

import soft.bigeran.dervis.R;

public class EvliyalarGosterim extends AppCompatActivity implements View.OnClickListener {

    private TextView Yazı;
    private TextView mTextView6;
    private Button mButton2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evliyalar_gosterim);
        initView();


        Yazı = (TextView) findViewById(R.id.yazı);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("Evliya");
        String isim = extras.getString("Evliyaname");
        mTextView6.setText(isim);


        String text = "";
        try {

            InputStream inputStream = getAssets().open(value);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }


        Yazı.setText(text);


    }

    private void initView() {
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                String s = mTextView6.getText().toString();
                String a = "\n"+"\n"+Yazı.getText().toString()+"\n"+"\n"+"Tasavvuf Mektebi";
                String paylas=s+a;
                myIntent.setType("text/plain");
                String shareBody = "Evliya Hayatları";
                myIntent.putExtra(Intent.EXTRA_SUBJECT, shareBody);
                myIntent.putExtra(Intent.EXTRA_TEXT, paylas);
                startActivity(Intent.createChooser(myIntent, "Şunu kullanarak paylaş"));
                break;
            default:
                break;
        }
    }
}
