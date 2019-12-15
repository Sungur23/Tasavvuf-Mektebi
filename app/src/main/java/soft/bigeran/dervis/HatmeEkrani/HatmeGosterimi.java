package soft.bigeran.dervis.HatmeEkrani;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jaeger.library.StatusBarUtil;
import soft.bigeran.dervis.R;

public class HatmeGosterimi extends AppCompatActivity {
    private Button hatmeOkunuş,HatmeAnlamı;
    private LinearLayout OkunusveAnlamabutonlar;
    private TextView HatmeText;
    private ImageView Hatmeİmaj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hatme_gosterimi);
        StatusBarUtil.setTransparent(HatmeGosterimi.this);
        OkunusveAnlamabutonlar = (LinearLayout) findViewById(R.id.butonlayout);
        HatmeText = (TextView) findViewById(R.id.hatmetext);
        hatmeOkunuş = (Button) findViewById(R.id.Okunuşu);
        HatmeAnlamı = (Button) findViewById(R.id.Anlamı);

        Hatmeİmaj = (ImageView) findViewById(R.id.hatmeimaj);
        final Bundle extras = getIntent().getExtras();
        String value = extras.getString("Hatme");

        if (value.toString().equals("Hatme1")) {
            OkunusveAnlamabutonlar.setVisibility(View.GONE);
            HatmeText.setText(R.string.hatme1);
        } else if (value.toString().equals("Hatme2")) {
            OkunusveAnlamabutonlar.setVisibility(View.GONE);
            HatmeText.setText(R.string.hatme2);

        } else if (value.toString().equals("Hatme3")) {
            OkunusveAnlamabutonlar.setVisibility(View.GONE);
            HatmeText.setText(R.string.hatme3);
        } else if (value.toString().equals("Hatme4")) {
            OkunusveAnlamabutonlar.setVisibility(View.GONE);
            HatmeText.setText(R.string.hatme3adab);
        } else if (value.toString().equals("Hatme5")) {
            OkunusveAnlamabutonlar.setVisibility(View.VISIBLE);
            Hatmeİmaj.setImageResource(R.drawable.hatmene00002);
            HatmeText.setText(R.string.hatme4);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme4a);
                }
            });
            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme4);
                }
            });

        } else if (value.toString().equals("Hatme6")) {
            OkunusveAnlamabutonlar.setVisibility(View.VISIBLE);
            Hatmeİmaj.setImageResource(R.drawable.hatmene00003);
            HatmeText.setText(R.string.hatme5);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme5a);
                }
            });

            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme5);
                }
            });
        } else if (value.toString().equals("Hatme7")) {
            Hatmeİmaj.setImageResource(R.drawable.hatmene00001);
            HatmeText.setText(R.string.hatme6);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme6o);
                }
            });
            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme6);
                }
            });
        } else if (value.toString().equals("Hatme8")) {
            OkunusveAnlamabutonlar.setVisibility(View.VISIBLE);
            HatmeText.setText(R.string.hatme7);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme7o);
                }
            });

            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme7);
                }
            });
        } else if (value.toString().equals("Hatme9")) {
            OkunusveAnlamabutonlar.setVisibility(View.VISIBLE);
            HatmeText.setText(R.string.hatme8);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme8a);
                }
            });

            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme8);
                }
            });

        } else if (value.toString().equals("Hatme10")) {
            OkunusveAnlamabutonlar.setVisibility(View.VISIBLE);
            HatmeText.setText(R.string.hatme9);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme9a);
                }
            });
            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme9);
                }
            });
        } else if (value.toString().equals("Hatme11")) {
            HatmeText.setText(R.string.hatme10);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme10a);
                }
            });
            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme10);
                }
            });
        } else if (value.toString().equals("Hatme12")) {
            HatmeText.setText(R.string.hatme11);
            HatmeAnlamı.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme11a);
                }
            });
            hatmeOkunuş.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    HatmeText.setText(R.string.hatme11);
                }
            });
        }
    }

}
