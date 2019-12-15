package soft.bigeran.dervis.Deneme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.thebrownarrow.customfont.CustomFontTextView;

import java.io.File;
import java.util.ArrayList;

import soft.bigeran.dervis.PdfGörüntüleme.PdfGoruntuleme;
import soft.bigeran.dervis.R;

public class DownedBook extends AppCompatActivity {

    private ListView mKitaplistesi;
    private Button mListegöster;
    ArrayList<String> Kitaplar = new ArrayList<>();

    private ImageView mHata;
    private CustomFontTextView mHatatext;
    String Klasöradı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.downed_book);
        initView();


        final Bundle extras = getIntent().getExtras();
        Klasöradı = extras.getString("Klasöradı");


        File dataDirectory = Environment.getExternalStorageDirectory();
        File dir = new File(dataDirectory, "Tasavvuf Mektebi"+"/"+Klasöradı);
        //File dir = new File(Environment.getExternalStorageDirectory() + "/Tasavvuf Mektebi");
        File[] contents = dir.listFiles();

        if (contents.length == 0) {
            mHata.setVisibility(View.VISIBLE);
            mKitaplistesi.setVisibility(View.GONE);
            mHatatext.setVisibility(View.VISIBLE);
        }
        else {

            Kitapgöster();
            mKitaplistesi.setVisibility(View.VISIBLE);
            mHata.setVisibility(View.GONE);
            mHatatext.setVisibility(View.GONE);

        }



        mKitaplistesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = mKitaplistesi.getItemAtPosition(position);
                String Kitapadım = (String) o; //As you are using Default String Adapter
                Toast.makeText(getBaseContext(), Kitapadım, Toast.LENGTH_SHORT).show();

                KitapAc(Kitapadım, "Tasavvuf Mektebi" + "/" + Klasöradı + "/" + Kitapadım);


            }
        });
    }

    private void initView() {
        mKitaplistesi = (ListView) findViewById(R.id.kitaplistesi);

        mHata = (ImageView) findViewById(R.id.hata);
        mHatatext = (CustomFontTextView) findViewById(R.id.hatatext);
    }


    private void KitapAc(String Referansadı, String Klasöryolu) {
        Intent i = new Intent(getApplicationContext(), PdfGoruntuleme.class);
        i.putExtra("Kitapklasöryolu", Klasöryolu);
        i.putExtra("KitapReferans", Referansadı);
        startActivity(i);
    }


    public void Kitapgöster() {
        File dataDirectory = Environment.getExternalStorageDirectory();
        File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/" + Klasöradı);
        File[] file = fileDir.listFiles();
        for (int i = 0; i < file.length; i++) {
            Kitaplar.add(file[i].getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.kitapitem, R.id.kitaplarım, Kitaplar);
        mKitaplistesi.setAdapter(adapter);


    }

}
