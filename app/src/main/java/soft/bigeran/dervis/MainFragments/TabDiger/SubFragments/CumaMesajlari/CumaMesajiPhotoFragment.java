package soft.bigeran.dervis.MainFragments.TabDiger.SubFragments.CumaMesajlari;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import soft.bigeran.dervis.MainFragments.BaseFragment;
import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Utils.ToastMessageUtil;

import java.io.ByteArrayOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;



@SuppressLint("ValidFragment")
public class CumaMesajiPhotoFragment extends BaseFragment implements View.OnClickListener {

    View mView;

    @BindView(R.id.photoImgv)
    ImageView photoImgv;
    @BindView(R.id.shareWhatsappImgv)
    ImageView shareWhatsappImgv;

    private Bitmap bitmap;

    private static final int PERM_WRITE_EXT_STORAGE = 901;

    public CumaMesajiPhotoFragment(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_cuma_mesaji_photo, container, false);
            ButterKnife.bind(this, mView);
            setToolbar();
            setShapes();
            init();
        }

        return mView;
    }

    @Override
    public void onStart() {
        getActivity().findViewById(R.id.tabMainLayout).setVisibility(View.GONE);
        super.onStart();
    }

    private void setToolbar() {

    }

    private void setShapes() {

    }

    private void init() {
        shareWhatsappImgv.setOnClickListener(this);
        setImage();
    }

    private void checkPermission() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED) {
            onClickApp("com.whatsapp", bitmap);
        } else
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PERM_WRITE_EXT_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {

        if (requestCode == PERM_WRITE_EXT_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onClickApp("com.whatsapp", bitmap);
            }
        }
    }

    private void setImage() {
        Glide.with(getContext())
                .load(R.drawable.icon_whatsapp)
                .apply(RequestOptions.fitCenterTransform())
                .into(shareWhatsappImgv);

        Glide.with(getContext())
                .load(bitmap)
                .apply(RequestOptions.fitCenterTransform())
                .into(photoImgv);
    }

    public void onClickApp(String pack, Bitmap bitmap) {
        PackageManager pm = getContext().getPackageManager();
        try {
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
            String path = MediaStore.Images.Media.insertImage(getContext().getContentResolver(), bitmap, "Title", null);
            Uri imageUri = Uri.parse(path);

            @SuppressWarnings("unused")
            PackageInfo info = pm.getPackageInfo(pack, PackageManager.GET_META_DATA);

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("image/*");
            waIntent.setPackage(pack);
            waIntent.putExtra(android.content.Intent.EXTRA_STREAM, imageUri);
            getContext().startActivity(Intent.createChooser(waIntent, "Share with"));
        } catch (android.content.ActivityNotFoundException ex) {
            ToastMessageUtil.showToastShort(getContext(), getResources().getString(R.string.WHATSAPP_NOT_INSTALLED));
        } catch (Exception e) {
            ToastMessageUtil.showToastShort(getContext(), getResources().getString(R.string.UNEXPECTED_ERROR));
        }
    }

    @Override
    public void onClick(View view) {

        if (view == shareWhatsappImgv) {
            checkPermission();
        }
    }
}