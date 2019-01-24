package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class HopitalDAO extends DAOBase {


    public HopitalDAO(Context pContext) {
        super(pContext);
    }


    public List<Hopital> getAllHopital(Centre c) {
        List<Hopital> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from Hopital where IdCentre = ?", new String[]{c.getIdCentre()+ ""});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idhopital = cursor.getInt(cursor.getColumnIndex("IdHopital"));
                String nomHopital = cursor.getString(cursor.getColumnIndex("NomHopital"));
                 Hopital h = new Hopital (idhopital,nomHopital,c);
            }


        }
        return l;
    }


}
