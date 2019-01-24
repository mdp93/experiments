package edu.umich.carlab.watchfon;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import edu.umich.carlab.clog.CLogDatabaseHelper;
import edu.umich.carlab.io.AppLoader;
import edu.umich.carlab.loadable.Middleware;
import edu.umich.carlabui.ExperimentBaseActivity;

import static edu.umich.carlab.Constants.*;

public class MainActivity extends ExperimentBaseActivity {
    final String TAG = "MainActivity";

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs
            .edit()
            .putString(UID_key, getString(edu.umich.carlab.watchfon.R.string.uid))
            .putInt(Experiment_Id, getApplication().getResources().getInteger(edu.umich.carlab.watchfon.R.integer.experimentID))
            .putInt(Experiment_Version_Number, getApplication().getResources().getInteger(edu.umich.carlab.watchfon.R.integer.version))
            .putString(Experiment_Shortname, getString(edu.umich.carlab.watchfon.R.string.shortname))
            .putBoolean(Experiment_New_Version_Detected, false)
            .putString(Main_Activity, MainActivity.class.getCanonicalName())
            .commit();

        super.onCreate(savedInstanceState);

        CLogDatabaseHelper.initializeIfNeeded(this);

        /** Loading all dependencies */
        AppLoader instance = AppLoader.getInstance();

        // Estimates rely on world aligned IMU
        instance.loadApps(new Class<?>[]{
                edu.umich.carlab.world_aligned_imu.AppImpl.class,
                edu.umich.carlab.watchfon_speed.AppImpl.class,
                edu.umich.carlab.watchfon_gear.AppImpl.class,
                edu.umich.carlab.watchfon_fuel.AppImpl.class,
                edu.umich.carlab.watchfon_odometer.AppImpl.class,
                edu.umich.carlab.watchfon_rpm.AppImpl.class,
                edu.umich.carlab.watchfon_steering.AppImpl.class,
                edu.umich.carlab.watchfon_estimates.AppImpl.class,
                edu.umich.carlab.watchfon_spoofed_sensors.AppImpl.class,
                edu.umich.carlab.watchfon_intrusion_detection.AppImpl.class,
        });


        instance.loadMiddlewares(new Middleware[]{
                new edu.umich.carlab.world_aligned_imu.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_speed.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_gear.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_fuel.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_odometer.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_rpm.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_steering.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_estimates.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_spoofed_sensors.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_intrusion_detection.MiddlewareImpl()
        });
        /** End of dependencies */

        /**************************************************************/
    }


}
