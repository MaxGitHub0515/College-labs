using System.Collections.Generic; // Добавлена эта директива
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace SystemZarzadzaniaPracownikami.Models
{
    public class Dział : INotifyPropertyChanged
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

        private string _nazwa;
        public string Nazwa
        {
            get { return _nazwa; }
            set
            {
                if (_nazwa != value)
                {
                    _nazwa = value;
                    OnPropertyChanged();
                }
            }
        }

        private string _opis;
        public string Opis
        {
            get { return _opis; }
            set
            {
                if (_opis != value)
                {
                    _opis = value;
                    OnPropertyChanged();
                }
            }
        }

        // Добавлены навигационные свойства для Entity Framework Core
        // Эти свойства будут представлять коллекции связанных ролей и сотрудников
        public virtual ICollection<Rola> Role { get; set; } = new HashSet<Rola>();
        public virtual ICollection<Osoba> Osoby { get; set; } = new HashSet<Osoba>();

        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName] string name = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));
        }
    }
}