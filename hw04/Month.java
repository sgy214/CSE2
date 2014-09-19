//Sunny Yu
//hw04 - Course Number
//23 September 2014

//prompts the user for a month and gives the number of days for the month

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class Month 
{
    //adds a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        
        //asks for user input
        System.out.print("Enter an integer giving the number of the month (1-12): ");
        int month, days, year;
        boolean isLeapYear;
        
        //verifies inputs and calculates results
        if (myScanner.hasNextInt()) {
            month = myScanner.nextInt();
            //establishes conditions for leap years
            if (month == 2) {
                System.out.print("Enter the year: ");
                if (myScanner.hasNextInt()) {
                    year = myScanner.nextInt();
                    isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                    if (isLeapYear)
                        days = 29;
                    else {
                        days = 28;
                    }
                    System.out.println("The month has " +days+ " days.");
                }
                else {
                    System.out.println("Invalid input.");
                    return;
                }
            }
            else {
                //selects the number of days using a switch statement
                switch (month) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12: System.out.println("The month has 31 days."); break;
                    case 4: case 6: case 9: case 11: System.out.println("The month has 30 days."); break;
                    default: System.out.println("You did not enter an integer between 1 and 12.");
                }    
            }
        }
        else {
            System.out.println("Invalid input.");
            return;
        }
    }
}