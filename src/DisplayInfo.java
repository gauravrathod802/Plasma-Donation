//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
//import java.util.Vector;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
//
//
//class DisplayInfo extends JFrame implements ActionListener
//{
//    
//    String bloodGrp[]={"O+","O-","A+","A-","B+","B-","AB+","AB-"};
//
//     JFrame frame1;
//    JLabel headingLabel, selectBldLabel, l2;
//    JComboBox selectbloodGrup;
//    JButton submitButton;
//
//     DisplayInfo()
//      {
//
//        JLabel headingLabel = new JLabel("Fatching Donor Information");
//
//        headingLabel.setForeground(Color.red);
//        headingLabel.setFont(new Font("Serif", Font.BOLD, 20));
//
//       JLabel selectBldLabel = new JLabel("Select Blood Group");
//       JComboBox selectbloodGrp=new JComboBox(bloodGrp);
//
//
//        JButton submitButton = new JButton("SUBMIT");
//
//
//        headingLabel.setBounds(100, 50, 350, 40);
//        selectBldLabel.setBounds(27, 110, 108, 20);
//        submitButton.setBounds(150, 150, 150, 20);
//        submitButton.addActionListener(this);
//
// 
//        setTitle("Fetching Donor Info");
//        getContentPane().setLayout(null);
//        setVisible(true);
//        setSize(577, 500);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        getContentPane().add(headingLabel);
//        getContentPane().add(selectBldLabel);;
//        getContentPane().add(submitButton);
//          try {
//
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//
//            //con = DriverManager.getConnection("jdbc:oracle:thin:@mcndesktop07:1521:xe", "sandeep", "welcome");
//			 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
//
//          Statement  st = conn.createStatement();
//
//            ResultSet rs = st.executeQuery("select RBloodgrp from register_donor_info");
//
//            Vector v = new Vector();
//
//            while (rs.next()) {
//
//              String  ids = rs.getString(1);
//
//                v.add(ids);
//
//            }
//
//            selectbloodGrp = new JComboBox(v);
//
//            selectbloodGrp.setBounds(150, 110, 100, 20);
//
// 
//
//            getContentPane().add(selectbloodGrp);
//
//            st.close();
//
//            rs.close();
//
//        } 
//        catch (Exception e) {
//
//        }
//
//    }
//
//
//
//     public void actionPerformed(ActionEvent e)
//      {
//
//        if (e.getSource() == submitButton) 
//        {
//            showTableData();
//        }
//      }
//
//
//
//      public void showTableData() 
//      {
//
//       JFrame frame1 = new JFrame("Database Search Result");
//
//        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame1.getContentPane().setLayout(new BorderLayout());
//
//        //  TableModel tm = new TableModel();
//
//        DefaultTableModel model = new DefaultTableModel();
//        model.setColumnIdentifiers(columnNames);
//
//       //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());
///*
//      table = new JTable(model);
//
//        table = new JTable();
//        table.setModel(model);
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//        table.setFillsViewportHeight(true);
//        JScrollPane scroll = new JScrollPane(table);
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//        scroll.setVerticalScrollBarPolicy(  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//*/
//        from = (String)selectbloodGrp.getSelectedItem();
//
////String textvalue = textbox.getText();
//
//        String name = "";
//        String email = "";
//        String phn = "";
//        String gender = "";
//        String address="";
//         try {
//
//           PreparedStatement pst = conn.prepareStatement("select * from register_donor_info where bloodgroup='" + from + "'");
//
//            ResultSet rs = pst.executeQuery();
//
//            int i = 0;
//
//            if (rs.next()) {
//
//                name = rs.getString("name");
//
//                email = rs.getString("umail");
//
//                phn = rs.getString("phn");
//
//                gender = rs.getString("gender");
//                address=rs.getString("address");
//
//                model.addRow(new Object[]{name, email, phn, gender,address});
//
//                i++;
//
//            }
//
//            if (i < 1) {
//
//                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
//
//            }
//
//            if (i == 1) {
//
//                System.out.println(i + " Record Found");
//
//            } else {
//
//                System.out.println(i + " Records Found");
//
//            }
//
//        } catch (Exception ex) {
//
//            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
//
//        frame1.getContentPane().add(scroll);
//
//        frame1.setVisible(true);
//
//        frame1.setSize(400, 300);
//
//    }
//
//
//
//
//
//  public static void main(String args[]) {
//
//        //new DisplayEmpData();
//new DisplayInfo();
//    }
//
//
//}