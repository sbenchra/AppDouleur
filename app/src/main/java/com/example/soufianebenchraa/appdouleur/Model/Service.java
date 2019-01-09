package com.example.soufianebenchraa.appdouleur.Model;

public class Service {

	private int IdService;
	private int Etage;
	private String Ail;
	private String LibelleService;
	private int IdCentre;

    public Service(int idService, int etage, String ail, String libelleService, int idCentre) {
        IdService = idService;
        Etage = etage;
        Ail = ail;
        LibelleService = libelleService;
        IdCentre = idCentre;
    }

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int idService) {
        IdService = idService;
    }

    public int getEtage() {
        return Etage;
    }

    public void setEtage(int etage) {
        Etage = etage;
    }

    public String getAil() {
        return Ail;
    }

    public void setAil(String ail) {
        Ail = ail;
    }

    public String getLibelleService() {
        return LibelleService;
    }

    public void setLibelleService(String libelleService) {
        LibelleService = libelleService;
    }

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int idCentre) {
        IdCentre = idCentre;
    }
}