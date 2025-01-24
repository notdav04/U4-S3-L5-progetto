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
    List<ElementoCatalogo> list1 = new ArrayList<>();
    list1.add(l1);
    list1.add(l2);
    list1.add(l3);
    List<ElementoCatalogo> list2 = new ArrayList<>();
    list2.add(l4);
    list2.add(l5);
    gc.saveEle(l1);
    gc.saveEle(l2);
    gc.saveEle(l3);
    gc.saveEle(l4);
gc.saveEle(l5);
    Utente u1 = new Utente("davide", "alonzi", LocalDate.of(2004, 2, 26));
    Utente u2 = new Utente("marco", "rossi", LocalDate.of(1999, 4, 18));
    Prestito p1 = new Prestito(u1, list1, LocalDate.of(2023, 2, 15),LocalDate.of(2023, 3, 15), LocalDate.of(2023, 3, 1) );
    gc.saveUser(u1);
    gc.saveUser(u2);
    gc.savePrestito(p1);
//    gc.saveEle(l1);
//    gc.deleteEle("109");
//    gc.searchEle("108");
//        gc.searchYear(2004);
//        gc.searchAutore("J.K. Rowling");
//        gc.searchTitle("h");
//    gc.close();
    }
}
