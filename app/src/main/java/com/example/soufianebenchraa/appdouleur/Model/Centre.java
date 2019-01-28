package com.example.soufianebenchraa.appdouleur.Model;

import java.io.Serializable;

public class Centre implements Serializable {

	private int IdCentre;
	private String NomCentre;
	private Ville ville;

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int idCentre) {
        IdCentre = idCentre;
    }

    public String getNomCentre() {
        return NomCentre;
    }

    public void setNomCentre(String nomCentre) {
        NomCentre = nomCentre;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Centre(int idCentre, String nomCentre, Ville ville) {

        IdCentre = idCentre;
        NomCentre = nomCentre;
        this.ville = ville;
    }
}