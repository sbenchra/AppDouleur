package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class AilDAO extends DAOBase {
    public AilDAO(Context pContext) {
        super(pContext);
    }

    public List<Ail> getAllAil() {
        List<Ail> l = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("select * from Ail", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String idail = cursor.getString(cursor.getColumnIndex("IdAil"));

                Ail v = new Ail(idail);
                l.add(v);

            }


        }
        return l;
    }

}
