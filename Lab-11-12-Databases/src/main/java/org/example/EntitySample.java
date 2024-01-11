package org.example;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EntitySample {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EntitySample() {
        // should match the persistence unit name in your persistence.xml
        emf = Persistence.createEntityManagerFactory("warehouse");
        em = emf.createEntityManager();
    }

    public void addWarehouseItem(AnEntity item) {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
    }

    public AnEntity findWarehouseItem(int id) {
        return em.find(AnEntity.class, id);
    }

    public void updateWarehouseItem(AnEntity item) {
        em.getTransaction().begin();
        em.merge(item);
        em.getTransaction().commit();
    }

    public void deleteWarehouseItem(int id) {
        AnEntity item = em.find(AnEntity.class, id);
        if (item != null) {
            em.getTransaction().begin();
            em.remove(item);
            em.getTransaction().commit();
        }
    }

    public List<AnEntity> getAllWarehouseItems() {
        TypedQuery<AnEntity> query = em.createQuery("SELECT e FROM AnEntity e", AnEntity.class);
        return query.getResultList();
    }

    public void close() {
        em.close();
        emf.close();
    }
}
