import java.util.ArrayList;

/** Representation for a bank */
public abstract class Bank {
	//Declare and initialize variables
	protected String name = "Bank";
	protected ArrayList<String> info = new ArrayList<String>();
	protected ArrayList<ArrayList<String>> identifiers;
	protected ArrayList<Account> savingsAccount;
	protected ArrayList<Account> checkingAccount;
	
	/** return this Bank's name */
	public String getName(){
		return name;
	}
	
	/** add a savings account to this Bank */
	public void addSavingsAccount(Account savingsAccount){
		this.savingsAccount.add(savingsAccount);
	}
	
	/** add a checking account to this Bank */
	public void addCheckingAccount(Account checkingAccount){
		this.checkingAccount.add(checkingAccount);
	}
	
	/** return a checking account in this Bank */
	public Account getCheckingAccount(int accessId){
		for (Account check: checkingAccount){
			if (check.getId() == accessId){
				return check;
			}
		}
		return null;
	}
	
	/** return a savings account in this Bank */
	public Account getSavingsAccount(int accessId){
		for (Account sav: savingsAccount){
			if (sav.getId() == accessId){
				return sav;
			}
		}
		return null;
	}
	
	/** method to add an element to info */
	public void add(String string){
	   	info.add(string);
	}

	/** get return the elements stored in info */
	public void getInfo(){
	   	for (String str: info){
	       	System.out.println(str);
	   	}
	}
	
	/**Template method pattern 
	 * opens a bank account */
	public final void openBankAccount(int account){
		personalInformation();
		chooseAccountType(account);
	}
	
	abstract void personalInformation(); /** evaluate personal information to determine if eligible to open a bank account*/
	abstract void chooseAccountType(int account); /** choose and create the account type */
	
	/**Template method pattern 
	 * sign into a bank account */
	public final boolean signIn(int accessId){
		//Account savings = null;
		//Account checking = null;
		//int accessId = accessId();
		
		//if the access id is not zero then the access id is valid
		//and now the password needs to be evaluated
		if (accessId(accessId)){
			//evaluate password
			if (password(accessId)){
				return true;
				//get the savings and/or checking accounts associated with with the access id
				/*for (Account sav: savingsAccount){
					if (sav.getId() == accessId){
						savings = sav;
						break;
					}
				}
				
				for (Account check: checkingAccount){
					if (check.getId() == accessId){
						checking = check;
						break;
					}
				}
				
				//get the name of the account holder and display their accounts
				String name = new String();
				for (ArrayList<String> str: identifiers){
					if (Integer.parseInt(str.get(5)) == accessId){
						name = str.get(0);
						break;
					}
				}
				
				if (checking == null){
					System.out.println("\nWelcome: " + name + "\n" + savings);
				}else if (savings == null){
					System.out.println("\nWelcome: " + name + "\n" + checking);
				}else{
					System.out.println("\nWelcome: " + name + "\n" + checking + "\n" + savings);
				}*/
				
			}
		}
		return false;
	}
	
	abstract boolean accessId(int accessId); /** evaluate access id for bank account */
	abstract boolean password(int accessId); /** evaluate password for bank account */
}

