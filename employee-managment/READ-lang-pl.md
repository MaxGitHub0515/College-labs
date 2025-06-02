# System Zarządzania Pracownikami

## Spis Treści:
- [*Funkcjonalność Aplikacji - Z perspektywy użytkownika*](#funkcjonalność-aplikacji---z-perspektywy-użytkownika)
- [*Struktura Aplikacji*](#struktura-aplikacji)
- [*Konfiguracja bazy danych SQL*](#konfiguracja-sql-z-ssms)


## STOS TECHNOLOGICZNY
- [*.NET CORE*](#)
- [*XAML (biblioteka WPF)*](#)
- [*Wzorzec MVVM*](#przykład-wzorca-mvvm )
- [*LINQ (zapytania do bazy)*](#)
- [*SQL* (relacyjna baza danych)](#tabele-bazy-danych)


## Funkcjonalność Aplikacji - Z perspektywy użytkownika

**Co może zrobić użytkownik?**
- Dla Działu:
    - Dodać nazwę działu i jego opis
     
- Dla Roli:
    - Dodać rolę z następującymi informacjami:
        - Tytuł roli,
        - Poziom (reprezentuje miejsce w hierarchii),
        - Rola wyższa (rola nadrzędna w hierarchii),
        - Raportowanie (rola, do której raportuje)

- Dla Osoby:
    - Dodać dane osobowe, w tym:
        - Imię i nazwisko, data urodzenia, email,
        numer telefonu, dział i rola (wybierane z wcześniej dodanych lub tworzonych w sekcji dział)

- Hierarchia Organizacyjna:
    - Przeglądać aktualną strukturę ról 
    (wcześniej dodanych) w formie drzewa hierarchicznego.

## Struktura Aplikacji

### Przykład wzorca MVVM 
    **YourAppName/**
    - *Models/*
        - *YourDataModel.cs*
        - *...*
    - *Views/*
        - *YourUserInterfaceView.xaml*
        - ...
    - *ViewModels/*
        - *YourUserInterfaceViewModel.cs*
        - *...*
    - *Services/ (opcjonalnie)*
        - *YourDataService.cs*
        - *...*
    - *App.xaml*

### Struktura Projektu
    **SystemZarządzaniaPracownikami/**
    - *bin/*
        - *Debug/*
        - *Release/*
    - *Data/*
        - *AppData.cs*
    - *Models/*
        - *Dzial.cs*
        - *GeneratedDbContext.cs*
        - *Osoba.cs*
        - *Rola.cs*
    - *obj/*
        - *Debug/*
        - *Release/*
    - *App.xaml*
    - *App.xaml.cs*
    - *AssemblyInfo.cs*
    - *connectDB.cs*
    - *MainWindow.xaml*
    - *MainWindow.xaml.cs*
    - *SystemZarządzaniaPracownikami.csproj*
    - *SystemZarządzaniaPracownikami.csproj.user*


## Konfiguracja [SQL z SSMS]()
    - PIERWSZE KROKI:
        - UTWÓRZ bazę danych w SSMS o nazwie **EmployeeDB**
        - DODAJ NASTĘPUJĄCE 3 TABELLE do bazy:
            - Dział
            - Osoba
            - Rola

--> Które powinny wyglądać następująco:

## Tabele Bazy Danych

### dbo.Dział

| Nazwa kolumny | Typ danych     | Nullable | Klucz główny | Klucz obcy |
|---------------|----------------|----------|--------------|------------|
| Id            | int            | Nie      | Tak          |            |
| Nazwa         | nvarchar(255)  | Nie      |              |            |
| Opis          | nvarchar(max)  | Tak      |              |            |

---

### dbo.Osoba

| Nazwa kolumny   | Typ danych     | Nullable | Klucz główny | Klucz obcy |
|------------------|----------------|----------|--------------|------------|
| Id               | int            | Nie      | Tak          |            |
| Imię             | nvarchar(255)  | Nie      |              |            |
| Nazwisko         | nvarchar(255)  | Nie      |              |            |
| DataUrodzenia    | date           | Nie      |              |            |
| Email            | nvarchar(255)  | Tak      |              |            |
| NumerTelefonu    | nvarchar(20)   | Tak      |              |            |
| DziałId          | int            | Nie      |              | Tak        |
| RolaId           | int            | Nie      |              | Tak        |

---

### dbo.Rola

| Nazwa kolumny        | Typ danych     | Nullable | Klucz główny | Klucz obcy |
|----------------------|----------------|----------|--------------|------------|
| Id                   | int            | Nie      | Tak          |            |
| Tytuł                | nvarchar(255)  | Nie      |              |            |
| Poziom               | int            | Nie      |              |            |
| DziałId              | int            | Nie      |              | Tak        |
| RolaWyzejId          | int            | Tak      |              | Tak        |
| RaportujeDoRoliId    | int            | Tak      |              | Tak        |


- Po zakończeniu konfiguracji bazy danych przejdź do instalacji pakietów:
    - Zainstaluj poniższe pakiety (aby zaimportować wcześniej utworzone tabele jako modele do VSC):
```shell
    dotnet add package Microsoft.EntityFrameworkCore
    dotnet add package Microsoft.EntityFrameworkCore.SqlServer
    dotnet add package Microsoft.EntityFrameworkCore.Tools
    dotnet add package Microsoft.EntityFrameworkCore.Design

```
- Jeśli chcesz zainstalować konkretną wersję pakietu NuGet za pomocą .NET CLI, dodaj parametr `--version`:

```shell
    dotnet add package YourPackageName --version 3.1.7
```
- Po udanej instalacji uruchom polecenie z connection stringiem, zamieniając dane przykładowe na własne:

```shell
     dotnet ef dbcontext scaffold "Server=YourServerName;Database=YourDBName;Trusted_Connection=True;TrustServerCertificate=True;" Microsoft.EntityFrameworkCore.SqlServer -o Models -c GeneratedDbContext --data-annotations --force
```

- Jeśli kompilacja zakończy się sukcesem, otrzymasz wszystkie tabele zaimportowane do folderu Models razem z plikiem głównym GeneratedDbContext.


## XAML (WPF)

- W pliku **App.xaml** powinniśmy mieć znacznik `"<Application>"`, który:
    - definiuje globalne ustawienia aplikacji
    - określa, które okno ma zostać otwarte jako pierwsze
    - przechowuje style i motywy używane w całej aplikacji

- Konfigurujemy nasz **App.xaml** w następujący sposób:

```shell
<Application x:Class="SystemZarzadzaniaPracownikami.App"
             xmlns="http://schemas.microsoft.com/winfx/2006/xaml/presentation"
             xmlns:x="http://schemas.microsoft.com/winfx/2006/xaml"
             xmlns:local="clr-namespace:SystemZarzadzaniaPracownikami"
             StartupUri="MainWindow.xaml">
    <Application.Resources>
         
    </Application.Resources>
</Application>
```
- `<Application.Resources>` służy do definiowania globalnych zasobów, takich jak: style, szablony, pędzle itp