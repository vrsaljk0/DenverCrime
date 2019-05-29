package sql;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Gui_admin {
	private static String[] patrol = new String[100];
	private static String[] district = {"A", "B", "C", "D", "E", "F", "G"};

	private static JFrame frame;
	private JTextField txtAdministrator;
	private JTextField txtSearch;
	private static JComboBox<String> patrols;
	private static JComboBox<String> districts;

	/**
	 * Launch the application.
	 */
	public void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_admin window = new Gui_admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
	}

	/**
	 * Create the application.
	 */
	public Gui_admin() {
		try {
			try {
				getConnection(0);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(300, 300, 1350, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAdministrator = new JTextField();
		txtAdministrator.setEditable(false);
		txtAdministrator.setBackground(UIManager.getColor("Button.darkShadow"));
		txtAdministrator.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtAdministrator.setText("Administrator");
		txtAdministrator.setBounds(15, 15, 200, 39);
		frame.getContentPane().add(txtAdministrator);
		txtAdministrator.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(659, 198, 538, 250);
		frame.getContentPane().add(textArea);
		
		JButton btnMine = new JButton("Mine");
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Mining.getRules();
					textArea.setText(Mining.getRules());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnMine.setBounds(816, 131, 117, 25);
		frame.getContentPane().add(btnMine);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setBounds(945, 134, 114, 19);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		patrols = new JComboBox(patrol);
		patrols.setToolTipText("");
		patrols.setBounds(679, 501, 170, 24);
		frame.getContentPane().add(patrols);
		
		districts =new JComboBox(district);
		districts.setToolTipText("");
		districts.setBounds(849, 501, 170, 24);
		frame.getContentPane().add(districts);
		
		JButton btnPreusmjeri = new JButton("Preusmjeri");
		btnPreusmjeri.setBounds(1036, 501, 170, 25);
		btnPreusmjeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					preusmjeri();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnPreusmjeri);
		
		JButton btnPoaljiPojaanje = new JButton("Posalji pojacanje");
		btnPoaljiPojaanje.setBounds(1036, 525, 170, 25);
		frame.getContentPane().add(btnPoaljiPojaanje);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setForeground(UIManager.getColor("MenuItem.selectionForeground"));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
        		Gui_login guilogin = new Gui_login();
        		guilogin.main(null);
			}
		});
		btnLogOut.setBackground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		btnLogOut.setBounds(1200, 24, 117, 25);
		frame.getContentPane().add(btnLogOut);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 183, 570, 550);
		BufferedImage image = null;
		//image = ImageIO.read(new File("C:\\Users\\Lukaku\\Documents\\programsko\\bin\\sql\\denver1.jpg"));
		image = ImageIO.read(new File("C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\src\\sql\\denver1.jpg"));
		Image scaledImage = image.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_SMOOTH);
		panel.add(new JLabel(new ImageIcon(scaledImage)));
		frame.getContentPane().add(panel);
	}
	
	public static Connection getConnection(int id) throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//String url = "jdbc:mysql://localhost:3306/denver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String query = "SELECT ID FROM user";

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      int br = 0;
		      while (rs.next())
		      {
		        Integer ID = rs.getInt("ID");
		        
		        patrol[br++] = ID.toString();
		        
		        System.out.println(patrol[br-1]);
		      }
		      
			st.close();
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Connection preusmjeri() throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//String url = "jdbc:mysql://localhost:3306/denver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String pat = (String) patrols.getSelectedItem();
			String pod = (String) districts.getSelectedItem();
			
			String query = "UPDATE user SET Podrucje='" + pod + "' WHERE ID='" + pat + "'";
			
			System.out.println(query);

		      // create the java statement
			Statement st = con.createStatement();
		      
		      // execute the query
		      st.executeUpdate(query);
		      
		     System.out.println("Uspjeh!!!!");
		      
			st.close();
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
