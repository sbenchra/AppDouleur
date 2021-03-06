package com.example.soufianebenchraa.appdouleur.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.soufianebenchraa.appdouleur.R;

public class EditModalPatient extends DialogFragment {
    public EditModalPatient() {
    }

    private TextView mEditText;
    public static EditModalPatient newInstance(String name) {
        EditModalPatient frag = new EditModalPatient();
        Bundle args = new Bundle();
        args.putString("name", name);
        frag.setArguments(args);
        return frag;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_fragment_patient, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String name = getArguments().getString("name", "");
        getDialog().setTitle(name);
        mEditText =  view.findViewById(R.id.edit_name);
        mEditText.setText(name);
        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

}
