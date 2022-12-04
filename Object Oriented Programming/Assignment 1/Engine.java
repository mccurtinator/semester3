
/**
 *
 * @author Michael McC
 * @version 1
 */
public class Engine
{
    // instance variables
    private String name;
    private double tpl;
    private double totalNumTurns;
    
    private Wheel wheel;

    /**
     * Constructor for objects of class Engine
     */
    public Engine(String name, double tpl)
    {
        this.name = name;

        this.tpl = tpl;
    }

    /**
     * addWheel method adds a wheel to the engine
     */
    
    public void addWheel(Wheel wheel) {
        this.wheel = wheel;
    }

    /**
     * runEngine method
     * prints engine information
     * calculates amount of turns from given amount of fuel
     * adds to running total of turns performed
     * returns max distance travelled from given amount of fuel
     */
    
   public double runEngine(double fuelLevel) {
    
      // print engine information
      System.out.printf("Engine name: %s\n",name);
      System.out.printf("Engine turns per litre: %.2f\n",tpl);
    
      // calculate amount of turns per tank of fuel
      double numTurns = (fuelLevel * tpl);
      
      // add to running total then print
      totalNumTurns += numTurns;
      System.out.printf("Engine's total turn count: %.2f\n",totalNumTurns);
      
      // return the distance travelled
      
      double distance = (numTurns * wheel.turn());
      
      return distance;
 }
}
