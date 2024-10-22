#pragma once
#include<iostream>
#include<windows.h>
#include<string>
#include"Radio.h"
using namespace std; 


5

class Radio //definicja klasy radio
{ 
public: //składniki publiczne 
int program; /*dane składowe*/ /*component data*/
int godzina; 
string Nazwa; 
void zapamietaj(string napis); /*funkcje składowe - 
deklaracje*/
void zmien_program(int numer); 
private: //składniki prywatne
void graj(string z); //funkcja składowa-deklaracja
};


//Added