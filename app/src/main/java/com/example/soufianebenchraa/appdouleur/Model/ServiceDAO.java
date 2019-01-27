package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ServiceDAO extends DAOBase {
  public static final String Service_Key="IdService";
  public static final String Service_Etage="Etage";
  public static final String Service_Ail="Ail";
  public static final String Service_Name="LibelleService";
  public static final String Service_Table_Name="Service";
  public static final String Service_Batiment="IdBatiment";

  public ServiceDAO(Context pContext) {
    super(pContext);
  }



  public List<Service> getAllService(Batiment b) {
    List<Service> l = new ArrayList<>();
    Cursor cursor = getReadableDatabase().rawQuery("select * from "+Service_Table_Name+" where IdBatiment = ?", new String[]{String.valueOf(b.getIdBatiment())});
    if (cursor != null) {

      while (cursor.moveToNext() ) {

          int idservice = cursor.getInt(cursor.getColumnIndex(Service_Key));
          String libelleservice = cursor.getString(cursor.getColumnIndex(Service_Name));
          Service s = new Service(idservice,libelleservice,b);
          Log.d("Curseur",s.getLibelleService());
          l.add(s);

          }
    }

        else {
        Log.d("Curseur","Le curseur est vide");
      }

    return l;
  }

  public void ajouterService(Service s)
  {
    super.open();
    ContentValues value = new ContentValues();

    value.put(ServiceDAO.Service_Name, s.getLibelleService());
    value.put(ServiceDAO.Service_Batiment, s.getBatiment().getIdBatiment());
  }

  public void supprimerService(long id)

  {
    mDb.delete(Service_Table_Name, Service_Key + " = ?", new String[] {String.valueOf(id)});

  }


}