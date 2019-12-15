package soft.bigeran.dervis.Singleton;

import android.content.Context;
import android.os.AsyncTask;

import soft.bigeran.dervis.Interfaces.CompleteCallback;
import soft.bigeran.dervis.Interfaces.OnEventListener;
import soft.bigeran.dervis.MainFragments.TabNamazVakti.JavaClasses.PrayerAsyncProcess;
import soft.bigeran.dervis.Models.PrayerTimeModels.PrayerTimes;

public class PrayerTimesList {

    private static PrayerTimesList single_instance = null;
    private static CompleteCallback<PrayerTimes[]> mCompleteCallback;
    private static int mRequestType;
    private static String mIdentifier;
    private static boolean finished = false;
    private PrayerTimes[] prayerTimes;

    private PrayerTimesList() {
    }

    public static PrayerTimesList getInstance() {
        if (single_instance == null) {
            single_instance = new PrayerTimesList();
        }
        return single_instance;
    }

    public void getAsyncPrayerTimes(Context context, CompleteCallback<PrayerTimes[]> completeCallback, int requestType, String identifier) {

        mCompleteCallback = completeCallback;
        mRequestType = requestType;
        mIdentifier = identifier;

        startAsyncProcess(context);

    }

    public void setPrayerTimes(PrayerTimes[] prayerTimes) {
        this.prayerTimes = prayerTimes;
    }

    public PrayerTimes[] getPrayerTimes() {
        return prayerTimes;
    }

    public void startAsyncProcess(final Context context) {

        PrayerAsyncProcess prayerAsyncProcess = new PrayerAsyncProcess(new OnEventListener<PrayerTimes[]>() {

            @Override
            public void onSuccess(PrayerTimes[] prayerTimes) {
                finished = true;
                setPrayerTimes(prayerTimes);
                if (mCompleteCallback != null) {
                    mCompleteCallback.onComplete(prayerTimes);
                }
            }

            @Override
            public void onFailure(Exception e) {
                mCompleteCallback.onFailed(e);
            }

            @Override
            public void onTaskContinue() {

            }
        }, mRequestType, mIdentifier);

        prayerAsyncProcess.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);

    }

    public static boolean isFinished() {
        return finished;
    }

    public static void setFinished(boolean finished) {
        PrayerTimesList.finished = finished;
    }


    public static CompleteCallback<PrayerTimes[]> getCompleteCallback() {
        return mCompleteCallback;
    }

    public static void setCompleteCallback(CompleteCallback<PrayerTimes[]> mCompleteCallback) {
        PrayerTimesList.mCompleteCallback = mCompleteCallback;
    }
}
