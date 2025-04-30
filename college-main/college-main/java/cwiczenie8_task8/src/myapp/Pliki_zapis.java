package myapp;

import java.io.FileOutputStream;
import java.io.IOException;

public class Pliki_zapis {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        String str = "Tekst do zapisania w pliku i dwie liczby: 123 i 321";

        try {
            fos = new FileOutputStream("plik.txt"); // Otwieranie pliku
            for(int i = 0; i < str.length(); i++) {
                fos.write((int)str.charAt(i)); // Zapis bajt po bajcie
            }
        } catch(IOException ex) {
            System.out.println("Błąd operacji na pliku: " + ex);
        } finally {
            try {
                if(fos != null) fos.close(); // Zamykanie pliku
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}