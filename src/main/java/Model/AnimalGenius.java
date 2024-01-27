package Model;

public enum AnimalGenius {
    DOG ("Dog"),
    CAT ("Cat"),
    HAMSTER ("Humster"),
    HORSE ("Horse"),
    CAMEL ("Camel"),
    DONKEY ("Donkey");

    private final String geniusName;
    AnimalGenius(String geniusName) {
        this.geniusName = geniusName;
    }

    public String getGeniusName() {
        return geniusName;
    }
}
