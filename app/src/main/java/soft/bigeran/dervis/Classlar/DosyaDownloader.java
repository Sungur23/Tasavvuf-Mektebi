package soft.bigeran.dervis.Classlar;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.kaopiz.kprogresshud.KProgressHUD;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import es.dmoral.toasty.Toasty;


public class DosyaDownloader extends AsyncTask<String, String, String>
{
    KProgressHUD hud;
    Activity activity;
    private String fileName;
    private String folder;

    public DosyaDownloader (Activity activity){
        this.activity = activity;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        hud = KProgressHUD.create(activity)
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
        String dosyaadı = strings[2];
        String klasöradı = strings[3];
        String path = strings[4];
        int count;
        try {
            URL url = new URL(f_url);
            URLConnection connection = url.openConnection();
            connection.connect();
            // getting file length
            int lengthOfFile = connection.getContentLength();
            InputStream input = new BufferedInputStream(url.openStream(), 8192);
            fileName = dosyaadı+filetype;

            String Klasöradı =klasöradı+"/";
            folder = Environment.getExternalStorageDirectory() + File.separator + "Tasavvuf Mektebi/"+Klasöradı;
            File directory = new File(folder);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Output stream to write file
            OutputStream output = new FileOutputStream(path);

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

        return "Izinleri vermediğiniz için dosyalar inmedi yada beklenmedik bir hata oluştu";
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

        Toasty.success(activity,
                message, Toast.LENGTH_LONG).show();
    }
}