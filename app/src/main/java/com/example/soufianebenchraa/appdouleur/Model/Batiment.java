package com.example.soufianebenchraa.appdouleur.Model;

public class Batiment {

	private int IdBatiment;

	private String NomBatiment;
	private Hopital hopital;

    public Batiment(int idBatiment, String nomBatiment, Hopital hopital) {
        IdBatiment = idBatiment;
        NomBatiment = nomBatiment;
        this.hopital = hopital;
    }

    public int getIdBatiment() {
        return IdBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        IdBatiment = idBatiment;
    }

    public String getNomBatiment() {
        return NomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        NomBatiment = nomBatiment;
    }

    public Hopital getHopital() {
        return hopital;
    }

    public void setHopital(Hopital hopital) {
        this.hopital = hopital;
    }
}