package model;

public class Wypozyczenie {
    private int idKsiazka;
    private int idCzytelnik;

    // Getters and setters
    public int getIdKsiazka() { return idKsiazka; }
    public void setIdKsiazka(int idKsiazka) { this.idKsiazka = idKsiazka; }
    public int getIdCzytelnik() { return idCzytelnik; }
    public void setIdCzytelnik(int idCzytelnik) { this.idCzytelnik = idCzytelnik; }

    // Constructors
    public Wypozyczenie() {}
    public Wypozyczenie(int idKsiazka, int idCzytelnik) {
        this.idKsiazka = idKsiazka;
        this.idCzytelnik = idCzytelnik;
    }
}