// Sunny Yu
// hw08 - HW8
// 27 October 2014

//
import java.util.Scanner;
public class HW8 {
    public static void main(String[] arg) {
        char input;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter 'C' or 'c' to continue, anything else to quit: ");
        input = getInput(scan,"Cc");
        System.out.println("You entered '"+input+"'");
        System.out.print("Enter 'y', 'Y', 'n', or 'N': ");
        input = getInput(scan,"yYnN",5); //give up after 5 attempts
        if(input!=' ') {
            System.out.println("You entered '"+input+"'");
        }
        input = getInput(scan,"Choose a digit.","0123456789");
        System.out.println("You entered '"+input+"'");
    }
    public static char getInput(Scanner a, String b) {
        String str = "";
        while(true) {
            str = a.next();
            if(str.length() > 1) {
                System.out.print("You should enter exactly one character: ");
            }
            else if(b.contains(str)) {
                break;
            }
            else {
                System.out.print("You did not enter a character from the list 'Cc'; try again: ");
            }
        }
        return str.charAt(0);
    }
    public static char getInput(Scanner a, String b, int c) {
        int i = 0;
        while(i < c) {
            String str = a.next();
            if(b.contains(str)) {
                return str.charAt(0);
            }
            i++;
            if(i == c) {
                break;
            }
            System.out.print("You did not enter a character from the list 'yYnN'; try again: ");
        }
        System.out.println("You failed after "+c+" tries.");
        return ' ';
    }
    public static char getInput(Scanner a, String b, String c) {
        String str = "";
        String split = "'"+c.charAt(0)+"'";
        for(int x = 1; x < c.length(); x++) {
            split = split +", '"+c.charAt(x)+"'";
        }
        while(true) {
            System.out.println(b);
            System.out.print("Enter one of: "+split+": ");
            str = a.next();
            if(str.length() > 1) {
                System.out.println("Enter exactly one character.");
                continue;
            }
            else if(c.contains(str)) {
                return str.charAt(0);
            }
            else {
                System.out.println("You did not enter an acceptable character.");
            }
        }
    }
}