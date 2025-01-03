%Zadanie polega na wyznaczeniu pochodnej numerycznej
%...



%Zrealizowac wykres funk f(x) , punkt dla ktorego bedziemy wyznaczac pochodna w postaci numerycznej

% Przedzial w ktorym znajduja sie 
 %x0 = 2;
% xa = 1;
 %xb = 3;

%x = xa:.2:xb;
fx = 7 * exp(0.5*x);

plot(fx)
xlabel("wartosc funk")
ylabel("argument funk")
title("wykres funk")
grid
figure
plot(x, fx)
xlabel("wartosc funk")
ylabel("argument funk")
title("wykres funk")


% f - pochodna dokladna
% wyznaczenie pochodnych numer dla roznych krokow dyskrytyzcji
h = 0.3
h1 = 0.15
h2 = 0.1
h3 = 0.01
h4 = 0.001


% wzor na pochodna numeryczna
  f = 7 * exp(0.5 * x0)
 fpn1 = (7 * exp(0.5*(x0 + h)) - 7 * exp(x0*0.5))/h;
 fpn2 = (7 * exp(0.5*(x0 + h1)) - 7 * exp(x0*0.5))/h1;
 fpn3 = (7 * exp(0.5*(x0 + h2)) - 7 * exp(x0*0.5))/h2;
 fpn4 = (7 * exp(0.5*(x0 + h3)) - 7 * exp(x0*0.5))/h3;
 fpn5 = (7 * exp(0.5*(x0 + h4)) - 7 * exp(x0*0.5))/h4;

plot(fpn1, "R")
hold on
plot(fpn2, "G")
plot(fpn3, "B")
plot(fpn4)
plot(fpn5)

    




 