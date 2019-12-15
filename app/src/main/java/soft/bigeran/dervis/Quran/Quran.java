package soft.bigeran.dervis.Quran;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Deneme.DosyaIndirici;
import soft.bigeran.dervis.Quran.ui.quran.QuranFragment;
import soft.bigeran.dervis.R;

public class Quran extends AppCompatActivity {

    KProgressHUD hud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quran_activity);


        File dataDirectory = Environment.getExternalStorageDirectory();
        File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Kur'an-ı Kerim/quraan.pdf");
        if(fileDir.exists()){
            if( savedInstanceState == null )
                changeFragment(new QuranFragment());
        }
        else{
            new DownloadFile().execute("https://drive.google.com/uc?export=download&id=140jKaQWb21A4sFdlzwljwHn4DRc-UOrM",".pdf");

        }

    }
    private class DownloadFile extends AsyncTask<String, String, String> {
        private String fileName;
        private String folder;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            hud = KProgressHUD.create(Quran.this)
                    .setStyle(KProgressHUD.Style.BAR_DETERMINATE)
                    .setDimAmount(0.5f)
                    .setLabel("Lütfen bekleyin")
                    .setDetailsLabel("Pdf dosyası İndiriliyor ")
                    .setMaxProgress(100)
                    .show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String f_url = strings[0];   // -> http://maven.apache.org/maven-1.x/maven.pdf
            String filetype = strings[1];
            int count;
            try {
                URL url = new URL(f_url);
                URLConnection connection = url.openConnection();
                connection.connect();
                // getting file length
                int lengthOfFile = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream(), 8192);
                fileName = "quraan"+filetype;

                folder = Environment.getExternalStorageDirectory() + File.separator + "Tasavvuf Mektebi/"+"/Kur'an-ı Kerim/";
                File directory = new File(folder);
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                // Output stream to write file
                OutputStream output = new FileOutputStream(folder + fileName);

                byte data[] = new byte[1024];

                long total = 0;

                while ((count = input.read(data)) != -1) {
                    total += count;
                    // publishing the progress....
                    // After this onProgressUpdate will be called
                    publishProgress("" + (int) ((total * 100) / lengthOfFile));
                    // Log.d(TAG, "Progress: " + (int) ((total * 100) / lengthOfFile));

                    // writing data to file
                    output.write(data, 0, count);
                }

                // flushing output
                output.flush();

                // closing streams
                output.close();
                input.close();
                return "Dosya şuraya indi : " + folder + fileName;

            } catch (Exception e) {
                Log.e("Error: ", e.getMessage());
            }

            return "Hata oluştu";
        }

        /**
         * Updating progress bar
         */
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            hud.setProgress(Integer.parseInt(progress[0]));
        }


        @Override
        protected void onPostExecute(String message) {
            // dismiss the dialog after the file was downloaded
            hud.dismiss();
            changeFragment(new QuranFragment());

            Toasty.success(getApplicationContext(),
                    message, Toast.LENGTH_LONG).show();
        }
    }


    private void changeFragment(Fragment targetFragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}


