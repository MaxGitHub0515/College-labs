
// public class Program {
//     public static void main(String[] args){
//         Punkt3D A = new Punkt3D("a");

//     }
// }
// }


import java.io.*;

// Klasa Program zawiera metode main do testowania klasy Wektor3D
// The Program class contains the main method for testing the Wektor3D class

public class Program {
    public static void main(String[] args) {
        // Poprawiona deklaracja obiektu a / Fixed declaration of object 'a'
        Wektor3D a = new Wektor3D(new Punkt3D("poczatek"), new Punkt3D("koniec"), "a");
        a.Wyswietl(); // Wyswietlenie danych wektora a / Display vector a data
        
        // Tworzenie wektora b i wczytywanie jego danych / Creating vector b and reading its data
        Wektor3D b = new Wektor3D("b");
        b.Wczytaj();
        b.Wyswietl();
        
        // Obliczanie sumy wektorow a i b / Calculating the sum of vectors a and b
        Wektor3D suma = Wektor3D.Suma(a, b, "suma");
        suma.Wyswietl();
        
        // Obliczanie roznicy wektorow a i b / Calculating the difference of vectors a and b
        Wektor3D roznica = Wektor3D.Roznica(a, b, "roznica");
        roznica.Wyswietl();
        
        // Wyswietlenie dlugosci wektora a / Displaying the length of vector a
        System.out.println("Dlugosc wektora a = " + a.Dlugosc());
    }
}
