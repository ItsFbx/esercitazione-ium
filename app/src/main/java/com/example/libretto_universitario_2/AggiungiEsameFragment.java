package com.example.libretto_universitario_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class AggiungiEsameFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_aggiungi_esame, container, false);
        TextView nomeEsame = view.findViewById(R.id.nomeEsame);
        EditText editTextNomeEsame = view.findViewById(R.id.editTextNome);
        EditText editTextVotoEsame = view.findViewById(R.id.editTextVoto);
        EditText editTextCfu = view.findViewById(R.id.editTextCFU);
        Button buttonAggiungiEsame = view.findViewById(R.id.buttonAggiungiEsame);

        buttonAggiungiEsame.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (!editTextNomeEsame.getText().toString().isEmpty() && !editTextCfu.getText().toString().isEmpty() && !editTextVotoEsame.getText().toString().isEmpty()){
                    HomeActivity.utente.aggiungiEsame(new Esame(editTextNomeEsame.getText().toString(),Integer.parseInt(editTextCfu.getText().toString()),Integer.parseInt(editTextVotoEsame.getText().toString())));
                    Toast.makeText(getActivity(),"Esame aggiunto",Toast.LENGTH_SHORT).show();
                    editTextNomeEsame.setHintTextColor(ContextCompat.getColor(getContext(),R.color.hint));
                    editTextCfu.setHintTextColor(ContextCompat.getColor(getContext(),R.color.hint));
                    editTextVotoEsame.setHintTextColor(ContextCompat.getColor(getContext(),R.color.hint));
                }
                else {
                    Toast.makeText(getActivity(),"Riempi tutti i campi",Toast.LENGTH_SHORT).show();
                    if (editTextNomeEsame.getText().toString().isEmpty()){
                        editTextNomeEsame.setHintTextColor(Color.RED);
                    }
                    if (editTextCfu.getText().toString().isEmpty()){
                        editTextCfu.setHintTextColor(Color.RED);
                    }
                    if (editTextVotoEsame.getText().toString().isEmpty()){
                        editTextVotoEsame.setHintTextColor(Color.RED);
                    }
                }
            }
        });

        return view;
    }
}