package com.example.soufianebenchraa.appdouleur.Model;

public class Lit {

  private int IdLit;
  private int idService;
  private int NumeroLit;

  public Lit(int idLit, int idService, int numeroLit) {

    IdLit = idLit;
    this.idService = idService;
    NumeroLit = numeroLit;
  }

  public int getIdLit() {
    return IdLit;
  }

  public void setIdLit(int idLit) {
    IdLit = idLit;
  }

  public int getIdService() {
    return idService;
  }

  public void setIdService(int idService) {
    this.idService = idService;
  }

  public int getNumeroLit() {
    return NumeroLit;
  }

  public void setNumeroLit(int numeroLit) {
    NumeroLit = numeroLit;
  }
}