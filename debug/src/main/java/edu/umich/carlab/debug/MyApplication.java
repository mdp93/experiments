package edu.umich.carlab.debug;

import android.app.Application;

public class MyApplication extends Application {
    public static final String TAG = "MyApp";


    public void onCreate() {
        super.onCreate();
//        Fabric.with(this, new Crashlytics());
    }
}
