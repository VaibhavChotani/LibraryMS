package libraryMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Home extends JFrame implements ActionListener {
	private JButton b1,b2,b3,b4,b5;
	
	public Home() 
	{
		
		JLabel l3 = new JLabel("HOME PAGE");
		l3.setBounds(210,40,95,10);//x,y,width,height
		add(l3);
		
		b1 = new JButton();
		b1.setText("Add Books");
		b1.setBounds(80,100,125,40);
		add(b1);
	    b1.addActionListener(this);
	    
	    b2 = new JButton();
		b2.setText("Books Issued");
		b2.setBounds(270,100,125,40);
		add(b2);
	    b2.addActionListener(this);
	    
	    b3 = new JButton();
		b3.setText("Issue Books");
		b3.setBounds(80,200,125,40);
		add(b3);
	    b3.addActionListener(this);
	    
	    b4 = new JButton();
		b4.setText("Return Book");
		b4.setBounds(270,200,125,40);
		add(b4);
	    b4.addActionListener(this);
	    
	    b5 = new JButton();
		b5.setText("Books Available");
		b5.setBounds(270,100,125,40);
		add(b5);
	    b5.addActionListener(this);
	    
	    
	    
	    
		
		
		
		
		
		
		setLayout(null);
		setVisible(true);
		setBounds(600, 200, 518, 442);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b1)
		{
			this.setVisible(false);
			new AddBooks().setVisible(true);
			
		}
		 if(ae.getSource()==b3)
		{
			this.setVisible(false);
			new IssueBooks().setVisible(true);
			
		}
		 if(ae.getSource()==b4)
		 {
			 this.setVisible(false);
			 new ReturnBook().setVisible(true);
		 }
		
	}
	
	public static void main(String args[])
	{
		new Home();
	}
	

}
