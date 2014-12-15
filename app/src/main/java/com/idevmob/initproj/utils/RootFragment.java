package com.idevmob.initproj.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class RootFragment extends Fragment {
    public String TAG = null;

    public String getTAG() {
        return TAG;
    }

    public String getBundleString(Bundle b, String key, String def)
    {
        String value = b.getString(key);
        if (value == null)
            value = def;
        return value;
    }

    public boolean getBundleBolean(Bundle b, String key, boolean def)
    {
        boolean value;
        try {
            value = b.getBoolean(key);
        } catch (Exception e) {
            value = def;
        }
        return value;
    }

    public int getBundleInt(Bundle b, String key, int def)
    {
        int value = b.getInt(key);
        if (value==0)
            value = def;
        return value;
    }
}
