/*
 * Customer method holds information about the customer
 * also interfaces with the shopping cart to allow the customer to add/remove items and view the cart
 */

import java.util.Random;   

public class Customer
{
    // instance variables 
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private final long customerId;


    private ShoppingCart ShoppingCart;
    
    /**
     * Constructor for objects of class Customer
     */
    public Customer(String firstName, String lastName, String emailAddress)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.customerId = makeCustomerId();

    }
    
    /*
     * makeCustomerId method
     * randomly generates a customer ID from 1-10000
     */
    public long makeCustomerId() {
        Random random = new Random(); 
        return(random.nextInt(10000));
    }
    
    // shoppingCart interfacing
    
    public void assignCart(ShoppingCart cart) {
        this.ShoppingCart = cart;
    }
    
    public void addItem(String name, double cost, long itemId) {
        this.ShoppingCart.addItem(name, cost, itemId);
    }
    
    public void removeItem(int index) {
        this.ShoppingCart.removeItem(index);
    }
    
    public void displayCart() {
        this.ShoppingCart.displayCart();
    }
    
    
    // getter methods
    public String getfirstName() {
        return(firstName);
    }
    
    public String getlastName() {
        return(lastName);
    }
    
    public String getemailAddress() {
        return(emailAddress);
    }
    
    public long getcustomerId() {
        return(customerId);
    }
}
