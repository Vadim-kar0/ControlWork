package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract   class Animal implements  Comparable<Animal>{
    private static int counter;
    private final int id = ++counter;
    private AnimalGenus animalGenus;
    private String name;
    private LocalDate birthday;
    private List<String> commands;


    public Animal(String name, LocalDate birthday, List<String> commands) {
        this.name = name;
        this.birthday = birthday;
        this.commands = commands;
    }

    public Animal(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public AnimalGenus getAnimalGenus() {
        return animalGenus;
    }

    public void setAnimalGenus(AnimalGenus animalGenus) {
        this.animalGenus = animalGenus;
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

    public void addCommand(String command){
        this.commands.add(command);
    }
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalGenius=" + animalGenus +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", commands=" + commands.toString() +
                "}\n";
    }

    @Override
    public int compareTo(Animal o) {
        if(getBirthday() == null || o.getBirthday() == null)
            return 0;
        return getBirthday().compareTo(o.getBirthday());
    }


}
