package soft.bigeran.dervis.DergahBul;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.R;

public class DergahBulucu extends AppCompatActivity {

    private Button Yönetici,Dergahbul;
    private EditText Dergahtext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dergah_bulucu);



        Yönetici = (Button) findViewById(R.id.button4);
        Dergahbul = (Button) findViewById(R.id.button3);
        Dergahtext = (EditText) findViewById(R.id.editText);



        Dergahbul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Dergahtext.getText().length()>=1){
                    sendEmail();

                }else{

                    Toasty.error(getApplicationContext(),"En az 1 karakter olmalıdır!",Toast.LENGTH_SHORT).show();
                }

            }
        });


        Yönetici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openWhatsApp();
            }
        });




    }

    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"bigeran26@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "⭐Dergah Bul⭐");
        emailIntent.putExtra(Intent.EXTRA_TEXT, Dergahtext.getText().toString());

        try {
            Toasty.success(getApplicationContext(),"Email adresini ara ara kontrol ediniz!",Toast.LENGTH_LONG).show();

            startActivity(Intent.createChooser(emailIntent, "Email gönder..."));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toasty.error(DergahBulucu.this,
                    "Email yüklü değil.", Toast.LENGTH_SHORT).show();
        }
    }

    private void openWhatsApp() {
        String smsNumber = "905557539828";
        boolean isWhatsappInstalled = whatsappInstalledOrNot("com.whatsapp");
        if (isWhatsappInstalled) {

            Intent sendIntent = new Intent("android.intent.action.MAIN");
            sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber) + "@s.whatsapp.net");//phone number without "+" prefix

            startActivity(sendIntent);
        } else {
            Uri uri = Uri.parse("market://details?id=com.whatsapp");
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            Toasty.error(this, "WhatsApp yüklü değil",Toast.LENGTH_LONG).show();
            startActivity(goToMarket);
        }
    }

    private boolean whatsappInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        } catch (PackageManager.NameNotFoundException e) {
            app_installed = false;
        }
        return app_installed;
    }

}
