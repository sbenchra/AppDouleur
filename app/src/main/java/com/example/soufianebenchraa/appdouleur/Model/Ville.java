package com.example.soufianebenchraa.appdouleur.Model;

public class Ville {

	private int IdVille;
	private int NomVille;

	public Ville(int idVille, int nomVille) {
		IdVille = idVille;
		NomVille = nomVille;
	}

	public int getIdVille() {
		return IdVille;
	}

	public void setIdVille(int idVille) {
		IdVille = idVille;
	}

	public int getNomVille() {
		return NomVille;
	}

	public void setNomVille(int nomVille) {
		NomVille = nomVille;
	}
}