package com.example.soufianebenchraa.appdouleur.Model;

public class Lit {

  private int IdLit;
  private int NumeroLit;
  private Service service;

  public int getIdLit() {
    return IdLit;
  }

  public void setIdLit(int idLit) {
    IdLit = idLit;
  }

  public int getNumeroLit() {
    return NumeroLit;
  }

  public void setNumeroLit(int numeroLit) {
    NumeroLit = numeroLit;
  }

  public Service getService() {
    return service;
  }

  public void setService(Service service) {
    this.service = service;
  }

  public Lit(int idLit, int numeroLit, Service service) {

    IdLit = idLit;
    NumeroLit = numeroLit;
    this.service = service;
  }
}