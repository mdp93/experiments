package edu.umich.carlab.watchfon;

import android.content.Context;
import android.util.Pair;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.sensors.PhoneSensors;
import edu.umich.carlab.watchfon_estimates.MiddlewareImpl;
import edu.umich.carlabui.appbases.SensorListAppBase;
import edu.umich.carlabui.appbases.SensorStreamAppBase;


/**
 * Created by arunganesan on 6/24/18.
 */

public class MainApp extends SensorListAppBase {
    public MainApp(CLDataProvider cl, Context context) {
        super(cl, context);
        name = "PhoneCollectApp";
        description = "Only phone sensors";

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

//        addLineGraph(world_aligned_imu, edu.umich.carlab.world_aligned_imu.MiddlewareImpl.ACCEL_Y);
    }
}
