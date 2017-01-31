/** Representation of a CheckingAccount */
public class CheckingAccount extends Account{	
	/** no-arg constructor */
	public CheckingAccount(){
    	id = 0;
    	balance = 0;
    	annualInterestRate = 0;
	}
 	
	/** construct CheckingAccount with specified id and balance */
	public CheckingAccount(int id, double balance){
    	this.id = id;
    	this.balance = balance;
	}
	
	/** string representation of a CheckingAccount object */
	public String toString(){
		return "Checking Account:\n" +
				"Id: " + id +
				"\nBalance: " + balance + "\n";
	}
}
