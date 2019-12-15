package soft.bigeran.dervis.Tarikatlar;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.R;

public class Tarikatlar extends AppCompatActivity {

    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExpListAdapterTarikatlar adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarikatlar);

        expListView = (ExpandableListView) findViewById(R.id.exp);
        veriYolla();

        adapter = new soft.bigeran.dervis.Tarikatlar.ExpListAdapterTarikatlar(this,basliklar,icerik);
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
                        Tarikatlar(R.string.naksi1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.naksi2text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.naksi3text,R.drawable.bg_2);
                    } else if ((childPosition==3)){
                        Tarikatlar(R.string.naksi4text,R.drawable.bg_2);
                    }
                } else if ((groupPosition==1)){

                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.kadiri1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.kadiri2text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.kadiri3text,R.drawable.bg_2);
                    } else if ((childPosition==3)){
                        Tarikatlar(R.string.kadiri4text,R.drawable.bg_2);
                    }else if ((childPosition==4)){
                        Tarikatlar(R.string.kadiri5text,R.drawable.bg_2);
                    }
                } else if ((groupPosition==2)) {

                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.mevlevi1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.mevlevi2text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.mevlevi3text,R.drawable.bg_2);
                    } else if ((childPosition==3)){
                        Tarikatlar(R.string.mevlevi4text,R.drawable.bg_2);
                    }

                } else if ((groupPosition==3)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.sazeli1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.sazeli1text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.sazeli3text,R.drawable.bg_2);
                    } else if ((childPosition==3)){
                        Tarikatlar(R.string.sazeli4text,R.drawable.bg_2);
                    }
                } else if ((groupPosition==4)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.vefai1text,R.drawable.bg_2);
                    }
                } else if ((groupPosition==5)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.bedevi1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.bedevi2text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.bedevi3text,R.drawable.bg_2);
                    }
                }else if ((groupPosition==6)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.melami1text,R.drawable.bg_2);
                    }
                }else if ((groupPosition==7)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.rufai1text,R.drawable.bg_2);
                    } else if ((childPosition==1)){
                        Tarikatlar(R.string.rufai2text,R.drawable.bg_2);
                    } else if ((childPosition==2)){
                        Tarikatlar(R.string.rufai3text,R.drawable.bg_2);
                    } else if ((childPosition==3)){
                        Tarikatlar(R.string.rufai4text,R.drawable.bg_2);
                    }else if ((childPosition==4)){
                        Tarikatlar(R.string.rufai5text,R.drawable.bg_2);
                    }else if ((childPosition==5)){
                        Tarikatlar(R.string.rufai6text,R.drawable.bg_2);
                    }
                }else if ((groupPosition==8)){
                    if ((childPosition==0))
                    {
                        Tarikatlar(R.string.Celvetiyye1,R.drawable.bg_2);
                    }
                }

                return true;
            }
        });
    }



    private void Tarikatlar(int Tarikatyazıid,int Fotoid) {
        Intent i = new Intent(getApplicationContext(), TarikatGosterimi.class);
        i.putExtra("Tarikat",Tarikatyazıid);
        i.putExtra("Foto",Fotoid);
        startActivity(i);
    }


    public void veriYolla(){
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add((String) getText(R.string.tarikat1));
        basliklar.add((String) getText(R.string.tarikat2));
        basliklar.add((String) getText(R.string.tarikat3));
        basliklar.add((String) getText(R.string.tarikat4));
        basliklar.add((String) getText(R.string.tarikat5));
        basliklar.add((String) getText(R.string.tarikat6));
        basliklar.add((String) getText(R.string.tarikat7));
        basliklar.add((String) getText(R.string.tarikat8));
        basliklar.add("Celvetiyye ");


        ArrayList<String> Nakşibendi = new ArrayList<String>();
        Nakşibendi.add((String) getText(R.string.naksi1));
        Nakşibendi.add((String) getText(R.string.naksi2));
        Nakşibendi.add((String) getText(R.string.naksi3));
        Nakşibendi.add((String) getText(R.string.naksi4));

        ArrayList<String> Kadirilik = new ArrayList<String>();
        Kadirilik.add((String) getText(R.string.kadiri1));
        Kadirilik.add((String) getText(R.string.kadiri2));
        Kadirilik.add((String) getText(R.string.kadiri3));
        Kadirilik.add((String) getText(R.string.kadiri4));
        Kadirilik.add((String) getText(R.string.kadiri5));



        ArrayList<String> Mevlevi = new ArrayList<String>();
        Mevlevi.add((String) getText(R.string.mevlevi1));
        Mevlevi.add((String) getText(R.string.mevlevi2));
        Mevlevi.add((String) getText(R.string.mevlevi3));
        Mevlevi.add((String) getText(R.string.mevlevi4));

        ArrayList<String> Şazeliyye = new ArrayList<String>();
        Şazeliyye.add((String) getText(R.string.sazeli1));
        Şazeliyye.add((String) getText(R.string.sazeli2));
        Şazeliyye.add((String) getText(R.string.sazeli3));
        Şazeliyye.add((String) getText(R.string.sazeli4));


        ArrayList<String> Vefaiyye = new ArrayList<String>();
        Vefaiyye.add((String) getText(R.string.vefai1));


        ArrayList<String> Bedeviyye = new ArrayList<String>();
        Bedeviyye.add((String) getText(R.string.bedeviye1));
        Bedeviyye.add((String) getText(R.string.bedeviye2));
        Bedeviyye.add((String) getText(R.string.bedeviye3));

        ArrayList<String> Melamiler = new ArrayList<String>();
        Melamiler.add((String) getText(R.string.melami1));


        ArrayList<String> Rufaiyye = new ArrayList<String>();
        Rufaiyye.add((String) getText(R.string.rufai1));
        Rufaiyye.add((String) getText(R.string.rufai2));
        Rufaiyye.add((String) getText(R.string.rufai3));
        Rufaiyye.add((String) getText(R.string.rufai4));
        Rufaiyye.add((String) getText(R.string.rufai5));
        Rufaiyye.add((String) getText(R.string.rufai6));




        ArrayList<String> Celvetiyye = new ArrayList<String>();
        Celvetiyye.add("Hakkında");


        icerik.put(basliklar.get(0), Nakşibendi);
        icerik.put(basliklar.get(1), Kadirilik);
        icerik.put(basliklar.get(2), Mevlevi);
        icerik.put(basliklar.get(3), Şazeliyye);
        icerik.put(basliklar.get(4), Vefaiyye);
        icerik.put(basliklar.get(5), Bedeviyye);
        icerik.put(basliklar.get(6), Melamiler);
        icerik.put(basliklar.get(7), Rufaiyye);
        icerik.put(basliklar.get(8), Celvetiyye);



    }

}

