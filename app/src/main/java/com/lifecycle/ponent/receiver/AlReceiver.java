package com.lifecycle.ponent.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.lifecycle.ponent.R;
import com.lifecycle.ponent.MainActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * 接收广播
 */
public class AlReceiver extends BroadcastReceiver {
    private NotificationManager notificationManager;
    private static final Random random = new Random(System.currentTimeMillis());

    @Override
    public void onReceive(Context context, Intent intent) {
        notificationManager = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        //>=8.0要加上channelId
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "default";
            String channelName = "默认通知";
            notificationManager.createNotificationChannel(new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH));
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentText("content..." + getPrintTime(System.currentTimeMillis()));
        builder.setTicker("ticker");
        builder.setContentTitle(context.getString(R.string.app_name));
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        Intent backIntent = new Intent(context, MainActivity.class);
        backIntent.setPackage(context.getPackageName());
        backIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent contentIntent = PendingIntent.getActivity(
                context, random.nextInt(), backIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        notificationManager.notify(1, builder.build());
    }

    public static SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static String getPrintTime(long time) {
        return DEFAULT_DATE_FORMAT.format(new Date(time));
    }

}
