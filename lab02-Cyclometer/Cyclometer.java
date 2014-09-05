//Sunny Yu
//lab02-Cyclometer

public class Cyclometer
{
    public static void main(String[] args)
    {
        //input data
        int secsTrip1 = 480;    //time in seconds of trip 1
        int secsTrip2 = 3220;   //time in seconds of trip 2
        int countsTrip1 = 1561; //rotation count of trip 1
        int countsTrip2 = 9037; //rotation count of trip 2
        
        //intermediate variables and output data
        double wheelDiameter = 27.0,    //diameter in inches of the wheel
        PI = 3.14159,   //value for pi
        feetPerMile = 5280, //feet in a mile
        inchesPerFoot  = 12,    //inches in a foot
        secondsPerMinute = 60;  //seconds in a minute
        double distanceTrip1, distanceTrip2, totalDistance; //output data
        
        //prints out the numbers stored
        System.out.println("Trip 1 took "+(secsTrip1/secondsPerMinute)+" minutes and had "+countsTrip1+" counts.");
        System.out.println("Trip 2 took "+(secsTrip2/secondsPerMinute)+" minutes and had "+countsTrip2+" counts.");
        
        //compute the values for the distances
        //distance in miles
        distanceTrip1 = countsTrip1*wheelDiameter*PI/inchesPerFoot/feetPerMile;
        distanceTrip2 = countsTrip2*wheelDiameter*PI/inchesPerFoot/feetPerMile;
        totalDistance = distanceTrip1 + distanceTrip2;
        
        //print out the results
        System.out.println("Trip 1 was "+distanceTrip1+" miles.");
        System.out.println("Trip 2 was "+distanceTrip2+" miles.");
        System.out.println("The total distance was "+totalDistance+" miles.");
    }
}