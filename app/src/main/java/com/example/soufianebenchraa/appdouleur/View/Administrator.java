package com.example.soufianebenchraa.appdouleur.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.soufianebenchraa.appdouleur.MainActivity;
import com.example.soufianebenchraa.appdouleur.R;

public class Administrator extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);
    }

    public void goToPatient(View patient)
    {
        Intent i = new Intent(this,GestionPatient.class);
        startActivity(i);
    }

    public void goToMedecin(View medecin)
    {
        Intent i = new Intent(this,GestionMedecin.class);
        startActivity(i);
    }
    public void Disconnect(View quit)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
