package edu.umich.carlab.wf_speed;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
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
        prefs.edit()
                .putBoolean(LIVE_MODE, true)
                .putString(Experiment_Shortname, getString(R.string.app_name))
                .putString(Main_Activity, MainActivity.class.getCanonicalName())
                .commit();

        super.onCreate(savedInstanceState);
        AppLoader instance = AppLoader.getInstance();

        instance.loadApps(new Class<?>[]{
                AppImpl.class,
//                edu.umich.carlab.world_aligned_imu.AppImpl.class,
                edu.umich.carlab.watchfon_speed.AppImpl.class,
//                edu.umich.carlab.watchfon_gear.AppImpl.class,
//                edu.umich.carlab.watchfon_fuel.AppImpl.class,
//                edu.umich.carlab.watchfon_odometer.AppImpl.class,
//                edu.umich.carlab.watchfon_rpm.AppImpl.class,
//                edu.umich.carlab.watchfon_steering.AppImpl.class,
        });


        instance.loadMiddlewares(new Middleware[]{
//                new edu.umich.carlab.world_aligned_imu.MiddlewareImpl(),
                new edu.umich.carlab.watchfon_speed.MiddlewareImpl(),
//                new edu.umich.carlab.watchfon_gear.MiddlewareImpl(),
//                new edu.umich.carlab.watchfon_fuel.MiddlewareImpl(),
//                new edu.umich.carlab.watchfon_odometer.MiddlewareImpl(),
//                new edu.umich.carlab.watchfon_rpm.MiddlewareImpl(),
//                new edu.umich.carlab.watchfon_steering.MiddlewareImpl(),
        });

    }
}
