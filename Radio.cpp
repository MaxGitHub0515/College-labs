#include"Radio.h"
using namaspace std;

void radio::graj(string z) 
{ 
for (int i = 0; i < 4;i++) 
 { 
 cout << z << endl; 
 Sleep(1000); //wstrzymanie wykonywania na 1 sekundę
 } 
 godzina = 30; //zmiana danej z klasy radio
} 
void radio::zapamietaj(string napis) 
{ 
 Nazwa = napis; 
} 
void radio::zmien_program() 
{ 
int numer;
cout << "Wybierz stacje radiowa : od 1 do 6, zeby wylaczyc radio wczisni 7";
cin >> numer;
bool exit = false;
while(!exit){
     cout << "Menu:\n";
        cout << "1. RMFFM\n";
        cout << "2. ZET\n";
        cout << "3. RMF MAXX\n";
        cout << "4. CZWORKA\n";
        cout << "5. RADIO 5\n";
        cout << "6. RMF CLASSIC\n";
        cout << "7. Exit\n";
        cout << "Enter your choice (1-7): ";
        cin >> numer;

switch (numer) 
 { 

case 1: radio::graj("RMFFM"); break; 
case 2: radio::graj("ZET"); break; 
case 3: radio::graj("RMF MAXX"); break;
case 4: radio::graj("CZWORKA"); break;
case 5: radio::graj("RADIO 5"); break;
case 6: radio::graj("RMF CLASSIC"); break;
case 7: 
    exit = true;
    cout << "Exiting"<<endl;

default: 
 cout << "Nie znam takiego programu. \n"; break; 
 } 
}
}
//Added


