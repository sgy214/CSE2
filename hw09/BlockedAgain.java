// Sunny Yu
// hw09 - BlockedAgain
// 4 November 2014

// This program takes user input and outputs a formatted set of numbers and 
// dashes using various methods

// imports the Scanner class
import java.util.Scanner;
// creates a public class
public class BlockedAgain {
    String num = "", space = " ", lines = "";
    int j = 1, count = 1;
    // adds a main method
    public static void main(String []s) {
        BlockedAgain test = new BlockedAgain();
        int m;
        //force user to enter int in range 1-9, inclusive.
        m = getInt();
        test.allBlocks(m);
    }
    public static int getInt() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an integer between 1 and 9, inclusive: ");
        while(true) {
            int n = checkInt();
            if(checkRange(n)) {
                return n;
            }
        }
    }
    public static int checkInt() {
        Scanner scan = new Scanner(System.in);
        while(!scan.hasNextInt()) {
            scan.next();
            System.out.print("You did not enter an integer, try again: ");
        }
        return scan.nextInt();
    }
    public static boolean checkRange(int a) {
        if(a < 1 || a > 9) {
                System.out.print("You did not enter a number between 1 and 9, try again: ");
                return false;
        }
        else {
            return true;
        }
    }
    public void allBlocks(int m) {
        for(int i=0; i<m; i++) {
            blocks(m);
        }
    }
    public void blocks(int n) {
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
    public void line(int n) {
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