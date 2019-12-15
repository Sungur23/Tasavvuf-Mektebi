package soft.bigeran.dervis.Quran.ui.quran;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import soft.bigeran.dervis.Deneme.Download;
import soft.bigeran.dervis.Deneme.FileDownloader;
import soft.bigeran.dervis.Quran.MVP.MVPPresenter;
import soft.bigeran.dervis.Quran.MVP.MVPView;
import soft.bigeran.dervis.Quran.MVP.QuranPresenter;
import soft.bigeran.dervis.Quran.Quran;
import soft.bigeran.dervis.Quran.adapters.CustomSuggestionsAdapter;
import soft.bigeran.dervis.Quran.interfaces.OnSearchItemClick;
import soft.bigeran.dervis.Quran.model.Surah;
import soft.bigeran.dervis.R;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class QuranFragment extends Fragment implements MVPView.QuranView, OnPageChangeListener,OnLoadCompleteListener, OnSearchItemClick {

    private View view;
    private static final String TAG = Quran.class.getSimpleName();
    public static final String SAMPLE_FILE = "quraan.pdf";
    PDFView pdfView;
    File pdfFileName;
    private ArrayList<Surah> surahs;
    private LayoutInflater inflater;

    private MaterialSearchBar searchBar;
    private CustomSuggestionsAdapter customSuggestionsAdapter;
    private MVPPresenter.QuranPresenter presenter;
    private MediaPlayer ring;


    private SharedPreferences kaydet;

    public QuranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.quran_fragment, container, false);

        //playSound();//it will play allhu akbar sound
        initializeAll();
        kaydet = PreferenceManager.getDefaultSharedPreferences(getContext());

        return view;
    }

    private void initializeAll() {
        //ring= MediaPlayer.create(getContext(),R.raw.notification);
        pdfView = view.findViewById(R.id.pdfView);
        surahs = new ArrayList<>();

        inflater = (LayoutInflater) getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        searchBar = view.findViewById(R.id.searchBar);

        presenter = new QuranPresenter(this);






    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        File dataDirectory = Environment.getExternalStorageDirectory();
        File fileDir = new File(dataDirectory, "Tasavvuf Mektebi" + "/Kur'an-ı Kerim/quraan.pdf");
        displayfromfile(fileDir,kaydet.getInt("Sayfa",0));//default pdf will be start from 0 page

        try {
            searchBar.setMaxSuggestionCount(2);
            searchBar.setHint("Sure bul");

            searchBar.addTextChangeListener(textWatcher);

        }catch (Exception e){
            e.printStackTrace();
        }

    }



    private void displayfromfile(File fileyolu, int pageNumber) {
        pdfFileName = fileyolu;

        pdfView.fromFile(pdfFileName)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this.getContext()))
                .load();

    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        getActivity().setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }


    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");


    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {

            surahs.add(new Surah(b.getTitle(),b.getPageIdx()));
            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }

        presenter.prepareSearchAdapter(inflater,surahs);


    }



    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {
                // send the entered text to our filter and let it manage everything
                customSuggestionsAdapter.getFilter().filter(searchBar.getText());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    @Override
    public void initializeSearchView(CustomSuggestionsAdapter adapter) {
        if (adapter != null) {
            try {
                searchBar.setCustomSuggestionAdapter(adapter);
                this.customSuggestionsAdapter = adapter;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSearchItemClick(String indexNo) {
        searchBar.disableSearch();
        pdfView.jumpTo(Integer.parseInt(indexNo));
    }
    //public void playSound(){
        //if (!ring.isPlaying()) {
            //ring.start();}
    //}
    @Override
    public void onPause() {
        //ring.stop();

        SharedPreferences.Editor editor = kaydet.edit(); //SharedPreferences'a kayıt eklemek için editor oluşturuyoruz
        editor.putInt("Sayfa",pdfView.getCurrentPage()); //int değer ekleniyor
        editor.commit(); //Kayıt
        super.onPause();

    }
}
