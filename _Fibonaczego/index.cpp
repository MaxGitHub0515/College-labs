
#include <iostream>
using namespace std;
 
long double fibo[100000]; int n;
int main()
{
    cout < "Ile liczb Fibonacciego mam wyznaczyc :";
    cin >> n;
    fibo[0] = 1;
    fibo[1] = 1;
    
    for(int i = 2; i < n; i++){
        fibo[i] = fibo[i-1] + fibo[i-2];
    }
    for(int i = 0; i < n; i++){
        cout <<endl << wyraz numer << i+1 << ": " << fib[i];
    }
    
    return 0;
}