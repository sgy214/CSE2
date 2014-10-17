// Sunny Yu
// hw07 - NumberStack
// 21 October 2014

// This program takes a user input integer between 1-9, and returns a display
// using for, while, and do-while loops.

// imports the Scanner
import java.util.Scanner;
// creates a class
public class NumberStack {
    // adds a main method
    public static void main(String[] arg) {
        // constructs an instance of the Scanner class
        Scanner scan = new Scanner(System.in);
        int n = 0;
        // asks for user input
        System.out.print("Enter a number between 1 and 9: ");
        // continues asking for user input until a valid input is received
        while(true) {
            // checks if user input is an integer
            while(!scan.hasNextInt()) {
                scan.next();
                System.out.print("You did not enter an integer, try again: ");
            }
            n = scan.nextInt();
            // checks that integer is between 1-9
            if(n < 1 || n > 9) {
                System.out.print("You did not enter a number between 1 and 9, try again: ");
            }
            // correct input breaks loops and runs rest of program
            else {
                break;
            }
        }
        System.out.println("Using for loops:");
        int j = 1, count = 1;
        // runs entire loop for every number up to n
        for(int i = 0; i < n; i++) {
            String num = "", space = " ", lines = "";
            // creates a string of numbers of the correct length
            for(int x = 0; x < count; x++) {
                num += Integer.toString(j);
                }
            // creates a string of spaces to center the line
            for(int x = 0; x < n-count/2; x++) {
                space += " ";
            }
            // prints out the formatted line the correct number of times
            for(int x =0; x < j; x++) {
                System.out.println(space + num);
            }
            // creates a string of "-" of the correct length
            for(int x = 0; x < count; x++) {
                lines += "-";
            }
            // prints out the line separating numbers
            System.out.println(space + lines);
            j += 1;
            count += 2;
        }
        System.out.println("Using while loops:");
        int i = 0; 
        j = 1;
        count = 1;
        // runs the entire loop for every number up to n
        while(i < n) {
            String num = "", space = " ", lines = "";
            int a = 0;
            // creates a string of numbers of the correct length
            while(a < count) {
                num += Integer.toString(j);
                a++;
            }
            a = 0;
            // creates a string of spaces to center the line
            while(a < n-count/2) {
                space += " ";
                a++;
            }
            a = 0;
            // prints out the formatted line the correct number of times
            while(a < j) {
                System.out.println(space + num);
                a++;
            }
            a = 0;
            // creates a strings of "-" of the correct length
            while(a < count) {
                lines += "-";
                a++;
            }
            // prints out the line between numbers
            System.out.println(space + lines);
            j += 1;
            count += 2;
            i++;
        }
        System.out.println("Using do-while loops:");
        i = 0; 
        j = 1;
        count = 1;
        // runs the entire loop for every number up to n
        do {
            String num = "", space = " ", lines = "";
            int b = 0;
            // creates a string of numbers of the correct length
            do {
                num += Integer.toString(j);
                b++;
            } while(b < count);
            b = 0;
            // creates a string of spaces of the correct length
            do {
                space += " ";
                b++;
            } while(b < n-count/2);
            b = 0;
            // prints out the formatted line the correct number of times
            do {
                System.out.println(space + num);
                b++;
            } while(b < j);
            b = 0;
            // creates a string of "-" of the correct length
            do {
                lines += "-";
                b++;
            } while(b < count);
            // prints out the line between numbers
            System.out.println(space + lines);
            j += 1;
            count += 2;
            i++;
        } while(i < n);
    }
}