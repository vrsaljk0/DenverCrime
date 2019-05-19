package sql;

import java.io.File;
import java.io.PrintWriter;
import java.sql.*;

public class Create_CSV {

	public static void getCSV() {
		try {
			PrintWriter file = new PrintWriter(new File("C:\\Users\\Aspire\\Desktop\\FAKS\\Programsko inž-2019\\baza\\crime_rules.csv")); //path gdje želimo spremiti bazu
			StringBuilder str = new StringBuilder();
			
			Connection connection = getConnection();
			
			String query = "select * from crime";
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			str.append("OFFENSE_TYPE_ID, OFFENSE_CATEGORY_ID, REPORTED_DATE, INCIDENT_ADDRESS, NEIGHBORHOOD_ID, IS_CRIME, IS_TRAFFIC\r\n");
			
			while(rs.next()) {
				str.append(rs.getString("OFFENSE_TYPE_ID"));
				str.append(",");
				str.append(rs.getString("OFFENSE_CATEGORY_ID"));
				str.append(",");
				str.append(rs.getString("REPORTED_DATE"));
				str.append(",");
				str.append(rs.getString("INCIDENT_ADDRESS"));
				str.append(",");
				str.append(rs.getString("NEIGHBORHOOD_ID"));
				str.append(",");
				str.append(rs.getString("IS_CRIME"));
				str.append(",");
				str.append(rs.getString("IS_TRAFFIC"));
				str.append("\r\n");
			}
			file.write(str.toString());
			file.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}	
	}
	
	public static Connection getConnection() throws Exception {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			//url prilagoditi - mysql://server:port_number/ime_baze
			String url = "jdbc:mysql://localhost:3306/denver_crime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Povezivanje uspješno");
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		return con;
	} 

}
