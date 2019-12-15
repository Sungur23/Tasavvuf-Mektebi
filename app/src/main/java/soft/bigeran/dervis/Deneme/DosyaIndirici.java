package soft.bigeran.dervis.Deneme;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.kishan.askpermission.AskPermission;
import com.kishan.askpermission.ErrorCallback;
import com.kishan.askpermission.PermissionCallback;
import com.kishan.askpermission.PermissionInterface;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Sureler.SurelerGosterim;

public class DosyaIndirici extends AppCompatActivity implements View.OnClickListener, PermissionCallback, ErrorCallback {


    private ImageView mKitapphoto;
    private ImageView mPaylaş;
    private TextView mKitapbilgi;


    private String Kitapbilgi;
    private String Kaynak;


    private FirebaseDatabase db;
    private DatabaseReference Kitapveriphotourl, Kitapveribilgi, KitapveriUrl, Kitapveriadı, Kitaptürü;
    private String kitap;
    private String Liste;
    private String Tür;
    private TextView mKitapadı;
    private TextView mKitapurl;
    private Button mİndir;
    private TextView mKitaptürü;
    private static final String TAG = "DemoActivity";
    private static final int REQUEST_PERMISSIONS = 20;

    KProgressHUD hud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosya_indirici);
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
        Kitaptürü = db.getInstance().getReference(Kaynak + "/" + Kitapbilgi + "/kitaptürü");

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


        Kitaptürü.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mKitaptürü.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                mKitaptürü.setText("İnternetiniz kapalı veya duyuru bilgisi bulunamadı");
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
        mKitaptürü = (TextView) findViewById(R.id.kitaptürü);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.paylaş:
                // TODO 19/10/25
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tasavvuf Mektebi");
                    String shareMessage = "\n Tasavvuf Mektebi uygulamasında şu kitabı buldum sende oku bence..\n\n";
                    shareMessage = shareMessage + mKitapurl.getText().toString() + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Seçiniz"));
                } catch (Exception e) {
                    //e.toString();
                }

                break;

            case R.id.indir:
                reqPermission();
                // TODO 19/10/25
                break;
            default:
                break;
        }
    }

    private void reqPermission() {
        new AskPermission.Builder(this).setPermissions(Manifest.permission.INTERNET,Manifest.permission.VIBRATE,Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .setCallback(this)
                .setErrorCallback(this)
                .request(REQUEST_PERMISSIONS);
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        new DownloadFile().execute(mKitapurl.getText().toString(),mKitaptürü.getText().toString());
        Toast.makeText(this, "Dosya indirilebilir, izin verildi", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode) {
        Toast.makeText(this, "Lütfen izin veriniz.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onShowRationalDialog(final PermissionInterface permissionInterface, int requestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Şu uygulama için izinlere ihtiyaç var.");
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                permissionInterface.onDialogShown();
            }
        });
        builder.setNegativeButton("Hayır", null);
        builder.show();
    }

    @Override
    public void onShowSettings(final PermissionInterface permissionInterface, int requestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("We need permissions for this app. Open setting screen?");
        builder.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                permissionInterface.onSettingsShown();
            }
        });
        builder.setNegativeButton("Hayır", null);
        builder.show();
    }

    private class DownloadFile extends AsyncTask<String, String, String> {
        private String fileName;
        private String folder;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            hud = KProgressHUD.create(DosyaIndirici.this)
                    .setStyle(KProgressHUD.Style.BAR_DETERMINATE)
                    .setDimAmount(0.5f)
                    .setLabel("Lütfen bekleyin")
                    .setDetailsLabel("Dosya İndiriliyor ")
                    .setMaxProgress(100)
                    .show();
        }

        @SuppressLint("WrongThread")
        @Override
        protected String doInBackground(String... strings) {
            String f_url = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String filetype = strings[1];
            int count;
            try {
                URL url = new URL(f_url);
                URLConnection connection = url.openConnection();
                connection.connect();
                // getting file length
                int lengthOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                fileName = mKitapadı.getText().toString() + filetype;

                folder = Environment.getExternalStorageDirectory() + File.separator + "Tasavvuf Mektebi/" + Tür + "/";
                File directory = new File(folder);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Output stream to write file
                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    // Log.d(TAG, "Progress: " + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                return "Dosya şuraya indi : " + folder + fileName;

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "Hata oluştu";
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            hud.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {
            // dismiss the dialog after the file was downloaded
            hud.dismiss();

            // Display File path after downloading
            Toasty.success(getApplicationContext(),
                    message, Toast.LENGTH_LONG).show();
        }
    }


}
