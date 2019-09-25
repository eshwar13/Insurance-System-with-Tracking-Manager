
import java.sql.*;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
                Scanner in = new Scanner(System.in);
		Connection conn = null;
		String option = null;
		do
		{
		int choose = 0 ;
		final String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "User13", "sony13");
		
			System.out.println("Want to Update values\nChoose options::\n1)Updating ID\n2)Updating name\n3)Updating Insurance-type");
			choose = in.nextInt();
			switch(choose)
			{
			 
			case 1 :
				System.out.println("Enter new ID:");
				int ID = in.nextInt();
				System.out.println("Enter your previous ID");
				int ID1 = in.nextInt();

			PreparedStatement ps = conn.prepareStatement("update insuranceservice set id = ? where id = ? ");
			ps.setInt(1, ID);
			ps.setInt(2, ID1);
			ps.executeQuery();
			System.out.println("Updation Completed .\nCheck View.java file for Confirmation");
			break;
			case 2 :
			
			
				System.out.println("Enter new name:");
				String name = in.next();
			System.out.println("Enter your previous name");
			String name1 = in.next();
			PreparedStatement ps1 = conn.prepareStatement("update insuranceservice set name = ? where name = ? ");
			ps1.setString(1,name);
			ps1.setString(2, name1);
			
			ps1.executeQuery();
			System.out.println("Updation Completed .\nCheck View.java file for Confirmation");
			break;
			
			case 3 :
				
				System.out.println("Enter new Insurance-type:");
				String type = in.next();
			System.out.println("Enter your previous Insurance-type");
			String type1 = in.next();
			PreparedStatement ps2 = conn.prepareStatement("update insuranceservice set type = ? where type = ? ");
			ps2.setString(1,type);
			ps2.setString(2, type1);
			
			ps2.executeQuery();
			System.out.println("Updation Completed .\nCheck View.java file for Confirmation");
			break;
			
			default :
				System.out.println("!!!*****");
				break;
			}
		
			System.out.println("TO continue Types yes/no ");
			option = in.next();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	
		}while(option.equals("yes"));
		
			
		
	
		in.close();
	}

}
