package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private static int counter;
    private final int id = ++counter;
    private AnimalGenius animalGenius;
    private String name;
    private LocalDate birthday;
    private List<String> commands;


    public Animal(String name, LocalDate birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public AnimalGenius getAnimalGenius() {
        return animalGenius;
    }

    public void setAnimalGenius(AnimalGenius animalGenius) {
        this.animalGenius = animalGenius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<String> getCommands() {
        return commands;
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(Animal animal, String comandName){
        if (animal.getCommands().contains(comandName)) {
            System.out.println("Hi has known this command");
        } else {
            List<String> list = getCommands();
            list.add(comandName);
            animal.setCommands(list);
        }
    }


    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalGenius=" + animalGenius +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands=" + commands +
                '}';
    }
}
