using System.Collections.ObjectModel; // Potrzebne do ObservableCollection
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace SystemZarzadzaniaPracownikami.Models
{
    public class Rola : INotifyPropertyChanged
    {
        private int _id;
        public int Id
        {
            get { return _id; }
            set
            {
                if (_id != value)
                {
                    _id = value;
                    OnPropertyChanged();
                }
            }
        }

        private string _tytuł;
        public string Tytuł
        {
            get { return _tytuł; }
            set
            {
                if (_tytuł != value)
                {
                    _tytuł = value;
                    OnPropertyChanged();
                }
            }
        }

        private int _poziom;
        public int Poziom
        {
            get { return _poziom; }
            set
            {
                if (_poziom != value)
                {
                    _poziom = value;
                    OnPropertyChanged();
                }
            }
        }

        // Klucz obcy do Działu
        private int _działId;
        public int DziałId
        {
            get { return _działId; }
            set
            {
                if (_działId != value)
                {
                    _działId = value;
                    OnPropertyChanged();
                }
            }
        }

        private Dział _dział;
        public Dział Dział // Obiekt Działu
        {
            get { return _dział; }
            set
            {
                if (_dział != value)
                {
                    _dział = value;
                    OnPropertyChanged();
                }
            }
        }

        // Klucz obcy do roli nadrzędnej (hierarchia)
        private int? _rolaWyżejId; // Nullable int
        public int? RolaWyżejId
        {
            get { return _rolaWyżejId; }
            set
            {
                if (_rolaWyżejId != value)
                {
                    _rolaWyżejId = value;
                    OnPropertyChanged();
                }
            }
        }

        private Rola _rolaWyżej;
        public Rola RolaWyżej // Obiekt Roli nadrzędnej
        {
            get { return _rolaWyżej; }
            set
            {
                if (_rolaWyżej != value)
                {
                    _rolaWyżej = value;
                    OnPropertyChanged();
                }
            }
        }

        // Klucz obcy do roli, do której raportuje
        private int? _raportujeDoRoliId; // Nullable int
        public int? RaportujeDoRoliId
        {
            get { return _raportujeDoRoliId; }
            set
            {
                if (_raportujeDoRoliId != value)
                {
                    _raportujeDoRoliId = value;
                    OnPropertyChanged();
                }
            }
        }

        private Rola _raportujeDoRoli;
        public Rola RaportujeDoRoli // Obiekt Roli, do której raportuje
        {
            get { return _raportujeDoRoli; }
            set
            {
                if (_raportujeDoRoli != value)
                {
                    _raportujeDoRoli = value;
                    OnPropertyChanged();
                }
            }
        }

        // Kolekcja podrzędnych ról w hierarchii (dla TreeView)
        public ObservableCollection<Rola> PodrzędneRole { get; set; } = new ObservableCollection<Rola>();

        // Kolekcja osób przypisanych do tej roli (dla TreeView)
        public ObservableCollection<Osoba> PrzypisaneOsoby { get; set; } = new ObservableCollection<Osoba>();


        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName] string name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}