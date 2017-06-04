package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParentBroker  extends Broker {

	private Connection conn = null;
	private Statement stmt = null;
	// DATABAS
	@Override
public void insertStorage(Object object) throws SQLException {
		
		
		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String hej = t[0];
		String[] splitter = hej.split("---");
		String input = splitter[0];
		String input2 = splitter[1];
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Parents(personnummer, namn, email) VALUES ('"
					+ input + "', '" + input2 + "', '" + splitter[2]+ "');");
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
		String hej = t[0];
		String[] splitter = hej.split("---");
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("UPDATE Parents SET namn ='"
					+ splitter[1] + "', email ='" + splitter[2] + "' WHERE personnummer='" + splitter[0] + "';");
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
		String hej = t[0];
		String[] splitter = hej.split("---");
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt.executeUpdate("DELETE FROM Parents WHERE personnummer='" + splitter[0] + "';");
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Parents;");
			while ( rs.next() ) {
				 @SuppressWarnings("unused")
				String id = rs.getString("personnummer");
		         @SuppressWarnings("unused")
				String  name = rs.getString("namn");
		         @SuppressWarnings("unused")
				String email = rs.getString("email");
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

	@Override
	public Object findInStorage(Object object) throws SQLException {

		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String hej = t[0];
		String[] splitter = hej.split("---");
		
		try{
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Parents WHERE personnummer='" + splitter[0] + "';");
			while ( rs.next() ) {
				 String id2 = rs.getString("personnummer");
		         String  name = rs.getString("namn");
		         String email = rs.getString("email");
			     rs.close();
			     stmt.close();
			     conn.close();
		         System.out.println();
		         return id2 + "---" + name + "---" + email;
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