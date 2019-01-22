package com.example.soufianebenchraa.appdouleur.Model;

public class Ville {

	private int IdVille;
	private String NomVille;

	public Ville(int idVille, String nomVille) {
		IdVille = idVille;
		NomVille = nomVille;
	}

	public int getIdVille() {
		return IdVille;
	}

	public void setIdVille(int idVille) {
		IdVille = idVille;
	}

	public String getNomVille() {
		return NomVille;
	}

	public void setNomVille(String nomVille) {
		NomVille = nomVille;
	}
}