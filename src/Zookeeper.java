public class Zookeeper extends Employee {
    private int assignedEnclosures;
    private String shift;
    private boolean hasAnimalTrainingCertification;

    public Zookeeper(String name, int employeeId, double salary, String hireDate,
                     int assignedEnclosures, String shift, boolean hasAnimalTrainingCertification) {
        super(name, employeeId, salary, hireDate);
        this.assignedEnclosures = assignedEnclosures;
        this.shift = shift;
        this.hasAnimalTrainingCertification = hasAnimalTrainingCertification;
    }

    // Инкапсуляция
    public int getAssignedEnclosures() {
        return assignedEnclosures;
    }

    public void setAssignedEnclosures(int assignedEnclosures) {
        if (assignedEnclosures < 0) {
            throw new IllegalArgumentException("Количество вольеров не может быть отрицательным");
        }
        this.assignedEnclosures = assignedEnclosures;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public boolean hasAnimalTrainingCertification() {
        return hasAnimalTrainingCertification;
    }

    public void setAnimalTrainingCertification(boolean hasAnimalTrainingCertification) {
        this.hasAnimalTrainingCertification = hasAnimalTrainingCertification;
    }

    @Override
    public void work() {
        System.out.println(getName() + " заботится о животных в " + assignedEnclosures + " вольерах");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println("\n--- Уборка вольера смотрителем " + getName() + " ---");
        super.cleanEnclosure(enclosure);
        System.out.println("Количество животных в вольере: " + enclosure.getAnimalCount());
        System.out.println("Уборка завершена успешно!");
    }

    // Полиморфизм: кормление всех животных в вольере
    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        System.out.println("\n--- Кормление животных в вольере '" + enclosure.getEnclosureName() + "' ---");
        System.out.println("Смотритель " + getName() + " начинает кормление...");

        for (Animal animal : enclosure.getAnimals()) {
            System.out.print("Кормление: ");
            // Полиморфный вызов - каждый тип животного будет есть по-своему
            animal.feed();
        }

        System.out.println("Все животные в вольере накормлены!");
    }

    public void performDailyRoutine(Enclosure enclosure) {
        System.out.println("\n=== Ежедневный уход за вольером '" + enclosure.getEnclosureName() + "' ===");
        cleanEnclosure(enclosure);
        feedAnimalsInEnclosure(enclosure);

        // Дополнительные действия с животными
        System.out.println("\n--- Взаимодействие с животными ---");
        for (Animal animal : enclosure.getAnimals()) {
            animal.makeSound();
            if (animal instanceof Vertebrate) {
                ((Vertebrate) animal).move();
            }
        }
    }

    @Override
    public String getPosition() {
        return "Смотритель";
    }

    @Override
    public String toString() {
        return super.toString() + ", закрепленные вольеры=" + assignedEnclosures +
                ", смена='" + shift + "', сертификация по тренировке=" +
                (hasAnimalTrainingCertification ? "есть" : "нет");
    }
}