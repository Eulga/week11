package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int NAPNOTI = 1;
    NotificationManager mNotiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.napalarm);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mNotiManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel notificationChannel = new NotificationChannel("my_alarm_channel", "알람테스트", NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription("알람테스트");
            mNotiManager.createNotificationChannel(notificationChannel);
        }
    }

    public void mOnClick(View v) {
        Toast.makeText(this, "안녕히 주무세요", Toast.LENGTH_LONG).show();
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent content = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                Notification noti = new NotificationCompat.Builder(MainActivity.this, "my_alarm_channel")
                        .setTicker("일어나세요")
                        .setContentTitle("기상 시간")
                        .setContentText("일어나! 일할 시간이야")
                        .setSubText("일을 해야 돈을 벌고 돈을 벌어야 밥먹고 살지!!")
                        .setSmallIcon(R.drawable.napalarm)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.harubang))
                        .setContentIntent(content)
                        .build();

                mNotiManager.notify(MainActivity.NAPNOTI, noti);
            }
        }, 5 * 1000);
    }
}
