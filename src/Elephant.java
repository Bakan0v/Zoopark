public class Elephant extends Vertebrate {
    private double tuskLength;

    public Elephant(String name, int age, double weight, double tuskLength) {
        super(name, age, weight);
        this.tuskLength = tuskLength;
    }

    public double getTuskLength() {
        return tuskLength;
    }

    public void setTuskLength(double tuskLength) {
        this.tuskLength = tuskLength;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубит: УУУУУУ!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест фрукты и овощи");
    }

    @Override
    public String getAnimalType() {
        return "Слон";
    }

    @Override
    public String toString() {
        return super.toString() + ", длина бивней: " + tuskLength + " м";
    }
}