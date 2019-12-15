package soft.bigeran.dervis.Kafileler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import soft.bigeran.dervis.R;

public class Kafile_Liste extends AppCompatActivity {

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
        setContentView(R.layout.activity_kafile__liste);


        listView = (ListView) findViewById(R.id.listViewSubjects);
        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Kafileler");




        adapter = new ArrayAdapter<String>(Kafile_Liste.this, R.layout.kafile_listitem, R.id.kitaplarım, subjectLists);
        listView.setAdapter(adapter);

        Query query5 = dbRef
                .orderByChild("kafilesırası");


        query5.addValueEventListener(new ValueEventListener() {
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

                Intent intent = new Intent(Kafile_Liste.this, KafileGoster.class);
                intent.putExtra("kafileadı", subjectLists.get(position));
                startActivity(intent);

            }
        });
    }

}