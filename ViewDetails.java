import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewDetails extends JFrame implements ActionListener{
	JButton back;
	String usr;
	
	ViewDetails(String usrnm) {
		this.usr = usrnm;
		setBounds(480, 180, 870, 625);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(110, 50, 150, 25);
		add(lblusername);
		
		JLabel username = new JLabel();
		username.setBounds(220, 50, 150, 25);
		add(username);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(110, 110, 150, 25);
		add(lblid);
		
		JLabel id = new JLabel();
		id.setBounds(220, 110, 150, 25);
		add(id);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(110, 170, 150, 25);
		add(lblnumber);
		
		JLabel number = new JLabel();
		number.setBounds(220, 170, 150, 25);
		add(number);
		
		JLabel lblname = new JLabel("Name");
		lblname.setBounds(110, 230, 150, 25);
		add(lblname);
		
		JLabel name = new JLabel();
		name.setBounds(220, 230, 150, 25);
		add(name);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(110, 290, 150, 25);
		add(lblgender);
		
		JLabel gender = new JLabel();
		gender.setBounds(220, 290, 150, 25);
		add(gender);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(500, 50, 150, 25);
		add(lblcountry); 
		
		JLabel country = new JLabel();
		country.setBounds(590, 50, 150, 25);
		add(country);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(500, 110, 150, 25);
		add(lbladdress); 
		
		JLabel address = new JLabel();
		address.setBounds(590, 110, 150, 25);
		add(address);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(500, 170, 150, 25);
		add(lblemail); 
		
		JLabel email = new JLabel();
		email.setBounds(590, 170, 250, 25);
		add(email);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setBounds(500, 230, 150, 25);
		add(lblphone); 
		
		JLabel phone = new JLabel();
		phone.setBounds(590, 230, 150, 25);
		add(phone);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(38, 69, 4));
		back.setForeground(Color.white);
		back.setBounds(350, 350, 100, 25);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(20, 400, 600, 200);
		add(image);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
		ImageIcon i6 = new ImageIcon(i5);
		JLabel image1 = new JLabel(i6);
		image1.setBounds(600, 400, 600, 200);
		add(image1);
		
		try {
			Connect c = new Connect();
			String query = "select * from customer where username = '"+usrnm+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				username.setText(rs.getString("username"));
				id.setText(rs.getString("id"));
				number.setText(rs.getString("number"));
				name.setText(rs.getString("name"));
				gender.setText(rs.getString("gender"));
				country.setText(rs.getString("country"));
				address.setText(rs.getString("address"));
				email.setText(rs.getString("email"));
				phone.setText(rs.getString("phone"));
				
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
		new ViewDetails("");
	}
}


