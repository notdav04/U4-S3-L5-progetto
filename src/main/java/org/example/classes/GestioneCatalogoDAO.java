package org.example.classes;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class GestioneCatalogoDAO {
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
        //ho usato questo approccio perche nell eliminazione mi diceva che non era possibile eliminare un elemento in quanto ancora presente nella tabella middle prestito_elementicatalogo

        em.getTransaction().begin();

        em.createNativeQuery("DELETE FROM prestito_elementicatalogo WHERE elementocatalogo_id = (SELECT id FROM elementi_bibliotecari WHERE isbn = :isbn)")
                .setParameter("isbn", isbn)
                .executeUpdate();
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
        List<ElementoCatalogo> results = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titoloCentrale ", ElementoCatalogo.class).setParameter("titoloCentrale", "%"+titolo+"%").getResultList();
        System.out.println("ricerca elemento per titolo o parte del titolo: " );
        results.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");

    }
    public void saveUser(Utente u){
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    public void savePrestito(Prestito p){
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    public void prestitiTessera(long tessera){
        List<ElementoCatalogo> results = em.createQuery("SELECT e FROM Prestito p JOIN p.elementiCatalogo e WHERE p.utente.tessera = :tessera AND p.dataRestituzioneEffettiva IS NULL", ElementoCatalogo.class).setParameter("tessera", tessera).getResultList();
        System.out.println("ricerca elementi non restituiti per tessera: " );
        results.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");
    }
    public void prestitiScaduti(){
        LocalDate today = LocalDate.now();
        List<Prestito> results = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista < :today", Prestito.class).setParameter("today", today).getResultList();
        System.out.println("ricerca prestiti scaduti e non restituiti: " );
        results.forEach(ele-> System.out.println(ele));
        System.out.println("----------------------------------------------");
    }
}















