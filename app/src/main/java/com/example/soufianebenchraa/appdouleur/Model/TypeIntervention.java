package com.example.soufianebenchraa.appdouleur.Model;

public class TypeIntervention {

	private int IdIntervention;
	private String LibelleIntevention;

	public TypeIntervention(int idIntervention, String libelleIntevention) {
		IdIntervention = idIntervention;
		LibelleIntevention = libelleIntevention;
	}

	public int getIdIntervention() {
		return IdIntervention;
	}

	public void setIdIntervention(int idIntervention) {
		IdIntervention = idIntervention;
	}

	public String getLibelleIntevention() {
		return LibelleIntevention;
	}

	public void setLibelleIntevention(String libelleIntevention) {
		LibelleIntevention = libelleIntevention;
	}
}