// Sunny Yu
// hw10 - Find Duplicates
// 18 November 2014

// This program takes a list of user input integers and determines if there are
// duplicates within that list.

import java.util.Scanner;
public class FindDuplicates {
    public static void main(String [] arg) {
        Scanner scan=new Scanner(System.in);
        int num[]=new int[10];
        String answer="";
        do {
            System.out.print("Enter 10 ints- ");
            for(int j=0;j<10;j++) {
                num[j]=scan.nextInt();
            }
            String out="The array ";
            out+=listArray(num); //return a string of the form "{2, 3, -9}"   
            if(hasDups(num)) {
                out+="has ";
            }
            else {
                out+="does not have ";
            }
            out+="duplicates.";
            System.out.println(out);
            out="The array ";
            out+=listArray(num);    
            if(exactlyOneDup(num)) {
                out+="has ";
            }
            else {
                out+="does not have ";
            }
            out+="exactly one duplicate.";
            System.out.println(out);
            System.out.print("Go again? Enter 'y' or 'Y', anything else to quit- ");
            answer=scan.next();
        } while(answer.equals("Y") || answer.equals("y"));
    }
    
    public static String listArray(int num[]){
        String out="{";
        for(int j=0;j<num.length;j++) {
            if(j>0) {
                out+=", ";
            }
            out+=num[j];
        }
        out+="} ";
        return out;
    }
    
    public static boolean hasDups(int num[]) {
        for (int a=0; a<10; a++) {
            for (int b=a+1; b<10; b++) {
                if(num[a] == num[b]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean exactlyOneDup(int num[]) {
        int count = 0;
        for (int a=0; a<10; a++) {
            for (int b=a+1; b<10; b++) {
                if(num[a] == num[b]) {
                    count += 1;
                }
            }
        }
        if(count == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}