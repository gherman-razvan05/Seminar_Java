package Vehicle_Management_ex;

public class Main {
    static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car("Audi", 250, "#01", 10000, false, 4);
        vehicles[1] = new Motorcycle("BMW", 200, "#02", 15000, true, true);
        vehicles[2] = new Truck("Volvo", 100, "#03", 80000, true,6000);
        for (Vehicle v : vehicles)
            v.move();

        Car c1 = new Car("Mercedes", 260, "#11", 40000, false,2);
        Car c2 = new Car("Mercedes", 260, "#11", 40000, false,2);

        if (c1.equals(c2))
            System.out.println("Aceeasi masina");
        else System.out.println("Alta masina");

        Car c3 = new Car("Opel", 200, "#21", 10000, false,4);

        try {
            c3.rent();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(c3.isRented());

        try {
            c3.returnVehicle(5000);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(c3.isRented());
        System.out.println("Masina " + c3.getId() + " are dupa inchiriere " + c3.getMileage() + " km");

        int nrZileInchiriere = 3;
        for (Vehicle v : vehicles) {
            if (v.needsService())
                System.out.println("Vehiculul " + v.getId() + " trebuie sa mearga la service!");
            else
                System.out.println("Vehiculul " + v.getId() + " nu are nevoie de revizie!");
            System.out.println("Pretul de inchiriere pentru " + nrZileInchiriere + " zile pentru vehiculul " + v.getId() + " este de " + v.rentalPrice(nrZileInchiriere) + " euro");
        }
    }
}
