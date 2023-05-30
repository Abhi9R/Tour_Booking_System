import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
	String usr;
	JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackage, bookPackage, viewPackage;
	JButton deletePersonalDetails, viewHotels, bookHotels, viewbookedHotels, destinations, Payment, exit;
	JButton about;
	
	Dashboard(String username) {
		this.usr = username;
		setBounds(0, 0, 1600, 1000);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(72, 138, 153));
		p1.setBounds(0, 0, 1600, 65);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("dashboard-icon-23660.png"));
		Image i2 = i1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel icon = new JLabel(i3);
		icon.setBounds(5, 0, 70, 70);
		p1.add(icon);
		
		JLabel heading = new JLabel("Dashboard");
		heading.setBounds(80, 10, 300, 40);
		heading.setForeground(Color.WHITE);
		heading.setFont(new Font("Tahoma", Font.BOLD, 30));
		p1.add(heading);
		
		JLabel heading2 = new JLabel("Tour Booking System");
		heading2.setBounds(580, 10, 600, 50);
		heading2.setForeground(Color.WHITE);
		heading2.setFont(new Font("Tahoma", Font.BOLD, 40));
		p1.add(heading2);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(72, 138, 153));
		p2.setBounds(0, 65, 300, 900);
		add(p2);
		
		addPersonalDetails = new JButton("Add Personal Details");
		addPersonalDetails.setBorderPainted(false);
		addPersonalDetails.setOpaque(true);
		addPersonalDetails.setBounds(0, 0, 300, 50);
		addPersonalDetails.setBackground(new Color(72, 138, 153));
		addPersonalDetails.setForeground(Color.WHITE);
		addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addPersonalDetails.addActionListener(this);
		p2.add(addPersonalDetails);
		
		updatePersonalDetails = new JButton("Update Personal Details");
		updatePersonalDetails.setBorderPainted(false);
		updatePersonalDetails.setOpaque(true);
		updatePersonalDetails.setBounds(0, 50, 300, 50);
		updatePersonalDetails.setBackground(new Color(72, 138, 153));
		updatePersonalDetails.setForeground(Color.WHITE);
		updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updatePersonalDetails.addActionListener(this);
		p2.add(updatePersonalDetails);
		
		viewPersonalDetails = new JButton("View Details");
		viewPersonalDetails.setBorderPainted(false);
		viewPersonalDetails.setOpaque(true);
		viewPersonalDetails.setBounds(0, 100, 300, 50);
		viewPersonalDetails.setBackground(new Color(72, 138, 153));
		viewPersonalDetails.setForeground(Color.WHITE);
		viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewPersonalDetails.addActionListener(this);
		p2.add(viewPersonalDetails);
		
		deletePersonalDetails = new JButton("Delete Account");
		deletePersonalDetails.setBorderPainted(false);
		deletePersonalDetails.setOpaque(true);
		deletePersonalDetails.setBounds(0, 150, 300, 50);
		deletePersonalDetails.setBackground(new Color(72, 138, 153));
		deletePersonalDetails.setForeground(Color.WHITE);
		deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deletePersonalDetails.addActionListener(this);
		p2.add(deletePersonalDetails);
		
		checkPackage = new JButton("Explore Packages");
		checkPackage.setBorderPainted(false);
		checkPackage.setOpaque(true);
		checkPackage.setBounds(0, 200, 300, 50);
		checkPackage.setBackground(new Color(72, 138, 153));
		checkPackage.setForeground(Color.WHITE);
		checkPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkPackage.addActionListener(this);
		p2.add(checkPackage);
		
		bookPackage = new JButton("Book Package");
		bookPackage.setBorderPainted(false);
		bookPackage.setOpaque(true);
		bookPackage.setBounds(0, 250, 300, 50);
		bookPackage.setBackground(new Color(72, 138, 153));
		bookPackage.setForeground(Color.WHITE);
		bookPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookPackage.addActionListener(this);
		p2.add(bookPackage);
		
		viewPackage = new JButton("View Package");
		viewPackage.setBorderPainted(false);
		viewPackage.setOpaque(true);
		viewPackage.setBounds(0, 300, 300, 50);
		viewPackage.setBackground(new Color(72, 138, 153));
		viewPackage.setForeground(Color.WHITE);
		viewPackage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewPackage.addActionListener(this);
		p2.add(viewPackage);
		
		viewHotels = new JButton("View Hotels");
		viewHotels.setBorderPainted(false);
		viewHotels.setOpaque(true);
		viewHotels.setBounds(0, 350, 300, 50);
		viewHotels.setBackground(new Color(72, 138, 153));
		viewHotels.setForeground(Color.WHITE);
		viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewHotels.addActionListener(this);
		p2.add(viewHotels);
		
		bookHotels = new JButton("Book Hotel");
		bookHotels.setBorderPainted(false);
		bookHotels.setOpaque(true);
		bookHotels.setBounds(0, 400, 300, 50);
		bookHotels.setBackground(new Color(72, 138, 153));
		bookHotels.setForeground(Color.WHITE);
		bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookHotels.addActionListener(this);
		p2.add(bookHotels);
		
		viewbookedHotels = new JButton("View booked Hotel");
		viewbookedHotels.setBorderPainted(false);
		viewbookedHotels.setOpaque(true);
		viewbookedHotels.setBounds(0, 450, 300, 50);
		viewbookedHotels.setBackground(new Color(72, 138, 153));
		viewbookedHotels.setForeground(Color.WHITE);
		viewbookedHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
		viewbookedHotels.addActionListener(this);
		p2.add(viewbookedHotels);
		
		destinations = new JButton("Destinations");
		destinations.setBorderPainted(false);
		destinations.setOpaque(true);
		destinations.setBounds(0, 500, 300, 50);
		destinations.setBackground(new Color(72, 138, 153));
		destinations.setForeground(Color.WHITE);
		destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
		destinations.addActionListener(this);
		p2.add(destinations);
		
		Payment = new JButton("Payment");
		Payment.setBorderPainted(false);
		Payment.setOpaque(true);
		Payment.setBounds(0, 550, 300, 50);
		Payment.setBackground(new Color(72, 138, 153));
		Payment.setForeground(Color.WHITE);
		Payment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Payment.addActionListener(this);
		p2.add(Payment);
		
		exit = new JButton("Exit");
		exit.setBorderPainted(false);
		exit.setOpaque(true);
		exit.setBounds(0, 600, 300, 50);
		exit.setBackground(new Color(72, 138, 153));
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exit.addActionListener(this);
		p2.add(exit);
		
		about = new JButton("About");
		about.setBorderPainted(false);
		about.setOpaque(true);
		about.setBounds(0, 650, 300, 50);
		about.setBackground(new Color(72, 138, 153));
		about.setForeground(Color.WHITE);
		about.setFont(new Font("Tahoma", Font.PLAIN, 20));
		about.addActionListener(this);
		p2.add(about);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("home.jpg"));
		Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image = new JLabel(i6);
		image.setBounds(0, 0, 1650, 1000);
		add(image);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == addPersonalDetails) {
			new AddCustomer(usr);
			setVisible(false);
		} else if (ae.getSource() == updatePersonalDetails) {
			new UpdateDetails(usr);
			setVisible(false);
		} else if(ae.getSource() == viewPersonalDetails) {
			new ViewDetails(usr);
			setVisible(false);
		} else if(ae.getSource() == checkPackage) {
			new ExplorePackage(usr);
			setVisible(false);
			
		} else if(ae.getSource() == bookPackage) {
			new BookPackage(usr);
			setVisible(false);
		} else if(ae.getSource() == viewPackage) {
			new ViewBookedPackage(usr);
			setVisible(false);
		} else if(ae.getSource() == deletePersonalDetails) {
			
			Connect c = new Connect();
			try {
				c.s.executeUpdate("delete from account where username = '"+usr+"'");
				c.s.executeUpdate("delete from bookhotel where username = '"+usr+"'");
				c.s.executeUpdate("delete from bookpackage where username = '"+usr+"'");
				c.s.executeUpdate("delete from customer where username = '"+usr+"'");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Login();
			setVisible(false);
		} else if(ae.getSource() == viewHotels) {
			new ViewHotels();
			setVisible(false);
		} else if(ae.getSource() == bookHotels) {
			new BookHotel(usr);
			setVisible(false);
		} else if(ae.getSource() == viewbookedHotels) {
			new ViewBookedHotel(usr);
			setVisible(false);
		} else if(ae.getSource() == destinations) {
			setVisible(false);
		} else if(ae.getSource() == Payment) {
			new Payment(usr);
			setVisible(false);
		} else if(ae.getSource() == exit) {
			setVisible(false);
		} else if(ae.getSource() == about) {
			new About(usr);
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		new Dashboard("");
	}
}
