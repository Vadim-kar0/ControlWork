package Services;

import Model.Animal;

import java.util.List;

public interface AnimalInterface {
    public void addNewAnimal() throws IllegalStateException;
    public void getCommandsAnimalById();
    public void addCommandToAnimalById();
    public void showAllAnimalSortByBirthday();
    public void showAmountAllAddAnimals();
}
