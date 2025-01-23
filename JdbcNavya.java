import java.sql.*;
public class JdbcNavya{
	public static void main(String args[]) throws Exception
	{
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tables","root","0709");
		Statement s=con.createStatement();
		s.executeUpdate("create table Navya(id int,name char(10))");
		s.close();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}