package com.example.soufianebenchraa.appdouleur.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public abstract class DAOBase  {

// Nous sommes à la première version de la base

    // Si je décide de la mettre à jour, il faudra changer cet
    protected final static int VERSION = 28;


    protected final static String NOM = "database.db";



    protected SQLiteDatabase mDb = null;

    protected DatabaseHandler mHandler = null;



    public DAOBase(Context pContext) {

        this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);

    }



    public SQLiteDatabase open() {

        // Pas besoin de fermer la dernière base puisque getWritableDatabase s'en charge

        mDb = mHandler.getWritableDatabase();

        return mDb;

    }



    public void close() {

        mDb.close();

    }



    SQLiteDatabase getDb() {
        return mDb;
    }


    SQLiteDatabase getReadableDatabase() {
        return mHandler.getReadableDatabase();
    }



}