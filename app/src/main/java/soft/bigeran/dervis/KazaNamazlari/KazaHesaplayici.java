package soft.bigeran.dervis.KazaNamazlari;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class KazaHesaplayici extends AppCompatActivity {

    private EditText GgünC, GayC, Gyılc, BgünC, BayC, ByılC;
    private Button Hesapla;
    private Integer Bugün, Buay, Buyıl, Gecengün, Gecenay, Gecenyıl;
    private SharedPreferences kaydet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kaza_hesaplayici);
        kaydet = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        BgünC = (EditText) findViewById(R.id.Bgün);
        BayC = (EditText) findViewById(R.id.Bay);
        ByılC = (EditText) findViewById(R.id.Byıl);
        GgünC = (EditText) findViewById(R.id.Ggün);
        GayC = (EditText) findViewById(R.id.Gay);
        Gyılc = (EditText) findViewById(R.id.Gyıl);
        Hesapla = (Button) findViewById(R.id.hesaplamabutonu);
        Hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((BgünC.getText().toString().equals(""))|| (BayC.getText().toString().equals(""))|| (ByılC.getText().toString().equals(""))
                        || (Gyılc.getText().toString().equals(""))|| (GayC.getText().toString().equals(""))|| (GgünC.getText().toString().equals("")))
                {
                    Toasty.error(getBaseContext(), "Tarihleri örnekteki gibi doldurunuz!", Toast.LENGTH_LONG).show();
                }
                else  {
                    Bugün = Integer.parseInt(BgünC.getText().toString());
                    Buay = Integer.parseInt(BayC.getText().toString());
                    Buyıl = Integer.parseInt(ByılC.getText().toString());
                    Gecengün = Integer.parseInt(GgünC.getText().toString());
                    Gecenay = Integer.parseInt(GayC.getText().toString());
                    Gecenyıl = Integer.parseInt(Gyılc.getText().toString());
                    int sabah =((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    int öğle =((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    int ikindi=((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    int akşam=((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    int yatsı=((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    int vitr=((Gecengün * 1) + (Gecenay * 30) + (Gecenyıl * 365)) - ((Bugün * 1) + (Buay * 30) + (Buyıl * 365));
                    SharedPreferences.Editor editor = kaydet.edit();
                    editor.putString("Sabahkayıt", String.valueOf(sabah));
                    editor.putString("Öğlekayıt", String.valueOf(öğle));
                    editor.putString("İkindikayıt", String.valueOf(ikindi));
                    editor.putString("Akşamkayıt", String.valueOf(akşam));
                    editor.putString("Yatsıkayıt", String.valueOf(yatsı));
                    editor.putString("Vitrkayıt", String.valueOf(vitr));
                    editor.commit();
                    Toasty.success(getBaseContext(), "Hesaplandı!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
