

//step1
import java.sql.*;
public class Database {

	public static void main(String[] args)throws Exception {
	
		
		
		try {
		//step2
		Class.forName("com.mysql.cj.jdbc.Driver");
		 
		//step3
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/plasmadonor","root","12345");
		 
		//step4
		PreparedStatement st1=conn.prepareStatement("insert into datajava(name,Age,branch) values('gpr', 21 , 'comp')");	
		
		//step5
		
		
	    
	    //String r="select name from datajava where Age=21";
	    int rs=st1.executeUpdate();
	     //rs1.next();
	   //  String name=rs1.getString("name");
	     //System.out.println(name);
	    // rs1.close();
		st1.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
