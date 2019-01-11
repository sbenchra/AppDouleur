package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class MedecinDAO extends DAOBase {
    public static final String Medecin_Key = "IdMedecin";
    public static final String Medecin_FName ="PrenomMedecin";
    public static final String Medecin_LName ="NomMedecin";
    public static final String Medecin_Number ="NumeroMedecin";
    public static final String Medecin_Table_NAME = "Medecin";

    public MedecinDAO(Context pContext) {
        super(pContext);
    }

    public void ajouterMedecin(Medecin m)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(MedecinDAO.Medecin_FName, m.getPrenomMedecin());
        value.put(MedecinDAO.Medecin_LName, m.getNomMedecin());
        value.put(MedecinDAO.Medecin_Number, m.getNumeroMedecin());

        mDb.insert(Medecin_Table_NAME, null, value);
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
        mDb.update(Medecin_Table_NAME, value, Medecin_Key  + " = ?", new String[] {String.valueOf(m.getIdMedecin())});

    }

    public Medecin selectionnerMedecin(int id)
    {
        Cursor c = mDb.rawQuery("select PrenomMedecin,NomMedecin,NumeroMedecin from " + Medecin_Table_NAME + " where IdMedecin = ? ", new String[]{id + ""});

        String PrenomMedecin = c.getString(1);

        String NomMedecin = c.getString(2);

        String NumeroMedecin = c.getString(3);

        Medecin m = new Medecin(id,PrenomMedecin, NomMedecin,NumeroMedecin);

        return m;
    }
}
