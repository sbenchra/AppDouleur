package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class TypeInterventionDAO extends DAOBase {

  public TypeInterventionDAO(Context pContext) {
    super(pContext);
  }
  public static final String Intervention_Key ="IdTypeIntervention";
  public static final String Intervention_Name ="LibelleTypeIntevention";

  public static final String Intervention_Table_Name="TypeIntervention";


    public List<TypeIntervention> getAllIntervention() {

        List<TypeIntervention> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from TypeIntervention", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int idtypeintervention = cursor.getInt(cursor.getColumnIndex("IdTypeIntevention"));
                String libelletypeintervention = cursor.getString(cursor.getColumnIndex("LibelleTypeIntervention"));
                String heureintevention = cursor.getString(cursor.getColumnIndex("HeureIntervention"));
                String dateintervention = cursor.getString(cursor.getColumnIndex("DateIntervention"));

                TypeIntervention typeintervention = new TypeIntervention(idtypeintervention,libelletypeintervention,heureintevention,dateintervention);
                l.add(typeintervention);

            }


        }
        return l;
    }

  public void ajouterTypeIntervention(TypeIntervention intervention)
  {
    super.open();
    ContentValues value = new ContentValues();
      value.put(TypeInterventionDAO.Intervention_Name, intervention.getDateIntervention());
      value.put(TypeInterventionDAO.Intervention_Name, intervention.getHeureIntervention());
    value.put(TypeInterventionDAO.Intervention_Name, intervention.getLibelleIntevention());

    mDb.insert(Intervention_Table_Name, null, value);

  }

  public void supprimerTypeIntervention(int id)
  {
    mDb.delete(Intervention_Key, id + " = ?", new String[] {String.valueOf(id)});

  }

}