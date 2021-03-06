package com.example.soufianebenchraa.appdouleur.utils;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

public class DateSelecter extends DialogFragment {

    private String selectedDate = "";
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), dateSetListener, year, month, day);
    }

    private DatePickerDialog.OnDateSetListener dateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    selectedDate = String.valueOf(day) + " / " + String.valueOf((month+1)) + " / " +String.valueOf(year);
                    Log.i("selected date",selectedDate);
                }
            };

    public String getDate() {
        return selectedDate;
    }
}
