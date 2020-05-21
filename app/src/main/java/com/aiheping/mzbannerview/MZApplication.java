package com.aiheping.mzbannerview;

import android.app.Application;

/**
 * Created by aiheping on 20/5/21.
 */

public class MZApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
       //ANR检测
       // new ANRWatchDog().start();
    }
}
