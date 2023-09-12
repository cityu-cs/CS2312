package CS2312.Lab01.Q06B;

import java.util.ArrayList;

public class Group {
    private ArrayList<Customer> customers = new ArrayList<>();

    public void add(Customer c) {
        customers.add(c);
    }

    public void pay(int amount) {
        if (customers.size() == 0) {
            return;
        }
        int each = amount / customers.size();
        for (Customer c : customers) {
            c.setAmount(c.getAmount() - each);
        }
    }
}
