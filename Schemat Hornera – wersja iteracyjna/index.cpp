#include<iostream>
using namespace std;

int main() {
    int n, c;
    // n - stopien wielomianu W(x), c - pierwistek wielomianu P(x)
    cout << "Podaj stopien wielomianu W(x): ";
    cin >> n;
    cout << "Podaj pierwiastek wielomianu P(x): ";
    cin >> c;

    int* a = new int[n+1];
    int* b = new int [n+1];
    cout << "Podaj pierwszy wspolczynik: ";
    cin >> a[n];
    b[n] = a[n];
// x0 -  wyraz wolny
    for(int i = n -1; i >=0; i--){
        cout << "Podaj wspolczynik przy (x" << i << "): ";
        cin >> a[i];
        b[i] = b[i+1] * c + a[i];
        cout << b[i] << endl;

    }

    delete[] a;
    delete[] b;

    return 0;
}
