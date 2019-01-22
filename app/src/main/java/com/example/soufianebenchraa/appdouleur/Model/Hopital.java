package com.example.soufianebenchraa.appdouleur.Model;

public class Hopital {

	private int IdHopital;
	private int IdCentre;
	private String NomHopital;

    public Hopital(int idHopital, int idCentre, String nomHopital) {
        IdHopital = idHopital;
        IdCentre = idCentre;
        NomHopital = nomHopital;
    }

    public int getIdHopital() {
        return IdHopital;
    }

    public void setIdHopital(int idHopital) {
        IdHopital = idHopital;
    }

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int idCentre) {
        IdCentre = idCentre;
    }

    public String getNomHopital() {
        return NomHopital;
    }

    public void setNomHopital(String nomHopital) {
        NomHopital = nomHopital;
    }
}