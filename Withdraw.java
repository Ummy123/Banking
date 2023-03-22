package finalProject;

import javax.swing.*; 
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class Withdraw extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create items
	static JButton home;
	static JTextField withdrawEntry;
	
	Color yellow = new Color(255, 248, 43);
	
	public Withdraw() {
		
		setTitle("Withdraw"); // create frame
		home = new JButton("Return to menu");
		withdrawEntry = new JTextField(20);
		
		home.addActionListener(this);
		withdrawEntry.addActionListener(this);
		
		frame.setSize(400,200);
		
		frame.setLayout(new FlowLayout());

		frame.add(withdrawEntry); // add elements to frame
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
				
				reader = new Scanner(file); // read file and withdraw
		    
		        String balance = reader.nextLine();
		        int balanceNumber = Integer.valueOf(balance);
			        
				String withdraw = withdrawEntry.getText();
				
				int withdrawNumber = Integer.valueOf(withdraw);
				
				int total = balanceNumber - withdrawNumber;
				
				String stringTotal = String.valueOf(total);
			
			try {
				
				PrintWriter pw = new PrintWriter("Balance.txt");
				pw.println(stringTotal);
				pw.close();
				
			} catch (IOException e1) { // check for error
			
				e1.printStackTrace();
				
			}
			
			} catch (FileNotFoundException e2) {
			
				e2.printStackTrace();
			}
			
			frame.dispose();
			LoggedIn li = new LoggedIn();
		
		}

	}
}
