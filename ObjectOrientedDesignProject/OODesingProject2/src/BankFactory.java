/**Factory/Singleton Pattern 
 * Factory class for create bank objects */
public class BankFactory {
	//Declare and initialize variables
	private static BankFactory factory;
	
	/** no-arg constructor */
	private BankFactory(){
		
	}
	
	/** get the factory */
	public static synchronized BankFactory getFactory(){
		if (factory == null){
			factory = new BankFactory();
		}
		return factory;
	}
	
	/** factory method to create banks */
	public Bank createBanks(String bank){
		
		if (bank == "Bank Of America"){
			return BankOfAmerica.getBank();
		}else if (bank == "Fifth Third"){
			return FifthThird.getBank();
		}
		
		return null;
	}
}
