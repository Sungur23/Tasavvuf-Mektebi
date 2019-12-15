package soft.bigeran.dervis.HtmlGosterici;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.widget.TextView;

import java.io.File;

import soft.bigeran.dervis.R;


public class HtmlGosterici extends AppCompatActivity {
    private android.webkit.WebView WebView;
    private TextView KitapReferans;

    SharedPreferences Kaydedici;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.html_gosterici);

        final Bundle extras = getIntent().getExtras();
        String value = extras.getString("KitapGönder");
        String value2 = "file:///android_asset/"+value+".html";


        //KitapReferans.setText(value2);

        WebView = (android.webkit.WebView) findViewById(R.id.webview);
        WebView.getSettings().setJavaScriptEnabled(true);
        WebView.setWebChromeClient(new WebChromeClient());
        WebView.getSettings().setDefaultTextEncodingName("utf-8");


        File file = new File(value2);

        if (file.exists()) {
            Log.d("WebView", value2);
        }
        Log.d("WebView", value2);

        WebView.loadUrl(value2);



    }



    @Override
    protected void onResume()
    {
        super.onResume();


    }

    @Override
    protected void onPause() {


        super.onPause();
    }

}
