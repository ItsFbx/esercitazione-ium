package com.example.libretto_universitario_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    ProfiloFragment profiloFragment = new ProfiloFragment();
    EsamiFragment esamiFragment = new EsamiFragment();
    MediaFragment mediaFragment = new MediaFragment();

    AggiungiEsameFragment aggiungiEsameFragment = new AggiungiEsameFragment();
    public static Utente utente;

    public static void setUtente(Utente utente){
        HomeActivity.utente = utente;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,profiloFragment).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int item = menuItem.getItemId();
                if (item == R.id.profilo){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,profiloFragment).commit();
                    return true;
                }

                if (item == R.id.esami){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,esamiFragment).commit();
                    return true;
                }

                if (item == R.id.media){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,mediaFragment).commit();
                    return true;
                }

                if (item == R.id.aggiungiEsame){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,aggiungiEsameFragment).commit();
                    return true;
                }
                return false;
            }
        });


    }
}