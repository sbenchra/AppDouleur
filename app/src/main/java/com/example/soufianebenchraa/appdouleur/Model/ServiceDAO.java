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
          int etage = cursor.getInt(cursor.getColumnIndex(Service_Etage));
          String ail = cursor.getString(cursor.getColumnIndex(Service_Ail));
          Service s = new Service(idservice,etage,ail,libelleservice,b);
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
    value.put(ServiceDAO.Service_Etage, s.getEtage());
    value.put(ServiceDAO.Service_Ail, s.getAil());
    value.put(ServiceDAO.Service_Name, s.getLibelleService());
    value.put(ServiceDAO.Service_Batiment, s.getBatiment().getIdBatiment());
  }

  public void supprimerService(long id)

  {
    mDb.delete(Service_Table_Name, Service_Key + " = ?", new String[] {String.valueOf(id)});

  }

  public void ModifierEtage(String etage, Service s )
  {
    ContentValues value = new ContentValues();

    value.put(etage, s.getEtage());

    mDb.update(Service_Table_Name, value, Service_Key  + " = ?", new String[] {String.valueOf(s.getIdService())});
  }




  public Service SelectionnerService(Batiment b)

  {

    Cursor c = mDb.rawQuery("select * from Service NATURAL JOIN Batiment" + " where IdService = ? ", new String[]{b.getIdBatiment() + ""});

    int IdService = c.getInt(0);
    int etage  = c.getInt(1);
    String Ail =c.getString(2);
    String NomService=c.getString(3);




    Service s = new Service(IdService,etage,Ail,NomService,b);

    return s;

  }
}