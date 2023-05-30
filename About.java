import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
	
	String usr;
	JButton back;
	
	About(String user) {
		this.usr = user;
		setBounds(180, 200, 1100, 500);
		setLayout(null);
		getContentPane().setBackground(new Color(58, 175, 169));
		
		JLabel text = new JLabel("Created and Developed by");
		text.setBounds(250, 90, 800, 50);
		text.setFont(new Font("Tahoma", Font.BOLD, 40));
		text.setForeground(new Color(23, 37, 42));
		add(text);
		
		JLabel text1 = new JLabel("ABHINAV");
		text1.setBounds(390, 210, 800, 60);
		text1.setFont(new Font("Tahoma", Font.BOLD, 50));
		text1.setForeground(new Color(254, 255, 255));
		add(text1);
		
		JLabel text2 = new JLabel("abhinavar0221@gmail.com");
		text2.setBounds(410, 300, 200, 20);
		text2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		//text.setForeground(new Color(43, 122, 120));
		add(text2);
		
		back = new JButton("BACK");
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.setBackground(new Color(222, 242, 241));
		back.setBounds(40, 400, 100, 30);
		back.setFont(new Font("Tahoma", Font.BOLD, 20));
		back.setForeground(Color.black);
		back.addActionListener(this);
		add(back);
		
		setVisible(true);
		setResizable(false);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == back) {
			new Dashboard(usr);
			setVisible(false);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new About("");
	}

}
