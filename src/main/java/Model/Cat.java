package Model;

import java.time.LocalDate;
import java.util.List;

public class Cat extends Pet{
    public Cat(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenius(AnimalGenius.CAT);
    }
}
