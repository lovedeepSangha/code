package Server;

import java.sql.*;

public class DataBase_Checking_UserName_Password {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/user_id";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	Connection conn = null;
	Statement stmt = null;

	public boolean Checking_UserName_Password(long Userid, String Password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// second step
			System.out.println(Userid + Password);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");

			PreparedStatement sql;

			sql = conn.prepareStatement("SELECT * FROM  user_id WHERE User_id=? and Password=?");
			sql.setDouble(1, (double) Userid);
			sql.setString(2, Password);
			ResultSet resultSet = sql.executeQuery();
			if (resultSet.next()) {
				System.out.println("done");
				return true;
			} else {
				System.out.println("not");
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
