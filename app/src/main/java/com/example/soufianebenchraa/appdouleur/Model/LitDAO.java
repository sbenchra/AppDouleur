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

public List<Integer> getAllCentre() {
  List<Integer> l = new ArrayList<>();
  Cursor cursor = getReadableDatabase().rawQuery("select * from Lit", null);
  if (cursor != null) {
    while (cursor.moveToNext()) {
      Integer NumeroLit = cursor.getInt(cursor.getColumnIndex("NumeroLit"));
      l.add(NumeroLit);
    }


  }
  return l;
}

}