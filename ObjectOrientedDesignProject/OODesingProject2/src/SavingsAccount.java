/** Representation of a SavingsAccount */
public class SavingsAccount extends Account{
	public final static int MAX_WITHDRAWLS = 6; //max withdrawls allowed per month
	public final static double MIN_BALANCE = 5.00; //minimum balance allowed before fees occur
	
	private int numOfWithdrawls;
	
	/** no-arg constructor */
	public SavingsAccount(){
    	id = 0;
    	balance = 0;
    	annualInterestRate = 0;
    	numOfWithdrawls = 0;
	}
 	
	/** construct SavingsAccount with specified id and balance */
	public SavingsAccount(int id, double balance){
    	this.id = id;
    	this.balance = balance;
    	numOfWithdrawls = 0;
	}
	
	/** string representation of a SavingsAccount object */
	public String toString(){
		return "Savings Account:\n" +
				"Id: " + id +
				"\nBalance: " + balance + "\n";
	}
}
