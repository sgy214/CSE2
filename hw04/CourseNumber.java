//Sunny Yu
//hw04 - Course Number
//23 September 2014

//reads in a 6 digit number, makes sure that it adheres to the above description, 
//and then prints out the semester and year

//imports the scanner utility
import java.util.Scanner;

//creates a class
public class CourseNumber 
{
    //adds a main method
    public static void main(String[] args)
    {
        //construct an instance of the Scanner class
        Scanner myScanner = new Scanner(System.in);
        int number, year, sem;
        String semester = null;
        
        //asks for user input
        System.out.print("Enter a six digit number giving the course semester: ");
        //verifies the correct input and calculates the results
        if (myScanner.hasNextInt()) {
            number = myScanner.nextInt();
            if (number >= 186510 && number <= 201440) {
                year = number/100;
                sem = number - (year*100);
            }
            else {
                System.out.println("The number was outside the range [186510, 201440].");
                return;
            }
        }
        else {
            System.out.println("Invalid input.");
            return;
        }
        //select the correct semester using a switch statement
        switch (sem) {
                    case 10: semester = "Spring"; break;
                    case 20: semester = "Summer 1"; break;
                    case 30: semester = "Summer 2"; break;
                    case 40: semester = "Fall"; break;
                    default: System.out.println(sem+ " is not a legitimate semester."); return;
                }
        //print out the result
        System.out.println("The course was offered in the " +semester+ " semester of " +year+ ".");
    }
}