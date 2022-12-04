/*
 * TransactionTest class runs two test shopping scenarios
 */
import java.text.SimpleDateFormat;

public class TransactionTest
{
    /*
     * Constructor for objects of class Customer
     */
    public TransactionTest()
    {
    }

    public static void main(String[] args) throws java.text.ParseException {
        
        // run both test scenarios

        test1();
        test2();
    }
    
        /* 
         * test1
         * Create Customer object 
         * Create Shopping Cart object for the Customer
         * Add 3 items with known cost to cart 
         * Finalise the cart and create an order
         * Add a delivery address for the order
         * Add a payment type
         * Validate the payment
         * If successful, email the customer with a success email and the cost of the purchased items
        */
    public static void test1() throws java.text.ParseException {
        


        System.out.println("\n--------New Test--------\n");

        Customer customer = new Customer("Vincent", "Everyman", "veveryman@email.com");
        ShoppingCart cart = new ShoppingCart(customer.makeCustomerId()); // make cart with randomly generated cart ID 
    
        customer.assignCart(cart);
    
        customer.addItem("Banana", 0.8, 69);
        customer.addItem("Apple", 0.5, 33);
        customer.addItem("Milk", 2.5, 21);
    
        customer.displayCart();
    
        Order order = new Order(cart);
        order.makeOrderNo(); // randomly generate order number
        
        order.transferItems(); // transfer all items from cart to order then clear the cart
        
        order.makeOrderDetails(); // generate order details for email
        
        Address delivery = new Address();
        delivery.setAddress("Elm Street","Springwood", "0000", "USA");
        
        order.addAddress(delivery);
               
        Address billing = new Address();
        // Vincent's billing address happens to be the same as his delivery address
        billing.setAddress("Elm Street","Springwood", "0000", "USA");

        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // sdf parse function is utilised to pass through card date as parameter

        Payment payment = new Payment(customer, "Visa",1919191919191919L, sdf.parse("2022-11-22"), billing, "Bank & Co");
        
        Email email = new Email(customer, order, billing, payment);
        
        email.sendEmail(); // generates email (text depends on payment validity), then prints it
    }
    
    public static void test2() throws java.text.ParseException {
        /*
         * The second scenario is a slight variation of the first:
         * The user adds three items
         * Requests a display of the shopping cart items and total
         * Removes one item
         * Confirms the cart and makes an order
         * The user submits a payment, however, the payment is not valid
         * The user is sent a regret email notifying them that the order was unsuccessful
         * 
         */
        
        System.out.println("\n--------New Test--------\n");

                
        Customer customer = new Customer("John", "Everyman", "jeveryman@email.com");
        ShoppingCart cart = new ShoppingCart(customer.makeCustomerId()); // make cart with randomly generated cart ID 
        
        customer.assignCart(cart);
    
        customer.addItem("Banana", 0.8, 69);
        customer.addItem("Apple", 0.5, 33);
        customer.addItem("Milk", 2.5, 21);
        
        customer.displayCart();
        
        customer.removeItem(2); // remove "Milk" item at index 2
    
        customer.displayCart();
        
        Order order = new Order(cart);
        order.makeOrderNo(); // randomly generate order number
        order.transferItems(); // transfer all items from cart to order then clear the cart
        
        order.makeOrderDetails(); // generate order details for email
        
        Address delivery = new Address();
        delivery.setAddress("Elm Street","Springwood", "0000", "USA");
        
        order.addAddress(delivery);
               
               
        Address billing = new Address();
        // John's billing address happens to be the same as his delivery address
        billing.setAddress("Elm Street","Springwood", "0000", "USA");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // sdf parse function is utilised to pass through card date as parameter

        Payment payment = new Payment(customer, "WasterCard",1818181818181818L, sdf.parse("2023-12-20"), billing, "Bank & Co");
        
        Email email = new Email(customer, order, billing, payment);
        
        email.sendEmail(); // generates email (text depends on payment validity), then prints it
    }
}
