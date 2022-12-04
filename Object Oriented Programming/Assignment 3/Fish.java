import java.util.Objects;

public abstract class Fish extends Animal
{
    //instance variables (fields)
    boolean hasFins;
    boolean hasGills;
    boolean swims;

    boolean dangerous;
    boolean edible;

    /**
     * Constructor for objects of class Fish
     */
    public Fish()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "blue"; //sets the value of colour inherited from Animal
        hasFins = true; //all the subclasses of Fish inherit this property and value
        hasGills = true; //all the subclasses of Fish inherit this property and value
        swims = true; //all the subclasses of Fish inherit this property and value
        edible = false;
        dangerous = false;
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance){
            System.out.printf("I swim %d metres \n", distance);
    }

    /**
     * bite method that all fish have
     */
    public void bite(){

        // fish will only cause harm with its bite if it is dangerous

        if (dangerous) {
            System.out.println("nomnomnom");
        }

        else {
            System.out.println("slurp slurp slurp");

        }
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Fish class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Fish object
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check if object is this object
        if (!(o instanceof Fish fish)) return false; // check if object is a Fish
        if (!super.equals(o)) return false; // check if object is an Animal
        return hasFins == fish.hasFins && hasGills == fish.hasGills && swims == fish.swims;
    }

    /**
     * 'getter' method for the hasGills field
     */
    public boolean hasGills(){
        return hasGills;
    }

    /**
     * 'getter' method for the hasFins field
     */
    public boolean hasFins(){
        return hasFins;
    }
}
