package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

public class HopitalDAO extends DAOBase {


    public HopitalDAO(Context pContext) {
        super(pContext);
    }

    public Hopital SelectionnerCentre(int idCentre)

    {

        Cursor c = mDb.rawQuery("select * from Hopital NATURAL JOIN Centre" + " where IdCentre = ? ", new String[]{idCentre + ""});

        int IdHopital = c.getInt(0);
        String NomHopital = c.getString(1);



        Hopital h = new Hopital(IdHopital,idCentre,NomHopital);

        return h;

    }

}
