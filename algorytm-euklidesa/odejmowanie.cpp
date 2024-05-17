#include <iostream>

using namespace std;

int main() {

    int a, b;
    cout << "Podaj liczbe a: ";
    cin >> a;

    
    cout << "Podaj liczbe b :";
    cin >> b;

    cout << "Wartosci (" << a << ", " << b << ")" << endl;

    // original values
    int wartoscA = a;
    int wartoscB = b;
    // NWD
    while(a != b){
        if(a>b){
            a = a - b;

        }else {
            b = b - a;
        }
    }
    int nwd = a;
    cout << "NWD : " << a <<endl;

    // NWW
    int  nww = (wartoscA * wartoscB) / nwd;
    cout << "NWW: " << nww << endl;

    return 0;
}