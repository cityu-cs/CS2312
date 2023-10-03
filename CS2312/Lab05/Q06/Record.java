package CS2312.Lab05.Q06;

public class Record {
    private String id;
    private String area;
    private int age;

    public Record() {}

    public Record(String id, String area, int age) {
        this.id = id;
        this.area = area;
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public int getAge() {
        return age;
    }
}
