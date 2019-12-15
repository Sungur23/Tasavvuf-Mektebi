package soft.bigeran.dervis.Deneme;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class Download extends AppCompatActivity implements View.OnClickListener {

    private static String Yandex = "https://firebasestorage.googleapis.com/v0/b/tasavvuf-mektebi-d4ad1.appspot.com/o/Ferid%C3%BCddin%20Attar%20-%20Esrarname.pdf?alt=media&token=a54ea423-0387-443f-8b84-7c770d62cbb8";
    private static String kitapadı = "isa";
    private ImageView mKitapphoto;
    private ImageView mPaylaş;
    private TextView mKitapbilgi;

    private String Kitapurl;
    private String Kitapphotourl;
    private String Kitapbilgi;
    private String Kaynak;


    private FirebaseDatabase db;
    private DatabaseReference Kitapveriphotourl, Kitapveribilgi, KitapveriUrl, Kitapveriadı;
    private String kitap;
    private String Liste;
    private String Tür;
    private TextView mKitapadı;
    private TextView mKitapurl;
    private Button mİndir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        initView();


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            // referansa ulaşıp ilgili sohbetleri getirebilmemiz için gerekli yapı
            Kitapbilgi = bundle.getString("kitapbilgi");
            Kaynak = bundle.getString("kitapkaynak");
            Tür = bundle.getString("Tür");
            mKitapbilgi.setText(Kaynak + "/" + Kitapbilgi);

        }

        Kitapveriphotourl = db.getInstance().getReference(Kaynak + "/" + Kitapbilgi + "/kitapphotourl");
        Kitapveribilgi = db.getInstance().getReference(Kaynak + "/" + Kitapbilgi + "/kitapbilgi");
        KitapveriUrl = db.getInstance().getReference(Kaynak + "/" + Kitapbilgi + "/kitapurl");
        Kitapveriadı = db.getInstance().getReference(Kaynak + "/" + Kitapbilgi + "/kitapadı");

        //Glide.with(this).load("http://goo.gl/gEgYUd").into(mKitapphoto);


        Kitapveriphotourl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.5
                String valueimage = dataSnapshot.getValue(String.class);

                Picasso.get()
                        .load(valueimage)
                        .into(mKitapphoto);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });


        Kitapveribilgi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mKitapbilgi.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mKitapbilgi.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });

        Kitapveriadı.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mKitapadı.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mKitapadı.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });


        KitapveriUrl.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mKitapurl.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mKitapurl.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
            }
        });

    }

    private void initView() {
        mKitapphoto = (ImageView) findViewById(R.id.kitapphoto);
        mPaylaş = (ImageView) findViewById(R.id.paylaş);
        mPaylaş.setOnClickListener(this);

        mKitapbilgi = (TextView) findViewById(R.id.kitapbilgi);
        mKitapadı = (TextView) findViewById(R.id.kitapadı);
        mKitapurl = (TextView) findViewById(R.id.kitapurl);
        mİndir = (Button) findViewById(R.id.indir);
        mİndir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paylaş:
                // TODO 19/10/25

                break;

            case R.id.indir:
                new DownloadFile2().execute(mKitapurl.getText().toString(), mKitapadı.getText().toString()+".pdf");
                // TODO 19/10/25
                break;
            default:
                break;
        }
    }


    private class DownloadFile2 extends AsyncTask<String, Void, Void> {

        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {

            //setContentView(R.layout.kitap_tur);
            this.progressDialog = new ProgressDialog(Download.this);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            this.progressDialog.setCancelable(true);
            this.progressDialog.show();
            this.progressDialog.setMessage("Devam eden işleminiz bulunmaktadır. Lütfen bekleyiniz..");

            String extStorageDirectory = Environment.getExternalStorageDirectory().toString() + "/Tasavvuf Mektebi";
            File folder2 = new File(extStorageDirectory);
            boolean success = true;
            if (!folder2.exists()) {
                success = folder2.mkdirs();
            }
            if (success) {


            } else {
                folder2.mkdirs();
            }
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(String... strings) {
            String fileUrl = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String fileName = strings[1];  // -> maven.pdf
            String extStorageDirectory = Environment.getExternalStorageDirectory().toString() + "/Tasavvuf Mektebi";
            File folder = new File(extStorageDirectory, Tür);
            File pdfFile = new File(folder, fileName);
            folder.mkdirs();
            try {
                pdfFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {

            this.progressDialog.dismiss();

            Toasty.warning(getApplicationContext(), "Kitap indi..", Toast.LENGTH_LONG).show();

            super.onPostExecute(aVoid);
        }

    }

}
