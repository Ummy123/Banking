package finalProject;

import javax.swing.*; 
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class Transfer extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create itmes
	static JButton home;
	static JTextField transferEntry;
	static JTextField transferedAccount;
	static JLabel transfer;
	static JLabel transferTo;
	
	Color yellow = new Color(255, 248, 43);
	
	public Transfer() {
		
		setTitle("Transfer"); // create frame
		
		try {
			
		      File file = new File("balance.txt");
		      Scanner reader = new Scanner(file);
		    	  
		      String balance = reader.nextLine();
	
		      home = new JButton("Return to menu");
		      transferEntry = new JTextField(20);
		      transferedAccount = new JTextField(20);
		      transfer = new JLabel("Enter amount to be transferred");
		      transferTo = new JLabel("Enter email address to transfer to");
		       
		      reader.close();
		      
		    } 
		
		catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		
		home.addActionListener(this);
		transferEntry.addActionListener(this);
		transferedAccount.addActionListener(this);
		
		frame.setSize(800,600);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		frame.add(transfer); // add items to frame
		frame.add(transferEntry);
		frame.add(transferTo);
		frame.add(transferedAccount);
		frame.add(home);
		
		frame.getContentPane().setBackground(yellow);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) { // check for event
		
		if (e.getActionCommand().equals("Return to menu")) {
			
			frame.dispose();
			LoggedIn li = new LoggedIn();
			
		} else { 
			
			File file = new File("Balance.txt");
		    Scanner reader;
		    
			try {
				
				reader = new Scanner(file); // read balance to take away for transfer
		    
		        String balance = reader.nextLine();
		        int balanceNumber = Integer.valueOf(balance);
			        
				String transfer = transferEntry.getText();
				
				int transferNumber = Integer.valueOf(transfer);
				
				int total = balanceNumber - transferNumber;
				
				String stringTotal = String.valueOf(total);
				
				String transferred = transferedAccount.getText();
				
				frame.dispose();
				
				TransferredConfirmation tc = new TransferredConfirmation(transfer,transferred);
			
			try {
				
				PrintWriter pw = new PrintWriter("Balance.txt");
				pw.println(stringTotal);
				pw.close();
				
			} catch (IOException e1) {
			
				e1.printStackTrace();
				
			}
			
			} catch (FileNotFoundException e2) {
			
				e2.printStackTrace();
			}
			
			frame.dispose();
		
		}

	}
		
}
