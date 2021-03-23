package libraryMS;
import java.sql.*;


public class Conn {
  Connection con;
  Statement s;
 public Conn() 
 {
	 try {
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("","","");
		 s = con.createStatement();

		 

	 }
	 catch(SQLException e)
	 {
		 e.printStackTrace();
	 }
	 catch(ClassNotFoundException e)
	 {
		  e.printStackTrace();
	 }
	
	
 }


}
