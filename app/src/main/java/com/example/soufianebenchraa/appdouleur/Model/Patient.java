package com.example.soufianebenchraa.appdouleur.Model;
import android.telephony.mbms.StreamingServiceInfo;

import java.io.Serializable;
import java.util.*;

public class Patient implements Serializable {

    private int IdPatient;

    private String NomPatient;
    private String PrenomPatient;
    private String DateNaissancePatient;
    private String SexePatient;
    private String PseudoPatient;
    private String MotDePassePatient;
    private int EtatPatient;
    private String DateIntervention;
    private Lit lit;
    private Medecin medecin;
    private TypeIntervention intervention;

    public Patient(String nomPatient, String prenomPatient, String dateNaissancePatient, String sexePatient, String pseudoPatient, String motDePassePatient, int etatPatient, String dateIntervention, Lit lit, Medecin medecin, TypeIntervention intervention) {

        NomPatient = nomPatient;
        PrenomPatient = prenomPatient;
        DateNaissancePatient = dateNaissancePatient;
        SexePatient = sexePatient;
        PseudoPatient = pseudoPatient;
        MotDePassePatient = motDePassePatient;
        EtatPatient = etatPatient;
        DateIntervention = dateIntervention;
        this.lit = lit;
        this.medecin = medecin;
        this.intervention = intervention;
    }

    public Patient(int id) {
        IdPatient = id;
    }
    public Patient( int id,String nomPatient, String prenomPatient, String dateNaissancePatient, String sexePatient, String pseudoPatient, String motDePassePatient, int etatPatient, String dateIntervention, Lit lit, Medecin medecin, TypeIntervention intervention) {
        this(nomPatient,prenomPatient,dateNaissancePatient,sexePatient,pseudoPatient,motDePassePatient,etatPatient,dateIntervention,lit,medecin,intervention);
        IdPatient = id;
    }

    public int getIdPatient() {
        return IdPatient;
    }

    public void setIdPatient(int idPatient) {
        IdPatient = idPatient;
    }

    public String getNomPatient() {
        return NomPatient;
    }

    public void setNomPatient(String nomPatient) {
        NomPatient = nomPatient;
    }

    public String getPrenomPatient() {
        return PrenomPatient;
    }

    public void setPrenomPatient(String prenomPatient) {
        PrenomPatient = prenomPatient;
    }

    public String getDateNaissancePatient() {
        return DateNaissancePatient;
    }

    public void setDateNaissancePatient(String dateNaissancePatient) {
        DateNaissancePatient = dateNaissancePatient;
    }

    public String getSexePatient() {
        return SexePatient;
    }

    public void setSexePatient(String sexePatient) {
        SexePatient = sexePatient;
    }

    public String getPseudoPatient() {
        return PseudoPatient;
    }

    public void setPseudoPatient(String pseudoPatient) {
        PseudoPatient = pseudoPatient;
    }

    public String getMotDePassePatient() {
        return MotDePassePatient;
    }

    public void setMotDePassePatient(String motDePassePatient) {
        MotDePassePatient = motDePassePatient;
    }

    public int getEtatPatient() {
        return EtatPatient;
    }

    public void setEtatPatient(int etatPatient) {
        EtatPatient = etatPatient;
    }

    public String getDateIntervention() {
        return DateIntervention;
    }

    public void setDateIntervention(String dateIntervention) {
        DateIntervention = dateIntervention;
    }

    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public TypeIntervention getIntervention() {
        return intervention;
    }

    public void setIntervention(TypeIntervention intervention) {
        this.intervention = intervention;
    }
}
