package mock.bank.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public static final String DB_URL = "jdbc:postgresql://localhost:5432/bank-mock";
	public static final String DB_USERNAME = "postgres";
	public static final String DB_PASSWORD = "postgres";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	}
}
