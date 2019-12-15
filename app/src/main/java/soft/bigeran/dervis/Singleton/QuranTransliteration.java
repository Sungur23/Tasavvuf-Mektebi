package soft.bigeran.dervis.Singleton;

import android.content.Context;
import android.os.AsyncTask;

import soft.bigeran.dervis.Interfaces.CompleteCallback;
import soft.bigeran.dervis.Interfaces.OnEventListener;
import soft.bigeran.dervis.MainFragments.TabKuran.JavaClasses.QuranAsyncProcess;
import soft.bigeran.dervis.Models.QuranModels.Quran;

import soft.bigeran.dervis.Constants.NumericConstants;

public class QuranTransliteration {

    private static QuranTransliteration single_instance = null;
    private static CompleteCallback<Quran> mCompleteCallback;
    private static boolean finished = false;
    private Quran quranTransliteration;

    private QuranTransliteration(Context context, String lang) {
        parseJson(context, lang);
    }

    public static QuranTransliteration getInstance(Context context, String lang, CompleteCallback<Quran> completeCallback) {
        if (single_instance == null) {
            mCompleteCallback = completeCallback;
            single_instance = new QuranTransliteration(context, lang);
        }

        return single_instance;
    }

    public static QuranTransliteration getInstance() {
        return single_instance;
    }

    public Quran getQuranTransliteration() {
        return quranTransliteration;
    }

    public void setQuranTransliteration(Quran quranTransliteration) {
        this.quranTransliteration = quranTransliteration;
    }

    private void parseJson(final Context context, String lang) {

        QuranAsyncProcess quranAsyncProcess = new QuranAsyncProcess(new OnEventListener<Quran>() {
            @Override
            public void onSuccess(Quran quran) {
                finished = true;
                setQuranTransliteration(quran);
                if (mCompleteCallback != null) {
                    mCompleteCallback.onComplete(quran);
                }
            }

            @Override
            public void onFailure(Exception e) {
                if (mCompleteCallback != null) {
                    mCompleteCallback.onFailed(e);
                }
            }

            @Override
            public void onTaskContinue() {

            }
        }, NumericConstants.REQUEST_TYPE_QURAN_TRANSLITERATION, lang);

        quranAsyncProcess.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);

    }

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean isFinished) {
        QuranTransliteration.finished = isFinished;
    }

    public static CompleteCallback<Quran> getCompleteCallback() {
        return mCompleteCallback;
    }

    public static void setCompleteCallback(CompleteCallback<Quran> mCompleteCallback) {
        QuranTransliteration.mCompleteCallback = mCompleteCallback;
    }
}
