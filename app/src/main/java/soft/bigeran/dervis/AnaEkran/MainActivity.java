package soft.bigeran.dervis.AnaEkran;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.crashlytics.android.Crashlytics;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import net.colindodd.toggleimagebutton.ToggleImageButton;

import java.io.File;

import es.dmoral.toasty.Toasty;
import io.fabric.sdk.android.Fabric;
import soft.bigeran.dervis.Ayarlar.Ayarlar;
import soft.bigeran.dervis.BuildConfig;
import soft.bigeran.dervis.Delalül.Delalul_hayrat;
import soft.bigeran.dervis.DergahBul.DergahBulucu;
import soft.bigeran.dervis.Duyuru.DuyuruMenu;
import soft.bigeran.dervis.EsmaülHüsna.EsmaulHusna;
import soft.bigeran.dervis.EvliyalarAnksiklopedisi.MainActivitySearchView;
import soft.bigeran.dervis.HadisCarki.HadisCarki;
import soft.bigeran.dervis.Hakkımızda.Hakkımızda;
import soft.bigeran.dervis.HatmeEkrani.HatmeAnaEkrani;
import soft.bigeran.dervis.Kafileler.KafileMenu;
import soft.bigeran.dervis.KazaNamazlari.KazaMenu;
import soft.bigeran.dervis.Kütüphane.KutuphaneGenel;
import soft.bigeran.dervis.Quran.Quran;
import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Sadatikiram.SadatlarMenu;
import soft.bigeran.dervis.Sohbetler.SohbetMenü.SohbetMenu;
import soft.bigeran.dervis.Sureler.SurelerMenu;
import soft.bigeran.dervis.Tarikatlar.Tarikatlar;
import soft.bigeran.dervis.Tasavvuf.Tasavvuf;
import soft.bigeran.dervis.Zikirmatik.Zikirsec;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;
    private static final int MODE_DARK = 0;
    private static final int MODE_LIGHT = 1;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigationMyProfile:
                    if (InternetKontrol(true)) {
                        startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.Walpaper.MainActivity.class));
                        Animatoo.animateFade(MainActivity.this);


                    }

                    return true;
                case R.id.navigationMyCourses:
                    if (InternetKontrol(true)) {
                        startActivity(new Intent(MainActivity.this, KafileMenu.class));
                        Animatoo.animateFade(MainActivity.this);

                    }

                    return true;
                case R.id.navigationHome:
                    return true;
                case R.id.navigationSearch:
                    startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.MainActivity.class));
                    Animatoo.animateFade(MainActivity.this);

                    return true;
                case R.id.navigationMenu:
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.openDrawer(GravityCompat.START);
                    return true;
            }
            return false;
        }
    };
    private Button mFloatingActionButton;
    private LinearLayout mHakkımda;
    private LinearLayout mAyar;
    private LinearLayout mPuanver;
    private LinearLayout mUygulamayıpaylaş;

    private ToggleImageButton mTemaayarı;
    private TextView mGecetext;
    private TextView mGündüztext;
    private int selectedTabColor, unSelectedTabColor;
    private LinearLayout mDuyurular;
    private LinearLayout mSohbetler;
    private LinearLayout mChat;
    private LinearLayout mDergahlayout;
    private LinearLayout mEzanvakti;
    private LinearLayout mGüncelle;
    private ImageView mThumb;
    private CardView mTarikatlar;
    private CardView mKütüphane;
    private CardView mEvliyalaransiklopedisi;
    private CardView mKazanamazları;
    private CardView mSureler;
    private CardView mSadatıkiram;
    private CardView mZikirmatik;
    private CardView mHadiscarkı;
    private CardView mEsma;
    private CardView mKuran;
    private LinearLayout mKafileler;
    private LinearLayout mDarkModeNav;
    private NavigationView mViewNav;
    private DrawerLayout mLayoutDrawer;
    private CardView mHatme;
    private Toolbar mToolbar;
    private ImageView mİmageView2;
    private BottomNavigationView mNavigation;
    private LinearLayout mMultimedia;
    private CardView mTasavvuf;
    private CardView mDelalül;
    private LinearLayout mSanalk;


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this).setIcon(R.drawable.red).setTitle(R.string.Çıkış)
                    .setMessage(R.string.Eminmisin)
                    .setPositiveButton(R.string.Evet, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();

                        }
                    }).setNegativeButton(R.string.Hayır, null).show();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDarkMode(getWindow());
        setContentView(R.layout.activity_main);
        initView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Fabric.with(this, new Crashlytics());
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(900);
        rotate.setRepeatCount(Animation.INFINITE);
        //mThumb.startAnimation(rotate);


        selectedTabColor = this.getResources().getColor(R.color.gray);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        bottomNavigationView.setSelectedItemId(R.id.navigationHome);


    }

    private void initView() {
        mFloatingActionButton = (Button) findViewById(R.id.floatingActionButton);
        mFloatingActionButton.setOnClickListener(this);
        mHakkımda = (LinearLayout) findViewById(R.id.hakkımda);
        mHakkımda.setOnClickListener(this);
        mAyar = (LinearLayout) findViewById(R.id.ayar);
        mAyar.setOnClickListener(this);
        mPuanver = (LinearLayout) findViewById(R.id.puanver);
        mPuanver.setOnClickListener(this);
        mUygulamayıpaylaş = (LinearLayout) findViewById(R.id.uygulamayıpaylaş);
        mUygulamayıpaylaş.setOnClickListener(this);

        mTemaayarı = (ToggleImageButton) findViewById(R.id.temaayarı);
        mTemaayarı.setOnClickListener(this);
        mGecetext = (TextView) findViewById(R.id.gecetext);
        mGündüztext = (TextView) findViewById(R.id.gündüztext);
        mDuyurular = (LinearLayout) findViewById(R.id.duyurular);
        mDuyurular.setOnClickListener(this);
        mSohbetler = (LinearLayout) findViewById(R.id.sohbetler);
        mSohbetler.setOnClickListener(this);
        mChat = (LinearLayout) findViewById(R.id.chat);
        mChat.setOnClickListener(this);
        mDergahlayout = (LinearLayout) findViewById(R.id.dergahlayout);
        mDergahlayout.setOnClickListener(this);
        mEzanvakti = (LinearLayout) findViewById(R.id.ezanvakti);
        mEzanvakti.setOnClickListener(this);
        mGüncelle = (LinearLayout) findViewById(R.id.güncelle);
        mGüncelle.setOnClickListener(this);
        mThumb = (ImageView) findViewById(R.id.thumb);
        mTarikatlar = (CardView) findViewById(R.id.tarikatlar);
        mTarikatlar.setOnClickListener(this);
        mKütüphane = (CardView) findViewById(R.id.kütüphane);
        mKütüphane.setOnClickListener(this);
        mEvliyalaransiklopedisi = (CardView) findViewById(R.id.Evliyalaransiklopedisi);
        mEvliyalaransiklopedisi.setOnClickListener(this);
        mKazanamazları = (CardView) findViewById(R.id.kazanamazları);
        mKazanamazları.setOnClickListener(this);
        mSureler = (CardView) findViewById(R.id.sureler);
        mSureler.setOnClickListener(this);
        mSadatıkiram = (CardView) findViewById(R.id.sadatıkiram);
        mSadatıkiram.setOnClickListener(this);
        mZikirmatik = (CardView) findViewById(R.id.zikirmatik);
        mZikirmatik.setOnClickListener(this);
        mHadiscarkı = (CardView) findViewById(R.id.Hadiscarkı);
        mHadiscarkı.setOnClickListener(this);
        mEsma = (CardView) findViewById(R.id.esma);
        mEsma.setOnClickListener(this);
        mKuran = (CardView) findViewById(R.id.Kuran);
        mKuran.setOnClickListener(this);
        mKafileler = (LinearLayout) findViewById(R.id.Kafileler);
        mKafileler.setOnClickListener(this);
        mDarkModeNav = (LinearLayout) findViewById(R.id.nav_dark_mode);
        mViewNav = (NavigationView) findViewById(R.id.nav_view);
        mLayoutDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mHatme = (CardView) findViewById(R.id.Hatme);
        mHatme.setOnClickListener(this);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mİmageView2 = (ImageView) findViewById(R.id.imageView2);
        mNavigation = (BottomNavigationView) findViewById(R.id.navigation);
        mMultimedia = (LinearLayout) findViewById(R.id.Multimedia);
        mMultimedia.setOnClickListener(this);
        mTasavvuf = (CardView) findViewById(R.id.Tasavvuf);
        mTasavvuf.setOnClickListener(this);
        mDelalül = (CardView) findViewById(R.id.Delalül);
        mDelalül.setOnClickListener(this);
        mSanalk = (LinearLayout) findViewById(R.id.Sanalk);
        mSanalk.setOnClickListener(this);
    }


    //create a seperate class file, if required in multiple activities
    public void setDarkMode(Window window) {
        if (new DarkModePrefManager(this).isNightMode()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            changeStatusBar(MODE_DARK, window);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            changeStatusBar(MODE_LIGHT, window);
        }
    }

    public void changeStatusBar(int mode, Window window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(this.getResources().getColor(R.color.contentStatusBar));
            //Light mode
            if (mode == MODE_LIGHT) {
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
    }


    private void Toogle(ToggleButton toggleButton) {
        boolean on = (toggleButton).isChecked();
        clicksesi();
        if (on) {
            mGecetext.setVisibility(View.GONE);
            mGündüztext.setVisibility(View.VISIBLE);
            Toasty.success(getApplicationContext(), "Gece Modu Acıldı", Toast.LENGTH_LONG).show();
        } else {
            mGecetext.setVisibility(View.VISIBLE);
            mGündüztext.setVisibility(View.GONE);
            Toasty.warning(getApplicationContext(), "Gündüz Modu Açıldı", Toast.LENGTH_LONG).show();
        }

    }

    private void clicksesi() {
        final MediaPlayer ses = MediaPlayer.create(getApplicationContext(), R.raw.m);
        ses.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatingActionButton:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);
                // TODO 19/12/01
                break;
            case R.id.hakkımda:// TODO 19/12/01
                startActivity(new Intent(MainActivity.this, Hakkımızda.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.ayar:// TODO 19/12/01
                startActivity(new Intent(MainActivity.this, Ayarlar.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.puanver:// TODO 19/12/01
                if (InternetKontrol(true)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(intent);
                }


                break;
            case R.id.uygulamayıpaylaş:// TODO 19/12/01
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Tasavvuf Mektebi");
                    String shareMessage = "\n Tasavvuf ile ilgili güzel bir uygulama buldum, sende yükle bence..\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "Seçiniz"));
                } catch (Exception e) {
                    //e.toString();
                }
                break;

            case R.id.temaayarı:// TODO 19/12/02
                Toogle(mTemaayarı);
                DarkModePrefManager darkModePrefManager = new DarkModePrefManager(this);
                darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                recreate();

                break;
            case R.id.duyurular:// TODO 19/12/02
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, DuyuruMenu.class));
                    Animatoo.animateFade(MainActivity.this);
                }
                break;
            case R.id.sohbetler:// TODO 19/12/02
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, SohbetMenu.class));
                    Animatoo.animateFade(MainActivity.this);
                }
                break;
            case R.id.chat:// TODO 19/12/02
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.Chat.MainActivity.class));
                    Animatoo.animateFade(MainActivity.this);
                }
                break;
            case R.id.dergahlayout:// TODO 19/12/02
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, DergahBulucu.class));
                    Animatoo.animateFade(MainActivity.this);
                }
                break;
            case R.id.ezanvakti:// TODO 19/12/02
                startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.MainActivity.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.güncelle:// TODO 19/12/02
                if (InternetKontrol(true)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("market://details?id=" + getPackageName()));
                    startActivity(intent);
                }

                break;
            case R.id.tarikatlar:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, Tarikatlar.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.kütüphane:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, KutuphaneGenel.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Evliyalaransiklopedisi:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, MainActivitySearchView.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.kazanamazları:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, KazaMenu.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.sureler:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, SurelerMenu.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.sadatıkiram:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, SadatlarMenu.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.zikirmatik:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, Zikirsec.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Hadiscarkı:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, HadisCarki.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.esma:// TODO 19/12/04
                startActivity(new Intent(MainActivity.this, EsmaulHusna.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Kuran:// TODO 19/12/04

                File dataDirectory = Environment.getExternalStorageDirectory();
                File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Kur'an-ı Kerim/quraan.pdf");
                if (fileDir.exists()) {
                    startActivity(new Intent(MainActivity.this, Quran.class));
                    Animatoo.animateFade(MainActivity.this);

                } else {
                    if (InternetKontrol(true)) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Bir kereye mahsus");
                        builder.setMessage("4 mb'lık pdf dosyası indirilmeli, indirilsin mi?");
                        builder.setNegativeButton("Hayır", null);
                        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(MainActivity.this, Quran.class));
                                Animatoo.animateFade(MainActivity.this);

                            }
                        });
                        builder.show();

                    }
                }

                break;
            case R.id.Kafileler:// TODO 19/12/07
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, KafileMenu.class));
                    Animatoo.animateFade(MainActivity.this);
                }

                break;
            case R.id.Hatme:// TODO 19/12/07
                startActivity(new Intent(MainActivity.this, HatmeAnaEkrani.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Multimedia:// TODO 19/12/08
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.Walpaper.MainActivity.class));
                    Animatoo.animateFade(MainActivity.this);
                }

                break;
            case R.id.Tasavvuf:// TODO 19/12/09
                startActivity(new Intent(MainActivity.this, Tasavvuf.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Delalül:// TODO 19/12/10
                startActivity(new Intent(MainActivity.this, Delalul_hayrat.class));
                Animatoo.animateFade(MainActivity.this);
                break;
            case R.id.Sanalk:// TODO 19/12/10
                if (InternetKontrol(true)) {
                    startActivity(new Intent(MainActivity.this, soft.bigeran.dervis.SanalKütüphane.MainActivity.class));
                    Animatoo.animateFade(MainActivity.this);
                }

                break;
            default:
                break;
        }
    }


    @Override
    protected void onResume() {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        Boolean temadurum = mPrefs.getBoolean("SettingTemam", true);

        mTemaayarı.setChecked(temadurum);

        if (mTemaayarı.isChecked()) {
            mGecetext.setVisibility(View.GONE);
            mGündüztext.setVisibility(View.VISIBLE);
        } else {
            mGecetext.setVisibility(View.VISIBLE);
            mGündüztext.setVisibility(View.GONE);
        }
        super.onResume();


    }


    @Override
    protected void onPause() {

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar", 0);
        SharedPreferences.Editor editorum = mPrefs.edit();
        editorum.putBoolean("SettingTemam", mTemaayarı.isChecked());
        editorum.commit();

        super.onPause();
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


}
