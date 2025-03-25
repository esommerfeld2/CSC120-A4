public class Engine implements EngineRequirements {

    //Attributes
    private FuelType f;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Constructor
     * @param f the engine type
     * @param currentFuelLevel the current level of fuel
     * @param maxFuelLevel the max amount of fuel
     */
    public Engine(FuelType f, double currentFuelLevel, double maxFuelLevel){
        this.f = f;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }
    /**
     * Acessor gets the fuel type
     * @return the fuel type
     */
    public FuelType getFuelType(){
        return this.f;
    }
    /**
     * Acessor gets the max fuel
     * @return the max fuel
     */

    public double getMaxFuel(){
        return this.maxFuelLevel;
    }
    /**
     * Acessor the current fuel level
     * @return the current fuel level
     */

    public double getCurrentFuel(){
        return this.currentFuelLevel;
    }
    /**
     * Manipulator
     * Sets the current fuel level to the max fuel level
     */

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }
    /**
     * Runs the engine
     * @return true if the fuel level is greater than 0 and false if it isn't
     */

    public Boolean go(){
        this.currentFuelLevel = this.currentFuelLevel - 10;
        System.out.println("The current fuel level is at: " + this.currentFuelLevel);
        if(this.currentFuelLevel >= 10){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Formats the engine output into a legaible string
     */

    public String toString(){
        return("Engine has fuel type: " + this.f + " current fuel level: " + this.currentFuelLevel + " and max fuel level: " + this.maxFuelLevel);
    }

    /**
     * Used to check code, runs all functions in the class
     */

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0, 95);
        System.out.println(myEngine);
        System.out.println(myEngine.getFuelType());
        System.out.println(myEngine.getMaxFuel());
        System.out.println(myEngine.getCurrentFuel());
        myEngine.refuel();
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
    }
}

