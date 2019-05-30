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
					Gui_patrola window = new Gui_patrola(id);
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
	public Gui_patrola(int id) {
		try {
			initialize(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */

	private void initialize(int id) throws IOException {
		
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
		txtPatrola.setText("Patrola br." + id);
		txtPatrola.setBackground(UIManager.getColor("Button.darkShadow"));
		txtPatrola.setColumns(15);
		
		JButton btnCallForHelp = new JButton("Zatrazi pojacanje");
		btnCallForHelp.setBounds(704, 142, 192, 68);
		btnCallForHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					actions(id, 2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 1 - akcija za unos, 2 - akcija za trazenje pomoci, 3 - akcija za obavijest da je riješeno
			}
		});
		btnCallForHelp.setBackground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		
		JButton btnSolved = new JButton("Situacija je rjesena");
		btnSolved.setBounds(968, 142, 183, 68);
		btnSolved.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					actions(id, 3);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 1 - akcija za unos, 2 - akcija za trazenje pomoci, 3 - akcija za obavijest da je riješeno
			}
		});
		btnSolved.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
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
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(113, 320, 56, 110);
		panel.add(lblA);
		
		JLabel lblA_1 = new JLabel("A_1");
		lblA_1.setBounds(94, 369, 21, 13);
		panel.add(lblA_1);
		
		JLabel lblA_2 = new JLabel("A_2");
		lblA_2.setBounds(56, 392, 56, 38);
		panel.add(lblA_2);
		
		JLabel lblA_3 = new JLabel("A_3");
		lblA_3.setBounds(77, 427, 79, 28);
		panel.add(lblA_3);
		
		JLabel lblA_4 = new JLabel("A_4");
		lblA_4.setBounds(94, 440, 75, 75);
		panel.add(lblA_4);
		
		JLabel lblA_5 = new JLabel("A_5");
		lblA_5.setBounds(67, 450, 28, 65);
		panel.add(lblA_5);
		
		JLabel lblA_6 = new JLabel("A_6");
		lblA_6.setBounds(66, 508, 49, 32);
		panel.add(lblA_6);
		
		JLabel lblA_7 = new JLabel("A_7");
		lblA_7.setBounds(25, 537, 92, 13);
		panel.add(lblA_7);
		
		JLabel lblA_8 = new JLabel("A_8");
		lblA_8.setBounds(0, 477, 70, 44);
		panel.add(lblA_8);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(170, 320, 21, 102);
		panel.add(lblB);
		
		JLabel lblB_1 = new JLabel("B_1");
		lblB_1.setBounds(170, 320, 128, 50);
		panel.add(lblB_1);
		
		JLabel lblB_2 = new JLabel("B_2");
		lblB_2.setBounds(244, 231, 56, 94);
		panel.add(lblB_2);
		
		JLabel lblB_3 = new JLabel("B_3");
		lblB_3.setBounds(201, 369, 99, 38);
		panel.add(lblB_3);
		
		JLabel lblB_4 = new JLabel("B_4");
		lblB_4.setBounds(195, 405, 21, 22);
		panel.add(lblB_4);
		
		JLabel lblB_5 = new JLabel("B_5");
		lblB_5.setBounds(270, 394, 28, 28);
		panel.add(lblB_5);
		
		JLabel lblC = new JLabel("C");
		lblC.setBounds(298, 320, 113, 122);
		panel.add(lblC);
		
		JLabel lblC_1 = new JLabel("C_1");
		lblC_1.setBounds(352, 441, 128, 22);
		panel.add(lblC_1);
		
		JLabel lblC_2 = new JLabel("C_2");
		lblC_2.setBounds(362, 460, 103, 65);
		panel.add(lblC_2);
		
		JLabel lblC_3 = new JLabel("C_3");
		lblC_3.setBounds(389, 379, 92, 65);
		panel.add(lblC_3);
		
		JLabel lblC_4 = new JLabel("C_4");
		lblC_4.setBounds(469, 417, 49, 38);
		panel.add(lblC_4);
		
		JLabel lblD = new JLabel("D");
		lblD.setBounds(114, 182, 128, 143);
		panel.add(lblD);
		
		JLabel lblD_1 = new JLabel("D_1");
		lblD_1.setBounds(244, 172, 52, 68);
		panel.add(lblD_1);
		
		JLabel lblD_2 = new JLabel("D_2");
		lblD_2.setBounds(201, 147, 41, 53);
		panel.add(lblD_2);
		
		JLabel lblE = new JLabel("E");
		lblE.setBounds(298, 198, 148, 122);
		panel.add(lblE);
		
		JLabel lblE_1 = new JLabel("E_1");
		lblE_1.setBounds(430, 240, 56, 81);
		panel.add(lblE_1);
		
		JLabel lblE_2 = new JLabel("E_2");
		lblE_2.setBounds(408, 172, 38, 28);
		panel.add(lblE_2);
		
		JLabel lblF = new JLabel("F");
		lblF.setBounds(94, 45, 103, 137);
		panel.add(lblF);
		
		JLabel lblF_1 = new JLabel("F_1");
		lblF_1.setBounds(170, 45, 166, 102);
		panel.add(lblF_1);
		
		JLabel lblF_2 = new JLabel("F_2");
		lblF_2.setBounds(232, 126, 103, 44);
		panel.add(lblF_2);
		
		JLabel lblF_3 = new JLabel("F_3");
		lblF_3.setBounds(298, 167, 38, 33);
		panel.add(lblF_3);
		
		JLabel lblG = new JLabel("G");
		lblG.setBounds(334, 59, 113, 143);
		panel.add(lblG);
		
		JLabel lblG_1 = new JLabel("G_1");
		lblG_1.setBounds(430, 90, 88, 92);
		panel.add(lblG_1);
		
		JLabel lblG_2 = new JLabel("G_2");
		lblG_2.setBounds(407, 26, 79, 38);
		panel.add(lblG_2);
		
		JLabel lblG_3 = new JLabel("G_3");
		lblG_3.setBounds(469, 96, 91, 38);
		panel.add(lblG_3);
		
		JLabel lblG_4 = new JLabel("G_4");
		lblG_4.setBounds(439, 5, 49, 155);
		panel.add(lblG_4);
		
		JLabel lblG_5 = new JLabel("G_5");
		lblG_5.setBounds(439, 147, 92, 17);
		panel.add(lblG_5);
		
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
					actions(0, 1); // 1 - akcija za unos, 2 - akcija za trazenje pomoci, 3 - akcija za obavijest da je riješeno
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
		frame.getContentPane().add(btnCallForHelp);
		frame.getContentPane().add(btnSolved);
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
	
	public static Connection actions(int id, int type) throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//String url = "jdbc:mysql://localhost:3306/denver?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String query;
			if (type == 1) {
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
			} else if (type == 2) {
				String pod = "None";
				
				query = "SELECT Podrucje FROM user WHERE ID='" + id + "'";
				
			    Statement st = con.createStatement();
			    
			    ResultSet rs = st.executeQuery(query);
			    
			    while (rs.next()) {
			        pod = rs.getString("Podrucje");
			    }
			    
				query = "INSERT INTO critical (id_patrola, podrucje, isCrit) VALUES ('" + id + "', '" + pod + "', true)";
			      
			    st.executeUpdate(query);
			    
			    System.out.println("Uspjeh.");
			} else {
				query = "UPDATE critical SET isCrit=False WHERE id_patrola='" + id + "'";
				
			    Statement st = con.createStatement();
			      
			    st.executeUpdate(query);
			    
			    System.out.println("Uspjeh.");
			}
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}