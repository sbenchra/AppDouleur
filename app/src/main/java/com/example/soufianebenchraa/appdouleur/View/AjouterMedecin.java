package com.example.soufianebenchraa.appdouleur.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.R;

import static java.lang.Math.random;

public class AjouterMedecin extends AppCompatActivity {
    EditText tonEdit;
    EditText tonEdit1;
    EditText tonEdit2;
    EditText tonEdit3;
    EditText tonEdit4;
    Button addEditButton;
    Button updateEditButton;
    String NomMedecin;
    String PrenomMedecin;
    String NumeroMedecin;
    String PseudoMedecin;
    String PasswordMedecin;
    boolean doubleBackToExitPressedOnce = false;
    private MedecinDAO medecinDAO;
    private Medecin medecin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutmedecin);
        medecinDAO = new MedecinDAO(getApplicationContext());
        tonEdit = (EditText)findViewById(R.id.editText10);
        tonEdit1 = (EditText)findViewById(R.id.editText6);
        tonEdit2 = (EditText)findViewById(R.id.editText9);
        tonEdit3 = (EditText)findViewById(R.id.editText12);
        tonEdit4 = (EditText)findViewById(R.id.editText13);
        addEditButton =  findViewById(R.id.ajouter);
        updateEditButton =  findViewById(R.id.modifier);
        try {
            medecin = (Medecin) getIntent().getSerializableExtra("medecin");
            populayeViews(medecin);
        } catch(ClassCastException e) {
            Log.e("modifier medecin","cast medecin",e);
        }
    }



    /**
     * ajouter un médecin
     */
    public void addMedecin(View addButton) {
        populateValues();
        double a = random();
        int b = (int) a;
        Medecin m = new Medecin(b,NomMedecin,PrenomMedecin,NumeroMedecin,PseudoMedecin,PasswordMedecin);
        long rowId = medecinDAO.ajouterMedecin(m);
        if(rowId>0) {
            Intent i = new Intent (AjouterMedecin.this, GestionMedecin.class);
            startActivity(i);
        } else {
            // TODO afficher une erreur à l'utilisateur
            Log.e("ajouter medecin","Erreur lors de l'ajout d'un médecin");
        }
    }

    /**
     * modifier medecin
     */
    public void updateMedecin(View updateButton) {
        if(medecin==null) {
            Log.e("modifier medecin","aucun medecin trouvé");
            return;
        }
        populateValues();
        medecin.setNomMedecin(NomMedecin);
        medecin.setPrenomMedecin(PrenomMedecin);
        medecin.setNumeroMedecin(NumeroMedecin);
        medecin.setPseudoMedecin(PseudoMedecin);
        medecin.setMotDePasseMedecin(PasswordMedecin);
        long rowId = medecinDAO.modifierMedecin(medecin);
        if(rowId>0) {
            Intent i = new Intent (AjouterMedecin.this, GestionMedecin.class);
            startActivity(i);
        } else {
            // TODO afficher une erreur à l'utilisateur
            Log.e("ajouter medecin","Erreur lors de l'ajout d'un médecin");
        }
    }
    /**
     * recuperer les infos depuis l'interface
     */
    private void populateValues() {
        NomMedecin = tonEdit.getText().toString();
        PrenomMedecin = tonEdit1.getText().toString();
        NumeroMedecin = tonEdit2.getText().toString();
        PseudoMedecin = tonEdit3.getText().toString();
        PasswordMedecin = tonEdit4.getText().toString();
    }

    /**
     * afficher les infos à l'interface
     */
    private void populayeViews(Medecin medecin) {
        if(medecin==null) {
            return;
        }
        tonEdit.setText(medecin.getNomMedecin());
        tonEdit1.setText(medecin.getPrenomMedecin());
        tonEdit2.setText(medecin.getNumeroMedecin());
        tonEdit3.setText(medecin.getPseudoMedecin());
        tonEdit4.setText(medecin.getMotDePasseMedecin());
        addEditButton.setVisibility(View.GONE);
        updateEditButton.setVisibility(View.VISIBLE);
    }

    /**
     * quand l'utilisetreu clique sur retour du téléphone, attendre un deuxieme clique avant de sortir de l'application
     * //TODO ajouter cette méthodes dans toutes les activity
     */

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Veuillez cliquer deux fois pour quitter", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    public void goBack(View backBtn) {
        Intent i = new Intent (AjouterMedecin.this, GestionMedecin.class);
        startActivity(i);
    }
}
