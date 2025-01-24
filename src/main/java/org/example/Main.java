package org.example;
import org.example.classes.*;



/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args ) {
    GestioneCatalogo gc = new GestioneCatalogo();
    Libro l1 = new Libro("111","harry potter", 2006,500,"J.K. Rowling", "Fantasy" );
//    gc.saveEle(l1);
//    gc.deleteEle("109");
//    gc.searchEle("108");
//        gc.searchYear(2004);
//        gc.searchAutore("J.K. Rowling");
//        gc.searchTitle("h");
    gc.close();
    }
}
