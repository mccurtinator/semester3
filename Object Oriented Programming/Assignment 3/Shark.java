import java.util.Objects;

public class Shark extends Fish
{

    String name; // the name of this Shark
    Boolean dangerous;

    /**
     * Constructor for objects of class Ostrich
     */
    public Shark(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        dangerous = true;
        colour = "grey";
    }

    /**
     * bite method overrides the bite method
     * inherited from superclass Fish
     */

    @Override
    public void bite(){
        System.out.println("Shark bite! -90 HP");
    }

    /**
     * toString method overrides the toString method
     * inherited from superclass Fish
     */
    @Override
    public String toString(){
        String strng = String.format("Shark; Name: %s; colour: %s\n", name, colour);
        return strng;
    }


    /**
     * equals method defines how equality is defined between
     * the instances of the Shark class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Shark object
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check if object is this object
        if (!(o instanceof Shark shark)) return false; // check if object is a Shark
        if (!super.equals(o)) return false; // check if object is a Fish
        return dangerous.equals(shark.dangerous) &&  getColour().equals(shark.getColour());
    }

}

