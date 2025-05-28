using Microsoft.EntityFrameworkCore;
using SystemZarzadzaniaPracownikami.Models; // Убедитесь, что это ваша правильная папка Models

namespace SystemZarzadzaniaPracownikami.Data // Убедитесь, что это ваша правильная папка Data
{
    public class ApplicationDbContext : DbContext
    {
        // Наборы данных (DbSet) для каждой из ваших моделей
        public DbSet<Dział> Działy { get; set; }
        public DbSet<Rola> Role { get; set; }
        public DbSet<Osoba> Osoby { get; set; }

        // Конфигурация базы данных SQLite
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            // Указываем, что будем использовать SQLite и где будет храниться файл базы данных.
            // Файл будет создан в той же директории, что и исполняемый файл приложения.
            optionsBuilder.UseSqlite("Data Source=SystemZarzadzaniaPracownikami.db");
        }

        // Метод для настройки связей между моделями (при необходимости)
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            // Настройка отношений для Rola (сам с собой и с Dział)
            modelBuilder.Entity<Rola>()
                .HasOne(r => r.RolaWyżej)        // Rola имеет одну RolaWyżej
                .WithMany(r => r.PodrzędneRole)  // RolaWyżej может иметь много PodrzędneRole
                .HasForeignKey(r => r.RolaWyżejId) // Внешний ключ для RolaWyżej
                .IsRequired(false)               // Необязательная связь (может быть null)
                .OnDelete(DeleteBehavior.Restrict); // Запретить каскадное удаление

            modelBuilder.Entity<Rola>()
                .HasOne(r => r.RaportujeDoRoli) // Rola имеет одну RolaRaportujeDoRoli
                .WithMany()                     // Без навигационного свойства в другой стороне
                .HasForeignKey(r => r.RaportujeDoRoliId) // Внешний ключ для RaportujeDoRoli
                .IsRequired(false)              // Необязательная связь
                .OnDelete(DeleteBehavior.Restrict); // Запретить каскадное удаление

            modelBuilder.Entity<Rola>()
                .HasOne(r => r.Dział)           // Rola имеет один Dział
                .WithMany(d => d.Role)          // Dział может иметь много Role
                .HasForeignKey(r => r.DziałId)  // Внешний ключ для Dział
                .OnDelete(DeleteBehavior.Restrict); // Запретить каскадное удаление

            // Настройка отношений для Osoba (с Dział и Rola)
            modelBuilder.Entity<Osoba>()
                .HasOne(o => o.Dział)
                .WithMany(d => d.Osoby)
                .HasForeignKey(o => o.DziałId)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder.Entity<Osoba>()
                .HasOne(o => o.Rola)
                .WithMany(r => r.PrzypisaneOsoby)
                .HasForeignKey(o => o.RolaId)
                .OnDelete(DeleteBehavior.Restrict);

            // Ограничение удаления для Dział: если есть связанные Role или Osoby, удаление запрещено
            modelBuilder.Entity<Dział>()
                .HasMany(d => d.Role)
                .WithOne(r => r.Dział)
                .OnDelete(DeleteBehavior.Restrict);

            modelBuilder.Entity<Dział>()
                .HasMany(d => d.Osoby)
                .WithOne(o => o.Dział)
                .OnDelete(DeleteBehavior.Restrict);
        }
    }
}