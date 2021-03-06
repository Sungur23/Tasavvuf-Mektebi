package soft.bigeran.dervis;

import android.content.Intent;
import android.graphics.PorterDuff;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import soft.bigeran.dervis.FragmentControllers.FragNavController;
import soft.bigeran.dervis.FragmentControllers.FragmentHistory;
import soft.bigeran.dervis.HatmeEkrani.HatmeAnaEkrani;
import soft.bigeran.dervis.MainFragments.BaseFragment;
import soft.bigeran.dervis.MainFragments.TabKuran.KuranFragment;
import soft.bigeran.dervis.MainFragments.TabNamazVakti.NamazVaktiFragment;
import soft.bigeran.dervis.MainFragments.TabDiger.DigerFragment;



import soft.bigeran.dervis.Singleton.TranslationList;
import soft.bigeran.dervis.Utils.Config;
import soft.bigeran.dervis.Utils.Utils;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import fr.castorflex.android.smoothprogressbar.SmoothProgressBar;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends FragmentActivity
        implements BaseFragment.FragmentNavigation,
        FragNavController.TransactionListener,
        FragNavController.RootFragmentListener {

    @BindView(R.id.content_frame)
    FrameLayout contentFrame;
    @BindArray(R.array.tab_name)
    String[] TABS;
    @BindView(R.id.bottom_tab_layout)
    TabLayout bottomTabLayout;
    @BindView(R.id.tabMainLayout)
    LinearLayout tabMainLayout;

    @BindView(R.id.llSharing)
    LinearLayout llSharing;
    @BindView(R.id.smoothProgressBar)
    SmoothProgressBar smoothProgressBar;

    private int[] mTabIconsSelected = {
            R.drawable.tab_quran,
            R.drawable.tab_mosque,
            R.drawable.icon_more
    };

    private FragNavController mNavController;
    private FragmentHistory fragmentHistory;
    private TextView tabDescription;

    private int initialTabIndex = 1;
    private int selectedTabColor, unSelectedTabColor;
    public static String PACKAGE_NAME;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mainnamaz);
        ButterKnife.bind(this);
        Fabric.with(this, new Crashlytics());

        PACKAGE_NAME = getApplicationContext().getPackageName();
        unSelectedTabColor = this.getResources().getColor(R.color.DarkGray);
        selectedTabColor = this.getResources().getColor(R.color.fab_color_pressed);

        initToolbar();
        initTab();

        fragmentHistory = new FragmentHistory();

        mNavController = FragNavController.newBuilder(savedInstanceState, getSupportFragmentManager(), R.id.content_frame)
                .transactionListener(this)
                .rootFragmentListener(this, TABS.length)
                .selectedTabIndex(FragNavController.TAB2)
                .build();

        bottomTabLayout.getTabAt(initialTabIndex).select();
        switchTab(initialTabIndex);
        updateTabSelection(initialTabIndex);


        bottomTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabSelectionControl(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                mNavController.clearStack();
                tabSelectionControl(tab);
            }
        });

        setSharedPreferences();
        setLanguageList();


    }

    private void setLanguageList() {
        TranslationList.getInstance(getBaseContext());
    }

    private void setSharedPreferences() {
        Config config = new Config();
        config.load(this);
    }

    private void initToolbar() {
        /*
        setSupportActionBar(toolbar);
        */
    }

    public void tabSelectionControl(TabLayout.Tab tab) {
        fragmentHistory.push(tab.getPosition());
        switchAndUpdateTabSelection(tab.getPosition());
    }

    private void initTab() {
        if (bottomTabLayout != null) {
            for (int i = 0; i < TABS.length; i++) {
                bottomTabLayout.addTab(bottomTabLayout.newTab());
                TabLayout.Tab tab = bottomTabLayout.getTabAt(i);

                if(tab != null) {
                    tab.setIcon(mTabIconsSelected[i]);
                    tab.setText(TABS[i]);
                }
/*
                if (tab != null)
                    tab.setCustomView(getTabView(i));*/
            }
            bottomTabLayout.getTabAt(initialTabIndex).getIcon().setColorFilter(selectedTabColor, PorterDuff.Mode.SRC_IN);
            //bottomTabLayout.setTabTextColors(unSelectedTabColor, selectedTabColor);

        }

    }


    private View getTabView(int position) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_item_bottom, null);
        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);
        icon.setImageDrawable(Utils.setDrawableSelector(MainActivity.this, mTabIconsSelected[position], mTabIconsSelected[position]));
        tabDescription = (TextView) view.findViewById(R.id.tabDesc);
        tabDescription.setText(TABS[position]);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    private void switchTab(int position) {
        mNavController.switchTab(position);

        updateTab(position);
//      updateToolbarTitle(position);
    }

    private void updateTab(int position) {

        for (int i = 0; i < TABS.length; i++) {
            TabLayout.Tab selectedTab = bottomTabLayout.getTabAt(i);
/*
            View customView = selectedTab.getCustomView();
            TextView tabDescription = (TextView) customView.findViewById(R.id.tabDesc);
            ImageView icon = (ImageView) customView.findViewById(R.id.tab_icon);

            if (position != i) {
                icon.setColorFilter(ContextCompat.getColor(this, R.color.gray), android.graphics.PorterDuff.Mode.SRC_IN);
                tabDescription.setTextColor(getResources().getColor(R.color.gray));
            } else {
                icon.setColorFilter(ContextCompat.getColor(this, R.color.fab_color_pressed), android.graphics.PorterDuff.Mode.SRC_IN);
                tabDescription.setTextColor(getResources().getColor(R.color.fab_color_pressed));
            }

            */
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (!mNavController.isRootFragment()) {
            mNavController.popFragment();
        } else {
            if (fragmentHistory.isEmpty()) {
                super.onBackPressed();
                startActivity(new Intent(soft.bigeran.dervis.MainActivity.this, soft.bigeran.dervis.AnaEkran.MainActivity.class));
                Animatoo.animateFade(soft.bigeran.dervis.MainActivity.this);
            } else {
                if (fragmentHistory.getStackSize() > 1) {
                    int position = fragmentHistory.popPrevious();
                    switchAndUpdateTabSelection(position);
                } else {
                    switchAndUpdateTabSelection(initialTabIndex);
                    fragmentHistory.emptyStack();
                }
            }
        }
    }

    public void switchAndUpdateTabSelection(int position) {
        switchTab(position);
        updateTabSelection(position);
    }

    private void updateTabSelection(int currentTab) {

        for (int i = 0; i < TABS.length; i++) {
            TabLayout.Tab selectedTab = bottomTabLayout.getTabAt(i);

            if (currentTab != i) {
                //selectedTab.getCustomView().setSelected(false);
                selectedTab.getIcon().setColorFilter(unSelectedTabColor, PorterDuff.Mode.SRC_IN);
            } else {
                //selectedTab.getCustomView().setSelected(true);
                selectedTab.getIcon().setColorFilter(selectedTabColor, PorterDuff.Mode.SRC_IN);
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mNavController != null) {
            mNavController.onSaveInstanceState(outState);
        }
    }

    @Override
    public void pushFragment(Fragment fragment) {
        if (mNavController != null) {
            mNavController.pushFragment(fragment);
        }
    }

    @Override
    public void pushFragment(Fragment fragment, String animationTag) {

    }


    @Override
    public void onTabTransaction(Fragment fragment, int index) {
        // If we have a backstack, show the back button
        /*
        if (getSupportActionBar() != null && mNavController != null) {
            updateToolbar();
        }
        */
    }

    private void updateToolbar() {
        /*
        getSupportActionBar().setDisplayHomeAsUpEnabled(!mNavController.isRootFragment());
        getSupportActionBar().setDisplayShowHomeEnabled(!mNavController.isRootFragment());
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        */
    }

    @Override
    public void onFragmentTransaction(Fragment fragment, FragNavController.TransactionType transactionType) {
        //do fragmentty stuff. Maybe change title, I'm not going to tell you how to live your life
        // If we have a backstack, show the back button
        /*
        if (getSupportActionBar() != null && mNavController != null) {
            updateToolbar();
        }
        */
    }

    @Override
    public Fragment getRootFragment(int index) {
        switch (index) {

            case FragNavController.TAB1:
                return new KuranFragment();
            case FragNavController.TAB2:
                return new NamazVaktiFragment();
            case FragNavController.TAB3:
                return new DigerFragment();

        }
        throw new IllegalStateException("Need to send an index that we know");
    }

//    private void updateToolbarTitle(int position){
//        getSupportActionBar().setTitle(TABS[position]);
//    }

    public void updateToolbarTitle(String title) {
        /*
        getSupportActionBar().setTitle(title);
        */
    }

    public void startProgressBar() {

        //smoothProgressBar.setSmoothProgressDrawableInterpolator(new FastOutSlowInInterpolator());
        //smoothProgressBar.setSmoothProgressDrawableColors(getResources().getIntArray(R.array.gplus_colors));
        //smoothProgressBar.setSmoothProgressDrawableInterpolator(new AccelerateInterpolator());
        //smoothProgressBar.setSmoothProgressDrawableMirrorMode(true);
        //smoothProgressBar.setSmoothProgressDrawableReversed(true);

        llSharing.setVisibility(View.VISIBLE);
        smoothProgressBar.progressiveStart();
    }

    public void stopProgressBar() {
        llSharing.setVisibility(View.GONE);
        smoothProgressBar.progressiveStop();
    }

    public void reSelectCurrentTab() {
        TabLayout.Tab tabAt = bottomTabLayout.getTabAt(bottomTabLayout.getSelectedTabPosition());
        mNavController.clearStack();
        tabSelectionControl(tabAt);
    }

}
