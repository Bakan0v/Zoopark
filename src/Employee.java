public abstract class Employee implements Staff {
    private String name;
    private int employeeId;
    private double salary;
    private String hireDate;

    public Employee(String name, int employeeId, double salary, String hireDate) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    // Геттеры и сеттеры с инкапсуляцией
    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя сотрудника не может быть пустым");
        }
        this.name = name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            throw new IllegalArgumentException("ID сотрудника должен быть положительным");
        }
        this.employeeId = employeeId;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной");
        }
        this.salary = salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(name + " чистит вольер: " + enclosure.getEnclosureName());
        System.out.println("Вольер очищен! Площадь: " + enclosure.getArea() + " м²");
    }

    public abstract String getPosition();

    @Override
    public String toString() {
        return getPosition() + " {имя='" + name + "', ID=" + employeeId +
                ", зарплата=" + salary + " руб., дата найма='" + hireDate + "'}";
    }
}