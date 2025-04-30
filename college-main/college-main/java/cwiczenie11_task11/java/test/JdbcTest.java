package test;

import java.util.List;
import model.Czytelnik;
import model.Ksiazka;
import biblioteka.Biblioteka;

public class JdbcTest {
    public static void main(String[] args) {
        Biblioteka b = new Biblioteka();
        
        // Insert test data
        b.insertCzytelnik("Karol", "Bebys", "94873847182");
        b.insertCzytelnik("Piotr", "Nowakowski", "51243849128");
        b.insertKsiazka("Java. Efektywne programowanie", "Joshua Bloch");
        b.insertKsiazka("W pustyni i w puszczy", "Henryk Sienkiewicz");
        
        // Retrieve and print data
        List<Czytelnik> czytelnicy = b.selectCzytelnicy();
        List<Ksiazka> ksiazki = b.selectKsiazki();
        
        System.out.println("Czytelnicy:");
        for (Czytelnik c : czytelnicy) System.out.println(c);
        
        System.out.println("\nKsiazki:");
        for (Ksiazka k : ksiazki) System.out.println(k);
        
        b.closeConnection();
    }
}
