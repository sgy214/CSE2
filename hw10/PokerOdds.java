// Sunny Yu
// hw10 - Poker Odds
// 18 November 2014

// This program draws 5 random cards from a deck of 52 cards
import java.util.Random;
import java.util.Scanner;
public class PokerOdds {
    public static void main(String [] arg) {
        showHands();
        simulateOdds();
    }
    public static void showHands() {
        Scanner scan=new Scanner(System.in);
        String cards[]= new String[5];
        String answer="";
        int hand[]=new int[5];
        do {
            hand = randomCards();
            for(int i=0; i<5; i++) {
                switch(hand[i]%13) {
                    case 0: cards[i] = "K"; break;
                    case 1: cards[i] = "A"; break;
                    case 11: cards[i] = "J"; break;
                    case 12: cards[i] = "Q"; break;
                    default: cards[i] = ""+(hand[i]%13);
                }
            }
            String clubs="", diamonds="", hearts="", spades="";
            for(int i=0; i<5; i++) {
                switch(hand[i]/13) {
                    case 0: clubs += cards[i]+" "; break;
                    case 1: diamonds += cards[i]+ " "; break;
                    case 2: hearts += cards[i]+" "; break;
                    case 3: spades += cards[i]+" "; break;
                }
            }
            System.out.println("Clubs: "+ clubs);
            System.out.println("Diamonds: "+ diamonds);
            System.out.println("Hearts: "+ hearts);
            System.out.println("Spades: "+ spades);
            
            System.out.print("Go again? Enter 'y' or 'Y', anything else to quit: ");
            answer=scan.next();
        } while(answer.equals("Y") || answer.equals("y"));
    }
    public static int[] randomCards() {
        int hand[]={-1, -1, -1, -1, -1};
        int deck[]=new int[52];
        for(int i=0; i<52; i++) {
            deck[i] = i;
            }
        for(int i=0; i<5; i++) {
            int rand = (int)(Math.random()*(52-i));
            hand[i] = deck[rand];
            deck[rand] = deck[51-i];
            deck[51-i] = -1;
        }
        return hand;
    }
    public static void simulateOdds() {
        int count = 0;
        int hand[]=new int[5];
        int freq[] = new int[13];
        while(count < 10000) {
            hand = randomCards();
            for(int i=0; i<5; i++) {
                hand[i] = (hand[i] % 13);
            }
            if(exactlyOneDup(hand)) {
                int x = returnDup(hand);
                freq[x] += 1;
            }
            count++;
        }
        String names[] = new String[13];
        for(int i=4; i<13; i++) {
            names[i] = (14-i)+"";
        }
        names[0] = "A";
        names[1] = "K";
        names[2] = "Q";
        names[3] = "J";
        System.out.println("  rank   freq of exactly one pair");
        for(int i=0; i<13; i++) {
            System.out.println("    "+names[i]+"\t\t"+freq[i]);
        }
        int sum = 0;
        for(int i=0; i<13; i++) {
            sum += freq[i];
        }
        System.out.println("----------------------------");
        System.out.println(" total not exactly one pair: "+(10000-sum));
    }
    public static boolean exactlyOneDup(int num[]) {
        int count = 0;
        for (int a=0; a<5; a++) {
            for (int b=a+1; b<5; b++) {
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
    public static int returnDup(int num[]) {
        int x = -1;
        for (int a=0; a<5; a++) {
            for (int b=a+1; b<5; b++) {
                if(num[a] == num[b]) {
                    x = num[a];
                }
            }
        }
        return x;
    }
}