import java.util.ArrayList;

public class Utente {
    private String nome;
    private String cognome;
    private String dataDiNascita;
    private String matricola;
    private String password;

    static ArrayList<Utente> utentiArrayList = new ArrayList<Utente>();

    public Utente (String nome, String cognome, String dataDiNascita, String matricola, String password){
        this.nome = nome;
        this.cognome = cognome;
        this. dataDiNascita= dataDiNascita;
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
}
