package org.example.classes;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Utenti")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tessera;
    @Column(nullable = false)
    private String nome;
    @Column (nullable = false)
    private String cognome;
    @Column(nullable = false)
    private LocalDate dataDiNascita;

    public Utente(){};

    public Utente( String nome, String cognome, LocalDate dataDiNascita) {

        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public long getTessera() {
        return tessera;
    }

    public void setTessera(long tessera) {
        this.tessera = tessera;
    }
}
