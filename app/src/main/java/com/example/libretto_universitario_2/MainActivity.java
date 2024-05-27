package com.example.libretto_universitario_2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Window;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.libretto_universitario_2.Utente;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.background));

        EditText editTextMatricola = findViewById(R.id.editTextMatricola);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonAccedi = findViewById(R.id.buttonAccedi);
        Button buttonNoAccount = findViewById(R.id.buttonNoAccount);
        Utente fabio = new Utente("Fabio","Ottico","19/10/2002","66091","password");
        fabio.aggiungiEsame(new Esame("Analisi matematica",9,18));
        fabio.aggiungiEsame(new Esame("Algoritmi e strutture dati",9,30));
        fabio.aggiungiEsame(new Esame("Fisica e metodo scientifico",6,28));
        fabio.aggiungiEsame(new Esame("Fondamenti di informatica",6,28));
        fabio.aggiungiEsame(new Esame("Architettura degli elaboratori",6,26));
        fabio.aggiungiEsame(new Esame("Matematica discreta",9,20));
        fabio.aggiungiEsame(new Esame("Programmazione 1",12,28));
        fabio.aggiungiEsame(new Esame("Calcolo scientifico e metodi numerici",6,29));
        fabio.aggiungiEsame(new Esame("Dati e modelli",6,26));
        fabio.aggiungiEsame(new Esame("Elementi di economia e diritto per informatici",6,22));
        fabio.aggiungiEsame(new Esame("Fondamenti di programmazione web" ,6,26));
        fabio.aggiungiEsame(new Esame("Programmazione 2",9,28));
        fabio.aggiungiEsame(new Esame("Reti di calcolatori",9,23));
        fabio.aggiungiEsame(new Esame("Sistemi operativi",12,26));
        fabio.aggiungiEsame(new Esame("Basi di dati",9,27));
        Utente.addUtente(fabio);


        buttonNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistratiActivity.class);
                startActivity(intent);
            }
        });

        buttonAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean utenteInesistente=false;

                editTextMatricola.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                editTextPassword.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                for (Utente utente : Utente.utentiArrayList){

                    if (editTextMatricola.getText().toString().equals(utente.getMatricola()) && editTextPassword.getText().toString().equals(utente.getPassword()) && !editTextMatricola.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        HomeActivity.setUtente(utente);
                        utenteInesistente=false;
                        startActivity(intent);
                    }
                    else if (editTextMatricola.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()){
                        if (editTextMatricola.getText().toString().isEmpty()) {
                            editTextMatricola.setHintTextColor(Color.RED);
                        }
                        if (editTextPassword.getText().toString().isEmpty()) {
                            editTextPassword.setHintTextColor(Color.RED);
                        }
                        Toast.makeText(getApplicationContext(),"Riempi tutti i campi",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        utenteInesistente=true;
                    }

                }
                if(utenteInesistente){
                    Toast.makeText(getApplicationContext(), "Credenziali errate", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}