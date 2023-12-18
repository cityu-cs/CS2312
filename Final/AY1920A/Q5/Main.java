package Final.AY1920A.Q5;

import javax.swing.Icon;

public class Main {
    public static void main(String [] args)  {   
        Product p1 = new Product("P001", 100); //id and price
        Product p2 = new Product("P002", 200);
        Product p3 = new Product("P003", 300);
        
        Service s1 = new Service("S001", 150); //id and price
        Service s2 = new Service("S002", 250);
        Service s3 = new Service("S003", 350);
        
        Customer c1 = new Customer("Helena"); //customer name
        Customer c2 = new Customer("Mary");
        Customer c3 = new Customer("Paul");
        
        Shop h1 = new Shop("Shop A", new Tradable[] {p1,s1}); //Shop name, products and services 
        Shop h2 = new Shop("Shop B", new Tradable[] {p1,p2,p3});         
        Shop h3 = new Shop("Shop C", new Tradable[] {s1,s2,s3});
        
        c1.order(s1, h1);  
        c2.order(p1, h2);  
        c3.order(p2, h3);  
    }  
}

class Customer {
    private String name;
    public Customer(String name) {this.name=name;}
    public void order(IConsumable cons, Shop s) {
        System.out.println(name + " orders " + cons + " from " + s +
        ", price is " + cons.getPrice() +
        ", discount percentage is " + cons.getDiscountPercent());
        s.processOrder(this, cons);
    }  
}

/*
 * Background:
 * Product and Service belongs to Tradable abstract class.
 * 10% discount for Product over 50 dollars.
 * 20% discount for Service over 100 dollars.
 * The profit of a Product is 10%. The profit of a Service is 30%.
 * To Customer, Tradable is known as IConsumable. They do not have access to the profit.
 * 
 * Expected output:
Helena orders S001 from Shop A, price is 150, discount percentage is 20 
Traded: S001, Earning: 45 
Mary orders P001 from Shop B, price is 100, discount percentage is 10 
Traded: P001, Earning: 10 
Paul orders P002 from Shop C, price is 200, discount percentage is 10 
Not provided!

 * Implement class Shop, interface IConsumable, abstract class Tradable, class Product and class Service.
 */

class Shop {
    private String name;
    private Tradable[] tradables;
    public Shop(String name, Tradable[] tradables) {
        this.name = name;
        this.tradables = tradables;
    }

    public void processOrder(Customer c, IConsumable cons) {
        for (Tradable t : tradables) {
            if(t.equals(cons)) {
                System.out.printf("Traded: %s, Earning: %d\n", t, t.getProfit());
                return;
            }
        }
        System.out.println("Not provided!");
    }

    @Override
    public String toString() {
        return name;
    }
}

interface IConsumable {
    int getDiscountPercent();
    int getPrice();
}

abstract class Tradable implements IConsumable {
    private String id;
    private int price;
    public Tradable(String id, int price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public abstract int getProfit();
}

class Product extends Tradable {
    public Product(String id, int price) {
        super(id, price);
    }

    @Override
    public int getDiscountPercent() {
        return super.getPrice() > 50 ? 10 : 0;
    }

    @Override
    public int getProfit() {
        return (int) (0.1 * super.getPrice());
    }
}

class Service extends Tradable {
    public Service(String id, int price) {
        super(id, price);
    }

    @Override
    public int getDiscountPercent() {
        return super.getPrice() > 100 ? 20 : 0;
    }

    @Override
    public int getProfit() {
        return (int) (0.3 * super.getPrice());
    }
}
