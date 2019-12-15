package soft.bigeran.dervis.Tarikatlar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import soft.bigeran.dervis.R;

public class TarikatGosterimi extends AppCompatActivity {
    private TextView Yazım;
    private ImageView Tarikatımaj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tarikat_gosterimi);
        Yazım = (TextView) findViewById(R.id.yaz);
        Tarikatımaj = (ImageView) findViewById(R.id.tarikatimaj);
        final Bundle extras = getIntent().getExtras();
        int Tarikat = extras.getInt("Tarikat");
        int foto = extras.getInt("Foto");
        Tarikatımaj.setImageResource(foto);
        Yazım.setText(Tarikat);
    }
}
