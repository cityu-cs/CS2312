package Final.MID.Q2;

import java.util.*;

class SalesAgent {

	private int commissionEarning;

	public void promote(Customer c, Product p) {
		c.shop(this, p);
	}

	public void earnCommission(int e) {
		commissionEarning += e;
		System.out.println(
			"Salesman commission has reached $" + 
			commissionEarning + ".");
	}

	//This method is used in part (c)
    public void promoteAll(Product p) {
		Customer.all_shop(this, p);
    }
}

class Product {

	private int price;

	public Product(int price) { 
		this.price=price; 
	}

	public int getPrice() { 
		return price; 
	}
}

public class Main {

public static void main(String[] args) {

        // For Part (a) 
        SalesAgent s1 = new SalesAgent();
        SalesAgent s2 = new SalesAgent();

        Customer c1 = new Customer(200); // has $200 initially
        Customer c2 = new Customer(100); // has $100 initially
        Customer c3 = new Customer(100); // has $100 initially

        Product p1 = new Product(100); // price is $100
        Product p2 = new Product(80); // price is $80

        s1.promote(c1, p1); // Output: OK. I buy the product. I have $100 left. Salesman commission has reached $10.
        s2.promote(c1, p1); // Output: No thanks. I have got one already.
        s2.promote(c1, p2); // Output: OK. I buy the product. I have $20 left. Salesman commission has reached $8.

        s1.promote(c2, p2); // Output: OK. I buy the product. I have $20 left. Salesman commission has reached $18.
        s2.promote(c2, p1); // Output: No thanks. I am out of money.

        // For Part (c)
        s1.promoteAll(p1); // Output one line per customer, totally 3 lines below:
                /*
                1: No thanks. I am out of money.
                2: No thanks. I am out of money.
                3: OK. I buy the product. I have 0 left. Salesman commission has reached $28.        
                */

    }
}

class Customer {
    private int balance;
    private List<Product> products;
    static private List<Customer> all_customers = new ArrayList<Customer>();
    public Customer(int balance) { 
        this.balance = balance;
        products = new ArrayList<Product>();
        all_customers.add(this);
    }

    private boolean hasPurchased(Product p) {
        return products.contains(p);
    }

    public void shop(SalesAgent s, Product p) {
        int newBalance = balance - p.getPrice();
        if (newBalance < 0) {
            System.out.println("No thanks. I am out of money.");
        } else if (hasPurchased(p)) {
            System.out.println("No thanks. I have got one already.");
        } else {
            balance = newBalance;
            products.add(p);
            System.out.printf("OK. I buy the product. I have $%d left. ", balance);
            s.earnCommission(p.getPrice() / 10);
        }
    }

    public static void all_shop(SalesAgent s, Product p) {
        for (int i = 0; i < all_customers.size(); i++) {
            System.out.printf("%d: ", i + 1);
            all_customers.get(i).shop(s, p);
        }
    }
}
