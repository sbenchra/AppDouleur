package com.example.soufianebenchraa.appdouleur.Model;

public class Service {

	private int IdService;
	private String LibelleService;
	private Batiment batiment;

    public Service(int idService, String libelleService, Batiment batiment) {
        IdService = idService;
        LibelleService = libelleService;
        this.batiment = batiment;
    }

    public int getIdService() {
        return IdService;
    }

    public void setIdService(int idService) {
        IdService = idService;
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
}