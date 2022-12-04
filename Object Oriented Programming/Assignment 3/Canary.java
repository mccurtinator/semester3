import java.util.Objects;

public class Canary extends Bird
{
    
    String name; // the name of this Canary

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */

    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
        System.out.println("tweet tweet tweet");
    }

    /**
     * toString method overrides the toString method
     * inherited from superclass Bird
     */

    @Override
    public String toString(){
        String strng;
        strng = String.format("\nCanary; Name: %s; colour: %s\n", name, colour);
        strng += super.toString();
        return strng;
    }

    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check if object is this object
        if (!(o instanceof Canary canary)) return false; // check if object is a Canary
        if (!super.equals(o)) return false; // check if object is a Bird
        return Objects.equals(getColour(), canary.getColour());
    }

}
