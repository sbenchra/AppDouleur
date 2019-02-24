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
        Cursor cursor = getReadableDatabase().rawQuery( "select I.IdIntervention as IdIntervention, LibelleTypeIntervention " +
                "from InterventionService I, TypeIntervention T , Service S where T.IdIntervention = I.IdIntervention and" +
                " I.IdService = S.IdService and I.IdService = ?" , new String[]{String.valueOf(s.getIdService())});
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idtypeintervention = cursor.getInt(cursor.getColumnIndex("IdIntervention"));
                String libelletypeintervention = cursor.getString(cursor.getColumnIndex("LibelleTypeIntervention"));
                TypeIntervention typeintervention = new TypeIntervention(idtypeintervention,libelletypeintervention);

                l.add(typeintervention);
            }


        }
        return l;
    }
}
