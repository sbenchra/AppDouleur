package com.example.soufianebenchraa.appdouleur.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.soufianebenchraa.appdouleur.Model.Ail;
import com.example.soufianebenchraa.appdouleur.Model.AilDAO;
import com.example.soufianebenchraa.appdouleur.Model.Batiment;
import com.example.soufianebenchraa.appdouleur.Model.BatimentDAO;
import com.example.soufianebenchraa.appdouleur.Model.Centre;
import com.example.soufianebenchraa.appdouleur.Model.CentreDAO;
import com.example.soufianebenchraa.appdouleur.Model.Etage;
import com.example.soufianebenchraa.appdouleur.Model.EtageDAO;
import com.example.soufianebenchraa.appdouleur.Model.Hopital;
import com.example.soufianebenchraa.appdouleur.Model.HopitalDAO;
import com.example.soufianebenchraa.appdouleur.Model.InterventionServiceDAO;
import com.example.soufianebenchraa.appdouleur.Model.Lit;
import com.example.soufianebenchraa.appdouleur.Model.LitDAO;
import com.example.soufianebenchraa.appdouleur.Model.Medecin;
import com.example.soufianebenchraa.appdouleur.Model.MedecinDAO;
import com.example.soufianebenchraa.appdouleur.Model.Patient;
import com.example.soufianebenchraa.appdouleur.Model.PatientDAO;
import com.example.soufianebenchraa.appdouleur.Model.Service;
import com.example.soufianebenchraa.appdouleur.Model.ServiceDAO;
import com.example.soufianebenchraa.appdouleur.Model.TypeIntervention;
import com.example.soufianebenchraa.appdouleur.Model.TypeInterventionDAO;
import com.example.soufianebenchraa.appdouleur.Model.Ville;
import com.example.soufianebenchraa.appdouleur.Model.VilleDAO;
import com.example.soufianebenchraa.appdouleur.R;
import com.example.soufianebenchraa.appdouleur.utils.DateSelecter;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {

    HopitalDAO hopitalDAO;
    CentreDAO centreDAO;
    BatimentDAO batimentDAO;
    ServiceDAO serviceDAO;
    PatientDAO patientDAO;
    LitDAO litDAO;
    VilleDAO villedao;
    MedecinDAO medecindao;
    EtageDAO etagedao;
    AilDAO aildao;

    TypeInterventionDAO interventiondao;
    InterventionServiceDAO interventionserviceDAO ;
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
    List<Ville> villes = new ArrayList<>();
    List<Medecin> medecins = new ArrayList<>();
    List<Centre> centres = new ArrayList<>();
    List<Hopital> hopitaux = new ArrayList<>();
    List<Batiment> batiments = new ArrayList<>();
    List<Service> services = new ArrayList<>();
    List<Lit> lits = new ArrayList<>();
    List<Ail> ails = new ArrayList<>();
    List<TypeIntervention> interventionsservice = new ArrayList<>();
    List<Etage> etages = new ArrayList<>();

    boolean isWoman = false;
    boolean isMan = false;
    Patient patient;
    DateSelecter dateSelectedFragment;
    DateSelecter dateSelectedFragment2;
    EditText nomET ;
    EditText  prenomET;
    EditText pseudoET;
    EditText passwordET;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_patient);

        patientDAO = new PatientDAO(getApplicationContext());

        nomET = (EditText)findViewById(R.id.editText);
        prenomET = (EditText)findViewById(R.id.editText2);
        pseudoET = (EditText)findViewById(R.id.editText4);
        passwordET = (EditText)findViewById(R.id.editText5);


        //Spinner Ville
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        //hopitaux
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        //batiments
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);//service
        spinner7 = (Spinner) findViewById(R.id.spinner7);//ail
        spinner8 = (Spinner) findViewById(R.id.spinner8);//etage
        spinner9 = (Spinner) findViewById(R.id.spinner9);//lit
        //Spinner Medecin
        spinner10 = (Spinner) findViewById(R.id.spinner10);
        //Spinner Intervention
        spinner11 = (Spinner) findViewById(R.id.spinner11);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateCentres();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateHopitaux();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateBatiments();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateServices();                    }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateLits();
                populateTypeIntervention();

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });




        villedao = new VilleDAO(getApplicationContext());
        villes = villedao.getAllVille();
        List<String> villespinner = new ArrayList();
        for (Ville ville : villes) {
            villespinner.add(ville.getNomVille());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, villespinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);


        etagedao = new EtageDAO(getApplicationContext());
        etages= etagedao.getAllEtage();
        List<String> etagespinner = new ArrayList();
        for (Etage etage : etages) {
            etagespinner.add(etage.getEtage());
        }

        ArrayAdapter adapter10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, etagespinner);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner8.setAdapter(adapter10);

        aildao = new AilDAO(getApplicationContext());
        ails = aildao.getAllAil();
        List<String> ailspinner = new ArrayList();
        for (Ail ail : ails) {
            ailspinner.add(ail.getAil());
        }

        ArrayAdapter adapter18= new ArrayAdapter(this, android.R.layout.simple_spinner_item, ailspinner);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner7.setAdapter(adapter18);



        medecindao = new MedecinDAO(getApplicationContext());
        medecins = medecindao.getAll();
        List<String> medecinspinner = new ArrayList();
        for (Medecin medecin : medecins) {
            medecinspinner.add(medecin.getNomMedecin());
        }
        ArrayAdapter adapter11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, medecinspinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner10.setAdapter(adapter11);


/*

        interventiondao = new TypeInterventionDAO(getApplicationContext());
        interventions = interventiondao.getAllIntervention();
        List<String> interventionspinner = new ArrayList();
        for (TypeIntervention intervention : interventions) {
            interventionspinner.add(intervention.getLibelleIntevention());
        }
        ArrayAdapter adapter12 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, interventionspinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner11.setAdapter(adapter12);
*/
    }

    public void populateCentres() {
        String villeselectionne = spinner2.getSelectedItem().toString();
        //Centre
        centreDAO = new CentreDAO(getApplicationContext());

        for (Ville ville : villes) {
            if ((ville.getNomVille().equals(villeselectionne))) {
                centres = centreDAO.getAllCentre(ville);
                List<String> centrespinner = new ArrayList();
                for (Centre centre : centres) {

                    centrespinner.add(centre.getNomCentre());
                    ArrayAdapter adapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, centrespinner);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner3.setAdapter(adapter2);


                }
            }
        }
    }


    public void populateHopitaux() {

        hopitalDAO = new HopitalDAO(getApplicationContext());
        String centreselectionne = spinner3.getSelectedItem().toString();
        for (Centre centre : centres)
            if (centre.getNomCentre().equals(centreselectionne)) {
                hopitaux = hopitalDAO.getAllHopital(centre);
                List<String> hopitalspinner = new ArrayList();
                for (Hopital hopital : hopitaux) {
                    hopitalspinner.add(hopital.getNomHopital());
                    ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hopitalspinner);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner4.setAdapter(adapter3);
                }
            }

    }

    public void populateBatiments() {
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
            }
    }

    //Spinner Lit Ail Etage
    public void populateServices() {
        serviceDAO = new ServiceDAO(getApplicationContext());
        String batimentselectionne = spinner5.getSelectedItem().toString();
        for (Batiment batiment : batiments)
            if (batiment.getNomBatiment().equals(batimentselectionne)) {

                services = serviceDAO.getAllService(batiment);
                if(services.isEmpty()) {
                    Log.d("Verifier", batiment.getNomBatiment());
                }
                else
                {
                    Log.d("Verifier","service n'est pas vide");


                }
                List<String> servicespinner = new ArrayList();

                for (Service service : services) {
                    servicespinner.add(service.getLibelleService());
                    ArrayAdapter adapter5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, servicespinner);

                    adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner6.setAdapter(adapter5);
                }
            }
    }

    public void populateLits() {
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
                    spinner9.setAdapter(adapter6);
                }

            }
    }




    public void populateTypeIntervention() {
        interventionserviceDAO = new InterventionServiceDAO(getApplicationContext());


        String serviceselectionne = spinner6.getSelectedItem().toString();
        for (Service service : services)
            if (service.getLibelleService().equals(serviceselectionne)) {
                interventionsservice = interventionserviceDAO.getAllIntervention(service);

                List<String> typeinterventionspinner = new ArrayList();
                for (TypeIntervention typeintervention : interventionsservice) {
                    typeinterventionspinner.add(typeintervention.getLibelleIntevention());
                    ArrayAdapter adapter55 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeinterventionspinner);
                    adapter55.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner11.setAdapter(adapter55);
                }

            }
    }

    public void addPatient(View addButton) {
        //TODO tester la validité des autres champs
        if(!isMan && !isWoman) {
            Toast.makeText(this, "Veuillez sélectionner le sexe du patient", Toast.LENGTH_SHORT).show();
            return;
        }
        if(dateSelectedFragment ==null || "".equals(dateSelectedFragment.getDate())) {
            Toast.makeText(this, "Veuillez ajouter la date de naissance", Toast.LENGTH_SHORT).show();
            return;

        }


        String sexe = isWoman ? "femme" : "homme";
        Lit lit1 = selectedLit();
        Service service = selectedService();
        Ail ail= selectedAil();
        Etage etage= selectedEtage();

        Lit lit = new Lit(lit1.getIdLit(),lit1.getNumeroLit(),service, etage, ail);
        Medecin medecin = selectedMedecin();
        TypeIntervention typeIntervention = selectedTypeIntervention();

        if(lit==null || medecin==null || typeIntervention==null) {
            Toast.makeText(this, "Des informations sont manquantes", Toast.LENGTH_SHORT).show();
            return;
        }
        Patient patient =  new Patient(nomET.getText().toString(),prenomET.getText().toString(),dateSelectedFragment.getDate(),sexe,pseudoET.getText().toString(),passwordET.getText().toString(),0,dateSelectedFragment2.getDate(),lit,medecin,typeIntervention);
        long rowId = patientDAO.ajouterPatient(patient);

        if(rowId!=-1) {
            Toast.makeText(this, "Succées : patient ajouté", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Une erreur est survenu lors de l'ajout du patient", Toast.LENGTH_SHORT).show();
            Log.e("ajout patient","patient : "+patient);

        }
    }

    private Ail selectedAil(){
        if(spinner9.getSelectedItem()==null) {
            return null;
        }
        String ailLabel = spinner9.getSelectedItem().toString();
        for (Ail ail: ails)
        {
            if(spinner9.getSelectedItem().toString().equals(ail.getAil()))
            {
                return ail;
                }
        }
        return null;

    }

    private Etage selectedEtage() {
        if(spinner8.getSelectedItem()==null) {
            return null;
        }
        String etageLabel = spinner8.getSelectedItem().toString();
        for (Etage etage: etages)

            if(spinner8.getSelectedItem().toString().equals(etage.getEtage()))
        {
            return etage;
        }
        return null;
        }



    private Lit selectedLit() {
        if(spinner9.getSelectedItem()==null) {
            return null;
        }
        String litLabel = spinner9.getSelectedItem().toString();
        for(Lit lit:lits) {
            if(litLabel.equals(String.valueOf(lit.getNumeroLit()))) {
                return lit;
            }
        }
        return null;
    }
    private Medecin selectedMedecin() {
        if(spinner10.getSelectedItem()==null) {
            return null;
        }
        String medecinLabel = spinner10.getSelectedItem().toString();
        for(Medecin medecin:medecins) {
            if(medecinLabel.equals(String.valueOf(medecin.getNomMedecin()))) {
                return medecin;
            }
        }
        return null;
    }


    private TypeIntervention selectedTypeIntervention() {
        if(spinner11.getSelectedItem()==null) {
            return null;
        }
        String interventionLabel = spinner11.getSelectedItem().toString();
        for(TypeIntervention typeIntervention:interventionsservice) {
            if(interventionLabel.equals(String.valueOf(typeIntervention.getLibelleIntevention()))) {
                return typeIntervention;
            }
        }
        return null;
    }


    private Service selectedService() {
        if(spinner6.getSelectedItem()==null) {
            return null;
        }
        String serviceLabel = spinner6.getSelectedItem().toString();
        for(Service service:services) {
            if(serviceLabel.equals(String.valueOf(service.getLibelleService()))) {
                return service;
            }
        }
        return null;
    }
    public void showDateSelecter(View v) {
        dateSelectedFragment = new DateSelecter();
        dateSelectedFragment.show(getSupportFragmentManager(), "date picker");
    }
    public void showDateSelecter2(View v) {
        dateSelectedFragment2 = new DateSelecter();
        dateSelectedFragment2.show(getSupportFragmentManager(), "date intervention");
    }

    public void onSexeRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_femme:
                if (checked)
                    isWoman = true;
                    break;
            case R.id.radio_homme:
                if (checked)
                    isMan=true;
                    break;
        }
    }



}

