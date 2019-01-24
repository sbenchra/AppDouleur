package com.example.soufianebenchraa.appdouleur.Model;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {



    public static final String Ville_Key="IdVille";

    public static final String Ville_Name="NomVille";

    public static final String Ville_Table_Name="Ville";


    public static final String Ville_Table_Create=
            "CREATE TABLE "+ Ville_Table_Name + "(" +
                    Ville_Key +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Ville_Name +" TEXT)";
                    //TODO y a une clé étrangere ici ?
                    //Ville_Key +" INTEGER,FOREIGN KEY(IdVille) REFERENCES Ville(IdVille));";






    public static final String Centre_Key="IdCentre";

    public static final String Centre_Name="CentreNom";
    public static final String CityC_Key="IdVille";
    public static final String Centre_Table_Name="Centre";


    public static final String Centre_Table_Create=
            "CREATE TABLE "+ Centre_Table_Name + "(" +
                    Centre_Key +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Centre_Name +" TEXT,"+
                    CityC_Key +" INTEGER,FOREIGN KEY(IdVille) REFERENCES Ville(IdVille));";



    public static final String Service_Key="IdService";
    public static final String Service_Etage="Etage";
    public static final String Service_Ail="Ail";
    public static final String Service_Name="LibelleService";
    public static final String Service_Table_Name="Service";
    public static final String Service_Batiment="IdBatiment";

    public static final String Service_Table_Create =
            " CREATE TABLE " + Service_Table_Name + "(" +
                    Service_Key+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Service_Etage + " INTEGER,"+
                    Service_Ail + " TEXT ,"+
                    Service_Name + " TEXT," +
                    Service_Batiment + " INTEGER," +
                    "FOREIGN KEY(IdBatiment) REFERENCES Batiment(IdBatiment))";



    public static final String Lit_Key="IdLit";
    public static final String Lit_Service="IdService";
    public static final String Lit_NumeroLit="IdNumeroLit";
    public static final String Lit_Table_Name="Lit";

    public static final String Lit_Table_Create =
            "CREATE TABLE " + Lit_Table_Name + "(" +
                    Lit_Key + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Lit_Service + " INTEGER,"+
                    Lit_NumeroLit + " INTEGER)";


    public static final String Medecin_Key = "IdMedecin";
    public static final String Medecin_FName ="PrenomMedecin";
    public static final String Medecin_LName ="NomMedecin";
    public static final String Medecin_Number ="NumeroMedecin";
    public static final String Medecin_Pseudo = "MedecinPatient";
    public static final String Medecin_MotDePasse = "MedecinMotDePasse";
    public static final String Medecin_Table_NAME = "Medecin";

    public static final String Medecin_Table_Create =

            "CREATE TABLE " + Medecin_Table_NAME + "(" +
                    Medecin_Key + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Medecin_FName + " TEXT,"+
                    Medecin_LName + " TEXT,"+
                    Medecin_Number + " INTEGER,"+
                    Medecin_Pseudo +" TEXT,"+
                    Medecin_MotDePasse +" TEXT)";


    public static final String Patient_KEY = "IdPatient";

    public static final String Patient_FName = "NomPatient";

    public static final String Patient_LName = "PrenomPatient";

    public static final String Patient_Lit = "IdLit";
    public static final String Patient_Medecin="IdMedecin";
    public static final String Patient_Birthdate = "DateNaissancePatient";

    public static final String Patient_Sexe = "SexePatient";
    public static final String Patient_Pseudo = "PseudoPatient";
    public static final String Patient_Etat = "EtatPatient";
    public static final String Patient_MotDePasse = "PatientMotDePasse";


    public static final String Patient_TABLE_NAME = "Patient";

    public static final String Patient_TABLE_CREATE =

            "CREATE TABLE " + Patient_TABLE_NAME + " (" +

                    Patient_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Patient_FName + " TEXT, " +
                    Patient_LName + " TEXT," +
                    Patient_Birthdate + "TEXT,"+
                    Patient_Sexe + " TEXT,"+
                    Patient_Lit + " INTEGER, " +
                    Patient_Medecin +" INTEGER,"+
                    Patient_Pseudo +" TEXT,"+
                    Patient_MotDePasse +" TEXT,"+
                    Patient_Etat +" INTEGER,"+


                    " FOREIGN KEY(IdLit) REFERENCES Lit(IdLit) ,FOREIGN KEY(IdMedecin) REFERENCES Medecin(IdMedecin) );";



    public static final String Douleur_Key= "IdDouleur";

    public static final String Patient_id= "IdPatient";
    public static final String Douleur_Intensity="Intensite";
    public static final String Douleur_Time="TempsDouleur";
    public static final String Douleur_Body="CodePartie";

    public static final String Douleur_Table_Name="Douleur";

    public static final String Douleur_Table_Create =
            "CREATE TABLE " + Douleur_Table_Name + "("+
                    Douleur_Key+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Patient_id + "  INTEGER ,"+
                    Douleur_Intensity + " INTEGER ,"+
                    Douleur_Time + " TEXT,"+
                    Douleur_Body + " TEXT" +
                    ", FOREIGN KEY(IdPatient) REFERENCES Patient(PatientId));";


    public static final String Intervention_Key ="IdTypeIntervention";
    public static final String Intervention_Name ="LibelleTypeIntevention";

    public static final String Intervention_Table_Name="TypeIntervention";

    public static final String Intervention_Table_Create =
            "CREATE TABLE "+ Intervention_Table_Name + "(" +
                    Intervention_Key + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Intervention_Name + " TEXT);";




    public static final String Subit_Patient="IdPatient";
    public static final String Subit_Intervention="IdTypeIntervention";
    public static final String Subit_Date="DateIntervention";
    public static final String Subit_Heure="HeureIntervention";

    public static final String Subit_Table_Name="Subit";

    public static final String Subit_Table_Create =
            "CREATE TABLE " + Subit_Table_Name + "("+
                    Subit_Patient+ " INTEGER ,"+
                    Subit_Intervention + " INTEGER,"+
                    Subit_Date + " DATE," +
                    Subit_Heure +" TEXT"+
                    ",FOREIGN KEY(IdPatient) REFERENCES Patient(PatientId)" +
                    ",FOREIGN KEY(IdTypeIntervention) REFERENCES TypeIntervention(IdTypeIntervention));";



    public static final String Hopital_Key="IdHopital";
    public static final String Hopital_Name="NomHopital";
    public static final String CentreH_Key="IdCentre";

    public static final String Hopital_Table_Name="Hopital";

    public static final String Hopital_Table_Create =
            "CREATE TABLE " + Hopital_Table_Name + "("+
                    Hopital_Key+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    Hopital_Name + " TEXT,"+
                    CentreH_Key + " INTEGER" +
                    ",FOREIGN KEY(IdCentre) REFERENCES Centre(IdCentre));";

    public static final String Batiment_Key="IdBatiment";
    public static final String Batiment_Name="NomBatiment";
    public static final String HopitalB_Key="IdHopital";

    public static final String Batiment_Table_Name="Batiment";

    public static final String Batiment_Table_Create =
            "CREATE TABLE " + Batiment_Table_Name + "("+
                    Batiment_Key+ " INTEGER PRIMARY KEY AUTOINCREMENT ,"+
                    Batiment_Name + " TEXT,"+
                    HopitalB_Key + " INTEGER" +
                    ",FOREIGN KEY(IdBatiment) REFERENCES Hopital(IdBatiment));";


    public DatabaseHandler(Context context, String name, CursorFactory factory, int version) {

        super(context, name, factory, version);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Ville_Table_Create);
        db.execSQL(Centre_Table_Create);
        db.execSQL(Hopital_Table_Create);
        db.execSQL(Batiment_Table_Create);
        db.execSQL(Service_Table_Create);
        db.execSQL(Lit_Table_Create);
        db.execSQL(Patient_TABLE_CREATE);
        db.execSQL(Medecin_Table_Create);
        db.execSQL(Douleur_Table_Create);
        db.execSQL(Intervention_Table_Create);
        db.execSQL(Subit_Table_Create);






    }
    public static final String Service_TABLE_DROP = "DROP TABLE IF EXISTS " + Service_Table_Name + ";";
    public static final String Lit_TABLE_DROP = "DROP TABLE IF EXISTS " + Lit_Table_Name + ";";
    public static final String Patient_TABLE_DROP = "DROP TABLE IF EXISTS " + Patient_TABLE_NAME + ";";
    public static final String Douleur_TABLE_DROP = "DROP TABLE IF EXISTS " + Douleur_Table_Name + ";";
    public static final String Intervention_TABLE_DROP = "DROP TABLE IF EXISTS " + Intervention_Table_Name + ";";
    public static final String Subit_TABLE_DROP = "DROP TABLE IF EXISTS " + Subit_Table_Name+ ";";
    public static final String Centre_TABLE_DROP = "DROP TABLE IF EXISTS " + Centre_Table_Name+ ";";
    public static final String Batiment_TABLE_DROP = "DROP TABLE IF EXISTS " + Batiment_Table_Name+ ";";
    public static final String Hopital_TABLE_DROP = "DROP TABLE IF EXISTS " + Hopital_Table_Name+ ";";
    public static final String Ville_TABLE_DROP = "DROP TABLE IF EXISTS " + Ville_Table_Name+ ";";


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Batiment_TABLE_DROP);
        db.execSQL(Hopital_TABLE_DROP);
        db.execSQL(Ville_TABLE_DROP);
        db.execSQL(Service_TABLE_DROP);
        db.execSQL(Patient_TABLE_DROP);
        db.execSQL(Lit_TABLE_DROP);
        db.execSQL(Douleur_TABLE_DROP);
        db.execSQL(Intervention_TABLE_DROP);
        db.execSQL(Subit_TABLE_DROP);
        db.execSQL(Centre_TABLE_DROP);


        onCreate(db);


    }

}

