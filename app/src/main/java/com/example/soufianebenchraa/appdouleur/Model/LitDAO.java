package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

public class LitDAO extends DAOBase {
  public LitDAO(Context pContext) {
    super(pContext);
  }



  public Lit SelectionnerCentre(int idService)

  {

    Cursor c = mDb.rawQuery("select * from Lit NATURAL JOIN Service" + " where IdService = ? ", new String[]{idService + ""});

    int IdLit = c.getInt(0);
    int NumeroLit = c.getInt(2);



    Lit l = new Lit (IdLit,idService,NumeroLit);

    return l;

  }
}