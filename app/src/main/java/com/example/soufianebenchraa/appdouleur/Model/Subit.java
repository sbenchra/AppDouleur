package com.example.soufianebenchraa.appdouleur.Model;

import java.sql.Time;
import java.util.Date;

public class Subit {
	private int IdPatient;
	private int IdIntervention;
	private String DateIntervention;
	private String HeureIntervention;

    public Subit(int idPatient, int idIntervention, String dateIntervention, String heureIntervention) {
        IdPatient = idPatient;
        IdIntervention = idIntervention;
        DateIntervention = dateIntervention;
        HeureIntervention = heureIntervention;
    }

    public int getIdPatient() {
        return IdPatient;
    }

    public void setIdPatient(int idPatient) {
        IdPatient = idPatient;
    }

    public int getIdIntervention() {
        return IdIntervention;
    }

    public void setIdIntervention(int idIntervention) {
        IdIntervention = idIntervention;
    }

    public String getDateIntervention() {
        return DateIntervention;
    }

    public void setDateIntervention(String dateIntervention) {
        DateIntervention = dateIntervention;
    }

    public String getHeureIntervention() {
        return HeureIntervention;
    }

    public void setHeureIntervention(String heureIntervention) {
        HeureIntervention = heureIntervention;
    }
}