package Vehicle_Management_ex;

public class Main {
    static void main(String[] args) {
        Vehicle[] vehicles=new Vehicle[3];
        vehicles[0]=new Car("Audi",250, "#01",10000,false);
        vehicles[1]=new Motorcycle("BMW", 200,"#02",15000,true);
        vehicles[2]=new Truck("Volvo", 100,"#03",80000,true );
        for(Vehicle v: vehicles)
            v.move();

        Car c1=new Car("Mercedes",260, "#11", 40000,false);
        Car c2=new Car("Mercedes",260,"#11", 40000,false);

        if(c1.equals(c2))
            System.out.println("Aceeasi masina");
        else System.out.println("Alta masina");

        Car c3=new Car("Opel",200,"#21",10000,false);

        try
        {
            c3.rent();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}
