package com.example.administrator.jinworks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/10/26 0026.
 */

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        String msg = intent.getStringExtra("key");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
