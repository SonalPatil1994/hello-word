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
import java.util.Scanner;

/**
 *
 * @author sonum
 */
public class friends {

    public friends() {
    }

    public friends(String ourId) {
        this.ourId = ourId;
     
    }
    
    String ourId;
    String acceptor;
   
   private ArrayList<String> frnds;
    public String getourId() {
        return ourId;
    }

    public void setourId(String ourId) {
        this.ourId = ourId;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }
  
}




     
     



