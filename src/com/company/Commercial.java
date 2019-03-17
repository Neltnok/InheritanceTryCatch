package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author Ken Neltnor
 * @version 1.0
 *
 */
public class Commercial extends  Customer  {

    private String propertyName = "";
    private static double COMMERCIALRATE = 5.00f;
    private boolean multiProperty = false;

    // create an object of type Scanner to manage user input
    static Scanner scanner = new Scanner(System.in);

    // I am using a constructor with no arguments as the attributes are delegated to the
    // super class for customer data and property name and multiProperty status
    // is defined in the method createResidentialCustomer
    // This constructor instantiates the residential object, calls a method to create the
    // customer object and prints the billing statement

    /**
     * @author Ken Neltnor
     * @version 1.0
     */
    public Commercial(){
        this.createCommercialCustomer();
        this.printCommercialCustomerBilling();
    }


    /**
     * Sets up the commercial customer attributes for this class
     * @author Ken Neltnor
     * @version 1.0
     */
    public void createCommercialCustomer(){

        // create the customer data by calling the Customer super class
        super.createCustomer();

        // prompt the user to define the property name
        System.out.print("Enter the property name: ");
        this.setPropertyName(scanner.nextLine());

        // add the flag for a multiProperty customer
        System.out.print("Enter a 1 if this is a multi-property customer or 0 if single property: ");
        if(scanner.nextInt() == 1)
            this.setMultiProperty(true);
        else
            this.setMultiProperty(false);
    }


    /**
     * Print out the Commercial Customer Billing statement
     * Calls the super class printCustomer method, calculates and displays a quote
     */
    public void printCommercialCustomerBilling(){

        // variable to hold the multiproperty discount
        double discount = 0.0f;

        // initialize numberFormat
        NumberFormat nf = NumberFormat.getNumberInstance();
        // set format to include commas every 3 digits
        nf.setGroupingUsed(true);
        // set format to limit to two places past the decimal
        nf.setMaximumFractionDigits(2);
        // set format to extend fractional digits to always be two places past decimal
        nf.setMinimumFractionDigits(2);

        System.out.println();
        System.out.println();
        System.out.println("Customer Quote Statement");
        // print out the customers name, address, phone and square footage
        super.printCustomer();


        // print out the Property Name
        System.out.println("Commercial Property Name: " + this.getPropertyName());

        // use the number formatter to print the subtotal
        System.out.println("Subtotal : $" +
                nf.format(this.getSquareFootage()/1000 * this.getCommercialRate()));

        // if the customer is multiProperty apply the discount
        if(this.isMultiProperty()) {
            System.out.println("Apply Multi-Property discount");
            discount = this.getSquareFootage()/1000 * this.getCommercialRate() * 0.1f;
        }
        // print out the discount amount and quote totals
        System.out.println("Discount Amount: $" + nf.format(discount));
        System.out.println("Grand Total is: $" +
                nf.format(this.getSquareFootage()/1000 * this.getCommercialRate() - discount));
    }




    /**
     * Accessor method for the multiProperty attribute
     * @return the multiProperty attribute as a boolean
     */
    public boolean isMultiProperty() {
        return multiProperty;
    }

    /**
     * Modifier method for the multiProperty attribute
     * @param multiProperty the multiProperty flag as a boolean
     */
    public void setMultiProperty(boolean multiProperty) {
        this.multiProperty = multiProperty;
    }

    /**
     * Modifier method for the propertyName attribute
     * @param arg the propertyName attribute as a string
     */
    public void setPropertyName(String arg){
        this.propertyName = arg;
    }

    /**
     * Accessor method for the propertyName attribute
     * @return The propertyName attribute as a string
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Accessor method for the COMMERCIALRATE attribute
     * @return the COMMERCIALRATE attribute as a double
     */
    public static double getCommercialRate() {
        return COMMERCIALRATE;
    }
}
