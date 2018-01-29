package com.unicorn.monitor.myapplication;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * <ul>
 * <li>Author: unicornhe </li>
 * <li>Time: 2018/1/29 10:16</li>
 * <li>Contack: unicorn.luson@gmail.com</li>
 * </ul>
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        isActive = true;
        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }


    private boolean isActive ;

    /**
     * Activity 生命周期监听，用于监控app前后台状态切换
     */
    ActivityLifecycleCallbacks activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.e("hls","------onActivityCreated:"+activity.getClass().getName());
        }

        @Override
        public void onActivityStarted(Activity activity) {

            Log.e("hls","------onActivityStarted:"+activity.getClass().getName());
//            if (activityAount == 0) {
//                //app回到前台
//                isForeground = true;
//            }
//            activityAount++;
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.e("hls","------onActivityResumed:"+activity.getClass().getName());
            if (!isActive) {
                //app 从后台唤醒，进入前台
                isActive = true;
                Log.i("ACTIVITY", "程序从后台唤醒");

                Toast.makeText(MyApplication.this,"切回应用",Toast.LENGTH_SHORT).show();
            }
        }
        @Override
        public void onActivityPaused(Activity activity) {
            Log.e("hls","------onActivityPaused:"+activity.getClass().getName());
        }

        @Override
        public void onActivityStopped(Activity activity) {
            Log.e("hls","------onActivityStopped:"+activity.getClass().getName());
            if (!Utils.isAppOnForeground(MyApplication.this)) {
                //app 进入后台
                isActive = false;//记录当前已经进入后台
                Log.i("ACTIVITY", "程序进入后台");
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.e("hls","------onActivitySaveInstanceState:"+activity.getClass().getName());
        }
        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.e("hls","------onActivityDestroyed:"+activity.getClass().getName());
        }
    };



}
