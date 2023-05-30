import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
	Thread t;
	JProgressBar bar;
	String usr;
	
	public void run() {
		try {
			for(int i=1;i<=101;i++) {
				int max = bar.getMaximum(); // 100
				int value = bar.getValue(); 
				
				if(value < max) {
					bar.setValue(bar.getValue() + 1);
				} else {
					setVisible(false);
					new Dashboard(usr);
				}
				
				Thread.sleep(50);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Loading(String usrnm) {
		this.usr = usrnm;
		t = new Thread(this);
		
		setBounds(500, 200, 650, 400);
		getContentPane().setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JLabel text = new JLabel("Tour Booking System");
		text.setBounds(130, 20, 600, 40);
		text.setForeground(new Color(255, 165, 0));
		text.setFont(new Font("Tahoma", Font.BOLD, 35));
		add(text);
		
		bar = new JProgressBar();
		bar.setBounds(160, 100, 300, 35);
		bar.setBackground(Color.white);
		bar.setStringPainted(true);
		add(bar);
		
		JLabel loading = new JLabel("Loading, please wait...");
		loading.setBounds(120, 140, 615, 45);
		loading.setForeground(new Color(255, 255, 255));
		loading.setFont(new Font("Tahoma", Font.BOLD, 35));
		add(loading);
		
		JLabel username = new JLabel("Welcome " + usr + " !!!");
		username.setBounds(20, 310, 400, 40);
		username.setForeground(new Color(255, 165, 0));
		username.setFont(new Font("Raleway", Font.PLAIN, 25));
		add(username);
		
		t.start();
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Loading("");
	}
}
