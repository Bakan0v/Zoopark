public class Lion extends Vertebrate {
    private String maneColor;

    public Lion(String name, int age, double weight, String maneColor) {
        super(name, age, weight);
        this.maneColor = maneColor;
    }

    public String getManeColor() {
        return maneColor;
    }

    public void setManeColor(String maneColor) {
        this.maneColor = maneColor;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " рычит: РРРРРР!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест мясо");
    }

    @Override
    public String getAnimalType() {
        return "Лев";
    }

    @Override
    public String toString() {
        return super.toString() + ", цвет гривы: " + maneColor;
    }
}