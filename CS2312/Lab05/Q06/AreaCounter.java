package CS2312.Lab05.Q06;

public class AreaCounter extends Counter {
    private String areaName;

    public AreaCounter(String areaName) {
        this.areaName = areaName;
    }

    public void countData(Record r) {
        if (r.getArea().equals(areaName)) {
            super.setCounter(getCounter() + 1);
        }
    }

    public String toString() {
        return String.format("[%s area] Count = %d", areaName, super.getCounter());
    }
}
