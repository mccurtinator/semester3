
public abstract class Bird extends Animal
{
    //instance variables (fields)
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;

    /**
     * Constructor for objects of class Bird
     */
    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black"; //overrides the value of colour inherited from Animal
        hasFeathers = true; //all the subclasses of Fish inherit this property and value
        hasWings = true; //all the subclasses of Fish inherit this property and value
        flies = true; //all the subclasses of Fish inherit this property and value
    }

    /**
     * move method overrides the move method
     * inherited from superclass Animal
     */

    @Override
    public void move(int distance){

        // not all birds fly so change movement message based on this

        if (flies = true) {
            System.out.printf("I fly %d metres \n", distance);
        }
        else {
            System.out.printf("I run %d metres \n", distance);
        }

    }

    /**
     * toString method overrides the toString method
     * inherited from superclass Animal
     */
    @Override
    public String toString(){

        // say whether the bird can fly or not

        String condition;

        if (this.flies){
            condition = "can";
        }

        else {
            condition = "cannot";
        }
        String strng = String.format("I am a bird. I %s fly.\n", condition);
        return strng;
    }


    /**
     * equals method overrides the equals method
     * inherited from superclass Animal
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;  // check if object is this object
        if (!(o instanceof Bird bird)) return false; // check if object is a Bird
        if (!super.equals(o)) return false; // check if object is an Animal
        return hasFeathers == bird.hasFeathers && hasWings == bird.hasWings && flies == bird.flies;
    }

    /**
     * sing method
     * All subclasses inherit this method
     */

    public void sing(){
        System.out.println("tra la la");
    }
    
    /**
     * 'getter' method for the hasWings field
     *  All subclasses inherit this method
     */
    public boolean hasWings(){
        return hasWings;
    }
    
    /**
     * 'getter' method for the hasFeathers field
     *  All subclasses inherit this method
     */
    public boolean hasFeathers(){
        return hasFeathers;
    }
}
