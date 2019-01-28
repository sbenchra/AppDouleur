package com.example.soufianebenchraa.appdouleur.Model;

import java.io.Serializable;

public class Etage implements Serializable {

    private String Etage;

    public Etage(String etage) {
        Etage = etage;
    }

    public String getEtage() {
        return Etage;
    }

    public void setEtage(String etage) {
        Etage = etage;
    }
}
