
/**
 * 
 * @author Michael McC
 * @version 1
 */
public class Car
{
    // instance variables
    private String name;
    private double totalDistance;
    private double totalKm;
    private double fuelLevel;
    
    private Engine engine;
    
    
    /**
     * Constructor for objects of class Car
     */
    public Car(String name)
    {
        this.name = name;    
    }
    
    /**
     * addEngine method adds an engine to the car
     */
    public void addEngine(Engine engine) {
        this.engine = engine;
    }
    
    /**
     * addWheel method 
     * calls on the engine to add a wheel
     */
    
    public void addWheel(Wheel wheel) {
        this.engine.addWheel(wheel);
    }

    /**
     * setFuel method 
     * sets the fuel level then prints it
     */
    public void setFuel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
        System.out.printf("Fuel level: %d\n",fuelLevel);
        
    }
    
    /**
     * drive method 
     * prints the car name, runs the car then reports the distance travelled
     */
    
    public void drive() {
    
        System.out.printf("Car name: %s\n", name);
        
        // get distance by running the engine
        double tripDistance = engine.runEngine(fuelLevel);
    
        // empty the tank as all fuel has been used by engine
        setFuel(0);
        
        // report distance travelled
        System.out.printf("Distance travelled this trip: %.2f Km\n",tripDistance);
        
        totalDistance += tripDistance;

        System.out.printf("Total distance travelled: %.2f Km\n\n",totalDistance);
 
    }
    

    
    
}