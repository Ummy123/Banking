package finalProject;

import javax.swing.*;  
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class TransferredConfirmation extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create items
	static JLabel confirmation;
	static JButton home;
	
	Color yellow = new Color(255, 248, 43);
	
	TransferredConfirmation(String transfer, String transferred) { // display amount transferred and to who
		
		home = new JButton("Return to menu");
		confirmation = new JLabel("$" + transfer + " has sucessfully been sent to " + transferred);
		
		home.addActionListener(this);
		
		frame.setSize(400,400);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		frame.add(confirmation);
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
			frame.dispose();
		}
		
		
	}

}
