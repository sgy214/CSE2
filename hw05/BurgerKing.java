//Sunny Yu
//hw05 - Burger King
//30 September 2014

//prompts the user for a Burger King order

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class BurgerKing
{
    //adds a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        //asks for user input
        System.out.println("Enter a letter to indicate choice of,");
        System.out.println("    Burger (B/b)");
        System.out.println("    Soda (S/s)");
        System.out.print("    Fries (F/f):    ");
        //assesses user input and responds appropriately
        if (myScanner.hasNext()) {
            String order = myScanner.next();
            //details of burger order
            if (order.equals("B") || order.equals("b")) {
                System.out.println("Enter A/a for \"all the fixins,\""); 
                System.out.println("    C/c for cheese,"); 
                System.out.print("    N/n for none of the above:  ");
                if (myScanner.hasNext()) {
                    String burger = myScanner.next();
                    switch (burger) {
                        case "A": case "a": System.out.println("You ordered a burger with \"all the fixins.\""); break;
                        case "C": case "c": System.out.println("You ordered a burger with cheese."); break;
                        case "N": case "n": System.out.println("You ordered a burger with no toppings."); break;
                        default: System.out.println("Sorry, that is not a valid burger order.");
                    }
                }
                else {
                    System.out.println("Please enter a valid burger order.");
                    return;
                }
            }
            //details of soda order
            else if (order.equals("S") || order.equals("s")) {
                System.out.print("Do you want Pepsi (P/p), Coke (C/c), Sprite (S/s), or Mountain Dew (M/m): ");
                if (myScanner.hasNext()) {
                    String soda = myScanner.next();
                    switch (soda) {
                        case "P": case "p": System.out.println("You ordered a Pepsi."); break;
                        case "C": case "c": System.out.println("You ordered a Coke."); break;
                        case "S": case "s": System.out.println("You ordered a Sprite."); break;
                        case "M": case "m": System.out.println("You ordered a Mountain Dew."); break;
                        default: System.out.println("Sorry, that is not a valid drink order.");
                    }
                }
                else {
                    System.out.println("Please enter a valid drink order.");
                    return;
                }
            }
            //details of fries order
            else if (order.equals("F") || order.equals("f")) {
                System.out.print("Do you want a large (L/l) or small (S/s) order of fries? ");
                if (myScanner.hasNext()) {
                    String fries = myScanner.next();
                    switch (fries) {
                        case "L": case "l": System.out.println("You ordered large fries."); break;
                        case "S": case "s": System.out.println("You ordered small fries."); break;
                        default: System.out.println("Sorry, that is not a valid order for fries.");
                    }
                }
                else {
                    System.out.println("Please enter a valid fries order.");
                    return;
                }
            }
            //invalid order input
            else {
                System.out.println("Please enter a valid order.");
                return;
            }
        }
        //invalid user input
        else {
            System.out.println("Please enter one of the choices.");
            return;
        }
    }
}