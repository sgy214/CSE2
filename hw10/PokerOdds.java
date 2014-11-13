// Sunny Yu
// hw10 - Poker Odds
// 18 November 2014

// This program draws 5 random cards from a deck of 52 cards and returns the
// poker hand. This program also runs a 10000 simulation of random poker hands
// and determines the number of a single set of pairs drawn.

// imports the Random and Scanner class
import java.util.Random;
import java.util.Scanner;
// creates a class
public class PokerOdds {
    // adds a main method
    public static void main(String [] arg) {
        // calls the method showHands
        showHands();
        // calls the method simulateOdds
        simulateOdds();
    }
    // creates the method showHands that prints out a random poker hand
    public static void showHands() {
        // creates an instance of the Scanner class
        Scanner scan=new Scanner(System.in);
        // declares and initializes two arrays
        String cards[]= new String[5];
        int hand[]=new int[5];
        // declares and initializes an empty string
        String answer="";
        // loops through the program depending on user input
        do {
            // calls the method randomCards and assigns it to an array
            hand = randomCards();
            // converts the values of the array into their poker equivalents
            for(int i=0; i<5; i++) {
                switch(hand[i]%13) {
                    case 0: cards[i] = "K"; break;
                    case 1: cards[i] = "A"; break;
                    case 11: cards[i] = "J"; break;
                    case 12: cards[i] = "Q"; break;
                    default: cards[i] = ""+(hand[i]%13);
                }
            }
            // creates a set of string labels
            String clubs="", diamonds="", hearts="", spades="";
            // determines the suite of each card and assigns them to the correct string label
            for(int i=0; i<5; i++) {
                switch(hand[i]/13) {
                    case 0: clubs += cards[i]+" "; break;
                    case 1: diamonds += cards[i]+ " "; break;
                    case 2: hearts += cards[i]+" "; break;
                    case 3: spades += cards[i]+" "; break;
                }
            }
            // prints out the suite and card values
            System.out.println("Clubs: "+ clubs);
            System.out.println("Diamonds: "+ diamonds);
            System.out.println("Hearts: "+ hearts);
            System.out.println("Spades: "+ spades);
            // asks for user input to rerun the program
            System.out.print("Go again? Enter 'y' or 'Y', anything else to quit: ");
            // assigns the input to a variable
            answer=scan.next();
        // runs the program while the user input is valid
        } while(answer.equals("Y") || answer.equals("y"));
    }
    // creates the method randomCards that returns an array
    // this method picks five random cards from a standard deck of 52 cards
    public static int[] randomCards() {
        // declares and initializes the array
        int hand[]={-1, -1, -1, -1, -1};
        // declares and allocates an array
        int deck[]=new int[52];
        // sets values for the array from 0 to 51
        for(int i=0; i<52; i++) {
            deck[i] = i;
        }
        // fills the array hand with five random numbers from the array deck
        for(int i=0; i<5; i++) {
            // takes a random number with a decreasing range for each iteration
            int rand = (int)(Math.random()*(52-i));
            // sets the value of the array hand to the value of the array deck
            // at the index of the random number
            hand[i] = deck[rand];
            // moves the card to the end of the deck and sets the value to -1
            deck[rand] = deck[51-i];
            deck[51-i] = -1;
        }
        // returns the array
        return hand;
    }
    // creates the method simulateOdds that prints the results of a 10000 time
    // simulation counting the number of exactly one pair per poker hand
    public static void simulateOdds() {
        int count = 0;
        // declares and initializes two variables
        int hand[]=new int[5];
        int freq[] = new int[13];
        // repeats the simulation 10000 times
        while(count < 10000) {
            // calls the method randomCards to create a random poker hand
            hand = randomCards();
            // determines the card value of the array hand
            for(int i=0; i<5; i++) {
                hand[i] = (hand[i] % 13);
            }
            // calls the method exactlyOneDup to determine if there is only one
            // set of pairs in the array
            if(exactlyOneDup(hand)) {
                // calls the method returnDup to return the value of the pair
                int x = returnDup(hand);
                // adds one to the array freq to count the number of pairs found
                // for each card value
                freq[x] += 1;
            }
            count++;
        }
        // declares and initializes an array with the poker hand values of the cards
        String names[] = new String[13];
        for(int i=4; i<13; i++) {
            names[i] = (14-i)+"";
        }
        names[0] = "A";
        names[1] = "K";
        names[2] = "Q";
        names[3] = "J";
        // prints out the formatted list of values
        System.out.println("  rank   freq of exactly one pair");
        // loops through and prints each element of the array names and freq
        for(int i=0; i<13; i++) {
            System.out.println("    "+names[i]+"\t\t"+freq[i]);
        }
        int sum = 0;
        // finds the sum of the values in the array freq
        for(int i=0; i<13; i++) {
            sum += freq[i];
        }
        // prints out the number of hands without exactly one pair
        System.out.println("----------------------------");
        System.out.println(" total not exactly one pair: "+(10000-sum));
    }
    // creates the method exactlyOneDup that returns a boolean
    // this method determines if an array has exactly one pair
    public static boolean exactlyOneDup(int num[]) {
        int count = 0;
        // runs a loop for every element in an array
        for (int a=0; a<5; a++) {
            // uses the next element in the array
            for (int b=a+1; b<5; b++) {
                // adds one to the variable count for every pair of duplicates in the array
                if(num[a] == num[b]) {
                    count += 1;
                }
            }
        }
        // returns true if there is only pair in the array
        if(count == 1) {
            return true;
        }
        else {
            return false;
        }
    }
    // creates the method returnDup that returns an integer
    public static int returnDup(int num[]) {
        // declares and initializes the varible x
        int x = -1;
        // runs a loop for every element in an array
        for (int a=0; a<5; a++) {
            // uses the next element in the array
            for (int b=a+1; b<5; b++) {
                // sets the variable x to the value of the pair
                if(num[a] == num[b]) {
                    x = num[a];
                }
            }
        }
        // returns the variable x
        return x;
    }
}