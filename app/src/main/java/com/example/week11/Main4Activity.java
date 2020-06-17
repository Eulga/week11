package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detectfree);

        FreeBR br = new FreeBR();
        IntentFilter filter = new IntentFilter();
        filter.addAction("myBR");
        registerReceiver(br, filter);
    }

    public void mOnClick(View v) {
        Intent intent = new Intent();
        intent.setAction("myBR");
        sendBroadcast(intent);
    }
}
