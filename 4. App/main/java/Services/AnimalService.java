package Services;

import Model.*;
import Services.ModelService.AnimalComparatorByBirthday;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class AnimalService implements AnimalInterface{
    private List<Animal> animals;

    public AnimalService(List<Animal> animals) {
        this.animals = new ArrayList<Animal>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }


    private String chooseName(){
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            int i;
            System.out.println("Write an animal name: ");
            name = scanner.nextLine();
            System.out.println("if the name = {" + name + "} is spelled correctly, write 1 else 0");
            i = scanner.nextInt();
            if (i == 1) {
                return name;
            }
        }
    }

    private LocalDate chooseBirthday(){
        Scanner scanner = new Scanner(System.in);
        LocalDate date;
        while (true) {
            int i;
            System.out.println("Write an animal birthday(format = YYYY-MM-DD): ");
            date = LocalDate.parse(scanner.nextLine());
            System.out.println("if the date = {" + date + "} is spelled correctly, write 1 else 0");
            i = scanner.nextInt();
            if (i == 1) {
                return date;
            }
        }
    }

    private List<String> chooseCommands(){
        Scanner scanner = new Scanner(System.in);
        List<String> commands;
        while (true) {
            int i;
            System.out.println("Write an animal commands through comma (format:run,jump,swim): ");
            commands = List.of(scanner.nextLine().split(","));
            System.out.println("if the commands = {" + commands + "} is spelled correctly, write 1 else 0");
            i = scanner.nextInt();
            if (i == 1) {
                return commands;
            }
        }
    }

    private AnimalGenus chooseGenus(){
        Scanner scanner = new Scanner(System.in);
        AnimalGenus ag;
        while (true) {
            int i;
            int answer;
            System.out.println( """
                Choose an animal genus:
                1 - Cat
                2 - Dog
                3 - Hamster
                4 - Horse
                5 - Camel
                6 - Donkey
                """);

            answer = scanner.nextInt();
            while (answer > 6 || answer < 1){
                System.out.println( """
                Choose an animal genus:
                1 - Cat
                2 - Dog
                3 - Hamster
                4 - Horse
                5 - Camel
                6 - Donkey
                """);
                answer = scanner.nextInt();
            }
            switch (answer) {
                case 1 -> ag = AnimalGenus.CAT;
                case 2 -> ag = AnimalGenus.DOG;
                case 3 -> ag = AnimalGenus.HAMSTER;
                case 4 -> ag = AnimalGenus.HORSE;
                case 5 -> ag = AnimalGenus.CAMEL;
                case 6 -> ag = AnimalGenus.DONKEY;
                default -> throw new IllegalStateException("Unexpected value: " + answer);
            }
            System.out.println("if the date = {" + ag.getGenusName() + "} is spelled correctly, write 1 else 0");
            i = scanner.nextInt();
            if (i == 1) {
                return ag;
            }
        }
    }

    @Override
    public void addNewAnimal() throws IllegalStateException {
        Animal animal;
        AnimalGenus ag = chooseGenus();
        String name = chooseName();
        LocalDate birthday = chooseBirthday();
        List<String> commands = chooseCommands();
        switch (ag){
            case CAT -> animal = new Cat(name,birthday,commands);
            case DOG -> animal = new Dog(name,birthday,commands);
            case HAMSTER -> animal = new Hamster(name,birthday,commands);
            case HORSE -> animal = new Horse(name,birthday,commands);
            case CAMEL -> animal = new Camel(name,birthday,commands);
            case DONKEY -> animal = new Donkey(name,birthday,commands);
            default -> throw new IllegalStateException("Unexpected value: " + ag);
        }
        List<Animal> animals = getAnimals();
        animals.add(animal);
        setAnimals(animals);
        System.out.println("successfully added");
}

    @Override
    public String getCommandsLastAnimal() {
    String result;
    Animal animal = getAnimals().get(-1);
    result = animal.getCommands().toString();
    return result;
    }

    @Override
    public String getCommandsAnimalById() {
    Scanner scanner = new Scanner(System.in);
    String result;
    System.out.println("Write animal id");
    int i = scanner.nextInt();
    Animal animal = getAnimals().get(i-1);
    result = animal.getCommands().toString();
    return result;
    }

    @Override
    public void addCommandToAnimalById() {
    Scanner scanner = new Scanner(System.in);
    List<String> commands;
    List<Animal> animals = null;
    String newCommand;

    System.out.println("Write animal id");
    int i = scanner.nextInt();
    Animal animal = getAnimals().get(i-1);
    commands = animal.getCommands();
    System.out.println("Animal has commands = ");
    System.out.print(commands);
    System.out.println("Write new command");
    newCommand = scanner.nextLine();
    commands.add(newCommand);
    animal.setCommands(commands);
    animals.set(i-1,animal);
    System.out.println("successfully added");
    }

    @Override
    public void showAllAnimalSortByBirthday() {
    List<Animal> list = getAnimals();
    list.sort(new AnimalComparatorByBirthday<Animal>());
    for (Animal animal : list) {
        System.out.println(animal);
    }
    }

    @Override
    public void showAmountAllAddAnimals() {

    System.out.println(Animal.getCounter());

    }
    }
