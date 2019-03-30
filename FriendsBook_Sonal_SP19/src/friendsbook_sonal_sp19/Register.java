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
public class Register {
    
    String User_Id;
    String password;
    String gender;
    String name;
    String dob;
    String school;

    public Register(String User_Id, String name,String gender, String dob, String school) {
        this.User_Id = User_Id;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.school = school;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String Id) {
        this.User_Id = Id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return dob;
    }

    public void setBirthday(String dob) {
        this.dob = dob;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }


    public static String register_Method(String User_Id, String name, String password, String gender , String school, String dob)
    {
    
        String alphaId=".*[a-zA-Z].*";
        String numId=".*[0-9].*";
        String spId=".*[#?!*].*";
       
        if(User_Id==password)
        {
            System.out.println("Id and password must be different");
            return("Matching User Id and Password");
            
            
        }
       
       if((User_Id.matches(alphaId) && User_Id.matches(numId) && User_Id.matches(spId))==false)
        {
            System.out.println(" User Id must contain atleast 1 letter, 1 digit and 1 special character from {#,?,!,*}");
            return("Enter again");
        }
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
       }
       catch(Exception e)
       {
           System.out.println("This is an error");
           return("internalError");
       }
       
       Connection connection=null;
       Statement statement=null;
       ResultSet resultSet=null;
       
       
       try
       {
           final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
           
           connection = DriverManager.getConnection(DATABASE_URL,"patils0011","1641943");
           statement =connection.createStatement();
           
           resultSet=statement.executeQuery("Select * from useraccount where User_Id= '"+User_Id + "'");
           
           if(resultSet.next())
           {
               return("SQLNoRecords");
           }
           else
           {
               if(!User_Id.equals(password))
               {
                   int r= statement.executeUpdate("insert into useraccount "
                   + "values ('"+ User_Id + "','" + name +"','"+ password +"','" +gender+ "','"+ school+"','"+ dob+"')");
                   
                   System.out.println("Your Registration is Successful");
                   return("Registration Successful");
               }
               else
               {
                   return("Registration Failed");
               }
           }
           
           
       }
       catch(SQLException e)
       {
           e.printStackTrace();
           return("SQLError");
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
               return("InternalError");
           }
       }
    }
    
}
