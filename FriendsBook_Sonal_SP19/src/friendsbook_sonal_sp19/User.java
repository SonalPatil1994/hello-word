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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class User {
    String User_Id;
    String password;
    String gender;
    String name;
    String dob;
    String school;
    String newFriend;
    boolean isFriend=false;
    
     private ArrayList<UpdateAndPost> updates;
     private ArrayList<UpdateAndPost> update;
     private ArrayList<String> friends;
     private ArrayList<Register> profiles;
     private ArrayList<UpdateAndPost> posts;
     private List<String> postList;
     private ArrayList<Notification> notifications;
     private ArrayList<Notification> messages;
     private ArrayList<Comment> comments;
     private String post;
     private String profile;
     private List<String> profile_Post=new ArrayList<String>();
     private List<String> SelectedUpdateAndPost;
     private String comment;
     private String friend_Uid;
     private List<Login> selectedProfile;
     private boolean isThere;
     private ArrayList<String> fmessage;

    public String getNewFriend() {
        return newFriend;
    }

    public void setNewFriend(String newFriend) {
        this.newFriend = newFriend;
    }

    public ArrayList<UpdateAndPost> getUpdates() {
        return updates;
    }

    public void setUpdates(ArrayList<UpdateAndPost> updates) {
        this.updates = updates;
    }

   public ArrayList<UpdateAndPost> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<UpdateAndPost> posts) {
        this.posts = posts;
    }

    
    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification> notifications) {
        this.notifications = notifications;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

   
 public User(String User_Id, String  password) {
        this.User_Id = User_Id;
        this.password = password;
     
     updates=new ArrayList<UpdateAndPost>();
     update=new ArrayList<UpdateAndPost>();
     friends=new ArrayList<String>();
     profiles=new ArrayList<Register>();
     posts=new ArrayList<UpdateAndPost>();
     notifications=new ArrayList<Notification>();
     messages=new ArrayList<Notification>();
     comments=new ArrayList<Comment>();
     post="";
     profile="";
     comment="";
     friend_Uid="";
     isThere=false;
      }
 
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
     String selection = "";
     Scanner input=new Scanner(System.in);

    public void User_Menu()
     {
     while(!selection.equals("y"))
        {
            //show the menu
            System.out.println();
            System.out.println("a: Select an Update and Post");
            System.out.println("b: Check Notifications");
            System.out.println("c: Create a new post ");
            System.out.println("d: Friend List");
            System.out.println("e: Update Profile");
            System.out.println("f: Send a Message");
            System.out.println("g: Send a friend request");
            System.out.println("h: See Hashtag in trends");
            System.out.println("y: Logout");
  
            selection = input.nextLine();
            System.out.println();
                 if(selection.equals("a"))
                 {
                    UpdateAndPost_Method(User_Id);
                 }
                 else if(selection.equals("b"))
                 {
                    showNotif(User_Id);
     
                 }
                  else if(selection.equals("c"))
                 {
                       Post(User_Id);
                 }
                   else if(selection.equals("d"))
                 {
                     friendList_Method(User_Id);
                 }
                    else if(selection.equals("e"))
                 {
                     UpdateAndPost.updateProfile_Method( User_Id);
                   
                 }
                     else if(selection.equals("f"))
                 {
                    
                     sendMessage_Method();
                 }
                      else if(selection.equals("g"))
                 {
                      
                     friendRequest_Method();
                 }
                       else if(selection.equals("h"))
                 {
                     Hashtag hash=new Hashtag();
                     Hashtag.show_tag(User_Id);
                 }
                       
                     else if(selection.equals("y"))
                {
                    //go out
                    ;
                }
        }
     }
    
    public void displayUp_Method(String User_Id)
    {
        
         
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
             rs=st.executeQuery("Select * from updateandpost where User_Id!='"+User_Id+"' order by Up_Id desc limit 3" );
             
            
             while(rs.next())
             {
                  
                System.out.println("Update Id:"+rs.getInt(1)+",\n"+"User Id:"+rs.getString(2)+",\n"
                       +"Update Type:"+rs.getString(3)+",\n"+"Update Content:"+rs.getString(4)+",\n"
                       +"Comment Content:"+rs.getString(5)+"\n");
                  
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
      
    }
  
    
    
    public void UpdateAndPost_Method(String User_Id)
    {
        
     updates=new ArrayList<UpdateAndPost>();
     update=new ArrayList<UpdateAndPost>();
     friends=new ArrayList<String>();
     profiles=new ArrayList<Register>();
     posts=new ArrayList<UpdateAndPost>();
     notifications=new ArrayList<Notification>();
     messages=new ArrayList<Notification>();
     comments=new ArrayList<Comment>();
     post="";
     profile="";
     comment="";
     friend_Uid="";
     isThere=false;
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
             st =conn.createStatement();
             st1=conn.createStatement();
             rs=st.executeQuery("Select * from friends where User_Id='" +User_Id+"' or Friend_Id='"+User_Id+"'");
             int count=0;
             boolean found=false;
             while(rs.next())
          {
              if(User_Id.equals(rs.getString(1)))
              {
                  friends.add(rs.getString(2));
              }
              else if(User_Id.equals(rs.getString(2)))
              {
                   friends.add(rs.getString(1));
              }
          }
          
           rs = st.executeQuery("Select * from updateandpost order by Up_Id desc ");
           
            while(rs.next())
            {
                if(friends.contains(rs.getString(2)))
                  {
                     
                posts.add(new UpdateAndPost(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                System.out.println("Update Id:"+rs.getInt(1)+",\n"+"User Id:"+rs.getString(2)+",\n"
                       +"Update Type:"+rs.getString(3)+",\n"+"Update Content:"+rs.getString(4)+",\n"
                       +"Comment Content:"+rs.getString(5)+"\n");
                
                  }
               
            }
                System.out.println("Do you want to comment?");
            
                System.out.println("Enter the post number you want to comment for:");
                int postNum= input.nextInt();
                rs=st.executeQuery("Select * from comment where Up_Id='"+postNum+"'");
           
            while(rs.next()){
           
                 Comment com=new Comment(rs.getString("Up_Id"),rs.getString("User_Id"),rs.getString("Comment_Content"));
                 comments.add(com);
                 System.out.println(+rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3));
               
           }
                Comment.comment(postNum,User_Id);
           
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
  
     
     public void Post(String User_Id)
{
    
    int  Up_Id=0;
    String type;
    String up_content;
    String posttype;
    String commContent;
    Scanner input=new Scanner(System.in);
    System.out.println("Enter the Content of your post");
    up_content=input.nextLine();
    System.out.println("Enter the Comments ");
    commContent=input.nextLine();
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
         
         try
         {
             conn =DriverManager.getConnection(DATABASE_URL,"patils0011","1641943");
             st =conn.createStatement();
             
             rs=st.executeQuery("Select * from nextup_num");
          
          while(rs.next())
          {
              currentUpNum=rs.getInt(1);
             
          }
           nextUpNum= currentUpNum +1;
           st.executeUpdate("Insert into nextup_num values ('" + nextUpNum + "')");
           rs=st.executeQuery("Select * from useraccount where User_Id = '" + User_Id + "'");
           if(rs.next())
            {
                newcomment();
                st.executeUpdate("insert into updateandpost "
                   + "values ('"+ nextUpNum + "','" + User_Id +"','Post'"
                        + ",'" + up_content+ "','" + commContent+ "')");
                st.executeUpdate("insert into comment "
                   + "values ('"+ nextUpNum + "','" + User_Id +"','" + commContent+ "')");
                
                st.executeUpdate("update nextup_num set nextUp_Id = '" + nextUpNum + "'");
                System.out.println("Post Successfully Updated");
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
     public static void newcomment()
    {
        Scanner input=new Scanner(System.in);
        boolean found= false;
        System.out.print("Enter your Post Content or Comment with hashtags:\n");
        String cmnt=input.nextLine();
        if(cmnt.contains("#"))
        {
            int f=(cmnt.indexOf("#"));
            int l=0;
            for (int i = f; i < cmnt.length(); i++) 
            {
                if (Character.isWhitespace(cmnt.charAt(i))) 
                {
                    l=i;
                    found=true;
                    break;
                }
                else
                {
                    continue;
                }
            }
            if(found)
            {
                new_htag(cmnt.substring(f, l));
            }
            else
            {
                new_htag(cmnt.substring(f));
            } 
        }
        
    }
     
     public static void new_htag(String tag)
    {
        Scanner in=new Scanner(System.in);
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
        ArrayList <String> tags =new ArrayList<String>();
        Connection conn = null;
        ResultSet rs = null;
        Statement st = null;
        ResultSet rs1 = null;
        Statement st1 = null;
        try
        {
            conn = DriverManager.getConnection(DB_URL,"patils0011","1641943");
            st=conn.createStatement();
            rs = st.executeQuery("Select * from hashtag");
            st1=conn.createStatement();
            rs1 = st1.executeQuery("Select * from hashtag");
            while(rs.next())
            {
                tags.add(rs.getString(1));
            }
            if(tags.contains(tag))
            {
                while(rs1.next())
                {
                    int u = st.executeUpdate("Update hashtag set count = '" + (rs1.getInt(2)+1)+ "' where htag='"+tag+"'");
                }
            }
            else
            {
                int r = st.executeUpdate("insert into hashtag values ('"+tag+"','" +0+ "')");
                System.out.println("New Hashtag created!!!");
            }
        }
        catch(SQLException e)
        {
            System.out.println("Friend's Id not found!!Please Try Again!!");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                rs.close();
                st.close();
                conn.close();
                ;
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }     
    }


     public void friendRequest_Method()
     {
         String newFriend;
         boolean isFriend=false;
         int currentNotifNum=0;
         int nextNotifNum=0;
         
         
         friends = new ArrayList<String>();
         Scanner input=new Scanner(System.in);
         System.out.println("Enter the User Id of a person to whom you want to send a request:");
         newFriend=input.nextLine();
      
      try
    {
         Class.forName("com.mysql.jdbc.Driver");

   }
    catch(Exception e)
    {
        System.out.println("Error");
    }
      
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Statement st1=null;
        ResultSet rs1=null;
     try
        {
            final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
        
            conn=DriverManager.getConnection(DB_URL,"patils0011","1641943");
            st=conn.createStatement();
            rs=st.executeQuery("Select * from nextnotif_num");
           while(rs.next())
          {
              currentNotifNum=rs.getInt(1);
             
          }
           nextNotifNum= currentNotifNum +1;
           st.executeUpdate("Insert into nextnotif_num values ('" + nextNotifNum + "')");
           rs=st.executeQuery("Select * from useraccount where User_Id='"+newFriend+"'" );
           if(User_Id.equals(newFriend))
   {
       System.out.println("Cannot send Friend Request to Yourself");
   }
           if(rs.next())
           {
               if(friends.size()<=0)
               {
                   
                   st.executeUpdate("Insert into notification values ('"
                   +nextNotifNum+"','"+User_Id
                   +"','"+ newFriend
                   +"','Friend request','UnRead','You have a Friend Request','Friend Request')");
              
                   st.executeUpdate("update nextnotif_num set nextNotif_Id = '" + nextNotifNum + "'");
                   System.out.println("Your request has been sent");
               }
               else
               {
                    System.out.println("Cannot Send request");
               }
            
           }
        else
           {
                System.out.println("Doesn't exist");
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
    
      public void sendMessage_Method()
     {
      
         String message;
         boolean isFriend=false;
         int currentNotifNum=0;
         int nextNotifNum=0;
         
         
         friends = new ArrayList<String>();
         Scanner input=new Scanner(System.in);
         System.out.println("Enter the User Id of a person to whom you want to send a message:");
         newFriend=input.nextLine();
         System.out.println("Enter the message you want to send:");
         message=input.nextLine();
      
      try
    {
         Class.forName("com.mysql.jdbc.Driver");

   }
    catch(Exception e)
    {
        System.out.println("Error");
    }
      
       Connection conn=null;
       Statement st=null;
       ResultSet rs=null;
   
     try
        {
            final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
        
            conn=DriverManager.getConnection(DB_URL,"patils0011","1641943");
            st=conn.createStatement();
            rs=st.executeQuery("Select * from nextnotif_num");
          while(rs.next())
          {
                currentNotifNum=rs.getInt(1);
          }
                nextNotifNum= currentNotifNum +1;
          st.executeUpdate("Insert into nextnotif_num values ('" + nextNotifNum + "')");
          rs=st.executeQuery("Select * from friends where Friend_Id='"+newFriend+"'" );
          if(User_Id.equals(newFriend))
   {
       System.out.println("Cannot send Message to Yourself");
   }
           if(rs.next())
           {
               if(friends.size()>=0)
               { 
                   st.executeUpdate("Insert into notification values ('"
                   +nextNotifNum+"','"+User_Id
                   +"','"+ newFriend
                   +"','message','Unread','"+ message+"','Users Message')");
              
                   st.executeUpdate("update nextnotif_num set nextNotif_Id = '" + nextNotifNum + "'");
                   System.out.println("Your message has been sent");
                   
               }
               else
               {
                   
                   System.out.println("Cannot send message");
                  
               }
           }
        else
           {
                System.out.println("You cannot send a message to a friend with whom you are not friend");
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
     
      public void showNotif(String User_Id)
      {
          Count cnt=new Count();
          int notifCount=Count.Count_Num(User_Id);
          System.out.println("Here are the notifications:");
           System.out.println("You have got "+ notifCount +"notifications");
          System.out.println("1.Friend Requests");
          System.out.println("2.Messages");
          System.out.println("3.GoBack");
          
          String selection="";        
          
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
        while(!selection.equals("3"))
        {
           
            System.out.println();
            selection = input.nextLine();
            System.out.println();
        
       if(selection.equals("1"))
        {
            rs=st.executeQuery("Select * from notification where Notif_Type='Friend Request'and Receiver= '" + User_Id + "'");      
            System.out.println();
            System.out.printf("Hi" + User_Id +", You have got friend requests");
         
         while(!selection.equals("3") &&rs.next())
        {
            System.out.println();
            System.out.println("1f: Accept");
            System.out.println("2f: Deny");
            System.out.println("3: Go out");
            selection = input.nextLine();
            System.out.println();
                 if(selection.equals("1f"))
                 {
                accept(User_Id);
                 } else if(selection.equals("2f"))
                 {
                    deny(User_Id);
                    
                 } 
                 else if(selection.equals("3"))
                {
                //go out
                ;
                }
        }  
      
        }
       
        else if(selection.equals("2"))
                 {
            rs=st.executeQuery("Select * from notification where Notif_Type='message'and Receiver= '" + User_Id + "'");
            System.out.printf("Hi" + User_Id +", You have got a Message\n");
        while(!selection.equals("3") && rs.next())
        {
            
            System.out.println();
            System.out.println("1m: Rreply");
            System.out.println("2m: Deny");
            System.out.println("3: Go out");
            selection = input.nextLine();
            System.out.println();
                 if(selection.equals("1m"))
                 {
                     replyMessage_Method(User_Id);
                 } else if(selection.equals("2m"))
                 {
                     denyMessage_Method(User_Id);
                 } 
                     else if(selection.equals("3"))
                {
                    //go out
                    ;
                }
        }  
                           
     } else if(selection.equals("3"))
        {
            ;
        }
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
               // rs.close();
                
                }
                catch(Exception e)
                {
                e.printStackTrace();
               System.out.println("Error");
                
                }
                
                }

}

      
       public void accept(String User_Id)
{
    ArrayList<Notification> notifications;
    notifications=new ArrayList<Notification>();
    int  nextNotifNum=0;
    boolean isFriend=false;
 
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
    Statement st1= null;
    ResultSet rs1=null;
try{
    
    final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
    conn=DriverManager.getConnection(DB_URL,"patils0011","1641943");
    st=conn.createStatement();
    st1=conn.createStatement();
    rs=st.executeQuery("Select * from notification where Notif_Type='Friend Request'and Receiver= '" + User_Id + "'");
        System.out.println();
          if(rs.next() && rs.getString(5).equals("Accept"))
          {
              System.out.println("You are already friends");
          }         
          
          if(rs.next())
          {
               String newfriend=rs.getString(2);
               System.out.println("You have got a friend request from" + newfriend);
               st.executeUpdate("Update notification set Notif_Status='Accept' where Notif_Type='Friend request' and Notif_Status='UnRead'");
               st.executeUpdate("Insert into friends values ('"+ User_Id+"','"+ newfriend+"')");
               isFriend=true;
               System.out.println();
               System.out.println("You accepted the friend request");
          }
      else
          {
              System.out.println("You cannot accept request");
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
               //rs.close();
                
                }
                catch(Exception e)
                {
                e.printStackTrace();
                System.out.println("Error");
                }
                }

}
       
        public void deny(String User_Id)
{
     ArrayList<Notification> notifications;
    notifications=new ArrayList<Notification>();
    int  nextNotifNum=0;
 
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
    rs=st.executeQuery("Select * from notification where Notif_Type='Friend Request'and Receiver= '" + User_Id + "'");
      
          if(rs.next() && rs.getString(5).equals("Deny"))
          {
              System.out.println("You have already denied the friend request");
          } 
          if(rs.next())
          {
               String newfriend=rs.getString(2);
               System.out.println("You have got a friend request from" + newfriend);
               st.executeUpdate("Update notification set Notif_Status='Deny' where Notif_Type='Friend request' and Notif_Status='UnRead'");
               System.out.println();
               System.out.println("You rejected the friend request");
          }
           else
          {
              System.out.println("Error");
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

}
       
        
        public void replyMessage_Method(String User_Id)
{
      Scanner input=new Scanner(System.in);
      String reply;
     
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
        rs=st.executeQuery("Select * from notification where Notif_Type='message'and Receiver= '" + User_Id + "'");
         
        if(rs.next() && rs.getString(5).equals("Read"))
          {
              System.out.println("You have already read message");
          } 
          if(rs.next())
          {
           String newfriend=rs.getString(2);
           String msg_Content=rs.getString(6);
           System.out.println("You have got a message from" + newfriend);
           System.out.println("Message Content:\n" + msg_Content );
          
           System.out.println("Enter the Reply for the message:");
           reply=input.nextLine();
           System.out.println();
           
           st.executeUpdate("Update notification set Notif_Status='Read',Msg_Content='"+reply+"' where Notif_Type='message' and Notif_Status='UnRead'");
           System.out.println("Your message has been sent to " + newfriend);
       
          }
           else
          {
              System.out.println("You cannot send message");
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

}
       
        
         public void denyMessage_Method(String User_Id)
{
      Scanner input=new Scanner(System.in);
      boolean isReply=false;
     
     
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
    rs=st.executeQuery("Select * from notification where Notif_Type='message'and Receiver= '" + User_Id + "'");
    System.out.printf("Hi" + User_Id +", You have got a Message\n");
        if(rs.next() && rs.getString(5).equals("Read"))
          {
              System.out.println("You have already read message");
          } 
          if(rs.next())
          {
            String newfriend=rs.getString(2);
            String Notif_Content=rs.getString(6);
            System.out.println("You have got a message from" + newfriend);
            System.out.println("Message Content:\n" + Notif_Content );
            System.out.println();
            st.executeUpdate("Update notification set Notif_Status='Read',Msg_Content='denied message' where Notif_Type='message' and Notif_Status='UnRead'");
            System.out.println("You have rejected to send message to  " + newfriend);
          }
           else
          {
              System.out.println("Error");
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

}
       
         
public void friendList_Method(String User_Id)
           {
         boolean isFriend=false;
         String friendList="";
         friends = new ArrayList<String>();
         String friendProfile="";
         profiles=new ArrayList<Register>();
         Scanner input=new Scanner(System.in);
      try
    {
         Class.forName("com.mysql.jdbc.Driver");

   }
    catch(Exception e)
    {
        System.out.println("Error");
    }
      
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        Statement st1=null;
        ResultSet rs1=null;
     try
        {
        final String DB_URL="jdbc:mysql://mis-sql.uhcl.edu/patils0011";
        conn=DriverManager.getConnection(DB_URL,"patils0011","1641943");
        st=conn.createStatement();
        st1=conn.createStatement();
        rs=st.executeQuery("Select * from friends where User_Id='" +User_Id+"' or Friend_Id='"+User_Id+"'");
        rs1=st1.executeQuery("Select * from useraccount where User_Id='" +User_Id+"'");
        int seq=0;
            while(rs.next())
            {
                if(rs.getString(1).equals(User_Id))
                {
                    rs1 = st1.executeQuery("Select User_Id from useraccount Where User_Id ='"+rs.getString(2)+"'");
                    seq++;
                }
                else if(rs.getString(2).equals(User_Id))
                {
                    rs1 = st1.executeQuery("Select User_Id from useraccount Where User_Id  ='"+rs.getString(1)+"'");
                    seq++;
                }
                while(rs1.next())
                {
                    System.out.println(seq+". "+rs1.getString(1));
                }
            } 
            rs1=st1.executeQuery("Select * from useraccount");
            System.out.println("Select the Friend's User Id to look their profile:");
                 String uid=input.nextLine();
           while(rs1.next())
           {
                 if(rs1.getString(1).equals(uid))
                 {
                     
                  System.out.println("User Id:"+rs1.getString(1)+"\nName:"+rs1.getString(2)+"\nGender:"+rs1.getString(4)+"\nBirthday:"+rs1.getString(6)+"\nSchool:"+rs1.getString(5));
                 }
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
     }
           
}
