package com.idevmob.initproj.utils;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String getDeviceId(Context ctx) {
        String id = android.provider.Settings.System.getString(ctx.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        return id;
    }


    public static boolean validateEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String capFirst(String str) {
        return str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
    }

    public static boolean isStringNull(String s) {
        if (s == null)
            return true;
        if(s.equals(""))
            return true;
        if (s.toLowerCase().trim().equals("null"))
            return true;
        return false;
    }

    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }

    public static int convertWithDensityRatio(Context context, int size) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (size*density);
    }

    public static String getDensityName(Context context) {
        float density = context.getResources().getDisplayMetrics().density;
        if (density >= 4.0) {
            return "xxxhdpi";
        }
        if (density >= 3.0) {
            return "xxhdpi";
        }
        if (density >= 2.0) {
            return "xhdpi";
        }
        if (density >= 1.5) {
            return "hdpi";
        }
        if (density >= 1.0) {
            return "mdpi";
        }
        return "ldpi";
    }
}
