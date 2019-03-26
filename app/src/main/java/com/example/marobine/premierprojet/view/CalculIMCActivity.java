package com.example.marobine.premierprojet.view;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marobine.premierprojet.R;
import com.example.marobine.premierprojet.controller.Control;

public class CalculIMCActivity extends AppCompatActivity {

    //propriétés / attributs
    private EditText textPoids;
    private EditText textTaille;
    private RadioButton RadioHomme;
    //pas besoin de récupérerles deux boutons radios, vu que seul l'un des 2 est coché
    private TextView lblIMC;
    private ImageView imgIMC;

    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imc_activity);
        // faire les liens avec les objets graphiques
        init();
    }

    // méthode locale pour faire les liens entre les propriétés et les composants graphiques
    /**
     * initialisation des liens avec les objets graphiques
     */
    private void init() {
        // (EditText) pour récupérer le bon type d'objet graphique
        textPoids = (EditText) findViewById(R.id.textPoids);
        textTaille = (EditText) findViewById(R.id.textTaille);
        RadioHomme = (RadioButton) findViewById(R.id.RadioHomme);
        lblIMC = (TextView) findViewById(R.id.lblIMC);
        imgIMC = (ImageView) findViewById(R.id.imgIMC);
        this.control = Control.getInstance(this);
        clicCalculer();
        recupererProfil();
    }

    private void clicCalculer() {
        // appel de l'évènement
        ((Button) findViewById(R.id.btCalc)).setOnClickListener(new Button.OnClickListener() {
            // on redéfini à la volée la méthode onClick
            public void onClick(View v) {
                // va s'executer quand on va cliquer sur le bouton
                float poids = 0;
                float taille = 0;
                int sexe = 0; // femme par défaut
                // Récupération des données saisies
                try {
                    poids = Float.parseFloat(textPoids.getText().toString());
                    taille = Float.parseFloat(textTaille.getText().toString());
                } catch (Exception e) {
                // On ne met rien car on ne veut qu'il ne se passe rien.
                // On garde les valeurs à zéro pour les variables poids et taille
                }
                if (RadioHomme.isChecked()) {
                    sexe=1;
                }
                //Contrôle des données saisies
                if (poids == 0 || taille == 0) {
                    // affichage d'un message temporaire d'erreur à l'écran
                    Toast.makeText(CalculIMCActivity.this, "Saisie incorrecte",
                    Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CalculIMCActivity.this, "Données mises à jour ?", Toast.LENGTH_SHORT).show();
                    afficherResultat(0, poids, taille, sexe);
                }
            }
        });
    }

    /**
     * Affichage de l'IMC, du message et de l'image
     * @param choix
     * @param poids
     * @param taille
     * @param sexe
     */
    private void afficherResultat(int choix, float poids, float taille, int sexe) {
        // Création du profil et récupération des informations
        this.control.creerProfil(choix, poids, taille, sexe, this);
        float imc = this.control.getIMC();
        String msg = this.control.getMessage();
        // Gestion de l'affichage des images en fonction des résultats
        if (sexe == 1) {
            if (msg.equals("cas de dénutrition")) {
                imgIMC.setImageResource(R.drawable.imc_homme_maigreur);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de maigreur")) {
                imgIMC.setImageResource(R.drawable.imc_homme_maigreur);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de poids ideal")) {
                imgIMC.setImageResource(R.drawable.imc_homme_normal);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de surpoids")) {
                imgIMC.setImageResource(R.drawable.imc_homme_surpoids);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité modérée")) {
                imgIMC.setImageResource(R.drawable.imc_homme_obesite);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité sévère")) {
                imgIMC.setImageResource(R.drawable.imc_homme_obsevere);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité morbide")) {
                imgIMC.setImageResource(R.drawable.imc_homme_obsevere);
                lblIMC.setTextColor(Color.GREEN);
            }
        } else if (sexe == 0) {
            if (msg.equals("cas de dénutrition")) {
                imgIMC.setImageResource(R.drawable.imc_femme_maigreur);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de maigreur")) {
                imgIMC.setImageResource(R.drawable.imc_femme_maigreur);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de poids ideal")) {
                imgIMC.setImageResource(R.drawable.imc_femme_normal);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas de surpoids")) {
                imgIMC.setImageResource(R.drawable.imc_femme_surpoids);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité modérée")) {
                imgIMC.setImageResource(R.drawable.imc_femme_obesite);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité sévère")) {
                imgIMC.setImageResource(R.drawable.imc_femme_obsevere);
                lblIMC.setTextColor(Color.GREEN);
            } else if (msg.equals("cas d'obésité morbide")) {
                imgIMC.setImageResource(R.drawable.imc_femme_obsevere);
                lblIMC.setTextColor(Color.GREEN);
            }
        }

        // formatage de l'affichage du résultat de l'IMC à deux chiffres après la virgule
        lblIMC.setText(String.format("%.01f",imc) + " : " + msg);
    }

    /*
     * Récupération du profil si des données ont été enregistrées
     * */
    public void recupererProfil () {
        if (control.getPoids() != null) {
            textPoids.setText(control.getPoids().toString());
            textTaille.setText(control.getTaille().toString());
            ((Button) findViewById(R.id.btCalc)).performClick();
        }
    }

}
