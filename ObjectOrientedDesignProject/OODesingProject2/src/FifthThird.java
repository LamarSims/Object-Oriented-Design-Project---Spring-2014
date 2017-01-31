import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**Singleton Pattern
 * Class to represent Fifth Third bank */
public class FifthThird extends Bank{
	//Declare and initialize variables
	private static FifthThird fifthThird;
	private boolean eligible = false;
	
	/** no-arg constructor */
	private FifthThird() {
		name = "Fifth Third";
		identifiers = new ArrayList<ArrayList<String>>();
		savingsAccount = new ArrayList<Account>();
		checkingAccount = new ArrayList<Account>();
	}
	
	/** entry point to get the FifthThird object */
	public synchronized static Bank getBank(){
		if (fifthThird == null){
			fifthThird = new FifthThird();
		}
		return fifthThird;
	}

	/** evaluate personal information to determine if eligible to open a bank account*/
	void personalInformation() {
		//determine if eligible to open a bank account
	   	if (Integer.parseInt(info.get(1)) < 18){
	       	JOptionPane.showMessageDialog(null, "Sorry " + name + " but you are too young to open a bank account at " + this.name);
	       	return;
	   	}
	   	
	   	eligible = true; //eligible to open a bank account

	   	//create an access number for the bank account
	   	boolean valid = false;
	   	int accessNum = 0;

	   	do{
	       	accessNum = (int)(1000 + Math.random() * 8999);
	       	valid = true;

	       	//make sure accessNum has not already been chosen
	       	for (ArrayList<String> list : identifiers){
	           	if (Integer.parseInt(list.get(5)) == accessNum){
	               	valid = false;
	               	break;
	           	}
	       	}

	   	}while(!valid);

	   	//add the information into the ArrayList for temporary storage
       	info.add(String.valueOf(accessNum));
	}


	/** choose and create the account type */
	void chooseAccountType(int account) {
	   	if (!eligible) return; //if eligible is false exit method
	   	
	   	//create the account type
	   	switch(account){
	   	case 0: createChecking();
	       	break;
	   	case 1: createSavings();
	       	break;
	   	case 2: createChecking();
	           	createSavings();
	   	}
	   	
	    //display the account holder's information
       	String output = new String();
       	int i = 0;
    	for(String str: info){
    		switch(i){
    		case 0: output += "Name: " + str + "\n";
    			break;
    		case 1: output += "Age: " + str + "\n";
    			break;
    		case 2: output += "SSN: " + str + "\n";
    			break;
    		case 3: output += "Address: " + str + "\n";
    			break;
    		case 4: output += "Password: " + str + "\n";
    			break;
    		case 5: output += "Access Number: " + str + "\n";
    		}
    		i++;
    	}
    	JOptionPane.showMessageDialog(null, "Personal and Login Information\n" + output);

	   	//copy the info ArrayList into temp to be stored in the data field identifiers
	   	ArrayList<String> temp = new ArrayList<String>();
	   	for (String str: info){
	       	temp.add(str);
	   	}

	   	//add the information to identifiers
	   	identifiers.add(temp);
	   	info.clear(); //remove all the elements in info
	   	eligible = false;

	}

	
	/** create a checking account */
	private void createChecking(){
	   	//prompt for a balance to put in the account
	   	double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a balance for the checking account: "));

	   	//make sure balance is valid
	   	while (balance < 0){
	       	balance = Double.parseDouble(JOptionPane.showInputDialog(null, "The balance cannot be negative. Enter a balance for the checking account: "));
	   	}

	   	//create a new checking account, using the access number as the id, and add it to the checkingAccount ArrayList
	   	checkingAccount.add(new CheckingAccount(Integer.parseInt(info.get(5)), balance));
	}

	/** create a savings account */
	private void createSavings(){  	 
	   	//prompt for a balance to put in the account
	   	double balance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a balance for the savings account: "));
	   	
	   	//make sure balance is valid
	   	while (balance < SavingsAccount.MIN_BALANCE){
	       	balance = Double.parseDouble(JOptionPane.showInputDialog(null, "The balance must be equal to or greater than $" + SavingsAccount.MIN_BALANCE + ". Enter a balance for the savings account "));
	   	}

	   	//create a new savings account, using the access number as the id, and add it to the checkingAccount ArrayList
	   	savingsAccount.add(new SavingsAccount(Integer.parseInt(info.get(5)), balance));
	}


	/** evaluate access id for bank account */
	boolean accessId(int accessId) {
       	//evaluate the checking accounts for the specified access id, to see if access id is valid
       	for (Account checking: checkingAccount){
           	if (checking.getId() == accessId){
               	return true;
           	}
       	}
       	
       	//evaluate the savings accounts for the specified access id, to see if access id is valid
       	for (Account savings: savingsAccount){
           	if (savings.getId() == accessId){
               	return true;
           	}
       	}
	   	
       	JOptionPane.showMessageDialog(null, "Specified access number is not valid!");
       	return false;
	}

	/** evaluate password for bank account */
	boolean password(int accessId) {
	   	int i = 0; //sign in attempts
	   	String password = new String();
	   	JPasswordField pf = new JPasswordField();
	   	
	   	do{
	       	//prompt the user to provide their password for their bank account
	   		int option;
	       	if (i != 0){
	           	option = JOptionPane.showConfirmDialog(null, pf, "Invalid password specified for this account. Enter you password again: ",
	           			                              JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	       	}else{
	       		option = JOptionPane.showConfirmDialog(null, pf, "Enter you password: ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	       	}
	       	
	       	if (option == JOptionPane.OK_OPTION){
	       		password = String.valueOf(pf.getPassword());
	       		//evaluate the identifiers ArrayList for the specified password, to see if password is valid
		       	//and return the checking account
		       	for (ArrayList<String> str: identifiers){
		           	//check if the password specified is a valid password for an identifier and
		           	//check to make sure the access id and password match up for the identifier
		           	if (str.get(4).equals(password) && Integer.parseInt(str.get(5)) == accessId){
		               	return true;
		           	}
		       	}
	       	}else if (option == JOptionPane.CANCEL_OPTION){
	       		return false;
	       	}

	       	i++;
	   	}while((i <= 4));

       	JOptionPane.showMessageDialog(null, "You have reached your number of password login attempts.");
       	return false;
	}
}
