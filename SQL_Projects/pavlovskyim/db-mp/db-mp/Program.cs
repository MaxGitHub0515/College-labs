// See https://aka.ms/new-console-template for more information
// using Microsoft.EntityFrameworkCore.Query;
using b2_4.Models;

var context = new NorthwindContext();
var customers = context.Customers.Include(context => c.Orders).ThenInclude(o => o.OrderDetails);

foreach(var customer in  customers) {
    Console.WriteLine(customer.ContactName);
    foreach(var order in customer.Orders)
    {
        Console.WriteLine(order.OrderDate); 
        foreach(var od in order.OrderDetails)
        {
            Console.WriteLine(od.Quantity.UnitPrice);
        }
    }
}


/*
 * display the follwoing data
 * client
 * order
 * 


/* DB CONNECTION STRING */
//"Server = 10.8.0.16; Database = maxpavlovskyim; User Id = BAZAORAZOPROGRAMOWANIE; Password = 40566; MultipleActiveResultSets = true"

