#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;


int main() {
    
    double a, b, c, x0, x1, x2;

    cout << "Rownania ax^2 + bx + c = 0"<< endl

    cout << "Podaj wartosc dla zmiennej a : "<<endl;
    cin >> a;
    cout << "Podaj wartosc dla zmiennej b : "<<endl;
    cin >> b;
    cout << "Podaj wartosc dla zmiennej c : "<<endl;
    cin >> c;
    double delta = b * b - 4 * a * c;
    if(a == 0) {
        cout << "Rownanie jest linowe : blad";
        exit(EXIT_SUCCESS);
    }
    if (delta > 0) {
         cout <<"Delta rowna sie " << delta << endl;
        x1 = (-b - delta) / (2 * a);
        x2 = (-b + delta) / (2 * a);
        cout << "Pierwszy pierwiastek x1 : " << x1 << endl;
        cout << "Drugi pierwiastek x2 : " << x2 << endl;

    }   

     else if (delta == 0) {
       cout <<"Delta rowna sie " << delta << endl;
        x0 = -b / (2 * a);
        cout << "W równaniu jest tylko jeden pierwiastek: " << x0 << endl;

    }   
    else {
         cout <<"Delta rowna sie " << delta << endl;
        double realPart = -b / (2 * a);
        double imaginaryPart = sqrt(-delta) / (2 * a);
        cout << "Dwa pierwiastki zespolone: ";
        cout << "x1 = " << realPart << " + " << imaginaryPart << "i , ";
        cout << "x2 = " << realPart << " - " << imaginaryPart << "i" << endl;
    }
    return 0;
}

