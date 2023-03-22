package finalProject;

/**
 * @author amer.sangha
 * @ date: June 22, 2022
 * @ title: Online Banking
 * @ description: Client Online Banking with basic functions
 */

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class OnlineBanking extends JFrame implements ActionListener {
	
	static OnlineBanking window = new OnlineBanking(); // create items
	private JButton sub;
	private JButton lib;
	Color lightBlue= new Color(135,216,247);
	
	public OnlineBanking() { // run this to start 
		
		setTitle("Online Banking");
		
		Container c = getContentPane();
		
		sub = new JButton("Sign up"); // add items to frame
		lib = new JButton("Log in");
		JLabel menuTxt = new JLabel("Welcome to Online Banking! Select an option below to continue.");
		
		sub.addActionListener(this);
		lib.addActionListener(this);
	
		c.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));

		c.add(menuTxt);
		c.add(sub);
		c.add(lib);
		
		c.setBackground(lightBlue);
		
	}
	
	public static void main(String[] args) {
		
		window.setSize(600,400);
		
		window.show();
		
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // checks for button press
		if (e.getActionCommand().equals("Sign up")) {
			
			window.dispose();
			SignUp su = new SignUp();
			
		}
		
		 if (e.getActionCommand().equals("Log in")) {
			window.dispose();
			LogInDetails lid = new LogInDetails();
		
		 }

	}
}
