package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class CentreDAO extends DAOBase {
    public static final String Centre_Key="IdCentre";
    public static final String City_Key="IdVille";
    public static final String Centre_Name="CentreNom";
    public static final String Centre_Table_Name="Centre";

    public CentreDAO(Context pContext) {
        super(pContext);
    }


    public void AjouterCentre(Centre c)

    {

        super.open();
        ContentValues value = new ContentValues();
        value.put(CentreDAO.Centre_Name, c.getIdCentre());
        value.put(CentreDAO.City_Key, c.getIdVille());

        mDb.insert(CentreDAO.Centre_Table_Name, null, value);

    }

    public void SupprimerCentre(long id)
    {
        mDb.delete(Centre_Table_Name, Centre_Key + " = ?", new String[] {String.valueOf(id)});
    }


}
