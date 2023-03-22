package finalProject;

import javax.swing.*; 
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

public class Invalid extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame(); // create items
	static JButton btn;
	Color yellow = new Color(255, 248, 43);
	
	public Invalid() {
		
		JLabel txt = new JLabel("Invalid, please return to the main menu."); // create window
		btn = new JButton("Return to menu");
		
		frame.setSize(600,400);
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,150,50));
		
		frame.add(txt); // add elements
		frame.add(btn);
		
		btn.addActionListener(this);
		
		frame.getContentPane().setBackground(yellow);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		
	}
	
	public void actionPerformed(ActionEvent e) { // check for event
		if (e.getActionCommand().equals("Return to menu")) {
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
			
		} else {
			
			frame.dispose();
			OnlineBanking ob = new OnlineBanking();
			ob.main(null);
		
		}
	
	}
	
}
