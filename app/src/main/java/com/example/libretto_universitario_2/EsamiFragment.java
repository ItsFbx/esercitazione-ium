package com.example.libretto_universitario_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;


public class EsamiFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_esami, container, false);
        ListView listViewEsami= view.findViewById(R.id.listViewEsami);
        AdattatoreEsame adattatoreEsame = new AdattatoreEsame(getContext(),HomeActivity.utente.getEsamiArrayList());
        listViewEsami.setAdapter(adattatoreEsame);

        return view;
    }
}