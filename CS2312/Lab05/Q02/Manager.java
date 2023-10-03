package CS2312.Lab05.Q02;

public class Manager extends Employee {
    private double bonus;

    public Manager() {}
    
    public Manager(String id, String name, double salary, double bonus) {
        super(id, name, salary);
        this.bonus = bonus;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public String toString() {
        return String.format("[%s %s] Basic salary: %.2f, Bonus: %.2f",
            super.getId(), super.getName(), super.getSalary(), this.bonus
        );
    }
}
