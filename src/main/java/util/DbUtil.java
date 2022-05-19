package util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql:dbconnection", "axizuser", "axiz");
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}
