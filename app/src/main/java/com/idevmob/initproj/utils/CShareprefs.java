package com.idevmob.initproj.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 *
 * PREFERENCE MANAGER
 *
*/

public class CShareprefs {

    private static final String PREF_NAME = AppConstants.PACKAGE_NAME+".PREF_NAME";
    private static final String KEY_VALUE = AppConstants.PACKAGE_NAME+".KEY_VALUE";

    private static CShareprefs sInstance;
    private final SharedPreferences mPref;

    private CShareprefs(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new CShareprefs(context);
        }
    }

    public static synchronized CShareprefs getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(CShareprefs.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setValue(long value) {
        mPref.edit()
                .putLong(KEY_VALUE, value)
                .commit();
    }

    public long getValue() {
        return mPref.getLong(KEY_VALUE, 0);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}