package soft.bigeran.dervis.MainFragments.TabKuran.JavaClasses;

import android.content.Context;
import android.os.AsyncTask;

import com.google.gson.Gson;
import soft.bigeran.dervis.Interfaces.OnEventListener;
import soft.bigeran.dervis.Models.TranslationModels.Translations;
import soft.bigeran.dervis.R;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TranslationsAsyncProcess extends AsyncTask<Context, Void, Translations> {

    private OnEventListener<Translations> mCallBack;
    private Exception mException;


    public TranslationsAsyncProcess(OnEventListener callback) {
        mCallBack = callback;
    }

    @Override
    protected Translations doInBackground(Context... contexts) {

        Context context = contexts[0];
        return setTranslations(context);
    }

    private Translations setTranslations(Context context) {
        InputStream raw = context.getResources().openRawResource(R.raw.quran_translation_list);
        Reader rd = new BufferedReader(new InputStreamReader(raw));
        // Now do the magic.
        return new Gson().fromJson(rd, Translations.class);
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mCallBack != null) {
            mCallBack.onTaskContinue();
        }
    }

    @Override
    protected void onPostExecute(Translations translations) {
        super.onPostExecute(translations);

        if (mCallBack != null) {
            if (mException == null) {
                mCallBack.onSuccess(translations);
            } else {
                mCallBack.onFailure(mException);
            }
        }

    }
}