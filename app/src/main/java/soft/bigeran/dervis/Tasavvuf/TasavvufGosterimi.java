package soft.bigeran.dervis.Tasavvuf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import soft.bigeran.dervis.R;

public class TasavvufGosterimi extends AppCompatActivity {

    private RelativeLayout Bilgimenü,Gösterim,Katmanı;
    private TextView Yazım,Ref;
    private ScrollView Sc;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasavvuf_gosterimi);


        Gösterim = (RelativeLayout) findViewById(R.id.gösterim);
        Katmanı = (RelativeLayout) findViewById(R.id.bilgikatman);
        Sc = (ScrollView) findViewById(R.id.sc);
        Yazım = (TextView) findViewById(R.id.yaz);
        Ref = (TextView) findViewById(R.id.referans);

        final Bundle extras = getIntent().getExtras();


        if (Ref.getText().toString().equals("Tr")){
            String value = extras.getString("Tasavvuf");
            String value2 = value+".txt";
            String text = "";
            try {

                //InputStream inputStream = getAssets().open("bilgi/ta" + pos + ".txt");
                InputStream inputStream = getAssets().open(value2);
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                text = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Yazım.setText(text);

        }else if (Ref.getText().toString().equals("En")){

            String value = extras.getString("Tasavvuf");
            String value2 = value+".txt";

            String text = "";
            try {

                InputStream inputStream = getAssets().open("En/"+value2);
                int size = inputStream.available();
                byte[] buffer = new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                text = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Yazım.setText(text);
        }
    }
}