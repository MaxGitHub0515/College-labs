#include<iostream>
using namespace std;
int hornerIteracyjnie(int wspolczynniki[],int stopienWielomianu,
{
int wynik = wspolczynniki[0];
for(int i = 1; i <= stopienWielomianu; i++)
wynik = wynik * x + wspolczynniki[i];
return wynik;
}
int main()
{
int wspolczynniki[] = {1, 3, -6};
int stopienWielomianu = 2;
int x = 2;
cout << hornerIteracyjnie(wspolczynniki, stopienWielomianu, x
return 0;
}