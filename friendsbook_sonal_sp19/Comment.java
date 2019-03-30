/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendsbook_sonal_sp19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class Comment {
    String User_Id;
    String Up_Id;
    String Comment_Content;

    public Comment(String User_Id, String Up_Id, String Comment_Content) {
        this.User_Id = User_Id;
        this.Up_Id = Up_Id;
        this.Comment_Content = Comment_Content;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String User_Id) {
        this.User_Id = User_Id;
    }

    public String getUp_Id() {
        return Up_Id;
    }

    public void setUp_Id(String Up_Id) {
        this.Up_Id = Up_Id;
    }

    public String getComment_Content() {
        return Comment_Content;
    }

    public void setComment_Content(String Comment_Content) {
        this.Comment_Content = Comment_Content;
    }
    public static void comment(int upid, String uid){
    
    Scanner input=new Scanner(System.in);
   
  
    
     try{
             Class.forName("com.mysql.jdbc.Driver");
             
         }
         catch(Exception e)
         {
               System.out.println("Error");
         }
         
         final String DATABASE_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
         Connection conn=null;
         Statement st=null;
         ResultSet rs=null;
         
         try
         {
             conn =DriverManager.getConnection(DATABASE_URL,"patils0011","1641943");
             st =conn.createStatement();
             System.out.println("Enter your comment:");
             String yourComm=input.nextLine();
             st.executeUpdate("insert into comment "
             + "values ('"+ upid + "','" + uid +"','" + yourComm+ "')");
         }
           catch(Exception e)
                {
                e.printStackTrace();
                System.out.println("Error");
               
                }
         finally
     {
                try
                {
                conn.close();
                st.close();
               }
                catch(Exception e)
                {
                e.printStackTrace();
                System.out.println("Error");
                 }
     }
    }
}
