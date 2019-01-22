package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

public class VilleDAO extends DAOBase{


    public VilleDAO(Context pContext) {
        super(pContext);
    }

    public Ville SelectionnerCentre(String Nomville)

    {

        Cursor c = mDb.rawQuery("select * from Ville" + " where NomVille= ? ", new String[]{ Nomville + ""});


        int IdVille = c.getInt(0);
        String nomVille = c.getString(1);



        Ville v = new Ville(IdVille,nomVille);

        return v;

    }

}
