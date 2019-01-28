package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
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

        Cursor cursor = getReadableDatabase().rawQuery("select * from Patient p,Lit l,Service s,Ail a,Etage e,Medecin m,TypeIntervention t,Batiment b,Hopital h,Centre c,Ville v " +
                "where p.IdLit=l.IdLit and p.IdMedecin=m.IdMedecin and l.IdService=s.IdService and p.IdIntervention= t.IdIntervention and l.IdAil=a.IdAil and l.IdEtage=e.IdEtage" +
                " and s.IdBatiment=b.IdBatiment and h.IdHopital=b.IdHopital and c.IdCentre=h.IdCentre and v.IdVille=c.IdVille",null);


        if(cursor!=null) {
            Log.e("get patients","cursor is not null" + cursor.getCount());
            while(cursor.moveToNext()) {
                Log.e("get patients","request succeded");
                String lName = cursor.getString(cursor.getColumnIndex("NomPatient"));
                String fName = cursor.getString(cursor.getColumnIndex("PrenomPatient"));
                String SexePatient = cursor.getString(cursor.getColumnIndex("SexePatient"));
                String DateNaissance = cursor.getString(cursor.getColumnIndex("NaissancePatient"));
                String PseudoPatient = cursor.getString(cursor.getColumnIndex("PseudoPatient"));
                String MotdepassePatient = cursor.getString(cursor.getColumnIndex("PatientMotDePasse"));
                int EtatPatient = cursor.getInt( cursor.getColumnIndex("EtatPatient"));
                int idlit = cursor.getInt(cursor.getColumnIndex("IdLit"));
                int numerolit = cursor.getInt(cursor.getColumnIndex("NumeroLit"));
                int idService = cursor.getInt(cursor.getColumnIndex("IdService"));
                String nomservice = cursor.getString(cursor.getColumnIndex("LibelleService"));

                String ail = cursor.getString(cursor.getColumnIndex("IdAil"));
                String etage = cursor.getString(cursor.getColumnIndex("IdEtage"));
                int idbatiment = cursor.getInt(cursor.getColumnIndex("IdBatiment"));
                String nombatiment = cursor.getString(cursor.getColumnIndex("NomBatiment"));
                int idhopital = cursor.getInt(cursor.getColumnIndex("IdHopital"));
                String nomhopital = cursor.getString(cursor.getColumnIndex("NomHopital"));

                String nomcentre = cursor.getString(cursor.getColumnIndex("CentreNom"));
                int idcentre = cursor.getInt(cursor.getColumnIndex("IdCentre"));
                int idville = cursor.getInt(cursor.getColumnIndex("IdVille"));
                String nomville = cursor.getString(cursor.getColumnIndex("NomVille"));
                int idIntervention = cursor.getInt(cursor.getColumnIndex("IdIntervention"));
                String libelleintervention = cursor.getString(cursor.getColumnIndex("LibelleTypeIntervention"));
                String dateintervention = cursor.getString(cursor.getColumnIndex("DateIntervention"));
                int idmedecin = cursor.getInt(cursor.getColumnIndex("IdMedecin"));
                String nommedecin = cursor.getString(cursor.getColumnIndex("NomMedecin"));
                String prenommedecin = cursor.getString(cursor.getColumnIndex("PrenomMedecin"));
                String numeromedecin = cursor.getString(cursor.getColumnIndex("NumeroMedecin"));
                String pseudoMedecin = cursor.getString(cursor.getColumnIndex("PseudoMedecin"));
                String motdepassemedecin = cursor.getString(cursor.getColumnIndex("MedecinMotDePasse"));


                Ville v = new Ville(idville,nomville);
                Centre c = new Centre(idcentre,nomcentre,v);
                Hopital h = new Hopital(idhopital,nomhopital,c);
                Batiment b = new Batiment(idbatiment,nombatiment,h);
                Etage e= new Etage(etage);
                Ail a= new Ail(ail);
                Service s = new Service(idService,nomservice,b);
                Lit l= new Lit(idlit,numerolit,s,e,a);
                TypeIntervention i= new TypeIntervention(idIntervention,libelleintervention);
                Medecin m = new Medecin(idmedecin,nommedecin,prenommedecin,numeromedecin,pseudoMedecin,motdepassemedecin);
                Patient p = new Patient(lName,fName,DateNaissance,SexePatient,PseudoPatient,MotdepassePatient,EtatPatient,dateintervention,l,m,i);
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

    public long modifierPatient(Patient p)
    {
        if(p==null) {
            return -1;
        }
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


        return mDb.update(Patient_TABLE_NAME,  value, Patient_KEY  + " = ?", new String[] {String.valueOf(p.getIdPatient())});
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