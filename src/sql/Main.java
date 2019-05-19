<<<<<<< HEAD
package sql;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {
		getConnection();
		
		//Mine.dataMine();
		Gui_login guilogin = new Gui_login();
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

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      while (rs.next())
		      {
		        int id = rs.getInt("ID");
		        String firstName = rs.getString("Ime");
		        String lastName = rs.getString("Prezime");
		        int role = rs.getInt("Područje");
		        
		        // print the results
		        System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, role);
		      }
		      st.close();
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		
		return null;
	} 
	
}
=======
package denvercrime;

public class Main { 
	
	public static void main(String[] args) throws Exception {
		Create_CSV.getCSV();
		Mining.getRules();
	}	
}
>>>>>>> 5bfe4e07232b30b9b9bbe9c841d59223dddc0a30
