import java.util.Date;
import java.util.ArrayList;
/** Account class for a representation of a bank account */
public abstract class Account {
    //declare and initialize variables 
	public static double LIMIT = -30.00; //overdraft limit
    protected AccountOperationsInterface operation;
    protected int id;
	protected double balance;
	protected double annualInterestRate;
	protected Date dateCreated;

	/** return the id for this Account */
	public int getId(){
    	return this.id;
	}
   
	/** return the balance for this Account */
	public double getBalance(){
    	return this.balance;
	}

	/** return the annual interest rate for this Account */
	public double getAnnualInterestRate(){
    	return this.annualInterestRate;
	}

	/** return a string representation of the data this Account was created */
	public String getDateCreated(){
    	return this.dateCreated.toString();
	}

	/** set the id for this Account */
	public void setId(int id){
    	this.id = id;
	}

	/** set the balance for this Account */
	public void setBalance(double balance){
    	this.balance = balance;
	}

	/** set the annual interest rate for this Account */
	public void setAnnualInterestRate(double annualInterestRate){
    	this.annualInterestRate = annualInterestRate;
	}

	/** return the monthly interest rate for this Account */
	public double getMonthlyInterestRate(){
    	return this.annualInterestRate / 1200;
	}

	/** Strategy Pattern: set the account operation to be used */
   	public void setOperation(AccountOperationsInterface operation){
   		this.operation = operation;
  	}

   	/** deposit a specified amount into this Account */
	public void deposit(double amount){
    	this.balance  = this.operation.execute(amount, this.balance);
	}

	/** withdraw a specified amount from this Account */
	public void withdraw(double amount){
		if (this.balance <= Account.LIMIT) return; //check for overdraft
    	this.balance = this.operation.execute(amount, this.balance);
	}

}


