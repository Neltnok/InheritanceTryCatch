package com.company;

// import for the NumberFormat utility
import java.text.NumberFormat;
// import for the Scanner class
import java.util.Scanner;

/**
 * @author Ken Neltnor
 * @version 1.0
 * Contains the attributes and methods for a residential customer
 */
public class Residential extends Customer {

    // the residential billing rate for the customer
    private static double RESIDENTIALRATE = 6.00f;
    // flag to hold the customers senior discount eligibility
    private boolean senior = false;

    // create an object of type Scanner to manage user input
    static Scanner scanner = new Scanner(System.in);

    /**
     *  I am using a constructor with no arguments as the attributes are delegated to the
     *  super class for customer data and senior status is defined in the method
     *  createResidentialCustomer
     *  This constructor instantiates the residential object, calls a method to create the
     *  customer object and prints the billing statement
     */

    public Residential(){
        this.createResidentialCustomer();
        this.printResidentialCustomerBilling();
    }


    /**
     * This method used to create a residential customer
     * calls the super class createCustomer method
     */
    public void createResidentialCustomer(){

        // create the customer data by calling the super class
        super.createCustomer();

        // add the flag for a senior residential customer
        System.out.print("Enter a 1 if this is a senior customer or 0 if non senior: ");
        if(scanner.nextInt() == 1)
            this.setSenior(true);
        else
            this.setSenior(false);

    }

    /**
     * @author Ken Neltnor
     * @version 1.0
     * This method generates the customer billing statement for residential customers
     */
    public void printResidentialCustomerBilling(){


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
        // use the number formatter to print the subtotal
        System.out.println("Subtotal : $" +
                nf.format(this.getSquareFootage()/1000 * this.getResidentialRate()));

        // if the customer is senior apply the discount
        if(this.isSenior()) {
            System.out.println("Apply senior discount");
            discount = this.getSquareFootage()/1000 * this.getResidentialRate() * 0.15;
        }
        // print out the bill totals
        System.out.println("Discount Amount: $" + nf.format(discount));
        System.out.println("Grand Total is: $" +
                nf.format(this.getSquareFootage()/1000 * this.getResidentialRate() - discount));
    }


    /**
     *
     * @return The billing rate per 1000 square feet for a residential customer
     * Accessor method for the RESIDENTIALRATE attribute
     */
    public static double getResidentialRate() {
        return RESIDENTIALRATE;
    }

    /**
     *
     * @param residentialRate the billing rate per 1000 square feet as a double
     * Modifier method for the RESIDENTIALRATE attribute
     */
    public static void setResidentialRate(double residentialRate) {
        Residential.RESIDENTIALRATE = residentialRate;
    }

    /**
     *
     * @return returns the isSenior elibibility as a boolean
     */
    public boolean isSenior() {
        return senior;
    }

    /**
     *
     * @param senior The senior elgibility as a boolean
     * Modifier method for the senior attribute of this class
     */
    public void setSenior(boolean senior) {
        this.senior = senior;
    }
}
