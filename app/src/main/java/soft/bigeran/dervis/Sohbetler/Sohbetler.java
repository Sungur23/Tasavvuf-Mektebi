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


public class Sohbetler extends Activity {


    ExpandableListView expListView;
    ArrayList<String> basliklar;
    HashMap<String, ArrayList<String>> icerik;

    int lastPosition = -1;

    ExpListAdapterSohbetler adapter;
    SharedPreferences Kaydedicim;
    private TextView Reftasavvuf;


    public static String ApiYoutube = "AIzaSyB8IvnuT6cd-zPOvyPElEHAt4rW_vKCwgQ";//here you should use your api key for testing purpose you can use this api also
    public static String Max = "&maxResults=50&key="; //here you should use your channel id for testing purpose you can use this api also
    public static String MaxCanlı = "&eventType=live&maxResults=20&key="; //here you should use your channel id for testing purpose you can use this api also
    public static String TaslakKanal = "https://www.googleapis.com/youtube/v3/search?part=snippet&order=date&channelId=";
    public static String TaslakPlaylist = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId=";
    public static String TaslakCanlıYayın = "https://www.googleapis.com/youtube/v3/search?part=snippet&type=video&channelId=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sohbetler);

        expListView = (ExpandableListView) findViewById(R.id.exp);
        veriYolla();
        adapter = new ExpListAdapterSohbetler(this, basliklar, icerik);
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
                if ((groupPosition == 0)) {
                    if ((childPosition == 0)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Wnt68XDd4jruVyEHoDV4ts");
                    } else if ((childPosition == 1)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UrRsAmUSpEHN3e0CuR0ZuG");
                    } else if ((childPosition == 2)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XovsUGrd771__CBqYuj2sy");
                    } else if ((childPosition == 3)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1X_QMwhD5wijk20dK-e1SaZ");
                    } else if ((childPosition == 4)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Xb0SsyMTuihMgBMhDIsi-U");
                    } else if ((childPosition == 5)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UBOx6IOnWVbWzFRXnpt9al");
                    } else if ((childPosition == 6)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UXikaAIXmK4ME1ZBd8Pr28");
                    } else if ((childPosition == 7)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VXXYfFRr14VB7zLIEJnABD");
                    } else if ((childPosition == 8)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XH3Kdj2O2g9pGfQJ7MuvBd");
                    } else if ((childPosition == 9)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1W_glCqSqbwFvveSZd878K6");
                    } else if ((childPosition == 10)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VdYpJfwItdxSLtNiYpfrgi");
                    } else if ((childPosition == 11)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Uw2UMN1fD7gjgESERZDdHH");
                    } else if ((childPosition == 12)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1X5O0k6YTFRKwExV9fHt9JL");
                    } else if ((childPosition == 13)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1WHFzdKXIvgR8YSOMZ9Qptv");
                    } else if ((childPosition == 14)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Uy4AO459TzO64J4b7Rs2ac");
                    } else if ((childPosition == 15)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VOl7XxK1XAJybn6JLuYLBs");
                    } else if ((childPosition == 16)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1WmeqiRmYHUbVIvd-3WCiVb");
                    } else if ((childPosition == 17)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Xtd1wsxKXhft58YWjB_UV8");
                    } else if ((childPosition == 18)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1WrlkoFYVuivYc0TxgDkCiI");
                    } else if ((childPosition == 19)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XsU-S3qFX9ZenvZrZLO38I");
                    } else if ((childPosition == 20)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VualqfpNGrsj21aiUI2Bpm");
                    } else if ((childPosition == 21)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XxsGf8DNgilsZ6KtUQsIhb");
                    } else if ((childPosition == 22)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Wu2hhDGlpggoaDYOWSIMfk");
                    } else if ((childPosition == 23)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Umnaf6IRtpxwtUw6sZQdms");
                    } else if ((childPosition == 24)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1U9LxZjV3WMlPUXG1NpB2JB");
                    } else if ((childPosition == 25)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Wa9VbtRODl6VFNVSP1a10W");
                    } else if ((childPosition == 26)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UMUlz7eaPQgcN-USYgDSdM");
                    } else if ((childPosition == 27)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1URQA8eRdT3cyJEqbEj0tL0");
                    } else if ((childPosition == 28)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Udx4v7fiUxwUMYifr0heNC");
                    } else if ((childPosition == 29)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VWAtCry98T1ZL04mwvba1-");
                    } else if ((childPosition == 30)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1U99dmdViTe307WgoUkYoeg");
                    } else if ((childPosition == 31)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Xmdivz62Ego4EWsQqCNEMQ");
                    } else if ((childPosition == 32)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UzDgiKXObnGAg-qktXfRyR");
                    } else if ((childPosition == 33)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1WsN96h7k6AY0xnWEulsHkV");
                    } else if ((childPosition == 34)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XR-lgMsMD36YcbEC5si4VW");
                    } else if ((childPosition == 35)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1V-Yh5Emf8P-QP0knJUS7dX");
                    } else if ((childPosition == 36)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1V3fQvvhr6zoWGrNM049tF0");
                    } else if ((childPosition == 37)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1Vw1dWu-tobQSdA81sKc5c5");
                    } else if ((childPosition == 38)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1WeE3uFu6PYe5YFURcP8aqv");
                    } else if ((childPosition == 39)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VTYZI71_9pkUHErRNatCrY");
                    } else if ((childPosition == 40)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1UuH3a3SdR3Ep-pJsDPQSh3");
                    } else if ((childPosition == 41)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1VJcVhrlMABb5ZQ6Yy9u2Om");
                    } else if ((childPosition == 42)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1URGH-0ssPdcmUantaXYQ3B");
                    } else if ((childPosition == 43)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1W77ixH_s0TBnFr3W25F261");
                    } else if ((childPosition == 44)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1U0znjhTGmObSopTJg80-S1");
                    } else if ((childPosition == 45)) {
                        YoutubeLink("UC3QqKQIjA_MSjWnTpyByeGA", "PL1HL4WPXNP1XZebmANnm5NWOb-RV7Bdu7");
                    }
                } else if ((groupPosition == 1)) {

                    if ((childPosition == 0)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs-S0BY5SjCYMIUy1hxyrE8S");
                    } else if ((childPosition == 1)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9bl4giPw8Lv89hpR0PzD27");
                    } else if ((childPosition == 2)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9WdVqytQHHcxv8TmG0okZk");
                    } else if ((childPosition == 3)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs8B0yLIYvWQsCJmgvya32CH");
                    } else if ((childPosition == 4)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9bVJmyo4E-06OInAv4FI-E");
                    } else if ((childPosition == 5)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs-ljJe5UjhHCBepbzUi-BQp");
                    } else if ((childPosition == 6)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs-bblk0RqAKTa4iDCLKgr1Y");
                    } else if ((childPosition == 7)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs83ZT1FqjqpNAeqyQi73561");
                    } else if ((childPosition == 8)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs_tUIJOe4OPCvVL1WPorvh4");
                    } else if ((childPosition == 9)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs8jEBuv65nGGUvc7ilNzwIB");
                    } else if ((childPosition == 10)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9jKFSSER3ddMJk2xZoWugK");
                    } else if ((childPosition == 11)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs89Yz23CeNLRq66ExkKaYTF");
                    } else if ((childPosition == 12)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs-BliJrV8QiCGgv4rYiI9Dm");
                    } else if ((childPosition == 13)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs8K_8GQa_WesJS4B6fo3aN1");
                    } else if ((childPosition == 14)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs8KVP-1WPlNzLfIuwSENKuk");
                    } else if ((childPosition == 15)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs91_Qet2uc1WhNxBxpzM6cJ");
                    } else if ((childPosition == 16)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs_f545_UmtranRkSOp3b7lt");
                    } else if ((childPosition == 17)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9vppWutTarn5AjHDxLeImI");
                    } else if ((childPosition == 18)) {
                        YoutubeLink("UCouXr5O1VLkt2D2kS8LG-Cg", "PLUlKGi2Libs9nVX47DNw3W5ktaEthkQ9c");
                    }
                } else if ((groupPosition == 2)) {

                    if ((childPosition == 0)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJAWA_1nj9VoG0gkIqBsDe3d");
                    } else if ((childPosition == 1)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJCgc9oyTW7urBXTRawzg8-f");
                    } else if ((childPosition == 2)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJAvhDGXr5gTNeBwqSekukFN");
                    } else if ((childPosition == 3)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJDaM7ljJd611vbLCbHumrGF");
                    } else if ((childPosition == 4)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJAeEg5dcIqshcg8f_Pg-e7g");
                    } else if ((childPosition == 5)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJBgNzpSxEeFAs40k2_UlmLG");
                    } else if ((childPosition == 6)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJD5xHCb137zRQx7kg9_-8HS");
                    } else if ((childPosition == 7)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJC1zjoO0LFuCI7zjg-VSGrX");
                    } else if ((childPosition == 8)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJCT0drf8y7TwLXx9R1Z7NHU");
                    } else if ((childPosition == 9)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJAVJ_bV1aBrQ8vl8GqCbhqB");
                    } else if ((childPosition == 10)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJBRpLi98TpbJGyWm6k5NF7b");
                    } else if ((childPosition == 11)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJCVm9P0M5sskGzkWep4MQ13");
                    } else if ((childPosition == 12)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "UCmdgKI-BG0UP-9mfW6ALp8A");
                    } else if ((childPosition == 13)) {
                        YoutubeLink("UCmdgKI-BG0UP-9mfW6ALp8A", "PLFFCJT3XtpJBTcpcpXAeyW6SCYJXXx8OU");
                    }
                } else if ((groupPosition == 3)) {

                    if ((childPosition == 0)) {
                        YoutubeLink("UCefBfwXK03zAyT2I-pOREEQ", "PLo9MuUeCgGUdeFndN_QG14y8FKbDLvx2P");
                    } else if ((childPosition == 1)) {
                        YoutubeLink("UCPcNZP03EkT9fx3F3jln1Jg", "PL7MFT1lRLLXBrfdvn8mswD34K_vRBgcc4");
                    } else if ((childPosition == 2)) {
                        YoutubeLink("UC3ex3CLiJGIr7GeeRlB5rSQ", "PLtxcr99vPPkPQXiTC-NmZZ7x1WtHc15Ir");
                    } else if ((childPosition == 3)) {
                        YoutubeLink("UCuSKjcNMMFKEWyTpC903Oag", "PLU5arcumDXa8moB42rXW2wIE5yw5UY-t1");
                    } else if ((childPosition == 4)) {
                        YoutubeLink("UCHyHFDMO8Xbc_lr9t2I54kg", "PLHN64Youc6wQc3QwDTlblqlMQzz3fvTsm");
                    } else if ((childPosition == 5)) {
                        YoutubeLink("UCPN1s2htACdh-lytI97bJpw", "PLTXD3H2wB1ash1EOxSkkK1sa_C3Z1Wml4");
                    } else if ((childPosition == 6)) {
                        YoutubeLink("UCLcs3ydEs5m9KhzkugjdHaw", "PLYYoyO1pbYlicUl0ukF2BkFkM86YpX_X7");
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

        basliklar.add("Cübbeli Ahmed Hoca");
        basliklar.add("İhsan Şenocak Hoca");
        basliklar.add("Şeyh Ahmed el-Kadiri");
        basliklar.add("Şeyh Muhammed Konyevi");



        ArrayList<String> Cübbeli = new ArrayList<String>();
        Cübbeli.add("Ramazan Sohbetleri");
        Cübbeli.add("Kısa Sohbetler");
        Cübbeli.add("Mescit Sohbetler");
        Cübbeli.add("Duyurular");
        Cübbeli.add("Kandil Sohbetleri");
        Cübbeli.add("Hayrettin Karaman Reddiye");
        Cübbeli.add("Mehmet Görmez Reddiye");
        Cübbeli.add("Bursa Sohbetleri");
        Cübbeli.add("Mustafa Öztürk Reddiye");
        Cübbeli.add("Kavâidü-l Akâid Dersleri");
        Cübbeli.add("Temel Karamollaoğlu Reddiye");
        Cübbeli.add("Terğîb-ü Terhîb'den Hadîs-i Şerifler");
        Cübbeli.add("Mustafa İslamoğlu Reddiye");
        Cübbeli.add("Şehir Sohbetleri");
        Cübbeli.add("Dücane Cündioğlu Reddiye");
        Cübbeli.add("Mekke'nin Fethi");
        Cübbeli.add("Aşr-ı Şerifler & Kasideler");
        Cübbeli.add("Mukâbele");
        Cübbeli.add("Mustafa Karataş Reddiye");
        Cübbeli.add("Ulusal Kanal Yayınları");
        Cübbeli.add("Mehmet Okuyan Reddiye");
        Cübbeli.add("54 Farz Sohbetleri");
        Cübbeli.add("Şifa-i Şerif Dersleri");
        Cübbeli.add("Masum Bayraktar / FM TV Reddiye");
        Cübbeli.add("Bayraktar Bayraklı Reddiye");
        Cübbeli.add("Tebessüm Ettiren Nükteler");
        Cübbeli.add("İlhami Güler Reddiye");
        Cübbeli.add("Edip Yüksel Reddiye");
        Cübbeli.add("Nedim Şener Reddiye");
        Cübbeli.add("Özcan Yeniçeri Reddiye");
        Cübbeli.add("Numan Ali Han Reddiye");
        Cübbeli.add("Fatih Nurullah Reddiye");
        Cübbeli.add("İhsan Eliaçık Reddiye");
        Cübbeli.add("Abdülaziz Bayındır Reddiye");
        Cübbeli.add("Ramazan Kurtoğlu Reddiye");
        Cübbeli.add("Emre Dorman Reddiye");
        Cübbeli.add("Akit TV Reddiye");
        Cübbeli.add("Sait Hatipoğlu Reddiye");
        Cübbeli.add("Ertuğrul Özkök Reddiye");
        Cübbeli.add("Mektûbât-ı Rabbâniyye'den İ'tikâd Mektubları");
        Cübbeli.add("Ali Bardakoğlu Reddiye");
        Cübbeli.add("Ahmet Hakan Reddiye");
        Cübbeli.add("Haydar Baş Reddiye");
        Cübbeli.add("Hüseyin Atay Reddiye");
        Cübbeli.add("Mehmet Toprak Reddiye");
        Cübbeli.add("Caner Taslaman Reddiye");




        ArrayList<String> ihsanhoca = new ArrayList<String>();


        ihsanhoca.add("Kısa Sohbetler");
        ihsanhoca.add("Tefsir Dersleri");
        ihsanhoca.add("Mişkatu'l Mesabih (Hadis) Dersleri");
        ihsanhoca.add("Âyet Âyet Kur'an-ı Kerim");
        ihsanhoca.add("Reddiyeler");
        ihsanhoca.add("Hutbeler");
        ihsanhoca.add("Tv Proğramları");
        ihsanhoca.add("Kaside-i Bürde Şerhi");
        ihsanhoca.add("2014 - Fıkıh Dersleri");
        ihsanhoca.add("Oruç");
        ihsanhoca.add("Fetvahane");
        ihsanhoca.add("Mukaddimeler");
        ihsanhoca.add("Selefilik/Vahhabilik");
        ihsanhoca.add("Allah Resulu'nun (sav) Ufkunda");
        ihsanhoca.add("Namaz");
        ihsanhoca.add("Diriliş Buluşmaları");
        ihsanhoca.add("Sahabe Hayatları");
        ihsanhoca.add("2014 - Akaid Dersleri");
        ihsanhoca.add("2014 - Tefsir Dersleri");


        ArrayList<String> Ahmedelkadiri = new ArrayList<String>();


        Ahmedelkadiri.add("Fethu'r Rabbani Sohbetleri");
        Ahmedelkadiri.add("Kalplerin Keşfi");
        Ahmedelkadiri.add("Sohbetlerimiz");
        Ahmedelkadiri.add("Geylani Musiki Ekibi");
        Ahmedelkadiri.add("Ramazan Sohbetleri-2017");
        Ahmedelkadiri.add("Sahih-i Buhari Dersleri");
        Ahmedelkadiri.add("Zikirlerimiz");
        Ahmedelkadiri.add("İlahiler-Abdülkadir Geylani Eğitim ve Hizmet Vakfı");
        Ahmedelkadiri.add("Şeyh Ahmed el Kadiri- Perşembe Sohbetleri");
        Ahmedelkadiri.add("Etkinliklerimiz");
        Ahmedelkadiri.add("Şeyh Ahmed El Kadiri- Niyazi Mısri Divan Şerhleri");
        Ahmedelkadiri.add("Halaka-i Kadiri");
        Ahmedelkadiri.add("Şeyh Ahmed El Kadiri-Kuşeyri Risalesi");
        Ahmedelkadiri.add("Şeyh Ahmed El Kadiri-Hikem-i Ataiyye Sohbetleri");



        ArrayList<String> Konyevi = new ArrayList<String>();



        Konyevi.add("Gönül Sohbetleri");
        Konyevi.add("Karışık Sohbet ve İlahiler -1 ");
        Konyevi.add("Karışık Sohbet ve İlahiler -2 ");
        Konyevi.add("Karışık Sohbet ve İlahiler -3 ");
        Konyevi.add("Karışık Sohbet ve İlahiler -4 ");
        Konyevi.add("Karışık Sohbet ve İlahiler -5 ");
        Konyevi.add("Karışık Sohbet ve İlahiler -6 ");




        icerik.put(basliklar.get(0), Cübbeli);
        icerik.put(basliklar.get(1), ihsanhoca);
        icerik.put(basliklar.get(2), Ahmedelkadiri);
        icerik.put(basliklar.get(3), Konyevi);



    }


}
