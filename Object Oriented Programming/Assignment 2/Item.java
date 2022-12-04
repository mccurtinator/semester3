/*
 * Item class holds information about an individual item: its name, cost and ID
 * also contains getter methods to access this information
 * and a toString method to simplify printing this information
 */
public class Item
{
    // instance variables
    
    private String name;
    private double cost;
    private long itemId;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, double cost, long itemId)
    {
        this.name = name;
        this.cost = cost;
        this.itemId = itemId;
    }


    
    @Override
    public String toString() {
        
        String out = String.format("Item Id: %d\t %s \t Cost: %.2f", itemId, name, cost);        
        return out;
    }
    
    // getter methods
    
    public double getCost() {
        return cost;
    }
    
    public String getName() {
        return name;
    }
    
    public long getId() {
        return itemId;
    }
}
