package com.example.soufianebenchraa.appdouleur.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.soufianebenchraa.appdouleur.R;

public class ConnexionAdmin extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexionadmin);



    }
    public void connexion(View v){
        EditText tonEdit = (EditText) findViewById(R.id.editText11);
        final String pseudo = tonEdit.getText().toString();
        EditText tonEdit2 = (EditText) findViewById(R.id.editText8);
        final String motdepasse = tonEdit2.getText().toString();
        if (pseudo.equals("admin") && motdepasse.equals("admin")) {
            Intent i = new Intent(ConnexionAdmin.this, Administrator.class);
            startActivity(i);
        } else {
            //TODO il faut afficher une erreur au utilisateur
            Log.e("Connexion", "Une erreur est survenue lors de la connexion");
        }
    }
}
