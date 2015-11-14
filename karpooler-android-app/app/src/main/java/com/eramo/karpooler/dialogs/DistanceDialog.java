package com.eramo.karpooler.dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avast.android.dialogs.core.BaseDialogFragment;
import com.avast.android.dialogs.fragment.SimpleDialogFragment;
import com.eramo.karpooler.R;

/**
 * Created by Mohamed.Gaber on 11/14/2015.
 */
public class DistanceDialog extends SimpleDialogFragment {


    @Override
    public BaseDialogFragment.Builder build(BaseDialogFragment.Builder builder) {

        builder.setView(LayoutInflater.from(getActivity()).inflate(R.layout.dialog_distance, null));

        return builder;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }

}
