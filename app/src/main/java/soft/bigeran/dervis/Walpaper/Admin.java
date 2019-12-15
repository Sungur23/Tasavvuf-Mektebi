package soft.bigeran.dervis.Walpaper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

import soft.bigeran.dervis.R;

public class Admin extends AppCompatActivity implements View.OnClickListener {

    Button video, thumnail, submit;
    CheckBox trendng;
    String category_name = null;
    EditText title, singer;
    public static final int GALLERY_REQUEST = 1;
    public static final int GALLERY_THUMB = 2;
    Uri video_uri = null;

    StorageReference mStorageRef;
    ProgressDialog progressDialog;
    private Spinner spinner1;
    DatabaseReference database;
    String fileName;


    private FirebaseDatabase db;
    private DatabaseReference dbRef;
    private TextView mRefWallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        initView();

        thumnail = (Button) findViewById(R.id.thumb_id);
        submit = (Button) findViewById(R.id.submit_id);
        title = (EditText) findViewById(R.id.title_id);
        singer = (EditText) findViewById(R.id.singer_id);
        trendng = (CheckBox) findViewById(R.id.trending_id);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setPrompt("Category");
        List<String> list = new ArrayList<String>();
        list.add("Genel Dini");
        list.add("Tasavvuf");
        list.add("Buhara Köyü");
        list.add("Diğer");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(dataAdapter);


        db = FirebaseDatabase.getInstance();
        dbRef = db.getReference("wallpapers");

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                long size = dataSnapshot.getChildrenCount();
                mRefWallpaper.setText(String.valueOf(size));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mStorageRef = FirebaseStorage.getInstance().getReference();
        database = FirebaseDatabase.getInstance().getReference().child("wallpapers");




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startposting();
            }
        });


    }

    private void initView() {
        mRefWallpaper = (TextView) findViewById(R.id.refWallpaper);
    }



    public void startposting() {
        final String saveTitle = title.getText().toString().trim();
        final String saveSinger = singer.getText().toString().toLowerCase().trim();

        if (!saveTitle.equals("")) {

            Toast.makeText(getApplicationContext(), "Yayınlandı", Toast.LENGTH_SHORT).show();


            category_name = (String) spinner1.getSelectedItem();
            String trimedcategory = category_name.toLowerCase().trim();

            DatabaseReference new_post = database.push();

            String isa = title.getText().toString();

            String startChar2 = "file/d/";
            String endChar2 = "/view?";
            String id = getStringBetweenTwoChars(isa, startChar2, endChar2);
            String Playbaş = "https://drive.google.com/";
            String orta = "uc?export=download&id=";
            String son = id;

            String link = Playbaş + orta + son;


            int wallpaperno = 1000000 - Integer.valueOf(mRefWallpaper.getText().toString());

            new_post.child("title").setValue("tasavvufmektebi"+wallpaperno);
            new_post.child("wallpapersıra").setValue(wallpaperno);
            new_post.child("video").setValue(link);
            new_post.child("category").setValue(trimedcategory);

            if (trendng.isChecked()) {
                new_post.child("trending").setValue("1");
            } else {
                new_post.child("trending").setValue("0");


            }

        } else {

            Toast.makeText(getApplicationContext(), "FAIL", Toast.LENGTH_SHORT).show();


        }


        title.setText("");
    }


    public String getStringBetweenTwoChars(String input, String startChar, String endChar) {
        try {
            int start = input.indexOf(startChar);
            if (start != -1) {
                int end = input.indexOf(endChar, start + startChar.length());
                if (end != -1) {
                    return input.substring(start + startChar.length(), end);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input; // return null; || return "" ;
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.thumb_id:
                // TODO 19/12/08
                break;
            case R.id.submit_id:
                // TODO 19/12/08
                break;
            default:
                break;
        }
    }
}
