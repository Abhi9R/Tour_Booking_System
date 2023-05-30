import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Payment extends JFrame implements ActionListener{
	JButton pay, back; 
	String usr;
	
	Payment(String username) {
		this.usr = username;
		setBounds(300, 180, 800, 600);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("paytm.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 800, 600);
		add(image);
		
		pay = new JButton("PAY");
		pay.setBorderPainted(false);
		pay.setOpaque(true);
		pay.setBackground(new Color(135, 206, 235));
		pay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pay.setForeground(Color.white);
		pay.setBounds(520, 90, 100, 60);
		pay.addActionListener(this);
		image.add(pay);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(135, 206, 235));
		back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		back.setForeground(Color.white);
		back.setBounds(520, 180, 100, 60);
		back.addActionListener(this);
		image.add(back);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == pay) {
			new Paytm(usr);
		} else {
			new Dashboard(usr);
			setVisible(false);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Payment("");
	}

}
