package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class PatientDAO extends DAOBase {
    public static final String Patient_KEY = "IdPatient";

    public static final String Patient_FName = "NomPatient";

    public static final String Patient_LName = "PrenomPatient";

    public static final String Patient_Lit = "IdLit";
    public static final String Patient_Medecin="IdMedcin";
    public static final String Patient_Birthdate = "DateNaissancePatient";
    public static final String Patient_Sexe = "SexePatient";
    public static final String Patient_Pseudo = "PseudoPatient";
    public static final String Patient_MotDePasse = "PatientMotDePasse";
    public static final String Patient_TABLE_NAME = "Patient";

    public PatientDAO(Context pContext) {
        super(pContext);
    }

    public void ajouterPatient(Patient p)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(PatientDAO.Patient_FName, p.getNomPatient());
        value.put(PatientDAO.Patient_LName, p.getPrenomPatient());
        value.put(PatientDAO.Patient_Birthdate, p.getDateNaissancePatient() );
        value.put(PatientDAO.Patient_Sexe, p.getSexePatient());
        value.put(PatientDAO.Patient_Lit, p.getIdLit());
        value.put(PatientDAO.Patient_Medecin, p.getIdPatient());
        value.put(PatientDAO.Patient_Medecin, p.getIdPatient());

        mDb.insert(Patient_TABLE_NAME, null, value);

    }

    public void supprimerPatient(long id)
    {
        mDb.delete(Patient_TABLE_NAME, Patient_KEY + " = ?", new String[] {String.valueOf(id)});

    }

    public void modifierPatient(Patient p)
    {

    }

    public void selectionnerPatient(int id)
    {

    }
}