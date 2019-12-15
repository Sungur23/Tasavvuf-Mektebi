package soft.bigeran.dervis.MainFragments.TabNamazVakti.Notify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DeletePendingIntent extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("neredeyiz", "DeletePendingIntent");
        String notificationId = intent.getStringExtra("_id");
        Notification.NotificationDBHelper mDbHelper = new Notification.NotificationDBHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        db.delete(Notification.NotificationEntry.TABLE_NAME, Notification.NotificationEntry._ID+" = "+notificationId,null);
        db.close();
    }
}
