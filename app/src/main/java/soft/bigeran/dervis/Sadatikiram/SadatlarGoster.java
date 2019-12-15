package soft.bigeran.dervis.Sadatikiram;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import soft.bigeran.dervis.R;

public class SadatlarGoster extends AppCompatActivity {

    private ImageView Sadatimaji;
    ScrollView Sadatgösterim;
    SharedPreferences kaydetsadatı;
    private TextView Sadatbaşlık, Sadattexti1, Sadattexti2, Sadattexti3, Sadattexti4, Sadattexti5, Sadattexti6;
    public static int scrollY = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sadatlar_goster);

        Sadatgösterim = (ScrollView) findViewById(R.id.Sadat);
        Sadatbaşlık = (TextView) findViewById(R.id.BaşlıgıSadat);
        Sadattexti1 = (TextView) findViewById(R.id.Sadattext);
        Sadattexti2 = (TextView) findViewById(R.id.Sadattext1);
        Sadattexti3 = (TextView) findViewById(R.id.Sadattext2);
        Sadattexti4 = (TextView) findViewById(R.id.Sadattext3);
        Sadattexti5 = (TextView) findViewById(R.id.Sadattext4);
        Sadattexti6 = (TextView) findViewById(R.id.Sadattext5);


        kaydetsadatı = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        String Yaziboyutu = mPrefs.getString("SettingYazıboyutu","21");
        int Boyut = Integer.parseInt(Yaziboyutu);

        Sadattexti1.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
        Sadattexti2.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
        Sadattexti3.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
        Sadattexti4.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
        Sadattexti5.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);
        Sadattexti6.setTextSize(TypedValue.COMPLEX_UNIT_SP,Boyut);

        Bundle extras = getIntent().getExtras();
        String value = extras.getString("Değer2");
        Sadatbaşlık.setText(value);
        //Sadatimaji.setBackground(R.drawable.a);
        if (Sadatbaşlık.getText().equals("d0")) {
            Sadattexti1.setText(getText(R.string.Sadat1text1));
            Sadattexti2.setText(getText(R.string.Sadat1text2));
            Sadattexti3.setText(getText(R.string.Sadat1text3));
            Sadattexti4.setText(getText(R.string.Sadat1text4));
            Sadattexti5.setText(getText(R.string.Sadat1text5));


        } else if (Sadatbaşlık.getText().equals("d1	")) {
            Sadattexti1.setText(getText(R.string.ebubekirtext1));
            Sadattexti2.setText(getText(R.string.ebubekirtext2));
            Sadattexti3.setText(getText(R.string.ebubekirtext3));
            Sadattexti4.setText(getText(R.string.ebubekirtext4));

        } else if (Sadatbaşlık.getText().equals("d2	")) {

            Sadattexti1.setText(getText(R.string.sadat24));


        } else if (Sadatbaşlık.getText().equals("d3	")) {

            Sadattexti1.setText(getText(R.string.sadat25));


        } else if (Sadatbaşlık.getText().equals("d4	")) {


            Sadattexti1.setText(getText(R.string.sadat5a));
            Sadattexti2.setText(getText(R.string.sadat5b));
            Sadattexti3.setText(getText(R.string.sadat5c));


        } else if (Sadatbaşlık.getText().equals("d5	")) {


            Sadattexti1.setText(getText(R.string.sadat6));


        } else if (Sadatbaşlık.getText().equals("d6	")) {

            Sadattexti1.setText(getText(R.string.sadat7));


        } else if (Sadatbaşlık.getText().equals("d7	")) {


            Sadattexti1.setText(getText(R.string.sadat8));


        } else if (Sadatbaşlık.getText().equals("d8	")) {

            Sadattexti1.setText(getText(R.string.sadat9));


        } else if (Sadatbaşlık.getText().equals("d9	")) {
            Sadattexti1.setText(getText(R.string.sadat10));

        } else if (Sadatbaşlık.getText().equals("d10	")) {

            Sadattexti1.setText(getText(R.string.sadat11));

        } else if (Sadatbaşlık.getText().equals("d11	")) {
            Sadattexti1.setText(getText(R.string.sadat12));
        } else if (Sadatbaşlık.getText().equals("d12	")) {
            Sadattexti1.setText(getText(R.string.sadat13));
        } else if (Sadatbaşlık.getText().equals("d13	")) {
            Sadattexti1.setText(getText(R.string.sadat14));
        } else if (Sadatbaşlık.getText().equals("d14	")) {
            Sadattexti1.setText(getText(R.string.sadat15));
        } else if (Sadatbaşlık.getText().equals("d15	")) {
            Sadattexti1.setText(getText(R.string.sadat16));
        } else if (Sadatbaşlık.getText().equals("d16	")) {
            Sadattexti1.setText(getText(R.string.sadat17));
        } else if (Sadatbaşlık.getText().equals("d17	")) {
            Sadattexti1.setText(getText(R.string.sadat18));
        } else if (Sadatbaşlık.getText().equals("d18	")) {
            Sadattexti1.setText(getText(R.string.sadat19));
        } else if (Sadatbaşlık.getText().equals("d19	")) {
            Sadattexti1.setText(getText(R.string.sadat20));
        } else if (Sadatbaşlık.getText().equals("d20	")) {
            Sadattexti1.setText(getText(R.string.sadat21));
        } else if (Sadatbaşlık.getText().equals("d21	")) {
            Sadattexti1.setText(getText(R.string.sadat22));
        } else if (Sadatbaşlık.getText().equals("d22	")) {
            Sadattexti1.setText(getText(R.string.sadat23));
        } else if (Sadatbaşlık.getText().equals("d23	")) {

            Sadattexti1.setText(getText(R.string.sadat24a));
            Sadattexti2.setText(getText(R.string.sadat24b));
            Sadattexti3.setText(getText(R.string.sadat24c));
            Sadattexti4.setText(getText(R.string.sadat24d));
            Sadattexti5.setText(getText(R.string.sadat24e));

        } else if (Sadatbaşlık.getText().equals("d24	")) {

            Sadattexti1.setText(getText(R.string.sadat25a));
            Sadattexti2.setText(getText(R.string.sadat25b));
            Sadattexti3.setText(getText(R.string.sadat25c));

        } else if (Sadatbaşlık.getText().equals("d25	")) {
            Sadattexti1.setText(getText(R.string.sadat26));
        } else if (Sadatbaşlık.getText().equals("d26	")) {
            Sadattexti1.setText(getText(R.string.sadat27));
        } else if (Sadatbaşlık.getText().equals("d27	")) {
            Sadattexti1.setText(getText(R.string.sadat28));
        } else if (Sadatbaşlık.getText().equals("d28	")) {
            Sadattexti1.setText(getText(R.string.sadat29));
        } else if (Sadatbaşlık.getText().equals("d29	")) {
            Sadattexti1.setText(getText(R.string.sadat30));
        } else if (Sadatbaşlık.getText().equals("d30	")) {
            Sadattexti1.setText(getText(R.string.sadat31));
        } else if (Sadatbaşlık.getText().equals("d31	")) {
            Sadattexti1.setText(getText(R.string.sadat32));
        } else if (Sadatbaşlık.getText().equals("d32	")) {
            Sadattexti1.setText(getText(R.string.sadat33));
        } else if (Sadatbaşlık.getText().equals("d33	")) {
            Sadattexti1.setText(getText(R.string.sadat34));
        } else if (Sadatbaşlık.getText().equals("d34	")) {
            Sadattexti1.setText(getText(R.string.sadat35));
        } else if (Sadatbaşlık.getText().equals("d35	")) {
            Sadattexti1.setText(getText(R.string.sadat36));
        } else if (Sadatbaşlık.getText().equals("d36	")) {
            Sadattexti1.setText(getText(R.string.sadat37));
        } else if (Sadatbaşlık.getText().equals("d37	")) {
            Sadattexti1.setText(getText(R.string.sadat38));
        } else if (Sadatbaşlık.getText().equals("d38	")) {

            Sadattexti1.setText(getText(R.string.sadat39a));
            Sadattexti2.setText(getText(R.string.sadat39b));

        }
        //Silsileleri buraya ekle
        else if (Sadatbaşlık.getText().equals("d39	")) {
            Sadattexti1.setText(getText(R.string.sadat40));
        } else if (Sadatbaşlık.getText().equals("d40	")) {
            Sadattexti1.setText(getText(R.string.sadat39));
        } else if (Sadatbaşlık.getText().equals("menzil")) {
            Sadattexti1.setText(getText(R.string.menzil));
        } else if (Sadatbaşlık.getText().equals("konya")) {
            Sadattexti1.setText(getText(R.string.konya));
        }

        //haznevi başlangıc
        else if (Sadatbaşlık.getText().equals("haznevi1")) {
            Sadattexti1.setText(getText(R.string.haznevi1));
        }else if (Sadatbaşlık.getText().equals("haznevi2")) {
            Sadattexti1.setText(getText(R.string.haznevi2));
        }else if (Sadatbaşlık.getText().equals("haznevi3")) {
            Sadattexti1.setText(getText(R.string.haznevi3));
        }else if (Sadatbaşlık.getText().equals("haznevi4")) {
            Sadattexti1.setText(getText(R.string.haznevi4));
        }

        //haznevi bitiş

        //mahmut başlangıc
        else if (Sadatbaşlık.getText().equals("mahmut1")) {
            Sadattexti1.setText(getText(R.string.mahmut1));
        }else if (Sadatbaşlık.getText().equals("mahmut2")) {
            Sadattexti1.setText(getText(R.string.mahmut2));
        }else if (Sadatbaşlık.getText().equals("mahmut3")) {
            Sadattexti1.setText(getText(R.string.mahmut3));
        }else if (Sadatbaşlık.getText().equals("mahmut4")) {
            Sadattexti1.setText(getText(R.string.mahmut4));
        }else if (Sadatbaşlık.getText().equals("mahmut5")) {
            Sadattexti1.setText(getText(R.string.mahmut5));
        } else if (Sadatbaşlık.getText().equals("mahmut6")) {
            Sadattexti1.setText(getText(R.string.mahmut6));
        }
        //mahmut bitiş


        //süleyman başlangıc
        else if (Sadatbaşlık.getText().equals("süleyman1")) {
            Sadattexti1.setText(getText(R.string.süleyman1));
        }else if (Sadatbaşlık.getText().equals("süleyman2")) {
            Sadattexti1.setText(getText(R.string.süleyman2));
        }else if (Sadatbaşlık.getText().equals("süleyman3")) {
            Sadattexti1.setText(getText(R.string.süleyman3));
        }else if (Sadatbaşlık.getText().equals("süleyman4")) {
            Sadattexti1.setText(getText(R.string.süleyman4));
        }else if (Sadatbaşlık.getText().equals("süleyman5")) {
            Sadattexti1.setText(getText(R.string.süleyman5));
        }
        //süleyman bitiş

        //yahyalı başlangıc
        else if (Sadatbaşlık.getText().equals("yahyalı1")) {
            Sadattexti1.setText(getText(R.string.yahyalı1));
        }else if (Sadatbaşlık.getText().equals("yahyalı2")) {
            Sadattexti1.setText(getText(R.string.yahyalı2));
            Sadattexti2.setText(getText(R.string.yahyalı2a));
            Sadattexti3.setText(getText(R.string.yahyalı2b));
            Sadattexti4.setText(getText(R.string.yahyalı2b1));
        }else if (Sadatbaşlık.getText().equals("yahyalı3")) {
            Sadattexti1.setText(getText(R.string.yahyalı3));
            Sadattexti2.setText(getText(R.string.yahyalı3a));
            Sadattexti3.setText(getText(R.string.yahyalı3b));
        }else if (Sadatbaşlık.getText().equals("yahyalı4")) {
            Sadattexti1.setText(getText(R.string.yahyalı4));
        }else if (Sadatbaşlık.getText().equals("yahyalı5")) {
            Sadattexti1.setText(getText(R.string.yahyalı5));
        }
        //yahyalı bitiş


        //kıbrisi başlangıc
        else if (Sadatbaşlık.getText().equals("kıbrisi1")) {
            Sadattexti1.setText(getText(R.string.kıbrisi1));
        }else if (Sadatbaşlık.getText().equals("kıbrisi2")) {
            Sadattexti1.setText(getText(R.string.kıbrisi2));
        }else if (Sadatbaşlık.getText().equals("kıbrisi3")) {
            Sadattexti1.setText(getText(R.string.kıbrisi3));
        }else if (Sadatbaşlık.getText().equals("kıbrisi4")) {
            Sadattexti1.setText(getText(R.string.kıbrisi4));
        }else if (Sadatbaşlık.getText().equals("kıbrisi5")) {
            Sadattexti1.setText(getText(R.string.kıbrisi5));
        } else if (Sadatbaşlık.getText().equals("kıbrisi6")) {
            Sadattexti1.setText(getText(R.string.kıbrisi6));
        }else if (Sadatbaşlık.getText().equals("kıbrisi7")) {
            Sadattexti1.setText(getText(R.string.kıbrisi7));
        }else if (Sadatbaşlık.getText().equals("kıbrisi8")) {
            Sadattexti1.setText(getText(R.string.kıbrisi8));
        }else if (Sadatbaşlık.getText().equals("kıbrisi9")) {
            Sadattexti1.setText(getText(R.string.kıbrisi9));
        } else if (Sadatbaşlık.getText().equals("kıbrisi10")) {
            Sadattexti1.setText(getText(R.string.kıbrisi10));
        }
        //kıbrisi bitiş
    }

    @Override
    protected void onPause() {

        String s=Sadatbaşlık.getText().toString();
        scrollY = Sadatgösterim.getScrollY();
        SharedPreferences.Editor editor = kaydetsadatı.edit();
        editor.putInt(s, scrollY); //int değer ekleniyor
        editor.commit(); //Kayıt
        super.onPause();

    }

    @Override
    protected void onResume() {
        final String s=Sadatbaşlık.getText().toString();

        Sadatgösterim.post(new Runnable() {
            @Override
            public void run() {
                Sadatgösterim.scrollTo(0,kaydetsadatı.getInt(s,0));
            }
        });
        super.onResume();
    }
}

