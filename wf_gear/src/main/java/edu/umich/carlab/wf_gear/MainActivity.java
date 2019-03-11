package edu.umich.carlab.wf_gear;

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
                .putString(Main_Activity, MainActivity.class.getCanonicalName())
                .commit();

        super.onCreate(savedInstanceState);

        AppLoader instance = AppLoader.getInstance();
        instance.loadApp( AppImpl.class );
    }
}
