package myapp;

// Klasa JOptionPane

import javax.swing.JOptionPane;

public class Pane {
    public static void main(String[] args) {
        // Wyświetlenie okna dialogowego do wprowadzania tekstu
        String tekst = JOptionPane.showInputDialog("Wpisz tekst...");
        
        // Wyświetlenie okna potwierdzenia z przyciskami Tak/Nie/Anuluj
        int a = JOptionPane.showConfirmDialog(
            null, 
            "Wpisałeś: " + tekst, 
            "Tytuł okienka", 
            JOptionPane.YES_NO_CANCEL_OPTION
        );
        
        // Wartości zwracane: Tak=0, Nie=1, Anuluj=2
        System.out.println(a);
        
        // Wyświetlenie okna z komunikatem
        JOptionPane.showMessageDialog(null, "Przykładowe okno z informacją");
        System.exit(0);
    }
}