package soft.bigeran.dervis.Duyuru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import soft.bigeran.dervis.R;

public class Duyurular extends AppCompatActivity {

    private TextView Duyurutext;
    private ImageView Duyuruimage;
    String duyuruadı;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.duyurular);

        Duyuruimage = (ImageView) findViewById(R.id.imageduyuru);
        Duyurutext = (TextView) findViewById(R.id.textduyuru);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            duyuruadı = bundle.getString("Duyurusıra");
        }

        String urlimage="image";
        String text="text";

        final DatabaseReference ddRefimageUrl = FirebaseDatabase.getInstance().getReference().child("Duyurularyeni").child(duyuruadı).child(urlimage).child("imageUrl");
        final DatabaseReference ddRefYazı = FirebaseDatabase.getInstance().getReference().child("Duyurularyeni").child(duyuruadı).child(text).child("Yazı");



        ddRefYazı.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Duyurutext.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Duyurutext.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });




        ddRefimageUrl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.5
                String valueimage = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(valueimage)
                        .into(Duyuruimage);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });




    }
}
