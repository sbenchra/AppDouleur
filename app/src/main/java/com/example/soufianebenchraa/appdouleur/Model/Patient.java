package com.example.soufianebenchraa.appdouleur.Model;
import android.telephony.mbms.StreamingServiceInfo;

import java.util.*;

public class Patient {

	private int IdPatient;
	private int IdLit;
	private String NomPatient;
	private String PrenomPatient;
	private String DateNaissancePatient;
	private String SexePatient;
    private String PseudoPatient;
    private String MotDePassePatient;
    private int EtatPatient;


    public Patient(int idPatient, int idLit, String nomPatient, String prenomPatient, String dateNaissancePatient, String sexePatient, String pseudoPatient, String motDePassePatient, int etatPatient) {
        IdPatient = idPatient;
        IdLit = idLit;
        NomPatient = nomPatient;
        PrenomPatient = prenomPatient;
        DateNaissancePatient = dateNaissancePatient;
        SexePatient = sexePatient;
        PseudoPatient = pseudoPatient;
        MotDePassePatient = motDePassePatient;
        EtatPatient = etatPatient;
    }

    public int getIdPatient() {
        return IdPatient;
    }

    public void setIdPatient(int idPatient) {
        IdPatient = idPatient;
    }

    public int getIdLit() {
        return IdLit;
    }

    public void setIdLit(int idLit) {
        IdLit = idLit;
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
}