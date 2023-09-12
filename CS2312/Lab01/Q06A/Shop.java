package CS2312.Lab01.Q06A;

public class Shop {
    private int profit;

    public int getProfit() {
        return profit;
    }

    public void earn(Customer c, int amount) {
        c.setAmount(c.getAmount() - amount);
        profit += amount;
    }
}
