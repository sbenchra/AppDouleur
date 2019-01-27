package com.example.soufianebenchraa.appdouleur.Model;

public class Lit {

  private int IdLit;
  private int NumeroLit;
  private Service service;
  private Etage etage;
  private Ail ail;

    public Lit(int idLit, int numeroLit, Service service, Etage etage, Ail ail) {
        IdLit = idLit;
        NumeroLit = numeroLit;
        this.service = service;
        this.etage = etage;
        this.ail = ail;
    }

    public Lit(int idLit, int numeroLit, Service service) {
        IdLit = idLit;
        NumeroLit = numeroLit;
        this.service = service;
    }

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

    public Etage getEtage() {
        return etage;
    }

    public void setEtage(Etage etage) {
        this.etage = etage;
    }

    public Ail getAil() {
        return ail;
    }

    public void setAil(Ail ail) {
        this.ail = ail;
    }
}