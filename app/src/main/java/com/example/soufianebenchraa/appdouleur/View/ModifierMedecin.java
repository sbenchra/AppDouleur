package com.example.soufianebenchraa.appdouleur.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.R;

public class ModifierMedecin extends AppCompatActivity {
    private MedecinDAO medecinDAO;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modifiermedecin);

        Intent i = getIntent();
        final int idmedecin =i.getIntExtra("idmedecin",0);
        String nommedecin = i.getStringExtra("nommedecin");
        String prenommedecin = i.getStringExtra("prenommedecin");
        String numeromedecin = i.getStringExtra("numeromedecin");
        String pseudomedecin = i.getStringExtra("pseudo");
        String mdpmedecin = i.getStringExtra("mdp");
        tonEdit = (EditText)findViewById(R.id.editText16);
        tonEdit1 = (EditText)findViewById(R.id.editText17);
        tonEdit2 = (EditText)findViewById(R.id.editText18);
        tonEdit3 = (EditText)findViewById(R.id.editText19);
        tonEdit4 = (EditText)findViewById(R.id.editText20);
        tonEdit.setText(nommedecin);
        tonEdit1.setText(prenommedecin);
        tonEdit2.setText(numeromedecin);
        tonEdit3.setText(pseudomedecin);
        tonEdit4.setText(mdpmedecin);

        final Button button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NomMedecin = tonEdit.getText().toString();
                PrenomMedecin = tonEdit1.getText().toString();
                NumeroMedecin = tonEdit2.getText().toString();
                PseudoMedecin = tonEdit3.getText().toString();
                PasswordMedecin = tonEdit4.getText().toString();
                Medecin m = new Medecin(idmedecin,NomMedecin,PrenomMedecin,NumeroMedecin,PseudoMedecin,PasswordMedecin);
                medecinDAO.modifierMedecin(m);


            }
        });




    }

    public void backtoGestion(View Back)
    {
        Intent i = new Intent (ModifierMedecin.this, GestionMedecin.class);
        startActivity(i);

    }





}