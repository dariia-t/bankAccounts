/***
 * Class to test the program with differnt types of bank accounts
 * @author Dariia Tyshchenko
 * @version 1.3
 * Date of creation: September 2, 2022
 * Last Date Modified: September 8, 2022
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Test {
    /***
	 * Main method to initialize the array of Bank accounts, assign the value to each bank account, sort, find and print the lists
	 * @param args
	 * no return value
	 */
    public static void main(String[] args){
        BankAccount[] accounts = new BankAccount[50];
        File file = new File("accounts.txt");
        try{
            Scanner readFile = new Scanner(file);
            for(int i=0;i<accounts.length;i++){
                accounts[i] = readFile.nextLine();
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }

        // asking user to select an operation
        while (true){
            System.out.print(String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                                "Select an operation:",
                                "1: View list of bank accounts",
                                "2: Search bank accounts by number",
                                "3: Add a new bank account",
                                "4: Remove an existing bank account",
                                "5: Sort bank accounts by account number",
                                "6: Exit",
                                "Your option: "));

            Scanner myScanner = new Scanner(System.in);
            int action = option(myScanner); 
            // performing an operation based on the user's choice
            switch (action){
                case 1:
                    System.out.print(String.format("%s\t\t%s\t\t%s\t\t\t\t%s\t\t%s\n", 
                                                    "Type",
                                                    "Number",
                                                    "Owner",
                                                    "Balance",
                                                    "Interest/Investment Type"));
                    printAccounts(accounts);
                    break;
                case 2:
                    System.out.print("Enter an amount: ");
                    int amount = amount(myScanner);
                    findAccounts(accounts, amount);
                    break;
                case 3:
                    sortAccounts(accounts, true);
                    printAccounts(accounts);
                    break;
                case 4:
                    sortAccounts(accounts, false);
                    printAccounts(accounts);
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("Thank you for using my program.");
                    return;
            }


        }
    }
	/***
	 * Method to validate the user's input when they select an operation
	 * @param myScanner
	 * @return an int that indicates the option selected by the user
	 */
    public static int option(Scanner myScanner){
        int action = 0;
        while (true){ 
            boolean goodData = myScanner.hasNextInt(); 
            if (!goodData){ 
                System.out.print("Not an integer! Try again: ");
                String garbage = myScanner.next(); 
                continue; 
            }
            else{ 
                action = myScanner.nextInt();
                boolean range = (action<=5 && action>=1); 
                if (!range){ 
                    System.out.print("Invalid operation (1 to 5). Try again: ");
                    continue; 
                }
                break; 
            }
        }
        return action;
    }
	/***
	 * Method to validate the user's input when they select an amount to find the accounts
	 * @param myScanner
	 * @return an amount the user wants to use to find the accounts
	 */
    public static int amount(Scanner myScanner){
        int money = 0;
        while (true){ 
            boolean goodData = myScanner.hasNextInt(); 
            if (!goodData){ 
                System.out.print("Not an integer! Try again: ");
                String garbage = myScanner.next();  
                continue; 
            }
            else{ 
                money = myScanner.nextInt(); 
                break; 
            }
        }
        return money;
    }
	/***
	 * Method to print an array of bank accounts
	 * @param list
	 * no return values
	 */
    public static void printAccounts(BankAccount[] list, int count){
        System.out.println(count);
    /*     for(int i=0; i<list.length; i++){
            System.out.println(list[i].toString());
        }*/
    }
	/***
	 * Method to find an account with the balance lower or equal to the one requested by user
	 * @param list, amount 
	 * @return an int that indicates how many accounts were found
	 */
    public static int findAccounts(BankAccount[] list, int count, long number){
        return -1;
    /*    int count = 0;
        for (int i=0; i<list.length; i++){
            if(list[i].getBalance()<=amount){
                System.out.println(list[i].toString());
                count+=1;
            }
        }
        System.out.println(count+ " bank accounts found.");
        return count; */
    }
	/***
	 * Method to sort the list of bank accounts by balance and by the owner name in alphabetical order
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public static void sortAccounts(BankAccount[] list, int count){
    /*     if (criterion == true){ // by balance
            for (int i=1; i<list.length; i++) {
                BankAccount currentVal = list[i];
                int j = i;
                while (j>0 && currentVal.getBalance()<(list[j - 1]).getBalance()){
                    list[j] = list[j - 1];
                    j--;
                }
                list[j] = currentVal;
            }
        }
        if (criterion == false){ //by owner
            for (int i=1; i<list.length; i++) {
                BankAccount currentVal = list[i];
                int j = i;
                while (j>0 && currentVal.getOwner().compareTo(list[j-1].getOwner())<0){
                    list[j] = list[j - 1];
                    j--;
                }
                list[j] = currentVal;
            }
        }*/
    } 
    public boolean checkAccountNumber(long number) throws InvalidAccountNumberException{
        if (number>=1000000000L && number<10000000000L){
            return true;
        }
        return false;
    }
}
