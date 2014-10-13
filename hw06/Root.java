// Sunny Yu
// hw06 - Root
// 14 October 2014

// This program will calculate the square root of a number using the
// bisection method. 

// imports the Scanner utility
import java.util.Scanner;

// creates a class
public class Root {
    // creates a main method
    public static void main(String[] arg) {
        // constructs an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        // declares and initizlizes some variables
        double x = -1, avg = 0;
        // asks for user input
        while(x < 0) {
            System.out.print("Enter a number greater than 0: ");
            // continues asking for user input until a double is given
            while(!myScanner.hasNextDouble()) {
                myScanner.next();
                System.out.print("Enter a number greater than 0: ");
            }
            x = myScanner.nextDouble();
        }
        double low = 0, high = 1+x;
        // loops the bisection method until the tolerance is reached
        while((high-low)/2 > 0.0000001*(x+1)) {
            avg = (high+low)/2.0;
            double squared = avg*avg;
            if(squared > x) {
                high = avg;
            }
            if(squared < x) {
                low = avg;
            }
        }
        // displays the estimated square root value
        System.out.println("The approximate square root is "+avg+".");
    }
}