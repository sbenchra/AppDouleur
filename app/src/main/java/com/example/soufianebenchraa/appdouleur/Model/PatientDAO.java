package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

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










    public List<List > getAll() {

        List<List> lists = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select NomPatient,PrenomPatient,NumeroLit,SexePatient,EtatPatient,Etage,Ail,NomBatiment,NomHopital,NomCentre from Patient" +
                " NATURAL JOIN Service NATURAL JOIN Batiment NATURAL JOIN Hopital NATURAL JOIN Centre",null);
        if(cursor!=null) {
            while(cursor.moveToNext()) {
                List l = new ArrayList();
                String lName = cursor.getString(cursor.getColumnIndex(Patient_LName));
                String fName = cursor.getString(cursor.getColumnIndex(Patient_FName));
                int numberlit = cursor.getInt(cursor.getColumnIndex("NumeroLit"));
                String SexePatient = cursor.getString(cursor.getColumnIndex("SexePatient"));
                int EtatPatient = cursor.getInt( cursor.getColumnIndex("EtatPatient"));
                int Etage = cursor.getInt( cursor.getColumnIndex("Etage"));
                String Ail = cursor.getString( cursor.getColumnIndex("Ail"));
                String NomBatiment = cursor.getString( cursor.getColumnIndex("NomBatiment"));
                String NomHopital = cursor.getString( cursor.getColumnIndex("NomHopital"));
                String NomCentre = cursor.getString( cursor.getColumnIndex("NomCentre"));

                l.add(lName);
                l.add(fName);
                l.add(numberlit);
                l.add(SexePatient);
                l.add(EtatPatient);
                l.add(Etage);
                l.add(Ail);
                l.add(NomBatiment);
                l.add(NomHopital);
                l.add(NomCentre);

                lists.add(l);
            }
            cursor.close();
        }
        return lists;
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