package Services;

import Model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    @Override
    public void addNewAnimal() {
        List<Animal> a = getAnimals();
        a.add(animal);
        setAnimals(a);
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
        this.animals = animals;

    }

    @Override
    public void showAllAnimalSortByBirthday() {


    }

    @Override
    public void showAmountAllAddAnimals() {

        System.out.println(Animal.getCounter());

    }
}
