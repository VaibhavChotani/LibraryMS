package libraryMS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class login extends JFrame implements ActionListener{
	
	 private JTextField textField ;
     private JPasswordField passwordField;
     private JButton b1,b2;
     
public login()
{
     JLabel l1 = new JLabel("Username  :");
	l1.setBounds(124, 89, 95, 24);
	add(l1);
	
	JLabel l2 = new JLabel("Password  :");
	l2.setBounds(124, 150, 100, 24);
	add(l2);
	
	JLabel l3 = new JLabel("LOGIN");
	l3.setBounds(210,40,95,10);//x,y,width,height
	add(l3);
	
	textField = new JTextField();
	textField.setBounds(220, 92, 150, 20);
	add(textField);
	
	passwordField =  new JPasswordField();
	passwordField.setBounds(220,152,150,20);
	add(passwordField);
	
	b1 = new JButton();
	b1.setText("LOGIN");
	b1.setBounds(124, 250, 100, 30);
	add(b1);
	
	b2 = new JButton();
	b2.setText("SIGN UP");
	b2.setBounds(280, 250, 100, 30);
	add(b2);
	
	b1.addActionListener(this);
	b2.addActionListener(this);
	
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
			try {
				Conn c = new Conn();
				String query = "select * from VAIBHAV.signup where username=? and password=? ";
				PreparedStatement s = c.con.prepareStatement(query);
				
				s.setString(1,textField.getText());
				s.setString(2,passwordField.getText());
				
				ResultSet rs = s.executeQuery();
				
				if(rs.next())
				{
					this.setVisible(false);
					new Home().setVisible(true);
				}
				else
					JOptionPane.showMessageDialog(null,"Invalid Login !");
				
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
			}
			
		}
		
		if(ae.getSource()==b2)
		{
			setVisible(false);
			Signup sign = new Signup();
			sign.setVisible(true);
			
		}
			
	}
	
	public static void main(String args[])
	{
		login l = new login();
    }

	
}
