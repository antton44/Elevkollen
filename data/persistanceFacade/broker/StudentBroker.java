package data.persistanceFacade.broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentBroker extends Broker {
	//Variabler för databas
	private Connection conn = null;
	private Statement stmt = null;

	// DATABAS
	@Override
	public void insertStorage(Object object) throws SQLException {
		//Rensar bort DTO-id
		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		//Rensad sträng, utan DTO-id
		String temp = t[0];
		//Delar upp sträng innan insert till databasen
		String[] splitter = temp.split("---");
		String input = splitter[0];
		String input2 = splitter[1];
		try {
			//"Connectar" till databasen
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			//Stänger av auto-commit. Annars går det inte göra något vettigt med test.db
			conn.setAutoCommit(false);
			//Insert till databas med hjälp SQL och tidigare uppdelad sträng.
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO Students(personnummer, namn, email) VALUES ('"
					+ input + "', '" + input2 + "', '" + splitter[2] + "');");
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
			stmt.executeUpdate("UPDATE Students SET namn ='" + splitter[1]
					+ "', email ='" + splitter[2] + "' WHERE personnummer='"
					+ splitter[0] + "';");
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
			stmt.executeUpdate("DELETE FROM Students WHERE personnummer='"
					+ splitter[0] + "';");
			stmt.close();
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getFromStorage(Object object) throws SQLException {

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			String SQL = "SELECT * FROM Students;";
			stmt = conn.createStatement();
			boolean results = stmt.execute(SQL);
			@SuppressWarnings("unused")
			int rsCount = 0;
			String returns = "";
			// Loop through the available result sets.
			do {
				if (results) {
					ResultSet rs = stmt.getResultSet();
					rsCount++;

					// Show data from the result set.

					while (rs.next()) {
						String id = rs.getString("personnummer");
						String name = rs.getString("namn");
						String email = rs.getString("email");

						returns += id + "---" + name + "---" + email + "\n";
					}
					rs.close();
				}
				results = stmt.getMoreResults();
			} while (results);
			stmt.close();
			conn.close();
			return returns;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object findInStorage(Object object) throws SQLException {

		String s = object.toString() + ":::";
		String[] t = s.split(":::");
		String temp = t[0];
		String[] splitter = temp.split("---");

		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:test.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Students WHERE personnummer='"
							+ splitter[0] + "';");
			while (rs.next()) {
				String id2 = rs.getString("personnummer");
				String name = rs.getString("namn");
				String email = rs.getString("email");
				rs.close();
				stmt.close();
				conn.close();
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
