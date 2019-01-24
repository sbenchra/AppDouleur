package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class BatimentDAO extends DAOBase {

    public BatimentDAO(Context pContext) {
        super(pContext);
    }

    public List<String> getAllBatiment() {
        List<String> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select NomBatiment from Batiment", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String nomBatiement = cursor.getString(cursor.getColumnIndex("NomBatiment"));
                l.add(nomBatiement);
            }


        }
        return l;
    }
}
