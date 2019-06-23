import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings("unused")
public class InFormDao {
	public static int delete(String bookcallno,int studentid){
		int status=1;
		try{
			Connection con=DataBase.getConnection();
			
		//	status=updatebook(bookcallno);//updating quantity and issue
			
			if(status>0){
			PreparedStatement ps=con.prepareStatement("DELETE FROM `inout` WHERE usn=? and roomno=?");
			ps.setString(1,bookcallno);
			ps.setInt(2,studentid);
			status=ps.executeUpdate();
			}
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	/*public static int updatebook(String bookcallno){
		int status=0;
		String quantity = null;
		int issued=0;
		try{
			Connection con=DataBase.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select location,roomno from leave where usn=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getString("location");
				issued=rs.getInt("roomno");
			}
			
			if(issued>0){
			PreparedStatement ps2=con.prepareStatement("update leave set location=?,roomno=? where usn=?");
			ps2.setString(1,bookcallno);
			ps2.setString(2,quantity+1);
			ps2.setInt(3,issued-1);
			
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}*/
}

