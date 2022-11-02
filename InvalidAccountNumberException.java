import java.util.InputMismatchException;

public class InvalidAccountNumberException extends InputMismatchException{
    /***
     * No-arg constructor
     * 
     * @param no parameters
     * no return
     */
    public InvalidAccountNumberException(){
        super("Invalid account number.");
    }
    /***
     * Constructor with one parameter
     * 
     * @param message for the message of the Exception
     * no return
     */
    public InvalidAccountNumberException(String message){
        super(message);
    }
}
