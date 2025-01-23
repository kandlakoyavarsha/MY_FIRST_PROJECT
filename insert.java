import java.sql.*;  

class MysqlCon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/tables","root","0709");  
//here sonoo is database name, root is username and password  
PreparedStatement stmt=con.prepareStatement("insert into boats values(?,?,?)");  
stmt.setInt(1,211);
stmt.setString(2,"vidhura");
stmt.setString(3,"red");
int i=stmt.executeUpdate();
System.out.println(i+"records inserted");
con.close();  
}catch(Exception e){ System.out.println(e);}  
}  

}  