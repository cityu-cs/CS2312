package CS2312.Lab05.Q06;

public class Counter {
    private int counter = 0;

    public Counter() {}

    public void countData(Record r) {
        counter++;
    }

    public String toString() {
        return String.format("[Total] Count = %d", counter);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
