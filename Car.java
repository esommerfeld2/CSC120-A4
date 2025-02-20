import java.util.ArrayList;

public class Car implements CarRequirements {
    
    //Atributes
    private String name;
    private int maxCapacity;
    public ArrayList<Passenger> passengersOnboard;

    /**
     * Constructor
     * @param maxCapacity the max capacity the train can hold
     */
    public Car(String name, int maxCapacity){
        this.name = name;
        this.maxCapacity = maxCapacity;
        passengersOnboard = new ArrayList<>();
    }

    /**
     * Acessor gets the capacity
     * @return the capacity
     */
    public int getCapacity(){
        return this.maxCapacity;
    }
    /**
     * Acessor gets the seats remaining
     * @return the seats remaining
     */
    public int seatsRemaining(){
        int seatsAvailable = this.maxCapacity - passengersOnboard.size();
        return seatsAvailable;
    }
    /**
     * Method that adds a passenger to the manifest
     * @return true if it worked
     */
    public Boolean addPassenger(Passenger p){
        int seatsAvailable = this.maxCapacity - passengersOnboard.size();
        if (seatsAvailable > 0){
            passengersOnboard.add(p);
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Method to remove a passenger from the manifest
     * @return true if it worked
     */
    public Boolean removePassenger(Passenger p){
        for (int i = 0; i < passengersOnboard.size(); i++) {
            if (passengersOnboard.get(i).equals(p)){
                passengersOnboard.remove(i);
                return true;
            } }
        return false;
    } 

    /**
     * Method to print the manifest of passengers
     */

    public void printManifest(){
        for(Passenger p : passengersOnboard){
            System.out.println(p);
          }
        if(passengersOnboard.size() == 0){
            System.out.println("This car is EMPTY.");
        }
    }

    /**
     * Used to format car return to be the name
     */
    public String toString(){
        return(this.name);
    }

    /**
     * Used to check code, runs all functions in the class
     */
    public static void main(String[] args) {
        Car myCar = new Car(" my", 2);
        System.out.println(myCar.getCapacity());
        Passenger Jeff = new Passenger("Jeff");
        System.out.println(myCar.addPassenger(Jeff));
        System.out.println(myCar.seatsRemaining());
        Passenger Will = new Passenger("Will");
        System.out.println(myCar.addPassenger(Will));
        System.out.println(myCar.addPassenger(Jeff));
        myCar.printManifest();
        System.out.println(myCar.removePassenger(Will));
        Passenger Ella = new Passenger("Ella");
        System.out.println(myCar.removePassenger(Ella));
        System.out.println(myCar.removePassenger(Jeff));
        myCar.printManifest();

    }
}