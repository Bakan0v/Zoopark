public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ЗООПАРКОМ ===\n");

        // Демонстрация того, что абстрактные классы не могут быть инстанциированы
        System.out.println("1. ДЕМОНСТРАЦИЯ АБСТРАКТНЫХ КЛАССОВ:");
        try {
            System.out.println("Абстрактные классы (Vertebrate, Reptile, Employee) не могут быть созданы напрямую");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Создание конкретных животных
        System.out.println("\n2. СОЗДАНИЕ ЖИВОТНЫХ:");

        Lion lion = new Lion("Симба", 5, 190.0, "золотистый");
        Elephant elephant = new Elephant("Дамбо", 10, 4500.0, 1.2);
        Snake snake = new Snake("Каа", 3, 8.5, 28.5, 4.2, false);
        Snake venomousSnake = new Snake("Нага", 2, 5.1, 29.0, 2.8, true);

        System.out.println(lion);
        System.out.println(elephant);
        System.out.println(snake);
        System.out.println(venomousSnake);

        // Создание вольеров
        System.out.println("\n3. СОЗДАНИЕ ВОЛЬЕРОВ:");

        Enclosure savannaEnclosure = new Enclosure("Саванна", 500.0);
        Enclosure reptileEnclosure = new Enclosure("Террариум", 50.0);

        // Добавление животных в вольеры
        savannaEnclosure.addAnimal(lion);
        savannaEnclosure.addAnimal(elephant);
        reptileEnclosure.addAnimal(snake);
        reptileEnclosure.addAnimal(venomousSnake);

        // Демонстрация вольеров
        savannaEnclosure.displayAnimals();
        reptileEnclosure.displayAnimals();

        // Демонстрация полиморфизма
        System.out.println("\n4. ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА:");
        System.out.println("Один и тот же метод makeSound() работает по-разному для разных животных:");

        // Создаем массив животных разных типов
        Animal[] animals = {lion, elephant, snake, venomousSnake};

        for (Animal animal : animals) {
            // Полиморфизм: один метод, разное поведение
            animal.makeSound();
        }

        // СОЗДАНИЕ ПЕРСОНАЛА
        System.out.println("\n5. СОЗДАНИЕ ПЕРСОНАЛА ЗООПАРКА:");

        Veterinarian vet = new Veterinarian("Доктор Иванов", 101, 75000, "2020-05-15",
                "VET-RU-12345", "Экзотические животные", 8);

        Zookeeper keeper1 = new Zookeeper("Мария Петрова", 201, 45000, "2021-03-20",
                3, "дневная", true);

        Zookeeper keeper2 = new Zookeeper("Алексей Сидоров", 202, 42000, "2022-07-10",
                2, "вечерняя", false);

        System.out.println(vet);
        System.out.println(keeper1);
        System.out.println(keeper2);

        // ДЕМОНСТРАЦИЯ РАБОТЫ ПЕРСОНАЛА
        System.out.println("\n6. ДЕМОНСТРАЦИЯ РАБОТЫ ПЕРСОНАЛА:");

        // Работа ветеринара (полиморфизм)
        System.out.println("\n--- Работа ветеринара ---");
        vet.work();
        vet.examineAnimal(lion);  // Полиморфизм: один метод для разных животных
        vet.examineAnimal(snake); // Полиморфизм: работает с любым Animal

        // Полный медосмотр в вольере
        vet.performHealthCheck(savannaEnclosure);

        // Работа смотрителей
        System.out.println("\n--- Работа смотрителей ---");
        keeper1.work();
        keeper1.performDailyRoutine(savannaEnclosure);

        keeper2.work();
        keeper2.performDailyRoutine(reptileEnclosure);

        // Демонстрация инкапсуляции в персонале
        System.out.println("\n7. ДЕМОНСТРАЦИЯ ИНКАПСУЛЯЦИИ В ПЕРСОНАЛЕ:");

        // Попытка установить некорректные значения
        try {
            keeper1.setSalary(-1000); // Вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Защита инкапсуляции: " + e.getMessage());
        }

        try {
            vet.setLicenseNumber(""); // Вызовет исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Защита инкапсуляции: " + e.getMessage());
        }

        // Корректное использование
        keeper1.setSalary(48000);
        System.out.println("Новая зарплата " + keeper1.getName() + ": " + keeper1.getSalary() + " руб.");

        // ДЕМОНСТРАЦИЯ АБСТРАКЦИИ С ПЕРСОНАЛОМ
        System.out.println("\n8. ДЕМОНСТРАЦИЯ АБСТРАКЦИИ С ПЕРСОНАЛОМ:");

        // Работа с персоналом через интерфейс Staff
        Staff[] staffMembers = {vet, keeper1, keeper2};

        System.out.println("Все сотрудники выполняют свою работу:");
        for (Staff staff : staffMembers) {
            staff.work();
            staff.cleanEnclosure(savannaEnclosure); // Каждый чистит по-своему
            System.out.println("---");
        }

        // Полиморфное кормление животных смотрителем
        System.out.println("\n9. ПОЛИМОРФНОЕ КОРМЛЕНИЕ ЖИВОТНЫХ:");
        keeper1.feedAnimalsInEnclosure(savannaEnclosure);
        keeper2.feedAnimalsInEnclosure(reptileEnclosure);

        // Демонстрация полиморфизма в вольерах
        System.out.println("\n10. ДЕМОНСТРАЦИЯ РАБОТЫ ВОЛЬЕРОВ:");
        savannaEnclosure.makeAllAnimalsSound();
        reptileEnclosure.makeAllAnimalsSound();

        // Демонстрация специфических методов
        System.out.println("\n11. СПЕЦИФИЧЕСКИЕ МЕТОДЫ:");
        snake.baskInSun(); // Метод только для рептилий
        lion.sleep();      // Общий метод для всех позвоночных
        elephant.move();   // Общий метод для всех позвоночных

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}