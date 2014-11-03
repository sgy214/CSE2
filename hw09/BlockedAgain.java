// Sunny Yu
// hw09 - BlockedAgain
// 4 November 2014

// This program takes user input and outputs a formatted set of numbers and 
// dashes using various methods

// imports the Scanner class
import java.util.Scanner;
// creates a public class
public class BlockedAgain {
    // declares and initializes variables to be used in multiple methods
    String num = "", space = " ", lines = "";
    int j = 1, count = 1;
    // adds a main method
    public static void main(String []s) {
        // creates an instance of the class BlockedAgain
        BlockedAgain test = new BlockedAgain();
        int m;
        // force user to enter int in range 1-9, inclusive
        m = getInt();
        // calls the method allBlocks from the instance of class BlockedAgain
        test.allBlocks(m);
    }
    // creates the method getInt that returns an integer
    public static int getInt() {
        // creates an instance of the Scanner class
        Scanner scan = new Scanner(System.in);
        // asks for user input
        System.out.print("Enter an integer between 1 and 9, inclusive: ");
        // returns user input
        while(true) {
            // calls the checkInt and checkRange methods
            int n = checkInt();
            if(checkRange(n)) {
                return n;
            }
        }
    }
    // creates the checkInt method that returns an integer
    public static int checkInt() {
        // creates an instance of the Scanner class
        Scanner scan = new Scanner(System.in);
        // continues to ask for user input until an integer is found
        while(!scan.hasNextInt()) {
            scan.next();
            System.out.print("You did not enter an integer, try again: ");
        }
        // returns the user input
        return scan.nextInt();
    }
    // creates the checkRange method that returns a boolean
    public static boolean checkRange(int a) {
        // checks if the returned value from checkInt is within the range
        if(a < 1 || a > 9) {
            System.out.print("You did not enter a number between 1 and 9, try again: ");
            return false;
        }
        // returns true if the input is correct
        else {
            return true;
        }
    }
    // creates the method allBlocks
    public void allBlocks(int m) {
        // loops the program for values of user input
        for(int i=0; i<m; i++) {
            // calls the method blocks
            blocks(m);
        }
    }
    // creates the method blocks
    public void blocks(int n) {
        // calls the method line
        line(n);
        // prints out the formatted line the correct number of times
        for(int x =0; x < j; x++) {
            System.out.println(space + num);
        }
        // prints out the line separating numbers
        System.out.println(space + lines);
        j += 1;
        count += 2;
    }
    // creates the method line
    public void line(int n) {
        // resets the variable upon each iteration
        num = ""; space = " "; lines = "";
        // creates a string of numbers of the correct length
        for(int x = 0; x < count; x++) {
            num += Integer.toString(j);
        }
        // creates a string of spaces to center the line
        for(int x = 0; x < n-count/2; x++) {
            space += " ";
        }
        // creates a string of "-" of the correct length
        for(int x = 0; x < count; x++) {
            lines += "-";
        }
    }
}