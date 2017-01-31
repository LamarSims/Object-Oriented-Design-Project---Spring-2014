import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener{
	private String[] info = new String[5];
	private int loginID;

	private JTextField IDNumber;
	private JTextField nameTF = new JTextField(10);
	private JTextField ageTF = new JTextField(10);
	private JTextField ssnTF = new JTextField(10);
	private JTextField addressTF = new JTextField(10);
	
	private JTextArea textArea = new JTextArea();
	
	private JPasswordField Password;
	private JPasswordField passTF = new JPasswordField(15);

	private JRadioButton boaRB;
	private JRadioButton fifthThirdRB;
	private JRadioButton boaRB2 = new JRadioButton("Bank Of America");
	private JRadioButton fifthThirdRB2 = new JRadioButton("Fifth & Third");

	private  JRadioButton Checking = new JRadioButton("Checking");
	private  JRadioButton Saving = new JRadioButton("Saving");

	private BankFactory factory = BankFactory.getFactory();

	private Bank bankOfAmerica = factory.createBanks("Bank Of America");
	private Bank fifthThird = factory.createBanks("Fifth Third");
	private Account checking = new CheckingAccount();
	private Account savings = new SavingsAccount();

	public GUI() {
	   	super(new GridLayout());
	   	JTabbedPane tabbedPane = new JTabbedPane();
	  	// ImageIcon icon = createImageIcon("images/middle.gif");
	
	   	JComponent panel_1a = makeTextPanel("Bank of America");
	   	panel_1a.setLayout(null);
	   	panel_1a.setPreferredSize(new Dimension(410,200));
	   	tabbedPane.addTab("Sign In", null, panel_1a, "Does nothing");
	
	   	JLabel Number = new JLabel("ID Number");
	   	Number.setBounds(20,10,100,20);
	
	   	IDNumber = new JTextField(40);
	   	IDNumber.setBounds(20, 30, 100, 20);
	
	   	JLabel pass = new JLabel("Password");
	   	pass.setBounds(150,10,100,20);
	
	   	Password = new JPasswordField(40);
	   	Password.setBounds(150, 30, 100, 20);
	
	   	JButton Login = new JButton("Login");
	   	Login.setBounds(320, 10, 70, 40);
	   	Login.addActionListener(this);
	   	
	   	Login.addActionListener(new ActionListener(){
		   	public void actionPerformed(ActionEvent arg0) {
		
		       	loginID = Integer.parseInt(IDNumber.getText());
		
		       	//loginPass = Password.getText();
		
		   	}
	   	});
	
	   	JButton CreateAccount = new JButton("Create Account");
	   	CreateAccount.setBounds(150, 150, 130, 50);
	   	CreateAccount.addActionListener(this);
	
	   	boaRB = new JRadioButton("Bank Of America");
	   	boaRB.setActionCommand("Bank Of America");
	   	boaRB.setSelected(true);
	   	boaRB.setBounds(10, 60, 130, 20);
	   	boaRB.addActionListener(this);
	
	   	fifthThirdRB = new JRadioButton("Fifth & Third");
	   	fifthThirdRB.setActionCommand("Fifth & Third");
	   	fifthThirdRB.setBounds(150, 60, 150, 20);
	   	fifthThirdRB.addActionListener(this);
	
	   	ButtonGroup group = new ButtonGroup();
	   	group.add(boaRB);
	   	group.add(fifthThirdRB);
	
	   	panel_1a.add(IDNumber);
	   	panel_1a.add(pass);
	   	panel_1a.add(Password);
	   	panel_1a.add(Login);
	   	panel_1a.add(CreateAccount);
	   	panel_1a.add(Number);
	   	panel_1a.add(boaRB);
	   	panel_1a.add(fifthThirdRB);
	
	   	//Add the tabbed pane to this panel.
	   	add(tabbedPane);
	}

	public void actionPerformed(ActionEvent e) {
	   	if(e.getActionCommand() == "Login") {
	       	if(boaRB.isSelected() && bankOfAmerica.signIn(loginID)){
	           	LoginGUI();
	       	}
	       	if(fifthThirdRB.isSelected() && fifthThird.signIn(loginID)){
	       		LoginGUI();
	       	}
	   	}else if(e.getActionCommand() == "Create Account"){
	       	CreateAccountGUI();
	   	}
	}

	protected JComponent makeTextPanel(String text) {
	   	JPanel panel = new JPanel(false);
	   	JLabel filler = new JLabel(text);
	   	filler.setHorizontalAlignment(JLabel.CENTER);
	   	panel.setLayout(new GridLayout(1, 1));
	   	panel.add(filler);
	   	
	   	return panel;
	}

	public static void createAndShowGUI() {
	   	//Create and set up the window.
	   	JFrame frame = new JFrame("");
	   	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   	
	   	//Add content to the window.
	   	frame.add(new GUI(), BorderLayout.CENTER);
	
	   	//Display the window.
	   	frame.pack();
	   	frame.setResizable(false);
	   	frame.setVisible(true);
	}

	public void CreateAccountGUI(){
	   	JLabel[] labels = { new JLabel("Name:") , new JLabel("Age"), new JLabel("SSN"), new JLabel("Address"), new JLabel("Password")};
	   	JButton confirm = new JButton("Confirm");
	   	JPanel p = new JPanel(new GridLayout(8,2));
	
	   	Checking.setActionCommand("Checking");
	   	p.add(Checking);
	
	   	Saving.setActionCommand("Savings");
	   	p.add(Saving);
	
	   	p.add(labels[0]);
	   	p.add(nameTF);
	   	p.add(labels[1]);
	   	p.add(ageTF);
	   	p.add(labels[2]);
	   	p.add(ssnTF);
	   	p.add(labels[3]);
	   	p.add(addressTF);
	   	p.add(labels[4]);
	   	p.add(passTF);
	
	   	//JRadioButton boaRB2 = new JRadioButton("Bank Of America");
	
	   	boaRB2.setActionCommand("Bank Of America");
	   	p.add(boaRB2);
	   	
	   	fifthThirdRB2.setActionCommand("Fifth & Third");
	   	p.add(fifthThirdRB2);
	
	   	ButtonGroup group = new ButtonGroup();
	   	group.add(boaRB2);
	   	group.add(fifthThirdRB2);
	
	   	p.add(confirm);
	   	confirm.addActionListener(new ActionListener(){
	       	public void actionPerformed(ActionEvent arg0) {
	           	if(boaRB2.isSelected() && !nameTF.getText().isEmpty() && !ageTF.getText().isEmpty() && !ssnTF.getText().isEmpty() && 
	           			!addressTF.getText().isEmpty() && !String.valueOf(passTF.getPassword()).isEmpty()){
		           	bankOfAmerica.add(nameTF.getText());
		           	bankOfAmerica.add(ageTF.getText());
		           	bankOfAmerica.add(ssnTF.getText());
		           	bankOfAmerica.add(addressTF.getText());
		           	bankOfAmerica.add(String.valueOf(passTF.getPassword()));
		           	
		           	int account = 0;
		
		           	if(Checking.isSelected() && Saving.isSelected()){
		               	account = 2;
		           	}else if(Checking.isSelected()){
		               	account = 0;
		           	}else if(Saving.isSelected()){
		               	account = 1;
		           	}
		
		           	bankOfAmerica.openBankAccount(account);
	           	}else{
	           		JOptionPane.showMessageDialog(null, "No textfield can be empty");
	           	}
	           	if(fifthThirdRB2.isSelected()){
	               	fifthThird.add(nameTF.getText());
	               	fifthThird.add(ageTF.getText());
	               	fifthThird.add(ssnTF.getText());
	               	fifthThird.add(addressTF.getText());
	               	fifthThird.add(String.valueOf(passTF.getPassword()));
	               	
	               	int account = 0;
	        		
		           	if(Checking.isSelected() && Saving.isSelected()){
		               	account = 2;
		           	}else if(Checking.isSelected()){
		               	account = 0;
		           	}else if(Saving.isSelected()){
		               	account = 1;
		           	}
		
		           	fifthThird.openBankAccount(account);
	           	}
	       	}
	   	});
	
	   	confirm.addActionListener(this);
	
	   	//Create and set up the window.
	   	JFrame frame = new JFrame("Create Account");
	
	   	//Set up the content pane.
	   	p.setOpaque(true);  //content panes must be opaque
	   	frame.setContentPane(p);
	   	
	   	//Display the window.
	   	frame.pack();
	   	frame.setVisible(true);
	}

	public void LoginGUI(){
	   	JPanel p = new JPanel();
	   	JPanel p2 = new JPanel(new GridLayout(5,1,0,30));

	   	textArea = new JTextArea("Welcome\n\n",16,20);
	   	textArea.setEditable(false);
	   	p.add(textArea);
	  	 
	   	if(boaRB.isSelected()){
	  		checking = bankOfAmerica.getCheckingAccount(loginID);
	  		savings = bankOfAmerica.getSavingsAccount(loginID);
	  		if (checking != null) textArea.insert(checking.toString(), 9);
	  		if (savings != null) textArea.insert(savings.toString(), 9);
  		}
	   	if (fifthThirdRB.isSelected()){
	   		checking = fifthThird.getCheckingAccount(loginID);
	  		savings = fifthThird.getSavingsAccount(loginID);
	  		if (checking != null) textArea.insert(checking.toString(), 9);
	  		if (savings != null) textArea.insert(savings.toString(), 9);
	   	}
	  	 

	   	JLabel label = new JLabel("");
	   	JButton deposit = new JButton("Deposit");
	   	JButton withdraw = new JButton("Withdraw");
	   	final JRadioButton check = new JRadioButton("Checking");
	   	final JRadioButton sav = new JRadioButton("Savings");
	  	
	   	ButtonGroup group = new ButtonGroup();
	   	group.add(check);
	   	group.add(sav);
	   	
	   	p2.add(label);
	   	p2.add(check);
	   	p2.add(sav);
	   	p2.add(deposit);
	   	p2.add(withdraw);

	   	deposit.addActionListener(new ActionListener(){
	   		public void actionPerformed(ActionEvent e) {
	   			if(e.getActionCommand() == "Deposit" && check.isSelected() && checking != null){
		   			Deposit depo = new Deposit();
		   			checking.setOperation(depo);
		   			checking.deposit(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount you want to deposit:")));
		   			textArea.insert(checking.toString(), 9);
	   			}
	   			if(e.getActionCommand() == "Deposit" && sav.isSelected() && savings != null){
		   			Deposit depo = new Deposit();
		   			savings.setOperation(depo);
		   			savings.deposit(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount you want to deposit:")));
		   			textArea.insert(savings.toString(), 9);
	   			}
	   		}
	   	 });
	  	 
	   	withdraw.addActionListener(new ActionListener(){
	   		public void actionPerformed(ActionEvent e) {
	   			if(e.getActionCommand() == "Withdraw" && check.isSelected() && checking != null){
	   				Withdraw withdraw = new Withdraw();
	   				checking.setOperation(withdraw);
	   				checking.withdraw(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount you want to withdraw:")));
	   				textArea.insert(checking.toString(), 9);
	   			}
	   			if(e.getActionCommand() == "Withdraw" && sav.isSelected() && savings != null){
	   				Withdraw withdraw = new Withdraw();
	   				savings.setOperation(withdraw);
	   				savings.withdraw(Double.parseDouble(JOptionPane.showInputDialog(null, "Enter the amount you want to withdraw:")));
	   				textArea.insert(savings.toString(), 9);
	   			}
	   		}
	   	});	  	 

	   	//Create and set up the window.
	   	JFrame frame = new JFrame("Account");

	   	//Set up the content pane.
	   	p.setOpaque(true);  //content panes must be opaque
	   	frame.add(p, BorderLayout.WEST);
	   	frame.add(p2, BorderLayout.EAST);

	   	//Display the window.
	   	frame.pack();
	   	frame.setVisible(true);
	   	frame.setSize(350,300);
	}

	public void getInfo(){
	   	for(int i = 0; i < info.length; i++){
	       	System.out.println(info[i]);
	   	}
	}
}   






/** Returns an ImageIcon, or null if the path was invalid.

	protected static ImageIcon createImageIcon(String path) {

   	java.net.URL imgURL = TabbedPaneDemo.class.getResource(path);

   	if (imgURL != null) {

       	return new ImageIcon(imgURL);

   	} else {

       	System.err.println("Couldn't find file: " + path);

       	return null;

   	}

	}*/

	 





