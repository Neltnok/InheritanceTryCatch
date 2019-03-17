package com.company;

// import for the Scanner class
import java.util.Scanner;

/**
 * Class menuManager - This class displays a menu for input of customer information and prints out the
 * weekly billing statement.
 *
 *@author Ken Neltnor
 *@version 1.0
 */

public class menuManager {

    // create an object of type Scanner to manage user input
    static Scanner scanner = new Scanner(System.in);

    /**
     * Method: <b>menuManager</b>
     * instantiates an object of type menuManager
     * displays a menu for customer attribute data entry and quote generation
     *
     */
    public menuManager() {

        // display the top menu for customer selection
        int selection = this.displayMenu();

       switch (selection){
           case 0:
               System.out.println("Thank you for using Quote Manager");
               break;

           case 1:
               System.out.println("Please enter the following Residential customer data");
               // call a constructor to create a residential customer object
               // and print out their billing statement
               Residential r = new Residential();
               break;

           case 2:
               System.out.println("Please enter the following Commercial customer data");
               Commercial c = new Commercial();
               break;

           default:
               break;
        }

    }

    /**
     * Method <B>displayMenu</B>
     * @author Ken Neltnor
     * @version 1.0
     * Requirements: None
     * Results: Displays a menu to allow selection of commercial or residential customers for weekly bill generation
     * @return : Returns a 1 for residential customer, 2 for commercial customer or 0 for exit.
      */
   public int displayMenu(){

        int selection = 3;

       System.out.println("Lawn Maintenance Quote Generator\n");

        // display the menu prompt until the  user responds with a valid choice
       do {
           selection = getInputInt("Please choose: \n1 for Residential customer \n2 for Commercial customer \n0 to exit");
       } while( selection != 0 & selection != 1 & selection != 2);

        return selection;
   }


//*****************************************************************************
// helper method
// method getInput
// requirements: caller must accept a double return type
// results: displays a prompt string and accepts a int as a response


    /**
     * Method getInputInt
     * @author Ken Neltnor
     * @version 1.0
     * @param prompt a string to hold the input prompt
     * @return a string that holds the response to the prompt
     */
    private static int getInputInt(String prompt){
        // local variable to return
        int returnVal = 0;

        // display the prompt
        System.out.println(prompt + " ");
        // get an int response from the user
        returnVal = scanner.nextInt();

        //
        return returnVal;
    }
}
