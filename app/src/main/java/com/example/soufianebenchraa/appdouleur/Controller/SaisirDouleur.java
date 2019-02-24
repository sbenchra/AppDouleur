package com.example.soufianebenchraa.appdouleur.Controller;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.soufianebenchraa.appdouleur.Model.Douleur;
import com.example.soufianebenchraa.appdouleur.Model.DouleurDAO;
import com.example.soufianebenchraa.appdouleur.Model.Patient;
import com.example.soufianebenchraa.appdouleur.R;
import com.example.soufianebenchraa.appdouleur.utils.ModalDouleur;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.graphics.Bitmap;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
public class SaisirDouleur extends AppCompatActivity implements Serializable
        {
    Patient patient;
    ModalDouleur editNameDialogFragment;
    ImageView image;
    Douleur douleur;
    DouleurDAO douleurdao;
    String partieCorps="";
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.douleurhomme);
        Intent intent = getIntent();


        ImageView iv = (ImageView) findViewById (R.id.imageView);


         patient = (Patient) intent.getSerializableExtra("patient");

    }



    public String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strDate = mdformat.format(calendar.getTime());

        return strDate;
    }
    public void un(View un){

         douleur =new Douleur(getCurrentTime(),partieCorps, 1,patient);
        douleurdao.ajouterDouleur(douleur);

    }
    public void deux(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 2,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void trois(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 3,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void quatre(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 4,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void cinq(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 5,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void six(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 6,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void sept(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 7,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void huit(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 8,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void neuf(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 9,patient);
        douleurdao.ajouterDouleur(douleur);
    }
    public void dix(View un){
        douleur =new Douleur(getCurrentTime(),partieCorps, 10,patient);
        douleurdao.ajouterDouleur(douleur);
    }


            public void TH1(View view){
                onCreateContextMenu();
                partieCorps="TH1";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }



            public void TH2(View view){
                onCreateContextMenu();
                partieCorps="TH2";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH3(View view){
                onCreateContextMenu();
                partieCorps="TH3";Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();


            }
            public void TH4(View view){
                onCreateContextMenu();
                partieCorps="TH4";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH5(View view){
                onCreateContextMenu();
                partieCorps="TH5";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH6(View view){
                onCreateContextMenu();
                partieCorps="TH6";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH7(View view){
                onCreateContextMenu();
                partieCorps="TH7";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH8(View view){
                onCreateContextMenu();
                partieCorps="TH8";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH9(View view){
                onCreateContextMenu();
                partieCorps="TH9";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void TH10(View view){
                partieCorps="TH10";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
                onCreateContextMenu();
            }
            public void TH11(View view){
                partieCorps="TH11";

                onCreateContextMenu();
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }
            public void TH12(View view){
                partieCorps="TH12";

                onCreateContextMenu();
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }
            public void C3(View view){
                partieCorps="C3";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
                onCreateContextMenu();
            }
            public void C4(View view){
                onCreateContextMenu();
                partieCorps="C4";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();

            }

            public void C5(View view){
                onCreateContextMenu();
                partieCorps="C5";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }

            public void C6(View view){
                onCreateContextMenu();
                partieCorps="C6";
                Toast.makeText(this,"Vous avez touché la partie"+ partieCorps, Toast.LENGTH_SHORT).show();
            }

            public void C7(View view){
                onCreateContextMenu();
                partieCorps="C7";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }

            public void C8(View view){
                onCreateContextMenu();
                partieCorps="C8";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }

            public void L1(View view){
                onCreateContextMenu();
                partieCorps="L1";
                Toast.makeText(this,"Vous avez touché la partie"+ partieCorps, Toast.LENGTH_SHORT).show();

            }
            public void L2(View view){
                onCreateContextMenu();
                partieCorps="L2";

                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }
            public void L3(View view){
                onCreateContextMenu();
                partieCorps="L3";

                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }
            public void L4(View view){
                onCreateContextMenu();
                partieCorps="L4";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();
            }
            public void L5(View view){
                onCreateContextMenu();
                partieCorps="L5";
                Toast.makeText(this, "Vous avez touché la partie"+partieCorps, Toast.LENGTH_SHORT).show();            }

            public void onCreateContextMenu()
    {
        FragmentManager fm = getSupportFragmentManager();
        editNameDialogFragment = ModalDouleur.newInstance("Saisir douleur");
        editNameDialogFragment.show(fm, "fragment_edit_name");

    }



        }

