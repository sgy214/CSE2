//Sunny Yu
//hw04 - Course Number
//23 September 2014

//this program prompts the user to enter an integer that gives the thousands of
//dollars of income and then writes out the amount of tax on the income given a
//progressive schedule

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class IncomeTax
{
    //creates a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        double tax;
        int income;
        
        //asks for user input
        System.out.print("Enter the income as an integer giving the number of thousands: ");
        
        //verifies inputs and calculates results
        if (myScanner.hasNextInt()) {
            income = myScanner.nextInt();
            if (income >= 0 && income < 20)
                tax = 0.05;
            else if (income >= 20 && income < 40)
                tax = 0.07;
            else if (income >= 40 && income < 78)
                tax = 0.12;
            else if (income >= 78)
                tax = 0.14;
            else {
                System.out.println("Please enter a positive integer.");
                return;
            }
        }
        else {
            System.out.println("Incorrect input.");
            return;
        }
        //prints out the results
        System.out.println("The tax rate on $" +income*1000+ " is "+(float)(tax*100)+ "%, and the tax is $" +(float)(tax*income*1000)+ ".");
    }
}
