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

/**
 *
 * @author sonum
 */
public class Notification {
    int Notif_Id;
    String Sender;
    String Receiver;
    String Notif_Type;
    String Notif_Status;
    String Notif_Content;
    String Msg_Content;

   
    String nextNotifNum;
 //String User_Id;

   //friends fr=new friends();

    public Notification(int Notif_Id, String Sender, String Receiver, String Notif_Type, String Notif_Status, String Notif_Content,
            String Msg_Content) {
        this.Notif_Id = Notif_Id;
        this.Sender = Sender;
        this.Receiver = Receiver;
        this.Notif_Type = Notif_Type;
        this.Notif_Status = Notif_Status;
        this.Notif_Content = Notif_Content;
         this.Msg_Content = Msg_Content;
    }
   
   
    String num;
    int nNum;
    
 
    
    public List<String> notification_New;
    private ArrayList<Notification> notifications;
    private friends frnds;
   // friends = new ArrayList<String>();
    public int getNotif_Id() {
        return Notif_Id;
    }

    public void setNotif_Id(int Notif_Id) {
        this.Notif_Id = Notif_Id;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String Sender) {
        this.Sender = Sender;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }

    public String getNotif_Type() {
        return Notif_Type;
    }

    public void setNotif_Type(String Notif_Type) {
        this.Notif_Type = Notif_Type;
    }

    public String getNotif_Status() {
        return Notif_Status;
    }

    public void setNotif_Status(String Notif_Status) {
        this.Notif_Status = Notif_Status;
    }

    public String getNotif_Content() {
        return Notif_Content;
    }

    public void setNotif_Content(String Notif_Content) {
        this.Notif_Content = Notif_Content;
    }
     public String getNextNotifNum() {
        return nextNotifNum;
    }

    public void setNextNotifNum(String nextNotifNum) {
        this.nextNotifNum = nextNotifNum;
    }
   
}
