using System;
using System.Collections.ObjectModel; // Potrzebne do ObservableCollection
using System.Linq; // Potrzebne do LINQ (FirstOrDefault, Any)
using System.Windows; // Potrzebne do MessageBox
using SystemZarzadzaniaPracownikami.Models; // Ważne: odwołanie do Models

namespace SystemZarzadzaniaPracownikami.Data
{
    public static class AppData
    {
        // Kolekcje ObservableCollection, aby zmiany w nich były automatycznie widoczne w UI
        public static ObservableCollection<Dział> Działy { get; set; } = new ObservableCollection<Dział>();
        public static ObservableCollection<Rola> Role { get; set; } = new ObservableCollection<Rola>();
        public static ObservableCollection<Osoba> Osoby { get; set; } = new ObservableCollection<Osoba>();

        // Statyczny konstruktor, który zostanie wywołany raz, gdy klasa AppData zostanie użyta po raz pierwszy
        static AppData()
        {
            // Inicjalizacja danych testowych
            InicjalizujDaneTestowe();
        }

        private static void InicjalizujDaneTestowe()
        {
            // Działy
            DodajDział(new Dział { Nazwa = "Zarząd", Opis = "Naczelne kierownictwo" });
            DodajDział(new Dział { Nazwa = "IT", Opis = "Dział techniczny i wsparcia" });
            DodajDział(new Dział { Nazwa = "HR", Opis = "Dział zasobów ludzkich" });
            DodajDział(new Dział { Nazwa = "Finanse", Opis = "Dział księgowości i finansów" });

            // Role (UWAGA: Ważna kolejność dodawania, aby móc przypisywać role nadrzędne i raportujące do istniejących)
            // Musimy mieć pewność, że Dział jest już dodany, zanim przypiszemy go do Roli
            DodajRola(new Rola { Tytuł = "Prezes Zarządu", Poziom = 1, Dział = Działy.FirstOrDefault(d => d.Nazwa == "Zarząd"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "Zarząd").Id });
            DodajRola(new Rola { Tytuł = "Dyrektor IT", Poziom = 2, Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu").Id });
            DodajRola(new Rola { Tytuł = "Dyrektor HR", Poziom = 2, Dział = Działy.FirstOrDefault(d => d.Nazwa == "HR"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "HR").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu").Id });
            DodajRola(new Rola { Tytuł = "Starszy Specjalista IT", Poziom = 2, Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor IT"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor IT").Id });
            DodajRola(new Rola { Tytuł = "Specjalista IT", Poziom = 3, Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Starszy Specjalista IT"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Starszy Specjalista IT").Id }); // Raportuje do Starszego Specjalisty
            DodajRola(new Rola { Tytuł = "Rekruter", Poziom = 3, Dział = Działy.FirstOrDefault(d => d.Nazwa == "HR"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "HR").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor HR"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor HR").Id });
            DodajRola(new Rola { Tytuł = "Księgowy", Poziom = 3, Dział = Działy.FirstOrDefault(d => d.Nazwa == "Finanse"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "Finanse").Id, RaportujeDoRoli = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu"), RaportujeDoRoliId = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu").Id });


            // Osoby (UWAGA: Ważna kolejność dodawania, aby móc przypisywać Dział i Rolę do istniejących)
            DodajOsoba(new Osoba { Imię = "Anna", Nazwisko = "Kowalska", DataUrodzenia = new DateTime(1980, 5, 15), Email = "anna.kowalska@firma.pl", NumerTelefonu = "111-222-333", Dział = Działy.FirstOrDefault(d => d.Nazwa == "Zarząd"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "Zarząd").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Prezes Zarządu").Id });
            DodajOsoba(new Osoba { Imię = "Piotr", Nazwisko = "Nowak", DataUrodzenia = new DateTime(1985, 8, 22), Email = "piotr.nowak@firma.pl", NumerTelefonu = "444-555-666", Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor IT"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor IT").Id });
            DodajOsoba(new Osoba { Imię = "Marta", Nazwisko = "Zielinska", DataUrodzenia = new DateTime(1990, 3, 10), Email = "marta.zielinska@firma.pl", NumerTelefonu = "777-888-999", Dział = Działy.FirstOrDefault(d => d.Nazwa == "HR"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "HR").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor HR"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Dyrektor HR").Id });
            DodajOsoba(new Osoba { Imię = "Kamil", Nazwisko = "Wojcik", DataUrodzenia = new DateTime(1992, 11, 29), Email = "kamil.wojcik@firma.pl", NumerTelefonu = "000-111-222", Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Specjalista IT"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Specjalista IT").Id });
            DodajOsoba(new Osoba { Imię = "Zofia", Nazwisko = "Lis", DataUrodzenia = new DateTime(1995, 1, 1), Email = "zofia.lis@firma.pl", NumerTelefonu = "333-444-555", Dział = Działy.FirstOrDefault(d => d.Nazwa == "HR"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "HR").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Rekruter"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Rekruter").Id });
            DodajOsoba(new Osoba { Imię = "Adam", Nazwisko = "Mickiewicz", DataUrodzenia = new DateTime(1975, 10, 20), Email = "adam.mickiewicz@firma.pl", NumerTelefonu = "666-777-888", Dział = Działy.FirstOrDefault(d => d.Nazwa == "IT"), DziałId = Działy.FirstOrDefault(d => d.Nazwa == "IT").Id, Rola = Role.FirstOrDefault(r => r.Tytuł == "Starszy Specjalista IT"), RolaId = Role.FirstOrDefault(r => r.Tytuł == "Starszy Specjalista IT").Id });

        }

        // Metody do zarządzania Działami
        private static int nextDziałId = 1;
        public static void DodajDział(Dział dział)
        {
            if (dział.Id == 0) // Jeśli ID nie zostało ustawione ręcznie (np. z bazy danych)
            {
                dział.Id = nextDziałId++; // Przypisz kolejne unikalne ID
            }
            Działy.Add(dział);
        }

        public static void AktualizujDział(Dział dział)
        {
            var existing = Działy.FirstOrDefault(d => d.Id == dział.Id);
            if (existing != null)
            {
                existing.Nazwa = dział.Nazwa;
                existing.Opis = dział.Opis;
                // Ponowne powiązanie obiektów Dział w Rolach i Osobach
                foreach (var rola in Role.Where(r => r.DziałId == existing.Id))
                {
                    rola.Dział = existing;
                }
                foreach (var osoba in Osoby.Where(o => o.DziałId == existing.Id))
                {
                    osoba.Dział = existing;
                }
            }
        }

        public static void UsuńDział(int id)
        {
            var działToRemove = Działy.FirstOrDefault(d => d.Id == id);
            if (działToRemove != null)
            {
                // Sprawdź, czy są jakieś role lub osoby przypisane do tego działu
                if (Role.Any(r => r.DziałId == id) || Osoby.Any(o => o.DziałId == id))
                {
                    MessageBox.Show("Nie można usunąć działu, ponieważ są do niego przypisane role lub osoby. Najpierw usuń lub przenieś te role/osoby.", "Błąd usunięcia", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }
                Działy.Remove(działToRemove);
            }
        }

        // Metody do zarządzania Rolami
        private static int nextRolaId = 1;
        public static void DodajRola(Rola rola)
        {
            if (rola.Id == 0)
            {
                rola.Id = nextRolaId++;
            }
            Role.Add(rola);
        }

        public static void AktualizujRola(Rola rola)
        {
            var existing = Role.FirstOrDefault(r => r.Id == rola.Id);
            if (existing != null)
            {
                existing.Tytuł = rola.Tytuł;
                existing.Poziom = rola.Poziom;
                existing.Dział = rola.Dział;
                existing.DziałId = rola.DziałId;
                existing.RolaWyżej = rola.RolaWyżej;
                existing.RolaWyżejId = rola.RolaWyżejId;
                existing.RaportujeDoRoli = rola.RaportujeDoRoli;
                existing.RaportujeDoRoliId = rola.RaportujeDoRoliId;

                // Ponowne powiązanie obiektów Rola w Osobach
                foreach (var osoba in Osoby.Where(o => o.RolaId == existing.Id))
                {
                    osoba.Rola = existing;
                }
            }
        }

        public static void UsuńRola(int id)
        {
            var rolaToRemove = Role.FirstOrDefault(r => r.Id == id);
            if (rolaToRemove != null)
            {
                // Sprawdź, czy są jakieś osoby przypisane do tej roli
                if (Osoby.Any(o => o.RolaId == id))
                {
                    MessageBox.Show("Nie można usunąć roli, ponieważ są do niej przypisane osoby. Najpierw usuń lub przenieś te osoby.", "Błąd usunięcia", MessageBoxButton.OK, MessageBoxImage.Warning);
                    return;
                }
                // Odłącz role, które raportowały do tej roli
                foreach (var rola in Role.Where(r => r.RaportujeDoRoliId == id))
                {
                    rola.RaportujeDoRoli = null;
                    rola.RaportujeDoRoliId = null;
                }
                // Odłącz role, dla których ta rola była rolą wyżej
                foreach (var rola in Role.Where(r => r.RolaWyżejId == id))
                {
                    rola.RolaWyżej = null;
                    rola.RolaWyżejId = null;
                }

                Role.Remove(rolaToRemove);
            }
        }

        // Metody do zarządzania Osobami
        private static int nextOsobaId = 1;
        public static void DodajOsoba(Osoba osoba)
        {
            if (osoba.Id == 0)
            {
                osoba.Id = nextOsobaId++;
            }
            Osoby.Add(osoba);
        }

        public static void AktualizujOsoba(Osoba osoba)
        {
            var existing = Osoby.FirstOrDefault(o => o.Id == osoba.Id);
            if (existing != null)
            {
                existing.Imię = osoba.Imię;
                existing.Nazwisko = osoba.Nazwisko;
                existing.DataUrodzenia = osoba.DataUrodzenia;
                existing.Email = osoba.Email;
                existing.NumerTelefonu = osoba.NumerTelefonu;
                existing.Dział = osoba.Dział;
                existing.DziałId = osoba.DziałId;
                existing.Rola = osoba.Rola;
                existing.RolaId = osoba.RolaId;
            }
        }

        public static void UsuńOsoba(int id)
        {
            var osobaToRemove = Osoby.FirstOrDefault(o => o.Id == id);
            if (osobaToRemove != null)
            {
                Osoby.Remove(osobaToRemove);
            }
        }
    }
}