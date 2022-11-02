/***
 * Class to model the entity Bank account
 * @author Dariia Tyshchenko
 * @version 0.3
 * Date of creation: September 19, 2022
 * Last Date Modified: September 21, 2022
 */
public abstract class BankAccount implements Comparable<BankAccount>,
											 Closable{
    // Data members
    private long number;
    private String owner;
    protected double balance;
	/***
	 * Constructor with two parameters
	 * @param	owner for the name of an owner of a bank account
	 * @param	balance for the balance on a bank account
	 */
    protected BankAccount(String owner, double balance){
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
	protected BankAccount(long number, String owner, double balance){
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
        String str;
        str = String.format("%d|%s|%.2f|",
                number, owner, balance);
        return str;
	}
    /***
	 * Method to compare the balance of the bank accounts 
	 * @param ba which is the bank account that is being compared
	 * @return an int that indicates if balance is greater, smaller or the same
	 */
    public int compareTo(BankAccount ba){
        if(this.getBalance()==ba.getBalance()){
            return 0;
        }
        else if(this.getBalance()>ba.getBalance()){
            return 1;
        }
        else{
            return -1;
        }
    }
    /***
	 * Method to indica if the balance of the bank account is below 200 
	 * no parameters 
	 * @return a boolean that is true if balance is less than 0
	 */
    public boolean isClosable(){
        if (balance<200){
            return true;
        }
        return false;
    }
}

