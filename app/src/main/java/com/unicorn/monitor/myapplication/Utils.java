package com.unicorn.monitor.myapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * <ul>
 * <li>Author: unicornhe </li>
 * <li>Time: 2018/1/29 14:26</li>
 * <li>Contack: unicorn.luson@gmail.com</li>
 * </ul>
 */

public class Utils {
    /**
     * APP是否处于前台唤醒状态
     * @param context  context
     * @return result
     */
    public static  boolean isAppOnForeground(Context context) {
        long time0=System.nanoTime();
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null){
            long time1=System.nanoTime();
            Log.e("hls","time cost:"+(time1-time0));
            return false;
        }


        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                long time1=System.nanoTime();
                Log.e("hls","time cost:"+(time1-time0));
                return true;
            }
        }

        long time1=System.nanoTime();
        Log.e("hls","time cost:"+(time1-time0));
        return false;
    }
}
