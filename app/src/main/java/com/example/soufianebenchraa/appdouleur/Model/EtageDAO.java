package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class EtageDAO extends DAOBase{
    public EtageDAO(Context pContext) {
        super(pContext);
    }

    public List<Etage> getAllEtage() {
        List<Etage> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from Etage", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String idetage = cursor.getString(cursor.getColumnIndex("IdEtage"));

                Etage v = new Etage(idetage);
                l.add(v);

            }


        }
        return l;
    }

}


