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
public class Count {
static int  total=0;
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    Login log=new Login();
   
    public static int Count_Num(String User_Id)
    {
       Scanner input=new Scanner(System.in);
      
try
{
     Class.forName("com.mysql.jdbc.Driver");

}
catch(Exception e)
{
        System.out.println("Error,Please try it");
}

    
    Connection conn=null;
    Statement st= null;
    ResultSet rs=null;

try{
    
    final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
    conn=DriverManager.getConnection(DB_URL,"patils0011","1641943");
    st=conn.createStatement();
    rs=st.executeQuery("Select * from notification where Notif_Status='UnRead' and Receiver= '" + User_Id + "'");
          
          if(rs.next())
          {
           total++;
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
                }
                catch(Exception e)
                {
                e.printStackTrace();
                System.out.println("Error");
                }
                }
                 return total;
    }
    
}
