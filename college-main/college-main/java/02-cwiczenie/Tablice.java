

// TABLICE JEDNO I WIELOWYMIAROWE


import java.io.*; // Importing Java I/O library (Import biblioteki wejscia/wyjscia)

public class Tablice { // Class definition (Definicja klasy)

    // Function that creates a new array and inputs values from the keyboard  
    // (Funkcja tworzaca nowa tablice i wprowadzajaca do niej wartosci z klawiatury)
    private static int[] WczytajTab(int n) {  

        // Dynamically creating a new array  
        // (Dynamiczne tworzenie nowej tablicy)
        int[] tab = new int[n];  

        // Creating a BufferedReader for reading input from the keyboard  
        // (Tworzenie BufferedReader do odczytu wejscia z klawiatury)
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        
        int wczytano = 0; // Counter for the number of read values (Licznik odczytanych wartosci)

        System.out.println("Podaj " + n + " liczb:");  
        // Display message: "Enter n numbers"  
        // (Wyswietl komunikat: "Podaj n liczb:")

        while (wczytano < n) {  // Loop until all numbers are read (Petla az wszystkie liczby zostana wczytane)
            try {  
                System.out.print((wczytano + 1) + ":\t");  
                // Display number position (Wyswietl numer pozycji)
                
                String s = in.readLine();  
                // Read input from user (Odczytaj wejscie od uzytkownika)
                
                tab[wczytano] = Integer.parseInt(s);  
                // Convert input to an integer and store in the array  
                // (Przeksztalc wejscie na liczbe calkowita i zapisz w tablicy)

                wczytano++; // Increment counter (Zwieksz licznik)

            } catch (Exception e) {  
                System.err.println("To nie jest liczba calkowita");  
                // Error message: "This is not a whole number"  
                // (Komunikat bledu: "To nie jest liczba calkowita")
            }  
        }  

        // Returning reference to the newly created array  
        // (Zwrocenie referencji do nowo utworzonej tablicy)
        return tab;  
    }  

    // Function to display the content of an array  
    // (Funkcja do wyswietlania zawartosci tablicy)
    private static void Wyswietl(int []tab, String nazwa) {  
        System.out.println("Zawartosc tablicy " + nazwa + ":");  
        // Display message: "Contents of array [name]"  
        // (Wyswietl komunikat: "Zawartosc tablicy [nazwa]:")

        for(int i = 0; i < tab.length; i++)  
            System.out.println(nazwa + "[" + i + "] = " + tab[i]);  
            // Display array element (Wyswietl element tablicy)
    }  

    public static void main(String[] args) {  
        // Initialization of array from the program level  
        // (Inicjacja tablicy z poziomu programu)
        int []tab1 = {1, 2, 3, 4, 5};  
        Wyswietl(tab1, "tab1");  

        // Initialization of array from the keyboard  
        // (Inicjacja tablicy z klawiatury)
        int []tab2 = WczytajTab(5);  
        Wyswietl(tab2, "tab2");  
    }
}
