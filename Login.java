import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	
	JButton ln, sp, fp;
	JTextField tfusrnm, tfpswrd;
	Login() {
		setSize(900, 400);
		setLocation(350, 200);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(131, 193, 233));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("295128.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(100, 90, 200, 200);
		p1.add(image);
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.DARK_GRAY);
		p2.setLayout(null);
		p2.setBounds(400, 30, 450, 300);
		add(p2);
		
		JLabel usrnm = new JLabel("Username");
		usrnm.setBounds(60, 20, 100, 25);
		usrnm.setForeground(Color.WHITE);
		usrnm.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(usrnm);
		
		tfusrnm = new JTextField();
		tfusrnm.setBounds(60, 60, 300, 30);
		p2.add(tfusrnm);
		
		JLabel pswrd = new JLabel("Password");
		pswrd.setBounds(60, 110, 100, 25);
		pswrd.setForeground(Color.WHITE);
		pswrd.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
		p2.add(pswrd);
		
		tfpswrd = new JTextField();
		tfpswrd.setBounds(60, 150, 300, 30);
		p2.add(tfpswrd);
		
		ln = new JButton("login");
		ln.setBounds(60, 200, 85, 30);
		ln.addActionListener(this);
		p2.add(ln);
		
		sp = new JButton("sign up");
		sp.setBounds(160, 200, 90, 30);
		sp.addActionListener(this);
		p2.add(sp);
		
		fp = new JButton("forget password ?");
		fp.setBounds(260, 200, 135, 30);
		fp.addActionListener(this);
		p2.add(fp);
		
		
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == ln) {
			try {
				String username = tfusrnm.getText(); 
				String password = tfpswrd.getText();
				
				String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
				Connect c = new Connect();
				ResultSet rs = c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Loading(username);
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password or account doesn't exist");
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else if(ae.getSource() == sp) {
			setVisible(false);
			new signup();
			
		} else if(ae.getSource() == fp) {
			setVisible(false);
			new ForgetPassword();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

}
