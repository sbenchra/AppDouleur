package com.example.soufianebenchraa.appdouleur.Model;
import android.telephony.mbms.StreamingServiceInfo;

import java.util.*;

public class Patient {

    private int IdPatient;

    private String NomPatient;
    private String PrenomPatient;
    private String DateNaissancePatient;
    private String SexePatient;
    private String PseudoPatient;
    private String MotDePassePatient;
    private int EtatPatient;
    private Lit lit;
    private Medecin medecin;
    private TypeIntervention intervention;

    public Patient(String nomPatient, String prenomPatient, String dateNaissancePatient, String sexePatient, int etatPatient, Lit lit, Medecin medecin, TypeIntervention intervention) {
        NomPatient = nomPatient;
        PrenomPatient = prenomPatient;
        DateNaissancePatient = dateNaissancePatient;
        SexePatient = sexePatient;
        EtatPatient = etatPatient;
        this.lit = lit;
        this.medecin = medecin;
        this.intervention = intervention;
    }

    public Patient(int idPatient, String nomPatient, String prenomPatient, String dateNaissancePatient, String sexePatient, String pseudoPatient, String motDePassePatient, int etatPatient, Lit lit, Medecin medecin, TypeIntervention intervention) {
        IdPatient = idPatient;
        NomPatient = nomPatient;
        PrenomPatient = prenomPatient;
        DateNaissancePatient = dateNaissancePatient;
        SexePatient = sexePatient;
        PseudoPatient = pseudoPatient;
        MotDePassePatient = motDePassePatient;
        EtatPatient = etatPatient;
        this.lit = lit;
        this.medecin = medecin;
        this.intervention = intervention;
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
