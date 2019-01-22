package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

public class BatimentDAO extends DAOBase{

    public BatimentDAO(Context pContext) {
        super(pContext);
    }

    public Batiment SelectionnerCentre(int idHopital)

    {

        Cursor c = mDb.rawQuery("select * from Batiment NATURAL JOIN Hopital" + " where IdHopital= ? ", new String[]{idHopital + ""});

        int IdBatiement = c.getInt(0);
        String NomBatiment = c.getString(1);

        Batiment b = new Batiment(IdBatiement,idHopital,NomBatiment);

        return b;

    }
}
