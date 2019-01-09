package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class DouleurDAO extends DAOBase {
    public static final String Douleur_Key= "IdDouleur";

    public static final String Patient_id= "IdPatient";
    public static final String Douleur_Intensity="Intensite";
    public static final String Douleur_Time="TempsDouleur";
    public static final String Douleur_Body="CodePartie";
    public static final String Douleur_Table_Name="Douleur";

    public DouleurDAO(Context pContext) {
        super(pContext);
    }

    public void ajouterDouleur(Douleur d)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(Patient_id, d.getIdDouleur());
        value.put(Douleur_Intensity, d.getIntensite());
        value.put(Douleur_Time, d.getTempsDouleur());
        value.put(Douleur_Body, d.getCodePartie());

        mDb.insert(Douleur_Table_Name, null, value);

    }



    public void selectionnerDouleur(int id)
    {

    }
}
