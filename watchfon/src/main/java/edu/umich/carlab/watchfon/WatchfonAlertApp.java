package edu.umich.carlab.watchfon;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.DataMarshal;
import edu.umich.carlab.loadable.App;
import edu.umich.carlab.sensors.PhoneSensors;
import edu.umich.carlab.watchfon_estimates.MiddlewareImpl;
import edu.umich.carlabui.appbases.SensorStream;


/**
 * Created by arunganesan on 6/24/18.
 */

public class WatchfonAlertApp extends App {


    public WatchfonAlertApp(CLDataProvider cl, Context context) {
        super(cl, context);

        name = "WatchFon Unused";
        description = "";

        final String watchfon_estimates = edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP;
        final String world_aligned_imu = edu.umich.carlab.world_aligned_imu.MiddlewareImpl.APP;

        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.GPS));
        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.ACCEL));
        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.GYRO));

        subscribe(world_aligned_imu, edu.umich.carlab.world_aligned_imu.MiddlewareImpl.ACCEL);
        subscribe(world_aligned_imu, edu.umich.carlab.world_aligned_imu.MiddlewareImpl.GYRO);
        subscribe(watchfon_estimates, MiddlewareImpl.SPEED);
        subscribe(watchfon_estimates, MiddlewareImpl.ODOMETER);
        subscribe(watchfon_estimates, MiddlewareImpl.FUEL);
        subscribe(watchfon_estimates, MiddlewareImpl.GEAR);
        subscribe(watchfon_estimates, MiddlewareImpl.ENGINERPM);
        subscribe(watchfon_estimates, MiddlewareImpl.STEERING);

        subscribe(edu.umich.carlab.watchfon_spoofed_sensors.MiddlewareImpl.APP, edu.umich.carlab.watchfon_spoofed_sensors.MiddlewareImpl.STEERING);
    }
}
