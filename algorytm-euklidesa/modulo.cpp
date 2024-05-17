#include <iostream>

using namespace std;

int main() {

    int a, b, r;
    cout << "Podaj liczbe a: ";
    cin >> a;

    
    cout << "Podaj liczbe b :";
    cin >> b;

    cout << "Wartosci (" << a << ", " << b << ")" << endl;

    // original values
    int wartoscA = a;
    int wartoscB = b;
    // NWD
    while(b!=0){
            r = a % b;
            a = b;
            b = r;
        }
    int nwd = a; 
    cout << "NWD: " << nwd << endl;

    // NWW
    int nww = (wartoscA / nwd) * wartoscB;
    cout << "NWW: " << nww << endl;
   
    
}