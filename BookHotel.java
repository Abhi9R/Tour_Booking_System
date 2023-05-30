import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
	Choice chotel, cac, cfood;
	JTextField total, tdays;
	String user;
	JLabel labelusername, lblphone, price;
	JButton checkPrice, book, back;
	
	BookHotel(String usr) {
		this.user = usr; 
		setBounds(350, 200, 1100, 600);
		setLayout(null);
		getContentPane().setBackground(new Color(31, 40, 51));
		
		JLabel text = new JLabel("Book Hotel");
		text.setBounds(100, 10, 300, 50);
		text.setFont(new Font("Tahoma", Font.BOLD, 40));
		text.setForeground(new Color(102, 252, 241));
		add(text);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(40, 80, 100, 20);
		lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusername.setForeground(new Color(69, 162, 158));
		add(lblusername);
		
		labelusername = new JLabel();
		labelusername.setBounds(250, 80, 100, 20);
		labelusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelusername.setForeground(new Color(197, 198, 199));
		add(labelusername);
		
		JLabel select = new JLabel("Select Hotel");
		select.setBounds(40, 130, 120, 20);
		select.setFont(new Font("Tahoma", Font.PLAIN, 16));
		select.setForeground(new Color(69, 162, 158));
		add(select);
		
		chotel = new Choice();
		chotel.setBounds(240, 130, 180, 25);
		chotel.setForeground(new Color(69, 162, 158));
		add(chotel);
		
		try {
			Connect c = new Connect();
			ResultSet rs = c.s.executeQuery("select * from hotels");
			while(rs.next()) {
				chotel.add(rs.getString("name"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		JLabel travellers = new JLabel("Travellers");
		travellers.setBounds(40, 180, 120, 20);
		travellers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		travellers.setForeground(new Color(69, 162, 158));
		add(travellers);
		
		total = new JTextField("1");
		total.setBounds(242, 180, 180, 25);
		add(total);
		
		JLabel days = new JLabel("No. of Days");
		days.setBounds(40, 220, 120, 20);
		days.setFont(new Font("Tahoma", Font.PLAIN, 16));
		days.setForeground(new Color(69, 162, 158));
		add(days);
		
		tdays = new JTextField("1");
		tdays.setBounds(242, 220, 180, 25);
		add(tdays);
		
		JLabel lblac = new JLabel("Amenities");
		lblac.setBounds(40, 260, 120, 20);
		lblac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblac.setForeground(new Color(69, 162, 158));
		add(lblac);
		
		cac = new Choice();
		cac.add("AC");
		cac.add("Non-AC");
		cac.setBounds(240, 260, 180, 25);
		add(cac);
		
		JLabel lblfood = new JLabel("Food Included");
		lblfood.setBounds(40, 300, 120, 20);
		lblfood.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblfood.setForeground(new Color(69, 162, 158));
		add(lblfood);
		
		cfood = new Choice();
		cfood.add("YES");
		cfood.add("NO");
		cfood.setBounds(240, 300, 180, 25);
		add(cfood);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(40, 340, 120, 20);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setForeground(new Color(69, 162, 158));
		add(phone);
		
		lblphone = new JLabel();
		lblphone.setBounds(250, 340, 120, 20);
		lblphone.setForeground(new Color(197, 198, 199));
		add(lblphone);
		
		JLabel totalprice = new JLabel("Total Price");
		totalprice.setBounds(40, 380, 120, 20);
		totalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalprice.setForeground(new Color(69, 162, 158));
		add(totalprice);
		
		price = new JLabel();
		price.setBounds(250, 380, 120, 20);
		price.setForeground(new Color(197, 198, 199));
		add(price);
		
		try {
			Connect c = new Connect();
			String query = "select * from customer where username = '"+user+"'";
			ResultSet rs = c.s.executeQuery(query);
			
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				lblphone.setText(rs.getString("phone"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		checkPrice = new JButton("Check Price");
		checkPrice.setBorderPainted(false);
		checkPrice.setOpaque(true);
		checkPrice.setBackground(new Color(197, 198, 199));
		checkPrice.setBounds(40, 450, 200, 30);
		checkPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		checkPrice.setForeground(Color.black);
		checkPrice.addActionListener(this);
		add(checkPrice);
		
		book = new JButton("BOOK");
		book.setBorderPainted(false);
		book.setOpaque(true);
		book.setBackground(new Color(197, 198, 199));
		book.setBounds(350, 450, 120, 30);
		book.setFont(new Font("Tahoma", Font.BOLD, 20));
		book.setForeground(Color.black);
		book.addActionListener(this);
		add(book);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(197, 198, 199));
		back.setBounds(590, 450, 120, 30);
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("book1.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(550, 80, 500, 300);
		add(image);
		
		
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == checkPrice) {
			Connect c = new Connect();
			try {
				ResultSet rs = c.s.executeQuery("select * from hotels where name = '"+chotel.getSelectedItem()+"'");
				long persons = Integer.parseInt(total.getText());
				int days = Integer.parseInt(tdays.getText());
				
				String acselected = cac.getSelectedItem();
				String foodselected = cfood.getSelectedItem();
				while(rs.next()) {
					long cost = Integer.parseInt(rs.getString("priceperperson"));
					long costac = Integer.parseInt(rs.getString("acroom"));
					long costfood = Integer.parseInt(rs.getString("foodincluded"));
					
					if(persons*days > 0) {
						long ttotal = 0;
						ttotal += acselected.equals("AC") ? costac : 0;
						ttotal += foodselected.equals("YES") ? costfood  : 0;
						ttotal += cost;
						ttotal = ttotal * persons * days;
						price.setText("Rs. "+ttotal);
					} else {
						JOptionPane.showMessageDialog(null, "Please enter values greater than 0");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			
			
		} else if(ae.getSource() == book) {
			try {
				Connect c = new Connect();
				c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"', '"+chotel.getSelectedItem()+"', '"+total.getText()+"', '"+tdays.getText()+"' , '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+lblphone.getText()+"', '"+price.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Hotel booked Successfully");
				new Dashboard(labelusername.getText());
				setVisible(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			new Dashboard(labelusername.getText());
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		new BookHotel("abhi@9r");
	}

}
