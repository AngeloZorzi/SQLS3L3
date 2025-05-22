package entities;

import enumerating.GenereConcerto;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    private boolean inStreaming;

    public Concerto() {}

    public Concerto(String titolo, LocalDate data, Location location, int numeroMassimoPartecipanti,
                    GenereConcerto genere, boolean inStreaming) {
        super(titolo, data, location, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}

