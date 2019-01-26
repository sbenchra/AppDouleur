package com.example.soufianebenchraa.appdouleur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.soufianebenchraa.appdouleur.View.Administrator;
import com.example.soufianebenchraa.appdouleur.View.ConnexionAdmin;

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


}
