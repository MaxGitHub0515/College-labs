import java.io.BufferedReader;
import java.io.InputStreamReader;

// Klasa Punkt3D reprezentuje punkt w przestrzeni trojwymiarowej
// The Punkt3D class represents a point in 3D space

public class Punkt3D {
    public double X, Y, Z; // Wspolrzedne punktu / Point coordinates
    private String nazwa;  // Nazwa punktu / Point name

    // Konstruktor inicjalizujacy wspolrzedne punktu bez nazwy
    // Constructor initializing the point's coordinates without a name
    public Punkt3D(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
        nazwa = "";
    }

    // Konstruktor inicjalizujacy wspolrzedne punktu wraz z nazwa
    // Constructor initializing the point's coordinates with a name
    public Punkt3D(double x, double y, double z, String nazwa) {
        X = x;
        Y = y;
        Z = z;
        this.nazwa = nazwa;
    }

    // Metoda do wczytywania liczby zmiennoprzecinkowej z konsoli
    // Method for reading a floating-point number from the console
    private double WczytajDouble(String nazwa) {
        // BufferedReader = klasa, która umozliwia odczytywanie danych wejściowych w postaci tekstu.
        // --> przetwarza te dane na poziom wyzszy (tekst);
        // System.in - standardowe wejscie w Javie, ---> odczytuje dane z klawiatury na poziomie niskim(bajty);
        // InputStreamReader = która działa jako pośrednik między strumieniem bajtów(z klawiatury) a strumieniem znakow(tesktu)
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(nazwa + "= ");
            // Służy do odczytywania pojedynczej linii tekstu wprowadzonej przez użytkownika lub dostępnej w pliku.
            String s = in.readLine();
            // parseDouble() Służy do konwertowania ciągu znaków (String) na liczbę zmiennoprzecinkową (double).
            return Double.parseDouble(s);
        } catch (Exception e) {
            System.err.println("Blad! To nie jest liczba!");
            return WczytajDouble(nazwa); // Rekurencyjne ponowne pytanie w przypadku bledu / Recursive retry on error
        }
    }

    // Metoda do wczytywania wspolrzednych punktu od uzytkownika
    // Method for reading point coordinates from the user
    private void WczytajPunkt() {
        System.out.println("Podaj wspolrzedne punktu " + nazwa + ":");
        X = WczytajDouble("X"); // Wczytywanie wspolrzednej X / Reading X coordinate
        Y = WczytajDouble("Y"); // Wczytywanie wspolrzednej Y / Reading Y coordinate
        Z = WczytajDouble("Z"); // Wczytywanie wspolrzednej Z / Reading Z coordinate
    }

    // Konstruktor inicjalizujacy punkt na podstawie nazwy i wczytujacy jego wspolrzedne
    // Constructor initializing the point based on the name and reading its coordinates
    public Punkt3D(String nazwa) {
        // stosowana do przypisania wartości do pol
        this.nazwa = nazwa;
        WczytajPunkt();
    }

    // Metoda do wyswietlania wspolrzednych punktu
    // Method for displaying the point's coordinates
    public void Wyswietl() {
        System.out.println("Punkt " + nazwa + ":");
        System.out.println("X= " + X);
        System.out.println("Y= " + Y);
        System.out.println("Z= " + Z);
    }
}
