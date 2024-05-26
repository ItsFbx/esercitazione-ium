package com.example.libretto_universitario_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MediaFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_media, container, false);
        int numCFU=0;
        int numEsami=HomeActivity.utente.getEsamiArrayList().size();
        float media=0;
        float mediaPonderata=0;
        float votoDiLaurea=0;

        TextView textViewMediaMatematica = view.findViewById(R.id.textViewMediaMatematica);
        TextView textViewMediaPonderata = view.findViewById(R.id.textViewMediaPonderata);
        TextView textViewVotoDiLaurea = view.findViewById(R.id.textViewVotoDiLaurea);

        for (Esame esame: HomeActivity.utente.getEsamiArrayList()){
            media+=esame.getVoto();
        }
        media=media/numEsami;
        textViewMediaMatematica.setText(media+"");

        for (Esame esame: HomeActivity.utente.getEsamiArrayList()){
            mediaPonderata+=esame.getVoto()*esame.getCfu();
            numCFU+=esame.getCfu();
        }
        mediaPonderata=mediaPonderata/numCFU;
        textViewMediaPonderata.setText(mediaPonderata+"");
        votoDiLaurea=(mediaPonderata*110)/30;
        textViewVotoDiLaurea.setText(votoDiLaurea+"");

        return view;
    }
}