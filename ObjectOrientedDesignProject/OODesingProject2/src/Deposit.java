/**Strategy Pattern
 * A deposit operation for an Account */
public class Deposit implements AccountOperationsInterface{
    /** no-arg constructor */
	public Deposit(){
	}
	
	/** perform the deposit operation */
    public double execute(double value, double balance){
   	 return value + balance;
    }
}


