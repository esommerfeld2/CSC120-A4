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
     * @param c the car
     */
    public void boardCar(Car c){
        Boolean full = c.addPassenger(this);
        if(full){
            System.out.println("Passenger added to car" + c);
        } else {
            System.out.println("Passenger was not added. No seats available.");
        }
    }
    
    /**
     * Method for passengers to get off a car
     * @param c the car
     */
    public void getOffCar(Car c){
        Boolean onCar = c.removePassenger(this);
        if(onCar){
            System.out.println("Passenger removed from car" + c);
        } else {
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
        Car carC = new Car( 2);
        Passenger jeff = new Passenger("Jeff");
        Passenger will = new Passenger("Will");
        will.boardCar(carC);
        jeff.boardCar(carC);
        will.getOffCar(carC);
    }
}
