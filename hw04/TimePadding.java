//Sunny Yu
//hw04 - Course Number
//23 September 2014

//takes a user input of number of seconds and displays the time in
//conventional form

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class TimePadding 
{
    //adds a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        
        //ask for user input
        System.out.print("Enter the time in seconds: ");
        int time, hour, min, sec;
        String minutes = null;
        String seconds = null;
        
        //verify correct input and calculate resutls
        if (myScanner.hasNextInt()) {
            time = myScanner.nextInt();
            if (time >= 0) {
                hour = time/3600;
                min = (time-hour*3600)/60;
                sec = time%60;
            }
            else {
                System.out.println("Please enter a positive integer.");
                return;
            }
        }
        else {
            System.out.println("Invalid input.");
            return;
        }
        minutes = ""+min;
        seconds = ""+sec;
        
        if (min < 10){
            minutes = "0"+min;
        }
        if (sec < 10) {
            seconds = "0"+sec;
        }
        //print out results
        System.out.println("The time is " +hour+":"+minutes+":"+seconds+".");
    }
}
        