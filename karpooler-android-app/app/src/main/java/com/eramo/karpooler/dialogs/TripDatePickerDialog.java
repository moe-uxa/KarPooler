package com.eramo.karpooler.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.eramo.karpooler.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TripDatePickerDialog extends AppCompatDialogFragment {


    public TripDatePickerDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_date_picker_dialog, container, false);

        return view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);

    }
}
