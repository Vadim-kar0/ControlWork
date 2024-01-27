package Model;

import java.time.LocalDate;
import java.util.List;

public class Humster extends Pet{
    public Humster(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenius(AnimalGenius.HAMSTER);
    }
}
