public abstract class Reptile extends Vertebrate {
    private double bodyTemperature;

    public Reptile(String name, int age, double weight, double bodyTemperature) {
        super(name, age, weight);
        this.bodyTemperature = bodyTemperature;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    @Override
    public void move() {
        System.out.println(getName() + " ползает");
    }

    public void baskInSun() {
        System.out.println(getName() + " греется на солнце");
    }
}