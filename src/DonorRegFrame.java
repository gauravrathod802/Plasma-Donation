//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//class DonorRegFrame extends  JFrame implements ActionListener
//{
//    /* String dates[]= { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",  "11", "12", "13", "14", "15",
//            "16", "17", "18", "19", "20",  "21", "22", "23", "24", "25",   "26", "27", "28", "29", "30", "31" };
//    String months[] = { "Jan", "feb", "Mar", "Apr",
//            "May", "Jun", "July", "Aug",
//            "Sup", "Oct", "Nov", "Dec" };
//     String years[] = { "1986","1987","1988","1989","1990","1991","1992","1993","1994","1995", "1996", "1997", "1998",
//            "1999", "2000", "2001", "2002", };
//    
//    String bloodGrp[]={"O+","O-","A+","A-","B+","B-","AB+","AB-"};
//    String gender[]={"MALE","FEMALE"};*/
//   
//
//    Container container = getContentPane();
//
//    JLabel header=new JLabel("REGISTER DONOR INFO");
//    
//
//    JLabel nameLabel = new JLabel("NAME");
//    JLabel emailLabel = new JLabel("EMAIL");
//    JLabel phnLabel=new JLabel("PHONE NO.");
//
//  //  JLabel dobLabel = new JLabel("DOB");
//    
//
//    JLabel genderLabel=new JLabel("GENDER");
//   // JComboBox gendercombobox=new JComboBox(gender);
//    
//
//  //  JComboBox dateCombobox = new JComboBox(dates);
//  //  JComboBox  monthCombobox = new JComboBox(months);
// //   JComboBox yearCombobox = new JComboBox(years);
//
//    JLabel ageLabel=new JLabel("AGE");
//
//    JLabel bldgrupLabel=new JLabel("BLOOD GROUP");
//   // JComboBox bloodGrpCombobox=new JComboBox(bloodGrp);
//
//    JLabel addressLabel=new JLabel("ADDRESS");
//    
//    JButton submitButton = new JButton("SUBMIT");
//    JButton resetButton = new JButton("RESET");
//    JButton backButton = new JButton("BACK");
//
//   JTextField nameField=new JTextField();
//   JTextField emailField=new JTextField();
//   JTextField phnField =new JTextField();
//   JTextField ageField=new JTextField();
//   JTextField gender=new JTextField();
//   JTextField bloodgrp=new JTextField();
//    JTextArea addressField=new JTextArea();
//
//
//    DonorRegFrame()
//    {
//        container.setBackground(Color.PINK);
//        //header.setSize(300,100);
//       // header.setPreferredSize(new Dimension(300, 150));
//        setLayoutManager();
//        setLocationAndSize();
//        addComponentsToContainer();
//        addActionEvent();
//    }
//
//     public void setLayoutManager() {
//        container.setLayout(null);
//    }
//
//      public void setLocationAndSize()
//       {
//                
//
//        header.setBounds(100,30,150,50);
//        nameLabel.setBounds(50, 100, 100, 30);
//        emailLabel.setBounds(50, 150, 100, 30);
//        phnLabel.setBounds(50,200,100,30);
//     //   dobLabel.setBounds(50,250,100,30);
//        ageLabel.setBounds(50,300,100,30);
//
//        genderLabel.setBounds(50,350,100,30);
//        bldgrupLabel.setBounds(50,400,100,30);
//        addressLabel.setBounds(50,450,100,30);
//
//        nameField.setBounds(150, 100, 150, 30);
//        emailField.setBounds(150, 150, 150, 30);
//        phnField.setBounds(150, 200, 150, 30);
//
//     //   dateCombobox.setBounds(150, 250, 100, 30);
//      //  monthCombobox.setBounds(260, 250, 100, 30);
//        //yearCombobox.setBounds(370, 250, 100, 30);
//        ageField.setBounds(150,300,100,30);
//
//    
//      gender.setBounds(150,350,150,30);
//
//      bloodgrp.setBounds(150, 400, 150, 30);
//        addressField.setBounds(150, 450, 200, 50);
//
//        submitButton.setBounds(50, 540, 150, 30);
//        resetButton.setBounds(200, 540, 150, 30);
//        backButton.setBounds(125, 590, 150, 30);
//
//    }
//
//      public void addComponentsToContainer() {
//          container.add(header);
//        container.add(nameLabel);
//        container.add(emailLabel);
//        container.add(phnLabel);
//        //container.add(dobLabel);
//        container.add(genderLabel);
//        
//        
//        container.add(bldgrupLabel);
//        container.add(addressLabel);
//
//        container.add(nameField);
//        container.add(emailField);
//        container.add(phnField);
//
//        //container.add(dateCombobox);
//       // container.add(monthCombobox);
//       // container.add(yearCombobox);
//
//        container.add(ageLabel);
//        container.add(ageField);
//
//        container.add(gender);
//    
//     container.add(bloodgrp);
//        container.add(addressField);
//
//        container.add(submitButton);
//        container.add(resetButton);
//        container.add(backButton);
//    }
//
//     public void addActionEvent() {
//       
//
//        submitButton.addActionListener(this);
//        resetButton.addActionListener(this);
//        backButton.addActionListener(this);
//    }
//
//    public void actionPerformed(ActionEvent e) {
//
//        if(e.getSource()==submitButton)
//        {
//            //insert data into data base
//    				try {
//    					 Class.forName("com.mysql.cj.jdbc.Driver");
//    					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
//    					// PreparedStatement pr=conn.prepareStatement("insert into register_donor_info(RdName, REmail, RPhone_No, RDOB, RAge, RGender, RBloodgrp, RAddress) values(?,?,?,?,?,?,?,?)");
//    					 PreparedStatement pr=conn.prepareStatement("insert into register_donor_info(RdName,REmail,RPhone_No,RAge,RGender,RBloodgrp,RAddress) values(?,?,?,?,?,?,?)");
//     				    
//    					 
//    					 pr.setString(1,nameField.getText());
//    				     pr.setString(2,emailField.getText());
//    				     pr.setString(3,phnField.getText());
//    				    // pr.setString(4,.getText());
//    				     pr.setString(4,ageField.getText());
//    				     pr.setString(5,gender.getText());
//    				     pr.setString(6,bloodgrp.getText());
//    				     pr.setString(7,addressField.getText());
//    				     int x=pr.executeUpdate();
//    				     if(x>0) {
//    				    	 System.out.print("Data inserted Sucessfully!");
//    				     }else {
//    				    	 System.out.print("Registration unsucessful");
//    					     	 
//    				     }
//    				}catch(Exception e1) {
//    					System.out.println(e1);
//    				}
//    				
//    			}
//    
//       
//        if(e.getSource()==resetButton)
//        {
//            nameField.setText("");
//            emailField.setText("");
//            phnField.setText("");
//            ageField.setText("");
//            addressField.setText("");
//       //     dateCombobox.setSelectedIndex(0);
//         //   monthCombobox.setSelectedIndex(0);
//           // yearCombobox.setSelectedIndex(0);
//            //gendercombobox.setSelectedIndex(0);
//            //bloodGrpCombobox.setSelectedIndex(0);
//
//        }
//
//        if(e.getSource()==backButton)
//        {
//            // this.setVisible(false);
//        	HomePageGUI homepage=new HomePageGUI();
//        	homepage.setVisible(true);
//            //this.dispose();
//
//        }
//
//    }
//
//
//
//
//    
//}
//public class DonarRegPage
//    {
//        public static void main(String args[])
//        {
//            DonorRegFrame frame=new DonorRegFrame();
//
//         frame.setTitle("Donar info");
//        frame.setVisible(true);
//        frame.setBounds(100, 100, 570, 800);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//
//
//            
//        }
//
//		public void setVisible(boolean b) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		
//    }





import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DonorRegFrame extends JPanel implements ActionListener {

    private JPanel donorPanel;

    private JLabel header = new JLabel("REGISTER DONOR INFO");

    private JLabel nameLabel = new JLabel("NAME");
    private JLabel emailLabel = new JLabel("EMAIL");
    private JLabel phnLabel = new JLabel("PHONE NO.");
    private JLabel genderLabel = new JLabel("GENDER");
    private JLabel ageLabel = new JLabel("AGE");
    private JLabel bldgrupLabel = new JLabel("BLOOD GROUP");
    private JLabel addressLabel = new JLabel("ADDRESS");

    private JButton submitButton = new JButton("SUBMIT");
    private JButton resetButton = new JButton("RESET");
    private JButton backButton = new JButton("BACK");

    private JTextField nameField = new JTextField();
    private JTextField emailField = new JTextField();
    private JTextField phnField = new JTextField();
    private JTextField ageField = new JTextField();
    private JTextField genderField = new JTextField();
    private JTextField bloodgrpField = new JTextField();
    private JTextArea addressField = new JTextArea();

    public DonorRegFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

        donorPanel = new JPanel();
        donorPanel.setLayout(null);
        donorPanel.add(header);
        donorPanel.add(nameLabel);
        donorPanel.add(emailLabel);
        donorPanel.add(phnLabel);
        donorPanel.add(genderLabel);
        donorPanel.add(bldgrupLabel);
        donorPanel.add(addressLabel);
        donorPanel.add(nameField);
        donorPanel.add(emailField);
        donorPanel.add(phnField);
        donorPanel.add(ageLabel);
        donorPanel.add(ageField);
        donorPanel.add(genderField);
        donorPanel.add(bloodgrpField);
        donorPanel.add(addressField);
        donorPanel.add(submitButton);
        donorPanel.add(resetButton);
        donorPanel.add(backButton);
        donorPanel.setPreferredSize(new Dimension(800, 600));
    }

    public JPanel getDonorPanel() {
        return donorPanel;
    }

    public void setLayoutManager() {
        setLayout(null);
    }

    public void setLocationAndSize() {
        header.setBounds(100, 30, 150, 50);
        nameLabel.setBounds(50, 100, 100, 30);
        emailLabel.setBounds(50, 150, 100, 30);
        phnLabel.setBounds(50, 200, 100, 30);
        ageLabel.setBounds(50, 300, 100, 30);
        genderLabel.setBounds(50, 350, 100, 30);
        bldgrupLabel.setBounds(50, 400, 100, 30);
        addressLabel.setBounds(50, 450, 100, 30);

        nameField.setBounds(150, 100, 150, 30);
        emailField.setBounds(150, 150, 150, 30);
        phnField.setBounds(150, 200, 150, 30);
        ageField.setBounds(150, 300, 100, 30);
        genderField.setBounds(150, 350, 150, 30);
        bloodgrpField.setBounds(150, 400, 150, 30);
        addressField.setBounds(150, 450, 200, 50);

        submitButton.setBounds(50, 540, 150, 30);
        resetButton.setBounds(200, 540, 150, 30);
        backButton.setBounds(125, 590, 150, 30);
    }

    public void addComponentsToContainer() {
        add(header);
        add(nameLabel);
        add(emailLabel);
        add(phnLabel);
        add(genderLabel);
        add(bldgrupLabel);
        add(addressLabel);
        add(nameField);
        add(emailField);
        add(phnField);
        add(ageLabel);
        add(ageField);
        add(genderField);
        add(bloodgrpField);
        add(addressField);
        add(submitButton);
        add(resetButton);
        add(backButton);
    }

    public void addActionEvent() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor", "root", "12345");
                PreparedStatement pr = conn.prepareStatement("insert into register_donor_info(RdName,REmail,RPhone_No,RAge,RGender,RBloodgrp,RAddress) values(?,?,?,?,?,?,?)");

                pr.setString(1, nameField.getText());
                pr.setString(2, emailField.getText());
                pr.setString(3, phnField.getText());
                pr.setString(4, ageField.getText());
                pr.setString(5, genderField.getText());
                pr.setString(6, bloodgrpField.getText());
                pr.setString(7, addressField.getText());
                int x = pr.executeUpdate();
                if (x > 0) {
                    System.out.print("Data inserted Successfully!");
                } else {
                    System.out.print("Registration unsuccessful");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }

        if (e.getSource() == resetButton) {
            clearFields();
        }

//        if (e.getSource() == backButton) {
//        	  JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(donorPanel);
//        	    if (parentFrame != null) {
//        	        HomePageGUI homePage = new HomePageGUI();
//        	        parentFrame.setContentPane(homePage.getContentPane());
//        	        parentFrame.validate();
//        	        parentFrame.repaint();
//        	    }
//        }
        
        if (e.getSource() == backButton) {
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(donorPanel);
            if (parentFrame != null && parentFrame instanceof HomePageGUI) {
                HomePageGUI homePage = (HomePageGUI) parentFrame;
                parentFrame.setContentPane(homePage.getHomePanel());
                parentFrame.validate();
                parentFrame.repaint();
            }
        }

        
    }
    
    

    public void clearFields() {
        nameField.setText("");
        emailField.setText("");
        phnField.setText("");
        ageField.setText("");
        genderField.setText("");
        bloodgrpField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Donor Registration");
        frame.setBounds(100, 100, 570, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        DonorRegFrame donorRegFrame = new DonorRegFrame();
        frame.getContentPane().add(donorRegFrame.getDonorPanel());

        frame.setVisible(true);
    }
}

