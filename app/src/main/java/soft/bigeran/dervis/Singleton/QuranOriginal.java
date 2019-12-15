package soft.bigeran.dervis.Singleton;

import android.content.Context;
import android.os.AsyncTask;

import soft.bigeran.dervis.Interfaces.CompleteCallback;
import soft.bigeran.dervis.Interfaces.OnEventListener;
import soft.bigeran.dervis.MainFragments.TabKuran.JavaClasses.QuranAsyncProcess;
import soft.bigeran.dervis.Models.QuranModels.Quran;

import soft.bigeran.dervis.Constants.NumericConstants;

public class QuranOriginal {

    private static QuranOriginal single_instance = null;
    private static CompleteCallback<Quran> mCompleteCallback;
    private static boolean finished = false;
    private Quran quranOriginal;

    private QuranOriginal(Context context) {
        parseJson(context);
    }

    public static QuranOriginal getInstance(Context context, CompleteCallback<Quran> completeCallback) {
        if (single_instance == null) {
            mCompleteCallback = completeCallback;
            single_instance = new QuranOriginal(context);
        }

        return single_instance;
    }

    public static QuranOriginal getInstance() {
        return single_instance;
    }

    public Quran getQuranOriginal() {
        return quranOriginal;
    }

    public void setQuranOriginal(Quran quranOriginal) {
        this.quranOriginal = quranOriginal;
    }

    private void parseJson(final Context context) {

        QuranAsyncProcess quranAsyncProcess = new QuranAsyncProcess(new OnEventListener<Quran>() {
            @Override
            public void onSuccess(Quran quran) {
                finished=true;
                setQuranOriginal(quran);
                if(mCompleteCallback != null){
                    mCompleteCallback.onComplete(quran);
                }

            }

            @Override
            public void onFailure(Exception e) {
                if(mCompleteCallback != null){
                    mCompleteCallback.onFailed(e);
                }
            }

            @Override
            public void onTaskContinue() {

            }
        }, NumericConstants.REQUEST_TYPE_QURAN_ORIGINAL, "");

        quranAsyncProcess.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);

    }

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean finished) {
        QuranOriginal.finished = finished;
    }


    public static CompleteCallback<Quran> getCompleteCallback() {
        return mCompleteCallback;
    }

    public static void setCompleteCallback(CompleteCallback<Quran> mCompleteCallback) {
        QuranOriginal.mCompleteCallback = mCompleteCallback;
    }
}
