package libraryMS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class ReturnBook extends JFrame implements ActionListener {
	 private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	    private JButton b1,b2,b3;


	    public ReturnBook() {
	    	
	      

		JLabel l1 = new JLabel("Name");
		l1.setBounds(73, 84, 90, 22);
		add(l1);

		JLabel l2 = new JLabel("ISBN");
		l2.setBounds(73, 117, 90, 22);
		add(l2);

		JLabel l3 = new JLabel("Publisher");
		l3.setBounds(73, 150, 90, 22);
		add(l3);

		JLabel l4 = new JLabel("Price");
		l4.setBounds(73, 216, 90, 22);
		add(l4);

		JLabel l5 = new JLabel("Pages");
		l5.setBounds(73, 249, 90, 22);
		add(l5);

		JLabel l6 = new JLabel("Student ID");
		l6.setBounds(73, 51, 90, 22);
	    add(l6);

		JLabel l7 = new JLabel("Edition");
		l7.setBounds(73, 183, 90, 22);
		add(l7);
		
		JLabel l8 = new JLabel("Book Id");
		l8.setBounds(73, 283, 90, 20);
		add(l8);
		
		JLabel l9 = new JLabel("Student Name");
		l9.setBounds(73, 313, 90, 20);
		add(l9);
		
		JLabel l10 = new JLabel("Issue Date");
		l10.setBounds(73, 345, 90, 20);
		add(l10);

		t1 = new JTextField();
		t1.setBounds(169, 54, 198, 20);
		add(t1);

		t2 = new JTextField();
		t2.setBounds(169, 87, 198, 20);
		add(t2);

		t3 = new JTextField();
		t3.setBounds(169, 120, 198, 20);
		add(t3);

		t4 = new JTextField();
		t4.setBounds(169, 153, 198, 20);
		add(t4);

	    t5 = new JTextField();
		t5.setBounds(169, 219, 198, 20);
		add(t5);

		t6 = new JTextField();
		t6.setBounds(169, 252, 198, 20);
		add(t6);

		t7 = new JTextField();
		t7.setBounds(173, 186, 198, 20);
		add(t7);
		
		t8 = new JTextField();
		t8.setBounds(169, 283, 198, 20);
		add(t8);
		
		t9 = new JTextField();
		t9.setBounds(169, 313, 198, 20);
		add(t9);
		
		t10 = new JTextField();
		t10.setBounds(169,345,198,20);
		add(t10);

	    b1 = new JButton("Return");
		b1.setBounds(102, 400, 100, 33);
	    add(b1);

		b2 = new JButton("Back");
	    b2.setBounds(212, 400, 100, 33);
	    add(b2);
	    
	    b3 = new JButton("Search");
	    b3.setBounds(320,400,100,33);
	    add(b3);
	    
	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
	       
		
		
		setLayout(null);
		 setBounds(500, 200, 518, 600);
		 setVisible(true);	
			
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		// TODO Auto-generated method stub
		try {
		if(ae.getSource()==b1)
		{
			Conn con = new Conn();
			String query ="delete from VAIBHAV.issueBooks where stid= ?";
			
			PreparedStatement st = con.con.prepareStatement(query);
			st.setString(1, t1.getText());
		   int rs = st.executeUpdate();
			 if (rs > 0)
	                JOptionPane.showMessageDialog(null, "Book Returned");
	            else
	                JOptionPane.showMessageDialog(null, "error in Deleting");
	        }
		
			
		
		if(ae.getSource()==b2)
		{
			this.setVisible(false);
			new Home().setVisible(true);
		}
		if(ae.getSource()==b3)
		{
			Conn con = new Conn();
			String query ="select * from VAIBHAV.issueBooks where stid=?";
			PreparedStatement st = con.con.prepareStatement(query);
			st.setString(1, t1.getText());
			ResultSet rs = st.executeQuery();
			
	                while (rs.next()) {
	                   
	                    t2.setText(rs.getString("name"));
	                    t3.setText(rs.getString("isbn"));
	                    t4.setText(rs.getString("publisher"));
	                    t5.setText(rs.getString("edition"));
	                    t6.setText(rs.getString("pages"));
	                    t7.setText(rs.getString("price"));
	                    t8.setText(rs.getString("book_id"));
	                    t9.setText(rs.getString("stname"));
	                    t10.setText(rs.getString("issuedate"));
	                    
	                    
			}	
	         st.close();
			rs.close();
		}
			
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	
 public static void main(String args[])
 {
	 new ReturnBook();
 }
}
