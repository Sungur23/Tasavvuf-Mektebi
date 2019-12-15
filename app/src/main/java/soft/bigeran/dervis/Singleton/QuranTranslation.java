package soft.bigeran.dervis.Singleton;

import android.content.Context;
import android.os.AsyncTask;

import soft.bigeran.dervis.Interfaces.CompleteCallback;
import soft.bigeran.dervis.Interfaces.OnEventListener;
import soft.bigeran.dervis.MainFragments.TabKuran.JavaClasses.QuranAsyncProcess;
import soft.bigeran.dervis.Models.QuranModels.Quran;
import soft.bigeran.dervis.Utils.Config;

import soft.bigeran.dervis.Constants.NumericConstants;

public class QuranTranslation {

    private static QuranTranslation single_instance = null;
    private static CompleteCallback<Quran> mCompleteCallback;
    private static boolean finished = false;
    private Quran quranTranslation;

    private QuranTranslation(Context context, String lang) {
        parseJson(context, lang);
    }

    public static QuranTranslation getInstance(Context context, String lang, CompleteCallback<Quran> completeCallback) {
        if (single_instance == null) {
            mCompleteCallback = completeCallback;
            single_instance = new QuranTranslation(context, lang);
        }

        return single_instance;
    }

    public static QuranTranslation getInstance() {
        return single_instance;
    }

    public Quran getQuranTranslation() {
        return quranTranslation;
    }

    public void setQuranTranslation(Quran quranOriginal) {
        this.quranTranslation = quranOriginal;
    }

    private void parseJson(final Context context, String lang) {

        int requestType;
        if (lang.equals(Config.defaultLang)) {
            requestType = NumericConstants.REQUEST_TYPE_QURAN_TRANSLATION_DEFAULT;
        } else {
            requestType = NumericConstants.REQUEST_TYPE_QURAN_TRANSLATION_OTHER;
        }

        QuranAsyncProcess quranAsyncProcess = new QuranAsyncProcess(new OnEventListener<Quran>() {
            @Override
            public void onSuccess(Quran quran) {
                finished = true;
                setQuranTranslation(quran);
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
        }, requestType, lang);

        quranAsyncProcess.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);

    }

    public static void reset() {
        single_instance = null;
    }

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean finished) {
        QuranTranslation.finished = finished;
    }

    public static CompleteCallback<Quran> getCompleteCallback() {
        return mCompleteCallback;
    }

    public static void setCompleteCallback(CompleteCallback<Quran> mCompleteCallback) {
        QuranTranslation.mCompleteCallback = mCompleteCallback;
    }
}
