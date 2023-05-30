import java.sql.*;

public class Connect {

	Statement s;

	Connect() {
		String url = "jdbc:mysql://localhost:3306/travelmanagementsystem";
		String username = "root";
		String password = "abhinav@123";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password); 
			s = connection.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
