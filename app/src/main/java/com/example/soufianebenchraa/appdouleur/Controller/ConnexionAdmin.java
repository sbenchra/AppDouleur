package com.example.soufianebenchraa.appdouleur.Controller;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.MainActivity;
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
        if ("admin".equals(pseudo) && "admin".equals(motdepasse)) {
            Intent i = new Intent(ConnexionAdmin.this, Administrator.class);
            startActivity(i);
        } else {
            //TODO il faut afficher une erreur au utilisateur
            Toast.makeText(this, "Mot de passe ou/et nom d'utilisateur est incorrect.", Toast.LENGTH_SHORT).show();
            Log.e("Connexion", "Une erreur est survenue lors de la connexion");
        }
    }
    public void goBack(View button) {
        Intent i = new Intent (ConnexionAdmin.this, MainActivity.class);
        startActivity(i);
    }


}
