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
        float numCFU=0;
        int numEsami=HomeActivity.utente.getEsamiArrayList().size();
        float media=0f;
        float mediaPonderata=0f;
        float votoDiLaurea=0f;

        TextView textViewMediaMatematica = view.findViewById(R.id.textViewMediaMatematica);
        TextView textViewMediaPonderata = view.findViewById(R.id.textViewMediaPonderata);
        TextView textViewVotoDiLaurea = view.findViewById(R.id.textViewVotoDiLaurea);

        for (Esame esame: HomeActivity.utente.getEsamiArrayList()){
            media+=esame.getVoto();
        }
        media=media/numEsami;
        textViewMediaMatematica.setText((Math.round(media*100.0f)/100.0f)+"");

        for (Esame esame: HomeActivity.utente.getEsamiArrayList()){
            mediaPonderata+=esame.getVoto()*esame.getCfu();
            numCFU+=esame.getCfu();
        }
        mediaPonderata=mediaPonderata/numCFU;
        textViewMediaPonderata.setText((Math.round(mediaPonderata)*100.0f)/100.0f+"") ;
        votoDiLaurea=(mediaPonderata*110.0f)/30.0f;
        textViewVotoDiLaurea.setText((Math.round(votoDiLaurea*100.0f)/100.0f)+"");

        return view;
    }
}