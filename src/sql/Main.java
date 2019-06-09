package denvercrime;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		getConnection();
		//Gui_login guilogin = new Gui_login();
	}
	
	public static Connection getConnection() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");

			String query = "SELECT * FROM user";
		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(query);
		      
			while (rs.next()) {
			    int id = rs.getInt("ID");
			    String firstName = rs.getString("Ime");
			    String lastName = rs.getString("Prezime");
			    String role = rs.getString("Podrucje");
			
			    System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, role);
			}
		    st.close();
			 
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	} 
	
}
