package Model;

import java.time.LocalDate;
import java.util.List;

public class Donkey extends PackAnimal{
    public Donkey(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenus(AnimalGenus.DONKEY);
    }
}
