import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    // Инкапсуляция: приватное поле с контролируемым доступом
    private List<Animal> animals;
    private String enclosureName;
    private double area;

    public Enclosure(String enclosureName, double area) {
        this.enclosureName = enclosureName;
        this.area = area;
        this.animals = new ArrayList<>();
    }

    // Контролируемые методы для работы со списком животных
    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("Животное не может быть null");
        }
        animals.add(animal);
        System.out.println(animal.getClass().getSimpleName() + " " +
                ((Vertebrate) animal).getName() + " добавлен в вольер " + enclosureName);
    }

    public void removeAnimal(Animal animal) {
        if (animals.remove(animal)) {
            System.out.println(animal.getClass().getSimpleName() + " " +
                    ((Vertebrate) animal).getName() + " удален из вольера " + enclosureName);
        } else {
            System.out.println("Животное не найдено в вольере");
        }
    }

    public void removeAnimalByName(String name) {
        Animal toRemove = null;
        for (Animal animal : animals) {
            if (((Vertebrate) animal).getName().equals(name)) {
                toRemove = animal;
                break;
            }
        }

        if (toRemove != null) {
            removeAnimal(toRemove);
        } else {
            System.out.println("Животное с именем '" + name + "' не найдено в вольере");
        }
    }

    // Геттеры (без прямого доступа к изменению списка)
    public List<Animal> getAnimals() {
        return new ArrayList<>(animals); // Возвращаем копию для защиты инкапсуляции
    }

    public String getEnclosureName() {
        return enclosureName;
    }

    public double getArea() {
        return area;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public void displayAnimals() {
        System.out.println("\n=== Вольер '" + enclosureName + "' (" + area + " м²) ===");
        if (animals.isEmpty()) {
            System.out.println("Вольер пуст");
        } else {
            for (Animal animal : animals) {
                System.out.println("- " + animal);
            }
        }
    }

    // Полиморфизм: общий метод для всех животных
    public void makeAllAnimalsSound() {
        System.out.println("\n--- Звуки из вольера '" + enclosureName + "' ---");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void feedAllAnimals() {
        System.out.println("\n--- Кормление в вольере '" + enclosureName + "' ---");
        for (Animal animal : animals) {
            animal.feed();
        }
    }
}