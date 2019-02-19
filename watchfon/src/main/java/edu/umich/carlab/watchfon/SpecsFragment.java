package edu.umich.carlab.watchfon;

import android.content.*;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import edu.umich.carlab.Constants;
import edu.umich.carlab.ManualTrigger;
import edu.umich.carlab.io.CLTripWriter;
import edu.umich.carlab.watchfon_steering.MiddlewareImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static edu.umich.carlab.Constants.*;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpecsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpecsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    final String TAG = "SpecsFrag";
    String selectedTemplateFile = "";
    File specDir;
    TextView statusText;
    ScrollView scroller;
    Spinner spinner;
    JSONObject specJson;
    SharedPreferences prefs;

    String statusTextPersist = null;

    // Bundle states
    String StatusTextState = "StatusTextState";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;


    private BroadcastReceiver doneSpecFile = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String resultFilename = intent.getStringExtra(Constants.SPEC_RESULT_FILENAME);
            File resultFile =  new File(resultFilename);
            JSONObject resultJson = readJSONFile(resultFile);
            writeAndScrolldown("===================");
            writeAndScrolldown("Finished running spec file");
            writeAndScrolldown("-------------------");

            try {
                writeAndScrolldown(resultJson.toString(2));
            } catch (Exception e) {

            }
        }
    };

    public SpecsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecsFragment newInstance(String param1, String param2) {
        SpecsFragment fragment = new SpecsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    void initializeParameters(String traceBasename) {
        Context c = getContext();

        // 1. Get the vehicle
        String vehicle = PerVehicleParameters.getVehicle(traceBasename);

        // 2. For each of the pertinent estimators, set their parameters
        edu.umich.carlab.watchfon_steering.MiddlewareImpl watchfon_steering =
                new edu.umich.carlab.watchfon_steering.MiddlewareImpl();

        watchfon_steering.setParameter(
                c,
                watchfon_steering.STEERING_RATIO,
                PerVehicleParameters.getSteeringRatio(vehicle));

        watchfon_steering.setParameter(
                c,
                watchfon_steering.VEHICLE_LENGTH,
                PerVehicleParameters.getVehicleLength(vehicle));


        // Fuel
        edu.umich.carlab.watchfon_fuel.MiddlewareImpl watchfon_fuel =
                new edu.umich.carlab.watchfon_fuel.MiddlewareImpl();

        watchfon_fuel.setParameter(
                c,
                watchfon_fuel.AVERAGE_MPG,
                PerVehicleParameters.getAverageMPG(vehicle)
        );

        watchfon_fuel.setParameter(
                c,
                watchfon_fuel.MAX_FUEL_CAPACITY,
                PerVehicleParameters.getMaxFuelCapacity(vehicle)
        );

    }

    void runSpec() {
        try {
            // 1. Find the trace file
            String traceFilename = specJson.getString("trace");
            File dumpsDir = CLTripWriter.GetDumpsDir(getContext());
            File[] relatedDumpFiles = dumpsDir.listFiles(
                    (File dir, String name) ->
                            name.contains(traceFilename));

            if (relatedDumpFiles.length != 1) {
                Log.e(TAG, "Error. Please specify a precise trace filename or file doesn't exist: " + traceFilename);
                return;
            }

            initializeParameters(traceFilename);

            File replayDumpFile = relatedDumpFiles[0];
            prefs.edit().putString(
                    Load_From_Trace_Key,
                    replayDumpFile.getCanonicalPath()).commit();
            mListener.onFragmentInteraction(null);
            writeAndScrolldown(String.format("Found dump file file %s", replayDumpFile.getCanonicalPath()));

            // 2. Set the attack injection
            JSONArray injectionArray = specJson.getJSONArray("injections");
            JSONArray replayDuration = specJson.getJSONArray("duration");

            prefs.edit()
                    .putString(Load_Attack_From_Specs_Key, injectionArray.toString())
                    .putFloat(Load_From_Trace_Duration_Start, (float)replayDuration.getDouble(0))
                    .putFloat(Load_From_Trace_Duration_End, (float)replayDuration.getDouble(1))
                    .commit();
            writeAndScrolldown(String.format(
                    "Loaded injections: %s",
                    injectionArray.toString(2)));

            // 3. Start CarLab on the trace file
            prefs.edit().putBoolean(ManualChoiceKey, true).commit();
            getContext().sendBroadcast(new Intent(
                    getContext(),
                    ManualTrigger.class));
            mListener.onFragmentInteraction(null);
            writeAndScrolldown("Started CarLab");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, e.getLocalizedMessage());
        }
    }

    void writeAndScrolldown(String message) {
        statusText.append("\n" + message);
        scroller.postDelayed(
                () -> scroller.smoothScrollTo(
                        0,
                        statusText.getBottom()),
                100);
    }

    JSONObject readJSONFile(File jsonFile) {
        JSONObject json = null;
        StringBuilder specFileText = new StringBuilder();
        try {
            FileInputStream fis = new FileInputStream(jsonFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    specFileText.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            String specFileString = specFileText.toString();
            json = new JSONObject(specFileString);
        } catch (Exception e) {
            Log.e(TAG, "Failed to parse spec file");
        }

        return json;
    }

    void readSpecFile(File specFile) {
        specJson = readJSONFile(specFile);

        try {
            writeAndScrolldown(specJson.toString(2));
        } catch (Exception e) {

        }
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_specs, container, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        specDir = CLTripWriter.GetSpecsDir(getContext());

        scroller = fragmentView.findViewById(R.id.status_scroller);

        statusText = fragmentView.findViewById(R.id.status_text);
        statusText.setText(statusTextPersist);
        statusText.setEnabled(false);

        Button specsButton = fragmentView.findViewById(R.id.specs_start);
        specsButton.setOnClickListener((View v) -> {
            if (!selectedTemplateFile.equals("")) {
                File specFile = new File(specDir, selectedTemplateFile);
                readSpecFile(specFile);
                if (specJson == null)
                    statusText.append("\nERROR. Unable to parse file");
                else
                    runSpec();

                writeAndScrolldown("");
            }
        });

        File[] specFiles = specDir.listFiles();
        List<String> specsArray = new ArrayList<>();
        for (File file : specFiles)
            specsArray.add(file.getName());

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_spinner_item,
                specsArray);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner = fragmentView.findViewById(R.id.specs_file_selection);
        spinner.setAdapter(spinnerAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTemplateFile = spinnerAdapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return fragmentView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getContext().registerReceiver(doneSpecFile, new IntentFilter(Constants.DONE_RUNNING_SPEC_FILE));
    }


    @Override
    public void onPause() {
        super.onPause();
        statusTextPersist = statusText.getText().toString();
        getContext().unregisterReceiver(doneSpecFile);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
