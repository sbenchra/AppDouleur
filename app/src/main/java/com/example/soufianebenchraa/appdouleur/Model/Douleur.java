package com.example.soufianebenchraa.appdouleur.Model;

import java.sql.Time;

public class Douleur {

  private int IdDouleur;
  private String TempsDouleur;
  private String CodePartie;
  private int Intensite;

  public Douleur(int idDouleur, String tempsDouleur, String codePartie, int intensite) {
    IdDouleur = idDouleur;
    TempsDouleur = tempsDouleur;
    CodePartie = codePartie;
    Intensite = intensite;
  }

  public int getIdDouleur() {
    return IdDouleur;
  }

  public void setIdDouleur(int idDouleur) {
    IdDouleur = idDouleur;
  }

  public String getTempsDouleur() {
    return TempsDouleur;
  }

  public void setTempsDouleur(String tempsDouleur) {
    TempsDouleur = tempsDouleur;
  }

  public String getCodePartie() {
    return CodePartie;
  }

  public void setCodePartie(String codePartie) {
    CodePartie = codePartie;
  }

  public int getIntensite() {
    return Intensite;
  }

  public void setIntensite(int intensite) {
    Intensite = intensite;
  }
}