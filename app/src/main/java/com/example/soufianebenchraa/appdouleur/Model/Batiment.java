package com.example.soufianebenchraa.appdouleur.Model;

public class Batiment {

	private int IdBatiment;
	private int IdHopital;
	private String NomBatiment;

    public Batiment(int idBatiment, int idHopital, String nomBatiment) {
        IdBatiment = idBatiment;
        IdHopital = idHopital;
        NomBatiment = nomBatiment;
    }

    public int getIdBatiment() {
        return IdBatiment;
    }

    public void setIdBatiment(int idBatiment) {
        IdBatiment = idBatiment;
    }

    public int getIdHopital() {
        return IdHopital;
    }

    public void setIdHopital(int idHopital) {
        IdHopital = idHopital;
    }

    public String getNomBatiment() {
        return NomBatiment;
    }

    public void setNomBatiment(String nomBatiment) {
        NomBatiment = nomBatiment;
    }
}