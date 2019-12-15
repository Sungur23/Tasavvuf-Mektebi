package soft.bigeran.dervis.Sadatikiram;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Sadatikiram.Model.Person;


public class SadatlarListe5 extends AppCompatActivity {
    private ArrayList<Person> persons;
    private ListView listView;
    private soft.bigeran.dervis.Sadatikiram.Adapter.SadatAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sadatlar_liste5);
        initialize();
        fillArrayList(persons);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {
                    String s = "d0";
                    Secim(s);
                } else if (position == 1) {
                    String s = "d1	";
                    Secim(s);
                } else if (position == 2) {
                    String s = "d2	";
                    Secim(s);
                } else if (position == 3) {
                    String s = "d3	";
                    Secim(s);
                } else if (position == 4) {
                    String s = "d4	";
                    Secim(s);
                } else if (position == 5) {
                    String s = "d5	";
                    Secim(s);
                } else if (position == 6) {
                    String s = "d6	";
                    Secim(s);
                } else if (position == 7) {
                    String s = "d7	";
                    Secim(s);
                } else if (position == 8) {
                    String s = "d8	";
                    Secim(s);
                } else if (position == 9) {
                    String s = "d9	";
                    Secim(s);
                } else if (position == 10) {
                    String s = "d10	";
                    Secim(s);
                } else if (position == 11) {
                    String s = "d11	";
                    Secim(s);
                } else if (position == 12) {
                    String s = "d12	";
                    Secim(s);
                } else if (position == 13) {
                    String s = "d13	";
                    Secim(s);
                } else if (position == 14) {
                    String s = "d14	";
                    Secim(s);
                } else if (position == 15) {
                    String s = "d15	";
                    Secim(s);
                } else if (position == 16) {
                    String s = "d16	";
                    Secim(s);
                } else if (position == 17) {
                    String s = "d17	";
                    Secim(s);
                } else if (position == 18) {
                    String s = "d18	";
                    Secim(s);
                } else if (position == 19) {
                    String s = "d19	";
                    Secim(s);
                } else if (position == 20) {
                    String s = "d20	";
                    Secim(s);
                } else if (position == 21) {
                    String s = "d21	";
                    Secim(s);
                } else if (position == 22) {
                    String s = "d22	";
                    Secim(s);
                } else if (position == 23) {
                    String s = "d23	";
                    Secim(s);
                } else if (position == 24) {
                    String s = "d24	";
                    Secim(s);
                } else if (position == 25) {
                    String s = "d25	";
                    Secim(s);
                } else if (position == 26) {
                    String s = "d26	";
                    Secim(s);
                } else if (position == 27) {
                    String s = "d27	";
                    Secim(s);
                } else if (position == 28) {
                    String s = "d28	";
                    Secim(s);
                } else if (position == 29) {
                    String s = "d29	";
                    Secim(s);
                } else if (position == 30) {
                    String s = "mahmut1";
                    Secim(s);
                } else if (position == 31) {
                    String s = "mahmut2";
                    Secim(s);
                } else if (position == 32) {
                    String s = "mahmut3";
                    Secim(s);
                } else if (position == 33) {
                    String s = "mahmut4";
                    Secim(s);
                } else if (position == 34) {
                    String s = "mahmut5";
                    Secim(s);
                } else if (position == 35) {
                    String s = "mahmut6";
                    Secim(s);
                }
            }
        });

    }

    private void initialize() {
        persons = new ArrayList<Person>();
        listView = (ListView) findViewById(R.id.person_list_view);
        listViewAdapter = new soft.bigeran.dervis.Sadatikiram.Adapter.SadatAdapter(SadatlarListe5.this,persons);
        listView.setAdapter(listViewAdapter);
    }
    private void Secim(String s) {
        Intent i = new Intent(getApplicationContext(), SadatlarGoster.class);
        i.putExtra("Değer2", s);
        startActivity(i);
    }

    private void fillArrayList(ArrayList<Person>persons){



        Person person	= new Person("	Hz. Muhammed Mustafa (S.a.v) "+1	, "(571-632)", R.drawable.mha);	persons.add(person	);
        Person person2	= new Person("	Hz. Ebû Bekir es-Sıddîk (R.a)"+2	, "(572-634)", R.drawable.photo19);	persons.add(person2	);
        Person person3	= new Person("	Hz. Selman-ı Farisi (R.a)"+3	, "(?-656)", R.drawable.photo21);	persons.add(person3	);
        Person person4	= new Person("	Hz. Kasım Bin Muhammed (R.a))"+4	, "(?-725)", R.drawable.photo61);	persons.add(person4	);
        Person person5	= new Person("	Hz. Cafer Es-Sadık (R.a))"+5	, "(702-765)", R.drawable.photo121);	persons.add(person5	);
        Person person6	= new Person("	Şeyh Ebu Yezid El-Bistami (K.s)"+6	, "(777-848)", R.drawable.photo121);	persons.add(person6	);
        Person person7	= new Person("	Şeyh Ebu Hasan El-Harkani (K.s)"+7	, "(963-1033)", R.drawable.photo121);	persons.add(person7	);
        Person person8	= new Person("	Şeyh Ebu Ali El-Farmedi (K.s)"+8	, "(1010-1084)", R.drawable.photo121);	persons.add(person8	);
        Person person9	= new Person("	Şeyh Hace Yusuf Hamedani (K.s)"+9	, "(1050-1140)", R.drawable.photo121);	persons.add(person9	);
        Person person10	= new Person("	Şeyh Abdülhalık-ı Gücdevani (K.s)"+10	, "(?-1220)", R.drawable.photo121);	persons.add(person10	);
        Person person11	= new Person("	Şeyh Arif Er-Rivegeri (K.s)"+11	, "(?-1315)", R.drawable.photo121);	persons.add(person11	);
        Person person12	= new Person("	Şeyh Mahmud İncir El-Fağnevi (K.s)"+12	, "(?-1315)", R.drawable.photo121);	persons.add(person12	);
        Person person13	= new Person("	Şeyh Ali Ramiteni (K.s)"+13	, "(?-1328)", R.drawable.photo121);	persons.add(person13	);
        Person person14	= new Person("	Şeyh Muhammed Baba Semmasi (K.s)"+14	, "(?-1354)", R.drawable.photo121);	persons.add(person14	);
        Person person15	= new Person("	Seyyid Emir-i Külal Hz."+15	, "(1284-1370)", R.drawable.photo121);	persons.add(person15	);
        Person person16	= new Person("	Şah-ı Nakşibendi Hz. (K.S.)"+16	, "(1318-1389)", R.drawable.tarikat2);	persons.add(person16	);
        Person person17	= new Person("	Şeyh Alaaddin Attar (K.s) "+17	, "(?-1400)", R.drawable.photo121);	persons.add(person17	);
        Person person18	= new Person("	Şeyh Yakub-u Çerhi (K.s)"+18	, "(?-1447)", R.drawable.photo121);	persons.add(person18	);
        Person person19	= new Person("	Şeyh Ubeydullah-ı Ahrar (K.s)"+19	, "(1403-1490)", R.drawable.photo121);	persons.add(person19	);
        Person person20	= new Person("	Şeyh Muhammed Zahid (K.s)"+20	, "(?-1530)", R.drawable.photo121);	persons.add(person20	);
        Person person21	= new Person("	Şeyh Derviş Muhammed (K.s)"+21	, "(?-1562)", R.drawable.photo121);	persons.add(person21	);
        Person person22	= new Person("	Şeyh Hacegi Muhammed Emkinegi (K.s)"+22	, "(1512-1599)", R.drawable.photo121);	persons.add(person22	);
        Person person23	= new Person("	Şeyh Muhammed Baki Billah (K.s)"+23	, "(1563-1603)", R.drawable.photo121);	persons.add(person23	);
        Person person24	= new Person("	Şeyh Ahmedi Faruki İmam-ı Rabbani (K.s)"+24	, "(1563-1624)", R.drawable.photo121);	persons.add(person24	);
        Person person25	= new Person("	Şeyh Muhammed Ma’sum Serhendi (K.s)"+25	, "(1599-1668)", R.drawable.photo121);	persons.add(person25	);
        Person person26	= new Person("	Şeyh Muhammed Seyfeddin (k.s)"+26	, "(1639-1684)", R.drawable.photo121);	persons.add(person26	);
        Person person27	= new Person("	Şeyh Nur Muhammed Bedvani (K.s)"+27	, "(?-1722)", R.drawable.photo121);	persons.add(person27	);
        Person person28	= new Person("	Şeyh Habibullah Can-ı Canan Mazhar (K.s)"+28	, "(1701-1781)", R.drawable.photo121);	persons.add(person28	);
        Person person29	= new Person("	Şeyh Abdullah Dehlevi (K.s)"+29	, "(1745-1824)", R.drawable.photo121);	persons.add(person29	);
        Person person30	= new Person("	Şeyh Mevlana Halid-i Bağdadi (K.s)"+30	, "(1770-1827)", R.drawable.photo121);	persons.add(person30	);
        Person person31	= new Person("    Mevlânâ Abdullâh el-Mücâvîr fî Beledillâh (K.s)"+31	, "(?-?)", R.drawable.photo121);	persons.add(person31	);
        Person person32	= new Person("	Mevlânâ Muhammed Mustafa İsmet Ğarîbullâh (K.s)"+32	, "(*)", R.drawable.photo121);	persons.add(person32	);
        Person person33	= new Person("	Mevlânâ Halîl Nûrullâh ez-Zeğravî (K.s)"+33	, "(*)", R.drawable.photo121);	persons.add(person33	);
        Person person34	= new Person("	Mevlânâ Ali Rızâ el-Bezzâz (K.s)"+34	, "(*)", R.drawable.photo121);	persons.add(person34	);
        Person person35	= new Person("	Mevlânâ Ali Haydar el-Ahıshavî (K.s)"+35	, "(*)", R.drawable.photo121);	persons.add(person35	);
        Person person36	= new Person("	Mevlânâ Mahmûd el-Ôfî (K.s)"+36	, "(-)", R.drawable.photo121);	persons.add(person36	);


    }

}