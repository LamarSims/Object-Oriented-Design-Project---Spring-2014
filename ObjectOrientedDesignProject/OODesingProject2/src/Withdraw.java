/** Strategy Pattern
 * 	A withdraw operation for an Account */
public class Withdraw implements AccountOperationsInterface{
    /** no-arg constructor */
	public Withdraw(){
	}
	
	/** perform the withdraw operation */
    public double execute(double value, double balance){
   	 return balance - value;
    }
}

