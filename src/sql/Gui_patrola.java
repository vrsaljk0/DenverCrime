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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Gui_patrola {

	private JFrame frame;
	private static JTextField txtPatrola;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField txtUnosZlocina;
	private JTextField txtIdKategorijePrekrajazlocina;
	private JTextField txtDatumPrijavePrekrajazlocina;
	private JTextField txtIdDistriktaPrekrajazlocina;
	private JTextField txtIdSusjedstvaPrekrajazlocina;
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
		try {
			getConnection(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		image = ImageIO.read(new File("C:\\Users\\Lukaku\\Documents\\programsko\\bin\\sql\\denver1.jpg"));
		
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
		txtIdKategorijePrekrajazlocina.setText("ID kategorije prekr\u0161aja/zlocina       :");
		txtIdKategorijePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdKategorijePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		txtIdKategorijePrekrajazlocina.setColumns(10);
		
		txtDatumPrijavePrekrajazlocina = new JTextField();
		txtDatumPrijavePrekrajazlocina.setText("Datum prijave prekr\u0161aja/zlocina     :");
		txtDatumPrijavePrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtDatumPrijavePrekrajazlocina.setColumns(10);
		txtDatumPrijavePrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdDistriktaPrekrajazlocina = new JTextField();
		txtIdDistriktaPrekrajazlocina.setText("ID distrikta prekr\u0161aja/zlocina          :");
		txtIdDistriktaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdDistriktaPrekrajazlocina.setColumns(10);
		txtIdDistriktaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		
		txtIdSusjedstvaPrekrajazlocina = new JTextField();
		txtIdSusjedstvaPrekrajazlocina.setText("ID susjedstva prekr\u0161aja/zlocina      :");
		txtIdSusjedstvaPrekrajazlocina.setHorizontalAlignment(SwingConstants.LEFT);
		txtIdSusjedstvaPrekrajazlocina.setColumns(10);
		txtIdSusjedstvaPrekrajazlocina.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(txtPatrola, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
					.addGap(883)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(824)
					.addComponent(txtUnosZlocina)
					.addGap(172))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtIdKategorijePrekrajazlocina, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(txtDatumPrijavePrekrajazlocina, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(txtIdDistriktaPrekrajazlocina, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addComponent(txtIdSusjedstvaPrekrajazlocina, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
							.addGap(71)))
					.addGap(1)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(50))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addGap(50))
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGap(48))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addComponent(txtPatrola, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
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
							.addGap(171)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
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

			String query = "SELECT * FROM user WHERE ID=" + id;

		      // create the java statement
		      Statement st = con.createStatement();
		      
		      // execute the query, and get a java resultset
		      ResultSet rs = st.executeQuery(query);
		      
		      // iterate through the java resultset
		      txtPatrola.setText("Patrola " + id);
		      System.out.println(txtPatrola.getText());
		      while (rs.next())
		      {
		        Integer ID = rs.getInt("ID");
		        String user = rs.getString("Username");
		        String pas = rs.getString("Lozinka");
		        String ime = rs.getString("Ime");
		        String prezime = rs.getString("Prezime");
		        String role = rs.getString("Uloga");
		        
		        
		        	
		      }
		      st.close();
			 
			return con;
		}catch( Exception e ) {
			System.out.println(e);
		}
		return null;
	}
}
