package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class VilleDAO extends com.example.soufianebenchraa.appdouleur.Model.DAOBase {


    public VilleDAO(Context pContext) {
        super(pContext);
    }

   /** public Ville SelectionnerCentre(String Nomville)

    {

        Cursor c = mDb.rawQuery("select * from Ville" + " where NomVille= ? ", new String[]{ Nomville + ""});


        int IdVille = c.getInt(0);
        String nomVille = c.getString(1);



        Ville v = new Ville(IdVille,nomVille);

        return v;

    }**/

   public List<Ville> getAllVille() {
       List<Ville> l = new ArrayList<>();
       Cursor cursor = getReadableDatabase().rawQuery("select * from Ville", null);
       if (cursor != null) {
           while (cursor.moveToNext()) {
               int idville = cursor.getInt(cursor.getColumnIndex("IdVille"));
               String nomville = cursor.getString(cursor.getColumnIndex("NomVille"));
               Ville v = new Ville(idville,nomville);
               l.add(v);

           }


       }
       return l;
   }


}
