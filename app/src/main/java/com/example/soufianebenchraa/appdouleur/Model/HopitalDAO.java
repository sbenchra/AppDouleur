package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class HopitalDAO extends DAOBase {


    public HopitalDAO(Context pContext) {
        super(pContext);
    }


    public List<String> getAllHopital() {
        List<String> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from Hopital", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String nomHopital = cursor.getString(cursor.getColumnIndex("NomHopital"));
                l.add(nomHopital);
            }


        }
        return l;
    }


}
