package soft.bigeran.dervis.MainFragments.TabNamazVakti.SubFragments;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import soft.bigeran.dervis.Interfaces.ListItemClickListener;
import soft.bigeran.dervis.MainFragments.BaseFragment;
import soft.bigeran.dervis.MainFragments.TabNamazVakti.Adapters.ImsakiyeAdapter;
import soft.bigeran.dervis.Models.PrayerTimeModels.PrayerTimes;

import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Singleton.PrayerTimesList;

import soft.bigeran.dervis.Utils.Config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ImsakiyeFragment extends BaseFragment
        implements ListItemClickListener, View.OnClickListener {

    View mView;
    private LinearLayoutManager mLayoutManager;
    private ImsakiyeAdapter imsakiyeAdapter;
    private String toolbarTitle;

    @BindView(R.id.txtToolbarTitle)
    TextView txtToolbarTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imgLeft)
    ImageView imgBack;

    @BindArray(R.array.months)
    String[] aylar;


    AsyncTask<Void, Void, Void> asyncInsertData;

    public static ImsakiyeFragment newInstance(String toolbarTitle) {
        Bundle args = new Bundle();
        args.putString("toolbarTitle", toolbarTitle);
        ImsakiyeFragment fragment = new ImsakiyeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        getActivity().findViewById(R.id.tabMainLayout).setVisibility(View.GONE);
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_imsakiye, container, false);
            ButterKnife.bind(this, mView);
            getItemsFromBundle();

            setToolbar();
            init();

            initRecyclerView();
            asyncInsertData = new AsyncInsertData().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }

        return mView;
    }

    private void init() {

        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(this);
    }

    private void getItemsFromBundle() {
        Bundle args = getArguments();
        if (args != null) {
            toolbarTitle = (String) args.get("toolbarTitle");
        }
    }

    private void initRecyclerView() {
        setLayoutManager();
        setAdapter();
    }

    private void setLayoutManager() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private void setAdapter() {
        imsakiyeAdapter = new ImsakiyeAdapter(getContext());
        recyclerView.setAdapter(imsakiyeAdapter);
        imsakiyeAdapter.setListItemClickListener(this);
    }

    private void setToolbar() {
        txtToolbarTitle.setText(Config.county.toUpperCase() + " " + toolbarTitle);
    }


    @Override
    public void onListItemClick(Object object, int clickedPosition) {

    }


    @Override
    public void onClick(View view) {

        if (view == imgBack) {
            getActivity().onBackPressed();
        }

    }


    /*****************************************************/
    private class AsyncInsertData extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            recyclerView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {

            Log.d("onInBackground()", "Data Inserting ");


            PrayerTimes[] prayerTimes = PrayerTimesList.getInstance().getPrayerTimes();
            final ArrayList<PrayerTimes> prayerTimesList = new ArrayList<PrayerTimes>();

            int currentDatePosition = 0;
            String formattedDate = getCurrentDate();

            for (int i = 0; i < prayerTimes.length; i++) {
                prayerTimesList.add(prayerTimes[i]);
                if (prayerTimes[i].getMiladiTarihKisa().equals(formattedDate)) {
                    currentDatePosition = i;
                }
            }

            final int finalCurrentDatePosition = currentDatePosition;
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // WORK on UI thread here
                    setUpRecyclerView(prayerTimesList);
                    recyclerView.scrollToPosition(finalCurrentDatePosition);
                }
            });


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }


        private void setUpRecyclerView(ArrayList<PrayerTimes> prayerTimesList) {
            if (prayerTimesList != null && prayerTimesList.size() > 0) {
                imsakiyeAdapter.addAll(prayerTimesList);
            }
        }

        private String getCurrentDate() {
            Date c = Calendar.getInstance().getTime();
            SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            return df.format(c);
        }


    }

    /*****************************************************/

    @Override
    public void onPause() {
        Log.i("onPause", "ok");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i("onStop", "ok");
        super.onStop();
    }

    @Override
    public void onDestroy() {

        //Fragment tamamen kill edildigi zaman cagrilir.
        if (asyncInsertData != null)
            asyncInsertData.cancel(true);
        Log.i("onDestroy", "ok");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i("onDestroyView", "ok");
        super.onDestroyView();
    }
}
