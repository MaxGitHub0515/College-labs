

// TABLICE JEDNO I WIELOWYMIAROWE


import java.io.*; // Importing Java I/O library (Import biblioteki wejscia/wyjscia)

public class Tablice { // Class definition (Definicja klasy)


    private static int[] WczytajTab(int n) {  


        int[] tab = new int[n];  

      
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));  
        
        int wczytano = 0; 

        System.out.println("Podaj " + n + " liczb:");  
   

        while (wczytano < n) {  
            try {  
                System.out.print((wczytano + 1) + ":\t");  
              
                
                String s = in.readLine();  
             
                
                tab[wczytano] = Integer.parseInt(s);  
              

                wczytano++; 

            } catch (Exception e) {  
                System.err.println("To nie jest liczba calkowita");  
            
            }  
        }  

  
        return tab;  
    }  

  
    private static void Wyswietl(int []tab, String nazwa) {  
        System.out.println("Zawartosc tablicy " + nazwa + ":");  


        for(int i = 0; i < tab.length; i++)  
            System.out.println(nazwa + "[" + i + "] = " + tab[i]);  

    }  

    public static void main(String[] args) {  

        int []tab1 = {1, 2, 3, 4, 5};  
        Wyswietl(tab1, "tab1");  

   
        int []tab2 = WczytajTab(5);  
        Wyswietl(tab2, "tab2");  
    }
}
