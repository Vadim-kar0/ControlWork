package Model;

import java.time.LocalDate;
import java.util.List;

public abstract class PackAnimal extends  Animal{
    public PackAnimal(String name, LocalDate birthday, List<String> commands) {
        super(name, birthday, commands);
    }
}
