#include <Student.h>

student tab[MAX];

main () {
  for (int i =0; i<MAX; i++) 
  {
  tab[i].imie = "";
  tab[i].adres = "";
  tab[i].tel = "";
  }

for (int i=0; i<MAX; i++) 
 if (tab[i].imie != ””) z++;

  int numer; 
    do
     { 
     cout << "1 - dodawanie " << endl; 
     cout << "2 - usuwanie" << endl; 
     cout << "3 - Przegladanie bazy - tabeli studentow" << endl; 
     cin >> numer; 
     switch (numer) 
       { 
       case 1: 
       { 
       ... 
       break; 
       } 
       case 2: 
       { 
       ... 
       break; 
       } 
       ... 
       } 
 
 } while (numer !=0); 

  // Wprowdzenie danych do bazy
  if (z !- MAX)
    for (int i=0; i<MAX; i++) 
     if (tab[i].imie == ””) 
     { 
    cout<<”Podaj dane:<<endl; 
    cout<<”Podaj imie:”; 
    cin>>tab[i].imie; 
    cin.ignore(); 
    .....//tak samo adres i tel 
    z++; //zwieksz liczbe zajetych 
    Save(); //wywolanie funkcji 
    break; //przerwij wykonywanie petli for 
 }

  // Usuwanie bau danych
  cout<<”Podaj imie:”; 
  cin>>temp; 
  cin.ignore(); 
   for (int i=0; i<MAX; i++) 
   if (tab[i].imie == temp) 
   { 
   tab[i].imie = ””; 
   z--; 
   cout << "Usunieto wpis!" << endl; 
   break; //for 
   } 
 // Podglądamy zawartość bazy – wyświetlenie danych z tablicy studentów
  
  return 0;

}

// Menu - dodawanie, usuwanie studenta
