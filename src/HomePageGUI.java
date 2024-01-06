//import java.awt.Color;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.*;
//import java.awt.font.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//public class HomePageGUI {
//	
//	public HomePageGUI() {
//		JFrame f1= new JFrame();
//		f1.setTitle("Home Page");
//        f1.setBounds(100,100,370,600);
//        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f1.setResizable(false);
//        f1.getContentPane().setBackground(Color.PINK);
//        f1.getContentPane().setLayout(null);
//        f1.setVisible(true);  
//        
//        JLabel Info=new JLabel("PLASMA DONATION");
//	    Info.setFont(new Font("Verdana",Font.PLAIN,20));
//	    Info.setSize(200,50);
//	    Info.setLocation(92,50);
//	    f1.getContentPane().add(Info);
//       
//		JButton b1= new JButton("Donate");
//		b1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DonorRegFrame donorpage=new DonorRegFrame();
//				 donorpage.setVisible(true);
//				 donorpage.setBounds(100, 100, 570, 800);
//			
//			
//			
//			}
//		});
//		b1.setBounds(50,200,130,60);
//		f1.getContentPane().add(b1);
//		
//		JButton b2= new JButton("Display");
//		b2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			
//				DisplayData display=new DisplayData();
//				 display.setVisible(true);
//			
//			
//			
//			
//			
//			}
//		});
//		b2.setBounds(200,200,140,60);
//		f1.getContentPane().add(b2);
//		
//		JButton b3= new JButton("Cancel");
//		b3.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				   f1.dispose(); 			
//			
//			}
//		});
//		b3.setBounds(125,270,150,60);
//		f1.getContentPane().add(b3);
//		
//	}
//	
//	public static void main(String [] args) {
//		new HomePageGUI();
//	}
//
//	public void setVisible(boolean b) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
//



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageGUI extends JFrame {

    private JPanel contentPane;
    private JButton donorButton;
    private JButton displayButton;

    private DonorRegFrame donorRegFrame;
    private DisplayData displayData;

    public HomePageGUI() {
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 223, 186)); // Light orange background
        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 1, 20, 20));

        JLabel titleLabel = new JLabel("PLASMA DONATION");
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleLabel);

        donorButton = new JButton("Donor Registration");
        donorButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        donorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDonorFrame();
            }
        });
        contentPane.add(donorButton);

        displayButton = new JButton("Display Data");
        displayButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDisplayFrame();
            }
        });
        contentPane.add(displayButton);
    }

    private void showDonorFrame() {
        if (donorRegFrame == null) {
            donorRegFrame = new DonorRegFrame();
        }
        setContentPane(donorRegFrame.getDonorPanel());
        validate();
        repaint();
    }

//    private void showDisplayFrame() {
//        if (displayData == null) {
//            displayData = new DisplayData();
//        }
//        setContentPane(displayData.getContentPane());  // Assuming you have a getContentPane() method
//        validate();
//        repaint();
//        displayData.showTableData(); // Refresh data when displaying
//    }
  private void showDisplayFrame() {
	 if (displayData == null) {
        displayData = new DisplayData(this);
    }
    displayData.setVisible(true);  // Show the DisplayData frame
    this.setVisible(false);  // Hide the current frame// Refresh data when displaying
}
    
    public JPanel getHomePanel() {
        return contentPane;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePageGUI frame = new HomePageGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}



































//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class HomePageGUI extends JFrame {
//
//    private JPanel contentPane;
//    private JButton donorButton;
//    private JButton displayButton;
//
//    private DonorRegFrame donorRegFrame;
//    private DisplayData displayData;
//
//    public HomePageGUI() {
//        initialize();
//    }
//
//    private void initialize() {
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setBounds(100, 100, 800, 800);
//
//        contentPane = new JPanel();
//        contentPane.setBackground(new Color(255, 223, 186)); // Light orange background
//        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
//        setContentPane(contentPane);
//        contentPane.setLayout(new GridLayout(3, 1, 20, 20));
//
//        JLabel titleLabel = new JLabel("PLASMA DONATION");
//        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 28));
//        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        contentPane.add(titleLabel);
//
//        donorButton = new JButton("Donor Registration");
//        donorButton.setFont(new Font("Verdana", Font.PLAIN, 18));
//        donorButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showDonorFrame();
//            }
//        });
//        contentPane.add(donorButton);
//
//        displayButton = new JButton("Display Data");
//        displayButton.setFont(new Font("Verdana", Font.PLAIN, 18));
//        displayButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                showDisplayFrame();
//            }
//        });
//        contentPane.add(displayButton);
//    }
//
//    private void showDonorFrame() {
//        System.out.println("showDonorFrame method called");
//
//    	if (donorRegFrame == null) {
//            donorRegFrame = new DonorRegFrame(this);
//        }
//        donorRegFrame.setVisible(true);  // Show the DonorRegFrame
////        this.setVisible(false);  // Hide the current frame
//    }
//
//    private void showDisplayFrame() {
//    	 if (displayData == null) {
//             displayData = new DisplayData(this);
//         }
//         displayData.setVisible(true);  // Show the DisplayData frame
//         this.setVisible(false);  // Hide the current frame// Refresh data when displaying
//    }
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    HomePageGUI frame = new HomePageGUI();
//                    frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}
//
//




