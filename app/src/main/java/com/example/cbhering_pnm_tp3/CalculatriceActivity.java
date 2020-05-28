package com.example.cbhering_pnm_tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalculatriceActivity extends AppCompatActivity {

    //Déclaration des variables
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAddition, btnSous, btnMult, btnDiv, btnEffacer, btnEgal, btnPoint;
    TextView affichage;
    private double chiffre1;
    private boolean cliqueOperateur = false;
    private boolean miseajour = false;
    private String operateur = "";

    //C'est la méthode qui va permettre d'afficher l'activité et récupérer les éléments liés au layout.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);


        //Récupération des éléments du layout de l'activité par leurs identificateurs et l'attribution
        //à des variables qui avaient été déclarées.
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnAddition = (Button) findViewById(R.id.btnAddition);
        btnSous = (Button) findViewById(R.id.btnSous);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEffacer = (Button) findViewById(R.id.btnEffacer);
        btnEgal = (Button) findViewById(R.id.btnEgal);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        affichage = (TextView) findViewById(R.id.resultat);

        // Création d'un listener pour le bouton avec l'appel de la méthode addition.
        btnAddition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueAddition();
            }
        });

        //Création d'un listener pour le bouton avec l'appel de la méthode soustraction.
        btnSous.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueSoustraction();
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode multiplication.
        btnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueMultiplication();
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode division.
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueDivision();
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode pour redemarrer.
        btnEffacer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueRedemarrer();
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode égal, laquelle
        // appele ensuite la méthode calcul pour calculer le résultat.
        btnEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueEgal();
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du point.
        btnPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre(".");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du zéro.
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("0");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre un.
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("1");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre deux.
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("2");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre trois.
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("3");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre quatre.
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("4");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre cinq.
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("5");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre six.
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("6");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre sept.
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("7");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre huit.
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("8");
            }
        });

        // Création d'un listener pour le bouton avec l'appel de la méthode qui traite le clique
        // du chiffre neuf.
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                cliqueChiffre("9");
            }
        });

    }

    //C'est la méthode qui va être exécutée lorsque l'utilisateur clique sur un chiffre. Le chiffre
    //est passé en paramètre comme string et sera ensuite affiché sur le TextView.
    public void cliqueChiffre(String str) {
        if(miseajour){
            miseajour = false;
        }else{
            if(!affichage.getText().equals("0"))
                str = affichage.getText() + str;
        }
        affichage.setText(str);
    }

    //Il s'agit de la méthode qui va nous conduire vers la méthode pour effectuer le calcul de l'addition
    //si la valeur booléene cliqueOperateur est vraie.
    public void cliqueAddition(){
        if(cliqueOperateur){
            calculerOperation();
            affichage.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(affichage.getText().toString()).doubleValue();
            cliqueOperateur = true;
        }
        operateur = "+";
        miseajour = true;
    }

    //Il s'agit de la méthode qui va nous conduire vers la méthode pour effectuer le calcul de la soustraction
    //si la valeur booléene cliqueOperateur est vraie.
    public void cliqueSoustraction(){
        if(cliqueOperateur){
            calculerOperation();
            affichage.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(affichage.getText().toString()).doubleValue();
            cliqueOperateur = true;
        }
        operateur = "-";
        miseajour = true;
    }

    //Il s'agit de la méthode qui va nous conduire vers la méthode pour effectuer le calcul de la multiplication
    //si la valeur booléene cliqueOperateur est vraie.
    public void cliqueMultiplication(){
        if(cliqueOperateur){
            calculerOperation();
            affichage.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(affichage.getText().toString()).doubleValue();
            cliqueOperateur = true;
        }
        operateur = "x";
        miseajour = true;
    }

    //Il s'agit de la méthode qui va nous conduire vers la méthode pour effectuer le calcul de la division
    //si la valeur booléene cliqueOperateur est vraie.
    public void cliqueDivision(){
        if(cliqueOperateur){
            calculerOperation();
            affichage.setText(String.valueOf(chiffre1));
        }else{
            chiffre1 = Double.valueOf(affichage.getText().toString()).doubleValue();
            cliqueOperateur = true;
        }
        operateur = "/";
        miseajour = true;
    }

    //Il s'agit de la méthode qui va nous conduire vers la méthode pour calculer le résultat
    //de l'expression mathématique.
    public void cliqueEgal(){
        calculerOperation();
        miseajour = true;
        cliqueOperateur = false;
    }

    //C'est la méthode qui va effacer l'écran d'affichage du résultat pour que l'opération puisse
    //être redémarrée.
    public void cliqueRedemarrer(){
        cliqueOperateur = false;
        miseajour = true;
        chiffre1 = 0;
        operateur = "";
        affichage.setText("0");
    }

    //Méthode qui va effectuer les calculs mathématiques selon l'opérateur choisi.
    private void calculerOperation(){
        if(operateur.equals("+")){
            chiffre1 = chiffre1 + Double.valueOf(affichage.getText().toString()).doubleValue();
            affichage.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("-")){
            chiffre1 = chiffre1 - Double.valueOf(affichage.getText().toString()).doubleValue();
            affichage.setText(String.valueOf(chiffre1));
        }

        if(operateur.equals("x")){
            chiffre1 = chiffre1 * Double.valueOf(affichage.getText().toString()).doubleValue();
            affichage.setText(String.valueOf(chiffre1));
        }

        //Nous avons traité ci-dessous l'exception de la division par zéro.
        if(operateur.equals("/")){
            try{
                chiffre1 = chiffre1 / Double.valueOf(affichage.getText().toString()).doubleValue();
                affichage.setText(String.valueOf(chiffre1));
            }catch(ArithmeticException e){
                affichage.setText("0");
            }
        }
    }
}
