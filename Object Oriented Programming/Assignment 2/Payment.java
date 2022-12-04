/*
 * Payment class holds information about the customer's payment
 * contains the isValid method to validate the payment
 */

import java.util.Date;


public class Payment

{
    // instance variables
    
    private Customer customer;
    private String type;
    private String cardType;
    private long CCNum;
    private Date date;
    private Address address;
    private String bankName;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(Customer customer, String cardType, long CCNum, Date date, Address address, String bankName)
    {
        this.customer = customer;
        this.cardType = cardType;
        this.CCNum = CCNum;
        this.date = date;
        this.address = address;
        this.bankName = bankName;
    }

    /*
     * isValid method
     * checks whether the provided card type matches the valid types MasterCard or Visa
     */
    public boolean isValid() {
        if (this.cardType == "MasterCard" || this.cardType == "Visa") {
            return true;    
        }
        else {
            return false;
        }
    }
}
