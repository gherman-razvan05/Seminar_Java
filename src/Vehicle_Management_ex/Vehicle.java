package Vehicle_Management_ex;

import java.util.Objects;

public abstract class Vehicle {
    private String brand;
    private double speed;

    private String id;
    private int mileage;
    private boolean rented;

    public Vehicle(String brand, double speed, String id, int mileage, boolean rented) {
        this.brand = brand;
        this.speed = speed;
        this.id = id;
        this.mileage = mileage;
        this.rented = rented;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public abstract void move();

    public void rent() {
        if (this.rented)
            throw new IllegalStateException("Vehiculul " + this.id + " este deja inchiriat!");
        this.rented = true;
    }

    public void returnVehicle(int drivenKm) {
        if (!this.rented)
            throw new IllegalStateException("Vehiculul " + this.id + " nu a fost inchiriat!");

        if (drivenKm > 0) {
            this.mileage += drivenKm;
            this.rented = false;
        }
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);
}

class Car extends Vehicle{

    private int doors;

    public Car(String brand, double speed, String id, int mileage, boolean rented, int doors) {
        super(brand, speed, id, mileage, rented);
        this.doors=doors;
    }

    @Override
    public void move() {
        System.out.println(getBrand()+" merge cu viteza: "+ getSpeed()+ " Km/h");
    }

    @Override
    public boolean needsService() {
        return getMileage()>10000;
    }

    @Override
    public double rentalPrice(int days) {
        double price=50*days;
        if(doors>=4)
            price*=1.1;
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Car car)) return false;
        return getSpeed()==car.getSpeed() && Objects.equals(getBrand(),car.getBrand())&& Objects.equals(getId(),car.getId()) && getMileage()==car.getMileage() && isRented()==car.isRented();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getBrand(),getSpeed(),getId(),getMileage(),isRented());
    }
}

class Motorcycle extends Vehicle {

    private boolean hasSideCar;

    public Motorcycle(String brand, double speed, String id, int mileage, boolean rented, boolean hasSideCar) {
        super(brand, speed, id, mileage, rented);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " merge cu viteza: " + getSpeed() + " Km/h");
    }

    @Override
    public boolean needsService() {
        return getMileage() > 6000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = days * 30;
        if (hasSideCar)
            price += 15 * days;
        return price;
    }
}

class Truck extends Vehicle {

    private int loadCapacity;

    public Truck(String brand, double speed, String id, int mileage, boolean rented, int loadCapacity) {
        super(brand, speed, id, mileage, rented);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void move() {
        System.out.println(getBrand() + " merge cu viteza: " + getSpeed() + " Km/h");
    }

    @Override
    public boolean needsService() {
        return getMileage() > 15000;
    }

    @Override
    public double rentalPrice(int days) {
        return (80 + 0.02 * loadCapacity) * days;
    }

}