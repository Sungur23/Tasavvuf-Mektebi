package soft.bigeran.dervis.Quran.MVP;

import android.content.Context;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;

import java.util.ArrayList;

import soft.bigeran.dervis.Quran.adapters.CustomSuggestionsAdapter;
import soft.bigeran.dervis.Quran.model.Surah;


public class QuranPresenter implements MVPPresenter.QuranPresenter {
    private ArrayList<Surah> suggestions;
    private CustomSuggestionsAdapter customSuggestionsAdapter;
    private MVPView.QuranView quranView;
    private Context context;
    private Fragment fragment;

    public QuranPresenter(Fragment fragment) {
        quranView = (MVPView.QuranView) fragment;
        this.fragment = fragment;
    }

    @Override
    public void prepareSearchAdapter(LayoutInflater inflater, ArrayList<Surah> surahs) {
        suggestions = surahs;

        try {
            if (suggestions == null){
                customSuggestionsAdapter = null;

            }else {
                customSuggestionsAdapter = new CustomSuggestionsAdapter(inflater,fragment);
                customSuggestionsAdapter.setSuggestions(suggestions);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        quranView.initializeSearchView(customSuggestionsAdapter);
    }
}
