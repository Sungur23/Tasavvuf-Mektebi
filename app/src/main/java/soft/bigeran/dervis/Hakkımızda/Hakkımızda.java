package soft.bigeran.dervis.Hakkımızda;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.github.florent37.diagonallayout.DiagonalLayout;
import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.RandomSort;

import de.hdodenhof.circleimageview.CircleImageView;
import soft.bigeran.dervis.Admin.Admin;
import soft.bigeran.dervis.R;

public class Hakkımızda extends AppCompatActivity implements View.OnClickListener {

    private DiagonalLayout mDiagonalLayout;
    private CircleImageView mAvatar;
    private Button mFb1;
    private Button mFb2;
    private RelativeLayout mMainActivity;
    private TextView mTelifyazı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diagonallayout_activity_main);
        initView();

        mTelifyazı.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animate_shrink_enter));

        Animator spruceAnimator2 = new Spruce
                .SpruceBuilder(mMainActivity)
                .sortWith(new RandomSort(/*interObjectDelay=*/20L))
                .animateWith(new Animator[]{DefaultAnimations.shrinkAnimator(mMainActivity, /*duration=*/1500)})
                .start();


    }

    private void initView() {
        mDiagonalLayout = (DiagonalLayout) findViewById(R.id.diagonalLayout);
        mAvatar = (CircleImageView) findViewById(R.id.avatar);
        mAvatar.setOnClickListener(this);
        mFb1 = (Button) findViewById(R.id.fb1);
        mFb1.setOnClickListener(this);
        mFb2 = (Button) findViewById(R.id.fb2);
        mFb2.setOnClickListener(this);
        mMainActivity = (RelativeLayout) findViewById(R.id.activity_main);
        mTelifyazı = (TextView) findViewById(R.id.telifyazı);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avatar:
                // TODO 19/11/16
                break;
            case R.id.fb1:

                Intent intent = new Intent(Hakkımızda.this, soft.bigeran.dervis.SanalKütüphane.Admin.class);

                startActivity(intent);
                break;
            case R.id.fb2:

                intent = new Intent(Hakkımızda.this, soft.bigeran.dervis.SanalKütüphane.Admin_Yazarlar.class);

                startActivity(intent);

                break;
            default:
                break;
        }
    }
}
