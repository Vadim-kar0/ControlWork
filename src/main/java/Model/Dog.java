package Model;

import java.time.LocalDate;
import java.util.List;

public class Dog extends Pet{
    public Dog(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
        setAnimalGenus(AnimalGenus.DOG);
    }
}
