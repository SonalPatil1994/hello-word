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
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class Hashtag {
    String htag;
    int cnt;
    
    public static void show_tag(String id){
        
        //User u=new User();
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
        Connection conn = null;
        ArrayList <String> friends =new ArrayList<String>();
        Scanner in=new Scanner(System.in);
        Statement st = null;
        ResultSet rs= null;
        ResultSet rs1 = null;
        Statement st1 = null;
        ResultSet rs2 = null;
        Statement st2 = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL,"patils0011","1641943");
            st = conn.createStatement();
            st1 = conn.createStatement();
            st2 = conn.createStatement();
            rs = st.executeQuery("Select * from hashtag order by count desc limit 3");
            rs1 = st1.executeQuery("Select * from updateandpost where type='Post'");
            int seq=0,se=0;
            boolean empty=true;
            while(rs.next())
            {
                seq++;
                System.out.println(seq+". "+rs.getString(1));
                empty=false;
            }
            if(empty)
            {
                System.out.println("No hashtags in trend");
            }
            System.out.println("Enter the tag you want to explore or press 'y' to go back");
            String tag=in.next();
            if(tag.equals("y"))
            {
                   ; 
            }
            else
            {
                rs=st.executeQuery("Select * from friends Where User_Id='"+id+"' or Friend_Id='"+id+"'");
                while(rs.next()){
                    if(rs.getString(1).equals(id)){
                        friends.add(rs.getString(2));
                    }
                    else if(rs.getString(2).equals(id)){
                        friends.add(rs.getString(1));
                    }
                }
                while(rs1.next())
                {
                    if(rs1.getString(4).contains(tag)&&friends.contains(rs1.getString(3)))
                    {
                        rs2 = st2.executeQuery("Select Up_Id, up_content from updateandpost Where Up_Id ='"+rs1.getString(1)+"'");
                        
                    }
                    if(rs2!=null)
                    {
                       while(rs2.next())
                        {
                            se++;
                            System.out.println(se+". "+rs2.getString(1)+": "+rs2.getString(2));
                        }  
                    } 
                }
            }
            
            
        }
        catch(SQLException e)
        {
            System.out.println("Error");
            System.out.println("Please try again");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                st.close();
                rs1.close();
                st1.close();
                conn.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}


