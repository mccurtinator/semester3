/*
 * Address class holds information about the customer's address
 * contains methods to set and get the address
 */

public class Address
{
    // instance variables
    
    private String street;
    private String city;
    private String zip;
    private String country;
    

    /**
     * Constructor for objects of class Address
     */
    public Address()
    {
    }

    // getter and setter methods 
    
    public void setAddress(String street, String city, String zip, String country) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.country = country;
    }
    
    public String getAddress() {
        return String.format("%s,\t%s,\t%s\t%s\n", street, city, zip, country);
    }
    
}
