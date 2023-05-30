
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
	JLabel labelusername, lblname;
	JComboBox comboId;
	JTextField txtnumber, txtcountry, txtaddress, txtemail, txtphone;
	JRadioButton rmale, rfemale;
	JButton badd, bback;
	String usrnm;
	AddCustomer(String usr) {
		this.usrnm = usr;
		setBounds(450, 200, 850, 550);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setBounds(30, 50, 150, 25);
		add(lblusername);
		
		labelusername = new JLabel(usrnm);
		labelusername.setBounds(220, 50, 150, 25);
		add(labelusername);
		
		JLabel lblid = new JLabel("Id");
		lblid.setBounds(30, 90, 150, 25);
		add(lblid);
		
		comboId = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", });
		comboId.setBounds(220, 90, 150, 25);
		comboId.setBackground(new Color(252, 249, 220));
		add(comboId);
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(30, 130, 150, 25);
		add(lblnumber);
		
		txtnumber = new JTextField();
		txtnumber.setBounds(220, 130, 150, 25);
		add(txtnumber);
		
		JLabel labelname = new JLabel("Name");
		labelname.setBounds(30, 170, 150, 25);
		add(labelname);
		
		lblname = new JLabel();
		lblname.setBounds(220, 170, 150, 25);
		add(lblname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setBounds(30, 210, 150, 25);
		add(lblgender);
		
		rmale = new JRadioButton("Male");
		rmale.setBounds(220, 210, 70, 25);
		add(rmale);
		
		rfemale = new JRadioButton("Female");
		rfemale.setBounds(310, 210, 85, 25);
		add(rfemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rfemale);
		bg.add(rmale);
		
		JLabel lblcountry = new JLabel("Country");
		lblcountry.setBounds(30, 250, 150, 25);
		add(lblcountry);
		
		txtcountry = new JTextField();
		txtcountry.setBounds(220, 250, 150, 25);
		add(txtcountry);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setBounds(30, 290, 150, 25);
		add(lbladdress);
		
		txtaddress = new JTextField();
		txtaddress.setBounds(220, 290, 150, 25);
		add(txtaddress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setBounds(30, 330, 150, 25);
		add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setBounds(220, 330, 150, 25);
		add(txtemail);
		
		JLabel lblphone = new JLabel("Mobile Number");
		lblphone.setBounds(30, 370, 150, 25);
		add(lblphone);
		
		txtphone = new JTextField();
		txtphone.setBounds(220, 370, 150, 25);
		add(txtphone);
		
		badd = new JButton("ADD");
		badd.setBorderPainted(false);
		badd.setOpaque(true);
		badd.setBackground(new Color(209, 140, 50));
		badd.setForeground(Color.white);
		badd.setBounds(70, 430, 80, 25);
		badd.addActionListener(this);
		add(badd);
		
		bback = new JButton("BACK");
		bback.setBorderPainted(false);
		bback.setOpaque(true);
		bback.setBackground(new Color(209, 140, 50));
		bback.setForeground(Color.white);
		bback.setBounds(225, 430, 80, 25);
		bback.addActionListener(this);
		add(bback);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hook-405091.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400, 30, 450, 420);
		add(image);
		
		try {
			Connect c = new Connect();
			ResultSet rs = c.s.executeQuery("select * from account where username = '"+usrnm+"'");
			while(rs.next()) {
				labelusername.setText(rs.getString("username"));
				lblname.setText(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == badd) {
			String username = labelusername.getText();
			String id = (String) comboId.getSelectedItem();
			String number = txtnumber.getText();
			String name = lblname.getText();
			String gender = null;
			if(rmale.isSelected()) {
				gender = "Male";
			} else {
				gender = "Female";
			}
			String country = txtcountry.getText();
			String address = txtaddress.getText();
			String phone = txtphone.getText();
			String email = txtemail.getText();
			
			try {
				Connect c = new Connect();
				String query = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Customer details added successfully");
				setVisible(false);
				new Dashboard(usrnm);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(ae.getSource() == bback) {
			setVisible(false);
			new Dashboard(usrnm);
		}
	}
	
	public static void main(String[] args) {
		new AddCustomer("");
	}
}
