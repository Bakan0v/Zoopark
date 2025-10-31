public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ЗООПАРКОМ ===\n");


        System.out.println("1. ДЕМОНСТРАЦИЯ АБСТРАКТНЫХ КЛАССОВ:");
        try {

            System.out.println("Абстрактные классы (Vertebrate, Reptile) не могут быть созданы напрямую");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        System.out.println("\n2. СОЗДАНИЕ ЖИВОТНЫХ:");

        Lion lion = new Lion("Симба", 5, 190.0, "золотистый");
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 1.2);
        Snake snake = new Snake("Каа", 3, 8.5, 28.5, 4.2, false);
        Snake venomousSnake = new Snake("Нага", 2, 5.1, 29.0, 2.8, true);

        System.out.println(lion);
        System.out.println(elephant);
        System.out.println(snake);
        System.out.println(venomousSnake);

        System.out.println("\n3. СОЗДАНИЕ ВОЛЬЕРОВ:");

        Enclosure savannaEnclosure = new Enclosure("Саванна", 500.0);
        Enclosure reptileEnclosure = new Enclosure("Террариум", 50.0);


        savannaEnclosure.addAnimal(lion);
        savannaEnclosure.addAnimal(elephant);
        reptileEnclosure.addAnimal(snake);
        reptileEnclosure.addAnimal(venomousSnake);


        savannaEnclosure.displayAnimals();
        reptileEnclosure.displayAnimals();


        System.out.println("\n4. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        System.out.println("Один и тот же метод makeSound() работает по-разному для разных животных:");


        Animal[] animals = {lion, elephant, snake, venomousSnake};

        for (Animal animal : animals) {

            animal.makeSound();
        }


        System.out.println("\n5. ДЕМОНСТРАЦИЯ РАБОТЫ ВОЛЬЕРОВ:");
        savannaEnclosure.makeAllAnimalsSound();
        reptileEnclosure.makeAllAnimalsSound();


        savannaEnclosure.feedAllAnimals();
        reptileEnclosure.feedAllAnimals();


        System.out.println("\n6. ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ:");


        try {
            lion.setAge(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Защита инкапсуляции: " + e.getMessage());
        }

        try {
            lion.setWeight(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Защита инкапсуляции: " + e.getMessage());
        }


        System.out.println("\n7. УПРАВЛЕНИЕ ВОЛЬЕРАМИ:");
        System.out.println("Количество животных в вольере 'Саванна': " + savannaEnclosure.getAnimalCount());


        savannaEnclosure.removeAnimalByName("Дамбо");
        savannaEnclosure.displayAnimals();


        System.out.println("\n8. СПЕЦИФИЧЕСКИЕ МЕТОДЫ:");
        snake.baskInSun();
        lion.sleep();
        elephant.move();

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}