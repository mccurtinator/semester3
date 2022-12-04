/*
 * ShoppingCart class
 * items can be added and removed while the cart is open
 * cart contents and total cost can be displayed to the user
 */

import java.util.ArrayList;
import java.time.LocalDateTime;
    
public class ShoppingCart
{
    // instance variables 
    
    private long cartId;
    private Item item;
    private LocalDateTime time;
    private double totalCost = 0;
    private boolean closed = false; // cart is open when created
    
    private ArrayList<Item> items = new ArrayList<Item>();
    
    

    /**
     * Constructor for objects of class ShoppingCart
     */
    public ShoppingCart(long cartId)
    {
        this.cartId = cartId;
    }
    
    /*
     * addItem method
     * adds the specified item to the cart but only if the cart is open
     */
    
    public void addItem(String name, double cost, long itemId) {
        if (this.closed == false) {
            Item newItem = new Item(name, cost, itemId);
            items.add(newItem);
        }
        else {
            System.out.println("Sorry! Cart is closed!");
        }

    }
    
    /*
     * removeItem method
     * removes the specified item from the cart
     */
    
    public void removeItem(int index) {
        items.remove(index);
    }
    
    /*
     * displayCart method
     * prints out each item in the cart along with the total cost
     */
    
    public void displayCart() {
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(items.get(i).toString());
                }
                
                System.out.println(String.format("Total: %.2f\n", calculateTotal()));
    }
    
    /*
     * calculateTotal method
     * adds the cost of each item together to find the total cost of the order
     */
    
    
    public double calculateTotal() {
            totalCost = 0; // reset count
            
            for (int i = 0; i < items.size(); i++) { 
                this.totalCost += (items.get(i).getCost());
            }

            return totalCost;
    } 

    // closeCart method sets the cart to closed
    public void closeCart() {
        this.closed = true;
    }

    // getItem method returns the specified item
    
    public Item getItem(int index) {
        return(items.get(index));
    }
    
    // countItems method returns the amount of items
        public int countItems() {
        return(items.size());
    }

}
