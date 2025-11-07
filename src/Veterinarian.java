public class Veterinarian extends Employee {
    private String licenseNumber;
    private String specialization;
    private int yearsOfExperience;

    public Veterinarian(String name, int employeeId, double salary, String hireDate,
                        String licenseNumber, String specialization, int yearsOfExperience) {
        super(name, employeeId, salary, hireDate);
        this.licenseNumber = licenseNumber;
        this.specialization = specialization;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Инкапсуляция: приватные поля с контролируемым доступом
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер лицензии не может быть пустым");
        }
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("Опыт работы не может быть отрицательным");
        }
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public void work() {
        System.out.println(getName() + " проводит осмотр животных");
    }

    // Полиморфизм: метод работает с любым Animal
    public void examineAnimal(Animal animal) {
        System.out.println("\n--- Осмотр животного ветеринаром " + getName() + " ---");
        System.out.println("Ветеринар осматривает: " + animal);

        // Взаимодействие с животным через полиморфные методы
        animal.makeSound();

        // Проверка здоровья
        if (animal instanceof Vertebrate) {
            Vertebrate vertebrate = (Vertebrate) animal;
            System.out.println("Проверка состояния:");
            System.out.println("- Имя: " + vertebrate.getName());
            System.out.println("- Возраст: " + vertebrate.getAge() + " лет");
            System.out.println("- Вес: " + vertebrate.getWeight() + " кг");

            // Специфические проверки для разных типов животных
            if (animal instanceof Lion) {
                Lion lion = (Lion) animal;
                System.out.println("- Цвет гривы: " + lion.getManeColor());
                System.out.println("- Состояние: Лев здоров и полон энергии");
            } else if (animal instanceof Elephant) {
                Elephant elephant = (Elephant) animal;
                System.out.println("- Длина бивней: " + elephant.getTuskLength() + " м");
                System.out.println("- Состояние: Слон в хорошей форме");
            } else if (animal instanceof Snake) {
                Snake snake = (Snake) animal;
                System.out.println("- Длина: " + snake.getLength() + " м");
                System.out.println("- Температура тела: " + snake.getBodyTemperature() + "°C");
                System.out.println("- Ядовитая: " + (snake.isVenomous() ? "Требуется особая осторожность" : "Безопасна"));
            }
        }

        System.out.println("Осмотр завершен успешно!");
    }

    public void performHealthCheck(Enclosure enclosure) {
        System.out.println("\n=== Медосмотр в вольере '" + enclosure.getEnclosureName() + "' ===");
        for (Animal animal : enclosure.getAnimals()) {
            examineAnimal(animal);
        }
    }

    @Override
    public String getPosition() {
        return "Ветеринар";
    }

    @Override
    public String toString() {
        return super.toString() + ", лицензия='" + licenseNumber +
                "', специализация='" + specialization +
                "', опыт=" + yearsOfExperience + " лет";
    }
}