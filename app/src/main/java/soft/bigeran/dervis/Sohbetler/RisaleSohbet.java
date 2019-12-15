package soft.bigeran.dervis.Sohbetler;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Youtube.Youtube;


public class RisaleSohbet extends Activity {


    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExplistAdapterRisale adapter;
    SharedPreferences Kaydedicim;
    private TextView Reftasavvuf;


    public static String ApiYoutube = "AIzaSyB8IvnuT6cd-zPOvyPElEHAt4rW_vKCwgQ";//here you should use your api key for testing purpose you can use this api also
    public static String Max = "&maxResults=50&key="; //here you should use your channel id for testing purpose you can use this api also
    public static String MaxCanlı = "&eventType=live&maxResults=20&key="; //here you should use your channel id for testing purpose you can use this api also
    public static String TaslakKanal = "https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&channelId=";
    public static String TaslakPlaylist = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=";
    private static String TaslakCanlıYayın = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&channelId=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.risale_sohbet);

        Kaydedicim = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        Reftasavvuf = (TextView) findViewById(R.id.reftasavvuf);

        Reftasavvuf.setText(Kaydedicim.getString("Dil","Tr"));

        expListView = (ExpandableListView) findViewById(R.id.exp);
        veriYolla();

        adapter = new ExplistAdapterRisale(this, basliklar, icerik);

        expListView.setAdapter(adapter);

        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                // TODO Auto-generated method stub
                if (lastPosition != -1 && lastPosition != groupPosition) {
                    expListView.collapseGroup(lastPosition);
                }
                lastPosition = groupPosition;
            }
        });

        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

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
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCccA_I9CNpWBqTVEQOZHYFK");
                    }
                    else if ((childPosition==1)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCdX1W_zdgOK_z9jom7o-iq9");
                    } else if ((childPosition==2)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCejLCf1G3zCRj1X2apr2G9t");
                    } else if ((childPosition==3)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCf1_YJi35UbfrH18d3hw2cl");
                    } else if ((childPosition==4)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCcADU4CDZ5qYbHrgj2QNndp");
                    }else if ((childPosition==5)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCfA8jjknQJ1rSVenePe4xT_");
                    }else if ((childPosition==6)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCdGx_SD-adjybn0MO6z1Yq4");
                    }else if ((childPosition==7)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCfgtJb7G6vmcLtzG20eHZNU");
                    }else if ((childPosition==8)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCdNiJYcZFq1mwVDf30zPaWr");
                    }else if ((childPosition==9)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCdFz3dMIvHqiRQD1iZrTklj");
                    }else if ((childPosition==10)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCeDsTefF_EUFqN_I4HKJXeU");
                    } else if ((childPosition==11)){
                        YoutubeLink("UCduJv_7n29cPYCqNzvLst4Q","PLy6iIZ9CAqCc03z_-FoFyj-h_EU_d3GXi");
                    }
                }

                else if ((groupPosition==1)){

                    if ((childPosition==0))
                    {
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLr7fQBYOY3KurCNmq1HRngOk32AiBzGKI");
                    } else if ((childPosition==1)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLd9ean0L6hh1TJr-jisdHec5jjRIhk5He");
                    } else if ((childPosition==2)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLd9ean0L6hh2fsIR5vZHsaZKI5C7BaXZi");
                    } else if ((childPosition==3)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLTI5KikB1_5UEwP4nERiakRChFAAlrF35");
                    } else if ((childPosition==4)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLFEE3A2C60E5A4B4A");
                    } else if ((childPosition==5)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PL8914DE3B6852B3A5");
                    } else if ((childPosition==6)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLmOl7lHG88Il92VoorGL1XFFGA4rdK1VX");
                    } else if ((childPosition==7)){
                        YoutubeLink("UCzxIoO_1mRPGqFlDDTfhUNg","PLr7fQBYOY3KurCNmq1HRngOk32AiBzGKI");
                    }
                }





                return true;
            }
        });



    }

    
    private void YoutubeLink(String Kanalurl,String Playlisturl) {
        Intent intent = new Intent(getApplicationContext(), Youtube.class);
        intent.putExtra("KanalUrl",TaslakKanal+Kanalurl+Max+ApiYoutube );
        //intent.putExtra("CanlıUrl",TaslakCanlıYayın+"UCmdgKI-BG0UP-9mfW6ALp8A"+MaxCanlı+ApiYoutube );
        intent.putExtra("PlaylistUrl",TaslakPlaylist+Playlisturl+Max+ApiYoutube );
        startActivity(intent);

    }
    


    public void veriYolla(){
        basliklar = new ArrayList<String>();
        icerik = new HashMap<String, ArrayList<String>>();

        basliklar.add("Uğur Akkafa");
        basliklar.add("Çantacı Necmi Abi ");



        ArrayList<String> Uğur = new ArrayList<String>();
        Uğur.add("Tüm Videolar");
        Uğur.add("İlk Önce İzlenmesi Gereken Sohbetler");
        Uğur.add("İzlemeniz gereken 5 Sohbet");
        Uğur.add("Kısa Sohbetler");
        Uğur.add("Bilmeniz Gereken Konular");
        Uğur.add("Akıl Açıcı Sohbetler");
        Uğur.add("Mutlaka İzlenmesi Gereken Sohbetler");
        Uğur.add("İlginç Konular");
        Uğur.add("Birde Bu Açıdan Bakın");
        Uğur.add("Bilinmesi Gereken 10 Konu");
        Uğur.add("Hayatınızı Değiştirecek 10 Sohbet");
        Uğur.add("Nur Mektebi Hikayeleri");


        ArrayList<String> Cantacı = new ArrayList<String>();


        Cantacı.add("Necmi Ağabey - Dersler ");
        Cantacı.add("Kısa Sohbetler");
        Cantacı.add("Uzay Haber Tv Sohbetleri");
        Cantacı.add("Necmeddin İlgen - Hazreti Mehdi (as)");
        Cantacı.add("Risale-i Nur'un intişarı");
        Cantacı.add("Risale-i Nur'un intişarı 2");
        Cantacı.add("Risale-i Nur'un intişarı 3");
        Cantacı.add("Konferanslar");





        icerik.put(basliklar.get(0), Uğur);
        icerik.put(basliklar.get(1), Cantacı);



    }


}
