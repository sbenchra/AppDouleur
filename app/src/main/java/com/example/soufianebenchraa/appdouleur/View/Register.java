package com.example.soufianebenchraa.appdouleur.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Spinner villeSpinner;
    Spinner centreSpinner;
    Spinner hopitalSpinner;
    Spinner serviceSpinner;
    Spinner ailSpinner;
    Spinner etageSpinner;
    Spinner litSpinner;
    Spinner medecinSpinner;
    Spinner tInterventionSpinner;
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
    Button addEditButton;
    Button updateEditButton;
    RadioButton femmeRB;
    RadioButton hommeRB;


    private static final String home = "homme";
    private static final String femme = "femme";


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
        villeSpinner = (Spinner) findViewById(R.id.villeSpinner);
        centreSpinner = (Spinner) findViewById(R.id.centreSpinner);
        //hopitaux
        hopitalSpinner = (Spinner) findViewById(R.id.hopitalSpinner);
        //batiments
        hopitalSpinner = (Spinner) findViewById(R.id.hopitalSpinner);
        serviceSpinner = (Spinner) findViewById(R.id.serviceSpinner);//service
        ailSpinner = (Spinner) findViewById(R.id.ailSpinner);//ail
        etageSpinner = (Spinner) findViewById(R.id.etageSpinner);//etage
        litSpinner = (Spinner) findViewById(R.id.litSpinner);//lit
        //Spinner Medecin
        medecinSpinner = (Spinner) findViewById(R.id.medecinSpinner);
        //Spinner Intervention
        tInterventionSpinner = (Spinner) findViewById(R.id.tInterventionSpinner);
        addEditButton =  findViewById(R.id.button20);
        updateEditButton =  findViewById(R.id.button40);
        femmeRB =  findViewById(R.id.radio_femme);
        hommeRB =  findViewById(R.id.radio_homme);

        villeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateCentres();
            }
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        centreSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateHopitaux();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        hopitalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateBatiments();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        hopitalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateServices();                    }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
        serviceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                populateLits();
                populateTypeIntervention();

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });


       populateSpinners();

        try {
            patient = (Patient) getIntent().getSerializableExtra("patient");
            populayeViews(patient);
        } catch(ClassCastException e) {
            Log.e("modifier patient","cast patient",e);
        }
    }

    private void populateSpinners() {
        villedao = new VilleDAO(getApplicationContext());
        villes = villedao.getAllVille();
        List<String> villespinner = new ArrayList();
        for (Ville ville : villes) {
            villespinner.add(ville.getNomVille());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, villespinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        villeSpinner.setAdapter(adapter);


        etagedao = new EtageDAO(getApplicationContext());
        etages= etagedao.getAllEtage();
        List<String> etagespinner = new ArrayList();
        for (Etage etage : etages) {
            etagespinner.add(etage.getEtage());
        }

        ArrayAdapter adapter10 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, etagespinner);
        adapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etageSpinner.setAdapter(adapter10);

        aildao = new AilDAO(getApplicationContext());
        ails = aildao.getAllAil();
        List<String> ailspinner = new ArrayList();
        for (Ail ail : ails) {
            ailspinner.add(ail.getAil());
        }

        ArrayAdapter adapter18= new ArrayAdapter(this, android.R.layout.simple_spinner_item, ailspinner);
        adapter18.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ailSpinner.setAdapter(adapter18);



        medecindao = new MedecinDAO(getApplicationContext());
        medecins = medecindao.getAll();
        List<String> medecinspinner = new ArrayList();
        for (Medecin medecin : medecins) {
            medecinspinner.add(medecin.getNomMedecin());
        }
        ArrayAdapter adapter11 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, medecinspinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medecinSpinner.setAdapter(adapter11);


    }

    public void populateCentres() {
        String villeselectionne = villeSpinner.getSelectedItem().toString();
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
                    centreSpinner.setAdapter(adapter2);


                }
            }
        }
    }


    public void populateHopitaux() {

        hopitalDAO = new HopitalDAO(getApplicationContext());
        String centreselectionne = centreSpinner.getSelectedItem().toString();
        for (Centre centre : centres)
            if (centre.getNomCentre().equals(centreselectionne)) {
                hopitaux = hopitalDAO.getAllHopital(centre);
                List<String> hopitalspinner = new ArrayList();
                for (Hopital hopital : hopitaux) {
                    hopitalspinner.add(hopital.getNomHopital());
                    ArrayAdapter adapter3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, hopitalspinner);
                    adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    hopitalSpinner.setAdapter(adapter3);
                }
            }

    }

    public void populateBatiments() {
        batimentDAO = new BatimentDAO(getApplicationContext());
        String hopitalselectionne = hopitalSpinner.getSelectedItem().toString();
        for (Hopital hopital : hopitaux)
            if (hopital.getNomHopital().equals(hopitalselectionne)) {
                batiments = batimentDAO.getAllBatiment(hopital);
                List<String> batimentspinner = new ArrayList();
                for (Batiment batiment : batiments) {
                    batimentspinner.add(batiment.getNomBatiment());
                    ArrayAdapter adapter4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, batimentspinner);
                    adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    hopitalSpinner.setAdapter(adapter4);
                }
            }
    }

    //Spinner Lit Ail Etage
    public void populateServices() {
        serviceDAO = new ServiceDAO(getApplicationContext());
        String batimentselectionne = hopitalSpinner.getSelectedItem().toString();
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
                    serviceSpinner.setAdapter(adapter5);
                }
            }
    }

    public void populateLits() {
        litDAO = new LitDAO(getApplicationContext());

        String serviceselectionne = serviceSpinner.getSelectedItem().toString();
        for (Service service : services)
            if (service.getLibelleService().equals(serviceselectionne)) {
                lits = litDAO.getAllLit(service);
                List<Integer> litspinner = new ArrayList();
                for (Lit lit : lits) {
                    litspinner.add(lit.getNumeroLit());
                    ArrayAdapter adapter6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, litspinner);
                    adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    litSpinner.setAdapter(adapter6);
                }

            }
    }




    public void populateTypeIntervention() {
        interventionserviceDAO = new InterventionServiceDAO(getApplicationContext());


        String serviceselectionne = serviceSpinner.getSelectedItem().toString();
        for (Service service : services)
            if (service.getLibelleService().equals(serviceselectionne)) {
                interventionsservice = interventionserviceDAO.getAllIntervention(service);

                List<String> typeinterventionspinner = new ArrayList();
                for (TypeIntervention typeintervention : interventionsservice) {
                    typeinterventionspinner.add(typeintervention.getLibelleIntevention());
                    ArrayAdapter adapter55 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, typeinterventionspinner);
                    adapter55.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    tInterventionSpinner.setAdapter(adapter55);
                }

            }
    }

    private void populayeViews(Patient patient) {
        if(patient==null) {
            return;
        }
        nomET.setText(patient.getNomPatient());
        prenomET.setText(patient.getPrenomPatient());
        passwordET.setText(patient.getMotDePassePatient());
        pseudoET.setText(patient.getPseudoPatient());
        if(patient.getSexePatient().equals(femme)) {
            femmeRB.setChecked(true);
        } else {
            hommeRB.setChecked(true);
        }
        addEditButton.setVisibility(View.GONE);
        updateEditButton.setVisibility(View.VISIBLE);


    }

    public void addPatient(View addButton) {
        pouplateViews();
        long rowId = patientDAO.ajouterPatient(patient);

        if(rowId>0) {
            Toast.makeText(this, "Succées : patient ajouté + "+ rowId, Toast.LENGTH_SHORT).show();
            Intent i = new Intent (Register.this, GestionPatient.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Une erreur est survenu lors de l'ajout du patient", Toast.LENGTH_SHORT).show();
            Log.e("ajout patient","patient : "+patient);

        }
    }



    public void pouplateViews(){
        //TODO tester la validité des autres champs
        if(!isMan && !isWoman) {
            Toast.makeText(this, "Veuillez sélectionner le sexe du patient", Toast.LENGTH_SHORT).show();
            return;
        }
        if(dateSelectedFragment ==null || "".equals(dateSelectedFragment.getDate())) {
            Toast.makeText(this, "Veuillez ajouter la date de naissance", Toast.LENGTH_SHORT).show();
            return;

        }

        String sexe = isWoman ? femme : home;
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
        patient = new Patient(nomET.getText().toString(),prenomET.getText().toString(),dateSelectedFragment.getDate(),sexe,pseudoET.getText().toString(),passwordET.getText().toString(),0,dateSelectedFragment2.getDate(),lit,medecin,typeIntervention);
    }

    public void updatePatient(View addButton)
    {
        pouplateViews();
        long rowId = patientDAO.modifierPatient(patient);

        if(rowId>0) {
            Toast.makeText(this, "Succées : patient modifié + "+ rowId, Toast.LENGTH_SHORT).show();
            Intent i = new Intent (Register.this, GestionPatient.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Une erreur est survenu lors de modification du patient", Toast.LENGTH_SHORT).show();
            Log.e("modifier patient","patient : "+patient);

        }
    }

    public void goBack(View button) {
        Intent i = new Intent (Register.this, GestionPatient.class);
        startActivity(i);
    }

    private Ail selectedAil(){
        if(ailSpinner.getSelectedItem()==null) {
            return null;
        }
        String ailLabel = ailSpinner.getSelectedItem().toString();
        for (Ail ail: ails)
        {
            if(ailLabel.equals(ail.getAil()))
            {
                return ail;
                }
        }
        return null;

    }

    private Etage selectedEtage() {
        if(etageSpinner.getSelectedItem()==null) {
            return null;
        }
        String etageLabel = etageSpinner.getSelectedItem().toString();
        for (Etage etage: etages)

            if(etageLabel.equals(etage.getEtage()))
        {
            return etage;
        }
        return null;
        }



    private Lit selectedLit() {
        if(litSpinner.getSelectedItem()==null) {
            return null;
        }
        String litLabel = litSpinner.getSelectedItem().toString();
        for(Lit lit:lits) {
            if(litLabel.equals(String.valueOf(lit.getNumeroLit()))) {
                return lit;
            }
        }
        return null;
    }
    private Medecin selectedMedecin() {
        if(medecinSpinner.getSelectedItem()==null) {
            return null;
        }
        String medecinLabel = medecinSpinner.getSelectedItem().toString();
        for(Medecin medecin:medecins) {
            if(medecinLabel.equals(String.valueOf(medecin.getNomMedecin()))) {
                return medecin;
            }
        }
        return null;
    }


    private TypeIntervention selectedTypeIntervention() {
        if(tInterventionSpinner.getSelectedItem()==null) {
            return null;
        }
        String interventionLabel = tInterventionSpinner.getSelectedItem().toString();
        for(TypeIntervention typeIntervention:interventionsservice) {
            if(interventionLabel.equals(String.valueOf(typeIntervention.getLibelleIntevention()))) {
                return typeIntervention;
            }
        }
        return null;
    }


    private Service selectedService() {
        if(serviceSpinner.getSelectedItem()==null) {
            return null;
        }
        String serviceLabel = serviceSpinner.getSelectedItem().toString();
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

