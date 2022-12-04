import java.util.Objects;

public abstract class Animal {
    boolean hasSkin;
    boolean breathes;
    String colour;

    /**
     * Constructor for objects of class Animal
     */
    public Animal() {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
    }

    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public void move(int distance) {
        System.out.printf("I move %d metres \n", distance);
    }

    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour() {
        return colour;
    }

    /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */

    public boolean hasSkin() {
        return hasSkin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return hasSkin == animal.hasSkin && breathes == animal.breathes;
    }

}
