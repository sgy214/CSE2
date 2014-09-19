//Sunny Yu
//lab04-BigMacAgain

//uses the Scanner class to obtain from users how many Big Macs 
//they want and whether they want an order of fries
//it then prints out the total cost of the meal 

//imports the scanner utility
import java.util.Scanner;

//create a class
public class BigMacAgain
{
    //add a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        
        //ask for user input
        System.out.print("Enter the number of Big Macs: ");
        int nBigMacs;
        
        //if and else statements that deal with incorrect input
        if (myScanner.hasNextInt()) {
            nBigMacs = myScanner.nextInt();
            double burgerCost = nBigMacs*2.22;
            if (nBigMacs > 0) {
                System.out.println("You ordered " +nBigMacs+ " Big Macs at $2.22 each for a total cost of $" +(float)burgerCost+ ".");
                System.out.print("Do you want an order of fries (Y/y/N/n)? ");
                String answer = myScanner.next();
                if (answer.equalsIgnoreCase("Y")) {
                    System.out.println("You ordered fries at a cost of $2.15.");
                    System.out.println("The total cost of the meal is $" +(float)(burgerCost+2.15)+ ".");
                }
                else if (answer.equalsIgnoreCase("N")) {
                        System.out.println("The total cost of the meal is $" +(float)burgerCost+ ".");
                    }
                else {
                    System.out.println("You did not enter a valid option.");
                    return;
                }
            }
            else {
                System.out.println("You did not enter an integer greater than zero.");
                return;
            }
        }  
        else {
            System.out.println("You did not enter an integer.");
            return;
        }
    }
}