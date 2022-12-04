
public class Trout extends Fish
{

    String name; // the name of this Shark
    Boolean hasSpikes;
    Boolean swimsUpriver;

    /**
     * Constructor for objects of class Ostrich
     */
    public Trout(String name) {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        this.colour = "brown";
        edible = true;
        hasSpikes = true;
    }

    /**
     * toString method overrides the toString method
     * inherited from superclass Fish
     */

    @Override
    public String toString(){
        String strng = String.format("Trout; Name: %s; colour: %s\n", name, colour);
        return strng;
    }

    @Override // good programming practice to use @Override to denote overridden methods
    public void move(int distance){

        System.out.println(String.format("I swim %d metres upriver to lay eggs.\n", distance));
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Trout class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Trout object
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // check if object is this object
        if (!(o instanceof Trout trout)) return false; // check if object is a Trout
        if (!super.equals(o)) return false; // check if object is a Fish
        return hasSpikes.equals(trout.hasSpikes) &&  edible == trout.edible && getColour().equals(trout.getColour());
    }

}

