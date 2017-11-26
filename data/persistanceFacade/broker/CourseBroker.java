package data.persistanceFacade.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseBroker extends Broker {

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
			stmt.executeUpdate("INSERT INTO Kurs(KursID, Namn) VALUES ('"
					+ input + "', '" + input2 + "')");
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
			stmt.executeUpdate("UPDATE Kurs SET Namn ='"
					+ splitter[1] + "' WHERE KursID='" + splitter[0] + "';");
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
			stmt.executeUpdate("DELETE FROM Kurs WHERE KursID='" + splitter[0] + "';");
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
			String SQL = "SELECT * FROM Kurs;";
			stmt = conn.createStatement();
			boolean results = stmt.execute(SQL);
		      int rsCount = 0;
		      String returns = "";
		      //Loop through the available result sets.
		     do {
		        if(results) {
		           ResultSet rs = stmt.getResultSet();
		           rsCount++;

		           //Show data from the result set.
		           System.out.println("RESULT SET #" + rsCount);
		           
		           while (rs.next()) {
		        	  String id = rs.getString("KursID");
				      String  name = rs.getString("Namn");
		        	  System.out.println(rs.getString("KursID") + ", " + rs.getString("Namn"));
		              returns += id + "---" + name + "\n";
		           }
		           rs.close();
		       }
		       results = stmt.getMoreResults();
		       } while(results);
			       stmt.close();
				   conn.close();
				   return returns;
			   }
		   catch (Exception e) {
		      e.printStackTrace();
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM Kurs WHERE KursID='" + splitter[0] + "';");
			while ( rs.next() ) {
				 String id2 = rs.getString("KursID");
		         String  name = rs.getString("Namn");
		         return id2 + "---" + name;
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