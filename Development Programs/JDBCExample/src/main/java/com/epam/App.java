package com.epam;
import java.sql.*;

/**
 * step to create the connection using JDBC
 * 1) import java.sql
 * 2) load and register the driver
 * 3) create connection
 * 4) create a statement
 * 5) execute the query
 * 6) process the results
 * 7) close the connection
 */
public class App
{
    public static void main( String[] args )
    {
       try {
           String url = "jdbc:mysql://localhost:3306/testdb";
           String username = "root";
           String password = "Jagadish@99";
           String query = "SELECT * FROM STUDENT";

           Connection con = DriverManager.getConnection(url, username, password);

           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery(query);

           while (rs.next()) {
               System.out.println(rs.getInt(1)+" "+rs.getString(2));
           }


           // now add the data
           DataAddClass.addData();
       }

       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
    }
}

class DataAddClass
{
   private static final String url = "jdbc:mysql://localhost:3306/testdb";
   private static final String username = "root";
   private static final String password = "Jagadish@99";

   public static void addData()
   {
       try{
           // data
           int id=5;
           String name ="Ashwini";
           String query = "INSERT INTO STUDENT VALUES (?,?) ";

           Connection con = DriverManager.getConnection(url,username,password);
           // prepared the statement first
           PreparedStatement ps = con.prepareStatement(query);
           ps.setInt(1,id);
           ps.setString(2,name);

           // now execute the query at the last
           int count = ps.executeUpdate();

           System.out.println("Rows affected "+count);
       }
       catch (SQLException e)
       {
           System.out.println(e.getMessage());
       }
   }
}
