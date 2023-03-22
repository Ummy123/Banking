package finalProject;

import javax.swing.*; 
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.util.Scanner;

public class ViewBalance extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame(); // create items
	static JButton home;
	static JLabel bal;
	
	Color yellow = new Color(255, 248, 43);
	
	public ViewBalance() {
		
		setTitle("Balance"); // create frame
		
		try {
		      File file = new File("balance.txt"); // read balance
		      Scanner reader = new Scanner(file);
		      
		      while (reader.hasNextLine()) {
		    	  
		        String balance = reader.nextLine();
	
		        home = new JButton("Return to menu");
				bal = new JLabel("Your balance is $" + balance);
		        
		      }
		      
		      reader.close();
		      
		    } 
		
		catch (FileNotFoundException e) {
		      e.printStackTrace();
		    }
		
		home.addActionListener(this);
		
		frame.setSize(400,400); // add button and label to frame
		
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,100,100));
		
		frame.add(bal);
		frame.add(home);
		
		frame.getContentPane().setBackground(yellow);

		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

}

	@Override
	public void actionPerformed(ActionEvent e) { // check for event
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("Return to menu")) {
			
			frame.dispose();
			LoggedIn li = new LoggedIn();
		
		} else {
			frame.dispose();
		}
	}
}
