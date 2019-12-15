package soft.bigeran.dervis.Quran.MVP;

import android.view.LayoutInflater;

import java.util.ArrayList;

import soft.bigeran.dervis.Quran.model.Surah;

public interface MVPPresenter {


    interface QuranPresenter{
        void prepareSearchAdapter(LayoutInflater inflater, ArrayList<Surah> surahs);
    }
}
