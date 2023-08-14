package Bankaccount;

import java.util.*;

     class Account {

        double balance = 0;

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance +=amount;
        }
        public boolean withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                return true;
            }
            else {
                return false;
            }
        }
    }

    class SavingsAccount extends Account {
        public void calculateInterest() {
            double rateOfInterest = 0.07;
            double interest = balance * rateOfInterest;

            deposit(interest);
        }

        public void process() {
            System.out.println("Account Type: Savings Account");
            Scanner scan = new Scanner(System.in);
            int option;

            do{
                System.out.println("Balance: " + getBalance());

                System.out.println("Select the Option:");
                System.out.println("1.Deposit");
                System.out.println("2.Withdraw");
                System.out.println("3. Exit");
                option = scan.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter amount to Deposit: ");
                        double depositAmount = scan.nextDouble();
                        deposit(depositAmount);
                        System.out.println("Deposited amount:" + getBalance());
                        break;
                    case 2:
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawAmount = scan.nextDouble();

                        if (withdraw(withdrawAmount)) {
                            System.out.println("Balance: " + getBalance());
                            calculateInterest();
                            System.out.println("Account Balance after Intrest:" + getBalance());
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 3:

                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }while(option != 3);
            scan.close();

        }
    }

     class CheckingAccount extends Account {

        public void process() {
            System.out.println("Account Type: Checking Account");
            Scanner scan = new Scanner(System.in);
            int option;
            do {
                System.out.println("Balance: " + getBalance());

                System.out.println("Select the Option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");

                option = scan.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("Enter the amount to Deposit: ");
                        double depositedAmount = scan.nextDouble();
                        deposit(depositedAmount);
                        System.out.println("Deposited amount: " + getBalance());
                        break;
                    case 2:
                        System.out.println("Enter the amount to withdraw: ");
                        double withdrawAmount = scan.nextDouble();
                        if (withdraw(withdrawAmount)) {
                            System.out.println("Balance: " + getBalance());
                            if (withdrawAmount > 50000) {

                                double feePer10000 = 5;
                                double amountExceedingLimit = withdrawAmount - 50000;
                                double num_of_10000s = amountExceedingLimit / 10000;
                                double fee = Math.floor(num_of_10000s) * feePer10000;
                                balance -= fee;
                                System.out.println("Balance after deduction: " + getBalance());
                            }
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (option != 3);
            scan.close();
        }
    }




     public class BAnk_acc{
        public static void main(String args[]) {

            System.out.println("Choose account type: \n 1.SavingsAccount \n 2.CheckingAccount ");
            Scanner scan = new Scanner(System.in);
            int accountType = scan.nextInt();


            if (accountType == 1) {
                SavingsAccount account = new SavingsAccount();
                account.process();
            } else if (accountType == 2) {
                CheckingAccount account = new CheckingAccount();
                account.process();
            } else {
                System.out.println("Invalid account type.");
            }
        }
    }



