package Model;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimal{
    public Camel(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenus(AnimalGenus.CAMEL);
    }

}
