using System;
using System.Windows;
using System.Windows.Controls;
using System.Linq; // Potrzebne do LINQ (FirstOrDefault, Any)
using System.Collections.ObjectModel; // Potrzebne do ObservableCollection
using SystemZarzadzaniaPracownikami.Models; // Ważne: odwołanie do klas modeli
using SystemZarzadzaniaPracownikami.Data;   // Ważne: odwołanie do klasy AppData

namespace SystemZarzadzaniaPracownikami // Ważne: ta przestrzeń nazw musi odpowiadać x:Class w XAML
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            // Zarejestruj zdarzenie Loaded, które zostanie wywołane, gdy okno zostanie w pełni załadowane
            this.Loaded += MainWindow_Loaded;
        }

        // Metoda wywoływana po załadowaniu okna
        private void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            WczytajDziały();
            WczytajRole();
            WczytajOsoby();
            ZbudujSchematOrganizacyjny(); // Zbuduj i wyświetl schemat organizacyjny przy starcie
        }

        // Metody do odświeżania danych w kontrolkach (DataGrids, ComboBoxes)
        private void WczytajDziały()
        {
            DziałyDataGrid.ItemsSource = AppData.Działy; // Ustaw źródło danych dla DataGrid
            RolaDziałComboBox.ItemsSource = AppData.Działy; // Ustaw źródło danych dla ComboBox w zakładce Role
            OsobaDziałComboBox.ItemsSource = AppData.Działy; // Ustaw źródło danych dla ComboBox w zakładce Osoby
        }

        private void WczytajRole()
        {
            RoleDataGrid.ItemsSource = AppData.Role; // Ustaw źródło danych dla DataGrid
            RolaWyżejComboBox.ItemsSource = AppData.Role; // Ustaw źródło danych dla ComboBox ról nadrzędnych
            RolaRaportujeDoComboBox.ItemsSource = AppData.Role; // Ustaw źródło danych dla ComboBox ról raportujących
            OsobaRolaComboBox.ItemsSource = AppData.Role; // Ustaw źródło danych dla ComboBox w zakładce Osoby
        }

        private void WczytajOsoby()
        {
            OsobyDataGrid.ItemsSource = AppData.Osoby; // Ustaw źródło danych dla DataGrid
        }

        // --- Metody dla Zarządzania Działami ---

        // Czyści pola formularza Działu
        private void WyczyśćFormularzDziału_Click(object sender, RoutedEventArgs e)
        {
            DziałIdTextBox.Text = string.Empty;
            DziałNazwaTextBox.Text = string.Empty;
            DziałOpisTextBox.Text = string.Empty;
            DziałyDataGrid.SelectedItem = null; // Usuń zaznaczenie z DataGrid
        }

        // Dodaje lub aktualizuje Dział
        private void DodajAktualizujDział_Click(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrWhiteSpace(DziałNazwaTextBox.Text))
            {
                MessageBox.Show("Nazwa działu nie może być pusta.", "Błąd Walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            if (int.TryParse(DziałIdTextBox.Text, out int id) && id != 0) // Jeśli ID jest i jest różne od 0, to aktualizujemy
            {
                var dział = AppData.Działy.FirstOrDefault(d => d.Id == id);
                if (dział != null)
                {
                    dział.Nazwa = DziałNazwaTextBox.Text;
                    dział.Opis = DziałOpisTextBox.Text;
                    AppData.AktualizujDział(dział);
                    MessageBox.Show("Dział został zaktualizowany.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
                }
            }
            else // W przeciwnym razie dodajemy nowy dział
            {
                var nowyDział = new Dział
                {
                    Nazwa = DziałNazwaTextBox.Text,
                    Opis = DziałOpisTextBox.Text
                };
                AppData.DodajDział(nowyDział);
                MessageBox.Show("Nowy dział został dodany.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            WyczyśćFormularzDziału_Click(null, null); // Wyczyść formularz po operacji
            WczytajDziały(); // Odśwież DataGrid Działów
            WczytajRole(); // Odśwież ComboBox w zakładce Role (na wypadek zmian w dostępnych działach)
            WczytajOsoby(); // Odśwież ComboBox w zakładce Osoby
            ZbudujSchematOrganizacyjny(); // Odśwież schemat organizacyjny
        }

        // Usuwa Dział
        private void UsuńDział_Click(object sender, RoutedEventArgs e)
        {
            var button = sender as Button;
            var dział = button?.DataContext as Dział; // Pobierz obiekt Dział z kontekstu danych przycisku

            if (dział != null)
            {
                if (MessageBox.Show($"Czy na pewno chcesz usunąć dział '{dział.Nazwa}'?", "Potwierdź usunięcie", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
                {
                    AppData.UsuńDział(dział.Id); // Wywołaj metodę usuwania z AppData
                    WczytajDziały(); // Odśwież DataGrid Działów
                    WyczyśćFormularzDziału_Click(null, null);
                    WczytajRole(); // Odśwież ComboBox w zakładce Role
                    WczytajOsoby(); // Odśwież ComboBox w zakładce Osoby
                    ZbudujSchematOrganizacyjny(); // Odśwież schemat
                }
            }
        }

        // Obsługuje zmianę zaznaczenia w DataGrid Działów
        private void DziałyDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (DziałyDataGrid.SelectedItem is Dział wybranyDział) // Sprawdź, czy coś jest zaznaczone i czy to jest Dział
            {
                DziałIdTextBox.Text = wybranyDział.Id.ToString();
                DziałNazwaTextBox.Text = wybranyDział.Nazwa;
                DziałOpisTextBox.Text = wybranyDział.Opis;
            }
            else
            {
                WyczyśćFormularzDziału_Click(null, null); // Jeśli nic nie jest zaznaczone, wyczyść formularz
            }
        }

        // --- Metody dla Zarządzania Rolami ---

        private void WyczyśćFormularzRoli_Click(object sender, RoutedEventArgs e)
        {
            RolaIdTextBox.Text = string.Empty;
            RolaTytułTextBox.Text = string.Empty;
            RolaPoziomTextBox.Text = string.Empty;
            RolaDziałComboBox.SelectedItem = null;
            RolaWyżejComboBox.SelectedItem = null;
            RolaRaportujeDoComboBox.SelectedItem = null;
            RoleDataGrid.SelectedItem = null;
        }

        private void DodajAktualizujRolę_Click(object sender, RoutedEventArgs e)
        {
            // Podstawowa walidacja pól
            if (string.IsNullOrWhiteSpace(RolaTytułTextBox.Text) || !int.TryParse(RolaPoziomTextBox.Text, out int poziom) || RolaDziałComboBox.SelectedItem == null)
            {
                MessageBox.Show("Tytuł, Poziom i Dział są wymagane dla roli.", "Błąd Walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            var wybranyDział = RolaDziałComboBox.SelectedItem as Dział;
            var rolaWyżej = RolaWyżejComboBox.SelectedItem as Rola;
            var raportujeDoRoli = RolaRaportujeDoComboBox.SelectedItem as Rola;

            if (int.TryParse(RolaIdTextBox.Text, out int id) && id != 0) // Aktualizacja istniejącej roli
            {
                var rola = AppData.Role.FirstOrDefault(r => r.Id == id);
                if (rola != null)
                {
                    rola.Tytuł = RolaTytułTextBox.Text;
                    rola.Poziom = poziom;
                    rola.Dział = wybranyDział;
                    rola.DziałId = wybranyDział.Id;
                    rola.RolaWyżej = rolaWyżej;
                    rola.RolaWyżejId = rolaWyżej?.Id; // Operator ?. obsługuje null
                    rola.RaportujeDoRoli = raportujeDoRoli;
                    rola.RaportujeDoRoliId = raportujeDoRoli?.Id; // Operator ?. obsługuje null

                    AppData.AktualizujRola(rola);
                    MessageBox.Show("Rola została zaktualizowana.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
                }
            }
            else // Dodanie nowej roli
            {
                var nowaRola = new Rola
                {
                    Tytuł = RolaTytułTextBox.Text,
                    Poziom = poziom,
                    Dział = wybranyDział,
                    DziałId = wybranyDział.Id,
                    RolaWyżej = rolaWyżej,
                    RolaWyżejId = rolaWyżej?.Id,
                    RaportujeDoRoli = raportujeDoRoli,
                    RaportujeDoRoliId = raportujeDoRoli?.Id
                };
                AppData.DodajRola(nowaRola);
                MessageBox.Show("Nowa rola została dodana.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            WyczyśćFormularzRoli_Click(null, null);
            WczytajRole();
            WczytajOsoby(); // Odśwież Combobox w Osoby, bo role mogły się zmienić
            ZbudujSchematOrganizacyjny(); // Odśwież schemat
        }

        private void UsuńRolę_Click(object sender, RoutedEventArgs e)
        {
            var button = sender as Button;
            var rola = button?.DataContext as Rola;

            if (rola != null)
            {
                if (MessageBox.Show($"Czy na pewno chcesz usunąć rolę '{rola.Tytuł}'?", "Potwierdź usunięcie", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
                {
                    AppData.UsuńRola(rola.Id);
                    WczytajRole();
                    WyczyśćFormularzRoli_Click(null, null);
                    WczytajOsoby(); // Odśwież Combobox w Osoby
                    ZbudujSchematOrganizacyjny(); // Odśwież schemat
                }
            }
        }

        private void RoleDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (RoleDataGrid.SelectedItem is Rola wybranaRola)
            {
                RolaIdTextBox.Text = wybranaRola.Id.ToString();
                RolaTytułTextBox.Text = wybranaRola.Tytuł;
                RolaPoziomTextBox.Text = wybranaRola.Poziom.ToString();
                RolaDziałComboBox.SelectedValue = wybranaRola.DziałId;
                RolaWyżejComboBox.SelectedValue = wybranaRola.RolaWyżejId;
                RolaRaportujeDoComboBox.SelectedValue = wybranaRola.RaportujeDoRoliId;
            }
            else
            {
                WyczyśćFormularzRoli_Click(null, null);
            }
        }

        // --- Metody dla Zarządzania Osobami ---

        private void WyczyśćFormularzOsoby_Click(object sender, RoutedEventArgs e)
        {
            OsobaIdTextBox.Text = string.Empty;
            OsobaImięTextBox.Text = string.Empty;
            OsobaNazwiskoTextBox.Text = string.Empty;
            OsobaDataUrodzeniaDatePicker.SelectedDate = null;
            OsobaEmailTextBox.Text = string.Empty;
            OsobaTelefonTextBox.Text = string.Empty;
            OsobaDziałComboBox.SelectedItem = null;
            OsobaRolaComboBox.SelectedItem = null;
            OsobyDataGrid.SelectedItem = null;
        }

        private void DodajAktualizujOsobę_Click(object sender, RoutedEventArgs e)
        {
            // Podstawowa walidacja pól
            if (string.IsNullOrWhiteSpace(OsobaImięTextBox.Text) || string.IsNullOrWhiteSpace(OsobaNazwiskoTextBox.Text) ||
                OsobaDataUrodzeniaDatePicker.SelectedDate == null || OsobaDziałComboBox.SelectedItem == null || OsobaRolaComboBox.SelectedItem == null)
            {
                MessageBox.Show("Imię, Nazwisko, Data Urodzenia, Dział i Rola są wymagane dla osoby.", "Błąd Walidacji", MessageBoxButton.OK, MessageBoxImage.Error);
                return;
            }

            var wybranyDział = OsobaDziałComboBox.SelectedItem as Dział;
            var wybranaRola = OsobaRolaComboBox.SelectedItem as Rola;
            DateTime dataUrodzenia = OsobaDataUrodzeniaDatePicker.SelectedDate.Value; // Upewnij się, że data jest wybrana

            if (int.TryParse(OsobaIdTextBox.Text, out int id) && id != 0) // Aktualizacja istniejącej osoby
            {
                var osoba = AppData.Osoby.FirstOrDefault(o => o.Id == id);
                if (osoba != null)
                {
                    osoba.Imię = OsobaImięTextBox.Text;
                    osoba.Nazwisko = OsobaNazwiskoTextBox.Text;
                    osoba.DataUrodzenia = dataUrodzenia;
                    osoba.Email = OsobaEmailTextBox.Text;
                    osoba.NumerTelefonu = OsobaTelefonTextBox.Text;
                    osoba.Dział = wybranyDział;
                    osoba.DziałId = wybranyDział.Id;
                    osoba.Rola = wybranaRola;
                    osoba.RolaId = wybranaRola.Id;

                    AppData.AktualizujOsoba(osoba);
                    MessageBox.Show("Osoba została zaktualizowana.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
                }
            }
            else // Dodanie nowej osoby
            {
                var nowaOsoba = new Osoba
                {
                    Imię = OsobaImięTextBox.Text,
                    Nazwisko = OsobaNazwiskoTextBox.Text,
                    DataUrodzenia = dataUrodzenia,
                    Email = OsobaEmailTextBox.Text,
                    NumerTelefonu = OsobaTelefonTextBox.Text,
                    Dział = wybranyDział,
                    DziałId = wybranyDział.Id,
                    Rola = wybranaRola,
                    RolaId = wybranaRola.Id
                };
                AppData.DodajOsoba(nowaOsoba);
                MessageBox.Show("Nowa osoba została dodana.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
            }
            WyczyśćFormularzOsoby_Click(null, null);
            WczytajOsoby();
            ZbudujSchematOrganizacyjny(); // Odśwież schemat
        }

        private void UsuńOsobę_Click(object sender, RoutedEventArgs e)
        {
            var button = sender as Button;
            var osoba = button?.DataContext as Osoba;

            if (osoba != null)
            {
                if (MessageBox.Show($"Czy na pewno chcesz usunąć osobę '{osoba.Imię} {osoba.Nazwisko}'?", "Potwierdź usunięcie", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
                {
                    AppData.UsuńOsoba(osoba.Id);
                    WczytajOsoby();
                    WyczyśćFormularzOsoby_Click(null, null);
                    MessageBox.Show("Osoba została usunięta.", "Sukces", MessageBoxButton.OK, MessageBoxImage.Information);
                    ZbudujSchematOrganizacyjny(); // Odśwież schemat
                }
            }
        }

        private void OsobyDataGrid_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (OsobyDataGrid.SelectedItem is Osoba wybranaOsoba)
            {
                OsobaIdTextBox.Text = wybranaOsoba.Id.ToString();
                OsobaImięTextBox.Text = wybranaOsoba.Imię;
                OsobaNazwiskoTextBox.Text = wybranaOsoba.Nazwisko;
                OsobaDataUrodzeniaDatePicker.SelectedDate = wybranaOsoba.DataUrodzenia;
                OsobaEmailTextBox.Text = wybranaOsoba.Email;
                OsobaTelefonTextBox.Text = wybranaOsoba.NumerTelefonu;
                OsobaDziałComboBox.SelectedValue = wybranaOsoba.DziałId;
                OsobaRolaComboBox.SelectedValue = wybranaOsoba.RolaId;
            }
            else
            {
                WyczyśćFormularzOsoby_Click(null, null);
            }
        }

        // --- Metody dla Schematu Organizacyjnego ---

        private void ZbudujSchematOrganizacyjny()
        {
            // 1. Wyczyść poprzednie dane i powiązania w drzewie
            foreach (var rola in AppData.Role)
            {
                rola.PodrzędneRole.Clear();
                rola.PrzypisaneOsoby.Clear();
            }

            // 2. Przypisz osoby do ról
            foreach (var osoba in AppData.Osoby)
            {
                var rolaOsoby = AppData.Role.FirstOrDefault(r => r.Id == osoba.RolaId);
                if (rolaOsoby != null)
                {
                    rolaOsoby.PrzypisaneOsoby.Add(osoba);
                }
            }

            // 3. Zbuduj hierarchię ról (kto komu raportuje, kto jest podrzędny)
            // Znajdź wszystkie role, które NIE raportują do nikogo (czyli są na najwyższym poziomie hierarchii dla drzewa)
            // W TreeView chcemy wyświetlić drzewo, gdzie Rola nadrzędna jest rodzicem Roli podrzędnej.
            // ItemsSource dla TreeView powinny być elementami najwyższego poziomu.
            var roleNajwyższegoPoziomu = AppData.Role
                                        .Where(r => !r.RaportujeDoRoliId.HasValue) // Role bez nadrzędnej roli raportującej
                                        .OrderBy(r => r.Poziom) // Opcjonalnie posortuj
                                        .ToList();

            // Dla każdej roli, zidentyfikuj jej podrzędne role
            // Używamy .ToList() na kopii, aby uniknąć modyfikacji kolekcji podczas iteracji
            foreach (var rolaNadrzędna in AppData.Role.ToList())
            {
                foreach (var rolaPodrzędna in AppData.Role.Where(r => r.RaportujeDoRoliId == rolaNadrzędna.Id).ToList())
                {
                    rolaNadrzędna.PodrzędneRole.Add(rolaPodrzędna);
                }
            }


            // Ustaw ItemsSource dla TreeView na listę ról najwyższego poziomu
            OrganizationalTreeView.ItemsSource = roleNajwyższegoPoziomu;
        }
    }
}