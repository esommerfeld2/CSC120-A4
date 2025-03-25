import java.util.ArrayList;

public class Car implements CarRequirements {
    
    //Atributes
    private int maxCapacity;
    public ArrayList<Passenger> passengersOnboard;

    /**
     * Constructor
     * @param maxCapacity the max capacity the train can hold
     */
    public Car(int maxCapacity){
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
     * @param p the passenger
     * @return true if it worked
     */
    public Boolean addPassenger(Passenger p){
        int seatsAvailable = this.maxCapacity - passengersOnboard.size();
        for (int i = 0; i < passengersOnboard.size(); i++) {
            if(passengersOnboard.get(i).equals(p)){
                return false;
            }
        }
        if (seatsAvailable > 0){
            passengersOnboard.add(p);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Method to remove a passenger from the manifest
     * @param p the passenger
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
     * Used to check code, runs all functions in the class
     */
    public static void main(String[] args) {
        Car myCar = new Car( 2);
        System.out.println(myCar.getCapacity());
        Passenger jeff = new Passenger("Jeff");
        System.out.println(myCar.addPassenger(jeff));
        System.out.println(myCar.seatsRemaining());
        Passenger will = new Passenger("Will");
        System.out.println(myCar.addPassenger(will));
        System.out.println(myCar.addPassenger(jeff));
        myCar.printManifest();
        System.out.println(myCar.removePassenger(will));
        Passenger ella = new Passenger("Ella");
        System.out.println(myCar.removePassenger(ella));
        System.out.println(myCar.removePassenger(jeff));
        myCar.printManifest();

    }
}