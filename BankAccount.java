/***
 * Class to model the entity Bank account
 * @author Dariia Tyshchenko
 * @version 0.6
 * Date of creation: September 2, 2022
 * Last Date Modified: September 8, 2022
 */
public class BankAccount {
    // Data members
    private long number;
    private String owner;
    protected double balance;
	/***
	 * Constructor with two parameters
	 * @param	owner for the name of an owner of a bank account
	 * @param	balance for the balance on a bank account
	 */
    public BankAccount(String owner, double balance){
        long accNumber = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
        this.number = accNumber;
        this.owner = owner;
        this.balance = balance;
    }
	/***
	 * Constructor with three parameters
	 * @param	number for the account number of a bank account
	 * @param	owner for the name of an owner of a bank account
	 * @param	balance for the balance on a bank account
	 */
	public BankAccount(long number, String owner, double balance){
        this.number = number;
        this.owner = owner;
        this.balance = balance;		
	}
	/***
	 * Getter for the number of a bank account
	 * @param	no parameters
	 * @return	the value of the data member number
	 */
    public long getNumber(){
        return number;
    }
	/***
	 * Getter for the name of the owner of a bank account
	 * @param	no parameters
	 * @return	the value of the data member owner
	 */
    public String getOwner(){
        return owner;
    }
	/***
	 * Getter for the balance of a bank account
	 * @param	no parameters
	 * @return	the value of the data member balance
	 */
    public double getBalance(){
        return balance;
    }
	/***
	 * Method to deposit money on a bank account
	 * @param amount
	 * no return values
	 */
    public void deposit(double amount){
		balance+=amount;
    }
	/***
	 * Method to withdraw money from a bank account
	 * @param amount
	 * @return a boolean that indicates if operation is possible
	 */
    public boolean withdraw(double amount){
		if (balance>=amount){
			balance-=amount;
			return true;
		}
        else{
			return false;
		}
    }
	/***
	 * Method to get the Bank Account information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        return String.format("%-10d\t%-30s\t%-10.2f\t",number, owner, balance);
    }
	/***
	 * Method to get the Bank Account information, writes to the file after running the program
	 * no parameters
	 * @return formatted string containing the attributes
	 */	
	public String simpleString(){
		return "null";
	}
}