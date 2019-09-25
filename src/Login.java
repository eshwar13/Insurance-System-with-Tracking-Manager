

import java.util.regex.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class Login {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	
	{
		String take = null;
		Scanner in = new Scanner(System.in);
		do
		{
		int choice = 0 ;
		
		System.out.println("Welcome to Login Page:\n\nEnter Your GmailID");
		String user = in.next();
		Pattern p = Pattern.compile("[@gmail.com]");
		Matcher m = p.matcher(user);
		if(m.find())
		{
			System.out.println("Enter your Password:");
			String password = in.next();
			Pattern p1 = Pattern.compile("[A-Z]+[a-z]+[^a-zA-Z0-9]\\D*");
			Matcher m1 = p1.matcher(password);
			if(m1.find() && m1.group().equals(password))
			{
				System.out.println("Sucessfully Completed login\n\n1)TO View  Records2)Update Records\n3)Delete Records");
				choice = in.nextInt();
				switch(choice)
				{
				case 1:
					  Login obj = new Login();
					  obj.view();
					  System.out.println("\n");
				break;
				
				case 2 :
					Login obj1 = new Login();
					obj1.Update();
					System.out.println("\n");
					break;
				
				case 3 :
					Login obj2 = new Login();
					obj2.delete();
					System.out.println("\n");
					break;
					default :
						System.out.println("Incorrect option");
						System.out.println("\n");
						break;
				
				}
			}
			else
			{
				System.out.println("Invalid password");
			}
		}
		else
		{
			System.out.println("Invalid Username ");
		}
		System.out.println("TO continue type yes\n");
           take = in.next();
	}while(take.equals("yes"));
	
	in.close();
	}
	
	
	public void view() throws ClassNotFoundException, SQLException
	{
		
		Connection conn = null ;
		
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
		public void Update() throws SQLException
		{
			
		Scanner ni = new Scanner(System.in);
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
				choose = ni.nextInt();
				switch(choose)
				{
				 
				case 1 :
					System.out.println("Enter new ID:");
					int ID = ni.nextInt();
					System.out.println("Enter your previous ID");
					int ID1 = ni.nextInt();

				PreparedStatement ps = conn.prepareStatement("update insuranceservice set id = ? where id = ? ");
				ps.setInt(1, ID);
				ps.setInt(2, ID1);
				ps.executeQuery();
				System.out.println("Updation Completed .\nCheck View.java file for Confirmation");
				break;
				case 2 :
				
				
					System.out.println("Enter new name:");
					String name = ni.next();
				System.out.println("Enter your previous name");
				String name1 = ni.next();
				PreparedStatement ps1 = conn.prepareStatement("update insuranceservice set name = ? where name = ? ");
				ps1.setString(1,name);
				ps1.setString(2, name1);
				
				ps1.executeQuery();
				System.out.println("Updation Completed .\nCheck View.java file for Confirmation");
				break;
				
				case 3 :
					
					System.out.println("Enter new Insurance-type:");
					String type = ni.next();
				System.out.println("Enter your previous Insurance-type");
				String type1 = ni.next();
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
				option = ni.next();
				
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}while(option.equals("yes"));
			ni.close();
	}
		
		public void delete() throws SQLException
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
			
		in.close();
		}
		
	}




