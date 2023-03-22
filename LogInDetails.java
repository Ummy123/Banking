package finalProject;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class LogInDetails extends JFrame implements ActionListener {

	JFrame frame = new JFrame(); // create frame elements
	static JTextField email;
	static JPasswordField pass;
	static JButton btn;
	Color yellow = new Color(255, 248, 43);
	
	public LogInDetails() {
		
		setTitle("Log in");
		
		JLabel emailTxt = new JLabel("Enter email:"); // create items
		JLabel passwordTxt = new JLabel("Enter Password:");
		pass = new JPasswordField(20);
		email = new JTextField(20);
		btn = new JButton("Return to menu");
		
		email.addActionListener(this);
		pass.addActionListener(this);
		btn.addActionListener(this);
				
		frame.setSize(600,400);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,150,50));
		
		frame.add(emailTxt); // add items to frame
		frame.add(email);
		
		frame.add(passwordTxt);
		frame.add(pass);
		
		frame.add(btn);
		
		frame.getContentPane().setBackground(yellow);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Return to menu")) { // check for event
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
			
	} else { 
		
		String eMailText = email.getText(); // get email and password
		String passwordText = pass.getText();
		
		try {
	
			File file = new File("Email and Password Data.txt"); // compare data
		      Scanner reader = new Scanner(file);
		      
		      while (reader.hasNextLine()) {
		        String edata = reader.next();
		        String pdata = reader.next();
		        
		        if (edata.equals(eMailText) && pdata.equals(passwordText)) {
		        	
		        	frame.dispose();
		        	LoggedIn li = new LoggedIn();
		        	
		        } else {
		        	
		        	frame.dispose();
		        	Invalid i = new Invalid();
		        	
		        }

		      }
		      reader.close();
			
		} catch (IOException e1) {
		
			e1.printStackTrace();
			
		}
		
		
	}
		
	}
}
