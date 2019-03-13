package edu.umich.carlab.wf_all_estimators;

import android.content.Context;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlabui.appbases.SensorListAppBase;

public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";

    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_all_estimators_app_impl";

        subscribe(edu.umich.carlab.watchfon_speed.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_speed.MiddlewareImpl.SPEED);

        subscribe(edu.umich.carlab.watchfon_steering.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_steering.MiddlewareImpl.STEERING);

        subscribe(edu.umich.carlab.watchfon_gear.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_gear.MiddlewareImpl.GEAR);

        subscribe(edu.umich.carlab.watchfon_rpm.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_rpm.MiddlewareImpl.RPM);

        subscribe(edu.umich.carlab.watchfon_odometer.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_odometer.MiddlewareImpl.DISTANCE);

        subscribe(edu.umich.carlab.watchfon_fuel.MiddlewareImpl.APP,
                edu.umich.carlab.watchfon_fuel.MiddlewareImpl.FUEL);

    }
}
