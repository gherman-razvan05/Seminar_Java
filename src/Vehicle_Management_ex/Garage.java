package Vehicle_Management_ex;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public void add(Vehicle v) {
        if (size >= fleet.length) {
            System.out.println("Garajul este plin!");
            return;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Vehiculul " + v.getId() + " exista deja!");
            return;
        }
        fleet[size] = v;
        size++;
        System.out.println("Vehiculul " + v.getId() + " a fost adaugat cu succes!");
    }

    public Vehicle findById(String id) {
        for (int i = 0; i < size; i++)
            if (fleet[i].getId().equals(id))
                return fleet[i];
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.rent();
                System.out.println("Vehiculul " + id + " a fost inchiriat cu succes!");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.returnVehicle(drivenKm);
                System.out.println("Vehiculul " + id + " a fost returnat cu succes!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printAvailable() {
        System.out.println("VEHICULE DISPONIBILE");
        boolean existaVehicul = false;
        for (int i = 0; i < size; i++)
            if (!fleet[i].isRented()) {
                existaVehicul = true;
                System.out.println(fleet[i].getBrand() + " - " + fleet[i].getId());
            }
        if(!existaVehicul)
            System.out.println("Nu sunt vehicule disponibile!");
    }

    public void printNeedsService(){
        System.out.println("VEHICULE CARE AU NEVOIE DE REVIZIE");
        boolean existaVehicul=false;
        for(int i=0;i<size;i++)
            if(fleet[i].needsService()){
                existaVehicul=true;
                System.out.println(fleet[i].getBrand()+" - "+fleet[i].getId()+" | Km: "+fleet[i].getMileage());
            }
        if(!existaVehicul)
            System.out.println("Nu sunt vehicule care necesita revizie!");
    }

    public void printRentalEstimate(String id, int days){
        Vehicle v=findById(id);
        if(v!=null)
            System.out.println("Estimare pret vehicul "+id+" pentru "+days+" zile: "+v.rentalPrice(days)+" Euro");
        else
            System.out.println("Vehiculul nu a fost gasit!");
    }


}
