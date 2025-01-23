import java.util.*;
import java.sql.*;

class A
{
    public static void main(String...args)
    {
        try{
      String q="insert into boats values(?,?,?)"  ;
      Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tables","root","0709");
      PreparedStatement st=con.prepareStatement(q);
      st.setInt(1,108);
      st.setString(2,"varsha");
      st.setString(3,"red");
      ResultSet rs=st.executeQuery();
      
      st.close();
      con.close();}
      catch(Exception e)
      {
        System.out.println(e);
      }
    }
}