package Services.ModelService;

import Model.Animal;

import java.util.Comparator;

public class AnimalComparatorByBirthday<T extends Animal> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if(o1.getBirthday() == null || o2.getBirthday() == null)
            return 0;
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
