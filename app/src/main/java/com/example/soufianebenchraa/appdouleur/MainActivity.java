package com.example.soufianebenchraa.appdouleur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.soufianebenchraa.appdouleur.Controller.ConnexionAdmin;
import com.example.soufianebenchraa.appdouleur.Controller.ConnexionMedecin;
import com.example.soufianebenchraa.appdouleur.Controller.ConnexionPatient;
import com.example.soufianebenchraa.appdouleur.Controller.Administrator;
import com.example.soufianebenchraa.appdouleur.Controller.ConnexionAdmin;
import com.example.soufianebenchraa.appdouleur.Controller.ConnexionPatient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAdmin(View admin)
    {
        Intent i = new Intent(this,ConnexionAdmin.class);
        startActivity(i);
    }

    public void goPatient(View admin)
    {
        Intent i = new Intent(this,ConnexionPatient.class);
        startActivity(i);
    }

    public void goToMedecin(View admin)
    {
        Intent i = new Intent(this,ConnexionMedecin.class);
        startActivity(i);
    }



}