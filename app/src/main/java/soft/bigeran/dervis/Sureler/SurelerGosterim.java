package soft.bigeran.dervis.Sureler;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.kishan.askpermission.AskPermission;
import com.kishan.askpermission.ErrorCallback;
import com.kishan.askpermission.PermissionCallback;
import com.kishan.askpermission.PermissionInterface;
import com.thebrownarrow.customfont.CustomFontTextView;

import java.io.File;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Deneme.DownloadService;
import soft.bigeran.dervis.R;

import static android.view.View.GONE;

public class SurelerGosterim extends AppCompatActivity implements View.OnClickListener, PermissionCallback, ErrorCallback {



    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    private CustomFontTextView mSureadı;
    private ImageView mSureimaj;
    private TextView mSuretext;

    private ImageButton mGerisar;
    private ImageButton mOynat;
    private ImageButton mDurdur;
    private ImageButton mİlerisardır;
    private Button mSureindir;
    private LinearLayout mİndirlayout;
    private String Sureadı;
    private String folder;

    private static final String TAG = "DemoActivity";
    private static final int REQUEST_PERMISSIONS = 20;

    ProgressDialog mProgressDialog;
    KProgressHUD hud;
    private RelativeLayout mOynatıcılayout;
    private  String Url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sureler_gosterim);
        initView();



        final Bundle extras = getIntent().getExtras();
        int Sureimaj = extras.getInt("Sureimajı");
        int Suretextim = extras.getInt("Suretexti");
        Sureadı = extras.getString("Sureadı");
        String Suremp3 = extras.getString("Suremp3");
        Url= extras.getString("Sureurl");
        mSureimaj.setImageResource(Sureimaj);
        mSuretext.setText(Suretextim);
        mSureadı.setText(Sureadı);

        folder = Environment.getExternalStorageDirectory().toString() +"/Tasavvuf Mektebi Media/" + "Sureler" + "/";

        File directory = new File(folder);

        if (!directory.exists()) {
            directory.mkdirs();
        }


        // String dosya =Sureadı + ".mp3";
        File extStore = Environment.getExternalStorageDirectory();
        File myFile = new File(extStore.getAbsolutePath() + "/Tasavvuf Mektebi Media/Sureler/"+Sureadı+".mp3");

        if(myFile.exists()){
            mOynatıcılayout.setVisibility(View.VISIBLE);
            mİndirlayout.setVisibility(GONE);
            Media();
        }else if (!myFile.exists()) {
            mİndirlayout.setVisibility(View.VISIBLE);
            mOynatıcılayout.setVisibility(GONE);
            Toasty.warning(this,"Sureyi indirip dinleyebilirsin", Toast.LENGTH_LONG).show();

        }





    }


    public void Media() {
        mediaPlayer = MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath()+ "/Tasavvuf Mektebi Media/Sureler/"+Sureadı+".mp3"));
        mediaPlayer.setLooping(false);

    }

    private void initView() {
        mSureadı = (CustomFontTextView) findViewById(R.id.sureadı);
        mSureimaj = (ImageView) findViewById(R.id.sureimaj);
        mSuretext = (TextView) findViewById(R.id.suretext);
        mGerisar = (ImageButton) findViewById(R.id.gerisar);
        mGerisar.setOnClickListener(this);
        mOynat = (ImageButton) findViewById(R.id.oynat);
        mOynat.setOnClickListener(this);
        mDurdur = (ImageButton) findViewById(R.id.durdur);
        mDurdur.setOnClickListener(this);
        mİlerisardır = (ImageButton) findViewById(R.id.ilerisardır);
        mİlerisardır.setOnClickListener(this);
        mSureindir = (Button) findViewById(R.id.sureindir);
        mSureindir.setOnClickListener(this);
        mİndirlayout = (LinearLayout) findViewById(R.id.indirlayout);
        mOynatıcılayout = (RelativeLayout) findViewById(R.id.oynatıcılayout);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gerisar:
                int temp = (int) startTime;

                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toasty.info(getApplicationContext(), "5 sn. geri", Toast.LENGTH_SHORT).show();
                } else {
                    Toasty.error(getApplicationContext(), "Önce oynata basmalısın", Toast.LENGTH_SHORT).show();
                }
                // TODO 19/10/14
                break;
            case R.id.oynat:
                Toasty.success(getApplicationContext(), "Sure Okunuyor", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();



                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();
                mOynat.setVisibility(GONE);
                mDurdur.setVisibility(View.VISIBLE);
                // TODO 19/10/14
                break;
            case R.id.durdur:

                Toasty.warning(getApplicationContext(), "Durduruldu", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause();
                mOynat.setVisibility(View.VISIBLE);
                mDurdur.setVisibility(GONE);
                // TODO 19/10/14
                break;
            case R.id.ilerisardır:
                temp = (int) startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    mediaPlayer.seekTo((int) startTime);
                    Toasty.warning(getApplicationContext(), "5 sn. ileri", Toast.LENGTH_SHORT).show();
                } else {
                    Toasty.error(getApplicationContext(), "Önce oynata basmalısın", Toast.LENGTH_SHORT).show();
                }
                // TODO 19/10/14
                break;
            case R.id.sureindir:// TODO 19/10/28

                //new Dm().execute("https://drive.google.com/uc?export=download&id=1SbJKcTCLCYHKs_JdROtASa3CK0kN-SiP",".mp3",Sureadı);

                if (InternetKontrol(true)){

                    reqPermission();


                }

                break;
            default:
                break;
        }
    }
    private void reqPermission() {
        new AskPermission.Builder(this).setPermissions(Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE)
                .setCallback(this)
                .setErrorCallback(this)
                .request(REQUEST_PERMISSIONS);
    }

    @Override
    public void onPermissionsGranted(int requestCode) {
        Indır();
        Toast.makeText(this, "Permissions Received.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode) {
        Toast.makeText(this, "Permissions Denied.", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onShowRationalDialog(final PermissionInterface permissionInterface, int requestCode) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("We need permissions for this app.");
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


    public void Indır (){
        hud = KProgressHUD.create(SurelerGosterim.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setDimAmount(0.5f)
                .setLabel("Lütfen bekleyin")
                .setDetailsLabel("Dosya İndiriliyor ")
                .setMaxProgress(100)
                .show();

        Intent intent;
        intent = new Intent(this, DownloadService.class);
        intent.putExtra("url",Url);
        intent.putExtra("adı", Sureadı);
        intent.putExtra("dosyatürü", ".mp3");
        intent.putExtra("path", "Tasavvuf Mektebi Media/Sureler/");
        intent.putExtra("receiver", new DownloadReceiver(new Handler()));
        startService(intent);



    }


    private class DownloadReceiver extends ResultReceiver {

        public DownloadReceiver(Handler handler) {
            super(handler);
        }

        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {

            super.onReceiveResult(resultCode, resultData);

            if (resultCode == DownloadService.UPDATE_PROGRESS) {

                int progress = resultData.getInt("progress"); //get the progress
                hud.setProgress(progress);

                if (progress == 100) {
                    hud.dismiss();
                    mİndirlayout.setVisibility(GONE);
                    mOynatıcılayout.setVisibility(View.VISIBLE);
                    Media();


                }
            }
        }
    }




    public boolean InternetKontrol(boolean b) {
        boolean connected = b;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED) ||
                (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)) {
            //we are connected to a network
            connected = true;


        } else {

            Toasty.error(this, "İnternet bağlantısını kontrol ediniz ve tekrar deneyiniz", Toast.LENGTH_LONG).show();
            connected = false;
        }
        return connected;
    }




    @Override
    protected void onPause() {
        File extStore = Environment.getExternalStorageDirectory();
        File myFile = new File(extStore.getAbsolutePath() + "/Tasavvuf Mektebi Media/Sureler/"+Sureadı+".mp3");

        if(myFile.exists()){
            mediaPlayer.stop();
            mediaPlayer.release();

        }
        super.onPause();

    }
    @Override
    protected void onDestroy() {

        super.onDestroy();

    }

}







