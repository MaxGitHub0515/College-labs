


// Program demonstracyjny dla klasy Student i Czlowiek
// Demonstration program for Student and Czlowiek classes

public class Program {
    public static void main(String[] args) {
        // Tworzenie obiektu klasy Student
        // Creating a Student object
        Student s = new Student("Alicja", "Kowalska", Plec.K, "Warszawa, F. Szopena 80", 21, "80010100000", 5, "AA007");
        s.Wyswietl(); // Wyswietlenie informacji o studencie / Displaying student information

        System.out.println("Porownywanie obiektow klas: Student i Czlowiek");
        // Comparing objects of the Student and Czlowiek classes

        // Tworzenie obiektu klasy Czlowiek i porownanie z obiektem klasy Student
        // Creating a Czlowiek object and comparing it with the Student object
        Czlowiek c = new Czlowiek("Alicja", "Kowalska", Plec.K, "Warszawa, F. Szopena 80", 21, "80010100000");
        System.out.println("(s == c) = " + s.equals(c)); // Porownanie studenta z czlowiekiem / Comparing student with human

        // Tworzenie drugiego obiektu klasy Czlowiek i porownanie z pierwszym
        // Creating a second Czlowiek object and comparing it with the first one
        Czlowiek c1 = new Czlowiek("Alicja", "Kowalska", Plec.K, "Krakow, J. Tuwima 10", 21, "80030311111");
        System.out.println("(c == c1) = " + c.equals(c1)); // Porownanie dwoch osob / Comparing two persons

        // Tworzenie pustego obiektu klasy Student i pobranie danych od uzytkownika
        // Creating an empty Student object and reading data from the user
        Student s1 = new Student();
        s1.Wczytaj(); // Wczytywanie danych / Reading data

        // Porownanie nowego studenta z pierwszym studentem
        // Comparing the new student with the first student
        System.out.println("(s == s1) = " + s.equals(s1));
    }
}



