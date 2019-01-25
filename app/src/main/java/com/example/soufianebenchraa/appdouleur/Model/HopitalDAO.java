package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class HopitalDAO extends DAOBase {

    public static final String Hopital_Key="IdHopital";
    public static final String Hopital_Name="NomHopital";
    public static final String CentreH_Key="IdCentre";
    public static final String Hopital_Table_Name="Hopital";

    public HopitalDAO(Context pContext) {
        super(pContext);
    }


    public List<Hopital> getAllHopital(Centre c) {
        List<Hopital> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from "+Hopital_Table_Name+" where IdCentre = ?", new String[]{String.valueOf(c.getIdCentre())});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idhopital = cursor.getInt(cursor.getColumnIndex(Hopital_Key));
                String nomHopital = cursor.getString(cursor.getColumnIndex(Hopital_Name));
                 Hopital h = new Hopital (idhopital,nomHopital,c);
                 l.add(h);
            }


        }
        return l;
    }


}
