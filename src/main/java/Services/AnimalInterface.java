package Services;

import Model.Animal;

import java.util.List;

public interface AnimalInterface {
    public void addNewAnimal();
    public String getCommandsLastAnimal();
    public String getCommandsAnimalById();
    public void addCommandToAnimalById();
    public void showAllAnimalSortByBirthday();
    public void showAmountAllAddAnimals();
}
