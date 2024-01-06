//import javax.swing.*;
//import java.sql.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
// 
//class LoginFrame extends JFrame implements ActionListener {
// 
//    Container container = getContentPane();
//    
//    JLabel emailLabel = new JLabel("EMAIL");
//    JLabel passwordLabel = new JLabel("PASSWORD");
//    JTextField emailTextField = new JTextField();
//    JPasswordField passwordField = new JPasswordField();
//    JButton loginButton = new JButton("LOGIN");
//    JButton resetButton = new JButton("RESET");
//    JButton backButton = new JButton("BACK");
//    JCheckBox showPassword = new JCheckBox("Show Password");
// 
// 
//    LoginFrame() {
//    	setTitle("Login Form");
//        container.setBackground(Color.PINK);
//        setLayoutManager();
//    	setBounds(100,100,370,600);
//        setLocationAndSize();
//        addComponentsToContainer();
//        addActionEvent();
// 
//    }
// 
//    public void setLayoutManager() {
//        container.setLayout(null);
//    }
// 
//    public void setLocationAndSize() {
//        emailLabel.setBounds(50, 150, 100, 30);
//        passwordLabel.setBounds(50, 220, 100, 30);
//        emailTextField.setBounds(150, 150, 150, 30);
//        passwordField.setBounds(150, 220, 150, 30);
//        showPassword.setBounds(150, 250, 150, 30);
//        loginButton.setBounds(50, 300, 100, 30);
//        resetButton.setBounds(200, 300, 100, 30);
//        backButton.setBounds(125,350,100,30);
// 
// 
//    }
// 
//    public void addComponentsToContainer() {
//        container.add(emailLabel);
//        container.add(passwordLabel);
//        container.add(emailTextField);
//        container.add(passwordField);
//        container.add(showPassword);
//        container.add(loginButton);
//        container.add(resetButton);
//        container.add(backButton);
//    }
// 
//    public void addActionEvent() {
//        loginButton.addActionListener(this);
//        resetButton.addActionListener(this);
//        showPassword.addActionListener(this);
//        backButton.addActionListener(this);
//        backButton.addActionListener(this);
//    }
// 
// 
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//         //going back to register page
//         if (e.getSource() == backButton)
//        {  
//                JOptionPane.showMessageDialog(this, "back");
//                //back to register page
//             this.setVisible(false);
//               new Registration().setVisible(true);
//                this.dispose();
//        }
//
//        // LOGIN button
//        if (e.getSource() == loginButton) {
//        	
//        	
//        	//s
//        	loginButton.addActionListener(new ActionListener() {
//    			public void actionPerformed(ActionEvent e) {
//    				try {
//    					 Class.forName("com.mysql.cj.jdbc.Driver");
//    					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
//    					// PreparedStatement pr=conn.prepareStatement("select *from user_register where U='"+emailTextField.getText()+"' and Password='"+passwordField.getText().toString()+"' ");				     
//    					 Statement st=conn.createStatement();				     
//    					 String r="select *from user_registration where UEmail='"+emailTextField.getText().toString()+"' and UPassword='"+passwordField.getText().toString()+"'";
//    				     ResultSet rs=st.executeQuery(r);
//    					 if(rs.next()) {
//    						 HomePageGUI home=new HomePageGUI();
//    						 home.setVisible(true);
//    						 setBounds(100, 100, 570, 800);
//    			                //this.dispose();
//    						 JOptionPane.showMessageDialog(null, "login Sucessfully!");}
//    					 else {
//    						 JOptionPane.showMessageDialog(null, "login Unsucessfully!");
//    					 }
//    						}catch(Exception e1) {
//    					System.out.println(e1);
//    				}
//    				
//    			}
//    		});		
//        	
// 
//        }
//        // RESET button
//        if (e.getSource() == resetButton) {
//            emailTextField.setText("");
//            passwordField.setText("");
//        }
//       // showPassword 
//        if (e.getSource() == showPassword) {
//            if (showPassword.isSelected()) {
//                passwordField.setEchoChar((char) 0);
//            } else {
//                passwordField.setEchoChar('*');
//            }
//
//       
//         
// 
// 
//        }
//    }
// 
//}
// 
//public class LoginPage {
//    public static void main(String[] a) {
//        LoginFrame frame = new LoginFrame();
//        frame.setTitle("Login Form");
//        frame.setBackground(Color.RED);
//        frame.setVisible(true);
//        frame.setBounds(100, 100, 370, 600);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
// 
//    }
// 
//}
//
//



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JPanel {
    private JButton backButton;
    private JFrame mainFrame;
    private CardLayout cardLayout;
    private JPanel cardPanel;


    public Login(CardLayout cardLayout, JPanel cardPanel, JFrame mainFrame) {
          this.cardLayout = cardLayout;
          this.cardPanel = cardPanel;
    	  this.mainFrame=mainFrame;

        setLayout(null);

        JLabel emailLabel = new JLabel("EMAIL");
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        emailLabel.setSize(100, 30);
        emailLabel.setBounds(88, 148, 100, 30);
        add(emailLabel);

        JLabel passwordLabel = new JLabel("PASSWORD");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        passwordLabel.setSize(150, 30);
        passwordLabel.setBounds(88, 218, 150, 30);
        add(passwordLabel);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailTextField.setSize(150, 30);
        emailTextField.setBounds(217, 150, 150, 30);
        add(emailTextField);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setSize(150, 30);
        passwordField.setBounds(217, 220, 150, 30);
        add(passwordField);

        JButton loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor", "root", "12345");
                    Statement st = conn.createStatement();
                    String r = "select *from user_registration where UEmail='" + emailTextField.getText() + "' and UPassword='" + passwordField.getText().toString() + "'";
                    ResultSet rs = st.executeQuery(r);
                    if (rs.next()) {
                        System.out.println("Login Successfully!");
                        HomePageGUI homePage = new HomePageGUI();
                        homePage.setVisible(true);

                        // Dispose of the login frame
                        mainFrame.dispose();
                        	
                    } else {
                        System.out.println("Login Unsuccessfully!");
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
        });
        loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
        loginButton.setSize(100, 30);
        loginButton.setBounds(114, 300, 100, 30);
        add(loginButton);

        JButton resetButton = new JButton("RESET");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                emailTextField.setText("");
                passwordField.setText("");
            }
        });
        resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
        resetButton.setSize(100, 30);
        resetButton.setBounds(246, 300, 100, 30);
        add(resetButton);

        backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "registration");
            }
        });
        backButton.addActionListener(e -> cardLayout.show(cardPanel, "registration"));

        backButton.setFont(new Font("Arial", Font.PLAIN, 15));
        backButton.setSize(150, 30);
        backButton.setBounds(172, 343, 100, 30);
        add(backButton);
        
        JLabel lblNewLabel = new JLabel("Login Page");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        lblNewLabel.setBounds(159, 66, 208, 40);
        add(lblNewLabel);
    }
}
