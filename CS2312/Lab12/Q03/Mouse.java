public class Mouse extends Animal {
    public Mouse(String name) {
        super(name);
    }

    @Override
    public int getRunSpeed() {
        return 2;
    }

    @Override
    public String getMyName() {
        return getName();
    }
}
