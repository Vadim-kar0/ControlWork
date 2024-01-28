package Model;

public enum AnimalGenus {
    DOG ("Dog"),
    CAT ("Cat"),
    HAMSTER ("Hamster"),
    HORSE ("Horse"),
    CAMEL ("Camel"),
    DONKEY ("Donkey");

    private final String genusName;
    AnimalGenus(String genusName) {
        this.genusName = genusName;
    }

    public String getGenusName() {
        return genusName;
    }
}
