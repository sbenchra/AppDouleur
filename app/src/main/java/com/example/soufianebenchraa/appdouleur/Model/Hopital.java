package com.example.soufianebenchraa.appdouleur.Model;

public class Hopital {

	private int IdHopital;
	private int IdCentre;
	private int NomHopital;

    public Hopital(int idHopital, int idCentre, int nomHopital) {
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

    public int getNomHopital() {
        return NomHopital;
    }

    public void setNomHopital(int nomHopital) {
        NomHopital = nomHopital;
    }
}