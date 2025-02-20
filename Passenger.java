public class Passenger implements PassengerRequirements{
    
    //Atributes
    private String name;

    /**
     * Constructor
     * @param name
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Method for passengers to board a car
     */
    public void boardCar(Car c){
        Boolean full = c.addPassenger(this);
        if(full){
            System.out.println("Passenger added to car" + c);
        }
        else{
            System.out.println("Passenger was not added. No seats available.");
        }
    }
    
    /**
     * Method for passengers to get off a car
     */
    public void getOffCar(Car c){
        Boolean onCar = c.removePassenger(this);
        if(onCar){
            System.out.println("Passenger removed from car" + c);
        }
        else{
            System.out.println("This passenger is not onboard.");
        }
    }

    /**
     * Used to format passenger return to be their name
     */
    public String toString(){
        return(this.name);
    }

    /**
     * Used to check code, runs all functions in the class
     */
    public static void main(String[] args) {
        Car CarC = new Car(" C", 2);
        Passenger Jeff = new Passenger("Jeff");
        Passenger Will = new Passenger("Will");
        Will.boardCar(CarC);
        Jeff.boardCar(CarC);
        Will.getOffCar(CarC);
    }
}
