package org.example;
import org.example.classes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
    GestioneCatalogo gc = new GestioneCatalogo();
    Libro l1 = new Libro("100-a","harry potter", 2006,500,"J.K. Rowling", "Fantasy" );
    Libro l2 = new Libro("101-b", "The Hobbit", 1937, 310, "J.R.R. Tolkien", "Fantasy");
    Libro l3 = new Libro("102-c", "1984", 1949, 328, "George Orwell", "Dystopian");
    Libro l4 = new Libro("103-d", "Pride and Prejudice", 1813, 279, "Jane Austen", "Romance");
    Libro l5 = new Libro("104-e", "To Kill a Mockingbird", 1960, 281, "Harper Lee", "Drama");
    Rivista r6 = new Rivista("105-f", "rivista1", 2003, 250, Rivista.Periodicita.SETTIMANALE);
    List<ElementoCatalogo> list1 = new ArrayList<>();
    list1.add(l1);
    list1.add(l2);
    list1.add(l3);
    List<ElementoCatalogo> list2 = new ArrayList<>();
    list2.add(l4);
    list2.add(l5);
    list2.add(r6);

    Utente u1 = new Utente("davide", "alonzi", LocalDate.of(2004, 2, 26));
    Utente u2 = new Utente("marco", "rossi", LocalDate.of(1999, 4, 18));
    Prestito p1 = new Prestito(u1, list1, LocalDate.of(2023, 2, 15),LocalDate.of(2023, 3, 15), LocalDate.of(2023, 3, 1) );
    Prestito p2 = new Prestito(u2, list2, LocalDate.of(2023, 4, 10), LocalDate.of(2023, 5, 10), LocalDate.of(2023, 5, 5));
    Prestito p3 = new Prestito(u1, list2, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 7, 1), null);

//SALVATAGGIO ELEMENTI
//        gc.saveEle(l1);
//        gc.saveEle(l2);
//        gc.saveEle(l3);
//        gc.saveEle(l4);
//        gc.saveEle(l5);
//        gc.saveEle(r6);
//        gc.saveUser(u1);
//    gc.saveUser(u2);
//    gc.savePrestito(p1);
//    gc.savePrestito(p2);
//    gc.savePrestito(p3);

        //MEDOTI RICHIESTI
//    gc.deleteEle("109");
    gc.searchEle("100-a");
        gc.searchYear(2006);
        gc.searchAutore("J.K. Rowling");
        gc.searchTitle("h");
//        gc.prestitiTessera(u1.getTessera());
//        gc.prestitiScaduti();
    gc.close();
    }
}
