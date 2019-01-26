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
    String NomMedecin;
    String PrenomMedecin;
    String NumeroMedecin;
    String PseudoMedecin;
    String PasswordMedecin;
    boolean doubleBackToExitPressedOnce = false;
    private MedecinDAO medecinDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutmedecin);
        medecinDAO = new MedecinDAO(getApplicationContext());
    }

    /**
     * ajouter un médecin
     */
    public void addMedecin(View addButton) {
        populateValues();
        double a = random();
        int b = (int) a;
        Medecin m = new Medecin(b,NomMedecin,PrenomMedecin,NumeroMedecin,PseudoMedecin,PasswordMedecin);
        Log.d("Saisir",PasswordMedecin);
        long rowId = medecinDAO.ajouterMedecin(m);
        if(rowId!=-1) {
            Intent i = new Intent (AjouterMedecin.this, GestionMedecin.class);
            startActivity(i);
        } else {
            // TODO afficher une erreur à l'utilisateur
            Log.e("ajouter medecin","Erreur lors de l'ajout d'un médecin");
        }

    }
    private void populateValues() {
        tonEdit = (EditText)findViewById(R.id.editText10);
        NomMedecin = tonEdit.getText().toString();
        tonEdit1 = (EditText)findViewById(R.id.editText6);
        PrenomMedecin = tonEdit1.getText().toString();
        tonEdit2 = (EditText)findViewById(R.id.editText9);
        NumeroMedecin = tonEdit2.getText().toString();
        tonEdit3 = (EditText)findViewById(R.id.editText12);
        PseudoMedecin = tonEdit3.getText().toString();
        tonEdit4 = (EditText)findViewById(R.id.editText13);
        PasswordMedecin = tonEdit4.getText().toString();
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
        Toast.makeText(this, "Veuillez ciquer deux fois pour sortir", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
