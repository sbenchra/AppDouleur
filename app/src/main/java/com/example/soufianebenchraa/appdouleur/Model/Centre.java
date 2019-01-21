package com.example.soufianebenchraa.appdouleur.Model;

public class Centre {

	private int IdCentre;
	private int IdVille;
	private String NomCentre;

    public Centre(int idCentre, int idVille, String nomCentre) {
        IdCentre = idCentre;
        IdVille = idVille;
        NomCentre = nomCentre;
    }

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int idCentre) {
        IdCentre = idCentre;
    }

    public int getIdVille() {
        return IdVille;
    }

    public void setIdVille(int idVille) {
        IdVille = idVille;
    }

    public String getNomCentre() {
        return NomCentre;
    }

    public void setNomCentre(String nomCentre) {
        NomCentre = nomCentre;
    }
}