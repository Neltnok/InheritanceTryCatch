package com.company;

/* You are writing a program for a company that does lawn maintenance. You will create:
        A Customer class that has:
        String customerName
        String customerPhone
        String customerAddress
        double squareFootage
        A Commercial class which extends customer that has:
        Property name
        A constant commercial rate at $5 per 1000 square feet (a 10,000 sqft property will be
        charged $50 dollars per week)
        A multi-property field
        A method that calculates weekly charges, if they have multiple properties provide a 10% discount.
        The method should display all information about the customer, the property, and the weekly charge.
        A residential class which extends customer that has:
        A constant rate at $6 per 1000 square feet
        A senior field
        A method that calculates weekly charges, if the senior field is set to true then provide a 15% discount.
        The method should display all information about the customer, the property, and the weekly charge.
        The Main class that presents a menu to the user with the following options:
        Residential Customer
        Commercial Customer
        Done

        The Main class should have methods that get data entry from the user about the Residential or
        Commercial customer and should display all of the information in the form of a quote.
*/

/**
 *  <b>Lawn Maintenance</b> This application displays customer information and weekly billing for a lawn
 *  maintenance company serving commercial and residential customers. Senior residential customers receive
 *  a 15% discount and commercial multiProperty customers receive a 10% discount
 */
public class Main {

    public static void main(String[] args) {
	// create a menuManager object to allow user to select commercil or residential
    // customers and print out their billing statement

        menuManager m = new menuManager();
    }


}
