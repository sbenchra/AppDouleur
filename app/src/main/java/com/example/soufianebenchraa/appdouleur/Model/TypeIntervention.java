package com.example.soufianebenchraa.appdouleur.Model;

import java.io.Serializable;

public class TypeIntervention implements Serializable {

    private int IdIntervention;

    private String LibelleIntevention;

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

    public TypeIntervention(int idIntervention, String libelleIntevention) {

        IdIntervention = idIntervention;
        LibelleIntevention = libelleIntevention;
    }
}