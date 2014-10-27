// Sunny Yu
// hw08 - HW8
// 28 October 2014

// The program uses three overloaded versions of the method getInput() to take
// different arguments and return a result.

// imports the Scanner class
import java.util.Scanner;
// creates a public class
public class HW8 {
    // adds a main method
    public static void main(String[] arg) {
        char input;
        // constructs an instance of the Scanner
        Scanner scan = new Scanner(System.in);
        // calls on different versions of the overloaded method getInput and
        // prints the results
        System.out.print("Enter 'C' or 'c' to continue, anything else to quit: ");
        input = getInput(scan,"Cc");
        System.out.println("You entered '"+input+"'");
        System.out.print("Enter 'y', 'Y', 'n', or 'N': ");
        input = getInput(scan,"yYnN",5); //give up after 5 attempts
        if(input!=' ') {
            System.out.println("You entered '"+input+"'");
        }
        input = getInput(scan,"Choose a digit.","0123456789");
        System.out.println("You entered '"+input+"'");
    }
    // creates the method getInput
    public static char getInput(Scanner a, String b) {
        String str = "";
        // infinite loop runs the program until a correct input is found
        while(true) {
            str = a.next();
            // makes sure only a single character is input
            if(str.length() > 1) {
                System.out.print("You should enter exactly one character: ");
                continue;
            }
            // checks if the input matches one of the valid options
            else if(b.contains(str)) {
                // breaks the loop if a correct input is found
                break;
            }
            else {
                System.out.print("You did not enter a character from the list 'Cc'; try again: ");
            }
        }
        // returns the input character
        return str.charAt(0);
    }
    // overloads the method getInput
    public static char getInput(Scanner a, String b, int c) {
        int i = 0;
        // runs the program for the specified number of times
        while(i < c) {
            String str = a.next();
            // checks if the input matches one of the valid options
            if(b.contains(str)) {
                // returns the input character
                return str.charAt(0);
            }
            i++;
            // breaks the loop if the number of trials is met
            if(i == c) {
                break;
            }
            System.out.print("You did not enter a character from the list 'yYnN'; try again: ");
        }
        // prints out the failure message if the loop is broken
        System.out.println("You failed after "+c+" tries.");
        // returns the space character
        return ' ';
    }
    // overloads the method getInput
    public static char getInput(Scanner a, String b, String c) {
        String str = "";
        // splits off the first element of string c
        String split = "'"+c.charAt(0)+"'";
        // runs a loop that splits off every following element of string c
        for(int x = 1; x < c.length(); x++) {
            // adds the characters of string c to a new string in the properly
            // formatted manner
            split = split +", '"+c.charAt(x)+"'";
        }
        // infinite loop that runs until a correct input is found
        while(true) {
            // prints out the supplied message
            System.out.println(b);
            // asks for user input
            System.out.print("Enter one of: "+split+": ");
            str = a.next();
            // checks that only a single character is input
            if(str.length() > 1) {
                System.out.println("Enter exactly one character.");
                continue;
            }
            // checks if the input matches one of the valid options
            else if(c.contains(str)) {
                return str.charAt(0);
            }
            else {
                System.out.println("You did not enter an acceptable character.");
            }
        }
    }
}