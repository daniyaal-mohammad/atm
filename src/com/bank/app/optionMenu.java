package com.bank.app;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class optionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###, ##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException{
        int x  =1;

        do{
            try{
                data.put(9876543, 1234);
                data.put(8989898, 5678);

                System.out.println("welcome to the ATM project!");
                System.out.println("Enter Your Customer Number :");

                SetCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number :");

                setPinNumber(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("\n" +"invalid characters.only numbers"+"\n");
                x=2;
            }
            for(Map.Entry<Integer, Integer> entry: data.entrySet()){
                if(entry.getKey()==getCustomerNumber() && entry.getValue()==getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n"+"Wrong customer Number or Pin Number"+"\n" );

        }while (x==1);
    }
    public void getAccountType(){
        System.out.println("Select the Account you want to access :");
        System.out.println("Type-1 Checking Account");
        System.out.println("Type-2 Saving Account");
        System.out.println("Exit");
        System.out.println("choice :");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thanku for using the ATM . BYE");
                break;
            default:
                System.out.println("\n"+"Invalid choice."+"\n");
                getAccountType();
        }
    }
    public void getChecking(){
        System.out.println("Checking Account :");
        System.out.println("type 1 -View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice :");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thanku for using ATM . Bye");
                break;
            default:
                System.out.println("\n"+"Invalid Choice "+"\n");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.println("Saving Account");
        System.out.println("Type 1- view Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice : ");

        selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("saving Account Balance: "+moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thanku for using Atm. Bye");
                break;
            default:
                System.out.println("\n"+"Invalid Choice :"+"\n");
        }
    }
    int selection;
}
