
#include <iostream>
#include <iomanip>
using namespace std;

long double fibo[100000];
int n;

int main()
{
    cout << "Ile liczb Fibonacciego mam wyznaczyc :";
    cin >> n;
    fibo[0] = 1;
    fibo[1] = 1;
    
    for(int i = 2; i < n; i++){
        fibo[i] = fibo[i-1] + fibo[i-2];
    }
    
    // cout << setprecision(10000);

    // -- 
    for(int i = 0; i < n; i++){
        cout << endl << "Wyraz numer " << i+1 << ": " << fibo[i];
    }
    /* To use the following code, comment out the lines above starting with --
    cout << endl <<"wyraz numer " << n << ":" << fibo[i-1]; */
    
    // Zlota liczba
    // 23601 -limit, use it for n
    cout <<"Zlota liczba : " << fibo[n-1] / fibo[n-2];
    return 0;
}
