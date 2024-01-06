//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//class Registration extends JFrame
//{
//	private Container c;
//    private JLabel name;
//    private JTextField tname;
//    private JLabel email;
//    private JTextField temail;
//    private JLabel pass;
//    private JTextField tpass;
//    private JButton sub;
//    private JButton reset;
//    private JButton reset_1;
//    private JButton login;
// 	
//    
//    public Registration() {
//    	setTitle("Registration Form");
//    	setBounds(100,100,370,600);
//    	setDefaultCloseOperation(EXIT_ON_CLOSE);
//    	setResizable(false);
//    	
//    	c=getContentPane();
//    	c.setBackground(Color.PINK);
//    	c.setLayout(null);
//
//    	
//        name = new JLabel("Name");
//        name.setFont(new Font("Arial", Font.PLAIN, 20));
//        name.setSize(100, 20);
//        name.setBounds(50,150,100,30);
//        c.add(name);
// 
//        tname = new JTextField();
//        tname.setFont(new Font("Arial", Font.PLAIN, 15));
//        tname.setSize(190, 20);
//        tname.setBounds(150,150,150,30);
//        c.add(tname);
//        
//        name = new JLabel("E-mail");
//        name.setFont(new Font("Arial", Font.PLAIN, 20));
//        name.setSize(100, 20);
//        name.setBounds(50,220,100,30);
//        c.add(name);
// 
//        temail = new JTextField();
//        temail.setFont(new Font("Arial", Font.PLAIN, 15));
//        temail.setSize(190, 20);
//        temail.setBounds(150,220,150,30);
//        c.add(temail);
//        
//        name = new JLabel("Password");
//        name.setFont(new Font("Arial", Font.PLAIN, 20));
//        name.setSize(100, 20);
//        name.setBounds(50,290,100,30);
//        c.add(name);
// 
//        tpass = new JTextField();
//        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
//        tpass.setSize(190, 20);
//        tpass.setBounds(150,290,150,30);
//        c.add(tpass);
// 
//        sub = new JButton("Register");
//        sub.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        		try {
//					 Class.forName("com.mysql.cj.jdbc.Driver");
//					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
//					 PreparedStatement pr=conn.prepareStatement("insert into user_registration(UName,UEmail,UPassword) values(?,?,?)");
//				     pr.setString(1,tname.getText());
//				     pr.setString(2,temail.getText());
//				     pr.setString(3,tpass.getText());
//				   
//				     int x=pr.executeUpdate();
//				     if(x>0) {
//				    	 System.out.print("Resgistration done Sucessfully!");
//				     }else {
//				    	 System.out.print("Registration unsucessful");
//					     	 
//				     }
//				}catch(Exception e1) {
//					System.out.println(e1);
//				}
//        	}
//        });
//        sub.setFont(new Font("Arial", Font.PLAIN, 15));
//        sub.setSize(150, 30);
//        sub.setBounds(50,350,100,30);
//        c.add(sub);
// 
//        reset = new JButton("Cancel");
//        reset.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        	//onclick cancel button
//        		
//        	    dispose();  
//        }
//        });
//        reset.setFont(new Font("Arial", Font.PLAIN, 15));
//        reset.setSize(150, 30);
//        reset.setBounds(200,350,100,30);
//        c.add(reset);
//        
//        reset_1 = new JButton("Login");
//        reset_1.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent e) {
//        	
//        		LoginFrame loginpage=new LoginFrame();
//				 loginpage.setVisible(true);
//			}
//        });
//        reset_1.setFont(new Font("Arial", Font.PLAIN, 15));
//        reset_1.setSize(150, 30);
//        reset_1.setBounds(125,400,100,30);
//        c.add(reset_1);
//        
//        
//        setVisible(true);
//        
//    }	
//    public static void main(String[] args) 
//    {
//	new Registration();
//    }
//}


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Registration extends JFrame {
    private Container c;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JButton reset_1;
    private JTextField tname, temail, tpass;
    private JLabel messageLabel;

    public Registration() {
        setTitle("Registration Form");
        setBounds(100, 100, 531, 637);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setBackground(Color.PINK);
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Create registration panel
        JPanel registrationPanel = createRegistrationPanel();
        cardPanel.add(registrationPanel, "registration");

        // Create login panel
        Login loginPanel = new Login(cardLayout, cardPanel, this);
        cardPanel.add(loginPanel, "login");

        c.add(cardPanel);

        // Show the registration panel by default
        cardLayout.show(cardPanel, "registration");

        setVisible(true);
    }

    private JPanel createRegistrationPanel() {
        JPanel registrationPanel = new JPanel();
        registrationPanel.setLayout(null);

        JLabel name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setBounds(105, 150, 100, 30);
        registrationPanel.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setBounds(217, 152, 150, 30);
        registrationPanel.add(tname);

        JLabel email = new JLabel("E-mail");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setBounds(105, 218, 100, 30);
        registrationPanel.add(email);

        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setBounds(217, 220, 150, 30);
        registrationPanel.add(temail);

        JLabel pass = new JLabel("Password");
        pass.setFont(new Font("Arial", Font.PLAIN, 20));
        pass.setSize(100, 20);
        pass.setBounds(105, 288, 100, 30);
        registrationPanel.add(pass);

        tpass = new JTextField();
        tpass.setFont(new Font("Arial", Font.PLAIN, 15));
        tpass.setSize(190, 20);
        tpass.setBounds(217, 290, 150, 30);
        registrationPanel.add(tpass);

        JButton sub = new JButton("Register");
        sub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor", "root", "12345");
                    PreparedStatement pr = conn.prepareStatement("insert into user_registration(UName,UEmail,UPassword) values(?,?,?)");
                    pr.setString(1, tname.getText());
                    pr.setString(2, temail.getText());
                    pr.setString(3, tpass.getText());

                    int x = pr.executeUpdate();
                    if (x > 0) {
                        messageLabel.setText("Registration done Successfully!");
                        clearRegistrationFields();
                    } else {
                        messageLabel.setText("Registration unsuccessful");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(150, 30);
        sub.setBounds(144, 350, 100, 30);
        registrationPanel.add(sub);

        reset_1 = new JButton("Login");
        reset_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Switch to the login panel
                cardLayout.show(cardPanel, "login");
            }
        });
        reset_1.setFont(new Font("Arial", Font.PLAIN, 15));
        reset_1.setSize(150, 30);
        reset_1.setBounds(267, 350, 100, 30);
        registrationPanel.add(reset_1);

        // JLabel to display registration messages
        messageLabel = new JLabel("");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        messageLabel.setForeground(Color.GREEN);
        messageLabel.setSize(300, 20);
        messageLabel.setLocation(70, 450);
        registrationPanel.add(messageLabel);
        
        JLabel lblNewLabel = new JLabel("Registration Page");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));

        lblNewLabel.setBounds(170, 60, 222, 60);
        lblNewLabel.setSize(400,50);
        registrationPanel.add(lblNewLabel);
        

        return registrationPanel;
    }

    private void clearRegistrationFields() {
        tname.setText("");
        temail.setText("");
        tpass.setText("");
    }

    public static void main(String[] args) {
        new Registration();
    }
}
