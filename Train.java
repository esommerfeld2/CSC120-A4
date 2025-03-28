import java.util.ArrayList;

public class Train implements TrainRequirements{

    //Atributes
    public Engine engine;
    public ArrayList<Car> cars;
    private int nCars;

    /**
     * Constructor
     * @param fuelType
     * @param currentFuelLevel
     * @param fuelCapacity
     * @param nCars
     * @param passengerCapacity
     */
    public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, 
    int nCars, int passengerCapacity){
        this.nCars = nCars;
        engine = new Engine(fuelType, currentFuelLevel, fuelCapacity);
        cars = new ArrayList<>(this.nCars);
        for (int i = 0; i < this.nCars; i++) {
            Car car = new Car(passengerCapacity);
            cars.add(car);
        }
    }

    /**
     * Acessor gets the engine
     * @retun the engine
     */
    public Engine getEngine(){
        return this.engine;
    }
    /**
     * Acessor gets the car at the ith index
     * @return the car
     */
    public Car getCar(int i){
       return cars.get(i);
    }

    /**
     * Acessor gets max capacity of the train
     * @return the max capactiy
     */
    public int getMaxCapacity(){
        int totalCapacity = 0;
        for(Car car : cars) {
            int carCapacity = car.getCapacity();
            totalCapacity += carCapacity;
        }
        return totalCapacity;
    }

    /**
     * Method that adds train car
     * @param car0 the car being adding
     */

    public void addCar(Car car0){
        cars.add(car0);
    }

    /**
     * Method returns the total seats left on the train
     * @return total seats remaining
     */
    public int seatsRemaining(){
        int totalSeatsLeft = 0;
        for (Car car : cars) {
            int seatsLeft = car.seatsRemaining();
            totalSeatsLeft += seatsLeft;
        }
        return totalSeatsLeft;
    }
    
    /**
     * Method prints manifest for the whole train
     */
    public void printManifest(){
        for (Car car : cars) {
            if(car.getCapacity() == car.seatsRemaining()){
                continue;
            } else {
                car.printManifest();
            }
        }
    } 

    /**
     * Used to check code, runs all functions in the class
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.STEAM, 100, 100, 4, 2);
        System.out.println(myTrain);
        System.out.println(myTrain.getEngine());
        System.out.println(myTrain.getCar(3));
        System.out.println(myTrain.getMaxCapacity());
        Passenger jeff = new Passenger("Jeff");
        Passenger will = new Passenger("Will");
        will.boardCar(myTrain.getCar(3));
        jeff.boardCar(myTrain.getCar(3));
        System.out.println(myTrain.seatsRemaining());
        myTrain.printManifest();

    }
}
