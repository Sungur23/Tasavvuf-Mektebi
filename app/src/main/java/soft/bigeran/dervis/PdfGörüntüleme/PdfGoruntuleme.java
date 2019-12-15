package soft.bigeran.dervis.PdfGörüntüleme;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Deneme.Download;
import soft.bigeran.dervis.R;

public class PdfGoruntuleme extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {

    private PDFView PdfGörüntüleyici;
    SharedPreferences PdfKaydedicim;
    private TextView Refaranspdf;

    String Sanalkitapreferans,Sanalkitapadı;
    public Bundle Sanal,Genel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_goruntuleme);

        PdfGörüntüleyici=(PDFView)findViewById(R.id.pdfView);
        Refaranspdf=(TextView)findViewById(R.id.Referanspdf);
        PdfKaydedicim = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());



        Genel = getIntent().getExtras();

        if(((Genel.getString("Kitap")!=null))){
            String Referans = Genel.getString("KitapReferans");
            Refaranspdf.setText(Referans);
            String value = Genel.getString("Kitap");
            String value2 = value+".pdf";
            PdfAcıcıAsset(value2);

        }else if((Genel.getString("Kitapklasöryolu") != null)) {

            Sanalkitapreferans = Genel.getString("KitapReferans");
            Sanalkitapadı = Genel.getString("Kitapklasöryolu");
            Refaranspdf.setText(Sanalkitapreferans);

            File dataDirectory = Environment.getExternalStorageDirectory();
            File fileDir = new File(dataDirectory, Sanalkitapadı);
            PdfacıcıFile(fileDir);

        }



    }



    private void PdfAcıcıAsset(String value2) {
        PdfGörüntüleyici.fromAsset(value2)
                .defaultPage(PdfKaydedicim.getInt(Refaranspdf.getText().toString(),0))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();

    }

    private void PdfacıcıFile(File Pdfyolu) {
        PdfGörüntüleyici.fromFile(Pdfyolu)
                .defaultPage(PdfKaydedicim.getInt(Refaranspdf.getText().toString(),0))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();

    }

    @Override
    public void onPause() {
        //ring.stop();

        SharedPreferences.Editor editor = PdfKaydedicim.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putInt(Refaranspdf.getText().toString(),PdfGörüntüleyici.getCurrentPage()); //int değer ekleniyor
        Toasty.info(this, "En son okunan yer kaydedildi", Toast.LENGTH_SHORT, true).show();
        editor.commit(); //Kayıt
        super.onPause();

    }

    @Override
    public void onPageChanged(int page, int pageCount) {

    }

    @Override
    public void loadComplete(int nbPages) {

    }
}
