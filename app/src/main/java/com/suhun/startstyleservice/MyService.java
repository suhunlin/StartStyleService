package com.suhun.startstyleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    String tag = MyService.class.getSimpleName();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.d(tag, "-----*****MyService onBind*****-----");
        return null;
    }

    @Override
    public void onCreate() {
        Log.d(tag, "-----*****MyService onCreate*****-----");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(tag, "-----*****MyService onStartCommand*****-----");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "-----*****MyService onDestroy*****-----");
    }
}