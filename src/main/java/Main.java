import dao.*;
import entities.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
        EntityManager em = emf.createEntityManager();

        try {
            // DAO
            LocationDAO locationDAO = new LocationDAO(em);
            EventoDAO eventoDAO = new EventoDAO(em);
            PersonaDAO personaDAO = new PersonaDAO(em);
            PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);


            Location location = new Location("Auditorium", "Ospitaletto");
            locationDAO.save(location);


            Evento evento = new Evento("Squirrels doom: How to survive", LocalDate.of(2025, 12, 23), location);
            eventoDAO.save(evento);


            Persona persona = new Persona("Giacomo", "Immacolato", "jackthereaper@email.com");
            personaDAO.save(persona);


            Partecipazione partecipazione = new Partecipazione(persona, evento);
            partecipazioneDAO.save(partecipazione);

            System.out.println("Dati salvati con successo!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}

