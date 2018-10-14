package com.example.surajj.mlkitdemo.util;

import android.content.Context;
import android.content.pm.PackageManager;

public class Utility {

    /** Check if this device has a camera */
    public static boolean checkCameraHardware(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }
}
