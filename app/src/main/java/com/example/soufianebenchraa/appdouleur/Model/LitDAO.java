package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class LitDAO extends DAOBase {
  public LitDAO(Context pContext) {
    super(pContext);
  }


/**
  public Lit SelectionnerCentre(int idService)

  {

    Cursor c = mDb.rawQuery("select * from Lit NATURAL JOIN Service" + " where IdService = ? ", new String[]{idService + ""});

    int IdLit = c.getInt(0);
    int NumeroLit = c.getInt(2);



    Lit l = new Lit (IdLit,idService,NumeroLit);

    return l;

  }**/

public List<Lit> getAllLit(Service s) {
  List<Lit> l = new ArrayList<>();
  Cursor cursor = getReadableDatabase().rawQuery("select * from Lit where IdService = ?", new String[]{s.getIdService() + ""});
  if (cursor != null) {
    while (cursor.moveToNext()) {
        int idlit = cursor.getInt(cursor.getColumnIndex("IdLit"));
        int numerolit = cursor.getInt(cursor.getColumnIndex("NumeroLit"));
        Lit lit = new Lit(idlit,numerolit,s);
        l.add(lit);
    }


  }
  return l;
}

}