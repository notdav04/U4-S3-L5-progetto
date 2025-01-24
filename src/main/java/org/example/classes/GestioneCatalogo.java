package org.example.classes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GestioneCatalogo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("saveEle");
    private EntityManager em = emf.createEntityManager();
    public void saveEle(ElementoCatalogo ele){
        em.getTransaction().begin();
        em.persist(ele);
        em.getTransaction().commit();
        System.out.println("aggiunto elemento: " + ele);

    }
    public void close(){
        em.close();
        emf.close();
    }

    public void deleteEle(String isbn){
        em.getTransaction().begin();
        em.createQuery("DELETE FROM ElementoCatalogo e WHERE e.isbn = :isbn").setParameter("isbn", isbn).executeUpdate();
        em.getTransaction().commit();
    }
    public void searchEle(String isbn){
        ElementoCatalogo result = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.isbn = :isbn", ElementoCatalogo.class).setParameter("isbn", isbn).getSingleResult();
        System.out.println("ricerca elemento: " + result);
    }
}
