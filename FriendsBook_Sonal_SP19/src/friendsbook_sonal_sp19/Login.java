/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsbook_sonal_sp19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class Login {
    
    String User_Id;
    String password;

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String User_Id) {
        this.User_Id = User_Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
      public boolean login_Method(String User_Id, String password)
     {
          
      Scanner input=new Scanner(System.in);
      boolean loginYes=false;
    
         try{
             Class.forName("com.mysql.jdbc.Driver");
             
         }
         catch(Exception e)
         {
             return (false);
         }
         
         final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
         Connection connection=null;
         Statement statement=null;
         ResultSet resultSet=null;
         
         try
         {
             connection =DriverManager.getConnection(DATABASE_URL,"patils0011","1641943");
             statement =connection.createStatement();
             
             resultSet=statement.executeQuery("Select * from useraccount where User_Id = '" + User_Id + "'");
             if(resultSet.next())
             {
                 if(password.equals(resultSet.getString(3)))
                 {
                     System.out.println("Welcome to Friendsbook");
                      loginYes=true;
                     return(true);
                    
                     
                 }else
                 {
                     System.out.println("Incorrect Login details");
                     return(false);
                     
                     
                 }
             }else
             {
                  System.out.println("Incorrect Login details,"
                          + "Please enter correct User Id and Password,"
                          + "If you dont have one, Please Register ");
                 return(false);
             }
             
         }
         catch(SQLException e)
         {
             e.printStackTrace();
             return(false);
             
         }
         finally
         {
             try
             {
                 resultSet.close();
                 statement.close();
                 connection.close();
             }
             catch(Exception e)
             {
                 e.printStackTrace();
             }
         }
     }
   
}
