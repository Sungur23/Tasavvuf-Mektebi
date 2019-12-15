package soft.bigeran.dervis.SanalKütüphane;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Admin_Yazarlar extends AppCompatActivity implements View.OnClickListener {


    DatabaseReference database;


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private TextView mRefyazar;
    private EditText mYazarphotourl;
    private EditText mYazarınadı;
    private EditText mAktarılacakQuery;
    private Button mYayınla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanalk_admin__yazalar);
        initView();


        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Sanalkütüphane/yazarlar");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long size = dataSnapshot.getChildrenCount();
                mRefyazar.setText(String.valueOf(size));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        database = FirebaseDatabase.getInstance().getReference().child("Sanalkütüphane/yazarlar");


    }

    private void initView() {
        mRefyazar = (TextView) findViewById(R.id.refKitap);
        mYazarphotourl = (EditText) findViewById(R.id.Yazarphotourl);
        mYazarınadı = (EditText) findViewById(R.id.yazarınadı);
        mAktarılacakQuery = (EditText) findViewById(R.id.aktarılacakQuery);
        mYayınla = (Button) findViewById(R.id.yayınla);
        mYayınla.setOnClickListener(this);
    }


    public void startposting() {
        final String saveTitle = mYazarphotourl.getText().toString().trim();
        //final String saveSinger = singer.getText().toString().toLowerCase().trim();

        if (!saveTitle.equals("")) {

            Toast.makeText(getApplicationContext(), "Yayınlandı", Toast.LENGTH_SHORT).show();


            DatabaseReference new_post = database.push();

         

            new_post.child("yazarphotourl").setValue(mYazarphotourl.getText().toString());
            new_post.child("yazaradı").setValue(mYazarınadı.getText().toString());
            new_post.child("aktarılcak").setValue(mAktarılacakQuery.getText().toString());

           
        } else {

            Toast.makeText(getApplicationContext(), "Hata", Toast.LENGTH_SHORT).show();


        }


        mYazarphotourl.setText("");
        // mYazaradı.setText("");
        //mYazarkatogori.setText("");
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
