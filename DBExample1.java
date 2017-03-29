import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBExample1 {
	public static void main(String[] args) {

		try{
			/*Register the Driver
			- code to register your installed driver with your program (only do once)
			- forName() method of the Java.lang.class and loads the JDBC driver directly
			- DriverManager class provides services for manageing the JDBC driver
			- com.mysql.jdbc.Driver is the specific driver string for MySQL */
			Class.forName("com.mysql.jdbc.Driver");

			/*Get a connection to the database
			 - getConnection() is a static method of the JDBC DriverManager class that opens
			 the connection to the database
			 - returns an object of the JDBC Connection class which needs as input a userid, password
			 connect string that identifies the JDBC driver to use and the name of the db you want to use*/
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/itb","root", "");

			/*Create a statement - have your Connection object (conn). Now want to create a
			Statement object (stmt)
			- createStatement() method of the JDBC Connection class returns an object of the JDBC Statement class*/
			Statement stmt = conn.createStatement();

			/*Execute a Query - to query the database, use the executeQuery() method of the Statemnt object
			- this method takes a SQL query as input and returns an object of the JDBC ResultSet class
			- the ResultSet object (rs)  is populated with the results of the query*/
			ResultSet rs = stmt.executeQuery("select * from emp");

			/*Process the results set - use next() method of the ResultsSet object to iterate
			- through the result set row by row
			- detects the end of the results set when it is reached
			- have getXXX() methods to pull data (e.g. getString()) out of the results set */
			while (rs.next()){
				System.out.println(rs.getInt("empno") + "," + rs.getString("ename"));

			}
		/*clean up the enviornment	- must close the resultset and statement objects
		and close the connection to the db*/
		rs.close();
	    stmt.close();
	    conn.close();
		}

		catch(Exception e){

			e.printStackTrace();
		}
	}
}
