package soft.bigeran.dervis.Duyuru;

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

public class DuyuruMenu extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> subjectLists = new ArrayList<>();
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duyuru_menu);


        listView = (ListView)findViewById(R.id.listViewSubjects);

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Duyurularyeni");
        adapter = new ArrayAdapter<String>(DuyuruMenu.this, R.layout.duyuru_item, R.id.kitaplarım , subjectLists);
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
                Intent intent = new Intent(DuyuruMenu.this, Duyurular.class);
                intent.putExtra("Duyurusıra", subjectLists.get(position));
                startActivity(intent);
            }
        });
    }
}