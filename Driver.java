package main;

import java.util.Scanner;
import services.DenominationCalculator;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of currency denominations: ");
        int num_denominations = sc.nextInt();						//size of array
        int[] denominationsArray = new int[num_denominations];		//stores all the denominator values

        System.out.println("Enter the currency denominations value: ");
        for (int i = 0; i < num_denominations; i++) {
            denominationsArray[i] = sc.nextInt();

            while (denominationsArray[i] <= 0) {		//invalid denomination
                System.out.println("Denomination should be greater than 0. Please enter valid denomination");
                i--;
            }
        }

        System.out.println("Enter the amount you want to pay: ");
        int paymentAmount = sc.nextInt();

        int[][] paymentMethod = DenominationCalculator.checkPaymentApproach(denominationsArray, paymentAmount);	//solution

        if (paymentMethod[0][0] == -1) 		//check if solution is not possible
            System.out.println("Entered value is not possible!");
        else {								//solution is possible
            System.out.println("\nYour payment approach in order to give min no of notes will be: ");
            for (int i = 0; (i < num_denominations && paymentMethod[i][0] != 0); i++) {
                System.out.println(paymentMethod[i][0] + ":" + paymentMethod[i][1]);
            }
        }

        sc.close();
    }

}