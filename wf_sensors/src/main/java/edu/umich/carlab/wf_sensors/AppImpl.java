package edu.umich.carlab.wf_sensors;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.Pair;
import edu.umich.carlab.CLDataProvider;
import edu.umich.carlab.DataMarshal;
import edu.umich.carlab.loadable.App;
import edu.umich.carlab.sensors.PhoneSensors;
import edu.umich.carlabui.appbases.SensorListAppBase;


public class AppImpl extends SensorListAppBase {
    final String TAG = "AppImpl";


    public AppImpl(CLDataProvider cl, Context context) {
        super(cl, context);
        foregroundApp = true;
        name = "wf_sensors_app_impl";
        subscribe(PhoneSensors.DEVICE, PhoneSensors.GRAVITY);
        subscribe(PhoneSensors.DEVICE, PhoneSensors.MAGNET);
        subscribe(PhoneSensors.DEVICE, PhoneSensors.GYRO);
        subscribe(PhoneSensors.DEVICE, PhoneSensors.ACCEL);
        subscribe(PhoneSensors.DEVICE, PhoneSensors.GPS);
    }


    @Override
    public void newData(DataMarshal.DataObject dObject) {
        super.newData(dObject);
    }
}
