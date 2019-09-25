
import java.sql.*;

import java.util.Scanner;
public class Delete 
{

	public static void main(String[] args) throws SQLException 
	
	
	{
		String option  = null;
		
		Connection conn = null ;
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		do
		{
		
		try
		{
	
		
	final String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
     	
	
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "User13", "sony13");
			
			//Statement st = conn.createStatement();
			
			
			  System.out.println("Want to delete record\nEnter candidate ID");
			  int id = in.nextInt();
			  
			  PreparedStatement ps = conn.prepareStatement("delete from insuranceservice where ID=?");
			  ps.setInt(1, id);
			  ps.executeQuery();
			  
			  System.out.println("your record is delete\nTO continue yes\nTO view records type --view--");
			  
			
			option = in.next();
			
			
			
			ps.close();
		
		}
			
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		
	}
			
	}while(option.equals("yes"));
		
		while(option.equals("no"))
		{
			System.out.println("!!!!!!!!*******");
		}
	
		if(option.equals("view"))
		{
  PreparedStatement pst = conn.prepareStatement("select * from insuranceservice");
			
			ResultSet rs = pst.executeQuery();
			
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
		else
		{
			System.out.println("!!!!!!!******");
		}
		

}
}
