package com.example.soufianebenchraa.appdouleur.View;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.Model.Patient;
import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.R;

import java.util.List;

public class GestionPatient extends AppCompatActivity {

    private TableLayout displayedPatients;
    private PatientDAO patientDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        patientDAO = new PatientDAO(getApplicationContext());

        setContentView(R.layout.gestionpatient);
        displayedPatients =  findViewById(R.id.DisplayedPatient);

    }

    private void populateDisplayedMedecins() {
        List<Patient> patients = patientDAO.getAll();
        if(patients!=null && patients.size()>0) {
            for (Patient patient:patients) {
                addMedecinToDisplayedList(patient);
            }
        }
    }

    private void addPatientToDisplayedList(Patient patient) {
        if(patient==null) return;
        displayedPatient.addView(createTableRow(patient));
        Log.i("table number of rows",String.valueOf(displayedPatients.getChildCount()));
    }
    private TableRow createTableRow(Patient patient) {
        Context context = getApplicationContext();
        // Create a new table row.
        TableRow tableRow = new TableRow(getApplicationContext());
        // Set new table row layout parameters.
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams);

        // le nom du patient
        TextView lNameTV = new TextView(context);
        lNameTV.setTextColor(Color.parseColor("#3a94e9"));
        lNameTV.setText(patient.getNomPatient());
        tableRow.addView(lNameTV, 0);
        // le prenom du patient
        TextView fNameTV = new TextView(context);
        fNameTV.setTextColor(Color.parseColor("#3a94e9"));
        fNameTV.setText(patient.getPrenomPatient());
        tableRow.addView(fNameTV, 1);
        // datedenaissance
        TextView Birthday = new TextView(context);
        Birthday.setTextColor(Color.parseColor("#3a94e9"));
        Birthday.setText(patient.getDateNaissancePatient());
        tableRow.addView(Birthday, 2);

        TextView Sexe = new TextView(context);
        Sexe.setTextColor(Color.parseColor("#3a94e9"));
        Sexe.setText(patient.getSexePatient());
        tableRow.addView(Sexe, 3);

        TextView Lit = new TextView(context);
        Lit.setTextColor(Color.parseColor("#3a94e9"));
        Lit.setText(patient.getLit().getNumeroLit());
        tableRow.addView(Lit, 4);
        TextView Service = new TextView(context);
        Service.setTextColor(Color.parseColor("#3a94e9"));
        Service.setText(patient.getLit().getService().getLibelleService());
        tableRow.addView(Service, 5);
        TextView Ail = new TextView(context);
        Ail.setTextColor(Color.parseColor("#3a94e9"));
        Ail.setText(patient.getLit().getService().getAil());
        tableRow.addView(Ail, 6);
        TextView Etage = new TextView(context);
        Etage.setTextColor(Color.parseColor("#3a94e9"));
        Etage.setText(patient.getLit().getService().getEtage());
        tableRow.addView(Etage, 7);
        TextView Batiment = new TextView(context);
        Batiment.setTextColor(Color.parseColor("#3a94e9"));
        Batiment.setText(patient.getLit().getService().getBatiment().getNomBatiment());
        tableRow.addView(Batiment, 8);
        TextView Hopital = new TextView(context);
        Hopital.setTextColor(Color.parseColor("#3a94e9"));
        Hopital.setText(patient.getLit().getService().getBatiment().getHopital().getNomHopital());
        tableRow.addView(Hopital, 9);
        TextView Centre = new TextView(context);
        Centre.setTextColor(Color.parseColor("#3a94e9"));
        Centre.setText(patient.getLit().getService().getBatiment().getHopital().getCentre().getNomCentre());
        tableRow.addView(Centre, 10);
        TextView Ville = new TextView(context);
        Ville.setTextColor(Color.parseColor("#3a94e9"));
        Ville.setText(patient.getLit().getService().getBatiment().getHopital().getCentre().getVille().getNomVille());
        tableRow.addView(Ville, 11);
        TextView DateIntervention = new TextView(context);
        DateIntervention.setTextColor(Color.parseColor("#3a94e9"));
        DateIntervention.setText(patient.getIntervention().getDateIntervention());
        tableRow.addView(DateIntervention, 12);
        TextView LibelleIntervention = new TextView(context);
        LibelleIntervention.setTextColor(Color.parseColor("#3a94e9"));
        LibelleIntervention.setText(patient.getIntervention().getLibelleIntevention());
        tableRow.addView(LibelleIntervention, 13);
        TextView Etat = new TextView(context);
        Etat.setTextColor(Color.parseColor("#3a94e9"));
        Etat.setText(patient.getEtatPatient());
        tableRow.addView(Etat, 14);

        return tableRow;
    }
}
