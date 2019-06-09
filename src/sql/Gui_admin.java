package denvercrime;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
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
import javax.swing.JScrollPane;

public class Gui_admin {
	private static String[] patrol = new String[100];
	private static String[] district = {"A", "B", "C", "D", "E", "F", "G"};
	private String[] algorithm = {"Odaberi algoritam", "Apriori", "FP-Growth"};

	private static JFrame frame;
	private JPanel panel_1;
	private JTextField txtAdministrator;
	private static JComboBox<String> patrols;
	private static JComboBox<String> districts;
	private JComboBox<String> algoritamCombo;
	private static JTextField message;
	
	//deklaracija labela
	private static JLabel lblA, lblB, lblC1, lblC2, lblD, lblE1, lblE2, lblF, lblG;

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

	public Gui_admin() {
		try {
			try {
				getConnection(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			initialize();
			try {
				initCheck(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtAdministrator = new JTextField();
		txtAdministrator.setEditable(false);
		txtAdministrator.setBackground(Color.WHITE);
		txtAdministrator.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtAdministrator.setText("Administrator");
		txtAdministrator.setBounds(15, 15, 200, 39);
		frame.getContentPane().add(txtAdministrator);
		txtAdministrator.setColumns(10);
		
		JTextArea textArea = new JTextArea("");
		textArea.setWrapStyleWord(true);
		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(659, 198, 538, 250);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scroll);
		
		JButton btnMine = new JButton("Mine");
		btnMine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String act = (String) algoritamCombo.getSelectedItem();
				if (act.equals("Apriori")) {
					try {
						Mining.getRules();
						textArea.setText(Mining.getRules());
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (act.equals("FP-Growth")) {
					try {
						Mining.getRulesFP();
						textArea.setText(Mining.getRulesFP());
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					textArea.setText("Potrebno je odabrati algoritam kako bi se ispisali rulovi!");
				}
			}
		});
		btnMine.setBounds(816, 131, 117, 25);
		frame.getContentPane().add(btnMine);
		
		patrols = new JComboBox(patrol);
		patrols.setToolTipText("");
		patrols.setBounds(679, 501, 170, 24);
		frame.getContentPane().add(patrols);
		
		districts = new JComboBox(district);
		districts.setToolTipText("");
		districts.setBounds(849, 501, 170, 24);
		frame.getContentPane().add(districts);
		
		JButton btnPreusmjeri = new JButton("Preusmjeri");
		btnPreusmjeri.setBounds(1036, 501, 170, 25);
		btnPreusmjeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					action(1); //preusmjeravanje
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnPreusmjeri);
		
		JButton btnPoaljiPojaanje = new JButton("Posalji pojacanje");
		btnPoaljiPojaanje.setBounds(1036, 525, 170, 25);
		btnPoaljiPojaanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					action(2); //slanje pojaèanja
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		btnLogOut.setBounds(1329, 26, 117, 25);
		frame.getContentPane().add(btnLogOut);
		
		BufferedImage image = null;
		image = ImageIO.read(new File("C:\\Users\\Aspire\\eclipse-workspace\\Programsko\\src\\denvercrime\\denver1.jpg")); //putanja za sliku
		
		panel_1 = new JPanel();
		panel_1.setBounds(45, 86, 570, 550);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 570, 550);
		panel_1.add(panel);
		Image scaledImage = image.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_SMOOTH);
		panel.setLayout(null);
		
		lblA = new JLabel("");
		lblA.setBackground(new Color(255,0,0,0));
		lblA.setOpaque(true);
		lblA.setBounds(86, 55, 189, 138);
		panel.add(lblA);
		
		lblB = new JLabel("");
		lblB.setBackground(new Color(255,0,0,0));
		lblB.setOpaque(true);
		lblB.setBounds(271, 0, 289, 163);
		panel.add(lblB);
		
		lblC1 = new JLabel("");
		lblC1.setBackground(new Color(255,0,0,0));
		lblC1.setOpaque(true);
		lblC1.setBounds(111, 193, 134, 163);
		panel.add(lblC1);
		
		lblC2 = new JLabel("");
		lblC2.setBackground(new Color(255,0,0,0));
		lblC2.setOpaque(true);
		lblC2.setBounds(202, 356, 43, 42);
		panel.add(lblC2);
		
		lblD = new JLabel("");
		lblD.setBackground(new Color(255,0,0,0));
		lblD.setOpaque(true);
		lblD.setBounds(241, 193, 90, 246);
		panel.add(lblD);
		
		lblE1 = new JLabel("");
		lblE1.setBackground(new Color(255,0,0,0));
		lblE1.setOpaque(true);
		lblE1.setBounds(333, 163, 150, 114);
		panel.add(lblE1);
		
		lblE2 = new JLabel("");
		lblE2.setBackground(new Color(255,0,0,0));
		lblE2.setOpaque(true);
		lblE2.setBounds(271, 163, 64, 32);
		panel.add(lblE2);
		
		lblF = new JLabel("");
		lblF.setBackground(new Color(255,0,0,0));
		lblF.setOpaque(true);
		lblF.setBounds(3, 354, 197, 196);
		panel.add(lblF);
		
		lblG = new JLabel("");
		lblG.setBackground(new Color(255,0,0,0)); 
		lblG.setOpaque(true);
		lblG.setBounds(333, 274, 188, 246);
		panel.add(lblG);
		
		JPanel B1 = new JPanel();
		B1.setBackground(Color.BLACK);
		B1.setBounds(271, 0, 4, 56);
		panel.add(B1);
		
		JPanel AB = new JPanel();
		AB.setBackground(Color.BLACK);
		AB.setBounds(271, 55, 4, 108);
		panel.add(AB);
		
		JPanel B2 = new JPanel();
		B2.setBackground(Color.BLACK);
		B2.setBounds(271, 0, 289, 4);
		panel.add(B2);
		
		JPanel B3 = new JPanel();
		B3.setBackground(Color.BLACK);
		B3.setBounds(482, 163, 78, 4);
		panel.add(B3);
		
		JPanel B4 = new JPanel();
		B4.setBackground(Color.BLACK);
		B4.setBounds(556, 0, 4, 163);
		panel.add(B4);
		
		JPanel F1 = new JPanel();
		F1.setBackground(Color.BLACK);
		F1.setBounds(3, 354, 112, 4);
		panel.add(F1);
		
		JPanel F2 = new JPanel();
		F2.setBackground(Color.BLACK);
		F2.setBounds(0, 354, 4, 196);
		panel.add(F2);
		
		JPanel F3 = new JPanel();
		F3.setBackground(Color.BLACK);
		F3.setBounds(199, 398, 4, 152);
		panel.add(F3);
		
		JPanel F4 = new JPanel();
		F4.setBackground(Color.BLACK);
		F4.setBounds(0, 545, 200, 4);
		panel.add(F4);
		
		JPanel A1 = new JPanel();
		A1.setBackground(Color.BLACK);
		A1.setBounds(86, 52, 189, 4);
		panel.add(A1);
		
		JPanel A2 = new JPanel();
		A2.setBackground(Color.BLACK);
		A2.setBounds(86, 193, 29, 4);
		panel.add(A2);
		
		JPanel A3 = new JPanel();
		A3.setBackground(Color.BLACK);
		A3.setBounds(85, 52, 4, 145);
		panel.add(A3);
		
		JPanel A4 = new JPanel();
		A4.setBackground(Color.BLACK);
		A4.setBounds(271, 52, 4, 113);
		panel.add(A4);
		
		JPanel C1 = new JPanel();
		C1.setBackground(Color.BLACK);
		C1.setBounds(111, 193, 4, 166);
		panel.add(C1);
		
		JPanel CD = new JPanel();
		CD.setBackground(Color.BLACK);
		CD.setBounds(241, 193, 4, 207);
		panel.add(CD);
		
		JPanel C3 = new JPanel();
		C3.setBackground(Color.BLACK);
		C3.setBounds(199, 396, 43, 4);
		panel.add(C3);
		
		JPanel CF = new JPanel();
		CF.setBackground(Color.BLACK);
		CF.setBounds(111, 354, 92, 5);
		panel.add(CF);
		
		JPanel CF2 = new JPanel();
		CF2.setBackground(Color.BLACK);
		CF2.setBounds(199, 357, 4, 43);
		panel.add(CF2);
		
		JPanel AE1 = new JPanel();
		AE1.setBackground(Color.BLACK);
		AE1.setBounds(271, 163, 4, 32);
		panel.add(AE1);
		
		JPanel BE1 = new JPanel();
		BE1.setBackground(Color.BLACK);
		BE1.setBounds(271, 163, 214, 4);
		panel.add(BE1);
		
		JPanel EG = new JPanel();
		EG.setBackground(Color.BLACK);
		EG.setBounds(332, 273, 154, 4);
		panel.add(EG);
		
		JPanel E4 = new JPanel();
		E4.setBackground(Color.BLACK);
		E4.setBounds(482, 163, 4, 113);
		panel.add(E4);
		
		JPanel DE = new JPanel();
		DE.setBackground(Color.BLACK);
		DE.setBounds(271, 192, 64, 4);
		panel.add(DE);
		
		JPanel E6 = new JPanel();
		E6.setBackground(Color.BLACK);
		E6.setBounds(332, 193, 3, 84);
		panel.add(E6);
		
		JPanel D1 = new JPanel();
		D1.setBackground(Color.BLACK);
		D1.setBounds(241, 397, 4, 43);
		panel.add(D1);
		
		JPanel DE1 = new JPanel();
		DE1.setBackground(Color.BLACK);
		DE1.setBounds(332, 193, 4, 84);
		panel.add(DE1);
		
		JPanel AD = new JPanel();
		AD.setBackground(Color.BLACK);
		AD.setBounds(241, 193, 29, 4);
		panel.add(AD);
		
		JPanel D4 = new JPanel();
		D4.setBackground(Color.BLACK);
		D4.setBounds(241, 435, 92, 5);
		panel.add(D4);
		
		JPanel DG = new JPanel();
		DG.setBackground(Color.BLACK);
		DG.setBounds(332, 273, 4, 167);
		panel.add(DG);
		
		JPanel G2 = new JPanel();
		G2.setBackground(Color.BLACK);
		G2.setBounds(332, 516, 189, 4);
		panel.add(G2);
		
		JPanel G3 = new JPanel();
		G3.setBackground(Color.BLACK);
		G3.setBounds(482, 273, 39, 4);
		panel.add(G3);
		
		JPanel G4 = new JPanel();
		G4.setBackground(Color.BLACK);
		G4.setBounds(517, 273, 4, 247);
		panel.add(G4);
		
		JTextPane Atxt = new JTextPane();
		Atxt.setForeground(new Color(0, 0, 0));
		Atxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Atxt.setBackground(new Color(255, 255, 255));
		Atxt.setText("A");
		Atxt.setBounds(86, 52, 20, 32);
		panel.add(Atxt);
		
		JTextPane Btxt = new JTextPane();
		Btxt.setForeground(new Color(0, 0, 0));
		Btxt.setText("B");
		Btxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Btxt.setBackground(new Color(255, 255, 255));
		Btxt.setBounds(271, 0, 20, 32);
		panel.add(Btxt);
		
		JTextPane Ctxt = new JTextPane();
		Ctxt.setForeground(new Color(0, 0, 0));
		Ctxt.setText("C");
		Ctxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Ctxt.setBackground(new Color(255, 255, 255));
		Ctxt.setBounds(111, 260, 20, 32);
		panel.add(Ctxt);
		
		JTextPane Ftxt = new JTextPane();
		Ftxt.setForeground(new Color(0, 0, 0));
		Ftxt.setText("F");
		Ftxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Ftxt.setBackground(new Color(255, 255, 255));
		Ftxt.setBounds(3, 354, 20, 32);
		panel.add(Ftxt);
		
		JTextPane Dtxt = new JTextPane();
		Dtxt.setForeground(new Color(0, 0, 0));
		Dtxt.setText("D");
		Dtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Dtxt.setBackground(new Color(255, 255, 255));
		Dtxt.setBounds(271, 245, 20, 32);
		panel.add(Dtxt);
		
		JTextPane Etxt = new JTextPane();
		Etxt.setForeground(new Color(0, 0, 0));
		Etxt.setText("E");
		Etxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Etxt.setBackground(new Color(255, 255, 255));
		Etxt.setBounds(463, 205, 20, 32);
		panel.add(Etxt);
		
		JTextPane Gtxt = new JTextPane();
		Gtxt.setForeground(new Color(0, 0, 0));
		Gtxt.setText("G");
		Gtxt.setFont(new Font("Tahoma", Font.BOLD, 20));
		Gtxt.setBackground(new Color(255, 255, 255));
		Gtxt.setBounds(497, 368, 20, 32);
		panel.add(Gtxt);
		
		JPanel AC = new JPanel();
		AC.setBackground(Color.BLACK);
		AC.setBounds(111, 192, 134, 4);
		panel.add(AC);
		
		JPanel G5 = new JPanel();
		G5.setBackground(Color.BLACK);
		G5.setBounds(332, 436, 3, 84);
		panel.add(G5);
		JLabel label = new JLabel(new ImageIcon(scaledImage));
		label.setBounds(0, 0, 570, 550);
		panel.add(label);
		
		frame.getContentPane().add(panel_1);
		
		algoritamCombo = new JComboBox(algorithm);
		algoritamCombo.setToolTipText("Odaberi algoritam");
		algoritamCombo.setBounds(670, 132, 135, 22);
		frame.getContentPane().add(algoritamCombo);
		
		JLabel lblMiningAlgoritam = new JLabel("Mining algoritam:");
		lblMiningAlgoritam.setForeground(Color.WHITE);
		lblMiningAlgoritam.setBounds(679, 107, 105, 14);
		frame.getContentPane().add(lblMiningAlgoritam);
		
		message = new JTextField();
		message.setBounds(679, 159, 499, 29);
		frame.getContentPane().add(message);
		message.setVisible(false);
	}
	
	public static Connection getConnection(int id) throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String query = "SELECT ID FROM user WHERE Uloga='P'";

		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(query);
		      
		    int br = 0;
		    while (rs.next()) {
              Integer ID = rs.getInt("ID");
		      patrol[br++] = "Patrola " + ID.toString();
	          System.out.println(patrol[br-1]);
		    }
		      
			st.close();
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Connection initCheck(int id) throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String pod = "None";
		
			String query = "SELECT Podrucje FROM critical WHERE isCrit=True";

		    Statement st = con.createStatement();
		    ResultSet rs = st.executeQuery(query);
		      
		    while (rs.next()) {
		      pod = rs.getString("podrucje");
		      System.out.println(pod);
		        
		        if (pod.equals("A")) {
	      	        lblA.setBackground(new Color(255,0,0,64));
			    	lblA.setOpaque(true);
			    } else if (pod.equals("B")) {
			    	lblB.setBackground(new Color(255,0,0,64));
			    	lblB.setOpaque(true);
			    } else if (pod.equals("C")) {
			    	lblC1.setBackground(new Color(255,0,0,64));
					lblC2.setBackground(new Color(255,0,0,64));
					lblC1.setOpaque(true);
					lblC2.setOpaque(true);
			    } else if (pod.equals("D")) {
			    	lblD.setBackground(new Color(255,0,0,64));
			    	lblD.setOpaque(true);
			    } else if (pod.equals("E")) {
			    	lblE1.setBackground(new Color(255,0,0,64));
					lblE2.setBackground(new Color(255,0,0,64));
					lblE1.setOpaque(true);
					lblE2.setOpaque(true);
			    } else if (pod.equals("F")) {
			    	lblF.setBackground(new Color(255,0,0,64));
			    	lblF.setOpaque(true);
			    } else if (pod.equals("G")) {
			    	lblG.setBackground(new Color(255,0,0,64));
			    	lblG.setOpaque(true);
			    } 
		    }
			 
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Connection action(int type) throws Exception{
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/denvercrime?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username = "root";
			String password = "";
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("It's connected!!!!!");
			
			String query;
			if (type == 1) {
				message.setText("Patrola uspješno preusmjerena!");
				message.setBackground(Color.GREEN);
				message.setVisible(true);
				
				String pat = (String) patrols.getSelectedItem();
				String pod = (String) districts.getSelectedItem();
				
				query = "UPDATE user SET Podrucje='" + pod + "' WHERE ID='" + pat.charAt(8) + "'";
				
				System.out.println(query);
				Statement st = con.createStatement();
			    st.executeUpdate(query);
			    System.out.println("Uspjeh!!!!");
			     
			    st.close();
			} else {
				message.setText("Pojaèanje uspješno poslano!");
				message.setBackground(Color.GREEN);
				message.setVisible(true);
				
				String sel_pat = (String) patrols.getSelectedItem();
				String sel_pod = (String) districts.getSelectedItem();
				int flag = 0;
				
				query = "SELECT isCrit FROM critical WHERE podrucje='" + sel_pod + "'";
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
			    while (rs.next()) {
			       flag = rs.getInt("isCrit");
			       
			       if (flag == 1) break;
			    }
			    
			    if (flag == 1) {
			    	query = "UPDATE user SET Podrucje='" + sel_pod + "' WHERE ID='" + sel_pat.charAt(8) + "'";
				    st.executeUpdate(query);
				    System.out.println("Uspjeh.");
			    } else {
			    	System.out.println("To podrucje ne treba pojacanje.");
			    }
			}
		      
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
