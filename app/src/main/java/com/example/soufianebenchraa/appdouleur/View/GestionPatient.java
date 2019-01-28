package com.example.soufianebenchraa.appdouleur.View;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.Model.Ail;
import com.example.soufianebenchraa.appdouleur.Model.AilDAO;
import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.Patient;
import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.R;
import com.example.soufianebenchraa.appdouleur.utils.EditModal;
import com.example.soufianebenchraa.appdouleur.utils.EditModalPatient;

import java.util.List;

public class GestionPatient extends AppCompatActivity {

    private TableLayout displayedPatients;
    private PatientDAO patientDAO;
    private Patient selectedPatient;
    private TableRow selectedRow;
    EditModalPatient editNameDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        patientDAO = new PatientDAO(getApplicationContext());
        setContentView(R.layout.gestionpatient);
        displayedPatients =  findViewById(R.id.displayedPatients);
        populateDisplayedPatients();

    }

    public void goToAjouterPatient(View addButton) {
        Intent i = new Intent (GestionPatient.this, Register.class);
        startActivity(i);
    }

    /**
     * recuperer tous les patients
     */
    private void populateDisplayedPatients() {
        List<Patient> patients = patientDAO.getAll();
        Log.d("size",String.valueOf(patients.size()));

        if(patients.isEmpty()){
        Log.d("Ici","aucun patient saisi");}
        if(patients!=null && patients.size()>0) {
            for (Patient patient:patients) {
                addPatientToDisplayedList(patient);
            }
        }
    }

    private void addPatientToDisplayedList(Patient patient) {
        if(patient==null) return;
        displayedPatients.addView(createTableRow(patient));
        Log.i("table number of rows",String.valueOf(displayedPatients.getChildCount()));
    }
    private TableRow createTableRow(final Patient patient) {
        Context context = getApplicationContext();
        // Create a new table row.
        final TableRow tableRow = new TableRow(getApplicationContext());
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
        Lit.setText(String.valueOf(patient.getLit().getNumeroLit()));
        tableRow.addView(Lit, 4);
        TextView Service = new TextView(context);
        Service.setTextColor(Color.parseColor("#3a94e9"));
        Service.setText(patient.getLit().getService().getLibelleService());
        tableRow.addView(Service, 5);
        TextView Ail = new TextView(context);
        Ail.setTextColor(Color.parseColor("#3a94e9"));
        Ail.setText(patient.getLit().getAil().getAil());
        tableRow.addView(Ail, 6);
        TextView Etage = new TextView(context);
        Etage.setTextColor(Color.parseColor("#3a94e9"));
        Etage.setText(patient.getLit().getEtage().getEtage());
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
        DateIntervention.setText(patient.getDateIntervention());
        tableRow.addView(DateIntervention, 12);
        TextView LibelleIntervention = new TextView(context);
        LibelleIntervention.setTextColor(Color.parseColor("#3a94e9"));
        LibelleIntervention.setText(patient.getIntervention().getLibelleIntevention());
        tableRow.addView(LibelleIntervention, 13);
        TextView Etat = new TextView(context);
        Etat.setTextColor(Color.parseColor("#3a94e9"));
        Etat.setText(String.valueOf(patient.getEtatPatient()));
        tableRow.addView(Etat, 14);
        tableRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedPatient = patient;
                selectedRow = tableRow;
                onCreateContextMenu(patient);

            }
        });

        return tableRow;
    }


    private void deletePatient() {
        selectedPatient.setEtatPatient(0);
        if(selectedPatient==null) {
            return;
        }
        long rowId = patientDAO.modifierPatient(selectedPatient);
        if(rowId>0) {
            displayedPatients.removeView(selectedRow);
            selectedRow = null;
            selectedPatient = null;
            editNameDialogFragment.dismiss();
        }
    }

    public void onDelete(View button) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Supprimer patient")
                .setMessage("Le patient sera désactiver")
                .setPositiveButton("Continuer", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deletePatient();
                    }

                })
                .setNegativeButton("Annuler", null)
                .show();
    }


    public void onUpdate(View button) {
        Intent j = new Intent (GestionPatient.this, Register.class);
        j.putExtra("patient",  selectedPatient);
        startActivity(j);
    }

    public void Activate(View button) {

        selectedPatient.setEtatPatient(1);
        long rowId = patientDAO.modifierPatient(selectedPatient);

        if(rowId>0) {
            Toast.makeText(this, "Succées : patient activé + "+ rowId, Toast.LENGTH_SHORT).show();
            Intent i = new Intent (GestionPatient.this, Register.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Une erreur est survenu lors de l'activation", Toast.LENGTH_SHORT).show();
            Log.e("activation patient","patient : "+selectedPatient.getPrenomPatient());

        }
    }


    public void onCreateContextMenu(Patient patient)
    {
        FragmentManager fm = getSupportFragmentManager();
        editNameDialogFragment = EditModalPatient.newInstance(patient.getNomPatient() + " "+ patient.getPrenomPatient());
        editNameDialogFragment.show(fm, "fragment_edit_name");

    }
}
