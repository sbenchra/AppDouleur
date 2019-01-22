package com.example.soufianebenchraa.appdouleur.Model;

public class Medecin {

	private int IdMedecin;
	private String NomMedecin;
	private String PrenomMedecin;
	private String NumeroMedecin;
	private String PseudoMedecin;
	private String MotDePasseMedecin;

    public Medecin(int idMedecin, String nomMedecin, String prenomMedecin, String numeroMedecin, String pseudoMedecin, String motDePasseMedecin) {
        IdMedecin = idMedecin;
        NomMedecin = nomMedecin;
        PrenomMedecin = prenomMedecin;
        NumeroMedecin = numeroMedecin;
        PseudoMedecin = pseudoMedecin;
        MotDePasseMedecin = motDePasseMedecin;
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

    public String getPseudoMedecin() {
        return PseudoMedecin;
    }

    public void setPseudoMedecin(String pseudoMedecin) {
        PseudoMedecin = pseudoMedecin;
    }

    public String getMotDePasseMedecin() {
        return MotDePasseMedecin;
    }

    public void setMotDePasseMedecin(String motDePasseMedecin) {
        MotDePasseMedecin = motDePasseMedecin;
    }
}