import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.font.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class HomePageGUI {
	
	public HomePageGUI() {
		JFrame f1= new JFrame();
		f1.setTitle("Home Page");
        f1.setBounds(100,100,370,600);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setResizable(false);
        f1.getContentPane().setBackground(Color.PINK);
        f1.getContentPane().setLayout(null);
        f1.setVisible(true);  
        
        JLabel Info=new JLabel("PLASMA DONATION");
	    Info.setFont(new Font("Verdana",Font.PLAIN,20));
	    Info.setSize(200,50);
	    Info.setLocation(92,50);
	    f1.getContentPane().add(Info);
       
		JButton b1= new JButton("Donate");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DonorRegFrame donorpage=new DonorRegFrame();
				 donorpage.setVisible(true);
			
			
			
			}
		});
		b1.setBounds(50,200,130,60);
		f1.getContentPane().add(b1);
		
		JButton b2= new JButton("Display");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DisplayData display=new DisplayData();
				 display.setVisible(true);
			
			
			
			
			
			}
		});
		b2.setBounds(200,200,140,60);
		f1.getContentPane().add(b2);
		
		JButton b3= new JButton("Cancel");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   f1.dispose(); 
			
			
			}
		});
		b3.setBounds(125,270,150,60);
		f1.getContentPane().add(b3);
		
	}
	
	public static void main(String [] args) {
		new HomePageGUI();
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
