package soft.bigeran.dervis.SanalKütüphane;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import soft.bigeran.dervis.R;

public class Admin extends AppCompatActivity implements View.OnClickListener {


    DatabaseReference database;


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private TextView mRefKitaplar;
    private EditText mKitapurl;
    private EditText mYazaradı;
    private EditText mYazarkatogori;
    private CheckBox mİdTrending;
    private Button mYayınla;
    private EditText mKitapadı;
    private EditText mKitapphotourl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanalk_admin);
        initView();


        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Sanalkütüphane/kitaplar");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long size = dataSnapshot.getChildrenCount();
                mRefKitaplar.setText(String.valueOf(size));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        database = FirebaseDatabase.getInstance().getReference().child("Sanalkütüphane/kitaplar");


    }

    private void initView() {
        mRefKitaplar = (TextView) findViewById(R.id.refKitap);
        mKitapurl = (EditText) findViewById(R.id.kitapurl);
        mYazarkatogori = (EditText) findViewById(R.id.yazarkatogori);
        mİdTrending = (CheckBox) findViewById(R.id.trending_id);
        mYayınla = (Button) findViewById(R.id.yayınla);
        mYayınla.setOnClickListener(this);
        mKitapadı = (EditText) findViewById(R.id.kitapadı);
        mYazaradı = (EditText) findViewById(R.id.yazaradı);
        mKitapphotourl = (EditText) findViewById(R.id.kitapphotourl);
    }


    public void startposting() {
        final String saveTitle = mKitapurl.getText().toString().trim();
        //final String saveSinger = singer.getText().toString().toLowerCase().trim();

        if (!saveTitle.equals("")) {

            Toast.makeText(getApplicationContext(), "Yayınlandı", Toast.LENGTH_SHORT).show();


            DatabaseReference new_post = database.push();

            String isa = mKitapurl.getText().toString();

            String startChar2 = "file/d/";
            String endChar2 = "/view?";
            String id = getStringBetweenTwoChars(isa, startChar2, endChar2);
            String Playbaş = "https://drive.google.com/";
            String orta = "uc?export=download&id=";
            String son = id;

            String link = Playbaş + orta + son;


            int kitapno = 1000000 - Integer.valueOf(mRefKitaplar.getText().toString());

            new_post.child("kitapadı").setValue(mKitapadı.getText().toString());
            new_post.child("kitapsıra").setValue(kitapno);
            new_post.child("kitapurl").setValue(link);
            new_post.child("kitapurl").setValue(mKitapphotourl.getText().toString());
            new_post.child("yazaradı").setValue(mYazaradı.getText().toString());
            new_post.child("yazarid").setValue(mYazarkatogori.getText().toString());

            if (mİdTrending.isChecked()) {
                new_post.child("trending").setValue("1");
            } else {
                new_post.child("trending").setValue("0");


            }

        } else {

            Toast.makeText(getApplicationContext(), "Hata", Toast.LENGTH_SHORT).show();


        }


        mKitapurl.setText("");
        // mYazaradı.setText("");
        //mYazarkatogori.setText("");
    }


    public String getStringBetweenTwoChars(String input, String startChar, String endChar) {
        try {
            int start = input.indexOf(startChar);
            if (start != -1) {
                int end = input.indexOf(endChar, start + startChar.length());
                if (end != -1) {
                    return input.substring(start + startChar.length(), end);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input; // return null; || return "" ;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.yayınla:// TODO 19/12/10
                startposting();

                break;
            default:
                break;
        }
    }
}
