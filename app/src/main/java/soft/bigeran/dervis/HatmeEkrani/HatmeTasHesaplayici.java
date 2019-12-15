package soft.bigeran.dervis.HatmeEkrani;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import soft.bigeran.dervis.R;

public class HatmeTasHesaplayici extends AppCompatActivity {



    private Button hesaplayıcı;
    private LinearLayout İnşirahLayoutC,İhlasLayoutC,YabakiLayoutC,LahavleLayoutC;
    private TextView Salavatsayısı,inşirahsayısı,ihlassayısı,entelbakisayısı,lahavlesayısı,Veya;
    private EditText sayı;
    private Integer salavat,inşirah,ihlas,baki,lahavle,KisiSayısı;
    private Switch SvitchAcıcı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatme_tas_hesaplayici);


        getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,
                android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);



        //Taş hesaplayıcı
        hesaplayıcı = (Button) findViewById(R.id.Hesapla);
        sayı = (EditText) findViewById(R.id.numarainput);
        Salavatsayısı = (TextView)findViewById(R.id.salavattext);
        inşirahsayısı = (TextView)findViewById(R.id.İnşirahtext);
        ihlassayısı = (TextView)findViewById(R.id.ihlastext);
        entelbakisayısı = (TextView)findViewById(R.id.Entelbakitext);
        lahavlesayısı = (TextView)findViewById(R.id.lahavletext);
        Veya = (TextView)findViewById(R.id.veya);
        SvitchAcıcı = (Switch)findViewById(R.id.switch1);
        İhlasLayoutC = (LinearLayout)findViewById(R.id.ihlasLayout);
        İnşirahLayoutC = (LinearLayout)findViewById(R.id.inşirahLayout);
        YabakiLayoutC = (LinearLayout)findViewById(R.id.EntelBakiLayout);
        LahavleLayoutC = (LinearLayout)findViewById(R.id.LaHavleLayout);


        İnşirahLayoutC.setVisibility(View.GONE);


        SvitchAcıcı.setChecked(true);
        SvitchAcıcı.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {

                    İhlasLayoutC.setVisibility(View.GONE);
                    İnşirahLayoutC.setVisibility(View.GONE);
                    YabakiLayoutC.setVisibility(View.VISIBLE);
                    LahavleLayoutC.setVisibility(View.VISIBLE);
                    SvitchAcıcı.setText(R.string.KüçükHatme);
                    Veya.setVisibility(View.VISIBLE);

                } else {
                    İhlasLayoutC.setVisibility(View.VISIBLE);
                    İnşirahLayoutC.setVisibility(View.VISIBLE);
                    YabakiLayoutC.setVisibility(View.GONE);
                    LahavleLayoutC.setVisibility(View.GONE);
                    Veya.setVisibility(View.GONE);
                    SvitchAcıcı.setText(R.string.BüyükHatme);

                }
            }
        });




        final int salavat = 100;
        final int inşirah = 79;
        final int ihlas = 1001;
        final int baki = 500;
        final int lahavle = 500;


        hesaplayıcı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((sayı.getText().toString().equals(""))|| (sayı.getText().toString().equals("0")))
                {
                    Toast.makeText(getBaseContext(),R.string.BirSayıGiriniz,
                            Toast.LENGTH_LONG).show();

                }


                else  {

                    KisiSayısı=Integer.parseInt(sayı.getText().toString());
                    Salavatsayısı.setText((String.valueOf(salavat/KisiSayısı))+"adet,Kalan:"+(String.valueOf(salavat%KisiSayısı)));
                    inşirahsayısı.setText((String.valueOf(inşirah/KisiSayısı))+"adet,Kalan:"+(String.valueOf(inşirah%KisiSayısı)));
                    ihlassayısı.setText((String.valueOf(ihlas/KisiSayısı))+"adet,Kalan:"+(String.valueOf(ihlas%KisiSayısı)));
                    entelbakisayısı.setText((String.valueOf(baki/KisiSayısı))+"adet,Kalan:"+(String.valueOf(baki%KisiSayısı)));
                    lahavlesayısı.setText((String.valueOf(lahavle/KisiSayısı))+"adet,Kalan:"+(String.valueOf(lahavle%KisiSayısı)));



                }

            }

        });
    }
}
