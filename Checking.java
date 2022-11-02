/***
 * Class to model the entity Checking account
 * @author Dariia Tyshchenko
 * @version 0.3
 * Date of creation: September 19, 2022
 * Last Date Modified: September 21, 2022
 */
public class Checking extends BankAccount {
	/***
	 * Constructor with two parameters
	 * @param	owner for the owner of a checking account
	 * @param	balance for the balance on the checking account
	 */   
    public Checking (String owner, double balance) {
        super(owner, balance);
    }
	/***
	 * Constructor with three parameters
	 * @param	number for the account number of a checking account
	 * @param	owner for the name of an owner of a checking account
	 * @param	balance for the balance on a checking account
	 */
	public Checking(long number, String owner, double balance){
        super(number, owner, balance);		
	}
	/***
	 * Method to get the Checking account information
	 * no parameters
	 * @return formatted string containing the name of the account
	 */
    public String toString(){
        String str = String.format("%s\t","Checking");
        str += super.toString();
        return str;
    }
	/***
	 * Method to get the Checking Account information, writes to the file after running the program
	 * no parameters
	 * @return formatted string containing the attributes
	 */	
	public String simpleString(){
		String str = "Checking|";
        str += super.simpleString();
        str += "\n";
        return str;
	}

}