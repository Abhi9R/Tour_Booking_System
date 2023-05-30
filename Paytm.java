import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paytm extends JFrame implements ActionListener{
	String user;
	
	
	Paytm(String username) {
		this.user = username;
		setBounds(500, 200, 800, 600);
		
		
		JEditorPane pane = new JEditorPane();
		pane.setEditable(false);
		
		
		try {
			
			pane.setPage("https://paytm.com/rent-payment");
			
		} catch(Exception e) {
			pane.setContentType("text/html");
			pane.setText("<html>Could not load, Error 404</html>");
		}
		
		JScrollPane sp = new JScrollPane(pane);
		getContentPane().add(sp);
		
		JButton back = new JButton("BACK");
		back.setBounds(610, 20, 80, 40);
		back.addActionListener(this);
		pane.add(back);
		
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		new Payment(user);
		setVisible(false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Paytm("");
	}

}
