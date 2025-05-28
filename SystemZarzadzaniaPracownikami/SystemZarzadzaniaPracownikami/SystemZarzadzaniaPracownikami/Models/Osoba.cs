using System;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace SystemZarzadzaniaPracownikami.Models
{
    public class Osoba : INotifyPropertyChanged
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

        private string _imię;
        public string Imię
        {
            get { return _imię; }
            set
            {
                if (_imię != value)
                {
                    _imię = value;
                    OnPropertyChanged();
                }
            }
        }

        private string _nazwisko;
        public string Nazwisko
        {
            get { return _nazwisko; }
            set
            {
                if (_nazwisko != value)
                {
                    _nazwisko = value;
                    OnPropertyChanged();
                }
            }
        }

        private DateTime _dataUrodzenia;
        public DateTime DataUrodzenia
        {
            get { return _dataUrodzenia; }
            set
            {
                if (_dataUrodzenia != value)
                {
                    _dataUrodzenia = value;
                    OnPropertyChanged();
                }
            }
        }

        private string _email;
        public string Email
        {
            get { return _email; }
            set
            {
                if (_email != value)
                {
                    _email = value;
                    OnPropertyChanged();
                }
            }
        }

        private string _numerTelefonu;
        public string NumerTelefonu
        {
            get { return _numerTelefonu; }
            set
            {
                if (_numerTelefonu != value)
                {
                    _numerTelefonu = value;
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

        // Klucz obcy do Roli
        private int _rolaId;
        public int RolaId
        {
            get { return _rolaId; }
            set
            {
                if (_rolaId != value)
                {
                    _rolaId = value;
                    OnPropertyChanged();
                }
            }
        }

        private Rola _rola;
        public Rola Rola // Obiekt Roli
        {
            get { return _rola; }
            set
            {
                if (_rola != value)
                {
                    _rola = value;
                    OnPropertyChanged();
                }
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName] string name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}