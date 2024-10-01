class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    void displayInfo() {
        System.out.println("\nThe vehicle is of brand: " + brand + " bought in the year " + year);
    }

    void start() {
        System.out.println("Vehicle is starting.........");
    }
}

class Car extends Vehicle {
    int maxSpeed;

    Car(String brand, int year, int maxSpeed) {
        super(brand, year);
        this.maxSpeed = maxSpeed;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Max speed of the car is " + maxSpeed + " km/h");
    }

    void start() {
        System.out.println("Car is starting.........");
    }
}

class ElectricCar extends Car {
    int batteryCapacity;

    ElectricCar(String brand, int year, int maxSpeed, int batteryCapacity) {
        super(brand, year, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery capacity of the electric car is " + maxSpeed + " km/h");
    }

    void start() {
        System.out.println("Electric Car is starting.........");
    }

    void charge() {
        System.out.println("Electric Car is charging.........");
    }
}

public class VehicleMain {
    public static void main(String args[]) {
        Vehicle v1 = new Vehicle("Generic", 2020);
        v1.displayInfo();
        v1.start();
        Car myCar = new Car("Audi", 2020, 240);
        myCar.displayInfo();
        myCar.start();
        ElectricCar myElectricCar = new ElectricCar("Tesla", 2023, 260, 100);
        myElectricCar.displayInfo();
        myElectricCar.start();
        myElectricCar.charge();
        ElectricCar myLucidCar = new ElectricCar("Lucid", 2024, 300, 120);
        myLucidCar.displayInfo();
        myLucidCar.start();
    }
}
