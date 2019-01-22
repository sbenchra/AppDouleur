package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CentreDAO extends DAOBase {
    public static final String Centre_Key="IdCentre";
    public static final String City_Key="IdVille";
    public static final String Centre_Name="CentreNom";
    public static final String Centre_Table_Name="Centre";

    public CentreDAO(Context pContext) {
        super(pContext);
    }


    public Centre SelectionnerCentre(int idVille)

    {

        Cursor c = mDb.rawQuery("select * from " + Centre_Table_Name + " NATURAL JOIN Ville" + " where Idville = ? ", new String[]{idVille + ""});

        int IdCentre = c.getInt(0);
        String NomCentre = c.getString(1);

        int IdVille = c.getInt(2);


        Centre C = new Centre(IdCentre,IdVille,NomCentre);

        return C;

    }



}
