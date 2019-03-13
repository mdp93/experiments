package edu.umich.carlab.wf_speed;

import android.content.Context;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.DataMarshal;

import edu.umich.carlabui.appbases.SensorListAppBase;


public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";

    edu.umich.carlab.watchfon_speed.MiddlewareImpl watchfon_speed =
            new edu.umich.carlab.watchfon_speed.MiddlewareImpl();

    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_speed_app_impl";
        subscribe(watchfon_speed.APP, watchfon_speed.SPEED);
    }


    @Override
    public void newData(DataMarshal.DataObject dObject) {
        super.newData(dObject);
    }
}
