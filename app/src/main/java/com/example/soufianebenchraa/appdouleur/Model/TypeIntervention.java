package com.example.soufianebenchraa.appdouleur.Model;

public class TypeIntervention {

    private int IdIntervention;
    private String DateIntervention;
    private String HeureIntervention;
    private String LibelleIntevention;

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

    public String getLibelleIntevention() {
        return LibelleIntevention;
    }

    public void setLibelleIntevention(String libelleIntevention) {
        LibelleIntevention = libelleIntevention;
    }

    public TypeIntervention(int idIntervention, String dateIntervention, String heureIntervention, String libelleIntevention) {

        IdIntervention = idIntervention;
        DateIntervention = dateIntervention;
        HeureIntervention = heureIntervention;
        LibelleIntevention = libelleIntevention;
    }
}