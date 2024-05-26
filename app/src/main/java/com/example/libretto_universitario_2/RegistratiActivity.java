package com.example.libretto_universitario_2;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.libretto_universitario_2.Utente;

import java.util.Calendar;

public class RegistratiActivity extends AppCompatActivity {

    private EditText editTextDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati);

        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextCognome = findViewById(R.id.editTextCognome);
        editTextDate = findViewById(R.id.editTextDataDiNascita);
        EditText editTextMatricola = findViewById(R.id.editTextMatricola);
        EditText editTextPassword= findViewById(R.id.editTextPassword);

        Button buttonRegistrati = findViewById(R.id.buttonRegistrati);
        Button buttonBack = findViewById(R.id.buttonBack);

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean utenteEsistente = false;
                editTextNome.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                editTextCognome.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                editTextDate.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                editTextMatricola.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));
                editTextPassword.setHintTextColor(ContextCompat.getColor(getApplicationContext(),R.color.hint));

                if(!editTextNome.getText().toString().isEmpty() && !editTextCognome.getText().toString().isEmpty() && !editTextDate.getText().toString().isEmpty() && !editTextMatricola.getText().toString().isEmpty() && !editTextPassword.getText().toString().isEmpty()){
                    for (Utente utente : Utente.utentiArrayList){
                        if (utente.getMatricola().equals(editTextMatricola.getText().toString())){
                            utenteEsistente = true;
                            Toast.makeText(RegistratiActivity.this, "Utente già registrato!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    if (!utenteEsistente){
                        Utente.addUtente(new Utente(editTextNome.getText().toString(), editTextCognome.getText().toString(), editTextDate.getText().toString(), editTextMatricola.getText().toString(), editTextPassword.getText().toString()));
                        Toast.makeText(RegistratiActivity.this, "Utente creato!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
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
                    if (editTextMatricola.getText().toString().isEmpty()){
                        editTextMatricola.setHintTextColor(Color.RED);
                    }
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
                RegistratiActivity.this,
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
}