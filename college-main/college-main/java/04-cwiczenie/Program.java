


// Program demonstracyjny dla klasy Student i Czlowiek
// Demonstration program for Student and Czlowiek classes

public class Program {
    public static void main(String[] args) {
 
        Student s = new Student("Alicja", "Kowalska", Plec.K, "Warszawa, F. Szopena 80", 21, "80010100000", 5, "AA007");
        s.Wyswietl();

        System.out.println("Porownywanie obiektow klas: Student i Czlowiek");

        Czlowiek c = new Czlowiek("Alicja", "Kowalska", Plec.K, "Warszawa, F. Szopena 80", 21, "80010100000");
        System.out.println("(s == c) = " + s.equals(c)); 

        Czlowiek c1 = new Czlowiek("Alicja", "Kowalska", Plec.K, "Krakow, J. Tuwima 10", 21, "80030311111");
        System.out.println("(c == c1) = " + c.equals(c1)); 


        Student s1 = new Student();
        s1.Wczytaj(); 
        System.out.println("(s == s1) = " + s.equals(s1));
    }
}



