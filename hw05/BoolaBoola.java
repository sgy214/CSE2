//Sunny Yu
//hw05 - BoolaBoola
//30 September 2014

//creates a randomized question regarding the use of booleans

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class BoolaBoola 
{
    //adds a main method
    public static void main(String[] args) 
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        boolean one = false;
        boolean two = false;
        boolean three = false;
        String sign1 = null;
        String sign2 = null;
        //randomizes the variables
        switch ((int)(Math.random()*2+1)) {
            case 1: one = true; break;
            case 2: one = false; break;
        }
        switch ((int)(Math.random()*2+1)) {
            case 1: two = true; break;
            case 2: two = false; break;
        }
        switch ((int)(Math.random()*2+1)) {
            case 1: three = true; break;
            case 2: three = false; break;
        }
        switch ((int)(Math.random()*2+1)) {
            case 1: sign1 = "&&"; break;
            case 2: sign1 = "||"; break;
        }
        switch ((int)(Math.random()*2+1)) {
            case 1: sign2 = "&&"; break;
            case 2: sign2 = "||"; break;
        }
        //asks for user input
        System.out.print("Does "+one+" "+sign1+" "+two+" "+sign2+" "+three+" have the value true (T/t) or false (F/f)? ");
        //utilizes the random variables
        if (myScanner.hasNext()) {
            String guess = myScanner.next();
            boolean answer = false;
            boolean guessBool = false;
            if (sign1.equals("&&")) {
                if (sign2.equals("&&")) {
                    answer = one&&two&&three;
                }
                else if (sign2.equals("||")) {
                    answer = one&&two||three;
                }
            }
            else if (sign1.equals("||")) {
                if (sign2.equals("&&")) {
                    answer = one||two&&three;
                }
                else if (sign2.equals("||")) {
                    answer = one||two||three;
                }
            }
            //interprets the user input answers
            if (guess.equals("T")||guess.equals("t")) {
                guessBool = true;
                if (answer == guessBool) {
                    System.out.println("Correct.");
                }
                else {
                    System.out.println("Incorrect. Please try again.");
                }
            }
            else if (guess.equals("F")||guess.equals("f")) {
                guessBool = false;
                if (answer == guessBool) {
                    System.out.println("Correct.");
                }
                else {
                    System.out.println("Incorrect. Please try again.");
                }
            }
            else {
                System.out.println("Invalid response. Please try again.");
            }
        }
        else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}