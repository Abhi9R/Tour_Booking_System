import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewBookedPackage extends JFrame implements ActionListener{
	JButton back;
	String usr;
	
	ViewBookedPackage(String usrnm) {
		this.usr = usrnm;
		setBounds(250, 190, 900, 450);
		getContentPane().setBackground(new Color(237, 199, 183));
		setLayout(null);
		
		JLabel text = new JLabel("Booked Package Details", SwingConstants.CENTER);
		text.setOpaque(true);
		text.setBackground(new Color(18, 60, 105));
		text.setForeground(new Color(186, 178, 181));
		text.setFont(new Font("Tahoma", Font.BOLD, 30));
		text.setBounds(200, 0, 400, 50);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblusername.setBounds(110, 70, 150, 25);
		add(lblusername);
		
		JLabel username = new JLabel();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(250, 70, 150, 25);
		add(username);
		
		JLabel lbpackage = new JLabel("Package");
		lbpackage.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbpackage.setBounds(110, 130, 150, 25);
		add(lbpackage);
		
		JLabel pack = new JLabel();
		pack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pack.setBounds(250, 130, 150, 25);
		add(pack);
		
		JLabel travellers = new JLabel("Travellers");
		travellers.setFont(new Font("Tahoma", Font.BOLD, 16));
		travellers.setBounds(110, 190, 150, 25);
		add(travellers);
		
		JLabel ttrav = new JLabel();
		ttrav.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ttrav.setBounds(250, 190, 150, 25);
		add(ttrav);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblphone.setBounds(110, 250, 150, 25);
		add(lblphone); 
		
		JLabel phone = new JLabel();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setBounds(250, 250, 150, 25);
		add(phone);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblprice.setBounds(110, 310, 150, 25);
		add(lblprice);
		
		JLabel price = new JLabel();
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setBounds(250, 310, 150, 25);
		add(price);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("viewpack.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(300, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(500, 60, 300, 500);
		add(image);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(172, 59, 97));
		back.setForeground(Color.white);
		back.setBounds(350, 350, 100, 25);
		back.addActionListener(this);
		add(back);
		
		
		
		try {
			Connect c = new Connect();
			String query = "select * from bookpackage where username = '"+usrnm+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				username.setText(rs.getString("username"));
				pack.setText(rs.getString("package"));
				ttrav.setText(rs.getString("travellers"));
				phone.setText(rs.getString("phone"));
				price.setText(rs.getString("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			setVisible(false);
			new Dashboard(usr);
		}
	}
	
	public static void main(String[] args) {
		new ViewBookedPackage("abhi@9r");
	}
}


