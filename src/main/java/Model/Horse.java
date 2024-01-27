package Model;

import java.time.LocalDate;
import java.util.List;

public class Horse extends PackAnimal{
    public Horse(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenius(AnimalGenius.HORSE);
    }
}
