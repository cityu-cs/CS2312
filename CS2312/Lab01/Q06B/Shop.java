package CS2312.Lab01.Q06B;

public class Shop {
    private int profit;

    public int getProfit() {
        return profit;
    }

    public void earn(Customer c, int amount) {
        c.setAmount(c.getAmount() - amount);
        profit += amount;
    }

    public void earn(Group g, int amount) {
        g.pay(amount);
        profit += amount;
    }
}
