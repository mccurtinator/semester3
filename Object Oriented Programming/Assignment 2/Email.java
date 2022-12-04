/*
 * Email class generates the email to be sent to the customer
 * content of email depends on whether the payment is valid or not
 * i.e. the order details will only be sent if the payment is valid
*/

public class Email

{
    
    // instance variables
    
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String introduction;
    
    private Order order;
    private Payment payment;
    private Address billing;

    private long orderNo;

    
    private String successfulMessage;
    private String failureMessage;

    // Email constructor constructs the body of the text to be sent to the customer
    
    public Email(Customer customer, Order order, Address billing, Payment payment)
    {
        this.firstName = customer.getfirstName();
        this.lastName = customer.getlastName();
        this.emailAddress = customer.getemailAddress();
        this.payment = payment;
        
        this.introduction = String.format("mailto:%s \nDear %s,\n", emailAddress, firstName);

        this.successfulMessage = String.format("Order success! Order details:\n%s\nBill to:%s\n",order.getOrderDetails(), billing.getAddress());
        
        this.failureMessage = String.format("Payment information invalid. Order unsuccessful.\n");
        
        
    }
    
    /*
     * sendEmail method
     * greets the customer
     * sends email regarding a successful or unsuccessful order depending on payment validity
     */
    public void sendEmail()
    {
        System.out.println(introduction);
        
        if (payment.isValid()) {
            System.out.println(successfulMessage);
        }
        
        else {
            System.out.println(failureMessage);

        }
    }
}
