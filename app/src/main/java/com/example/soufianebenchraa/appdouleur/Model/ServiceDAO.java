package com.example.soufianebenchraa.appdouleur.Model;

import android.content.ContentValues;
import android.content.Context;

public class ServiceDAO extends DAOBase {
    public static final String Service_Key="IdService";
    public static final String Service_Etage="Etage";
    public static final String Service_Ail="Ail";
    public static final String Service_Name="LibelleService";
    public static final String Service_Table_Name="Service";
    public static final String Service_Centre="IdCentre";

    public ServiceDAO(Context pContext) {
        super(pContext);
    }

    public void ajouterService(Service s)
    {
        super.open();
        ContentValues value = new ContentValues();
        value.put(ServiceDAO.Service_Etage, s.getEtage());
        value.put(ServiceDAO.Service_Ail, s.getAil());
        value.put(ServiceDAO.Service_Name, s.getLibelleService());
        value.put(ServiceDAO.Service_Centre, s.getIdCentre());
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
    public void ModifierAil(Service s)
    {

    }
    public void ModifierName(Service s)
    {

    }
}
