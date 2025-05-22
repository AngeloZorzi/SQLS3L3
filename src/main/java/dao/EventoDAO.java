package dao;

import entities.*;
import enumerating.GenereConcerto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {
    private final EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public Evento findById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();
    }

    
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }


    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartitePareggiate() {
        return em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate", PartitaDiCalcio.class)
                .getResultList();
    }


    public List<GaraDiAtletica> getGareDiAtleticaPerVincitore(Persona vincitore) {
        return em.createNamedQuery("GaraDiAtletica.getGarePerVincitore", GaraDiAtletica.class)
                .setParameter("vincitore", vincitore)
                .getResultList();
    }

    public List<GaraDiAtletica> getGareDiAtleticaPerPartecipante(Persona partecipante) {
        return em.createNamedQuery("GaraDiAtletica.getGarePerPartecipante", GaraDiAtletica.class)
                .setParameter("partecipante", partecipante)
                .getResultList();
    }



}
