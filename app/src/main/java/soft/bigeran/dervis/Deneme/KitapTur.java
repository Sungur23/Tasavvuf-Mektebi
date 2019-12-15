package soft.bigeran.dervis.Deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import soft.bigeran.dervis.R;

public class KitapTur extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    public String Tür;
    private String Kitaplar;
    private ListView listView;



    private ArrayList<String> subjectLists = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitap_tur);


        listView = (ListView)findViewById(R.id.listViewSubjects);
        db = FirebaseDatabase.getInstance();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            // referansa ulaşıp ilgili sohbetleri getirebilmemiz için gerekli yapı
            Tür = bundle.getString("Dil");
            Kitaplar = bundle.getString("Kitaplar");
            dbRef = db.getReference(Kitaplar+"/"+Tür);
            setTitle(Tür);
        }


        adapter = new ArrayAdapter<String>(KitapTur.this, R.layout.klasoritem, R.id.klasörlerim, subjectLists);
        listView.setAdapter(adapter);

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                subjectLists.clear();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    subjectLists.add(ds.getKey());
                    Log.d("LOGVALUE", ds.getKey());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(KitapTur.this, KitaplarListe.class);
                intent.putExtra("Tür", subjectLists.get(position));
                intent.putExtra("Listetür", subjectLists.get(position));
                intent.putExtra("Liste",Kitaplar+"/"+Tür);
                startActivity(intent);
            }
        });
    }
}