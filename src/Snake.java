public class Snake extends Reptile {
    private double length;
    private boolean isVenomous;

    public Snake(String name, int age, double weight, double bodyTemperature,
                 double length, boolean isVenomous) {
        super(name, age, weight, bodyTemperature);
        this.length = length;
        this.isVenomous = isVenomous;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public boolean isVenomous() {
        return isVenomous;
    }

    public void setVenomous(boolean venomous) {
        isVenomous = venomous;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " шипит: Шшшшшш!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест грызунов");
    }

    @Override
    public String getAnimalType() {
        return isVenomous ? "Ядовитая змея" : "Неядовитая змея";
    }

    @Override
    public String toString() {
        return super.toString() + ", длина: " + length + " м, температура тела: " +
                getBodyTemperature() + "°C, ядовитая: " + isVenomous;
    }
}