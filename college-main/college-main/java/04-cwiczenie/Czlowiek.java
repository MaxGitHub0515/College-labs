import java.io.BufferedReader;
import java.io.InputStreamReader;

// Klasa Czlowiek reprezentuje osobe z podstawowymi danymi osobowymi
// The Czlowiek class represents a person with basic personal data

public class Czlowiek {
    private String imie;
    private String nazwisko;
    private String adres; 
    private int wiek;       
    private Plec plec;      
    private String pesel;   

    // Konstruktor inicjalizujacy wszystkie pola
    // Constructor initializing all fields
    public Czlowiek(String imie, String nazwisko, Plec plec, String adres, int wiek, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.wiek = wiek;
        this.plec = plec;
        this.pesel = pesel;
    }

    // Konstruktor domyslny
    // Default constructor
    public Czlowiek() {}

    // Metoda do wczytywania ciagu znakow z konsoli
    // Method for reading a string from the console
    protected String WczytajString(String nazwa) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(nazwa + ": ");
            String s = in.readLine();
            if (s.length() > 0)
                return s;
            else
                return WczytajString(nazwa); // Rekurencyjne ponowne pytanie w przypadku pustego wejscia / Recursive retry on empty input
        } catch (Exception e) {
            return WczytajString(nazwa); // Ponowienie pytania w przypadku bledu / Retry in case of error
        }
    }

    // Metoda do wczytywania liczby calkowitej z konsoli
    // Method for reading an integer from the console
    protected int WczytajInt(String nazwa) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(nazwa + "= ");
            String s = in.readLine();
            int zmienna = Integer.parseInt(s);
            return zmienna;
        } catch (Exception e) {
            System.err.println("Blad! To nie jest liczba!");
            return WczytajInt(nazwa); // Rekurencyjne pytanie w przypadku bledu / Recursive retry on error
        }
    }

    // Metoda do wczytywania danych osoby od uzytkownika
    // Method for reading person data from the user
    public void Wczytaj() {
        this.imie = WczytajString("Imie");
        this.nazwisko = WczytajString("Nazwisko");
        boolean sukces = false;
        do {
            String p = WczytajString("Plec (M/K)");
            p = p.toUpperCase();
            if (p.charAt(0) == 'M') {
                this.plec = Plec.M;
                sukces = true;
            }
            if (p.charAt(0) == 'K') {
                this.plec = Plec.K;
                sukces = true;
            }
        } while (!sukces); // Petla do momentu poprawnego wyboru pleci / Loop until gender selection is correct
        this.pesel = WczytajString("Pesel");
    }

    // Metoda wyswietlajaca dane osoby
    // Method displaying person data
    public void Wyswietl() {
        System.out.println("Imie: " + this.imie);
        System.out.println("Nazwisko: " + this.nazwisko);
        System.out.println("Plec: " + this.plec);
        System.out.println("Adres: " + this.adres);
        System.out.println("Wiek: " + this.wiek);
        System.out.println("Pesel: " + this.pesel);
    }
    public boolean equals(Object o) {
        if (o instanceof Czlowiek) {
            Czlowiek c = (Czlowiek) o;
            return this.pesel.equals(c.pesel);
        }
        return false;
    }
}

