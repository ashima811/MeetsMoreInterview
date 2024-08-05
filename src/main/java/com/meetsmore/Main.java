package com.meetsmore;

import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Welcome to the 7-eleven");
        int billingAmount=getBillingAmount(scanner);
         int amountToInsert=getInsertionAmount(scanner);

         int amountToWithdraw= amountToInsert-billingAmount;
            if (withdrawal(amountToWithdraw)) {
                getRemainingAmountFromMachine(amountToWithdraw);
            }

    }
    private static final int[] NOTES_DENOMINATION= {10000,5000,2000,1000};
    private static final int[] COINS_DENOMINATION= {500,100,50,10,5,1};
    static int machineBalance=50000;

    private static int getInsertionAmount(Scanner scanner){
        System.out.println("Enter the amount of money inserted into the ATM");
        return scanner.nextInt();
    }

    private static int getBillingAmount(Scanner scanner){
        System.out.println("Enter the amount to deduct");
        return scanner.nextInt();
    }
    private static void getRemainingAmountFromMachine(int amount){
        int remainingAmount=amount;
        if(remainingAmount<0) {
            System.out.println("Insert money is not sufficient");
        }
        System.out.println("Dispensing the following notes");
        for(int denomination : NOTES_DENOMINATION){pwd
            if(remainingAmount==0)
                break;
            int numberOfNotes= remainingAmount/denomination;
            if(numberOfNotes>0)
            {
                System.out.println("yen  "+denomination+ " ::  "+numberOfNotes+ "  notes");
                remainingAmount%=denomination;
            }
        }
        if(remainingAmount>0){
            for (int denomination : COINS_DENOMINATION)
            {
                int numberofCoins= remainingAmount/denomination;
                if(numberofCoins>0)
                {
                    System.out.println("yen  "+denomination+" ::  "+ numberofCoins+ "  coins");
                    remainingAmount%=denomination;
                }
            }
        }
    }

    private static boolean withdrawal(int amount){
        if (amount>machineBalance)
        {
            System.out.println("Can not dispense the exact amount due to Insufficient balance in the machine, your remaining amount:: "+ amount);
            return false;
        }
        else {
            System.out.println("Withdrawing Amount:: "+ amount);
            return true;
        }
    }


}