package edu.umich.carlab.wf_steer;

import android.content.Context;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.DataMarshal;
import edu.umich.carlab.watchfon_steering.MiddlewareImpl;
import edu.umich.carlabui.appbases.SensorListAppBase;


public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";


    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_steer_app_impl";
        subscribe(MiddlewareImpl.APP, MiddlewareImpl.STEERING);
    }


    @Override
    public void newData(DataMarshal.DataObject dObject) {
        super.newData(dObject);
    }
}
