package finalProject;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class SignUp extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame(); // create frame elements
	static JTextField email;
	static JPasswordField pass;
	static JButton btn;
	Color lightBlue= new Color(135,216,247);
	
	
	public SignUp() {
		
		setTitle("Registration"); // create items
		
		JLabel emailTxt = new JLabel("Enter email:");
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
		
		frame.getContentPane().setBackground(lightBlue);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // check for event
		if (e.getActionCommand().equals("Return to menu")) {
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
			
	} else { 
		   
		      String eMailText = email.getText(); // get email and password
		      String passwordText = pass.getText();
			
		try {
			
			FileWriter fw = new FileWriter("Email and Password Data.txt"); // save data
			email.write(fw);
			fw.write(" ");
			pass.write(fw);
			fw.close();
			Deposit d = new Deposit();
			d.resetBal();
				
			} catch (IOException e1) {
			
				e1.printStackTrace();
				
			}
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
			
		}
	}
	
}
