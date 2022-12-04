
/**
 *
 * @author Michael McC
 * @version 1
 */
public class Wheel
{
    // instance variables
    private double radius;
    private String name;
    private double circumference;
    
    
    /**
     * Constructor for objects of class Wheel
     */
    
    public Wheel(String name, double radius)
    {
        this.name = name;
        this.radius = radius;
    }

    
    /** turn method 
     * essentially wheel's main method
     * prints wheel information
     * calculates wheel circumference, prints and returns it
     */

    public double turn() {
        
        // print wheel information
        System.out.printf("Wheel name: %s\n",name);
        System.out.printf("Wheel radius: %.2f m\n",radius);
        
        // calculate wheel circumference, print and return
        double circumference = 2 * Math.PI * radius;
        System.out.printf("Wheel circumference (distance per turn): %.2f m \n",circumference);
        return circumference;

    }

}
