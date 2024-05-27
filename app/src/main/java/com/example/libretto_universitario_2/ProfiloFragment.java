package com.example.libretto_universitario_2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.libretto_universitario_2.Utente;


public class ProfiloFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);
        TextView textViewNome = view.findViewById(R.id.textViewNome);
        textViewNome.setText(HomeActivity.utente.getNome());
        TextView textViewCognome = view.findViewById(R.id.textViewCognome);
        textViewCognome.setText(HomeActivity.utente.getCognome());
        TextView textViewDataDiNascita = view.findViewById(R.id.textViewDataDiNascita);
        textViewDataDiNascita.setText(HomeActivity.utente.getDataDiNascita());
        TextView textViewMatricola = view.findViewById(R.id.textViewMatricola);
        textViewMatricola.setText(HomeActivity.utente.getMatricola());

        Button buttonModifica = view.findViewById(R.id.buttonModifica);
        buttonModifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ModificaProfiloActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
        return view;
    }


}