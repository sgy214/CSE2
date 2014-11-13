// Sunny Yu
// hw10 - Find Duplicates
// 18 November 2014

// This program takes a list of user input integers and determines if there are
// duplicates within that list.

// imports the Scanner class
import java.util.Scanner;
// creates a class
public class FindDuplicates {
    // adds a main method
    public static void main(String [] arg) {
        // creates an instance of the Scanner class
        Scanner scan=new Scanner(System.in);
        // declares and initializes an array
        int num[]=new int[10];
        // declares and initializes a string
        String answer="";
        // loop repeats the program based on user input
        do {
            // asks for user input
            System.out.print("Enter 10 ints- ");
            // adds user input into an array
            for(int j=0;j<10;j++) {
                num[j]=scan.nextInt();
            }
            // sets the printed statement
            String out="The array ";
            out+=listArray(num); //return a string of the form "{2, 3, -9}"   
            // calls the hasDups method to determine the output
            if(hasDups(num)) {
                out+="has ";
            }
            else {
                out+="does not have ";
            }
            out+="duplicates.";
            // prints out the complete statement
            System.out.println(out);
            // resets the printed statement
            out="The array ";
            out+=listArray(num);    
            // calls the method exactlyOneDup to determine the output
            if(exactlyOneDup(num)) {
                out+="has ";
            }
            else {
                out+="does not have ";
            }
            out+="exactly one duplicate.";
            // prints out the complete statement
            System.out.println(out);
            // asks for user input to repeat the program
            System.out.print("Go again? Enter 'y' or 'Y', anything else to quit- ");
            // collects user input
            answer=scan.next();
        // continues loop depending on user input
        } while(answer.equals("Y") || answer.equals("y"));
    }
    // creates the method listArray that returns a string
    // this method properly formats an array to be printed
    public static String listArray(int num[]){
        // creates a string to be printed out
        String out="{";
        // adds all elements of an array to the string
        for(int j=0;j<num.length;j++) {
            if(j>0) {
                out+=", ";
            }
            out+=num[j];
        }
        out+="} ";
        // returns the formatted string
        return out;
    }
    // creates the method hasDups that returns a boolean
    // this method determines if there are duplicates in an array
    public static boolean hasDups(int num[]) {
        // runs a loop for every element in an array
        for (int a=0; a<10; a++) {
            // uses the next element in the array
            for (int b=a+1; b<10; b++) {
                // returns true if the two elements are equal
                if(num[a] == num[b]) {
                    return true;
                }
            }
        }
        // returns false if there are no duplicate elements
        return false;
    }
    // creates the method exactlyOneDup that returns a boolean
    // this method determines if an array has only one set of duplicates
    public static boolean exactlyOneDup(int num[]) {
        int count = 0;
        // same format as in the hasDups method to compare every element in the array
        for (int a=0; a<10; a++) {
            for (int b=a+1; b<10; b++) {
                if(num[a] == num[b]) {
                    // adds one to the variable count for every pair of duplicates in the array
                    count += 1;
                }
            }
        }
        // returns true if there is only one set of duplicates, returns false otherwise
        if(count == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}