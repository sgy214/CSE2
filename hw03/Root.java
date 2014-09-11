//Sunny Yu
//hw03 - Root

//prints out the crude estimate of the cubed root and then the result cubed of an user inputed double

//access the Scanner utility
import java.util.Scanner;

public class Root 
{
    public static void main(String[] args)
    {
        //create a scanner
        Scanner input = new Scanner(System.in);
        
        //user input
        System.out.print("Enter a double and I print its cubed root: ");
        double x = input.nextDouble();
        
        //calculations
        double guess = x/3;
        guess = (2*guess*guess*guess+x)/(3*guess*guess);
        guess = (2*guess*guess*guess+x)/(3*guess*guess);
        guess = (2*guess*guess*guess+x)/(3*guess*guess);
        guess = (2*guess*guess*guess+x)/(3*guess*guess);
        guess = (2*guess*guess*guess+x)/(3*guess*guess);
        
        double cubed = guess*guess*guess;
        
        //print out the results
        System.out.println("The cube root is " + guess + ".");
        System.out.println("The estimate cubed is " + cubed + ".");
    }
}