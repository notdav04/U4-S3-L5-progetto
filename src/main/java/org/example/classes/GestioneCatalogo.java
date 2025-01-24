package org.example.classes;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class GestioneCatalogo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("saveEle");
    private EntityManager em = emf.createEntityManager();
    public void saveEle(ElementoCatalogo ele){
        em.getTransaction().begin();
        em.persist(ele);
        em.getTransaction().commit();
        System.out.println("aggiunto elemento: " + ele);
        System.out.println("----------------------------------------------");
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
        System.out.println("ricerca elemento per isbn: " + result);
        System.out.println("----------------------------------------------");
    }

    public void searchYear(int year){
        List<ElementoCatalogo> result = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno_pubblicazione", ElementoCatalogo.class).setParameter("anno_pubblicazione", year).getResultList();
        System.out.println("ricerca elemento per anno: " );
        result.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");
    }

    public void searchAutore(String autore){
        List<ElementoCatalogo> results = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE TYPE(e) = Libro AND e.autore = :autore", ElementoCatalogo.class).setParameter("autore", autore.toUpperCase()).getResultList();
        System.out.println("ricerca elemento per autore: " );
        results.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");
    }
    public void searchTitle(String titolo){
        List<ElementoCatalogo> results = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titoloInizio OR e.titolo LIKE :titoloCentrale OR e.titolo LIKE :titoloFine ", ElementoCatalogo.class).setParameter("titoloInizio", titolo + "%").setParameter("titoloCentrale", "%"+titolo+"%").setParameter("titoloFine", "%" + titolo).getResultList();
        System.out.println("ricerca elemento per titolo o parte del titolo: " );
        results.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");

    }
}















