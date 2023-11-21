public class Person {
    public Playable getPlay(String token) {
        if (token.equals("Piano")) {
            return new Piano();
        } else if (token.equals("Football")) {
            return new Football();
        } else if (token.equals("Chess")) {
            return new Chess();
        } else {
            return null;
        }
    }
}