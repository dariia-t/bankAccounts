/***
 * Class to model the entity Investment account
 * @author Dariia Tyshchenko
 * @version 0.8
 * Date of creation: September 2, 2022
 * Last Date Modified: September 8, 2022
 */
public class Investment extends BankAccount{
	// Data members    
    private String type;
	/***
	 * Constructor with three parameters
	 * @param	owner for the name of an owner of an investment account
	 * @param	balance for the balance on an investment account
	 * @param	type for the type on an investment account	 
     */
    public Investment (String owner, double balance, String type){
        super(owner, balance);
        this.type = type;
    }
    /***
    * Constructor with four parameters
    * @param	number for the account number of a investment account
    * @param	owner for the name of an owner of an investment account
    * @param	balance for the balance on an investment account
    * @param	type for the type on an investment account	 
    */
   public Investment (long number, String owner, double balance, String type){
       super(number, owner, balance);
       this.type = type;
   }
	/***
	 * Getter for the type of an investment account
	 * @param	no parameters
	 * @return	the value of the data member type
	 */
    public String getType() {
        return type;
    }
	/***
	 * Setter for the type of an investment account
	 * @param	type to set the data member type
	 * no return value
	 */
    public void setType(String type){
        this.type = type;
    }
	/***
	 * Method to add or subtract the profit or loss on the investment 
	 * @param no parameters
	 * @return the value of the monthly profit/loss
	 */
    public double applyRisk (){
        double profit = (Math.random()*0.04+0.01)*balance; 
        double probability = Math.random();
        if (probability<0.5){
            balance-=profit;
            return -profit;
        }
        else {
            balance+=profit;
            return profit;
        }
    }
	/***
	 * Method to get the Investment Account information
	 * no parameters
	 * @return formatted string containing the value of the data members
	 */
    public String toString(){
        String str = String.format("%s\t","Investment");
        str += super.toString();
        str += type;
        return str;
    }
	/***
	 * Method to get the Investment Account information, writes to the file after running the program
	 * no parameters
	 * @return formatted string containing the attributes
	 */	
	public String simpleString(){
		return "null";
	}
}