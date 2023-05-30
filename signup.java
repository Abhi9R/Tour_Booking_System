import java.awt.*;
import java.awt.event.*;
import java.sql.Statement;

import javax.swing.*;



public class signup extends JFrame implements ActionListener{
	JButton create, back;
	JTextField tfusername, tfname, tfpassword, tfanswer;
	Choice csecurity;
	
	Statement s;
	
	signup() {
		setSize(900, 400);
		setLocation(350, 200);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133, 193, 233));
		p1.setBounds(0, 0, 500, 400);
		p1.setLayout(null);
		add(p1);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("Tahoma", Font.BOLD, 14));
		username.setBounds(50, 20, 125, 25);
		p1.add(username);
		
		tfusername = new JTextField();
		tfusername.setBounds(190, 20, 180, 25);
		tfusername.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfusername);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		name.setBounds(50, 60, 125, 25);
		p1.add(name);
		
		tfname = new JTextField();
		tfname.setBounds(190, 60, 180, 25);
		tfname.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfname);
		
		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(50, 100, 125, 25);
		p1.add(password);
		
		tfpassword = new JTextField();
		tfpassword.setBounds(190, 100, 180, 25);
		tfpassword.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfpassword);
		
		JLabel security = new JLabel("Security Question");
		security.setFont(new Font("Tahoma", Font.BOLD, 14));
		security.setBounds(50, 140, 125, 25);
		p1.add(security);
		
		csecurity = new Choice();
		csecurity.add("--select--");
		csecurity.add("Fav character from Harry Potter");
		csecurity.add("Fav Marvel character");
		csecurity.add("Your lucky number");
		csecurity.setBounds(190, 140, 180, 25);
		p1.add(csecurity);
		
		JLabel answer = new JLabel("Answer");
		answer.setFont(new Font("Tahoma", Font.BOLD, 14));
		answer.setBounds(50, 180, 125, 25);
		p1.add(answer);
		
		tfanswer = new JTextField();
		tfanswer.setBounds(190, 180, 180, 25);
		tfanswer.setBorder(BorderFactory.createEmptyBorder());
		p1.add(tfanswer);
		
		create = new JButton("Create");
		create.setBackground(Color.white);
		create.setForeground(new Color(133, 193, 233));
		create.setFont(new Font("Tahoma", Font.PLAIN, 14));
		create.setBounds(50, 250, 100, 30);
		create.addActionListener(this);
		p1.add(create);
		
		back = new JButton("Back");
		back.setBackground(Color.white);
		back.setForeground(new Color(133, 193, 233));
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		back.setBounds(170, 250, 100, 30);
		back.addActionListener(this);
		p1.add(back);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("signup.png"));
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(580, 50, 250, 250);
		add(image);
		
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == create) {
			String username = tfusername.getText();
			String name = tfname.getText();
			String password = tfpassword.getText();
			String question = csecurity.getSelectedItem();
			String answer = tfanswer.getText();
			
			String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
			try {
				Connect c = new Connect();
				c.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Account created successfully");
				setVisible(false);
				new Login();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if (ae.getSource() == back) {
			setVisible(false);
			new Login();
		}
	}
	

	public static void main(String[] args) {
		new signup();
	}
}
