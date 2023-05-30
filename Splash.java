import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame{
	
	Splash(){
		setSize(1200, 600);
		setLocation(100, 100);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mountains-100367.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1200, 600, DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		add(image);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Splash frame = new Splash();
	}

}
