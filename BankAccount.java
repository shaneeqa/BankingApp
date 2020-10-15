package BankingApp;

import java.util.Scanner;

class BankAccount{
    int amount;
    int balance;
    int previousTransactionAmount;

    void checkBalance(){
        System.out.println("Current Balance: "+balance);

    }

    void deposit(int amount){
        if(amount> 0){
            balance += amount;
            System.out.println("You have deposited "+ amount + " to your account.");
            checkBalance();
            previousTransactionAmount = amount;
        }

    }

    void withdraw(int amount){
        if(amount > 0){
            if(balance >= amount){
                balance-= amount;
                System.out.println("You have withdrawn "+ amount + " from your account.");
                checkBalance();
                previousTransactionAmount = -amount;
            }
            else {
                System.out.println("Sorry, insufficient balance to withdraw. Your ");
                checkBalance();
            }
        }
    }

    void previousTransaction(){
        if(previousTransactionAmount > 0){
            System.out.println("DEPOSIT: " + previousTransactionAmount);
        } else if(previousTransactionAmount < 0){
            System.out.println("WITHDRAWN: " + previousTransactionAmount);
        } else {
            System.out.println("You have no transactions");
        }
    }

    void showMenu(){
        char selectedOption;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Select an option");
            System.out.println("1: Check Balance");
            System.out.println("2: Deposit");
            System.out.println("3: Withdraw");
            System.out.println("4: Check Previous Transaction");
            System.out.println("5: Exit");
            selectedOption = scanner.next().charAt(0);

            switch (selectedOption){
                case '1':
                    checkBalance();
                    break;

                case '2':
                    System.out.println("Enter Deposit Amount");
                    amount = scanner.nextInt();
                    deposit(amount);
                    break;

                case '3':
                    System.out.println("Enter Amount to Withdraw");
                    amount = scanner.nextInt();
                    withdraw(amount);
                    break;

                case '4':
                    previousTransaction();
                    break;

                default:
                    System.out.println("Invalid Option Entered");
            }
        } while (selectedOption != '5');

        System.out.println("Thanks for visiting");



    }


}
