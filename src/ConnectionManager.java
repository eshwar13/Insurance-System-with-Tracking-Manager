
import java.sql.*;                                                //import SQL package
   abstract class ConnectionManager 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException
{
	
	
	
	Class.forName("oracle.jdbc.driver.OracleDriver");       //LOading Driver class
	
	Connection conn = null;                                  //creating connection .
	
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","User13","sony13");    //creating connection object
	if(conn != null)
	{
		System.out.println("Connection Established Sucessfully");
	}                                                                             /*processing the connection */
	else
	{
		System.out.println("not Connected");
	}
	
	conn.close();      
}

}


	

	


 