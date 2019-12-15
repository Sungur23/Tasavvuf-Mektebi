package soft.bigeran.dervis.Quran.MVP;

import soft.bigeran.dervis.Quran.adapters.CustomSuggestionsAdapter;


public interface MVPView {


    interface QuranView{
        void initializeSearchView(CustomSuggestionsAdapter adapter);
    }
}
