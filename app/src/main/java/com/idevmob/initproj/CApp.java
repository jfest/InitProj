package com.idevmob.initproj;

import android.app.Application;
import android.util.Log;
import com.idevmob.initproj.utils.AppConstants;
import com.idevmob.initproj.utils.EfficientCache;
import com.idevmob.initproj.utils.Utils;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

@EApplication
public class CApp extends Application {

    public EfficientCache appCache;
    public String DEVICE_ID = null;

    public void onCreate() {
        super.onCreate();
        Log.i(AppConstants.TAG, "MyApp onCreate");

        initSomeStuff();
    }

    @Background
    void initSomeStuff() {
        // init some stuff in background
        appCache = new EfficientCache(AppConstants.INIT_CACHE_SIZE);
        DEVICE_ID = Utils.getDeviceId(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onLowMemory(){
        // clean memory
    }
}
