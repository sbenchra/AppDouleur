package com.example.soufianebenchraa.appdouleur.Model;

public class Medecin {

	private int IdMedecin;
	private String NomMedecin;
	private String PrenomMedecin;
	private String NumeroMedecin;

    public Medecin(int idMedecin, String nomMedecin, String prenomMedecin, String numeroMedecin) {
        IdMedecin = idMedecin;
        NomMedecin = nomMedecin;
        PrenomMedecin = prenomMedecin;
        NumeroMedecin = numeroMedecin;
    }

    public int getIdMedecin() {
        return IdMedecin;
    }

    public void setIdMedecin(int idMedecin) {
        IdMedecin = idMedecin;
    }

    public String getNomMedecin() {
        return NomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        NomMedecin = nomMedecin;
    }

    public String getPrenomMedecin() {
        return PrenomMedecin;
    }

    public void setPrenomMedecin(String prenomMedecin) {
        PrenomMedecin = prenomMedecin;
    }

    public String getNumeroMedecin() {
        return NumeroMedecin;
    }

    public void setNumeroMedecin(String numeroMedecin) {
        NumeroMedecin = numeroMedecin;
    }
}