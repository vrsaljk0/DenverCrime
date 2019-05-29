package sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

//import org.junit.Test;
import javax.swing.JComboBox;

public class Gui_patrola {

	private JFrame frame;
	private static JTextField txtPatrola;
	private static JTextField time;
	private JTextField txtUnosZlocina;
	private static JTextField txtIdKategorijePrekrajazlocina;
	private static JTextField txtDatumPrijavePrekrajazlocina;
	private static JTextField txtIdDistriktaPrekrajazlocina;
	private static JTextField txtIdSusjedstvaPrekrajazlocina;
	private JPanel panel_1;
	private static JTextField neighborhood;
	private static String[] districts = {"A", "B", "C", "D", "E", "F", "G"};
	private static String[] offenses = {"promet", "napad", "pozar", "provala", "krada", "opijati", "ostalo"};
	private static String[] ampms = {"AM", "PM"};
	
	
	private static JComboBox<String> offense;
	private static JComboBox<String> district;
	private static JComboBox<String> ampm;
	private static JTextField ERROR_forma;
	



	/**
	 * Launch the application.
	 */
	//@Test
	public void main(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_patrola window = new Gui_patrola();
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
	public Gui_patrola() {
		try {
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
		
		offense =new JComboBox(offenses);
		offense.setBounds(968, 342, 151, 30);
		district = new JComboBox(districts);
		district.setBounds(968, 516, 151, 30);
		ampm =new JComboBox(ampms);
		ampm.setBounds(1047, 431, 72, 30);
		
		time = new JTextField();
		time.setBounds(968, 431, 73, 30);
		time.setColumns(10);
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(300, 300, 1250, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtPatrola = new JTextField();
		txtPatrola.setBounds(24, 20, 200, 95);
		txtPatrola.setEditable(false);
		txtPatrola.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtPatrola.setHorizontalAlignment(SwingConstants.LEFT);
		txtPatrola.setText("Patrola");
		txtPatrola.setBackground(UIManager.getColor("Button.darkShadow"));
		txtPatrola.setColumns(15);
		
		JButton btnNewButton = new JButton("Zatrazi pojacanje");
		btnNewButton.setBounds(704, 742, 192, 68);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		
		JButton btnNewButton_1 = new JButton("Situacija je rjesena");
		btnNewButton_1.setBounds(968, 742, 183, 68);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBounds(1107, 12, 117, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
        		Gui_login guilogin = new Gui_login();
        		guilogin.main(null);
			}
		});
		

		BufferedImage image = null;
		//image = ImageIO.read(new File("C:\\Users\\Lukaku\\Documents\\programsko\\bin\\sql\\denver1.jpg"));
		image = ImageIO.read(new File("C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\src\\sql\\denver1.jpg"));
		//image = ImageIO.read(new File("D:\\xampp\\htdocs\\java\\programsko\\src\\sql\\denver1.jpg"));
		
		panel_1 = new JPanel();
		panel_1.setBounds(43, 269, 570, 550);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 570, 550);
		panel_1.add(panel);
		Image scaledImage = image.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_SMOOTH);
		panel.setLayout(null);
		JLabel label = new JLabel(new ImageIcon(scaledImage));
		label.setBounds(0, 5, 570, 550);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(283, 560, 4, 22);
		panel.add(textArea);
		
		txtUnosZlocina = new JTextField();
		txtUnosZlocina.setBounds(806, 251, 238, 35);
		txtUnosZlocina.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtUnosZlocina.setText("Unos zlocina :\r\n ");
		txtUnosZlocina.setEditable(false);
		txtUnosZlocina.setColumns(10);
		
		txtIdKategorijePrekrajazlocina = new JTextField();
		txtIdKategorijePrekrajazlocina.setBounds(704, 342, 263, 30);
		txtIdKategorijePrekrajazlocina.setText("ID kategorije prekr\u0161aja/zlocina:");
		txtIdKategorijePrekrajazlocina.setEditable(false);
		txtIdKategorijePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdKategorijePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		txtIdKategorijePrekrajazlocina.setColumns(10);
		
		txtDatumPrijavePrekrajazlocina = new JTextField();
		txtDatumPrijavePrekrajazlocina.setBounds(704, 431, 263, 30);
		txtDatumPrijavePrekrajazlocina.setText("Vrijeme prijave prekr\u0161aja/zlocina:");
		txtDatumPrijavePrekrajazlocina.setEditable(false);
		txtDatumPrijavePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtDatumPrijavePrekrajazlocina.setColumns(10);
		txtDatumPrijavePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdDistriktaPrekrajazlocina = new JTextField();
		txtIdDistriktaPrekrajazlocina.setBounds(704, 516, 263, 30);
		txtIdDistriktaPrekrajazlocina.setText("ID distrikta prekr\u0161aja/zlocina:");
		txtIdDistriktaPrekrajazlocina.setEditable(false);
		txtIdDistriktaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdDistriktaPrekrajazlocina.setColumns(10);
		txtIdDistriktaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdSusjedstvaPrekrajazlocina = new JTextField();
		txtIdSusjedstvaPrekrajazlocina.setBounds(704, 604, 263, 30);
		txtIdSusjedstvaPrekrajazlocina.setText("ID susjedstva prekr\u0161aja/zlocina:");
		txtIdSusjedstvaPrekrajazlocina.setEditable(false);
		txtIdSusjedstvaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdSusjedstvaPrekrajazlocina.setColumns(10);
		txtIdSusjedstvaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		JButton btnUnos = new JButton("Unesi");
		btnUnos.setBounds(890, 679, 97, 37);
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getConnection(0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	
		
		neighborhood = new JTextField();
		neighborhood.setBounds(968, 604, 151, 30);
		neighborhood.setColumns(10);
		
		ERROR_forma = new JTextField();
		ERROR_forma.setText("UNOS NIJE DOBAR!!!!!!!!!!!!!!!!  >:(");
		ERROR_forma.setBackground(Color.RED);
		ERROR_forma.setBounds(745, 311, 328, 20);
		ERROR_forma.setColumns(10);
		ERROR_forma.setVisible(false);
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(txtPatrola);
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(btnNewButton_1);
		frame.getContentPane().add(panel_1);
		frame.getContentPane().add(txtIdKategorijePrekrajazlocina);
		frame.getContentPane().add(txtDatumPrijavePrekrajazlocina);
		frame.getContentPane().add(txtIdDistriktaPrekrajazlocina);
		frame.getContentPane().add(txtIdSusjedstvaPrekrajazlocina);
		frame.getContentPane().add(btnUnos);
		frame.getContentPane().add(offense);
		frame.getContentPane().add(time);
		frame.getContentPane().add(ampm);
		frame.getContentPane().add(district);
		frame.getContentPane().add(neighborhood);
		frame.getContentPane().add(ERROR_forma);
		frame.getContentPane().add(txtUnosZlocina);
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
			
			String off = (String) offense.getSelectedItem();
			
			if (off.equals("promet")) off = "traffic";
			if (off.equals("napad")) off = "assault";
			if (off.equals("pozar")) off = "larceny";
			if (off.equals("provala")) off = "burglary";
			if (off.equals("krada")) off = "theft";
			if (off.equals("opijati")) off = "opiates";
			if (off.equals("ostalo")) off = "other";
			
			String date = (String) ampm.getSelectedItem();
			
			if (date.equals("AM")) date = "dan";
			if (date.equals("PM")) date = "noc";
			
			String dist = (String) district.getSelectedItem();
			String neigh = neighborhood.getText();
			
			System.out.println(off);
			
			if (neigh.equals("") || time.getText().equals("")) {
				ERROR_forma.setVisible(true);
			} else  {
				String query;
				if( off.equals("traffic") || off.equals("Traffic") ) {
					query = "INSERT INTO crime (OFFENSE, Date, District, Neighborhood, isCrime, isTraffic) VALUES ('" + off + "', '" + date + "', '" + dist + "', '" + neigh + "', false, true)";
				} else {
					query = "INSERT INTO crime (OFFENSE, Date, District, Neighborhood, isCrime, isTraffic) VALUES ('" + off + "', '" + date + "', '" + dist + "', '" + neigh + "', true, false)";
				}
				
				System.out.println(query);
				// create the java statement
			      Statement st = con.createStatement();
			      
			      // execute the query
			      st.executeUpdate(query);
			      
			      
			      
			      st.close();
			      
			      /*textField_5.setText("");
			      time.setText("");
			      textField_4.setText("");
			      textField_7.setText("");*/
			      neighborhood.setText("");
			      offense.setSelectedIndex(0);
			      ampm.setSelectedIndex(0);
			      district.setSelectedIndex(0);
				
				System.out.println("Uspjeh.");
			}
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
