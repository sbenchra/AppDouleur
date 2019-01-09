package com.example.soufianebenchraa.appdouleur.Model;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {



    public static final String Centre_Key="IdCentre";
    public static final String Centre_City="CentreVille";
    public static final String Centre_Name="CentreNom";
    public static final String Centre_Table_Name="Centre";


    public static final String Centre_Table_Create=
            "CREATE TABLE "+ Centre_Table_Name + "(" +
                    Centre_Key +"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Centre_Name +"TEXT,"+
                    Centre_City +"TEXT);";



    public static final String Service_Key="IdService";
    public static final String Service_Etage="Etage";
    public static final String Service_Ail="Ail";
    public static final String Service_Name="LibelleService";
    public static final String Service_Table_Name="Service";
    public static final String Service_Centre="IdCentre";

    public static final String Service_Table_Create =
            " CREATE TABLE " + Service_Table_Name + "(" +
                    Service_Key+ "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Service_Etage + "INTEGER PRIMARY KEY,"+
                    Service_Ail + "TEXT PRIMARY KEY,"+
                    Service_Name + "TEXT," +
                    Service_Centre + "INTEGER," +
                    "FOREIGN KEY(IdCentre) REFERENCES Centre(IdCentre))";



    public static final String Lit_Key="IdLit";
    public static final String Lit_Service="IdService";
    public static final String Lit_NumeroLit="IdNumeroLit";
    public static final String Lit_Table_Name="Lit";

    public static final String Lit_Table_Create =
            "CREATE TABLE " + Lit_Table_Name + "(" +
                    Lit_Key + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Lit_Service + "INTEGER,"+
                    Lit_NumeroLit + "INTEGER)";


    public static final String Medecin_Key = "IdMedecin";
    public static final String Medecin_FName ="PrenomMedecin";
    public static final String Medecin_LName ="NomMedecin";
    public static final String Medecin_Number ="NumeroMedecin";
    public static final String Medecin_Table_NAME = "Medecin";

    public static final String Medecin_Table_Create =

            "CREATE TABLE " + Medecin_Table_NAME + "(" +
                    Medecin_Key + "INTERGER PRIMARY KEY AUTOINCREMENT,"+
                    Medecin_FName + "TEXT,"+
                    Medecin_LName + "TEXT,"+
                    Medecin_Number + "INTEGER);";


    public static final String Patient_KEY = "IdPatient";

    public static final String Patient_FName = "NomPatient";

    public static final String Patient_LName = "PrenomPatient";

    public static final String Patient_Lit = "IdLit";
    public static final String Patient_Medecin="IdMedcin";
    public static final String Patient_Birthdate = "DateNaissancePatient";

    public static final String Patient_Sexe = "SexePatient";
    public static final String Patient_TABLE_NAME = "Patient";

    public static final String Patient_TABLE_CREATE =

            "CREATE TABLE " + Patient_TABLE_NAME + " (" +

                    Patient_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Patient_FName + " TEXT, " +
                    Patient_LName + " TEXT," +
                    Patient_Birthdate + "DATE,"+
                    Patient_Sexe + " TEXT,"+
                    Patient_Lit + " INTEGER, " +
                    Patient_Medecin +" INTEGER,"+
                    " FOREIGN KEY(IdLit) REFERENCES Lit(IdLit) ,FOREIGN KEY(IdMedecin) REFERENCES Medecin(IdMedecin) );";



    public static final String Douleur_Key= "IdDouleur";

    public static final String Patient_id= "IdPatient";
    public static final String Douleur_Intensity="Intensite";
    public static final String Douleur_Time="TempsDouleur";
    public static final String Douleur_Body="CodePartie";

    public static final String Douleur_Table_Name="Douleur";

    public static final String Douleur_Table_Create =
            "CREATE TABLE " + Douleur_Table_Name + "("+
                    Douleur_Key+ "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Patient_id + "  INTEGER ,"+
                    Douleur_Intensity + "INTEGER ,"+
                    Douleur_Time + "TEXT,"+
                    Douleur_Body + "TEXT" +
                    ", FOREIGN KEY(IdPatient) REFERENCES Patient(PatientId));";


    public static final String Intervention_Key ="IdTypeIntervention";
    public static final String Intervention_Name ="LibelleTypeIntevention";

    public static final String Intervention_Table_Name="TypeIntervention";

    public static final String Intervention_Table_Create =
            "CREATE TABLE "+ Intervention_Table_Name + "(" +
                    Intervention_Key + "INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    Intervention_Name + "TEXT);";




    public static final String Subit_Patient="IdPatient";
    public static final String Subit_Intervention="IdTypeIntervention";
    public static final String Subit_Date="DateIntervention";
    public static final String Subit_Heure="HeureIntervention";

    public static final String Subit_Table_Name="Subit";

    public static final String Subit_Table_Create =
            "CREATE TABLE " + Subit_Table_Name + "("+
                    Subit_Patient+ "INTEGER ,"+
                    Subit_Intervention + "INTEGER"+
                    Subit_Date + "DATE" +
                    Subit_Heure +"TEXT"+
                    ",FOREIGN KEY(IdPatient) REFERENCES Patient(PatientId)" +
                    ",FOREIGN KEY(IdTypeIntervention) REFERENCES TypeIntervention(IdTypeIntervention));";



    public DatabaseHandler(Context context, String name, CursorFactory factory, int version) {

        super(context, name, factory, version);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Centre_Table_Create);
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
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
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

