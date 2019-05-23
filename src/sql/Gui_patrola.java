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

public class Gui_patrola {

	private JFrame frame;
	private static JTextField txtPatrola;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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
		frame.getContentPane().setBackground(UIManager.getColor("Button.darkShadow"));
		frame.setBounds(300, 300, 1250, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtPatrola = new JTextField();
		txtPatrola.setEditable(false);
		txtPatrola.setFont(new Font("Century Schoolbook L", Font.BOLD, 20));
		txtPatrola.setHorizontalAlignment(SwingConstants.LEFT);
		txtPatrola.setText("Patrola");
		txtPatrola.setBackground(UIManager.getColor("Button.darkShadow"));
		txtPatrola.setBounds(22, 20, 200, 39);
		frame.getContentPane().add(txtPatrola);
		txtPatrola.setColumns(15);
		
		textField = new JTextField();
		textField.setBounds(738, 246, 150, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("ZatraÅ¾i pojaÄ�anje");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(UIManager.getColor("OptionPane.errorDialog.border.background"));
		btnNewButton.setBounds(712, 709, 200, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Situacija je rjeÅ¡ena");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.shadow"));
		btnNewButton_1.setBounds(984, 709, 200, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.setBounds(1105, 12, 117, 25);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
        		Gui_login guilogin = new Gui_login();
        		guilogin.main(null);
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(984, 335, 150, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(738, 335, 150, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(738, 420, 150, 30);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(984, 420, 150, 30);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(984, 246, 150, 30);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(738, 503, 150, 30);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(984, 508, 150, 30);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(738, 595, 150, 30);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(984, 595, 150, 30);
		frame.getContentPane().add(textField_9);
		
		JPanel panel = new JPanel();
		panel.setBounds(43, 183, 570, 550);
		BufferedImage image = null;
		image = ImageIO.read(new File("C:\\\\Romano\\\\2.god\\\\Objektno\\\\eclipse_vj\\\\MySql-vjezba\\\\src\\\\sql\\\\denver1.jpg"));
		Image scaledImage = image.getScaledInstance(panel.getWidth(),panel.getHeight(),Image.SCALE_SMOOTH);
		panel.add(new JLabel(new ImageIcon(scaledImage)));
		frame.getContentPane().add(panel);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
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
