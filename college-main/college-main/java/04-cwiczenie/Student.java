// Klasa Student dziedziczy po klasie Czlowiek i dodaje dane dotyczace studiow
// The Student class inherits from Czlowiek and adds academic-related data
// super => 
/*
super() przekazujemy parametry, które są następnie przekazywane do konstruktora klasy bazowej (superklasy). 
Te parametry są używane do inicjalizacji pól lub wykonania logiki w konstruktorze klasy bazowej.



*/
public class Student extends Czlowiek {
    private int semestr;   // Numer semestru / Semester number
    private String album;  // Numer albumu studenta / Student's record book number

    // Konstruktor inicjalizujacy wszystkie pola
    // Constructor initializing all fields
    public Student(String imie, String nazwisko, Plec plec, String adres, int wiek, String pesel, int semestr, String album) {
        super(imie, nazwisko, plec, adres, wiek, pesel);
        this.semestr = semestr;
        this.album = album;
    }

    // Konstruktor domyslny
    // Default constructor
    public Student() {}

    // Metoda do wczytywania danych studenta od uzytkownika
    // Method for reading student data from the user
    public void Wczytaj() {
        System.out.println("Wczytywanie danych studenta");
        super.Wczytaj(); // Wywolanie metody wczytywania danych z klasy Czlowiek / Calling the data reading method from Czlowiek class
        this.semestr = WczytajInt("Semestr"); // Wczytywanie semestru / Reading semester
        this.album = WczytajString("Album"); // Wczytywanie numeru albumu / Reading student record book number
    }

    // Metoda do wyswietlania danych studenta
    // Method for displaying student data
    public void Wyswietl() {
        System.out.println("Wyswietlanie danych o studencie");
        super.Wyswietl(); // Wywolanie metody wyswietlania danych z klasy Czlowiek / Calling the display method from Czlowiek class
        System.out.println("Semestr: " + semestr);
        System.out.println("Album: " + album);
        System.out.println();
    }
}


