/***
 * Class to model the entity Bank 
 * @author Dariia Tyshchenko
 * @version 0.3
 * Date of creation: September 19, 2022
 * Last Date Modified: September 21, 2022
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Bank {
    // Data members 
    private BankAccount accounts[];
    private int count;
    /***
    * Constructor with one parameter
    * @param	filename for the name of the file
    */
    public Bank(String filename){
        this.accounts = new BankAccount[100];
        readAccounts(filename);
    }
    /***
    * Method that reads the accounts from the file
    * @param	filename for the name of the file
    * no return value
    */
    private void readAccounts(String filename){
        File file = new File(filename);
        try{
            Scanner readFile = new Scanner(file);
            while(readFile.hasNextLine()){
                if (count<accounts.length){
                    String a = readFile.nextLine();
                    String[] elements = a.split("\\|");
                    switch (elements[0]){
                        case "Checking":
                            accounts[count] = new Checking(Long.valueOf(elements[1]), elements[2], Double.valueOf(elements[3]));
                            break;
                        case "Savings":
                            accounts[count] = new Savings(Long.valueOf(elements[1]), elements[2], Double.valueOf(elements[3]), Double.valueOf(elements[4]));
                            break;
                        case "Investment":
                            accounts[count] = new Investment(Long.valueOf(elements[1]), elements[2], Double.valueOf(elements[3]), elements[4]);
                            break;
                    }
                    count +=1;
                }
            }
            readFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
    }
    /***
     * Method to find an account with the balance lower or equal to the one requested by user
     * @param number, account number  
     * @return a BankAccount with the respective bank account number 
     */
    public BankAccount find(long number){
        for (int i=0; i<count; i++){
            if(accounts[i].getNumber()== number){
                return accounts[i];
            }
        }
        return null;
    }
    /***
    * Method that adds a bank account to the bank 
    * @param	ba for bank account
    * @return boolean to indicate if the account was added 
    */
    public boolean add(BankAccount ba){
        boolean success = false;
        if(count<accounts.length){
            accounts[count]=ba;
            System.out.println("Bank account added");
            count+=1;
            success=true; 
        }
        return success;
    }
    /***
    * Method that removes a bank account to the bank 
    * @param	number for the bank account number 
    * @return boolean to indicate if the account was removed  
    */
    public boolean remove(long number){
        boolean success = false;
        BankAccount removed = find(number);
        if (removed!=null){
            int index = 0;
            for (int i = 0; i <count; i++) {
                if (accounts[i]==removed){
                    index = i;
                }
            }
            for (int i = index; i <count; i++) {
                accounts[i] = accounts[i + 1];
            }
            count -=1;
            success = true;
        }
        return success; 
    }
    /***
     * Method to print an array of bank accounts
     * no parameters
     * no return values
     */
    public void viewAll(){
        System.out.println("Type\t\tNumber\t\tOwner\t\t\t\tBalance\t\tInterest/Investment Type");
        for(int i=0; i<count; i++){
            System.out.println(accounts[i].toString());
        }
    }
    /***
     * Method to  view the acounts with balance below 200
     * no parameters
     * no return values
     */
    public void viewClosable(){
        int j=0;
        for(int i=0; i<count; i++){
            if (accounts[i].isClosable()==true){
                System.out.println(accounts[i].toString());
                j++;
            }
        }  
        System.out.println(j+" closable accounts found");       
    }
    /***
     * Method to sort the accounts by balance 
     * no parameters
     * no return values
     */
    public void sort(){
        java.util.Arrays.sort(accounts, 0, count);
    }
    /***
     * Method to save accounts to the file
     * @param filename for the name of the file
     * no return values
     */
    public void saveAccounts(String filename){
        File file = new File(filename);
        try{
            PrintWriter writeFile = new PrintWriter(file);
            for(int i=0;i<count;i++){
                writeFile.print(accounts[i].simpleString());
            }
            writeFile.close();
        }
        catch(FileNotFoundException e){
            System.out.println("File is not found");
        }
    }
}
