package soft.bigeran.dervis.Tasavvuf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.R;


public class Tasavvuf extends AppCompatActivity {

    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExpListAdapterTasavvuf adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasavvuf);

        expListView = (ExpandableListView) findViewById(R.id.exp);
        SharedPreferences mPrefs = getSharedPreferences("Ayarlar",0);
        String dilsecimi = mPrefs.getString("SettingSecim","tr");

        if (dilsecimi.equals("tr")||(dilsecimi.equals(""))){

            veriYollatr();

        }else if (dilsecimi.equals("en")){
            veriYollaen();

        }

        adapter = new soft.bigeran.dervis.Tasavvuf.ExpListAdapterTasavvuf(this,basliklar,icerik);
        expListView.setAdapter(adapter);

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO Auto-generated method stub
                if (lastPosition != -1 && lastPosition != groupPosition) {
                    expListView.collapseGroup(lastPosition);
                }
                lastPosition = groupPosition;
            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int arg0) {
                // TODO Auto-generated method stub

            }
        });
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                //Nothing here ever fires

                if ((groupPosition==0))
                {
                    if ((childPosition==0))
                    {
                        Tasavvuf("bilgi/ta1");
                    } else if ((childPosition==1)){
                        Tasavvuf("bilgi/ta2");
                    } else if ((childPosition==2)){
                        Tasavvuf("bilgi/ta3");
                    } else if ((childPosition==3)){
                        Tasavvuf("bilgi/ta4");
                    } else if ((childPosition==4)){
                        Tasavvuf("bilgi/ta5");
                    } else if ((childPosition==5)){
                        Tasavvuf("bilgi/ta6");
                    } else if ((childPosition==6)){
                        Tasavvuf("bilgi/ta7");
                    } else if ((childPosition==7)){
                        Tasavvuf("bilgi/ta8");
                    } else if ((childPosition==8)){
                        Tasavvuf("bilgi/ta9");
                    } else if ((childPosition==9)){
                        Tasavvuf("bilgi/ta10");
                    } else if ((childPosition==10)){
                        Tasavvuf("bilgi/ta11");
                    } else if ((childPosition==11)){
                        Tasavvuf("bilgi/ta12");
                    } else if ((childPosition==12)){
                        Tasavvuf("bilgi/ta13");
                    } else if ((childPosition==13)){
                        Tasavvuf("bilgi/ta14");
                    } else if ((childPosition==14)){
                        Tasavvuf("bilgi/ta15");
                    } else if ((childPosition==15)){
                        Tasavvuf("bilgi/ta16");
                    } else if ((childPosition==16)){
                        Tasavvuf("bilgi/ta17");
                    }

                } else if ((groupPosition==1)){

                    if ((childPosition==0))
                    {
                        Tasavvuf("zikir/zi1");
                    } else if ((childPosition==1)){
                        Tasavvuf("zikir/zi2");
                    } else if ((childPosition==2)){
                        Tasavvuf("zikir/zi3");
                    } else if ((childPosition==3)){
                        Tasavvuf("zikir/zi4");
                    } else if ((childPosition==4)){
                        Tasavvuf("zikir/zi5");
                    } else if ((childPosition==5)){
                        Tasavvuf("zikir/zi6");
                    } else if ((childPosition==6)){
                        Tasavvuf("zikir/zi7");
                    } else if ((childPosition==7)){
                        Tasavvuf("zikir/zi8");
                    } else if ((childPosition==8)){
                        Tasavvuf("zikir/zi9");
                    } else if ((childPosition==9)){
                        Tasavvuf("zikir/zi10");
                    }
                } else if ((groupPosition==2)) {
                    if ((childPosition==0))
                    {
                        Tasavvuf("Rabıta/ra1");
                    } else if ((childPosition==1)){
                        Tasavvuf("Rabıta/ra2");
                    } else if ((childPosition==2)){
                        Tasavvuf("Rabıta/ra3");
                    } else if ((childPosition==3)){
                        Tasavvuf("Rabıta/ra4");
                    }

                } else if ((groupPosition==3)){

                    if ((childPosition==0))
                    {
                        Tasavvuf("Sorular/so1");
                    } else if ((childPosition==1)){
                        Tasavvuf("Sorular/so2");
                    } else if ((childPosition==2)){
                        Tasavvuf("Sorular/so3");
                    } else if ((childPosition==3)){
                        Tasavvuf("Sorular/so4");
                    }
                } else if ((groupPosition==4)){
                    if ((childPosition==0))
                    {
                        Tasavvuf("Velayet/ve1");
                    } else if ((childPosition==1)){
                        Tasavvuf("Velayet/ve2");
                    } else if ((childPosition==2)){
                        Tasavvuf("Velayet/ve3");
                    }
                }
                return true;
            }
        });



    }


    private void Tasavvuf(String Konu) {
        Intent i = new Intent(getApplicationContext(), TasavvufGosterimi.class);
        i.putExtra("Tasavvuf",Konu);
        startActivity(i);
    }


    public void veriYollatr(){
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add((String) getText(R.string.tasavvufbilgi0));
        basliklar.add((String) getText(R.string.tasavvufzikir0));
        basliklar.add("Rabıta Bölümü");
        basliklar.add("Soru-Cevap");
        basliklar.add("Nefs ve Velayet");



        ArrayList<String> Tasavvuf = new ArrayList<String>();
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi1));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi2));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi3));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi4));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi5));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi6));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi8));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi7));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi9));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi11));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi10));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi12));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi13));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi14));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi15));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi16));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi17));

        ArrayList<String> Zikir = new ArrayList<String>();
        Zikir.add((String) getText(R.string.tasavvufzikir1));
        Zikir.add((String) getText(R.string.tasavvufzikir2));
        Zikir.add((String) getText(R.string.tasavvufzikir3));
        Zikir.add("4. Zikir Terbiyede Rolü-3");
        Zikir.add("5. Zikir Sıkça Sorulan Sorular ");
        Zikir.add("6. Lafz-ı Celal Zikri-1");
        Zikir.add("7. Lafz-ı Celal Zikri-2");
        Zikir.add("8. Lafz-ı Celal Zikri-3");
        Zikir.add("9. Letaifler-1");
        Zikir.add("10. Letaifler-2");





        ArrayList<String> Rabıta = new ArrayList<String>();
        Rabıta.add("1. Rabıta Nedir?");
        Rabıta.add("2. Ölüm Rabıtası Nedir?");
        Rabıta.add("3. Mürşid Rabıtası Nedir?");
        Rabıta.add("4. Murakabe Nedir? ");

        ArrayList<String> Soru = new ArrayList<String>();
        Soru.add("1. Tasavvuf İle İlgili Sorular");
        Soru.add("2. Tarikat İlgili Meseleler");
        Soru.add("3. Mürşid-Şeyh Soruları");
        Soru.add("4. Seyr-i Süluk Soruları");


        ArrayList<String> Velayet = new ArrayList<String>();
        Velayet.add("1. Nefsin Mertebeleri");
        Velayet.add("2. Velayet Nedir?");
        Velayet.add("3. Velayet Mertebeleri");
        icerik.put(basliklar.get(0), Tasavvuf);
        icerik.put(basliklar.get(1), Zikir);
        icerik.put(basliklar.get(2), Rabıta);
        icerik.put(basliklar.get(3), Soru);
        icerik.put(basliklar.get(4), Velayet);



    }
    public void veriYollaen(){
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add((String) getText(R.string.tasavvufbilgi0));
        basliklar.add((String) getText(R.string.tasavvufzikir0));


        ArrayList<String> Tasavvuf = new ArrayList<String>();
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi1));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi2));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi3));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi4));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi5));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi6));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi8));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi7));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi9));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi11));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi10));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi12));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi13));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi14));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi15));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi16));
        Tasavvuf.add((String) getText(R.string.tasavvufbilgi17));

        ArrayList<String> Zikir = new ArrayList<String>();
        Zikir.add((String) getText(R.string.tasavvufzikir1));
        Zikir.add((String) getText(R.string.tasavvufzikir2));
        Zikir.add((String) getText(R.string.tasavvufzikir3));

        icerik.put(basliklar.get(0), Tasavvuf);
        icerik.put(basliklar.get(1), Zikir);



    }


}

