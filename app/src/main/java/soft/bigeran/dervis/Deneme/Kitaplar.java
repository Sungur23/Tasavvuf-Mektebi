package soft.bigeran.dervis.Deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import soft.bigeran.dervis.Chat.ChatActivity;
import soft.bigeran.dervis.Chat.HomeActivity;
import soft.bigeran.dervis.R;

public class Kitaplar extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> subjectLists = new ArrayList<>();
    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitaplar);

        listView = (ListView)findViewById(R.id.listViewSubjects);

        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("Kitaplar");

        adapter = new ArrayAdapter<String>(Kitaplar.this, R.layout.klasorred, R.id.kitaplarım , subjectLists);
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
                Intent intent = new Intent(Kitaplar.this, KitapTur.class);
                intent.putExtra("Dil", subjectLists.get(position));
                intent.putExtra("Kitaplar","Kitaplar");
                startActivity(intent);
            }
        });
    }
}