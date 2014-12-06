// Sunny Yu
// hw11 - Poker Hands
// 5 December 2014

// This program ranks the user input poker hand.

// imports the Scanner and Arrays class
import java.util.Arrays;
import java.util.Scanner;
// creates a class
public class PokerHands {
    // adds a main method
    public static void main(String[] arg) {
        // creates an instance of the Scanner class
        Scanner scan = new Scanner(System.in);
        // declares and initializes the array
        int[] newHand = new int[5];
        // loops through the program until the user tells it to stop
        while(true) {
            // calls the methods inputHand, showOneHand, and ranking
            newHand = inputHand();
            showOneHand(newHand);
            ranking(newHand);
            // asks for user input to continue running
            System.out.print("Enter 'y/Y' to enter a(nother) hand: ");
            String reply = scan.next();
            // determines whether the program runs again
            if(reply.equals("y") || reply.equals("Y")) {
                continue;
            }
            else {
                // ends the loop
                break;
            }
        }
    }
    // creates the method inputHand that outputs the user generated array
    public static int[] inputHand() {
        // creates an instance of the Scanner class
        Scanner scan = new Scanner(System.in);
        // declares and initializes the integers suit and card
        int suit = 0;
        int card = 0;
        // declares and initializes the array with negative numbers
        int[] hand = {-1, -2, -3, -4, -5};
        for(int i=0; i<5; i++) {
            // asks for user input
            System.out.print("Enter the suit 'c', 'd', 'h', or 's': ");
            // determines values of the suit
            switch(scan.next()) {
                case "c": suit = 0; break;
                case "d": suit = 13; break;
                case "h": suit = 26; break;
                case "s": suit = 39; break;
                // resets the loop without a valid input
                default: System.out.println("You did not enter a valid response."); i--; continue;
            }
            // asks for user input
            System.out.print("Enter one of 'A', 'K', 'Q', 'J', '10',...'2': ");
            // determines values of the card
            switch(scan.next()) {
                case "A": case "a": card = 0; break;
                case "K": case "k": card = 1; break;
                case "Q": case "q": card = 2; break;
                case "J": case "j": card = 3; break;
                case "10": card = 4; break;
                case "9": card = 5; break;
                case "8": card = 6; break;
                case "7": card = 7; break;
                case "6": card = 8; break;
                case "5": card = 9; break;
                case "4": card = 10; break;
                case "3": card = 11; break;
                case "2": card = 12; break;
                // resets the loop without a valid input
                default: System.out.println("You did not enter a valid response."); i--; continue;
            }
            // sets the values of the array based on user input
            hand[i] = card + suit;
            // checks for duplicates in the array
            for (int a=0; a<5; a++) {
                for (int b=a+1; b<5; b++) {
                    if(hand[a] == hand[b]) {
                        // resets the loop when duplicates are found
                        System.out.println("You already entered that card.");
                        i--;
                        break;
                    }
                }
            }
        }
        // returns the array
        return hand;
    }
    // creates the method showOneHand to format and print the array
    public static void showOneHand(int hand[]) {
        // declares and initializes a couple variables
        String suit[] = {"Clubs:	", "Diamonds: ", "Hearts:   ", "Spades:   "};
        String face[] = {"A ","K ","Q ","J ","10 ","9 ","8 ","7 ","6 ","5 ","4 ","3 ","2 "};
        String out = "";
        // loops through the four suits
        for(int s=0; s<4; s++) {
            out+=suit[s];
            for(int rank=0; rank<13; rank++)
            for(int card=0; card<5; card++)
            if(hand[card]/13 == s && hand[card]%13 == rank)
            out += face[rank];
            out += '\n';
        }
        // prints out the formatted poker hand
        System.out.println(out);
    }
    // creates a method ranking to determine the poker hand rank
    public static void ranking(int[] hand) {
        // initializes the output string
        String out = "This is a ";
        String rank = "High Card";
        // initializes six arrays
        int[] card = new int[5];
        int[] suit = new int[5];
        int[] freq = new int[13];
        int[] count = new int[5];
        int[] suitFreq = new int[4];
        int[] suitCount = new int[6];
        // sets the array based on the poker hand
        for(int i=0; i<5; i++) {
            card[i] = hand[i] % 13;
            suit[i] = hand[i]/13;
        }
        // sorts the array in increasing order
        for(int i=0; i<5; i++) {
            Arrays.sort(card);
        }
        // counts the frequency of cards and suits
        for(int i=0; i<5; i++) {
            freq[card[i]] += 1;
        }
        for(int i=0; i<13; i++) {
            count[freq[i]] += 1;  
        }
        for(int i=0; i<5; i++) {
            suitFreq[suit[i]] += 1;
        }
        for(int i=0; i<4; i++) {
            suitCount[suitFreq[i]] += 1;
        }
        // checks if the poker hand is a flush
        if(suitCount[5]==1) {
            rank = "Flush";
        }
        // narrows down the ranking to high card or straight
        if(count[1]==5) {
            // checks if the poker hand is a staight
            if(card[4]-card[0]==4) {
                rank = "Straight ";
                // checks if the poker hand is also a flush
                if(suitCount[5]==1) {
                    rank += "Flush";
                    // checks if the poker hand is royal flush
                    if(card[0]==0) {
                        rank = "Royal Flush";
                    }
                }
            }
        }
        // sets the output variable based on the count
        if(count[2] == 1) {
            rank = "One Pair";
            // determines if the poker hand is a full house
            if(count[3] == 1) {
                rank = "Full House";
            }
        }
        else if(count[2] == 2) {
            rank = "Two Pair";
        }
        else if(count[3] == 1) {
            rank = "Three of a Kind";
        }
        else if(count[4] == 1) {
            rank = "Four of a Kind";
        }
        // prints out the poker hand rank
        System.out.println(out+rank);
    }
}