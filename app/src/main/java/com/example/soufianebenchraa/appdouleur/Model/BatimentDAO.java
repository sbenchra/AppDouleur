package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class BatimentDAO extends DAOBase {

    public BatimentDAO(Context pContext) {
        super(pContext);
    }

    public List<Batiment> getAllBatiment(Hopital h) {
        List<Batiment> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from Batiment where IdHopital= ?", new String[] {String.valueOf(h.getIdHopital())});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idbatiment = cursor.getInt(cursor.getColumnIndex("IdBatiment"));
                String nomBatiement = cursor.getString(cursor.getColumnIndex("NomBatiment"));
                Batiment b = new Batiment (idbatiment,nomBatiement,h);
                l.add(b);
            }


        }
        return l;
    }
}
