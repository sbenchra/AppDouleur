package com.example.soufianebenchraa.appdouleur.Model;

import java.sql.Time;

public class Douleur {

  private int IdDouleur;
  private String TempsDouleur;
  private String CodePartie;
  private int Intensite;
  private Patient patient;

  public Douleur(String tempsDouleur, String codePartie, int intensite, Patient patient) {
    TempsDouleur = tempsDouleur;
    CodePartie = codePartie;
    Intensite = intensite;
    this.patient = patient;
  }
  public Douleur(int id,String tempsDouleur, String codePartie, int intensite, Patient patient) {
    this(tempsDouleur,codePartie,intensite,patient);
    IdDouleur = id;
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

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

}