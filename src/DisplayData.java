import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private HomePageGUI homePage;
    private DisplayData displayData;


    public DisplayData(HomePageGUI homePage) {
        this.homePage = homePage;
        initialize();
    }

//    public DisplayData(DisplayData displayData) {
//        initialize();
//    }
    public DisplayData() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JButton showDataButton = new JButton("Show Table Data");
        showDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showTableData();
                showDataButton.setEnabled(false);
            }
        });
        contentPane.add(showDataButton, BorderLayout.NORTH);

        table = new JTable();
        table.setBackground(Color.WHITE);

        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Email", "Phone_No", "Age", "Gender", "Bloodgrp", "Address"}
        ) {
            Class[] columnTypes = new Class[]{
                    String.class, String.class, String.class, Integer.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackToHomePage();
            }
        });
        contentPane.add(backButton, BorderLayout.SOUTH);
    }

    public void showTableData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor", "root", "12345");

            Statement st = con.createStatement();
            String query = "SELECT * FROM register_donor_info";
            ResultSet rs = st.executeQuery(query);

            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            while (rs.next()) {
                String RdName = rs.getString("RdName");
                String REmail = rs.getString("REmail");
                String RPhone_No = String.valueOf(rs.getInt("RPhone_No"));
                int RAge = rs.getInt("RAge");
                String RGender = rs.getString("RGender");
                String RBloodgrp = rs.getString("RBloodgrp");
                String RAddress = rs.getString("RAddress");

                Object[] row = {RdName, REmail, RPhone_No, RAge, RGender, RBloodgrp, RAddress};
                dtm.addRow(row);
            }

            con.close();

        } catch (Exception e1) {
            System.out.println(e1);
        }
    }

    public JPanel getDisplayPanel() {
        return contentPane;
    }
    
    private void goBackToHomePage() {
    	   if (homePage != null) {
               homePage.setVisible(true);  // Show the original HomePageGUI frame
               dispose();  // Close the current DisplayData frame
           } else {
               // Handle the case where homePage is null (optional)
               System.out.println("Error: homePage is null");
           }
       }
    

    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePageGUI homePage = new HomePageGUI();  // Create an instance of HomePageGUI
                    DisplayData frame = new DisplayData(homePage);  // Pass the reference to HomePageGUI
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
