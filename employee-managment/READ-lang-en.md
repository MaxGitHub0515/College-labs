
# Employee Management System

## Table of Contents:
- [*App Functionality - Client-Side Perspective*](#application-functionality---client-side-perspective)
- [*App Structure*](#project-structure)
- [*Setting up SQL DB*](#setting-up-sql-with-ssms)


## STACK
- [*.NET CORE*](#)
- [*XAML (library WPF)*](#)
- [*MVVN Pattern*](#example-of-mvvn-pattern )
- [*LINQ (querying from DB)*](#)
- [*SQL* (relational DB)](#database-tables)


## Application Functionality - Client-Side Perspective

**What a User can DO?**
- For Department:
    - Add a department name and description for it
     
- For Role:
    - Add a role with the following details:
        - Add a role title,
        - Level (which represents position in a hierarchy),
        - Higher role (to choose role above the current one in hierarchy)
        - Report (to report to specific role)

- For Person:
    - Add personal details, including:
        - Add a name and surname, data of birth, email,
        phone number, department and role (choose from previously added and add your own in department section), 

- Organizational Hierarchy
    - View the current structure of roles 
    (those that were previously added) displayed as a hierarchical tree.

## Application Structure

### Example of MVVN Pattern 
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
    - *Services/ (Optional)*
        - *YourDataService.cs*
        - *...*
    - *App.xaml*

### Project Structure
    **SystemZarządzaniaPracownikami/**
    - *bin/*
        - *Debug/*
        - *Release/*
    - *Data/*
        - *AppData.cs*
    - *Models/*
        - *Converters.cs*
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


## Setting up [SQL with SSMS]()
    - FIRST STEPS:
        - CREATE DB in SSMS called **EmployeeDB**
        - ADD THE FOLLOWING 3 TABLES to the DB called:
            - Department
            - Person
            - Role

--> Which should look like as follows:

## Database Tables

### dbo.Department

| Column Name   | Data Type      | Nullable | Primary Key | Foreign Key |
|---------------|----------------|----------|-------------|-------------|
| Id            | int            | No       | Yes         |             |
| Nazwa         | nvarchar(255)  | No       |             |             |
| Opis          | nvarchar(max)  | Yes      |             |             |

---

### dbo.Person

| Column Name      | Data Type      | Nullable | Primary Key | Foreign Key |
|------------------|----------------|----------|-------------|-------------|
| Id               | int            | No       | Yes         |             |
| Imię             | nvarchar(255)  | No       |             |             |
| Nazwisko         | nvarchar(255)  | No       |             |             |
| DataUrodzenia    | date           | No       |             |             |
| Email            | nvarchar(255)  | Yes      |             |             |
| NumerTelefonu    | nvarchar(20)   | Yes      |             |             |
| DziałId          | int            | No       |             | Yes         |
| RolaId           | int            | No       |             | Yes         |

---

### dbo.Role

| Column Name       | Data Type     | Nullable | Primary Key | Foreign Key |
|-------------------|---------------|----------|-------------|-------------|
| Id                | int           | No       | Yes         |             |
| Tytuł             | nvarchar(255) | No       |             |             |
| Poziom            | int           | No       |             |             |
| DziałId           | int           | No       |             | Yes         |
| RolaWyzejId       | int           | Yes      |             | Yes         |
| RaportujeDoRoliId | int           | Yes      |             | Yes         |


- When DB set-up is DONE you should proceed to Package Installation:
    - Install the following packages (so as to import already created tables as models into VSC):
```shell
    dotnet add package Microsoft.EntityFrameworkCore
    dotnet add package Microsoft.EntityFrameworkCore.SqlServer
    dotnet add package Microsoft.EntityFrameworkCore.Tools
    dotnet add package Microsoft.EntityFrameworkCore.Design
```
    -  If you want to install a specific version of a NuGet package using the .NET CLI, you add the --version argument at the end of the dotnet add package command just like that: 

```shell
    dotnet add package YourPackageName --version 3.1.7
```

- After the successful installation run a Connection String, but replace the dummy data using your own instead:

```shell 
    dotnet ef dbcontext scaffold "Server=YourServerName;Database=YourDBName;Trusted_Connection=True;TrustServerCertificate=True;" Microsoft.EntityFrameworkCore.SqlServer -o Models -c GeneratedDbContext --data-annotations --force
```
- Then if your build is successful, you get all tables inside models already set up for you along with root file - generatedDbContext

