package finalProject;

import javax.swing.*; 
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class Deposit extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create items
	static JButton home;
	static JTextField depositEntry;
	
	Color yellow = new Color(255, 248, 43);
	
	public Deposit() {
		
		setTitle("Depost");
		
		home = new JButton("Return to menu"); // create frame
		depositEntry = new JTextField(20);
		
		home.addActionListener(this);
		depositEntry.addActionListener(this);
		
		frame.setSize(400,200); // create frame layout
		
		frame.setLayout(new FlowLayout());

		frame.add(depositEntry); // add elements
		frame.add(home);
		
		frame.getContentPane().setBackground(yellow);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	public void resetBal() throws FileNotFoundException { // reset if new user is registered
	
		frame.dispose();
		PrintWriter pw = new PrintWriter("Balance.txt");
		pw.println(0);
		pw.close();
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
				
				reader = new Scanner(file); // add to balance
		    
		        String balance = reader.nextLine();
		        int balanceNumber = Integer.valueOf(balance);
			        
				String deposit = depositEntry.getText();
				
				int depositNumber = Integer.valueOf(deposit);
				
				int total = depositNumber + balanceNumber;
				
				String stringTotal = String.valueOf(total);
			
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
			LoggedIn li = new LoggedIn(); // return to menu
		
		}

	}
}