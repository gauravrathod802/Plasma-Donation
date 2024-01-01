import java.awt.BorderLayout;
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
import javax.swing.JLabel;
import javax.swing.JButton;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField donorid;
	private JTextField dname;
	private JTextField bloodgrp;
	private JTextField city;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		donorid = new JTextField();
		donorid.setBounds(29, 71, 116, 22);
		contentPane.add(donorid);
		donorid.setColumns(10);
		
		dname = new JTextField();
		dname.setBounds(29, 106, 116, 22);
		contentPane.add(dname);
		dname.setColumns(10);
		
		bloodgrp = new JTextField();
		bloodgrp.setBounds(29, 141, 116, 22);
		contentPane.add(bloodgrp);
		bloodgrp.setColumns(10);
		
		city = new JTextField();
		city.setBounds(29, 176, 116, 22);
		contentPane.add(city);
		city.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(29, 38, 116, 22);
		contentPane.add(email);
		
		JLabel lblNewLabel = new JLabel("Home page");
		lblNewLabel.setBounds(29, 0, 56, 16);
		contentPane.add(lblNewLabel);
		
		JButton donor = new JButton("Donor");
		donor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.cj.jdbc.Driver");
					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
					 PreparedStatement pr=conn.prepareStatement("insert into donor(DonorId,Dname,BloodGrp,City,Email) values(?,?,?,?,?)");
				     pr.setString(1,donorid.getText());
				     pr.setString(2,dname.getText());
				     pr.setString(3,bloodgrp.getText());
				     pr.setString(4,city.getText());
				     pr.setString(5,email.getText());
				     int x=pr.executeUpdate();
				     if(x>0) {
				    	 System.out.print("Data inserted Sucessfully!");
				     }else {
				    	 System.out.print("Registration unsucessful");
					     	 
				     }
				}catch(Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		donor.setBounds(12, 211, 97, 25);
		contentPane.add(donor);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(261, 211, 97, 25);
		contentPane.add(btnNewButton_1);
	}

}
