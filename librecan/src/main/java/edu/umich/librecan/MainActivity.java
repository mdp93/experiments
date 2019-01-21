package edu.umich.librecan;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import edu.umich.carlab.clog.CLog;
import edu.umich.carlab.clog.CLogDatabaseHelper;
import edu.umich.carlab.io.AppLoader;
import edu.umich.carlab.loadable.Middleware;
import edu.umich.carlab.utils.Utilities;
import edu.umich.carlabui.CarLabUIBuilder;
import edu.umich.carlabui.ExperimentBaseActivity;
import edu.umich.carlabui.R;


import static edu.umich.carlab.Constants.*;

public class MainActivity extends ExperimentBaseActivity {
    final String TAG = "MainActivity";

    SharedPreferences prefs;
    int version, experimentID;
    String shortname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        CLogDatabaseHelper.initializeIfNeeded(this);


        /** Loading all dependencies */
        AppLoader instance = AppLoader.getInstance();

        instance.loadApps(new Class<?>[]{
                edu.umich.carlab.world_aligned_imu.AppImpl.class,
                edu.umich.librecan_middleware.AppImpl.class,
        });


        instance.loadMiddlewares(new Middleware[] {
            new edu.umich.carlab.world_aligned_imu.MiddlewareImpl(),
            new edu.umich.librecan_middleware.MiddlewareImpl(),
        });
        /** End of dependencies */

        prefs
                .edit()
                .putString(UID_key, getString(edu.umich.librecan.R.string.uid))
                .putInt(Experiment_Id, getApplication().getResources().getInteger(edu.umich.librecan.R.integer.experimentID))
                .putInt(Experiment_Version_Number,  getApplication().getResources().getInteger(edu.umich.librecan.R.integer.version))
                .putString(Experiment_Shortname, getString(edu.umich.librecan.R.string.shortname))
                .putBoolean(Experiment_New_Version_Detected, false)
                .putString(Main_Activity, MainActivity.class.getCanonicalName())
                .apply();
        /**************************************************************/
    }
}
