package com.suhun.startstyleservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private String tag = MyService.class.getSimpleName();
    private Timer timer;
    private int myCounter, maxCounter;

    private class MyTask extends TimerTask{
        @Override
        public void run() {
            myCounter++;
            Log.d(tag, "-----*****MyService MyTask*****-----"+myCounter);
            if(myCounter > maxCounter){
                cancel();
            }
        }
    }

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
        myCounter = 0;
        maxCounter = 100;
        timer = new Timer();
        timer.schedule(new MyTask(), 100, 100);
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
        if(timer!=null){
            timer.cancel();
            timer.purge();
            timer = null;
        }
    }
}