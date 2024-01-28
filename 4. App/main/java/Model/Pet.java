package Model;

import java.time.LocalDate;
import java.util.List;

public abstract class Pet extends Animal{
    public Pet(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
    }
}
