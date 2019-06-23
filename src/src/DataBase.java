import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
	public static Connection getConnection(){
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mini","root","");
			System.out.println("connected...");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}

