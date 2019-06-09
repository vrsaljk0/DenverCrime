package denvercrime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Gui_login {

	private static JFrame frame;
	private JTextField txtDenvercrime;
	private static JTextField txtKorisnikoIme, error;
	private static JPasswordField txtLozinka;
	private JTextField txtKorisnikoIme_1;
	private JTextField txtLozinka_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_login window = new Gui_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui_login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtDenvercrime = new JTextField();
		txtDenvercrime.setEditable(false);
		txtDenvercrime.setBackground(Color.WHITE);
		txtDenvercrime.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtDenvercrime.setText("DenverCrime");
		txtDenvercrime.setBounds(15, 15, 200, 39);
		frame.getContentPane().add(txtDenvercrime);
		txtDenvercrime.setColumns(10);
		
		error = new JTextField();
		error.setText("Pogrešno ime ili lozinka, pokušajte ponovno");
		error.setFont(new Font("Century Schoolbook L", Font.BOLD, 10));
		error.setEditable(false);
		error.setColumns(35);
		error.setVisible(false);
		error.setBackground(Color.red);
		error.setBounds(769, 190, 250, 100);
		frame.getContentPane().add(error);
		
		txtKorisnikoIme = new JTextField();
		txtKorisnikoIme.setText("");
		txtKorisnikoIme.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtKorisnikoIme.setEditable(true);
		txtKorisnikoIme.setColumns(10);
		txtKorisnikoIme.setBackground(UIManager.getColor("Button.background"));
		txtKorisnikoIme.setBounds(789, 316, 200, 50);
		if( txtKorisnikoIme.isFocusOwner() == true ) System.out.println("ej");
		frame.getContentPane().add(txtKorisnikoIme);
		
		txtLozinka = new JPasswordField();
		txtLozinka.setText("");
		txtLozinka.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtLozinka.setEditable(true);
		txtLozinka.setColumns(10);
		txtLozinka.setBackground(UIManager.getColor("Button.background"));
		txtLozinka.setBounds(789, 407, 200, 50);
		txtLozinka.setFocusable(true);
		if( txtLozinka.isFocusOwner() ) txtLozinka.setText("");
		frame.getContentPane().add(txtLozinka);
		
		JButton btnUlogirajSe = new JButton("Ulogiraj se");
		btnUlogirajSe.setFont(new Font("Dialog", Font.BOLD, 15));
		btnUlogirajSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getConnection();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUlogirajSe.setBounds(789, 509, 200, 50);
		frame.getContentPane().add(btnUlogirajSe);
		
		txtKorisnikoIme_1 = new JTextField();
		txtKorisnikoIme_1.setText("Korisničko ime:");
		txtKorisnikoIme_1.setFont(new Font("Dialog", Font.BOLD, 20));
		txtKorisnikoIme_1.setEditable(false);
		txtKorisnikoIme_1.setColumns(10);
		txtKorisnikoIme_1.setBackground(UIManager.getColor("Button.darkShadow"));
		txtKorisnikoIme_1.setBounds(552, 316, 206, 50);
		frame.getContentPane().add(txtKorisnikoIme_1);
		
		txtLozinka_1 = new JTextField();
		txtLozinka_1.setText("Lozinka:");
		txtLozinka_1.setFont(new Font("Dialog", Font.BOLD, 20));
		txtLozinka_1.setEditable(false);
		txtLozinka_1.setColumns(10);
		txtLozinka_1.setBackground(UIManager.getColor("Button.darkShadow"));
		txtLozinka_1.setBounds(552, 407, 206, 50);
		frame.getContentPane().add(txtLozinka_1);
	}
	
	@SuppressWarnings("deprecation")
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
		      
		      boolean noMatch = false;
		      while (rs.next()) {
		        int id = rs.getInt("ID");
		        String user = rs.getString("Username");
		        String pas = rs.getString("Lozinka");
		        String ime = rs.getString("Ime");
		        String prezime = rs.getString("Prezime");
		        String role = rs.getString("Uloga");
		        
		        String username1 = null, pass = null;
		        
		        username1 = txtKorisnikoIme.getText();
		        pass = txtLozinka.getText();
		        
		        System.out.println(user + " " + username1 + " " + pass + "  " + pas + " " + username1.equals(user));
		        
		        if( username1.equals(user) && pass.equals(pas) ) {
		        	if( role.charAt(0) == 'A' ) {
		        		System.out.printf("%s %s\n", ime, prezime);
		        		frame.setVisible(false);
		        		Gui_admin guiadmin = new Gui_admin();
		        		guiadmin.main(id);
		        	} else {
		        		String podrucje = rs.getString("Podrucje");
		        		System.out.println("Opala patrola!");
		        		frame.setVisible(false);
		        		Gui_patrola guipatrola = new Gui_patrola(id, podrucje);
		        		guipatrola.main(id, podrucje);
		        	}
		        } else {
		        	noMatch = true;
		        }
		        	
		      }
		      
		      if( noMatch ) {
		    	txtKorisnikoIme.setBorder(BorderFactory.createLineBorder(Color.RED));
	        	txtLozinka.setBorder(BorderFactory.createLineBorder(Color.RED));
	        	txtKorisnikoIme.setText("");
	        	txtLozinka.setText("");
	        	error.setVisible(true);
		      }
		      
		      st.close();
			 
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	} 
}
