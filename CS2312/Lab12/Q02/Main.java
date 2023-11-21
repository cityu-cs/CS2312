public class Main {
    public static void main(String[] args) {  
        Person person = new Person();
        String[] playableStrings = {
            "Football", "Piano", "Piano", "Football", "Chess"
        };
        for (String playableString : playableStrings) {
            Playable playable = person.getPlay(playableString);
            if (playable != null) {
                playable.play();
            }
        }
    }
}
