/*import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UserRegister extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField pass;
	private JButton register;
	private JButton btnNewButton_1;

	
	 // Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 //Create the frame.
	
	public UserRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		name = new JTextField();
		name.setBounds(173, 40, 116, 22);
		contentPane.add(name);
		name.setColumns(10);
		
		email = new JTextField();
		email.setBounds(173, 89, 116, 22);
		contentPane.add(email);
		email.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(173, 136, 116, 22);
		contentPane.add(pass);
		pass.setColumns(10);
		
		register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
					 PreparedStatement pr=conn.prepareStatement("insert into user_register(UName,UEmail,UPassword) values(?,?,?)");
				     pr.setString(1,name.getText());
				     pr.setString(2,email.getText());
				     pr.setString(3,pass.getText());
				   
				     int x=pr.executeUpdate();
				     if(x>0) {
				    	 System.out.print("Resgistration done Sucessfully!");
				     }else {
				    	 System.out.print("Registration unsucessful");
					     	 
				     }
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});		
		register.setBounds(65, 176, 97, 25);
		contentPane.add(register);
		
		btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBounds(216, 176, 97, 25);
		contentPane.add(btnNewButton_1);
	}
}


*/