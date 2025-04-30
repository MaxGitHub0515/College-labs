package myapp;

// Wybór pliku za pomocą FileDialog

import java.awt.FileDialog;
import java.awt.Frame;

public class Pliki_wybor {
    public static void main(String[] args) {
        Frame a = new Frame("Okno macierzyste");
        a.setBounds(20, 20, 400, 500);
        a.setVisible(true);

        // Tworzenie okna dialogowego do wyboru pliku (LOAD - do odczytu)
        FileDialog fd = new FileDialog(a, "Wczytaj", FileDialog.LOAD);
        // Dla zapisu użyj: FileDialog fd = new FileDialog(a, "Zapisz", FileDialog.SAVE);
        
        fd.setVisible(true);
        String katalog = fd.getDirectory();
        String plik = fd.getFile();
        
        System.out.println("Wybrano plik: " + plik);
        System.out.println("w katalogu: " + katalog);
        System.out.println("Ścieżka: " + katalog + plik);
    }
}