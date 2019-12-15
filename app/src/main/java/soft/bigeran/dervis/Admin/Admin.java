package soft.bigeran.dervis.Admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.AnaEkran.MainActivity;
import soft.bigeran.dervis.R;

public class Admin extends AppCompatActivity implements View.OnClickListener {
    private EditText imageUrl, DuyuruSıra, Yazı, Youtubeurl, Şifre;
    private Button Yayınla, Giriş;
    private LinearLayout Şifregirişekranı;

    private ScrollView AdminEkranı;
    private EditText mGörünürlükfire;
    private Button mWallpapers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
        initView();

        imageUrl = (EditText) findViewById(R.id.imageurl);
        Yazı = (EditText) findViewById(R.id.yazıfire);
        Şifre = (EditText) findViewById(R.id.şifre);
        Yayınla = (Button) findViewById(R.id.yayınla);
        Giriş = (Button) findViewById(R.id.giriş);
        Şifregirişekranı = (LinearLayout) findViewById(R.id.pas);
        AdminEkranı = (ScrollView) findViewById(R.id.scroll);


        Giriş.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Şifre.getText().toString().equals("472963")) {
                    AdminEkranı.setVisibility(View.VISIBLE);
                    Şifregirişekranı.setVisibility(View.GONE);


                } else {

                    Toasty.error(getApplicationContext(), "Yetkiniz yok", Toast.LENGTH_LONG).show();
                }


            }

        });


        String urlimage = "image";
        String text = "text";
        String Görünürlük = "Görünürlük";

        final DatabaseReference ddRefGörünürlük = FirebaseDatabase.getInstance().getReference().child("Duyurular").child(Görünürlük).child("Chatdurum");
        final DatabaseReference ddRefimageUrl = FirebaseDatabase.getInstance().getReference().child("Duyurular").child(urlimage).child("imageUrl");
        final DatabaseReference ddRefYazı = FirebaseDatabase.getInstance().getReference().child("Duyurular").child(text).child("Yazı");


        ddRefYazı.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Yazı.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        ddRefimageUrl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.5
                String valueimage = dataSnapshot.getValue(String.class);
                imageUrl.setText(valueimage);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        Yayınla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Admin.this);
                builder.setTitle("Tasavvuf Mektebi");
                builder.setIcon(R.drawable.mha);
                builder.setMessage("Duyuru yayınlamak istiyor musun?");
                builder.setNegativeButton("Hayır", null);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        ddRefimageUrl.setValue(imageUrl.getText().toString());
                        ddRefYazı.setValue(Yazı.getText().toString());
                        ddRefGörünürlük.setValue(mGörünürlükfire.getText().toString());


                        Toast.makeText(getBaseContext(),
                                "Yayınlandı...",
                                Toast.LENGTH_LONG).show();

                        startActivity(new Intent(Admin.this, MainActivity.class));
                        Animatoo.animateZoom(Admin.this);


                    }
                });
                builder.show();


            }

        });


    }

    private void initView() {
        mGörünürlükfire = (EditText) findViewById(R.id.görünürlükfire);
        mWallpapers = (Button) findViewById(R.id.wallpapers);
        mWallpapers.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.giriş:
                // TODO 19/12/08
                break;
            case R.id.yayınla:
                // TODO 19/12/08
                break;
            case R.id.wallpapers:

                Intent intent = new Intent(Admin.this, soft.bigeran.dervis.Walpaper.Admin.class);

                startActivity(intent);
                // TODO 19/12/08
                break;
            default:
                break;
        }
    }
}
