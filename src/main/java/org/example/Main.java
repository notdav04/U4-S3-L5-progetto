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
    Libro l1 = new Libro("110","harry potter", 2004,500,"J.K. Rowling", "Fantasy" );
    gc.saveEle(l1);
    gc.deleteEle("109");
    gc.searchEle("108");
    gc.close();
    }
}
