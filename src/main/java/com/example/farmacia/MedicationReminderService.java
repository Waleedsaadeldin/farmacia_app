package com.example.farmacia;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.time.LocalTime;

public class MedicationReminderService extends Service
{
    private static final String tag = "MedicationReminderService";
    public MedicationReminderService() {}

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d(tag, "MedicationReminderService Started");
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        String channelId = "my_channel_id";
//        String channelName = "My Notification Channel";
//        int importance = NotificationManager.IMPORTANCE_DEFAULT;
//        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
//        notificationManager.createNotificationChannel(channel);
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
//                .setSmallIcon(R.drawable.baseline_notifications_active_24)
//                .setContentTitle("Notification Title")
//                .setContentText("Farmacia Del Futuro")
//                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
//        Intent intent = new Intent(this, pharmacy.class);
//        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
//        builder.setContentIntent(pendingIntent);
//        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
//        builder.setVibrate(new long[]{100, 200, 300, 400});
//        notificationManager.notify(1, builder.build());
//        LocalTime currentTime = LocalTime.now();
//        LocalTime targetTime = LocalTime.of(3, 36);
//        if(currentTime.equals(targetTime))
//        {
//            try {
//                Thread.sleep(5000);
                Toast.makeText(this, "Ordered", Toast.LENGTH_SHORT).show();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

//        }

        return START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(tag, "MedicationReminderService Destroyed");
    }
}