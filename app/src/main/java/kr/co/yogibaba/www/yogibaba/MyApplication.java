package kr.co.yogibaba.www.yogibaba;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tacademy on 2016-05-12.
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
