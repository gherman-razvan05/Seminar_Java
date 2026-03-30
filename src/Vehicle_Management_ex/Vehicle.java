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
}

class Car extends Vehicle{

    public Car(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+" merge cu viteza: "+ getSpeed()+ " Km/h");
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

class Motorcycle extends Vehicle{

    public Motorcycle(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+" merge cu viteza: "+ getSpeed()+ " Km/h");
    }


}

class Truck extends Vehicle{

    public Truck(String brand, double speed, String id, int mileage, boolean rented) {
        super(brand, speed, id, mileage, rented);
    }

    @Override
    public void move() {
        System.out.println(getBrand()+" merge cu viteza: "+ getSpeed()+ " Km/h");
    }

}