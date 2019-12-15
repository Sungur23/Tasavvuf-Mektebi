package soft.bigeran.dervis.Zikirmatik;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import soft.bigeran.dervis.R;

public class Zikirsec extends AppCompatActivity {
    private ArrayList<Zikir> zikir;
    private ListView listView;
    private soft.bigeran.dervis.Zikirmatik.ZikirAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zikirsec);

        initialize();
        fillArrayList(zikir);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {

                    String Adı = "Zikir Seçilmedi";
                    String Sayı = "⭐❤⭐";
                    ZikirSecim(Adı,Sayı);


                } else if (position == 1) {

                    String Adı = "Estağfirullah";
                    String Sayı = "25";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 2) {

                    String Adı = "Bismillahi Subhanallahi ve Bihamdihi";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 3) {

                    String Adı = "Lâ ilâhe illallâhu vahdehu lâşerîke leh \n lehu'l mülkü ve lehu'l hamdü ve \n hüve alâ külli şey'in kadîr";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);
                } else if (position == 4) {

                    String Adı = "Lâ ilâhe illallâhu'l Melikül Hakkul Mübin";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 5) {

                    String Adı = "Lâ ilâhe illallah";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 6) {

                    String Adı = "Lâ Havle Velâ Kuvvete İllâ Billâh";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);
                } else if (position == 7) {

                    String Adı = "Sübhânallahi ve bi–hamdihî sübhânallahi’l–azîm";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 8) {

                    String Adı = "Sübhânallâhi velhamdülillâhi velâ ilâhe illallahü vallâhü ekber";
                    String Sayı = "Hadis-i şeriflerde sayı belirtilmemiştir";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 9) {

                    String Adı = "SubhanAllah";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 10) {

                    String Adı = "Subhanallahi ve bihamdihi adede halkıhi \n ve rıza nefsihi ve zinete arşihi ve midade kelimatihi";
                    String Sayı = "3";
                    ZikirSecim(Adı,Sayı);

                } else if (position == 11) {

                    String Adı = "Allâhumme Salli Alâ Muhammed";
                    String Sayı = "Hadis-i şeriflerde sayı belirtilmemiştir";
                    ZikirSecim(Adı,Sayı);
                } else if (position == 12) {

                    String Adı = "Estağfirullâhe Ve Etûbu İleyh";
                    String Sayı = "70 veya 100";
                    ZikirSecim(Adı,Sayı);
                } else if (position == 13) {
                    String Adı = "İhlas Suresi";
                    String Sayı = "100";
                    ZikirSecim(Adı,Sayı);

                }
            }
        });

    }


    private void ZikirSecim(String Adı,String Sayı) {
        Intent i = new Intent(getApplicationContext(), Zikirmatik.class);
        i.putExtra("Zikiradı", Adı);
        i.putExtra("Zikirsayı", Sayı);
        startActivity(i);
    }

    private void initialize() {
        zikir = new ArrayList<Zikir>();
        listView = (ListView) findViewById(R.id.person_list_view);
        listViewAdapter = new soft.bigeran.dervis.Zikirmatik.ZikirAdapter(Zikirsec.this,zikir);
        listView.setAdapter(listViewAdapter);
    }

    private void fillArrayList(ArrayList<Zikir>zikir){



        Zikir Zikir	= new Zikir("Zikir Seçme, Zikirmatiğe gir", "(⭐❤⭐)", R.drawable.zikir);	zikir.add(Zikir	);
        Zikir Zikir1	= new Zikir("Estağfirullah", "(Tavsiye Edilen Sayı: En az 25 defa)", R.drawable.zikir);	zikir.add(Zikir1);
        Zikir Zikir2	= new Zikir("Bismillahi Subhanallahi ve Bihamdihi", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir2	);
        Zikir Zikir3	= new Zikir("Lâ ilâhe illallâhu vahdehu lâşerîke leh, lehu'l mülkü ve lehu'l hamdü ve hüve alâ külli şey'in kadîr", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir3	);
        Zikir Zikir4	= new Zikir("Lâ ilâhe illallâhu'l Melikül Hakkul Mübin", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir4	);
        Zikir Zikir5	= new Zikir("Lâ ilâhe illallah", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir5	);
        Zikir Zikir6	= new Zikir("Lâ Havle Velâ Kuvvete İllâ Billâh", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir6	);
        Zikir Zikir7	= new Zikir("Sübhânallahi ve bi–hamdihî sübhânallahi’l–azîm", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir7	);
        Zikir Zikir8	= new Zikir("Sübhânallâhi velhamdülillâhi velâ ilâhe illallahü vallâhü ekber", "(Hadis-i şeriflerde sayı belirtilmemiştir)", R.drawable.zikir);	zikir.add(Zikir8	);
        Zikir Zikir9	= new Zikir("SubhanAllah"	, "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir9	);
        Zikir Zikir10	= new Zikir("Subhanallahi ve bihamdihi adede halkıhi ve rıza nefsihi ve zinete arşihi ve midade kelimatihi", "(Tavsiye Edilen Sayı: En az 3 defa)", R.drawable.zikir);	zikir.add(Zikir10	);
        Zikir Zikir11	= new Zikir("Allâhumme Salli Alâ Muhammed", "(Hadis-i şeriflerde sayı belirtilmemiştir)", R.drawable.zikir);	zikir.add(Zikir11	);
        Zikir Zikir12	= new Zikir("Estağfirullâhe Ve Etûbu İleyh"	, "(Tavsiye Edilen Sayı: En az 70 defa)", R.drawable.zikir);	zikir.add(Zikir12	);
        Zikir Zikir13	= new Zikir("İhlas Suresi", "(Tavsiye Edilen Sayı: En az 100 defa)", R.drawable.zikir);	zikir.add(Zikir13	);


    }



}