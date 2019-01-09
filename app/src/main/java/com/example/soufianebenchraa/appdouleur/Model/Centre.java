package com.example.soufianebenchraa.appdouleur.Model;

public class Centre {

	private int IdCentre;
	private String VilleCentre;
	private String NomCentre;

    public Centre(int idCentre, String villeCentre, String nomCentre) {
        IdCentre = idCentre;
        VilleCentre = villeCentre;
        NomCentre = nomCentre;
    }

    public int getIdCentre() {
        return IdCentre;
    }

    public void setIdCentre(int idCentre) {
        IdCentre = idCentre;
    }

    public String getVilleCentre() {
        return VilleCentre;
    }

    public void setVilleCentre(String villeCentre) {
        VilleCentre = villeCentre;
    }

    public String getNomCentre() {
        return NomCentre;
    }

    public void setNomCentre(String nomCentre) {
        NomCentre = nomCentre;
    }
}