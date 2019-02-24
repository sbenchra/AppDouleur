package com.example.soufianebenchraa.appdouleur.Controller;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.R;
import com.example.soufianebenchraa.appdouleur.utils.EditModal;

import java.util.List;

public class GestionMedecin extends AppCompatActivity{

    private MedecinDAO medecinDAO;
    private TableLayout displayedMedecins;
    private Medecin selectedMedecin;
    private TableRow selectedRow;
    EditModal editNameDialogFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionmedecin);
        medecinDAO = new MedecinDAO(getApplicationContext());
        displayedMedecins =  findViewById(R.id.displayedMedecins);
        populateDisplayedMedecins();
    }


    /**
     * il faut recuperer les données depuis le layout (nom,prenom,numero...) et appeller le addMedecin avec ces données
     */

    //TO DO lier cette activite a l'activité à l'activité ajouter medecin
    public void goToAjouterMedecin(View addButton) {
        Intent i = new Intent (GestionMedecin.this, AjouterMedecin.class);
        startActivity(i);
    }

    /**
     * appeller cette fonction à l'init pour recuperer tout les medecins et les afficher
     */
    private void populateDisplayedMedecins() {
        List<Medecin> medecins = medecinDAO.getAll();
        if(medecins!=null && medecins.size()>0) {
            for (Medecin medecin:medecins) {
                addMedecinToDisplayedList(medecin);
            }
        }
    }

    /**
     * si le medecin à ajouter est null ==> ne rien faire
     * sinon ajouter ses information au tableau d'affichage
     */

    private void addMedecinToDisplayedList(Medecin medecin) {
        if(medecin==null) return;
        displayedMedecins.addView(createTableRow(medecin));
    }


    /**
     * créer une ligne d'affichage pour le medecin
     */
    private TableRow createTableRow(final Medecin medecin) {
        Context context = getApplicationContext();
        // Create a new table row.
        final TableRow tableRow = new TableRow(getApplicationContext());
        // Set new table row layout parameters.
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(layoutParams);

        // le nom du medecin
        TextView lNameTV = new TextView(context);
        lNameTV.setTextColor(Color.parseColor("#3a94e9"));
        lNameTV.setText(medecin.getNomMedecin());
        tableRow.addView(lNameTV, 0);
        // le prenom du medecin
        TextView fNameTV = new TextView(context);
        fNameTV.setTextColor(Color.parseColor("#3a94e9"));
        fNameTV.setText(medecin.getPrenomMedecin());
        tableRow.addView(fNameTV, 1);
        // le numero du medecin
        TextView numberTV = new TextView(context);
        numberTV.setTextColor(Color.parseColor("#3a94e9"));
        numberTV.setText(medecin.getNumeroMedecin());
        tableRow.addView(numberTV, 2);
        tableRow.setClickable(true);
        registerForContextMenu(tableRow);


        tableRow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedMedecin = medecin;
                selectedRow = tableRow;
                onCreateContextMenu(medecin);

            }
        });

        return tableRow;
    }
    public void onDelete(View button) {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Supprimer médecin")
                .setMessage("Le médecin selectionné sera supprimé de la base !")
                .setPositiveButton("Continuer", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteMedecin();
                    }

                })
                .setNegativeButton("Annuler", null)
                .show();
    }

    private void deleteMedecin() {
        if(selectedMedecin==null) {
            return;
        }
        int rowId = medecinDAO.supprimerMedecin(selectedMedecin.getIdMedecin());
        if(rowId>0) {
            displayedMedecins.removeView(selectedRow);
            selectedRow = null;
            selectedMedecin = null;
            editNameDialogFragment.dismiss();
        }
    }

    public void onUpdate(View button) {
        Intent i = new Intent (GestionMedecin.this, AjouterMedecin.class);
        i.putExtra("medecin",selectedMedecin);
        startActivity(i);
    }

    public void onCreateContextMenu(Medecin medecin)
    {
        FragmentManager fm = getSupportFragmentManager();
        editNameDialogFragment = EditModal.newInstance(medecin.getNomMedecin() + " "+ medecin.getPrenomMedecin());
        editNameDialogFragment.show(fm, "fragment_edit_name");

    }

    public void goBack(View button) {
        Intent i = new Intent (GestionMedecin.this, Administrator.class);

        startActivity(i);
    }
}
