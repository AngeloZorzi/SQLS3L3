package dao;

import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location l) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(l);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }

    public Location findById(Long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location l) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(l);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }
    }
}

