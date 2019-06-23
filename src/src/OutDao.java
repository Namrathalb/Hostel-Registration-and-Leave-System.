import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@SuppressWarnings("unused")
public class OutDao {
	
/*public static boolean checkBook(String bookcallno){
	boolean status=false;
	try{
		Connection con=DataBase.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from inout where usn=?");
		ps.setString(2,bookcallno);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
*/

public static int save(String bookcallno,String studentid,String studentname,String studentcontact){
	int status=1;
	try{
		Connection con=DataBase.getConnection();		
		//status=updatebook(bookcallno);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("INSERT INTO `inout`(`usn`, `roomno`, `loaction`, `contact`) VALUES (?,?,?,?)");
		ps.setString(1,bookcallno);
		ps.setString(2,studentid);
		ps.setString(3,studentname);
		ps.setString(4,studentcontact);
		status=ps.executeUpdate();
		}		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
/*public static int updatebook(String bookcallno){
	int status=0;
	int squantity=0,issued=0;
//	String location;
	try{
		Connection con=DataBase.getConnection();
		
		PreparedStatement ps=con.prepareStatement("select location, roomno, going, quantity from leave where usn=?");
		ps.setString(1,bookcallno);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			squantity=rs.getInt("roomno");
		//	location=rs.getString("location");
			issued=rs.getInt("quantity");
		}
		
		if(squantity>0){
		PreparedStatement ps2=con.prepareStatement("update leave set to=?, fatherno=? where usn=?");
		ps2.setInt(3,squantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(1,bookcallno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}*/
}
