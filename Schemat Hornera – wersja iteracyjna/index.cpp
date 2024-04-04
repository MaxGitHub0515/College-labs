##include<iostream>
using namespace std;

int hornerIteracyjnie(int wspolczynniki[], int stopienWielomianu, int x) {
    int wynik = wspolczynniki[stopienWielomianu];
    for(int i = stopienWielomianu - 1; i >= 0; i--)
        wynik = wynik * x + wspolczynniki[i];
    return wynik;
}

int main() {
    int stopienWielomianu;
    cout << "Podaj stopień wielomianu: ";
    cin >> stopienWielomianu;
    
    int wspolczynniki[stopienWielomianu + 1];
    cout << "Podaj współczynniki wielomianu: ";
    for (int i = stopienWielomianu; i >= 0; i--) {
        cin >> wspolczynniki[i];
    }
    
    int x;
    cout << "Podaj wartość x: ";
    cin >> x;
    
    cout << "Wynik: " << hornerIteracyjnie(wspolczynniki, stopienWielomianu, x);
    return 0;
}
