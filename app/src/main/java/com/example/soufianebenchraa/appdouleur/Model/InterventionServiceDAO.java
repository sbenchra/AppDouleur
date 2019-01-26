package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class InterventionServiceDAO extends DAOBase{

    public InterventionServiceDAO(Context pContext) {
        super(pContext);
    }

    public List<TypeIntervention> getAllIntervention(Service s) {
        List<TypeIntervention> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery( "select * from InterventionService NATURAL JOIN TypeIntervention where IdService = ?" , new String[]{String.valueOf(s.getIdService())});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idtypeintervention = cursor.getInt(cursor.getColumnIndex("IdTypeIntevention"));
                int idTypeIntervention = cursor.getInt(cursor.getColumnIndex("IdTypeIntervention"));
                String libelletypeintervention = cursor.getString(cursor.getColumnIndex("LibelleTypeIntervention"));
                String heureintevention = cursor.getString(cursor.getColumnIndex("HeureIntervention"));
                String dateintervention = cursor.getString(cursor.getColumnIndex("DateIntervention"));
                TypeIntervention typeintervention = new TypeIntervention(idtypeintervention,libelletypeintervention,heureintevention,dateintervention);

                l.add(typeintervention);
            }


        }
        return l;
    }
}
