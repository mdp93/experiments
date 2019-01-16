package edu.umich.carlab.watchfon;

import android.content.Context;
import android.util.Pair;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.loadable.App;
import edu.umich.carlab.loadable.SensorListAppBase;
import edu.umich.carlab.sensors.PhoneSensors;
import edu.umich.carlab.watchfon_estimates.MiddlewareImpl;


/**
 * Created by arunganesan on 6/24/18.
 */

public class MainApp extends SensorListAppBase {
    public MainApp(CLDataProvider cl, Context context) {
        super(cl, context);
        name = "PhoneCollectApp";
        description = "Only phone sensors";

        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.GPS));
        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.ACCEL));
        sensors.add(new Pair<>(PhoneSensors.DEVICE, PhoneSensors.GYRO));

        sensors.add(new Pair<>(edu.umich.carlab.world_aligned_imu.MiddlewareImpl.APP, edu.umich.carlab.world_aligned_imu.MiddlewareImpl.ACCEL));
        sensors.add(new Pair<>(edu.umich.carlab.world_aligned_imu.MiddlewareImpl.APP, edu.umich.carlab.world_aligned_imu.MiddlewareImpl.GYRO));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.SPEED));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.ODOMETER));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.FUEL));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.GEAR));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.ENGINERPM));
        sensors.add(new Pair<>(edu.umich.carlab.watchfon_estimates.MiddlewareImpl.APP, MiddlewareImpl.STEERING));

    }
}