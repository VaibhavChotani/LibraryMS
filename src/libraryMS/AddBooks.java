package libraryMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class AddBooks extends JFrame implements ActionListener{

     
    private JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    private JButton b1,b2;


    public AddBooks() {
    	
      

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

	JLabel l6 = new JLabel("Book_id");
	l6.setBounds(73, 51, 90, 22);
    add(l6);

	JLabel l7 = new JLabel("Edition");
	l7.setBounds(73, 183, 90, 22);
	add(l7);
	
	JLabel l8 =  new JLabel("Date");
	l8.setBounds(73,280,90,22);
	add(l8);
   

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
	t7.setBounds(169, 186, 198, 20);
	add(t7);
	
	t8 =  new JTextField();
	t8.setBounds(169,284,198,20);
	add(t8);

    b1 = new JButton("Add");
	b1.setBounds(102, 330, 100, 33);
    add(b1);

	b2 = new JButton("Back");
    b2.setBounds(212, 330, 108, 33);
    add(b2);
    
    b1.addActionListener(this);
    b2.addActionListener(this);
       
	
	
	setLayout(null);
	 setBounds(600, 200, 518, 442);
	 setVisible(true);	
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	

    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            Conn con = new Conn();
            if(ae.getSource() == b1){
            String query = "insert into VAIBHAV.book values(?, ?, ?, ?, ?, ?, ?,?)";
		PreparedStatement st = con.con.prepareStatement(query);
                
		st.setString(1, t1.getText());
		st.setString(2, t2.getText());
		st.setString(3, t3.getText());
		st.setString(4, t4.getText());
		st.setString(5, t7.getText());
		st.setString(6, t5.getText());
		st.setString(7, t6.getText());
        st.setString(8, t8.getText());
        
		int rs = st.executeUpdate();
		if (rs > 0)
          JOptionPane.showMessageDialog(null, "Successfully Added");
		else
          JOptionPane.showMessageDialog(null, "Error");
		
		
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                
		        st.close();
            }
            
            if(ae.getSource() == b2){
            	
                this.setVisible(false);
		        new Home().setVisible(true);

            }
            con.con.close();
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
    	new AddBooks();
        }
}
