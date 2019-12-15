package soft.bigeran.dervis.Deneme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.thebrownarrow.customfont.CustomFontTextView;

import java.io.File;
import java.util.ArrayList;

import soft.bigeran.dervis.R;

public class Folder extends AppCompatActivity {

    private ListView mKlasörlistesi;

    ArrayList<String> Klasörler = new ArrayList<>();
    private ImageView mHata;
    private CustomFontTextView mHatatext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder);
        initView();

        File dir = new File(Environment.getExternalStorageDirectory() + "/Tasavvuf Mektebi");
        if (dir.exists() && dir.isDirectory()) {
            // do something here
            KlasörGöster();
            mHata.setVisibility(View.GONE);
            mHatatext.setVisibility(View.GONE);



        } else {
            mHata.setVisibility(View.VISIBLE);
            mKlasörlistesi.setVisibility(View.GONE);
            mHatatext.setVisibility(View.VISIBLE);

        }


        mKlasörlistesi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = mKlasörlistesi.getItemAtPosition(position);
                String str = (String) o; //As you are using Default String Adapter
                Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
                Klasör(str);

            }
        });
    }

    private void initView() {
        mKlasörlistesi = (ListView) findViewById(R.id.klasörlistesi);

        mHata = (ImageView) findViewById(R.id.hata);
        mHatatext = (CustomFontTextView) findViewById(R.id.hatatext);
    }

    private void Klasör(String Ad) {
        Intent i = new Intent(getApplicationContext(), DownedBook.class);
        i.putExtra("Klasöradı", Ad);
        startActivity(i);
    }

    public void KlasörGöster() {
        File dataDirectory = Environment.getExternalStorageDirectory();
        File fileDir = new File(dataDirectory, "Tasavvuf Mektebi");
        File[] file = fileDir.listFiles();
        for (int i = 0; i < file.length; i++) {
            Klasörler.add(file[i].getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.klasoritem, R.id.klasörlerim, Klasörler);
        mKlasörlistesi.setAdapter(adapter);

    }


}
