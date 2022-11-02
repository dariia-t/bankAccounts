/***
 * Class to model the entity Savings account
 * @author Dariia Tyshchenko
 * @version 0.6
 * Date of creation: September 2, 2022
 * Last Date Modified: September 8, 2022
 */
public class Savings extends BankAccount {
	// Data members
    private double YearlyInterestRate;
	/***
	 * Constructor with three parameters
	 * @param	owner for the name of an owner of a savings account
	 * @param	balance for the balance on a savings account
	 * @param	yInterestRate for the yearly interst rate on the savings 
     */
    public Savings (String owner, double balance, double yInterestRate){
        super(owner, balance);
        YearlyInterestRate = yInterestRate;
    }
	/***
	 * Constructor with four parameters
	 * @param	number for the account number of a savings account
	 * @param	owner for the name of an owner of a savings account
	 * @param	balance for the balance on a savings account
	 * @param	yInterestRate for the yearly interst rate on the savings 
     */
    public Savings (long number, String owner, double balance, double yInterestRate){
        super(number, owner, balance);
        YearlyInterestRate = yInterestRate;
    }
	/***
	 * Getter for the yearly interest of a savings account
	 * @param	no parameters
	 * @return	the value of the data member YearlyInterestRate
	 */
    public double getYearlyInterest (){
        return YearlyInterestRate;
    }
	/***
	 * Getter for the monthly interest of a savings account
	 * @param	no parameters
	 * @return	the value of the monthlyInterestRate
	 */
    public double getMontlyInterest(){
        double monthlyInterest = (YearlyInterestRate/12)/100;
        return monthlyInterest;
    }
	/***
	 * Setter for the yearly interest of a savings account
	 * @param	y to set the data member YearlyInterestRate
	 * no return value
	 */
    public void setYearlyInterest(double y){
        YearlyInterestRate = y;
    }
	/***
	 * Method to add the monthly interst to the balance on the account
	 * @param no parameters
	 * @return the value of the monthly profit 
	 */
    public double applyInterest(){
        double monthlyProfit = getMontlyInterest()*balance;
        balance+=monthlyProfit;
        return monthlyProfit;
    }
	/***
	 * Method to get the Savings Account information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        String str = String.format("%s\t","Savings\t");
        str += super.toString();
        str += String.format("%-10.2f", YearlyInterestRate);
        return str;
    }
	/***
	 * Method to get the Savings Account information, writes to the file after running the program
	 * no parameters
	 * @return formatted string containing the attributes
	 */	
	public String simpleString(){
		return "null";
	}
}