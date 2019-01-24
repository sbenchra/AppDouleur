package com.example.soufianebenchraa.appdouleur.Model;

public class Service {

	private int IdService;
	private int Etage;
	private String Ail;
	private String LibelleService;
	private Batiment batiment;

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

    public Batiment getBatiment() {
        return batiment;
    }

    public void setBatiment(Batiment batiment) {
        this.batiment = batiment;
    }

    public Service(int idService, int etage, String ail, String libelleService, Batiment batiment) {

        IdService = idService;
        Etage = etage;
        Ail = ail;
        LibelleService = libelleService;
        this.batiment = batiment;
    }
}