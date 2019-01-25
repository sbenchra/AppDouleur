package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MedecinDAO extends DAOBase {
    public static final String Medecin_Key = "IdMedecin";
    public static final String Medecin_FName ="PrenomMedecin";
    public static final String Medecin_LName ="NomMedecin";
    public static final String Medecin_Number ="NumeroMedecin";
    public static final String Medecin_Pseudo = "MedecinPatient";
    public static final String Medecin_MotDePasse = "MedecinMotDePasse";
    public static final String Medecin_Table_NAME = "Medecin";
    //tag utilisé lors de la navigation d'une activity à l'autre
    public static final String navigateMedecinTag = "medecinAjoute";

    public MedecinDAO(Context pContext) {
        super(pContext);
    }

    public List<Medecin > getAll() {

        List<Medecin> medecins = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select * from "+Medecin_Table_NAME,null);
        if(cursor!=null) {
            while(cursor.moveToNext()) {
                String lName = cursor.getString(cursor.getColumnIndex(Medecin_LName));
                String fName = cursor.getString(cursor.getColumnIndex(Medecin_FName));
                String number = cursor.getString(cursor.getColumnIndex(Medecin_Number));

                medecins.add(new Medecin(lName,fName,number));
            }
            cursor.close();
        }
        return medecins;
    }

    public long ajouterMedecin(Medecin m)
    {
        if(m==null) {
            return -1;
        }
        super.open();
        ContentValues value = new ContentValues();
        value.put(MedecinDAO.Medecin_FName, m.getPrenomMedecin());
        value.put(MedecinDAO.Medecin_LName, m.getNomMedecin());
        value.put(MedecinDAO.Medecin_Number, m.getNumeroMedecin());
        value.put(MedecinDAO.Medecin_Pseudo, m.getPseudoMedecin());
        value.put(MedecinDAO.Medecin_MotDePasse, m.getMotDePasseMedecin());

        return mDb.insert(Medecin_Table_NAME, null, value);
    }

    public void supprimerMedecin(long id)
    {
        mDb.delete(Medecin_Table_NAME, Medecin_Key + " = ?", new String[] {String.valueOf(id)});
    }

    public void modifierFMedecin(Medecin m)
    {
        ContentValues value = new ContentValues();
        value.put(MedecinDAO.Medecin_FName, m.getPrenomMedecin());
        value.put(MedecinDAO.Medecin_LName, m.getNomMedecin());
        value.put(MedecinDAO.Medecin_Number, m.getNumeroMedecin());
        value.put(MedecinDAO.Medecin_Pseudo, m.getPseudoMedecin());
        value.put(MedecinDAO.Medecin_MotDePasse, m.getMotDePasseMedecin());
        mDb.update(Medecin_Table_NAME, value, Medecin_Key  + " = ?", new String[] {String.valueOf(m.getIdMedecin())});

    }

    public Medecin selectionnerMedecin(int id)
    {
        Cursor c = mDb.rawQuery("select PrenomMedecin,NomMedecin,NumeroMedecin,PseudoMedecin,MotDepasseMedecin from " + Medecin_Table_NAME + " where IdMedecin = ? ", new String[]{id + ""});

        String PrenomMedecin = c.getString(1);

        String NomMedecin = c.getString(2);

        String NumeroMedecin = c.getString(3);
        String PseudoMedecin = c.getString(4);
        String MotDePasseMedecin= c.getString(5);

        Medecin m = new Medecin(id,PrenomMedecin, NomMedecin,NumeroMedecin,PseudoMedecin,MotDePasseMedecin);

        return m;
    }
}
