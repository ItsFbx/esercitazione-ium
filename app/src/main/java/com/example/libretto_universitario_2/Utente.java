package com.example.libretto_universitario_2;
import java.util.ArrayList;
import java.io.Serializable;


public class Utente implements Serializable {
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String matricola;
    private String password;

    static ArrayList<Utente> utentiArrayList = new ArrayList<>();
    private ArrayList<Esame> esamiArrayList = new ArrayList<>();

    public Utente (String nome, String cognome, String dataDiNascita, String matricola, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita= dataDiNascita;
        this.matricola = matricola;
        this.password = password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getDataDiNascita() {
        return this.dataDiNascita;
    }

    public String getMatricola() {
        return this.matricola;
    }

    public String getPassword() {
        return this.password;
    }

    public static void addUtente(Utente utente) {
        utentiArrayList.add(utente);
    }

    public ArrayList<Esame> getEsamiArrayList(){return this.esamiArrayList;}

    public void aggiungiEsame (Esame esame){
        this.esamiArrayList.add(esame);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
