package com.example.soufianebenchraa.appdouleur.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.MainActivity;
import com.example.soufianebenchraa.appdouleur.Model.Patient;
import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.R;

public class ConnexionPatient extends AppCompatActivity {

    PatientDAO patientDAO;
    EditText tonEdit;
    EditText tonEdit1;
    String pseudo;
    String motdepasse;
    Register register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexionpatient);

    }

    public void connect(View connexion){

        tonEdit = (EditText) findViewById(R.id.editText3);
        pseudo = tonEdit.getText().toString();
        tonEdit1 = (EditText) findViewById(R.id.editText7);
        motdepasse = tonEdit1.getText().toString();
        patientDAO = new PatientDAO(getApplicationContext());
        long exist = patientDAO.CheckPatient(pseudo, motdepasse);
        if (exist == 1) {
            if (patientDAO.CheckPossiblity(pseudo)==0)
            {
                Toast.makeText(getApplicationContext(),"Votre compte n'a pas encore été vérfié",Toast.LENGTH_LONG).show();
            } else {
                Intent i = new Intent(ConnexionPatient.this, SaisirDouleur.class);


                Patient p= patientDAO.getPatient(pseudo);
                i.putExtra("Patient",p);
                startActivity(i);
            }

        } else {
            //TODO il faut afficher une erreur au utilisateur
            Toast.makeText(this, "Mot de passe ou/et nom d'utilisateur est incorrect.", Toast.LENGTH_SHORT).show();
            Log.e("Connexion", "Une erreur est survenue lors de la connexion");
        }

    }


    public void goBack(View retour){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void register(View retour){
        Intent i = new Intent(this,Register2.class);
        startActivity(i);



    }
}
