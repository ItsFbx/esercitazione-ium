package com.example.libretto_universitario_2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class ModificaProfiloActivity extends AppCompatActivity {

    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifica_profilo);
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.background));

        Utente utente=HomeActivity.utente;

        EditText editTextNome = findViewById(R.id.editTextNome);
        editTextNome.setText(HomeActivity.utente.getNome());
        EditText editTextCognome = findViewById(R.id.editTextCognome);
        editTextCognome.setText(HomeActivity.utente.getCognome());
        editTextDate = findViewById(R.id.editTextDataDiNascita);
        editTextDate.setText(HomeActivity.utente.getDataDiNascita());
        /*EditText editTextMatricola = findViewById(R.id.editTextMatricola);
        editTextMatricola.setText(HomeActivity.utente.getMatricola());*/
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        editTextPassword.setText(HomeActivity.utente.getPassword());

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        Button buttonConferma = findViewById(R.id.buttonConferma);
        Button buttonIndietro = findViewById(R.id.buttonIndietro);

        buttonIndietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModificaProfiloActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttonConferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editTextNome.getText().toString().isEmpty() && !editTextCognome.getText().toString().isEmpty() && !editTextDate.getText().toString().isEmpty() /*&& !editTextMatricola.getText().toString().isEmpty()*/ && !editTextPassword.getText().toString().isEmpty()){
                    HomeActivity.utente.setNome(editTextNome.getText().toString());
                    HomeActivity.utente.setCognome(editTextCognome.getText().toString());
                    HomeActivity.utente.setDataDiNascita(editTextDate.getText().toString());
                    /*HomeActivity.utente.setMatricola(editTextMatricola.getText().toString());*/
                    HomeActivity.utente.setPassword(editTextPassword.getText().toString());
                    Toast.makeText(getApplicationContext(),"Profilo aggiornato",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ModificaProfiloActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    if (editTextNome.getText().toString().isEmpty()){
                        editTextNome.setHintTextColor(Color.RED);
                    }
                    if (editTextCognome.getText().toString().isEmpty()){
                        editTextCognome.setHintTextColor(Color.RED);
                    }
                    if (editTextDate.getText().toString().isEmpty()){
                        editTextDate.setHintTextColor(Color.RED);
                    }
                    /*if (editTextMatricola.getText().toString().isEmpty()){
                        editTextMatricola.setHintTextColor(Color.RED);
                    }*/
                    if (editTextPassword.getText().toString().isEmpty()){
                        editTextPassword.setHintTextColor(Color.RED);
                    }
                    Toast.makeText(getApplicationContext(),"Riempi tutti i campi",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void showDatePickerDialog() {
        // Ottieni la data corrente
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Crea un DatePickerDialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                ModificaProfiloActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Incrementa il mese poiché gennaio è 0
                        month = month + 1;
                        // Formatta la data in una stringa
                        String selectedDate = dayOfMonth + "/" + month + "/" + year;
                        // Imposta la data selezionata nell'EditText
                        editTextDate.setText(selectedDate);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(ModificaProfiloActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }


}