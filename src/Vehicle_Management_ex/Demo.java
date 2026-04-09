package Vehicle_Management_ex;

public class Demo {
    static void main(String[] args) {
        Garage garage= new Garage(10);
        garage.add(new Car("Audi", 250, "#01", 10000, false, 4));
        garage.add(new Motorcycle("BMW", 200, "#02", 15000, true, true));
        garage.add(new Truck("Volvo", 100, "#03", 80000, true,6000));
        garage.add(new Car("Toyota",230,"#04", 50000, false,2));
        garage.add(new Motorcycle("Honda", 300,"#05",1000,false,false));
        garage.add(new Truck("Scania", 100, "#06",40000,false,5000));

        garage.add(new Truck("Scania", 100, "#06",40000,false,5000));

        System.out.println("============");
        garage.rentById("#01");
        garage.rentById("#02");
        garage.rentById("#04");

        garage.returnById("#04",10000);
        garage.returnById("#06",6500);

        garage.printAvailable();
        garage.printNeedsService();

        garage.printRentalEstimate("#05",10);
        garage.rentById("#05");
        garage.printAvailable();
    }
}
