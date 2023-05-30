import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener{
	Choice cpack;
	JTextField total;
	String user;
	JLabel labelusername, lblphone, price;
	JButton checkPrice, book, back;
	
	BookPackage(String usr) {
		this.user = usr; 
		setBounds(180, 200, 1100, 500);
		setLayout(null);
		getContentPane().setBackground(new Color(31, 40, 51));
		
		JLabel text = new JLabel("Book Package");
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
		
		JLabel select = new JLabel("Select Package");
		select.setBounds(40, 130, 120, 20);
		select.setFont(new Font("Tahoma", Font.PLAIN, 16));
		select.setForeground(new Color(69, 162, 158));
		add(select);
		
		cpack = new Choice();
		cpack.add("France Tour Package");
		cpack.add("Germany Tour Package");
		cpack.add("Italy Tour Package");
		cpack.setForeground(new Color(69, 162, 158));
		cpack.setBounds(240, 130, 180, 25);
		add(cpack);
		
		JLabel travellers = new JLabel("Travellers");
		travellers.setBounds(40, 180, 120, 20);
		travellers.setFont(new Font("Tahoma", Font.PLAIN, 16));
		travellers.setForeground(new Color(69, 162, 158));
		add(travellers);
		
		total = new JTextField("1");
		total.setBounds(242, 180, 180, 25);
		add(total);
		
		JLabel phone = new JLabel("Phone");
		phone.setBounds(40, 230, 120, 20);
		phone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phone.setForeground(new Color(69, 162, 158));
		add(phone);
		
		lblphone = new JLabel();
		lblphone.setBounds(250, 230, 120, 20);
		lblphone.setForeground(new Color(197, 198, 199));
		add(lblphone);
		
		JLabel totalprice = new JLabel("Total Price");
		totalprice.setBounds(40, 280, 120, 20);
		totalprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalprice.setForeground(new Color(69, 162, 158));
		add(totalprice);
		
		price = new JLabel();
		price.setBounds(250, 280, 120, 20);
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
		checkPrice.setBounds(40, 410, 200, 30);
		checkPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		checkPrice.setForeground(Color.black);
		checkPrice.addActionListener(this);
		add(checkPrice);
		
		book = new JButton("BOOK");
		book.setBorderPainted(false);
		book.setOpaque(true);
		book.setBackground(new Color(197, 198, 199));
		book.setBounds(350, 410, 120, 30);
		book.setFont(new Font("Tahoma", Font.BOLD, 20));
		book.setForeground(Color.black);
		book.addActionListener(this);
		add(book);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(197, 198, 199));
		back.setBounds(590, 410, 120, 30);
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
			String packageprice = cpack.getSelectedItem();
			long cost = 0;
			int number = Integer.parseInt(total.getText());
			
			if(packageprice.equals("France Tour Package")) {
				cost += 177890;
			} else if(packageprice.equals("Germany Tour Package")) {
				cost += 149399;
			} else {
				cost += 128250;
			}
			
			cost = cost*number;
			price.setText("Rs " + cost);
		} else if(ae.getSource() == book) {
			try {
				Connect c = new Connect();
				c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"', '"+cpack.getSelectedItem()+"', '"+total.getText()+"', '"+lblphone.getText()+"', '"+price.getText()+"')");
				
				JOptionPane.showMessageDialog(null, "Package booked Successfully");
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
		new BookPackage("abhi@9r");
	}

}
