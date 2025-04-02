public class Wektor3D {
    public double x, y, z;  // Wspolrzedne publiczne
    private String nazwa;   // Nazwa prywatna

    
    // Konstruktor przyjmujacy wspolrzedne i nazwe
    public Wektor3D(double x, double y, double z, String nazwa) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.nazwa = nazwa;
    }

    // Konstruktor przyjmujacy dwa punkty i obliczajacy wspolrzedne
    public Wektor3D(Punkt3D poczatek, Punkt3D koniec, String nazwa) {
        this.x = koniec.getX() - poczatek.getX();
        this.y = koniec.getY() - poczatek.getY();
        this.z = koniec.getZ() - poczatek.getZ();
        this.nazwa = nazwa;
    }

    // Konstruktor przyjmujacy tylko nazwe, wspolrzedne ustawiane na 0
    public Wektor3D(String nazwa) {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        this.nazwa = nazwa;
    }

    // Funkcja prywatna sumujaca dwa wektory
    private void Suma(Wektor3D a, Wektor3D b) {
        this.x = a.x + b.x;
        this.y = a.y + b.y;
        this.z = a.z + b.z;
    }

    // Funkcja prywatna obliczajaca roznice dwoch wektorow
    private void Roznica(Wektor3D a, Wektor3D b) {
        this.x = a.x - b.x;
        this.y = a.y - b.y;
        this.z = a.z - b.z;
    }

    // Funkcja publiczna wczytujaca wspolrzedne z klawiatury
    public void wczytajWspolrzedne() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Podaj x: ");
        this.x = scanner.nextDouble();
        System.out.print("Podaj y: ");
        this.y = scanner.nextDouble();
        System.out.print("Podaj z: ");
        this.z = scanner.nextDouble();
    }

    // Funkcja wyswietlajaca wspolrzedne
    public void wyswietl() {
        System.out.println(nazwa + ": (" + x + ", " + y + ", " + z + ")");
    }
}
