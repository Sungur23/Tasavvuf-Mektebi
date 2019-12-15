package soft.bigeran.dervis.Kafileler;

import android.animation.Animator;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.RandomSort;

import soft.bigeran.dervis.R;

public class KafileGoster extends AppCompatActivity {

    private TextView mNeredentext;
    private TextView mNereyetext;
    private TextView mTarihtext;
    private TextView mSaattext;
    private TextView mBaybayantext;
    private TextView mÜcrettext;
    private TextView mNumaratext;
    private TextView mNotlartext;
    private FirebaseDatabase db;
    private DatabaseReference dbRef;

    String Path;

    private DatabaseReference Nereden, Nereye, Tarih, Saat, Ücret, Numara, Notlar, BayBayan;
    private ScrollView mScrol;
    private RelativeLayout mMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kafile_goster);
        initView();

        db = FirebaseDatabase.getInstance();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // referansa ulaşıp ilgili sohbetleri getirebilmemiz için gerekli yapı
            Path = bundle.getString("kafileadı");

        }

        Animator spruceAnimator2 = new Spruce
                .SpruceBuilder(mScrol)
                .sortWith(new RandomSort(/*interObjectDelay=*/20L))
                .animateWith(new Animator[]{DefaultAnimations.shrinkAnimator(mScrol, /*duration=*/1000)})
                .start();



        Nereden = db.getInstance().getReference("Kafileler" + "/" + Path + "/nereden");
        Nereye = db.getInstance().getReference("Kafileler" + "/" + Path + "/nereye");
        Tarih = db.getInstance().getReference("Kafileler" + "/" + Path + "/tarih");
        Saat = db.getInstance().getReference("Kafileler" + "/" + Path + "/saat");
        Ücret = db.getInstance().getReference("Kafileler" + "/" + Path + "/ücret");

        Numara = db.getInstance().getReference("Kafileler" + "/" + Path + "/numara");
        Notlar = db.getInstance().getReference("Kafileler" + "/" + Path + "/notlar");
        BayBayan = db.getInstance().getReference("Kafileler" + "/" + Path + "/baybayan");


        Numara.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.5
                String valueimage = dataSnapshot.getValue(String.class);

                mNumaratext.setText(valueimage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mNumaratext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");

            }
        });


        Notlar.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mNotlartext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mNotlartext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });


        BayBayan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mBaybayantext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mBaybayantext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });


        Nereden.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.5
                String valueimage = dataSnapshot.getValue(String.class);
                mNeredentext.setText(valueimage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        Nereye.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mNereyetext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mNereyetext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });

        Saat.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mSaattext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mSaattext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });


        Ücret.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mÜcrettext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mÜcrettext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });

        Tarih.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mTarihtext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mTarihtext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });

    }

    private void initView() {
        mNeredentext = (TextView) findViewById(R.id.neredentext);
        mNereyetext = (TextView) findViewById(R.id.nereyetext);
        mTarihtext = (TextView) findViewById(R.id.tarihtext);
        mSaattext = (TextView) findViewById(R.id.saattext);
        mBaybayantext = (TextView) findViewById(R.id.baybayantext);
        mÜcrettext = (TextView) findViewById(R.id.ücrettext);
        mNumaratext = (TextView) findViewById(R.id.numaratext);
        mNotlartext = (TextView) findViewById(R.id.notlartext);
        mScrol = (ScrollView) findViewById(R.id.scrol);
        mMainActivity = (RelativeLayout) findViewById(R.id.activity_main);
    }
}
