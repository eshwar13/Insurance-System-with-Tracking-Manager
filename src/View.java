
import java.sql.*;
public class View 
{

	public static void main(String[] args) throws SQLException
	{
		Connection conn = null ;
		try
		{
		
		
	final String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
     	
	
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "User13", "sony13");
		
			PreparedStatement ps = conn.prepareStatement("select * from insuranceservice");
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("ID"+"    " +"Name"+"     "+"Gender"+"    "+"Insuracne-type"+"      "+"Details");
			
			while(rs.next())
			{
				//System.out.println("ID"+"      " +"Name"+"       "+"Gender"+"      "+"Type"+"        "+"Details\n");
			System.out.println("\n");
				System.out.print(rs.getInt(1)+"   ");
				System.out.print(rs.getString(2)+"    ");
                System.out.print(rs.getString(3)+"      ");
                System.out.print(rs.getString(4)+"      ");
                System.out.println(rs.getString(5)+"  ");
                
				}
			
			
			}
     	
		
		
	
		catch (ClassNotFoundException e) 
     	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
		
		
		

	}

}
