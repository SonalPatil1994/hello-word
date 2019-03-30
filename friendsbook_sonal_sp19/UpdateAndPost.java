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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class UpdateAndPost {
    
    int  Up_Id;
    String User_Id;
    String type;
    String up_content;
    String Comment_Content;
    

    public UpdateAndPost(int Up_Id, String User_Id, String type, String up_content, String Comment_Content) {
        this.Up_Id = Up_Id;
        this.User_Id = User_Id;
        this.type = type;
        this.up_content = up_content;
        this.Comment_Content=Comment_Content;
    }
 
     private ArrayList<UpdateAndPost> posts;
     private ArrayList<UpdateAndPost> updates;
 

    public int getUp_Id() {
        return Up_Id;
    }

    public void setUp_Id(int Up_Id) {
        this.Up_Id = Up_Id;
    }

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String User_Id) {
        this.User_Id = User_Id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUp_content() {
        return up_content;
    }

    public void setUp_content(String up_content) {
        this.up_content = up_content;
    }
    
    public static void updateProfile_Method(String id)
   {
       
        
        Scanner input=new Scanner(System.in);
    
        System.out.println("Enter the new name to be updated");
        String newName=input.nextLine();
        System.out.println("Enter the new School to be updated");
        String newSchool=input.nextLine();
        System.out.println("Enter the new birth date to be updated");
        String newDob=input.nextLine();
        int currentUpNum=0;
        int nextUpNum=0;
  
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
         Statement st1=null;
         ResultSet rs1=null;
         
         try
         {
         conn =DriverManager.getConnection(DATABASE_URL,"patils0011","1641943");
         st1 =conn.createStatement();
         st =conn.createStatement();
         rs1=st1.executeQuery("Select * from nextup_num");
          
          while(rs1.next())
          {
              currentUpNum=rs1.getInt(1);
             
          }
            nextUpNum= currentUpNum +1;
            st1.executeUpdate("Insert into nextup_num values ('" + nextUpNum + "')");
            rs=st.executeQuery("Select * from useraccount where User_Id ='" + id+"'");
            rs1=st1.executeQuery("Select * from updateandpost");
            if(rs.next())
            {
                    st.executeUpdate("Update useraccount set Name='"+ newName
                             +"', School='"+ newSchool
                             +"', dob='"+ newDob
                             +"' where User_Id='"+ id+"'");
                    st1.executeUpdate("insert into updateandpost "
                   + "values ('"+ nextUpNum + "','" + id  +"','Update','Updated Profile','Updated')");
          
                    st1.executeUpdate("update nextup_num set nextUp_Id = '" + nextUpNum + "'");
               
                    st1.executeUpdate("update nextup_num set nextUp_Id = '" + nextUpNum + "'");
                    System.out.println("Profile Successfully Updated");
            }
            else
            {

                    System.out.println("Cannot Update Post");
           
            }
      
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
                rs.close();
                
                }
                catch(Exception e)
                {
                e.printStackTrace();
                System.out.println("Error");
                }
                }
}
}


    
     