/***
 * Class to test the program with differnt types of bank accounts
 * @author Dariia Tyshchenko
 * @version 0.3
 * Date of creation: September 19, 2022
 * Last Date Modified: September 21, 2022
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class BankManager {
    // Data members 
    static Scanner myScanner = new Scanner(System.in);
    static Bank bank1 = new Bank("accounts.txt");
    /***
     * Main method to test the operations in the Bank 
     * @param args
     * no return value
     */
    public static void main(String[] args){
        
        boolean running = true;
        int action = 0;
        while(running == true){
            System.out.print(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                        "Select an operation:",
                        "1: view all accounts",
                        "2: manage account",
                        "3: add new account",
                        "4: remove account",
                        "5: sort accounts by balance",
                        "6: view closable accounts",
                        "7: exit",
                        "Your option: "));

            boolean goodSelection=false;
            while (goodSelection==false){  
                try{
                    action = myScanner.nextInt(); 
                    if (action>7 || action<1){
                        throw new Exception("Enter an integer from 1 to 7!\nTry again: ");
                    }
                    goodSelection=true;
                }            
                catch(InputMismatchException e){
                    System.out.print("Invalid input! Enter an integer: ");
                    myScanner.nextLine();
                    continue;
                }
                catch (Exception excpt) {
                    System.out.print(excpt.getMessage());
                    myScanner.nextLine();
                    continue;
                } 
            }
            // performing an operation based on the user's choice
            switch (action){
                case 1:
                    bank1.viewAll();
                    break;
                case 2:
                    managing();
                    break;
                case 3: // add a new account 
                    adding();
                    break;
                case 4:
                    removing();
                    break;
                case 5:
                    bank1.sort();
                    break;
                case 6:
                    bank1.viewClosable();
                    break;
                case 7:
                    bank1.saveAccounts("accounts.txt");
                    System.out.println("Thank you for using my banking program");
                    running = false;
            }//end of switch 
        }// end of the while loop 
    }// end of the main method
    /***
     * Method to manage a chosen account
     * no parameters
     * no return values
     */
    public static void managing(){
        boolean run = false;
        long number=0;
        while (run==false){
            try{
                System.out.print("Enter an account number: ");
                number =myScanner.nextLong(); 
                checkAccountNumber(number);
                if (bank1.find(number)==null){
                    System.out.println("Account number not found");
                    continue;
                } 
                else{
                    BankAccount managed = bank1.find(number);
                    boolean running = true;
                    int action = 0;
                    while(running == true){
                        System.out.print(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                                    "Select an operation:",
                                    "1: view balance",
                                    "2: withdraw",
                                    "3: deposit",
                                    "4: apply monthly interest",
                                    "5: apply investment risk",
                                    "6: return to main menu",
                                    "Your option: "));

                        boolean goodSelection=false;
                        while (goodSelection==false){  
                            try{
                                action = myScanner.nextInt(); 
                                if (action>6 || action<1){
                                    throw new Exception("Enter an integer from 1 to 6!\nTry again: ");
                                }
                                goodSelection=true;
                            }            
                            catch(InputMismatchException e){
                                System.out.print("Invalid input! Enter an integer: ");
                                myScanner.nextLine();
                                continue;
                            }
                            catch (Exception excpt) {
                                System.out.print(excpt.getMessage());
                                myScanner.nextLine();
                                continue;
                            } 
                        }
                        // performing an operation based on the user's choice
                        switch (action){
                            case 1: //view balance
                                System.out.println(String.format("Balance = $%.2f", managed.getBalance()));
                                break;
                            case 2: // withdraw
                                withdrawing(managed);
                                break;
                            case 3: //deposit
                                depositing(managed);
                                break;
                            case 4: // apply monthly interest
                                applyMI(managed);
                                break;
                            case 5: // apply investment risk
                                applyIR(managed);
                                break;
                            case 6: // return to main menu 
                                running = false;
                        }//end of switch 
                    }

                }   //end of else 
                run=true;
            }
            catch(InvalidAccountNumberException e){
                System.out.println(e.getMessage());
               // myScanner.next();
                continue;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                myScanner.next();
                continue;
            }
        }
    }
    /***
     * Method to apply risk to the account
     * @param ba for the bank account
     * no return values
     */
    private static void applyIR(BankAccount ba){
        if (ba.toString().contains("Investment")==true){
            Investment i = (Investment) ba;
            String str ="Risk applied successfully. The amount $";
            double change = i.applyRisk();
            if (change>=0){
                str+= String.format("%.2f", change);
                str+=" was added to your account.";
            }
            else{
                str+= String.format("%.2f", -change);
                str+=" was withdrawn from your account.";
            }
            System.out.println(str);
        }
        else{
            System.out.println("Invalid operation. Your account is not an investment account");
        }
    }
    /***
     * Method to apply interest rate to the account
     * @param ba for the bank account
     * no return values
     */
    private static void applyMI(BankAccount ba){
        if (ba.toString().contains("Savings")==true){
            Savings s = (Savings) ba;
            String str ="Interest rate applied. The amount $";
            str+= String.format("%.2f", s.applyInterest());
            str+=" added to your balance.";
            System.out.println(str);

        }
        else{
            System.out.println("Invalid operation. Your account is not a savings account");
        }
    }
    /***
     * Method to deposit to the account
     * @param ba for the bank account
     * no return values
     */
    private static void depositing(BankAccount ba){
        boolean run = false;
        while (run==false){
            try{
                System.out.print("Enter the amount: ");
                double amount = myScanner.nextDouble(); 
                ba.deposit(amount);
                String str = "New balance: ";
                str+=String.format("%.2f",ba.getBalance());
                System.out.println(str);
                run=true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                myScanner.next();
                continue;
            }
        }
    }
    /***
     * Method to withdraw from the account
     * @param ba for the bank account
     * no return values
     */
    public static void withdrawing(BankAccount ba){
        boolean run = false;
        while (run==false){
            try{
                System.out.print("Enter the amount: ");
                double amount = myScanner.nextDouble(); 
                if (ba.withdraw(amount)==false){
                    System.out.println("Withdrawal failed. You do not have enough balance.");
                } 
                else{
                    String str = "Successful withdrawal. New balance: ";
                    str+=String.format("%.2f",ba.getBalance());
                    System.out.println(str);
                }
                run=true;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                myScanner.next();
                continue;
            }
        }
    }
    /***
     * Method to add an account
     * no parameters
     * no return values
     */
    public static void adding(){
        boolean case3=false;
        while (case3==false){
            try{
                myScanner.nextLine();
                System.out.print("Enter bank account type (Checking/Savings/Investment): ");
                String accountType = myScanner.nextLine();
                System.out.print("Enter name of the owner (first name and last name): ");
                String name = myScanner.nextLine();
                System.out.print("Enter the balance: ");
                double balance = myScanner.nextDouble();
                switch(accountType){
                    case "Checking":
                        BankAccount additionC = new Checking(name, balance);
                        bank1.add(additionC);
                        break;
                    case "Savings":
                        boolean s1=false;
                        while(s1==false){
                            try{
                                myScanner.nextLine(); 
                                System.out.print("Enter the yearly interest rate: ");
                                double yInterestRate = myScanner.nextDouble();
                                BankAccount additionS = new Savings(name, balance, yInterestRate);
                                bank1.add(additionS);
                                s1=true;
                            }
                            catch(InputMismatchException e){
                                System.out.println("Invalid input for the yearly interest rate. Try again!");
                                myScanner.next();
                                continue;
                            } 
                        }
                        break;
                    case "Investment":
                        boolean s2=false;
                        while(s2==false){
                            try{
                                myScanner.nextLine();
                                System.out.print("Enter the investment type (Growth/Property/Shares): ");
                                String type = myScanner.next();
                                if (investmentType(type)==false){
                                    throw new Exception("The type must be Growth/Property/Shares\n");
                                }
                                else{
                                    BankAccount additionI = new Investment(name, balance, type);
                                    bank1.add(additionI);
                                    s2=true;
                                }
                            }
                            catch (Exception excpt) {
                                System.out.print(excpt.getMessage());
                                //myScanner.nextLine();
                                continue;
                            }  
                        }
                        break;
                    default:
                        System.out.println("The type of the bank account is incorrect. Please try again!");
                        continue;
                }
                case3=true;
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input. Try again!");
               // myScanner.nextLine();
                continue;
            }  
            catch (Exception excpt) {
                System.out.print(excpt.getMessage());
                myScanner.nextLine();
                continue;
            } 
        }
    }
    /***
     * Method to remove an account
     * no parameters
     * no return values
     */
    public static void removing(){
        boolean run = false;
        while (run==false){
            try{
                System.out.print("Enter an account number: ");
                long number =myScanner.nextLong(); 
                checkAccountNumber(number);
                if (bank1.remove(number)==true){
                    System.out.println("Bank account removed");
                } 
                else{
                    System.out.println("Account number not found");
                    continue;
                }
                run=true;
            }
            catch(InvalidAccountNumberException e){
                System.out.println(e.getMessage());
               // myScanner.next();
                continue;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input");
                myScanner.next();
                continue;
            }
        }
    }
    /***
     * Method to check if investment type entered by the user is valid
     * @param type for the type entered
     * @return boolean that indicates if the tpe is valid 
     */
    public static boolean investmentType(String type){
        boolean rightType = false;
        switch (type){
            case "Growth":
                rightType=true;
                break;
            case "Property":
                rightType=true;
                break;
            case "Shares":
                rightType=true;
                break;
        }
        return rightType;
    }
    /***
     * Method to check if account number is within the range
     * @param number 
     * @return boolean true or false to ibdicate if within the range
     */
    public static boolean checkAccountNumber(long number) throws InvalidAccountNumberException{
        String n = String.valueOf(number);
        if (n.length()==10){
            return true;
        }
        else{
            throw new InvalidAccountNumberException("Invalid Account Number (must be 10 digits)");
        }
    }
}// end of class 
