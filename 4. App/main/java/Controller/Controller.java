package Controller;

import Services.AnimalService;
import View.UserView;

public class Controller {
    AnimalService animalService = new AnimalService();
    UserView userView = new UserView();

    public void start(){
        userView.set("""
                1 - Добавление нового животного
                2 - Список команд животного по id
                3 - Обучение новым командам по id
                4 - Вывести список животных по дате рождения
                5 - Вывести в консоль общее количество созданных животных любого типа
                6 - Вывести всех животных в консоль
                7 - (! Для проверки добавить несколько животных)
                0 - выход
                """);
        int answer = userView.get();
        switch (answer){
            case 1 -> {
                animalService.addNewAnimal();
                start();
            }
            case 2 -> {
                animalService.getCommandsAnimalById();
                start();
            }
            case 3 -> {
                animalService.addCommandToAnimalById();
                start();
            }
            case 4 -> {
                animalService.showAllAnimalSortByBirthday();
                start();
            }
            case 5 -> {
                animalService.showAmountAllAddAnimals();
                start();
            }
            case 6 -> {
                animalService.showAllAnimals();
                start();
            }
            case 7 -> {
                animalService.addFewAnimals();
                start();
            }
            case 0 -> {
                break;
            }
            default -> start();
        }





    }










}
