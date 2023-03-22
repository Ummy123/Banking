package finalProject;

import javax.swing.*;  
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class LoggedIn extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create frame elements
	static JButton home;
	static JButton deposit;
	static JButton withdraw;
	static JButton viewBal;
	static JButton transfer;
	static JButton history;
	
	Color yellow = new Color(255, 248, 43);
	
	public LoggedIn() {
		
		setTitle("Log In Menu");
		
		home = new JButton("Return to menu"); // create items
		deposit = new JButton("Deposit");
		withdraw = new JButton("Withdraw");
		viewBal = new JButton("View balance");
		transfer = new JButton("Transfer funds");
		
		home.addActionListener(this);
		deposit.addActionListener(this);
		withdraw.addActionListener(this);
		viewBal.addActionListener(this);
		transfer.addActionListener(this);
		
		frame.setLayout(new GridLayout(5,1));
		
		frame.add(deposit); // add items to frame
		frame.add(withdraw);
		frame.add(viewBal);
		frame.add(transfer);
		frame.add(home);
		
		frame.getContentPane().setBackground(yellow);

		frame.pack();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // check for event and open based on selection
		
		
		if (e.getActionCommand().equals("Deposit")) {
			
			frame.dispose();
			Deposit d = new Deposit();
			
		}
		
		if (e.getActionCommand().equals("Withdraw")) {
			
			frame.dispose();
			Withdraw w = new Withdraw();
			
		}
		
		if (e.getActionCommand().equals("View balance")) {
			
			frame.dispose();
			ViewBalance vb = new ViewBalance();
			
		}
		
		if (e.getActionCommand().equals("Transfer funds")) {
			
			frame.dispose();
			Transfer t = new Transfer();
			
		}
		
		else if (e.getActionCommand().equals("Return to menu")) {
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
			
		}
	}

}