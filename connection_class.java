package AMS;
import java.sql.*;
public class connection_class
{
   Connection con;
   Statement stm;
   
   connection_class()
   {
     try
     {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql:///AMS","root","Rohit1001#");
        stm=con.createStatement();
     }
     catch(Exception ex)
     {
         ex.printStackTrace();
     }
   }
     public static void main(String[] args)
     {
         new connection_class();
     }
    
}
