package soft.bigeran.dervis.MainFragments.TabKuran;

import android.os.AsyncTask;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import soft.bigeran.dervis.Interfaces.ListItemClickListener;
import soft.bigeran.dervis.MainFragments.BaseFragment;
import soft.bigeran.dervis.MainFragments.TabKuran.Adapters.SurahAdapter;
import soft.bigeran.dervis.MainFragments.TabKuran.SubFragments.SureDetayFragment;

import soft.bigeran.dervis.R;
import soft.bigeran.dervis.Singleton.QuranOriginal;
import soft.bigeran.dervis.Singleton.QuranTranslation;
import soft.bigeran.dervis.Singleton.QuranTransliteration;
import soft.bigeran.dervis.Utils.Config;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class KuranFragment extends BaseFragment implements ListItemClickListener {

    View mView;
    private LinearLayoutManager mLayoutManager;
    private SurahAdapter surahAdapter;

    @BindView(R.id.txtToolbarTitle)
    TextView txtToolbarTitle;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onStart() {
        getActivity().findViewById(R.id.tabMainLayout).setVisibility(View.VISIBLE);
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main_kuran, container, false);
            ButterKnife.bind(this, mView);

            setToolbar();
            initRecyclerView();
            new AsyncInsertData().execute();


            //setUpRecyclerView();

        }

        return mView;
    }

    private void setToolbar() {
        txtToolbarTitle.setText(getString(R.string.quran));
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
        surahAdapter = new SurahAdapter(getContext());
        recyclerView.setAdapter(surahAdapter);
        surahAdapter.setListItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onListItemClick(Object object, int clickedPosition) {
        mFragmentNavigation.pushFragment(SureDetayFragment.newInstance(clickedPosition));
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


            final String[] surahName = getResources().getStringArray(R.array.surah_name);
            final ArrayList<String> surahNameList = new ArrayList<String>();

            for (int i = 0; i < surahName.length; i++) {
                surahNameList.add(surahName[i]);
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // WORK on UI thread here
                    setUpRecyclerView(surahNameList);
                }
            });


            setQuranModels();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Log.d("MainActivity", "Data Inserted ");
            recyclerView.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }


        private void setUpRecyclerView(ArrayList<String> surahNameList) {

            if (surahNameList != null && surahNameList.size() > 0) {
                surahAdapter.addAll(surahNameList);
            }
        }

        private void setQuranModels() {

            QuranOriginal.getInstance(getActivity(), null);
            QuranTransliteration.getInstance(getActivity(), Config.transliterationlang,null);
            QuranTranslation.getInstance(getActivity(), Config.lang,null);

        }


    }

}