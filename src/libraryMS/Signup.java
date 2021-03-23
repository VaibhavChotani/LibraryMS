package libraryMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class Signup extends JFrame implements ActionListener {

	private JLabel l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2;
	
	public Signup() {
		
		JLabel l3 = new JLabel("SIGNUP");
		l3.setBounds(210,40,95,10);//x,y,width,height
		add(l3);
		l1 = new JLabel();
		l1.setText("Name : ");
		l1.setBounds(124, 90, 100, 25);
		add(l1);
		
		l2 = new JLabel();
		l2.setText("Username : ");
		l2.setBounds(124, 140, 100, 25);
		add(l2);
		
		l3 = new JLabel();
		l3.setText("Password : ");
		l3.setBounds(124, 180, 100, 25);
		add(l3);
		
		t1 =  new JTextField();
		t1.setBounds(210, 92, 170, 20);
		add(t1);
		
		t2 =  new JTextField();
		t2.setBounds(210, 132, 170, 20);
		add(t2);
		
		t3 =  new JTextField();
		t3.setBounds(210, 172, 170, 20);
		add(t3);
		
		b1 = new JButton();
		b1.setText("Create Account");
		b1.setBounds(124, 250, 150, 25);
		add(b1);
		
		b2 = new JButton();
		b2.setText("Back");
		b2.setBounds(325, 250, 70, 25);
		add(b2);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		
		
		
		
		
		
		setLayout(null);
		 setBounds(600, 200, 518, 442);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		if(ae.getSource()==b1)
		{
			try {
				Conn c = new Conn();
				String name = t1.getText();
				String username = t2.getText();
				String password = t3.getText();
				
				String query = "insert into VAIBHAV.signup values(?,?,?)";
				PreparedStatement s = c.con.prepareStatement(query);
				s.setString(1,name);
				s.setString(2, username);
				s.setString(3, password);
				
				int rs = s.executeUpdate();
				
				if(rs>0)
				{
					 JOptionPane.showMessageDialog(null, "successfully Created");
				}
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
				s.close();
				c.con.close();
			}
			
			catch(Exception e1)
			{
				e1.printStackTrace();
			}
		}
		if(ae.getSource()==b2)
		{
			setVisible(false);
			new login().setVisible(true);
		}
		
		
		
	}
}
