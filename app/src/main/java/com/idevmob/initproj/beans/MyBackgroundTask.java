package com.idevmob.initproj.beans;

import android.util.Log;

import com.idevmob.initproj.CApp;
import com.idevmob.initproj.utils.AppConstants;

import org.androidannotations.annotations.App;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.UiThread;

@EBean
public class MyBackgroundTask {
    @App
    CApp application;

    @Background
    void doSomethingInBackground() {
        String result = "XXX";
        updateUI(result);
    }

    // Notice that we manipulate the activity ref only from the UI thread
    @UiThread
    void updateUI(String result) {
        Log.i(AppConstants.TAG,"updateUI dans le MyBackgroundTask");
    }
}