package com.example.soufianebenchraa.appdouleur.View;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.R;

import java.util.ArrayList;
import java.util.List;

public class GestionMedecin extends AppCompatActivity{

    private MedecinDAO medecinDAO;
    Button Ajouter;
    private TableLayout displayedMedecins;
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
    public void addMedecin(View addButton) {

        Intent i = new Intent (GestionMedecin.this, AjouterMedecin.class);
        startActivity(i);


        Medecin medecin = medecinDAO.addMedecin();
        Log.i("addi medecin",medecin.getNomMedecin());
        addMedecinToDisplayedList(medecin);
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
        Log.i("table number of rows",String.valueOf(displayedMedecins.getChildCount()));
    }


    /**
     * créer une ligne d'affichage pour le medecin
     */
    private TableRow createTableRow(Medecin medecin) {
        Context context = getApplicationContext();
        // Create a new table row.
        TableRow tableRow = new TableRow(getApplicationContext());
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
        return tableRow;
    }
}
