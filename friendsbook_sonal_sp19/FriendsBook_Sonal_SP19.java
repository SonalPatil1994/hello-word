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
public class FriendsBook_Sonal_SP19 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
         String User_Id;
    String password;
    String gender;
    String name;
    String dob;
    String school;
         Scanner input = new Scanner(System.in);
         Login newLogin=new Login();
         String selection = "";
        
        //while loop to display menu
        while(!selection.equals("x"))
        {
            //show the menu
            System.out.println();
            System.out.println("For Login Choose 1 & For creating a new Account Choose 2");
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("x: Finish the simulation");
            
            //get the input
            selection = input.nextLine();
            System.out.println();
            
            if(selection.equals("1"))
            {
               
            System.out.print("Enter User Id:");
            User_Id=input.nextLine();
     
            System.out.print("Enter Password:");
            password=input.nextLine();
    
            boolean res=newLogin.login_Method(User_Id,password);
            if(res==true)
   {
                User newUser=new User(User_Id,password);
                newUser.displayUp_Method(User_Id);
                newUser.User_Menu();
       
   }

            }
                else if(selection.equals("2"))
            {
                

            System.out.print("Enter User Id:");
            User_Id=input.nextLine();
            System.out.print("Enter Name:");
            name=input.nextLine();
            System.out.print("Enter Password:");
            password=input.nextLine();
    
            System.out.print("Enter Gender:");
            gender=input.nextLine();
            System.out.print("Enter school:");
            school=input.nextLine();
    
            System.out.print("Enter Birthday:");
            dob=input.nextLine();
                
   
            String output= Register.register_Method( User_Id,  name,  password,  gender ,  school,  dob);
 
            }
            else if(selection.equals("x"))
            {
                //go out
                ;
            }
            
        }
        
    }

}
