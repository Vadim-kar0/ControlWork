package Model;

import java.time.LocalDate;
import java.util.List;

public class Hamster extends Pet{
    public Hamster(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenus(AnimalGenus.HAMSTER);
    }
}
