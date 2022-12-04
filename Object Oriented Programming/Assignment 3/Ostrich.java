
public class Ostrich extends Bird
{

    String name; // the name of this Ostrich
    String legs; // leg information

    String height;

    /**
     * Constructor for objects of class Ostrich
     */
    public Ostrich(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "pink"; // this overrides the value inherited from Bird
        flies = false;
        legs = "thin and long";
        height = "tall";
    }

    /**
     * toString method overrides the toString method
     * inherited from superclass Bird
     */

    @Override
    public String toString(){
        String strng;

        strng = String.format("\nOstrich; Name: %s; colour: %s\n", name, colour);
        strng += super.toString();
        return strng;
    }

    /**
     * equals method defines how equality is defined between
     * the instances of the Ostrich class
     * param Object
     * return true or false depending on whether the input object is
     * equal to this Ostrich object
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check if object is this object
        if (!(o instanceof Ostrich ostrich)) return false; // check if object is an Ostrich
        if (!super.equals(o)) return false; // check if object is a Bird
        return legs.equals(ostrich.legs) && height.equals(ostrich.height);
    }

}
