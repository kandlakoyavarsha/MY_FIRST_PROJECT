import java.sql.*;
public class InsertNavya{
    public static void main(String args[])
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tables","root","0709");
            PreparedStatement ps=con.prepareStatement("delete from navya");
            /*ps.setInt(1,10);
            ps.setString(2,"navya");*/
            ps.executeUpdate();
            ps.close();
            con.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}