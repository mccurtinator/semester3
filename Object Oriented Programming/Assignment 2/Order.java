/*
 * Order class creates an order by transferring the items from the shopping cart
 * also generates the order details to be sent to the customer
 */

import java.util.ArrayList;
import java.util.Random;

public class Order
{
    // instance variables
    
    private double orderTotal;
    private ShoppingCart cart;
    private long orderNo;
    private ArrayList<Item> items = new ArrayList<Item>();

    private String details;
    private Address delivery;
    
    /**
     * Constructor for objects of class Order
     */
    public Order(ShoppingCart cart)
    {
        this.cart = cart;
        this.orderTotal = cart.calculateTotal();
        this.orderNo = makeOrderNo();
    }

    /*
     * makeOrderNo
     * randomly generates an order number between 1-10000
     */
    public long makeOrderNo() {
        Random random = new Random(); 
        return(random.nextInt(10000));
    }
    
    /*
     * makeOrderDetails method
     * generates the order details, listing the details of each item in the order 
    */
   
    public String makeOrderDetails() {
        details = String.format("Order Number: %d,\tOrder Total: %.2f \nItem Name\tCost\tID\n", orderNo, orderTotal);
        
        for (int i = 0; i < items.size(); i++) {
            details += String.format("%s\t%.2f\t%d\t\n", items.get(i).getName(), items.get(i).getCost(), items.get(i).getId());
            
        }
        return(details);
    }
    
    /*
     * addAddress method
     * adds the delivery address to the order details
     */
    
    public void addAddress(Address delivery) {
        this.delivery = delivery;
        details += String.format("\nDeliver to: %s\n", delivery.getAddress());
    }
    
    /*
     * transferItems method
     * transfers each item from the cart into the order
     * then removes the items from the cart and closes it
     */
    public void transferItems() {
        for (int i = 0; i < cart.countItems(); i++) {
            items.add(cart.getItem(i));
        }
        for (int i = 0; i < cart.countItems(); i++) {
            cart.removeItem(i);
        }
        cart.closeCart();
    }

    
    // getter method returns the generated order details
    
        public String getOrderDetails() {
        return(details);
    }
    
}
