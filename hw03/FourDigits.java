//Sunny Yu
//hw03 - Four Digits

//prompts the user to enter a double and then prints out the
//first four digits to the right of the decimal point

//access the Scanner utility
import java.util.Scanner;

//create a class
public class FourDigits
{
    //create a main method
    public static void main(String[] args)
    {
        //create a scanner
        Scanner input = new Scanner(System.in);
        
        //user input
        System.out.print("Enter a double and I display the four digits "
        + "to the right of the decimal point: ");
        double number = input.nextDouble();
        
        //converting user input to integer
        int complete = (int)(number*100000);

        complete = complete/10;
        int oneBot = (complete/10)*10;

        int tensTop = (complete/10);
        int tensBot = (complete/100)*10;

        int hunTop = (complete/100);
        int hunBot = (complete/1000)*10;

        int thouTop = (complete/1000);
        int thouBot = (complete/10000)*10;
        
        //finding the remainders
        //gives the four digits
        int ones = complete%oneBot;
        int tens = tensTop%tensBot;
        int hundreds = hunTop%hunBot;
        int thousands = thouTop%thouBot;
        
        //print out the results
        System.out.print(thousands);
        System.out.print(hundreds);
        System.out.print(tens);
        System.out.println(ones);
    }
}