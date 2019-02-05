package edu.umich.carlab.watchfon;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


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
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;


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

    void readSpecFile(File specFile) {
        try {
            FileInputStream fis = new FileInputStream(specFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            try {
                while ((line = reader.readLine()) != null) {
                    statusText.append("\n" + line);
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


        } catch (Exception e) {
            Log.e(TAG, "Failed to read spec file");
        }

        scroller.smoothScrollTo(0, statusText.getBottom());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_specs, container, false);
        specDir = getContext().getExternalFilesDir("specs");

        scroller = fragmentView.findViewById(R.id.status_scroller);

        statusText = fragmentView.findViewById(R.id.status_text);
        statusText.setText("Select a spec file...\n...");
        statusText.setEnabled(false);

        Button specsButton = fragmentView.findViewById(R.id.specs_start);
        specsButton.setOnClickListener((View v) -> {
            if (!selectedTemplateFile.equals("")) {
                File specFile = new File(specDir, selectedTemplateFile);
                readSpecFile(specFile);
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
