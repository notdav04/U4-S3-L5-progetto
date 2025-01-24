package org.example.classes;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Table(name = "riviste")
public class Rivista extends ElementoCatalogo{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public enum Periodicita{
        SETTIMANALE,
        MENSILE,
        SEMESTRALE
    }
public Rivista(){};

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn,titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "isbn=" + super.getIsbn() +
                ", titolo='" + super.getTitolo() + '\'' +
                ", annoPubblicazione=" + super.getAnnoPubblicazione() +
                ", numeroPagine=" + super.getNumeroPagine() +
                ", periodicita=" + periodicita +
                '}';
    }
}
