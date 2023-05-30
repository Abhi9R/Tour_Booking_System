import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
	JButton back;
	String usr;
	
	ViewBookedHotel(String usrnm) {
		this.usr = usrnm;
		setBounds(250, 190, 900, 600);
		getContentPane().setBackground(new Color(237, 199, 183));
		setLayout(null);
		
		JLabel text = new JLabel("Booked Hotel Details", SwingConstants.CENTER);
		text.setOpaque(true);
		text.setBackground(new Color(18, 60, 105));
		text.setForeground(new Color(186, 178, 181));
		text.setFont(new Font("Tahoma", Font.BOLD, 30));
		text.setBounds(200, 0, 400, 50);
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblusername.setBounds(60, 70, 150, 25);
		add(lblusername);
		
		JLabel username = new JLabel();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(190, 70, 150, 25);
		add(username);
		
		JLabel lbhotel = new JLabel("Hotel");
		lbhotel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbhotel.setBounds(60, 130, 150, 25);
		add(lbhotel);
		
		JLabel hotel = new JLabel();
		hotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hotel.setBounds(190, 130, 200, 25);
		add(hotel);
		
		JLabel travellers = new JLabel("Travellers");
		travellers.setFont(new Font("Tahoma", Font.BOLD, 16));
		travellers.setBounds(60, 190, 150, 25);
		add(travellers);
		
		JLabel ttrav = new JLabel();
		ttrav.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ttrav.setBounds(190, 190, 150, 25);
		add(ttrav);
		
		JLabel lblac = new JLabel("Amenities");
		lblac.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblac.setBounds(60, 250, 150, 25);
		add(lblac);
		
		JLabel tac = new JLabel();
		tac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tac.setBounds(190, 250, 150, 25);
		add(tac);
		
		JLabel food = new JLabel("Food Included");
		food.setFont(new Font("Tahoma", Font.BOLD, 16));
		food.setBounds(60, 310, 150, 25);
		add(food);
		
		JLabel tfood = new JLabel();
		tfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfood.setBounds(190, 310, 150, 25);
		add(tfood);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblphone.setBounds(60, 370, 150, 25);
		add(lblphone); 
		
		JLabel phone = new JLabel();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setBounds(190, 370, 150, 25);
		add(phone);
		
		JLabel lblprice = new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblprice.setBounds(60, 430, 150, 25);
		add(lblprice);
		
		JLabel price = new JLabel();
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		price.setBounds(190, 430, 150, 25);
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
		back.setBounds(230, 470, 100, 25);
		back.addActionListener(this);
		add(back);
		
		
		
		try {
			Connect c = new Connect();
			String query = "select * from bookhotel where username = '"+usrnm+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				username.setText(rs.getString("username"));
				hotel.setText(rs.getString("hotelname"));
				ttrav.setText(rs.getString("travellers"));
				tac.setText(rs.getString("acroom"));
				tfood.setText(rs.getString("foodincluded"));
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
		new ViewBookedHotel("abhi@9r");
	}
}


