package denvercrime;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JTextPane;

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
	
	//deklaracija labela
	private static JLabel lblA, lblB, lblC1, lblC2, lblD, lblE1, lblE2, lblF, lblG;
	
	
	public void main(int id, String podrucje) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_patrola window = new Gui_patrola(id, podrucje);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Gui_patrola(int id, String podrucje) {
		try {
			initialize(id, podrucje);
			try {
				actions(id, 4); // 4 - za provjeru koje je boje polje na mapi
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void initialize(int id, String podrucje) throws IOException {
		
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
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtPatrola = new JTextField();
		txtPatrola.setBounds(24, 25, 311, 79);
		txtPatrola.setEditable(false);
		txtPatrola.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtPatrola.setHorizontalAlignment(SwingConstants.LEFT);
		txtPatrola.setText("Patrola br." + id + " - Područje " + podrucje);
		txtPatrola.setBackground(Color.WHITE);
		txtPatrola.setColumns(15);
		
		JButton btnCallForHelp = new JButton("Zatrazi pojacanje");
		btnCallForHelp.setBounds(704, 142, 192, 68);
		btnCallForHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					actions(id, 2);
				} catch (Exception e1) {
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
					e1.printStackTrace();
				} // 1 - akcija za unos, 2 - akcija za trazenje pomoci, 3 - akcija za obavijest da je rije�eno
			}
		});
		btnSolved.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBounds(1321, 31, 117, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
        		Gui_login guilogin = new Gui_login();
        		guilogin.main(null);
			}
		});
		

		BufferedImage image = null;
		image = ImageIO.read(new File("C:\\Users\\Aspire\\eclipse-workspace\\Programsko\\src\\denvercrime\\denver1.jpg"));
		
		panel_1 = new JPanel();
		panel_1.setBounds(50, 157, 570, 550);
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
		
		///MIJENJANJE BOJE ZA DISTRICTE
		if(false) { 
			A1.setBackground(Color.RED);
			A3.setBackground(Color.RED);
			A2.setBackground(Color.RED);
			AC.setBackground(Color.RED);
			AE1.setBackground(Color.RED);
			AD.setBackground(Color.RED);
			AB.setBackground(Color.RED);
			Atxt.setBackground(new Color(255, 0, 0));
			
			//crveni districti
			lblA.setBackground(new Color(255,0,0,64));
			lblB.setBackground(new Color(255,0,0,64));
			lblC1.setBackground(new Color(255,0,0,64));
			lblC2.setBackground(new Color(255,0,0,64));
			lblD.setBackground(new Color(255,0,0,64));
			lblE1.setBackground(new Color(255,0,0,64));
			lblE2.setBackground(new Color(255,0,0,64));
			lblF.setBackground(new Color(255,0,0,64));
			lblG.setBackground(new Color(255,0,0,64));
		} 
		
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
					actions(0, 1); // 1 - akcija za unos, 2 - akcija za trazenje pomoci, 3 - akcija za obavijest da je rije�eno
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		
		neighborhood = new JTextField();
		neighborhood.setBounds(968, 604, 151, 30);
		neighborhood.setColumns(10);
		
		ERROR_forma = new JTextField();
		ERROR_forma.setText("Molimo vas unesite ispravne podatke!");
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
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(375, 269, 226, 5);
		frame.getContentPane().add(panel_6);
		panel_6.setBackground(Color.RED);
	}
	
	public static Connection actions(int id, int type) throws Exception{
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
					ERROR_forma.setText("Molimo vas unesite ispravne podatke!");
					ERROR_forma.setBackground(Color.RED);
					ERROR_forma.setVisible(true);
				} else  {
					if( off.equals("traffic") || off.equals("Traffic") ) {
						query = "INSERT INTO crime (OFFENSE, Date, District, Neighborhood, isCrime, isTraffic) VALUES ('" + off + "', '" + date + "', '" + dist + "', '" + neigh + "', false, true)";
					} else {
						query = "INSERT INTO crime (OFFENSE, Date, District, Neighborhood, isCrime, isTraffic) VALUES ('" + off + "', '" + date + "', '" + dist + "', '" + neigh + "', true, false)";
					}
					
					System.out.println(query);
				      Statement st = con.createStatement();
				      st.executeUpdate(query);
				      st.close();
				      
				      neighborhood.setText("");
				      offense.setSelectedIndex(0);
				      ampm.setSelectedIndex(0);
				      district.setSelectedIndex(0);
						ERROR_forma.setText("Unos zočina uspješan!");
						ERROR_forma.setBackground(Color.GREEN);
						ERROR_forma.setVisible(true);
					System.out.println("Uspjeh.");
				}
			} else if (type == 2) {
				
				ERROR_forma.setText("Uspješno zatraženo pojačanje!");
				ERROR_forma.setBackground(Color.GREEN);
				ERROR_forma.setVisible(true);
				
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
			} else if (type == 3) {
				
				ERROR_forma.setText("Potvrđena rješenost situacije!");
				ERROR_forma.setBackground(Color.GREEN);
				ERROR_forma.setVisible(true);
				
				String pod = "None";
				
				query = "SELECT Podrucje FROM critical WHERE id_patrola='" + id + "' AND isCrit=True";
				
			    Statement st = con.createStatement();
			    ResultSet rs = st.executeQuery(query);
			    
			    while (rs.next()) {
			        pod = rs.getString("Podrucje");
			    }
				query = "UPDATE critical SET isCrit=False WHERE id_patrola='" + id + "'";
			    st.executeUpdate(query);
			    System.out.println("Uspjeh.");
			    
			    if (pod.equals("A")) {
			    	lblA.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("B")) {
			    	lblB.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("C")) {
			    	lblC1.setBackground(new Color(255,0,0,0));
					lblC2.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("D")) {
			    	lblD.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("E")) {
			    	lblE1.setBackground(new Color(255,0,0,0));
					lblE2.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("F")) {
			    	lblF.setBackground(new Color(255,0,0,0));
			    } else if (pod.equals("G")) {
			    	lblG.setBackground(new Color(255,0,0,0));
			    }
			} else {
				String pod = "None";
				
				query = "SELECT Podrucje FROM critical WHERE isCrit=True";
			    Statement st = con.createStatement();
			    ResultSet rs = st.executeQuery(query);
			    
			    while (rs.next()) {
			        pod = rs.getString("Podrucje");
			        
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
			}
			 
			return con;
		} catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}