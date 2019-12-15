package soft.bigeran.dervis.Kütüphane;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.EsmaülHüsna.EsmaulHusna;
import soft.bigeran.dervis.HtmlGosterici.HtmlGosterici;
import soft.bigeran.dervis.Kütüphane.Mektubatlar.MektubatıRabbani.MektubatiRabbani;
import soft.bigeran.dervis.Kütüphane.İlmihaller.Safiilmihali.Safiİlmihali;
import soft.bigeran.dervis.Menüm.AnaMenu;
import soft.bigeran.dervis.PdfGörüntüleme.PdfGoruntuleme;
import soft.bigeran.dervis.R;



public class KutuphaneMenu extends AppCompatActivity {
    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExpListAdapterKutuphane adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kutuphane_menu);

        expListView = (ExpandableListView) findViewById(R.id.exp);
        veriYolla();

        adapter = new ExpListAdapterKutuphane(this, basliklar, icerik);

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
                if ((groupPosition==0))
                {
                    if ((childPosition==0))
                    {
                        startActivity(new Intent(KutuphaneMenu.this, TasavvufiEserler.class));
                        Animatoo.animateFade(KutuphaneMenu.this);
                    }

                }
                else if ((groupPosition==1)) {
                    if ((childPosition==0))
                    {
                        Intent i = new Intent(getApplicationContext(), Safiİlmihali.class);
                        startActivity(i);
                    }
                    else if ((childPosition==1)){
                        Kitap("tesbihatlar/safii","tesbihat1");
                    }
                    else if ((childPosition==2)){
                        Kitap("tesbihatlar/hanefii","tesbihat2");
                    }
                }
                else if ((groupPosition==2)){

                    if ((childPosition==0))
                    {
                        final String appPackageName ="adigeleon.com.nadiryayincilik"; // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                }
                return true;
            }
        });
    }
    private void Kitap(String Kitapadı,String Referans) {
        Intent i = new Intent(getApplicationContext(), KutuphaneGosterim.class);
        i.putExtra("Kitap",Kitapadı);
        i.putExtra("KitapReferans",Referans);
        startActivity(i);
    }

    private void Kitappdf(String Kitapadı,String Referans) {
        Intent i = new Intent(getApplicationContext(), PdfGoruntuleme.class);
        i.putExtra("Kitap",Kitapadı);
        i.putExtra("KitapReferans",Referans);
        startActivity(i);
    }
    public void veriYolla(){
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add("Tasavvufi Eserler");
        basliklar.add("ilmihal Bölümü");
        basliklar.add("Diğer Kitaplar");


        ArrayList<String> TasavvufiEserler = new ArrayList<String>();
        TasavvufiEserler.add("17 yazar 30 kitap vardır \n  \n Eklenmesini istediğiniz kitapları mail atınız  \n \n Giriş yapmak için tıklayınız");




        ArrayList<String> Ilmihal = new ArrayList<String>();
        Ilmihal.add("1.Şafi İlmihali");
        Ilmihal.add("2.Şafi tesbihatı");
        Ilmihal.add("3.Hanefi tesbihatı");


        ArrayList<String> Risale = new ArrayList<String>();
        Risale.add("1. Tefsir-i Nadiri");

        icerik.put(basliklar.get(0), TasavvufiEserler);
        icerik.put(basliklar.get(1), Ilmihal);
        icerik.put(basliklar.get(2), Risale);
        //icerik.put(basliklar.get(3), Divan);



    }


}