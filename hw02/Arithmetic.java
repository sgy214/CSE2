//Sunny Yu
//hw02
//Arithmetic

//This program will compute the cost of items bought, including the
//PA sales tax of 6%

//create a class
public class Arithmetic
{
    //add main method
    public static void main(String[] args)
    {
        //numbers of pairs of socks
        int nSocks = 3;
        //cost per pair of socks
        double sockCost$ = 2.58;
        //number of drinking glasses
        int nGlasses = 6;
        //cost per glass
        double glassCost$ = 2.29;
        //number of boxes of envelopes
        int nEnvelopes = 1;
        //cost per box of envelopes
        double envelopeCost$ = 3.25;
        //sales tax of PA
        double taxPercent = 0.06;
        
        //total cost of socks
        double totalSockCost$ = nSocks * sockCost$;
        //total cost of drinking glasses
        double totalGlassCost$ = nGlasses * glassCost$;
        //total cost of envelopes
        double totalEnvelopeCost$ = nEnvelopes * envelopeCost$;
        
        //total cost of purchases before tax
        double totalCost$ = totalEnvelopeCost$ + totalGlassCost$ + totalSockCost$;
        
        //total sales tax
        double totalTax = totalCost$ * taxPercent;
       
        //rounding the sales tax
        totalTax = totalTax * 100;
        int roundedTax = (int)totalTax;
        double finalTax = roundedTax / 100.0;
        
        //print out the costs and tax of items
        System.out.print("The cost of " + nSocks + " socks at $" + sockCost$ + " each, is $" + totalSockCost$ + ". ");
        System.out.println("The sales tax is $" + (totalSockCost$ * taxPercent) + ". ");
        System.out.print("The cost of " + nGlasses + " drinking glasses at $" + glassCost$ + " each, is $" + totalGlassCost$ + ". ");
        System.out.println("The sales tax is $" + (totalGlassCost$ * taxPercent) + ". ");
        System.out.print("The cost of " + nEnvelopes + " boxes of envelopes at $" + envelopeCost$ + " each, is $" + totalEnvelopeCost$ + ". ");
        System.out.println("The sales tax is $" + (totalEnvelopeCost$ * taxPercent) + ". ");

        //print out the total costs
        System.out.println("The total cost of the purchases before tax is $" + (float)totalCost$ + ". The total sales tax is $" + finalTax + 
        ". The total cost of the purchases including sales tax is $" + (float)(totalCost$ + finalTax) + ". ");
    }
}