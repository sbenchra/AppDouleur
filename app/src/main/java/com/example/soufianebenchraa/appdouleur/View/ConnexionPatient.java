package com.example.soufianebenchraa.appdouleur.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.R;

public class ConnexionPatient extends AppCompatActivity {

    PatientDAO patientDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexionpatient);

        EditText tonEdit = (EditText) findViewById(R.id.editText3);
        final String pseudo = tonEdit.getText().toString();
        EditText tonEdit1 = (EditText) findViewById(R.id.editText7);
        final String motdepasse = tonEdit1.getText().toString();

        Button button22 = (Button) findViewById(R.id.button22);

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (patientDAO.CheckPatient(pseudo, motdepasse) != 1) {
                    Intent i = new Intent(ConnexionPatient.this, SuppressionMedecin.class);
                    startActivity(i);
                } else {
                    //TODO il faut afficher une erreur au utilisateur
                    Log.e("Connexion", "Une erreur est survenue lors de la connexion");
                }
                if (patientDAO.CheckPossiblity(pseudo)==0)
                {
                    Toast.makeText(getApplicationContext(),"Votre compte n'a pas encore été vérfié",Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
