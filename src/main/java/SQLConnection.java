import java.sql.*;

public class SQLConnection
{
	private Connection connection;
	private Statement statement;
	
	public void connect(String url, String user, String password) throws SQLException, ClassNotFoundException
	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
	}
	
	public void disconnect() throws SQLException
	{
            connection.close();
	}
	
	public ResultSet getData(String query) throws SQLException
	{
            return statement.executeQuery(query);
	}
	
	public void insertData(String query) throws SQLException
	{
            statement.executeUpdate(query);
	}
}