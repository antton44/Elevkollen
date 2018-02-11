package data.persistanceFacade.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginBroker extends Broker{

	private Connection conn = null;
	private Statement stmt = null;
	// DATABAS
	@Override
	public void insertStorage(Object object) throws SQLException {
		
		
		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String temp = t[0];
		String[] splitter = temp.split("---");
		String input = splitter[0];
		String input2 = splitter[1];
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Users(personnummer, password) VALUES ('"
					+ input + "', '" + input2 + "');");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStorage(Object object) throws SQLException {
		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String temp = t[0];
		String[] splitter = temp.split("---");
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE Users SET password ='"
					+ splitter[1] + "' WHERE personnummer='" + splitter[0] + "';");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
public void deleteStorage(Object object) throws SQLException {
		
		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String temp = t[0];
		String[] splitter = temp.split("---");
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM Users WHERE personnummer='" + splitter[0] + "';");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getFromStorage(Object object) throws SQLException {
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");
			while ( rs.next() ) {
				 @SuppressWarnings("unused")
				String id = rs.getString("personnummer");
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		} catch (Throwable e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return object;
	}

	@Override
	public Object findInStorage(Object object) throws SQLException {

		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String temp = t[0];
		String[] splitter = temp.split("---");
		
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE personnummer='" + splitter[0] + "';");
			while ( rs.next() ) {
				 String id2 = rs.getString("personnummer");
			     rs.close();
			     stmt.close();
			     conn.close();
		         return id2;
		      }
		      rs.close();
		      stmt.close();
		      conn.close();
		} catch (Throwable e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return null;
	}
}
