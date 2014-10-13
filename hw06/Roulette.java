// Sunny Yu
// hw06 - Roulette
// 14 October 2014

// This program runs a Monte Carlo simulation of the roulette game played
// by placing a $1 bet on a specific number for 100 spins

// creates the class
public class Roulette {
    // creates a main method
    public static void main(String[] arg) {
        // declares and initializes several variables
        int trials = 0, totalWinnings = 0, profit = 0, noWins =0;
        // loop runs 1000 trials
        while(trials < 1000) {
            int winnings = 0, spins = 0, wins = 0;
            // sets a random bet value
            int bet = (int)(Math.random()*37);
            // loop tests 100 spins
            while(spins < 100) {
                int roulette = (int)(Math.random()*37);
                // adds up the winnings and times won
                if(bet == roulette) {
                    winnings += 36;
                    wins += 1;
                }
                spins++;
            }
            // counts the number of times you lost everything
            if(winnings == 0) {
                noWins += 1;
            }
            // counts the number of times you made a profit
            if(wins >= 3) {
                profit += 1;
            }
            // adds up total winnings
            totalWinnings += winnings;
            trials++;
        }
        // prints out results of the simulation
        System.out.println("You lose everything "+noWins+" times.");
        System.out.println("You win a total of $"+totalWinnings);
        System.out.println("You make a profit "+profit+" times.");
    }
}