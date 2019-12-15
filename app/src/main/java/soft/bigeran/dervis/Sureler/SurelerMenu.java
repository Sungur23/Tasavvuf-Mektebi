package soft.bigeran.dervis.Sureler;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.ContinuousSort;
import com.willowtreeapps.spruce.sort.ContinuousWeightedSort;
import com.willowtreeapps.spruce.sort.CorneredSort;
import com.willowtreeapps.spruce.sort.DefaultSort;
import com.willowtreeapps.spruce.sort.InlineSort;
import com.willowtreeapps.spruce.sort.LinearSort;
import com.willowtreeapps.spruce.sort.RadialSort;
import com.willowtreeapps.spruce.sort.RandomSort;

import soft.bigeran.dervis.R;

public class SurelerMenu extends AppCompatActivity implements View.OnClickListener {

    private Button mSure1;
    private Button mSure2;
    private Button mSure3;
    private Button mSure4;
    private Button mSure5;
    private Button mSure6;
    private Button mSure7;
    private Button mSure8;
    private Button mSure9;
    private Button mSure10;
    private Button mSure11;
    private Button mSure12;
    private Button mSure13;
    private Button mSure14;
    private Button mSure15;
    private Button mSure16;
    private Button mDua1;
    private Button mDua2;
    private Button mDua3;
    private Button mDua4;
    private Button mDua5;
    private Button mDua6;
    private Button mDua7;
    private Button mDua8;
    private Button mDua9;
    private LinearLayout mSureMenü;
    private RelativeLayout mAnakatmanım;


    Animator spruceAnimator, anim;
    long interObjectDelay = 100L;
    int duration = 2000;
    private LinearLayout mAnim1;
    private LinearLayout mAnim2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sureler_menu);
        initView();
       // initSpruce();


        Animator spruceAnimator = new Spruce
                .SpruceBuilder(mAnim1)
                .sortWith(new RandomSort(/*interObjectDelay=*/20L))
                .animateWith(new Animator[] {DefaultAnimations.shrinkAnimator(mAnim1, /*duration=*/3000)})
                .start();

        Animator spruceAnimator2 = new Spruce
                .SpruceBuilder(mAnim2)
                .sortWith(new RandomSort(/*interObjectDelay=*/20L))
                .animateWith(new Animator[] {DefaultAnimations.shrinkAnimator(mAnim2, /*duration=*/3000)})
                .start();

    }

    private void initSpruce() {
        spruceAnimator = new Spruce.SpruceBuilder(mAnim1)
                .sortWith(new DefaultSort(100))
                .animateWith(DefaultAnimations.spinAnimator(mAnim1, 4000),
                        ObjectAnimator.ofFloat(mAnim1, "translationX", -mAnim1.getWidth(), 0f).setDuration(800))
                .start();
    }

    private void initView() {
        mSure1 = (Button) findViewById(R.id.sure1);
        mSure1.setOnClickListener(this);
        mSure2 = (Button) findViewById(R.id.sure2);
        mSure2.setOnClickListener(this);
        mSure3 = (Button) findViewById(R.id.sure3);
        mSure3.setOnClickListener(this);
        mSure4 = (Button) findViewById(R.id.sure4);
        mSure4.setOnClickListener(this);
        mSure5 = (Button) findViewById(R.id.sure5);
        mSure5.setOnClickListener(this);
        mSure6 = (Button) findViewById(R.id.sure6);
        mSure6.setOnClickListener(this);
        mSure7 = (Button) findViewById(R.id.sure7);
        mSure7.setOnClickListener(this);
        mSure8 = (Button) findViewById(R.id.sure8);
        mSure8.setOnClickListener(this);
        mSure9 = (Button) findViewById(R.id.sure9);
        mSure9.setOnClickListener(this);
        mSure10 = (Button) findViewById(R.id.sure10);
        mSure10.setOnClickListener(this);
        mSure11 = (Button) findViewById(R.id.sure11);
        mSure11.setOnClickListener(this);
        mSure12 = (Button) findViewById(R.id.sure12);
        mSure12.setOnClickListener(this);
        mSure13 = (Button) findViewById(R.id.sure13);
        mSure13.setOnClickListener(this);
        mSure14 = (Button) findViewById(R.id.sure14);
        mSure14.setOnClickListener(this);
        mSure15 = (Button) findViewById(R.id.sure15);
        mSure15.setOnClickListener(this);
        mSure16 = (Button) findViewById(R.id.sure16);
        mSure16.setOnClickListener(this);
        mDua1 = (Button) findViewById(R.id.Dua1);
        mDua1.setOnClickListener(this);
        mDua2 = (Button) findViewById(R.id.Dua2);
        mDua2.setOnClickListener(this);
        mDua3 = (Button) findViewById(R.id.Dua3);
        mDua3.setOnClickListener(this);
        mDua4 = (Button) findViewById(R.id.Dua4);
        mDua4.setOnClickListener(this);
        mDua5 = (Button) findViewById(R.id.Dua5);
        mDua5.setOnClickListener(this);
        mDua6 = (Button) findViewById(R.id.Dua6);
        mDua6.setOnClickListener(this);
        mDua7 = (Button) findViewById(R.id.Dua7);
        mDua7.setOnClickListener(this);
        mDua8 = (Button) findViewById(R.id.Dua8);
        mDua8.setOnClickListener(this);
        mDua9 = (Button) findViewById(R.id.Dua9);
        mDua9.setOnClickListener(this);
        mSureMenü = (LinearLayout) findViewById(R.id.SureMenü);
        mAnakatmanım = (RelativeLayout) findViewById(R.id.Anakatmanım);
        mAnim1 = (LinearLayout) findViewById(R.id.anim1);
        mAnim2 = (LinearLayout) findViewById(R.id.anim2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sure1:
                String s = "fatiha";
                Sureler(R.drawable.fatiha, R.string.fatiha, "Fatiha Suresi", s, "https://drive.google.com/uc?export=download&id=1gOMPXB27kF2tnfhfypKI57NRQx6tUuiz");
                break;
            case R.id.sure2:
                s = "fil";
                Sureler(R.drawable.fil, R.string.fil, "Fil Suresi", s, "https://drive.google.com/uc?export=download&id=1EtEfxtt21qScDiMhw7spgP5Ee1TN_okP");
                break;
            case R.id.sure3:
                s = "asr";
                Sureler(R.drawable.asr, R.string.asr, "Asr Suresi", s, "https://drive.google.com/uc?export=download&id=1HRRLtRhE87TGse9FxGfWn7Y4ajyfWXsP");
                break;
            case R.id.sure4:
                s = "felak";
                Sureler(R.drawable.felak, R.string.felak, "Felak Suresi", s, "https://drive.google.com/uc?export=download&id=1hzYjwhJh1nN4pS0hJttAHgBgb-YWt91q");
                break;
            case R.id.sure5:
                s = "nas";
                Sureler(R.drawable.nas, R.string.nas, "Nas Suresi", s, "https://drive.google.com/uc?export=download&id=1O2hAuLOA8CGiKxy5dAQepiJP_04EAztb");
                break;
            case R.id.sure6:
                s = "ihlas";
                Sureler(R.drawable.ihlas, R.string.ihlas, "İhlas  Suresi", s, "https://drive.google.com/uc?export=download&id=1Fv6L6tKZ67orRqbRmR_sUFmO8QItcLUV");
                break;
            case R.id.sure7:
                s = "tebbet";
                Sureler(R.drawable.tebbet, R.string.tebbet, "Tebbet Suresi", s, "https://drive.google.com/uc?export=download&id=1pVcQgsiSTUt36zOvA2hfkbWD6wlXyg1D");
                break;
            case R.id.sure8:
                s = "nasr";
                Sureler(R.drawable.nasr, R.string.nasr, "Nasr Suresi", s, "https://drive.google.com/uc?export=download&id=1qh8uY_689bJ-QCQbtrO_VRJ2LQgz0mzj");
                break;
            case R.id.sure9:
                s = "maun";
                Sureler(R.drawable.maun, R.string.maun, "Maun Suresi", s, "https://drive.google.com/uc?export=download&id=1ctggl7U2njE-Vzsx_BXnf3hmR3Z4BCIz");
                break;
            case R.id.sure10:
                s = "kureys";
                Sureler(R.drawable.kureys, R.string.kureyş, "Kureyş Suresi", s, "https://drive.google.com/uc?export=download&id=12z3Dha5JrxG23CDYk8ym-RnFmkyQxQp8");
                break;
            case R.id.sure11:
                s = "kevser";
                Sureler(R.drawable.kevser, R.string.kevser, "Kevser Suresi", s, "https://drive.google.com/uc?export=download&id=1xs2K-T095FHfEV9OrIvL5sKEC9GhvvY2");
                break;
            case R.id.sure12:
                s = "kafirun";
                Sureler(R.drawable.kafirun, R.string.kafirun, "Kafirun Suresi", s, "https://drive.google.com/uc?export=download&id=1pe8594dGYY1CSVq6Avl2o0W70jqvmEjf");
                break;
            case R.id.sure13:
                s = "kadir";
                Sureler(R.drawable.kadir, R.string.kadir, "Kadir Suresi", s, "https://drive.google.com/uc?export=download&id=1hsHBnplNcea3ChER4bsovAiqGHaq-r3Q");
                break;
            case R.id.sure14:
                s = "ayetelkursi";
                Sureler(R.drawable.ayetel_k, R.string.ayetelkursi, "Ayetel Kursi", s, "https://drive.google.com/uc?export=download&id=1KJb4zyn7G7nXmdL0ttsfDVZ75ir2IS4X");
                break;
            case R.id.sure15:
                s = "amenerrasulu";
                Sureler(R.drawable.amenrasul, R.string.anenarrasulü, "Amenerrasulü", s, "https://drive.google.com/uc?export=download&id=1Wnlh96jVCUnfp55kasWKfWFGj7j9LKXQ");
                break;
            case R.id.sure16:
                s = "hasr";
                Sureler(R.drawable.h_ellezi, R.string.haşr, "Haşr Suresi", s, "https://drive.google.com/uc?export=download&id=1--poTxApv-X3O9Z9lZMCMA6nsyLj9FEq");
                break;
            case R.id.Dua1:
                s = "abarik";
                Sureler(R.drawable.abarik, R.string.barik, "Salli Barik", s, "https://drive.google.com/uc?export=download&id=1SbJKcTCLCYHKs_JdROtASa3CK0kN-SiP");
                break;
            case R.id.Dua2:
                s = "amentu";
                Sureler(R.drawable.amentu, R.string.amentü, "Amentü", s, "https://drive.google.com/uc?export=download&id=19tfN9bDcjFCFQFJTnPcldzVpTSCGshVk");
                break;
            case R.id.Dua3:
                s = "asalli";
                Sureler(R.drawable.asalli, R.string.salli, "Salli Ala", s, "https://drive.google.com/uc?export=download&id=1eh9lP9J58QqBWDoiQcaSCVzK2Ku-8bsw");
                break;
            case R.id.Dua4:
                s = "ettahiyyatu";
                Sureler(R.drawable.tahhiyyat, R.string.ettahiyati, "Ettehiyyâtu", s, "https://drive.google.com/uc?export=download&id=1P_RH3YHSMRIcvDCnKRIoGUbbv9Naxxgh");
                break;
            case R.id.Dua5:
                s = "k1";
                Sureler(R.drawable.k1, R.string.kunut1, "Kunut-1 Duası", s, "https://drive.google.com/uc?export=download&id=1LU8x27yGjUNSXOW6EGq1ec-p07ixROLQ");
                break;
            case R.id.Dua6:
                s = "k2";
                Sureler(R.drawable.k2, R.string.kunut2, "Kunut-2 Duası", s, "https://drive.google.com/uc?export=download&id=1dp7IWWV_ejiVRO3Ib2df1umb6pcTuykJ");
                break;
            case R.id.Dua7:
                s = "rabbena";
                Sureler(R.drawable.rabbena, R.string.rabbaneatina, "Rabbena Atina", s, "https://drive.google.com/uc?export=download&id=1JeGYLNvmMBGBTQKP5pWipTT1m8_iIGOB");
                break;
            case R.id.Dua8:
                s = "rfirli";
                Sureler(R.drawable.rfirli, R.string.rabbanefirli, "Rabbane Firli", s, "https://drive.google.com/uc?export=download&id=1lahySKVL0FQeDf-ZSgZHi_EAtRPTH6wD");
                break;
            case R.id.Dua9:
                s = "subhaneke";
                Sureler(R.drawable.subhaneke, R.string.subhaneke, "Subhaneke", s, "https://drive.google.com/uc?export=download&id=10cM5UKIT6AYCECpq1bbgaesGQuOydDZz");
                break;
            case R.id.Dua10:// TODO 19/10/29
                break;
            case R.id.Dua11:// TODO 19/10/29
                break;
            case R.id.Dua12:// TODO 19/10/29
                break;
            case R.id.Dua13:// TODO 19/10/29
                break;
            case R.id.Dua14:// TODO 19/10/29
                break;
            case R.id.Dua15:// TODO 19/10/29
                break;
            case R.id.Dua16:// TODO 19/10/29
                break;
            default:
                break;
        }
    }


    private void Sureler(int Sureimajı, int Suretexti, String Sureadı, String Suremp3, String Sureurl) {
        Intent i = new Intent(getApplicationContext(), SurelerGosterim.class);
        i.putExtra("Sureimajı", Sureimajı);
        i.putExtra("Suretexti", Suretexti);
        i.putExtra("Sureadı", Sureadı);
        i.putExtra("Suremp3", Suremp3);
        i.putExtra("Sureurl", Sureurl);
        startActivity(i);
    }

}