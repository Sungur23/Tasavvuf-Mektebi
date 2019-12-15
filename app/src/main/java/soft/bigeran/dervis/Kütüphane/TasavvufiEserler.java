package soft.bigeran.dervis.Kütüphane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.HtmlGosterici.HtmlGosterici;
import soft.bigeran.dervis.Kütüphane.Mektubatlar.MektubatıRabbani.MektubatiRabbani;
import soft.bigeran.dervis.Kütüphane.İlmihaller.Safiilmihali.Safiİlmihali;
import soft.bigeran.dervis.PdfGörüntüleme.PdfGoruntuleme;
import soft.bigeran.dervis.R;

public class TasavvufiEserler extends AppCompatActivity {
    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExpListAdapterTasavvufiEserler adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasavvufi_eserler);

        expListView = (ExpandableListView) findViewById(R.id.exp);
        veriYolla();

        adapter = new ExpListAdapterTasavvufiEserler(this, basliklar, icerik);

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
                if ((groupPosition == 0)) {

                    if ((childPosition == 0)) {
                        Intent i = new Intent(getApplicationContext(), MektubatiRabbani.class);
                        startActivity(i);
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Mektubatlar/MevlanaHalid", "mektup1");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Mektubatlar/Seydayıtahi", "mektup2");
                    } else if ((childPosition == 3)) {
                        Kitap("kitaplar/Mektubatlar/Hazret", "mektup3");
                    } else if ((childPosition == 4)) {
                        Kitap("kitaplar/Mektubatlar/Ahmedhaznevi", "mektup4");
                    }

                } else if ((groupPosition == 1)) {
                    if ((childPosition == 0)) {
                        Kitap("kitaplar/İsbat'ün Nübüvve", "kitap1");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Mebde' ve Me'ad", "kitap2");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Mükâşefât-i Gaybiyye", "kitap3");
                    }else if ((childPosition == 3)) {
                        Intent i = new Intent(getApplicationContext(), MektubatiRabbani.class);
                        startActivity(i);
                    }


                } else if ((groupPosition == 2)) {


                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Risaleler/HalidiyeRisalesi1", "kitap12a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Risaleler/HalidiyeRisalesi2", "kitap12b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Risaleler/HalidiyeRisalesi3", "kitap12c");
                    } else if ((childPosition == 3)) {
                        Kitap("kitaplar/Risaleler/HalidiyeRisalesi4", "kitap12d");
                    }
                } else if ((groupPosition == 3)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Adabıfethullah1", "kitap4a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Adabıfethullah2", "kitap4b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Adabıfethullah3", "kitap4c");
                    }


                } else if ((groupPosition == 4)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Minah1", "kitap5a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Minah2", "kitap5b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Minah3", "kitap5c");
                    } else if ((childPosition == 3)) {
                        Kitap("kitaplar/Minah4", "kitap5d");
                    }else if ((childPosition == 4)) {
                        Kitap("kitaplar/Minah5", "kitap5e");
                    }else if ((childPosition == 5)) {
                        Kitap("kitaplar/Minah6", "kitap5f");
                    }


                }
                else if ((groupPosition == 5)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/İşaretitahi1", "kitap6a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/İşaretitahi2", "kitap6b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/İşaretitahi3", "kitap6c");
                    } else if ((childPosition == 3)) {
                        Kitap("kitaplar/İşaretitahi4", "kitap6d");
                    }else if ((childPosition == 4)) {
                        Kitap("kitaplar/İşaretitahi5", "kitap6e");
                    }else if ((childPosition == 5)) {
                        Kitap("kitaplar/İşaretitahi6", "kitap6f");
                    }else if ((childPosition == 6)) {
                        Kitap("kitaplar/İşaretitahi7", "kitap6g");
                    }else if ((childPosition == 7)) {
                        Kitap("kitaplar/İşaretitahi8", "kitap6m");
                    }


                }else if ((groupPosition == 6)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi1", "kitap11a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi2", "kitap11b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi3", "kitap11c");
                    } else if ((childPosition == 3)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi4", "kitap11d");
                    }else if ((childPosition == 4)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi5", "kitap11e");
                    }else if ((childPosition == 5)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi6", "kitap11f");
                    }else if ((childPosition == 6)) {
                        Kitap("kitaplar/Risaleler/KuşeyriRisalesi7", "kitap11g");
                    }

                }else if ((groupPosition == 7)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Risaleler/EyoğulRisalesi", "kitap13");
                    }

                }else if ((groupPosition == 8)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Avarif1", "kitap9a");
                    } else if ((childPosition == 1)) {
                        Kitap("kitaplar/Avarif2", "kitap9b");
                    } else if ((childPosition == 2)) {
                        Kitap("kitaplar/Avarif3", "kitap9c");
                    }

                }else if ((groupPosition == 9)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Hikemiataiye", "kitap7");
                    }

                }else if ((groupPosition == 10)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/Rabıtaitarika", "kitap10");
                    }
                }else if ((groupPosition == 11)) {

                    if ((childPosition == 0)) {
                        Kitap("kitaplar/ŞeytanınHileleri", "kitap8");
                    }
                }


                return true;



            }
        });
    }

    private void Kitap(String Kitapadı, String Referans) {
        Intent i = new Intent(getApplicationContext(), KutuphaneGosterim.class);
        i.putExtra("Kitap", Kitapadı);
        i.putExtra("KitapReferans", Referans);
        startActivity(i);
    }

    private void Kitappdf(String Kitapadı, String Referans) {
        Intent i = new Intent(getApplicationContext(), PdfGoruntuleme.class);
        i.putExtra("Kitap", Kitapadı);
        i.putExtra("KitapReferans", Referans);
        startActivity(i);
    }

    public void veriYolla() {
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add("Mektubatlar");
        basliklar.add("İmam-ı Rabbani (k.s)");
        basliklar.add("Mevlana Halid Zülcelaleyn (k.s)");
        basliklar.add("Fethullah-ı Verkanisi (k.s)");
        basliklar.add("Gavs-ı Hizani (k.s)");
        basliklar.add("Abdurrahman-ı Tagi (k.s)");
        basliklar.add("Imam-ı Kuşeyri (k.s)");
        basliklar.add("İmam-ı Gazeli (k.s)");
        basliklar.add("Şihabuddin Sühreverdi(k.s)");
        basliklar.add("İbn Ataullah el-İskenderi (k.s)");
        basliklar.add("Mehmet Fevzi (k.s)");
        basliklar.add("Muhiddin İbnül Arabi (k.s)");




        ArrayList<String> Mektubatlar = new ArrayList<String>();
        Mektubatlar.add("1. Mektubat-ı Rabbani");
        Mektubatlar.add("2. Mektubat-ı Mevlana Halid");
        Mektubatlar.add("3. Mektubat-ı Seyday-i Tagi");
        Mektubatlar.add("4. Mektubat-ı Hazret");
        Mektubatlar.add("5. Mektubat-ı Ahmed el-Haznevi");

        ArrayList<String> Imamırabani = new ArrayList<String>();
        Imamırabani.add("1. İsbat'ün Nübüvve");
        Imamırabani.add("2. Mebde' ve Me'ad");
        Imamırabani.add("3. Mükâşefât-i Gaybiyye");
        Imamırabani.add("4. Mektubat-ı Rabbani");

        ArrayList<String> Fethulllah = new ArrayList<String>();
        Fethulllah.add("1. Adab-ı Fethullah-I");
        Fethulllah.add("2. Adab-ı Fethullah-II");
        Fethulllah.add("3. Adab-ı Fethullah-III");


        ArrayList<String> Gavsıhizani = new ArrayList<String>();
        Gavsıhizani.add("1. Halid-i Öleki'nin Dilinden Gavs-ı Hizani");
        Gavsıhizani.add("2. Minah-I");
        Gavsıhizani.add("3. Minah-II");
        Gavsıhizani.add("4. Minah-III");
        Gavsıhizani.add("5. Minah-IV");
        Gavsıhizani.add("6. Atiyyeler");


        ArrayList<String> Abdurrahmanıtagi = new ArrayList<String>();
        Abdurrahmanıtagi.add("1. İşaret-i Tagi 1.Bölüm");
        Abdurrahmanıtagi.add("2. İşaret-i Tagi 2.Bölüm");
        Abdurrahmanıtagi.add("3. İşaret-i Tagi 3.Bölüm");
        Abdurrahmanıtagi.add("4. İşaret-i Tagi 4.Bölüm");
        Abdurrahmanıtagi.add("5. İşaret-i Tagi 5.Bölüm");
        Abdurrahmanıtagi.add("6. İşaret-i Tagi 6.Bölüm");
        Abdurrahmanıtagi.add("7. İşaret-i Tagi 7.Bölüm");
        Abdurrahmanıtagi.add("8. İşaret-i Tagi 8.Bölüm");


        ArrayList<String> ımamkuşeyri = new ArrayList<String>();
        ımamkuşeyri.add("1. Kuşeyri Risalesi 1.Bölüm");
        ımamkuşeyri.add("2. Kuşeyri Risalesi 2.Bölüm");
        ımamkuşeyri.add("3. Kuşeyri Risalesi 3.Bölüm");
        ımamkuşeyri.add("4. Kuşeyri Risalesi 4.Bölüm");
        ımamkuşeyri.add("5. Kuşeyri Risalesi 5.Bölüm");
        ımamkuşeyri.add("6. Kuşeyri Risalesi 6.Bölüm");
        ımamkuşeyri.add("7. Kuşeyri Risalesi 7.Bölüm");


        ArrayList<String> mevlanahalid = new ArrayList<String>();
        mevlanahalid.add("1. Halidiyye Risalesi-I");
        mevlanahalid.add("2. Halidiyye Risalesi-II");
        mevlanahalid.add("3. Halidiyye Risalesi-III");
        mevlanahalid.add("4. Halidiyye Risalesi-IV");



        ArrayList<String> x = new ArrayList<String>();
        x.add("1. Hikem-i Ataiyye");


        ArrayList<String> x2 = new ArrayList<String>();
        x2.add("1. Aynü'l-Hakîka fî Râbitati't-Tarîka");


        ArrayList<String> x3 = new ArrayList<String>();
        x3.add("1. Şeytanın Hileleri");


        ArrayList<String> x4 = new ArrayList<String>();
        x4.add("1. Ey Oğul Risalesi");


        ArrayList<String> Sühreverdi = new ArrayList<String>();
        Sühreverdi.add("1. Avarif-ül Me'Arif-I");
        Sühreverdi.add("2. Avarif-ül Me'Arif-II");
        Sühreverdi.add("3. Avarif-ül Me'Arif-III");



        icerik.put(basliklar.get(0), Mektubatlar);
        icerik.put(basliklar.get(1), Imamırabani);
        icerik.put(basliklar.get(2), mevlanahalid);
        icerik.put(basliklar.get(3), Fethulllah);
        icerik.put(basliklar.get(4), Gavsıhizani);
        icerik.put(basliklar.get(5), Abdurrahmanıtagi);
        icerik.put(basliklar.get(6), ımamkuşeyri);
        icerik.put(basliklar.get(7),x4);
        icerik.put(basliklar.get(8), Sühreverdi);
        icerik.put(basliklar.get(9), x);
        icerik.put(basliklar.get(10),x2);
        icerik.put(basliklar.get(11),x3);


    }
}


