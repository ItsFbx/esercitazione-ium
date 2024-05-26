package com.example.libretto_universitario_2;

public class Esame {
    String nome;
    int cfu;
    int voto;

    public Esame(String nome, int cfu, int voto){
        this.nome = nome;
        this.cfu = cfu;
        this.voto = voto;
    }

    public String getNome() {
        return this.nome;
    }

    public int getCfu() {
        return this.cfu;
    }

    public int getVoto() {
        return this.voto;
    }
}
