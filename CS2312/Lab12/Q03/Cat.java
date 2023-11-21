public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    } // super class doesn't have a default constructor Animal()
    // therefore explicit constructor is required

    @Override
    public int getRunSpeed() {
        return 5;
    }

    @Override
    public String getMyName() {
        return getName();
    }

    public void chase(Runnable target) {
        if (getRunSpeed() > target.getRunSpeed()) {
            System.out.printf("%s Catches %s\n", getMyName(), target.getMyName());
        } else {
            System.out.printf("%s Cannot Catch %s\n", getMyName(), target.getMyName());
        }
    }
}
