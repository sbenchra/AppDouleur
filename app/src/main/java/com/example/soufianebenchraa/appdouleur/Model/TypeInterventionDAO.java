package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class TypeInterventionDAO extends DAOBase {
    public TypeInterventionDAO(Context pContext) {
        super(pContext);
    }
    public static final String Intervention_Key ="IdTypeIntervention";
    public static final String Intervention_Name ="LibelleTypeIntevention";

    public static final String Intervention_Table_Name="TypeIntervention";

    public void ajouterTypeIntervention(TypeIntervention intervention)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(TypeInterventionDAO.Intervention_Name, intervention.getLibelleIntevention());
        mDb.insert(Intervention_Table_Name, null, value);

    }

    public void supprimerTypeIntervention(int id)
    {
        mDb.delete(Intervention_Key, id + " = ?", new String[] {String.valueOf(id)});

    }

}
