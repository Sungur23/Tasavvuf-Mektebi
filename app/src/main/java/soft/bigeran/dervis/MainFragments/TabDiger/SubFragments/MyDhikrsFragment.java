package soft.bigeran.dervis.MainFragments.TabDiger.SubFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import soft.bigeran.dervis.MainFragments.BaseFragment;
import soft.bigeran.dervis.MainFragments.TabDiger.Adapters.MyDhikrsAdapter;
import soft.bigeran.dervis.MainFragments.TabDiger.SubFragments.Interfaces.DhikrReturnCallback;
import soft.bigeran.dervis.MainFragments.TabDiger.Utils.MyZikir;
import soft.bigeran.dervis.MainFragments.TabDiger.Utils.TinyDB;

import soft.bigeran.dervis.R;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import soft.bigeran.dervis.Constants.StringConstants;

@SuppressLint("ValidFragment")
public class MyDhikrsFragment extends BaseFragment {

    View mView;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.imgLeft)
    ImageView imgLeft;
    @BindView(R.id.txtToolbarTitle)
    TextView txtToolbarTitle;

    private MyDhikrsAdapter myDhikrsAdapter;
    private DhikrReturnCallback dhikrReturnCallback;

    public MyDhikrsFragment(DhikrReturnCallback dhikrReturnCallback) {
        this.dhikrReturnCallback = dhikrReturnCallback;
    }

    @Override
    public void onStart() {
        getActivity().findViewById(R.id.tabMainLayout).setVisibility(View.GONE);
        super.onStart();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_my_dhikrs, container, false);
            ButterKnife.bind(this, mView);
            init();
            addListeners();
            setDhikrAdapter();
        }

        return mView;
    }

    private void init() {
        imgLeft.setVisibility(View.VISIBLE);
        txtToolbarTitle.setText(getResources().getString(R.string.MY_DHIKR));

    }

    private void addListeners() {
        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void setDhikrAdapter(){
        TinyDB tinyDB = new TinyDB(getContext());
        ArrayList<Object> tempList = tinyDB.getListObject(StringConstants.MY_ZIKIRS, MyZikir.class);

        myDhikrsAdapter = new MyDhikrsAdapter(getContext(), tempList, new DhikrReturnCallback() {
            @Override
            public void onReturn(MyZikir myZikir) {
                dhikrReturnCallback.onReturn(myZikir);
                getActivity().onBackPressed();
            }
        });
        recyclerView.setAdapter(myDhikrsAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
