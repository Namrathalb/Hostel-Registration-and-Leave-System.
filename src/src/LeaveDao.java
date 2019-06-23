import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
public class LeaveDao {
public static int save(String usn,String roomno,String location,String going,int squantity){
	int status=0;
	try{
		Connection con=DataBase.getConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO `leave`(`usn`, `roomno`, `location`, `going`, `quantity`) values(?,?,?,?,?)");
		ps.setString(1,usn);
		ps.setString(2,roomno);
		ps.setString(3,location);
		ps.setString(4,going);
		ps.setInt(5,squantity);
		status=ps.executeUpdate();
		con.close();
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
}
}

