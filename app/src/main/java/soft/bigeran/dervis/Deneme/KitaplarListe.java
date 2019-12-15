package soft.bigeran.dervis.Deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import soft.bigeran.dervis.Chat.CustomAdapter;
import soft.bigeran.dervis.Chat.Message;
import soft.bigeran.dervis.R;

public class KitaplarListe extends AppCompatActivity {

    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private String kitap;
    private String Liste;
    private String Tür;
    private ListView listView;



    private ArrayList<String> subjectLists = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitaplar_liste);


        listView = (ListView)findViewById(R.id.listViewSubjects);
        db = FirebaseDatabase.getInstance();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            // referansa ulaşıp ilgili sohbetleri getirebilmemiz için gerekli yapı
            kitap = bundle.getString("Listetür");
            Liste = bundle.getString("Liste");
            Tür = bundle.getString("Tür");
            dbRef = db.getReference(Liste+"/"+kitap);
            setTitle(kitap);
        }


        adapter = new ArrayAdapter<String>(KitaplarListe.this, R.layout.kitapitem, R.id.kitaplarım, subjectLists);
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
                Intent intent = new Intent(KitaplarListe.this, DosyaIndirici.class);
                intent.putExtra("kitapbilgi", subjectLists.get(position));
                intent.putExtra("kitapkaynak",Liste+"/"+kitap);
                intent.putExtra("Tür",Tür);
                startActivity(intent);
            }
        });
    }
}