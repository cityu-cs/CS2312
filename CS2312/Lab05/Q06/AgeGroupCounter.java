package CS2312.Lab05.Q06;

public class AgeGroupCounter extends Counter {
    private int ageLo;
    private int ageHi;

    public AgeGroupCounter(int ageLo, int ageHi) {
        this.ageLo = ageLo;
        this.ageHi = ageHi;
    }

    public void countData(Record r) {
        int age = r.getAge();
        if (age >= ageLo && age <= ageHi) {
            super.setCounter(super.getCounter() + 1);
        }
    }

    public String toString() {
        return String.format("[Age %d to %d] Count = %d", ageLo, ageHi, super.getCounter());
    }
}
