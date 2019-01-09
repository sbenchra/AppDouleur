package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class SubitDAO extends DAOBase {
    public SubitDAO(Context pContext) {
        super(pContext);
    }
    public static final String Subit_Patient="IdPatient";
    public static final String Subit_Intervention="IdTypeIntervention";
    public static final String Subit_Date="DateIntervention";
    public static final String Subit_Heure="HeureIntervention";
    public static final String Subit_Table_Name="Subit";


    public void ajouterSubit(Subit s)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(SubitDAO.Subit_Patient, s.getIdPatient());
        value.put(SubitDAO.Subit_Intervention, s.getIdIntervention());

        value.put(SubitDAO.Subit_Date, s.getDateIntervention());
        value.put(SubitDAO.Subit_Heure, s.getHeureIntervention());
    }

    public void supprimerSubit(long idPatient)
    {
        mDb.delete(Subit_Table_Name, idPatient + " = ?", new String[] {String.valueOf(idPatient)});

    }

    public void modifierSubit(Subit s)
    {

    }
}
