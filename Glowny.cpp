#include"Radio.h"
#include "Radio.cpp"
#include <conio.h>

void main() 
{   
    //Added
    // Added 2 objects to the class of Radio 
    // Radio radio1 = new Radio();
    // Radio radio2 = new Radio();

 // FIRST LAB

    // Radio radio1;
    // radio1.godzina = 20;
    
    // Radio radio2;
    // radio2.godzina = 10; 
    

    // cout << "skladnik godzina obiektu radio1 = " << radio1.godzina<<endl;
    // cout << "skladnik godzina obiektu radio2 = " << radio2.godzina<<endl;
    
    // radio2.godzina = radio1.godzina;

    // cout << "skladnik godzina obiektu radio1= " <<radio1.godzina<<endl;
    // cout << "skladnik godzina obiektu radio2= " <<radio2.godzina<<endl;

    // radio1.Nazwa = zapamietaj("Radio_1")
    // radio2.Nazwa = zapamietaj("Radio_2")
    
    // cout <<"skladnik Nazwa obiektu radio1=" <<radio1.Nazwa<<endl
    // cout <<"skladnik Nazwa obiektu radio2=" <<radio2.Nazwa<<endl
    
    // Radio* wsk = &radio1;

    // cout << "Wskazuje na objekt -> " << wsk->godzina <<endl;
    // cout << "Wskazuje na objekt -> " << wsk->Nazwa <<endl;

    // wsk = &radio2;
    // cout << "Wskazuje na objekt -> " << wsk->godzina <<endl;
    // cout << "Wskazuje na objekt -> " << wsk->Nazwa <<endl;

    // string Tab_radio[10] = {radio1,, radio2};
    // Tab_radio*[0];

    // cout << Tab_radio[0]<<endl;
    
// SEC LAB

void radio::graj(string z ){
    while(!_kbhit()){
        cout << z << endl;
        Sleep(1500);
    }
    godzina = 30

}
    radio radio1;
    radio radio2;
    radio1.zmien_program()
    radio2.zmien_program()

    cout << sizeof(radio1)<<endl;


void fun(radio a) {
    cout<<"Nazwa radia: "<<a.Nazwa<<endl; 
    cout<<"Aktualna godzina: "<<a.godzina<<endl; 
    cout<<"Aktualny program: "<<a.program<<endl; 
}
fun(radio1)
fun(radio2)
system("pause");
}
