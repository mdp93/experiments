package edu.umich.carlab.wf_sensors;

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
        prefs
                .edit()
                .putString(UID_key, getString(edu.umich.carlab.wf_sensors.R.string.uid))
                .putInt(Experiment_Id, getApplication().getResources().getInteger(edu.umich.carlab.wf_sensors.R.integer.experimentID))
                .putInt(Experiment_Version_Number, getApplication().getResources().getInteger(edu.umich.carlab.wf_sensors.R.integer.version))
                .putString(Experiment_Shortname, getString(edu.umich.carlab.wf_sensors.R.string.shortname))
                .putBoolean(Experiment_New_Version_Detected, false)
                .putString(Main_Activity, MainActivity.class.getCanonicalName())
                .commit();

        super.onCreate(savedInstanceState);

        CLogDatabaseHelper.initializeIfNeeded(this);
        AppLoader instance = AppLoader.getInstance();
        instance.loadApp( AppImpl.class );
    }
}
