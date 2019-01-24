package com.example.soufianebenchraa.appdouleur.View;

import android.os.Bundle;
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
    private MedecinDAO medecinDAO;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajoutmedecin);


        tonEdit = (EditText)findViewById(R.id.editText10);
        NomMedecin = tonEdit.getText().toString();
        tonEdit1 = (EditText)findViewById(R.id.editText6);
        PrenomMedecin = tonEdit1.getText().toString();
        tonEdit2 = (EditText)findViewById(R.id.editText9);
        NumeroMedecin = tonEdit1.getText().toString();
        tonEdit3 = (EditText)findViewById(R.id.editText12);
        PseudoMedecin = tonEdit1.getText().toString();
        tonEdit4 = (EditText)findViewById(R.id.editText13);
        PasswordMedecin = tonEdit1.getText().toString();
        Button button18=(Button)findViewById(R.id.button18);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    double a = random();
                    int b = (int) a;

                    Medecin m = new Medecin(b,NomMedecin,PrenomMedecin,NumeroMedecin,PseudoMedecin,PasswordMedecin);

                     long rowId = medecinDAO.ajouterMedecin(m);
                     if(rowId!=-1) {

                     } else {
                     //il faut afficher une erreur au utilisateur
                     Log.e("Ajout medecin","Une erreur est survenue lors de l'ajout du médecin");

                     }


                }

        });




    }
}
