package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@DiscriminatorValue("GARA")
@NamedQueries({
        @NamedQuery(name = "GaraDiAtletica.getGarePerVincitore",
                query = "SELECT g FROM GaraDiAtletica g WHERE g.vincitore = :vincitore"),
        @NamedQuery(name = "GaraDiAtletica.getGarePerPartecipante",
                query = "SELECT g FROM GaraDiAtletica g JOIN g.atleti a WHERE a = :partecipante")
})
public class GaraDiAtletica extends Evento {

    @ManyToMany
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;

    public GaraDiAtletica() {}

    public GaraDiAtletica(String titolo, LocalDate data, Location location, int numeroMassimoPartecipanti,
                          Set<Persona> atleti, Persona vincitore) {
        super(titolo, data, location, numeroMassimoPartecipanti);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}

