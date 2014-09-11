//Sunny Yu
//hw03 - Bicycle

//calculate distance, time, and average mph from user inputs

//access the Scanner utility
import java.util.Scanner;

public class Bicycle
{
    public static void main(String[] args)
    {
        //create a scanner
        Scanner input = new Scanner(System.in);
        
        //input data
        System.out.print("Enter the number of seconds: ");
        double seconds = input.nextDouble();
        System.out.print("Enter the number of counts: ");
        double counts = input.nextDouble();
        
        //intermediate variables
        double wheelDiameter = 27.0,    //diameter in inches of the wheel
        PI = 3.14159,   //value for pi
        feetPerMile = 5280, //feet in a mile
        inchesPerFoot = 12,    //inches in a foot
        secondsPerMinute = 60,  //seconds in a minute
        minutesPerHour = 60;    //minutes in an hour
        
        //compute the values for the distances
        //distance in miles
        double distance = counts*wheelDiameter*PI/inchesPerFoot/feetPerMile;

        //compute time in minutes
        double time = seconds/secondsPerMinute;
        
        //compute average mph
        double timeHours = time/minutesPerHour;
        double averageMPH = distance/timeHours;
        
        //round the distance to two decimal places
        distance = distance*100;
        int intDistance = (int)distance;
        double roundedDistance = intDistance;
        roundedDistance = roundedDistance/100;
        //round the average mph to two decimal places
        averageMPH = averageMPH*100;
        int intAverage = (int)averageMPH;
        double roundedAverage = intAverage;
        roundedAverage = roundedAverage/100;
        
        //print out the results
        System.out.println("The distance was " + roundedDistance + " miles and took " + time + " minutes.");
        System.out.println("The average mph was " + roundedAverage + ".");
    }
}