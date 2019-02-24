package com.example.soufianebenchraa.appdouleur.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.MainActivity;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.R;

public class ConnexionMedecin extends AppCompatActivity {

    MedecinDAO medecindao;
    EditText tonEdit;
    EditText tonEdit2;
    String pseudo;
    String motdepasse;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexionmedecin);



    }
    public void connexion(View v){
        tonEdit = (EditText) findViewById(R.id.editText443);
        pseudo = tonEdit.getText().toString();
        tonEdit2 = (EditText) findViewById(R.id.editText447);
        motdepasse = tonEdit2.getText().toString();
        medecindao = new MedecinDAO(getApplicationContext());
        if (medecindao.CheckMedecin(pseudo,motdepasse)==1) {
            Intent i = new Intent(ConnexionMedecin.this, GestionPatient.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Mot de passe ou/et nom d'utilisateur est incorrect.", Toast.LENGTH_SHORT).show();
            //TODO il faut afficher une erreur au utilisateur
            Log.e("Connexion", "Une erreur est survenue lors de la connexion");
        }
    }

    public void goBack(View button) {
        Intent i = new Intent (ConnexionMedecin.this, MainActivity.class);
        startActivity(i);
    }
}
