package edu.umich.carlab.wf_speed;

import android.content.Context;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.watchfon_speed.MiddlewareImpl;
import edu.umich.carlabui.appbases.SensorListAppBase;


public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";

    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_speed_app_impl";
        subscribe(MiddlewareImpl.APP, MiddlewareImpl.SPEED);
    }
}
