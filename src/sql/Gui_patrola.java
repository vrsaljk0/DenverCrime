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

public class Gui_patrola {

	private JFrame frame;
	private static JTextField txtPatrola;
	private static JTextField textField_1;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_7;
	private JTextField txtUnosZlocina;
	private static JTextField txtIdKategorijePrekrajazlocina;
	private static JTextField txtDatumPrijavePrekrajazlocina;
	private static JTextField txtIdDistriktaPrekrajazlocina;
	private static JTextField txtIdSusjedstvaPrekrajazlocina;
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
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
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 13));
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(300, 300, 1250, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtPatrola = new JTextField();
		txtPatrola.setEditable(false);
		txtPatrola.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtPatrola.setHorizontalAlignment(SwingConstants.LEFT);
		txtPatrola.setText("Patrola");
		txtPatrola.setBackground(UIManager.getColor("Button.darkShadow"));
		txtPatrola.setColumns(15);
		
		JButton btnNewButton = new JButton("ZatraÅ¾i pojaÄ�anje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		
		JButton btnNewButton_1 = new JButton("Situacija je rjeÅ¡ena");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
        		Gui_login guilogin = new Gui_login();
        		guilogin.main(null);
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		BufferedImage image = null;
		//image = ImageIO.read(new File("C:\\Users\\Lukaku\\Documents\\programsko\\bin\\sql\\denver1.jpg"));
		image = ImageIO.read(new File("C:\\Romano\\2.god\\Objektno\\eclipse_vj\\MySql-vjezba\\src\\sql\\denver1.jpg"));
		
		panel_1 = new JPanel();
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
		txtUnosZlocina.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtUnosZlocina.setText("Unos zlocina :\r\n ");
		txtUnosZlocina.setEditable(false);
		txtUnosZlocina.setColumns(10);
		
		txtIdKategorijePrekrajazlocina = new JTextField();
		txtIdKategorijePrekrajazlocina.setText("ID kategorije prekr\u0161aja/zlocina:");
		txtIdKategorijePrekrajazlocina.setEditable(false);
		txtIdKategorijePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdKategorijePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		txtIdKategorijePrekrajazlocina.setColumns(10);
		
		txtDatumPrijavePrekrajazlocina = new JTextField();
		txtDatumPrijavePrekrajazlocina.setText("Datum prijave prekr\u0161aja/zlocina:");
		txtDatumPrijavePrekrajazlocina.setEditable(false);
		txtDatumPrijavePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtDatumPrijavePrekrajazlocina.setColumns(10);
		txtDatumPrijavePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdDistriktaPrekrajazlocina = new JTextField();
		txtIdDistriktaPrekrajazlocina.setText("ID distrikta prekr\u0161aja/zlocina:");
		txtIdDistriktaPrekrajazlocina.setEditable(false);
		txtIdDistriktaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdDistriktaPrekrajazlocina.setColumns(10);
		txtIdDistriktaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdSusjedstvaPrekrajazlocina = new JTextField();
		txtIdSusjedstvaPrekrajazlocina.setText("ID susjedstva prekr\u0161aja/zlocina:");
		txtIdSusjedstvaPrekrajazlocina.setEditable(false);
		txtIdSusjedstvaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdSusjedstvaPrekrajazlocina.setColumns(10);
		txtIdSusjedstvaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		JButton btnUnos = new JButton("Unesi");
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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(txtPatrola, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(883)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(824)
					.addComponent(txtUnosZlocina, 238, 238, 238)
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(99)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdKategorijePrekrajazlocina, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addComponent(txtDatumPrijavePrekrajazlocina, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addComponent(txtIdDistriktaPrekrajazlocina, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addComponent(txtIdSusjedstvaPrekrajazlocina, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
									.addGap(71))))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnUnos)))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
							.addGap(50))
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(txtPatrola, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
						.addComponent(btnNewButton_2))
					.addGap(67)
					.addComponent(txtUnosZlocina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(txtIdKategorijePrekrajazlocina, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(txtDatumPrijavePrekrajazlocina, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(txtIdDistriktaPrekrajazlocina, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(txtIdSusjedstvaPrekrajazlocina, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(47)
							.addComponent(btnUnos, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
							.addGap(101)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(63)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(59)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(58)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(171)
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
		);
		frame.getContentPane().setLayout(groupLayout);
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
			
			String off = textField_5.getText();
			String date = textField_1.getText();
			String dist = textField_4.getText();
			String neigh = textField_7.getText();
			
			System.out.println(off);
			
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
		      
		      textField_5.setText("");
		      textField_1.setText("");
		      textField_4.setText("");
		      textField_7.setText("");
			
			System.out.println("Uspjeh.");
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
