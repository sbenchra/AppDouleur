package com.example.soufianebenchraa.appdouleur.Model;

import java.io.Serializable;

public class Hopital implements Serializable {

	private int IdHopital;

	private String NomHopital;
	private Centre centre;

    public Hopital(int idHopital, String nomHopital, Centre centre) {
        IdHopital = idHopital;
        NomHopital = nomHopital;
        this.centre = centre;
    }

    public int getIdHopital() {
        return IdHopital;
    }

    public void setIdHopital(int idHopital) {
        IdHopital = idHopital;
    }

    public String getNomHopital() {
        return NomHopital;
    }

    public void setNomHopital(String nomHopital) {
        NomHopital = nomHopital;
    }

    public Centre getCentre() {
        return centre;
    }

    public void setCentre(Centre centre) {
        this.centre = centre;
    }
}