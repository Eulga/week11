package com.example.week11;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FreeBR extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Intent intent2 = new Intent(context, Main5Activity.class);
        intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent2);
    }
}
