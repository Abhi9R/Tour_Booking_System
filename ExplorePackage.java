import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ExplorePackage extends JFrame implements ActionListener{
	JButton back;
	String user;
	
	ExplorePackage(String usr) {
		this.user = usr;
		setBounds(450, 200, 900, 600);
		
		String[] package1 = {"France Tour Package", "15D/16N", "flexible", "4 flights", "7 hotels", "6 activities", "Daily Buffet", "Rs.1,77,890/-", "per person", "france.jpeg"};
		String[] package2 = {"Germany Tour Package", "13D/14N", "flexible", "4 flights", "6 hotels", "5 activities", "Daily Buffet", "Rs.1,49,399/-", "per person", "pack2.jpeg"};
		String[] package3 = {"Italy Tour Package", "10D/11N", "flexible", "3 flights", "5 hotels", "4 activities", "Daily Buffet", "Rs.1,28,250/-", "per person", "amalfi.jpeg"};
		
		JTabbedPane tab = new JTabbedPane();
		
		JPanel p1 = createPackage(package1);
		tab.addTab("Package 1", null, p1);
		
		JPanel p2 = createPackage(package2);
		tab.addTab("Package 2", null, p2);
		
		JPanel p3 = createPackage(package3);
		tab.addTab("Package 3", null, p3);
		
		add(tab);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(38, 69, 4));
		back.setForeground(Color.white);
		back.setBounds(350, 400, 100, 25);
		back.addActionListener(this);
		p1.add(back);
		
		setResizable(false);
		setVisible(true);
	}
	
	public JPanel createPackage(String[] pack) {
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(227, 222, 222));
		
		JLabel l1 = new JLabel(pack[0]);
		l1.setBounds(50, 5, 350, 40);
		l1.setForeground(new Color(141, 135, 65));
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		p1.add(l1);
		
		JLabel l2 = new JLabel(pack[1], SwingConstants.CENTER);
		l2.setOpaque(true);
		l2.setBounds(30, 65, 60, 25);
		l2.setForeground(Color.white);
		l2.setBackground(new Color(101, 157, 189));
		l2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p1.add(l2);
		
		JLabel l3 = new JLabel(pack[2], SwingConstants.CENTER);
		l3.setOpaque(true);
		l3.setBounds(86, 65, 50, 25);
		l3.setForeground(Color.white);
		l3.setBackground(Color.black);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		p1.add(l3);
		
		JLabel flight = new JLabel(pack[3]);
		flight.setOpaque(true);
		flight.setBounds(40, 150, 70, 25);
		flight.setForeground(Color.black);
		flight.setFont(new Font("Tahoma", Font.PLAIN, 14));
		flight.setBackground(new Color(187, 222, 242));
		add(flight);
		
		JLabel hotel = new JLabel(pack[4]);
		hotel.setOpaque(true);
		hotel.setBounds(40, 175, 70, 25);
		hotel.setForeground(Color.black);
		hotel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		hotel.setBackground(new Color(105, 170, 209));
		add(hotel);
		
		JLabel activities = new JLabel(pack[5]);
		activities.setOpaque(true);
		activities.setBounds(40, 200, 70, 25);
		activities.setForeground(Color.black);
		activities.setFont(new Font("Tahoma", Font.PLAIN, 14));
		activities.setBackground(new Color(73, 137, 173));
		add(activities);
		
		JLabel l4 = new JLabel(pack[6]);
		l4.setOpaque(true);
		l4.setBounds(40, 225, 70, 25);
		l4.setForeground(Color.black);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		l4.setBackground(new Color(52, 116, 153));
		add(l4);
		
		JLabel price = new JLabel(pack[7], SwingConstants.CENTER);
		price.setOpaque(true);
		price.setBounds(30, 250, 180, 60);
		price.setForeground(Color.white);
		price.setBackground(new Color(218, 173, 134));
		price.setFont(new Font("Tahoma", Font.PLAIN, 30));
		p1.add(price);
		
		JLabel l5 = new JLabel(pack[8], SwingConstants.CENTER);
		l5.setOpaque(true);
		l5.setBounds(210, 290, 70, 20);
		l5.setForeground(Color.white);
		l5.setBackground(Color.black);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		p1.add(l5);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[9]));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(300, 50, 500, 300);
		p1.add(image);
		
		return p1;
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Dashboard(user);
		}
	}
	
	public static void main(String[] args) {
		new ExplorePackage("");

	}

}
