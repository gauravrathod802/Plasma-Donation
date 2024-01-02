//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JButton;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.ListSelectionModel;
//import java.awt.event.ActionListener;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.awt.event.ActionEvent;
//import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.Color;
//
//public class DisplayData extends JFrame {
//
//	private JPanel contentPane;
//	private JTable table;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DisplayData frame = new DisplayData();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public DisplayData() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 726, 394);
//		contentPane = new JPanel();
//		contentPane.setBackground(Color.PINK);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JButton btnNewButton = new JButton("show table data");
//		btnNewButton.addActionListener(new ActionListener() {
//			
//			public void actionPerformed(ActionEvent e) {
//			
//				   try {
//
//						 Class.forName("com.mysql.cj.jdbc.Driver");
//
//						 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
//
//			        Statement st = con.createStatement();
//			            String s3="select *from register_donor_info";
//			            ResultSet rs = st.executeQuery(s3);
//			            while(rs.next()) {
//			            	String  RdName = rs.getString("RdName");
//
//			            	String REmail = rs.getString("REmail");
//
//			            	String	 RPhone_No=String.valueOf(rs.getInt("RPhone_No"));
//			            	String RAge = String.valueOf(rs.getInt("RAge"));
//			            	String RGender = rs.getString("RGender");
//			                String	RBloodgrp=rs.getString("RBloodgrp");
//			                String	RAddress=rs.getString("RAddress");
//			            	
//			                String tb[]= {RdName,REmail,RPhone_No,RAge,RGender,RBloodgrp,RAddress};
//			                DefaultTableModel dtm=(DefaultTableModel)table.getModel();
//			            
//			                dtm.addRow(tb);
//			                JButton source = (JButton) e.getSource();
//		                    source.setEnabled(false);
//			            }
//			           
//			            con.close(); 
//			    		
//				   } catch (Exception e1) {
//					   System.out.println(e1);
//			        }
//			
//			
//			
//			
//			
//	
//			
//			}
//		});
//		btnNewButton.setBounds(12, 163, 140, 40);
//		contentPane.add(btnNewButton);
//		
//		table = new JTable();
//		table.setBackground(Color.WHITE);
//
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"RdName", "REmail", "RPhone_No", " RAge", "RGender", " RBloodgrp", "RAddress"
//			}
//		) {
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, Integer.class, Integer.class, String.class, String.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(0).setPreferredWidth(96);
//		table.getColumnModel().getColumn(1).setPreferredWidth(182);
//		table.getColumnModel().getColumn(2).setPreferredWidth(133);
//		table.getColumnModel().getColumn(3).setPreferredWidth(63);
//		table.getColumnModel().getColumn(4).setPreferredWidth(85);
//		table.getColumnModel().getColumn(5).setPreferredWidth(95);
//		table.getColumnModel().getColumn(6).setPreferredWidth(137);
//		table.setBounds(183, 67, 513, 242);
//		contentPane.add(table);
//		
//		JLabel lblNewLabel = new JLabel("Name");
//		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblNewLabel.setBounds(183, 49, 53, 16);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblNewLabel_1 = new JLabel("Email");
//		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
//		lblNewLabel_1.setBounds(262, 49, 56, 16);
//		contentPane.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_2 = new JLabel("Phone no");
//		lblNewLabel_2.setBounds(360, 49, 56, 16);
//		contentPane.add(lblNewLabel_2);
//		
//		JLabel lblNewLabel_3 = new JLabel("Age");
//		lblNewLabel_3.setBounds(446, 49, 30, 16);
//		contentPane.add(lblNewLabel_3);
//		
//		JLabel lblNewLabel_4 = new JLabel("Address");
//		lblNewLabel_4.setBounds(614, 49, 56, 16);
//		contentPane.add(lblNewLabel_4);
//		
//		JLabel lblNewLabel_5 = new JLabel("BloodGrp");
//		lblNewLabel_5.setBounds(546, 49, 56, 16);
//		contentPane.add(lblNewLabel_5);
//		
//		JLabel lblNewLabel_6 = new JLabel("Gender");
//		lblNewLabel_6.setBounds(488, 49, 56, 16);
//		contentPane.add(lblNewLabel_6);
//	}
//}











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
                new String[]{"RdName", "REmail", "RPhone_No", "RAge", "RGender", "RBloodgrp", "RAddress"}
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

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DisplayData frame = new DisplayData();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
