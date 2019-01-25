package com.example.soufianebenchraa.appdouleur.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.soufianebenchraa.appdouleur.Model.Batiment;
import com.example.soufianebenchraa.appdouleur.Model.BatimentDAO;
import com.example.soufianebenchraa.appdouleur.Model.Centre;
import com.example.soufianebenchraa.appdouleur.Model.CentreDAO;
import com.example.soufianebenchraa.appdouleur.Model.Hopital;
import com.example.soufianebenchraa.appdouleur.Model.HopitalDAO;
import com.example.soufianebenchraa.appdouleur.Model.Lit;
import com.example.soufianebenchraa.appdouleur.Model.LitDAO;
import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.Model.Service;
import com.example.soufianebenchraa.appdouleur.Model.ServiceDAO;
import com.example.soufianebenchraa.appdouleur.Model.TypeIntervention;
import com.example.soufianebenchraa.appdouleur.Model.TypeInterventionDAO;
import com.example.soufianebenchraa.appdouleur.Model.Ville;
import com.example.soufianebenchraa.appdouleur.Model.VilleDAO;
import com.example.soufianebenchraa.appdouleur.R;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity  {

    HopitalDAO  hopitalDAO;
    CentreDAO centreDAO;
    BatimentDAO batimentDAO;
    ServiceDAO serviceDAO;
    LitDAO litDAO;
    VilleDAO villedao;
    MedecinDAO medecindao;
    TypeInterventionDAO interventiondao;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    Spinner spinner7;
    Spinner spinner8;
    Spinner spinner9;
    Spinner spinner10;
    Spinner spinner11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_patient);

        //Spinner Ville
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<Ville> villes ;
        villedao = new VilleDAO(getApplicationContext());
        villes=villedao.getAllVille();
        List<String> villespinner = new ArrayList();
        for (Ville ville:villes) {
            villespinner.add(ville.getNomVille());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, villespinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        //Centre
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<Centre> centres ;
        centreDAO = new CentreDAO(getApplicationContext());
        String villeselectionne = spinner2.getSelectedItem().toString();
        for (Ville ville:villes) {
            if ((ville.getNomVille().equals(villeselectionne)))
            {
                centres=centreDAO.getAllCentre(ville);
                List<String> centrespinner = new ArrayList();
                for (Centre centre:centres) {
                    centrespinner.add(centre.getNomCentre());
                    ArrayAdapter adapter2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, centrespinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter2);
                }

                //Spinner Hopital
                spinner4 = (Spinner) findViewById(R.id.spinner4);
                List<Hopital> hopitaux;
                hopitalDAO = new HopitalDAO(getApplicationContext());
                String centreselectionne = spinner3.getSelectedItem().toString();
                for (Centre centre : centres)
                    if (centre.getNomCentre().equals(centreselectionne)) {
                        hopitaux = hopitalDAO.getAllHopital(centre);
                        List<String> hopitalspinner = new ArrayList();
                        for (Hopital hopital : hopitaux) {
                            hopitalspinner.add(centre.getNomCentre());
                            ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hopitalspinner);
                            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            spinner4.setAdapter(adapter3);
                        }
                        //Spinner Batiment

                        spinner5 = (Spinner) findViewById(R.id.spinner5);
                        List<Batiment> batiments;
                        batimentDAO = new BatimentDAO(getApplicationContext());
                        String hopitalselectionne = spinner4.getSelectedItem().toString();
                        for (Hopital hopital : hopitaux)
                            if (hopital.getNomHopital().equals(hopitalselectionne)) {
                                batiments = batimentDAO.getAllBatiment(hopital);
                                List<String> batimentspinner = new ArrayList();
                                for (Batiment batiment : batiments) {
                                    batimentspinner.add(batiment.getNomBatiment());
                                    ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, batimentspinner);
                                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                    spinner5.setAdapter(adapter4);
                                }

                                //Spinner Lit Ail Etage

                                spinner6 = (Spinner) findViewById(R.id.spinner6);
                                spinner7 = (Spinner) findViewById(R.id.spinner7);
                                spinner8 = (Spinner) findViewById(R.id.spinner8);
                                List<Service> services;
                                serviceDAO = new ServiceDAO(getApplicationContext());
                                String batimentselectionne = spinner5.getSelectedItem().toString();
                                for (Batiment batiment : batiments)
                                    if (batiment.getNomBatiment().equals(batimentselectionne)) {
                                        services = serviceDAO.getAllService(batiment);
                                        List<String> servicespinner = new ArrayList();
                                        List<String> Ailspinner = new ArrayList();
                                        List<Integer> Etagespinner = new ArrayList();
                                        for (Service service : services) {
                                            servicespinner.add(service.getLibelleService());
                                            ArrayAdapter adapter5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, servicespinner);
                                            ArrayAdapter adapter8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Ailspinner);
                                            ArrayAdapter adapter9 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Etagespinner);
                                            adapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            spinner7.setAdapter(adapter8);
                                            adapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            spinner8.setAdapter(adapter9);
                                            adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                            spinner3.setAdapter(adapter5);
                                        }
                                        spinner9 = (Spinner) findViewById(R.id.spinner9);
                                        List<Lit> lits;
                                        litDAO = new LitDAO(getApplicationContext());
                                        String serviceselectionne = spinner6.getSelectedItem().toString();
                                        for (Service service : services)
                                            if (service.getLibelleService().equals(serviceselectionne)) {
                                                lits = litDAO.getAllLit(service);
                                                List<Integer> litspinner = new ArrayList();
                                                for (Lit lit : lits) {
                                                    litspinner.add(lit.getNumeroLit());
                                                    ArrayAdapter adapter6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, litspinner);
                                                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                                    spinner3.setAdapter(adapter6);
                                                }
                                            }
                                    }
                            }
                    }

            }
        }

        //Spinner Medecin
        spinner10 = (Spinner) findViewById(R.id.spinner10);
        List<Medecin> medecins ;
        medecindao = new MedecinDAO(getApplicationContext());
        medecins=medecindao.getAll();
        List<String> medecinspinner = new ArrayList();
        for (Medecin medecin:medecins) {
            medecinspinner.add(medecin.getNomMedecin());
        }
        ArrayAdapter adapter11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, medecinspinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner10.setAdapter(adapter11);


        //Spinner Intervention
        spinner11 = (Spinner) findViewById(R.id.spinner11);
        List<TypeIntervention> interventions ;
        interventiondao = new TypeInterventionDAO(getApplicationContext());
        interventions=interventiondao.getAllIntervention();
        List<String> interventionspinner = new ArrayList();
        for (TypeIntervention intervention:interventions) {
            interventionspinner.add(intervention.getLibelleIntevention());
        }
        ArrayAdapter adapter12 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, interventionspinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter12);

    }

}

