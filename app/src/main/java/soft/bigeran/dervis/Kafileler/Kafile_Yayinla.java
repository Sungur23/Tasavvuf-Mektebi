package soft.bigeran.dervis.Kafileler;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import soft.bigeran.dervis.R;

public class Kafile_Yayinla extends AppCompatActivity implements View.OnClickListener {

    private EditText mNereden;
    private EditText mNereye;
    private EditText mTarih;
    private EditText mSaat;
    private EditText mÜcret;
    private EditText mNumara;
    private EditText mNotlar;
    private Button mButtonRegister;
    private EditText mBaybayan;
    private DatabaseReference mDatabase;

    int kafileno;
    Integer Kafileno;
    private TextView mReferanskafile;


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private String Pathvideolar;
    private String Liste;
    private String Tür;
    private ListView listView;


    private ArrayList<String> subjectLists = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private TextView mVideotürüref;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafile__yayinla);
        initView();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Kafileler");


        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Kafileler");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long size = dataSnapshot.getChildrenCount();
                mReferanskafile.setText(String.valueOf(size));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }





    private void initView() {
        mNereden = (EditText) findViewById(R.id.Nereden);
        mNereye = (EditText) findViewById(R.id.Nereye);
        mTarih = (EditText) findViewById(R.id.Tarih);
        mSaat = (EditText) findViewById(R.id.Saat);
        mÜcret = (EditText) findViewById(R.id.Ücret);
        mNumara = (EditText) findViewById(R.id.Numara);
        mNotlar = (EditText) findViewById(R.id.Notlar);
        mButtonRegister = (Button) findViewById(R.id.buttonRegister);
        mButtonRegister.setOnClickListener(this);
        mBaybayan = (EditText) findViewById(R.id.Baybayan);


        mReferanskafile = (TextView) findViewById(R.id.referanskafile);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonRegister:
                YoYo.with(Techniques.Tada)
                        .duration(200)
                        .repeat(2)
                        .playOn(findViewById(R.id.buttonRegister));
                AlertDialog.Builder builder = new AlertDialog.Builder(Kafile_Yayinla.this);
                builder.setTitle("Tasavvuf Mektebi");
                builder.setMessage("Kafileyi yayınlamak ister misiniz?");
                builder.setNegativeButton("Hayır", null);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        kafileno = 10000 - Integer.valueOf(mReferanskafile.getText().toString());


                        KafileModel kafileModel = new KafileModel(mNereden.getText().toString(), mNereye.getText().toString(), mTarih.getText().toString(),
                                mSaat.getText().toString(), mÜcret.getText().toString(), mNumara.getText().toString(), mNotlar.getText().toString(), mBaybayan.getText().toString(),
                                kafileno);
                        mDatabase.child("Kafileler").child(mNereden.getText().toString() + "-" + mNereye.getText().toString() ).setValue(kafileModel);
                        // TODO 19/12/07

                        mBaybayan.setText("");
                        mNereden.setText("");
                        mNereye.setText("");
                        mNotlar.setText("");
                        mNumara.setText("");
                        mSaat.setText("");
                        mTarih.setText("");
                        mÜcret.setText("");

                    }
                });
                builder.show();


                break;
            default:
                break;
        }
    }
}
