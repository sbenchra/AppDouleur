package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDAO extends DAOBase {
    public static final String Patient_KEY = "IdPatient";

    public static final String Patient_FName = "NomPatient";

    public static final String Patient_LName = "PrenomPatient";

    public static final String Patient_Lit = "IdLit";
    public static final String Patient_Medecin="IdMedecin";
    public static final String Patient_Birthdate = "NaissancePatient";
    public static final String Patient_Sexe = "SexePatient";
    public static final String Patient_IdIntervention = "IdIntervention";

    public static final String Intervention_Date="DateIntervention";


    public static final String Patient_Pseudo = "PseudoPatient";
    public static final String Patient_MotDePasse = "PatientMotDePasse";
    public static final String Patient_EtatPatient = "EtatPatient";
    public static final String Patient_TABLE_NAME = "Patient";

    public PatientDAO(Context pContext) {
        super(pContext);
    }





    public List<Patient > getAll() {

        List<Patient> patients = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select * from Patient" +
                " NATURAL JOIN Lit NATURAL JOIN Service NATURAL JOIN Medecin NATURAL JOIN TypeIntervention ",null);
        if(cursor!=null) {
            while(cursor.moveToNext()) {

                String lName = cursor.getString(cursor.getColumnIndex(Patient_LName));
                String fName = cursor.getString(cursor.getColumnIndex(Patient_FName));
                String SexePatient = cursor.getString(cursor.getColumnIndex("SexePatient"));
                String DateNaissance = cursor.getString(cursor.getColumnIndex("NaissancePatient"));
                String PseudoPatient = cursor.getString(cursor.getColumnIndex("PseudoPatient"));
                String MotdepassePatient = cursor.getString(cursor.getColumnIndex("PatientMotdePasse"));
                int EtatPatient = cursor.getInt( cursor.getColumnIndex("EtatPatient"));
                int idlit = cursor.getInt(cursor.getColumnIndex("IdLit"));
                int numerolit = cursor.getInt(cursor.getColumnIndex("NumeroLit"));
                int idService = cursor.getInt(cursor.getColumnIndex("IdService"));
                String nomservice = cursor.getString(cursor.getColumnIndex("LibelleService"));

                String ail = cursor.getString(cursor.getColumnIndex("Ail"));
                int etage = cursor.getInt(cursor.getColumnIndex("Etage"));
                int idbatiment = cursor.getInt(cursor.getColumnIndex("IdBatiment"));
                String nombatiment = cursor.getString(cursor.getColumnIndex("NomBatiment"));
                int idhopital = cursor.getInt(cursor.getColumnIndex("IdHopital"));
                String nomhopital = cursor.getString(cursor.getColumnIndex("NomHopital"));

                String nomcentre = cursor.getString(cursor.getColumnIndex("NomCentre"));
                int idcentre = cursor.getInt(cursor.getColumnIndex("IdCentre"));
                int idville = cursor.getInt(cursor.getColumnIndex("IdVille"));
                String nomville = cursor.getString(cursor.getColumnIndex("nomville"));
                int idIntervention = cursor.getInt(cursor.getColumnIndex("IdIntervention"));
                String libelleintervention = cursor.getString(cursor.getColumnIndex("LibelleIntervention"));
                String dateintervention = cursor.getString(cursor.getColumnIndex("DateIntervention"));
                String heureintervention = cursor.getString(cursor.getColumnIndex("HeureIntevention"));
                int idmedecin = cursor.getInt(cursor.getColumnIndex("IdMedecin"));
                String nommedecin = cursor.getString(cursor.getColumnIndex("NomMedecin"));
                String prenommedecin = cursor.getString(cursor.getColumnIndex("PrenomMedecin"));
                String numeromedecin = cursor.getString(cursor.getColumnIndex("NumeroMedecin"));
                String pseudoMedecin = cursor.getString(cursor.getColumnIndex("PseudoMedecin"));

                Ville v = new Ville(idville,nomville);
                Centre c = new Centre(idcentre,nomcentre,v);
                Hopital h = new Hopital(idhopital,nomhopital,c);
                Batiment b = new Batiment(idbatiment,nombatiment,h);
                Service s = new Service(idService,etage,ail,nomservice,b);
                Lit l= new Lit(idlit,numerolit,s);
                TypeIntervention i= new TypeIntervention(idIntervention,libelleintervention);
                Medecin m = new Medecin(idmedecin,nommedecin,prenommedecin,numeromedecin,pseudoMedecin);
                Patient p = new Patient(lName,fName,DateNaissance,SexePatient,EtatPatient,l,m,i);
                patients.add(p);


            }
            cursor.close();
        }
        return patients;
    }


    public long ajouterPatient(Patient p)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(PatientDAO.Patient_LName, p.getNomPatient());
        value.put(PatientDAO.Patient_FName, p.getPrenomPatient());
        value.put("NaissancePatient", p.getDateNaissancePatient() );
        value.put(PatientDAO.Patient_Pseudo, p.getPseudoPatient() );
        value.put(PatientDAO.Patient_MotDePasse, p.getMotDePassePatient() );
        value.put(PatientDAO.Intervention_Date, p.getDateIntervention() );
        value.put(PatientDAO.Patient_Sexe, p.getSexePatient());
        value.put(PatientDAO.Patient_EtatPatient, p.getEtatPatient());
        value.put(PatientDAO.Patient_Lit, p.getLit().getIdLit());
        value.put(PatientDAO.Patient_Medecin, p.getMedecin().getIdMedecin());
        value.put(PatientDAO.Patient_IdIntervention, p.getIntervention().getIdIntervention());

        return mDb.insert(Patient_TABLE_NAME, null, value);

    }

    public int supprimerPatient(long id)
    {
        if(id<=0)  return -1;
       return mDb.delete(Patient_TABLE_NAME, Patient_KEY + " = ?", new String[] {String.valueOf(id)});

    }

    public void modifierPatient(Patient p)
    {

    }

    public int CheckPatient(String pseudoname, String motdepasse)
    {
        Cursor cursor = getReadableDatabase().rawQuery("select * from Patient where PseudoPatient = "+pseudoname+" AND PatientMotDePasse = "+motdepasse ,null);
        if(cursor!=null)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public int CheckPossiblity(String pseudoname){
        Cursor cursor = getReadableDatabase().rawQuery("select * from Patient where PseudoPatient = "+pseudoname ,null);

            int etat = cursor.getInt(cursor.getColumnIndex("EtatPatient"));


        return etat;


    }
}