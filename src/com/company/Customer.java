package com.company;

import java.util.Scanner;

/**
 * Class contains attributes and methods for customer objects
 *
 *@author Ken Neltnor
 *@version 1.0
 */
public class Customer {

    // create an object of type Scanner to manage user input
    static Scanner scanner = new Scanner(System.in);

    // class attributes
    private String customerName = "";
    private String customerPhone = "";
    private String customerAddress = "";
    private double squareFootage = 0.0f;


    /**
     * @author Ken Neltnor
     * @version 1.0
     * Customer class holds the attributes and methods for a customer object
     * This constructor performs a lazy initialization as the real attributes
     * are set using the createCustomerMethod
     */
    public Customer(){
        this.customerName = "";
        this.customerPhone = "";
        this.customerAddress = "";
        this.squareFootage = 0.0f;
    }

    /**
     * accessor method for the customerName attribute of this class
     * @return returns the customer Name as a string
     */
    public String getCustomerName() {
        return customerName;
    }


    /**
     * modifier method for the customerName attribute of this class
     * @param customerName as a string
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    /**
     * accessor method for the customerPhone attribute of this class
     * @return customer phone number as a string
     */
    public String getCustomerPhone() {
        return customerPhone;
    }


    /**
     * modifier method for the customerPhone attribute of this class
     * @param customerPhone as a string
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }


    /**
     * accessor method for the customerAddress attribute of this class
     * @return customerAddress attribute as a string
     */
    //
    public String getCustomerAddress() {
        return customerAddress;
    }


    /**
     * modifier method for the customerAddress attribute of this class
     * @param customerAddress as a string
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * accessor method for the customer squareFootage attribute of this class
     * @return customer squareFootage attribute as a double
     */
    public double getSquareFootage() {
        return squareFootage;
    }


    /**
     * modifier method for the customer squareFootage attribute of this class
     * @param squareFootage as a double
     */
    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

/**
 * method createCustomer
 * This allows the customer class to create its own attributes from console input
 */
// this way if I add more customer attributes we only have to change one method.

public void createCustomer(){
    // generates customer data from user supplied input from the console


    this.setCustomerName(this.getInputString("Please enter the customers name: "));
    this.setCustomerAddress(this.getInputString("Please enter the customers address: "));
    this.setCustomerPhone(this.getInputString("Please enter the customers phone #: "));

    // get the square footage
    System.out.print("Please enter the customers square footage: ");
    this.setSquareFootage(scanner.nextDouble());
}

    /**
     * Method printCustomer
     * Prints the customer class attributes to the console
     */
    public void printCustomer(){

        System.out.println("Customer Name:    " + this.getCustomerName());
        System.out.println("Customer Address: " + this.getCustomerAddress());
        System.out.println("Customer Phone    " + this.getCustomerPhone());
        System.out.println("Square Footage:   " + this.getSquareFootage());
}

//*****************************************************************************
// helper method
// method getInputString
// requirements: caller must accept a double return type
// results: displays a prompt string and accepts a int as a response

    /**
     * Method getInputString
     * @author Ken Neltnor
     * @version 1.0
     * @param prompt a string to hold the input prompt
     * @return a string that holds the response to the prompt
     */
    private static String getInputString(String prompt){
        // local variable to return
        String returnVal = "";

        // display the prompt
        System.out.print(prompt + " ");
        // get an int response from the user
        returnVal = scanner.nextLine();

        //
        return returnVal;
    }
}
