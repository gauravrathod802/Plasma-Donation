import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
class LoginFrame extends JFrame implements ActionListener {
 
    Container container = getContentPane();
    
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField emailTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton backButton = new JButton("BACK");
    JCheckBox showPassword = new JCheckBox("Show Password");
 
 
    LoginFrame() {
        container.setBackground(Color.PINK);
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
 
    public void setLayoutManager() {
        container.setLayout(null);
    }
 
    public void setLocationAndSize() {
        emailLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        emailTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);
        backButton.setBounds(125,350,100,30);
 
 
    }
 
    public void addComponentsToContainer() {
        container.add(emailLabel);
        container.add(passwordLabel);
        container.add(emailTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(backButton);
    }
 
    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        backButton.addActionListener(this);
        backButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {

         //going back to register page
         if (e.getSource() == backButton)
        {  
                JOptionPane.showMessageDialog(this, "back");
                //back to register page
             this.setVisible(false);
               new Registration().setVisible(true);
                this.dispose();
        }

        // LOGIN button
        if (e.getSource() == loginButton) {
        	
        	
        	//s
        	loginButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				try {
    					 Class.forName("com.mysql.cj.jdbc.Driver");
    					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
    					// PreparedStatement pr=conn.prepareStatement("select *from user_register where U='"+emailTextField.getText()+"' and Password='"+passwordField.getText().toString()+"' ");				     
    					 Statement st=conn.createStatement();				     
    					 String r="select *from user_registration where UEmail='"+emailTextField.getText().toString()+"' and UPassword='"+passwordField.getText().toString()+"'";
    				     ResultSet rs=st.executeQuery(r);
    					 if(rs.next()) {
    						 HomePageGUI home=new HomePageGUI();
    						 home.setVisible(true);
    			                //this.dispose();
    						 JOptionPane.showMessageDialog(null, "login Sucessfully!");}
    					 else {
    						 JOptionPane.showMessageDialog(null, "login Unsucessfully!");
    					 }
    						}catch(Exception e1) {
    					System.out.println(e1);
    				}
    				
    			}
    		});		
//e
        	
 /*   String emailText;
            String pwdText;
            emailText = emailTextField.getText();
            pwdText = passwordField.getText();
            if (emailText.equalsIgnoreCase("123") && pwdText.equalsIgnoreCase("1234"))  //comapring data with regsitered user database
             {
                JOptionPane.showMessageDialog(this, "Login Successful"); //and direct to home page
                 // this.setVisible(false);
                //HomePage homepage=new HomePgae();
               // new HomePage().setVisible(true);
                //this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }*/
 
        }
        // RESET button
        if (e.getSource() == resetButton) {
            emailTextField.setText("");
            passwordField.setText("");
        }
       // showPassword 
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

       
         
 
 
        }
    }
 
}
 
public class LoginPage {
    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Login Form");
        frame.setBackground(Color.RED);
        frame.setVisible(true);
        frame.setBounds(100, 100, 370, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
 
    }
 
}