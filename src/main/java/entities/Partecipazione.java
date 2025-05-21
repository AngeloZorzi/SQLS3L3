package entities;

import jakarta.persistence.*;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;


    public Partecipazione() {}
    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
