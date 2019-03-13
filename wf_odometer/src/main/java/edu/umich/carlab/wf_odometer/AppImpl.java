package edu.umich.carlab.wf_odometer;

import android.content.Context;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.watchfon_odometer.MiddlewareImpl;
import edu.umich.carlabui.appbases.SensorListAppBase;


public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";


    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_odometer_app_impl";
        subscribe(MiddlewareImpl.APP, MiddlewareImpl.DISTANCE);
    }
}
