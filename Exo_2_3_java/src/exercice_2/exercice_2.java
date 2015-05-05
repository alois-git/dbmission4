package exercice_2;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class exercice_2 {
	
	public static void main(String[]toto) throws SQLException{
		
		// Add library https://jdbc.postgresql.org/download.html, JDBC4 Postgresql Driver, Version 9.4-1201 for example.
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection connection = null;
		
		// You need to introduce correct data for connecting the database.
		try {
			//getConnection(String url, String user, String password)
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/exercice_1","postgres","a");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (connection != null) {
			//TODO generer une table free.
			//SITDOWN
			CallableStatement stmt = connection.prepareCall(" { ? = call sitdown(3)}");
			stmt.registerOutParameter(1, Types.INTEGER);
			stmt.execute();
			int token = stmt.getInt(1);
			stmt.close();
			if (token == -1){
				System.out.println("table is not free");
			}
			else{
				//ORDERDRINKS
				stmt = connection.prepareCall(" { call orderDrinks(?, array[[2,1]])}");
				stmt.setInt(1, token);
				stmt.execute();
				stmt.close();
				//ISSUETICKET
				stmt = connection.prepareCall(" {? = call issueTicket(?) }");
				stmt.registerOutParameter(1, Types.VARCHAR);
				stmt.setInt(2, token);
				stmt.execute();
				String ticket = stmt.getString(1);
				stmt.close();
				System.out.println(ticket);
				//ORDERDRINKS
				stmt = connection.prepareCall(" { call orderDrinks(?, array[[2,1]])}");
				stmt.setInt(1, token);
				stmt.execute();
				stmt.close();
				//PAY
				stmt = connection.prepareCall(" { ? = call payTable(?, 20) }");
				stmt.registerOutParameter(1, Types.VARCHAR);
				stmt.setInt(2, token);
				stmt.execute();
				String res = stmt.getString(1);
				stmt.close();
				System.out.println(res);
			}
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
}
