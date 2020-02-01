/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author ayush
 */
public class PurSql implements Printable{
    static int webid;
    static int ok=0;
    static int xx;
    static String datep;
    static void demo2(){
    try{
        int flag=0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from available");  
    while(rs.next()){ 
    if(PurchaseFXMLController.bgrp.equals(rs.getString(1)) && PurchaseFXMLController.unitreq<=(rs.getFloat(2))){
        purchase();
      ok=1;
     
     flag=0;
     break;
    }
    flag=1;
   }
    if(flag==1){
    AlertBox.display("Result","Blood Not Available");
    }
    /*
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt1=conn.createStatement();
    x++;
    System.out.println(x);
    
 
     String sql = "INSERT INTO `donor`(d_id,do_name,d_gender,d_age,d_contact, d_blood, d_units, h_id, h_name ) VALUE ("+x+",'"+DonorFXMLController.name+"','"+DonorFXMLController.gender+"',"+DonorFXMLController.age+","+DonorFXMLController.contact+",'"+DonorFXMLController.b_group+"',"+DonorFXMLController.units+","+HospFXMLController.h_id_to_pass+",'"+HospFXMLController.h_name_to_pass+"');";
      stmt1.executeUpdate(sql);
    ResultSet rs1=stmt.executeQuery("select * from donor");  
    */
    con.close();  
}catch(Exception e){ System.out.println(e);} 

}
    static void purchase(){
        
        try{
            float x=0;
           int  i=0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from available");  
    while(rs.next()){
        if(PurchaseFXMLController.bgrp.equals(rs.getString(1)))
        x=rs.getFloat(2);
    }
    double y=x-PurchaseFXMLController.unitreq;
     String sql= "UPDATE available SET available="+y+" WHERE d_blood='"+PurchaseFXMLController.bgrp+"';";
    stmt.executeUpdate(sql);
       Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt1=conn.createStatement();  
    ResultSet rs1=stmt1.executeQuery("select * from purchaser");  
    while(rs1.next())
        i=rs1.getInt(1);
    i++;
    xx=i;
    webid=i;
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Calendar calobj = Calendar.getInstance();
    String dt=(df.format(calobj.getTime()));
    datep=dt;
     String sqll = "INSERT INTO `purchaser`(p_id,p_name,p_gender,p_purpose,p_units, p_blood, p_contact, date) VALUE ("+i+",'"+PurchaseFXMLController.pname+"','"+PurchaseFXMLController.pgender+"','"+PurchaseFXMLController.purpose+"',"+PurchaseFXMLController.unitreq+",'"+PurchaseFXMLController.bgrp+"',"+PurchaseFXMLController.pcon+",'"+dt+"');";
    stmt1.executeUpdate(sqll);
    }catch(Exception e){ System.out.println(e);} 
    }
    
     static void callprint(){
   if(PurchaseFXMLController.ptr.equals("Print Receipt")){
      PurSql ob= new PurSql();
    ob.printt();}
  }
     void printt(){
 try{
          PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable((Printable) this);
         boolean ok = job.printDialog();
         //PrintDonor pt = new PrintDonor();
         if (ok) {
             try {
                job.print();
             } catch (PrinterException ex) {
              /* The job did not successfully complete */
             }
         }
    }catch(Exception e){
    System.out.println(e);}
}
public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
 
        /* Now we perform our rendering */
        g.drawString("Blood Receiver Receipt", 200, 100);
        g.drawString("Date and Time: "+PurSql.datep, 350, 100);
        g.drawString("Purchaser Id:  "+PurSql.xx,100,150);
        g.drawString("Donor Name: "+PurchaseFXMLController.pname,100,200);
        g.drawString("Gender: "+PurchaseFXMLController.pgender, 100, 250);
        g.drawString("Contact Numbeer: "+PurchaseFXMLController.pcon,100, 300);
        g.drawString("Unit Required: "+PurchaseFXMLController.unitreq, 100, 350);
        g.drawString("Purpose of Purchasing: "+PurchaseFXMLController.purpose, 100, 400);
        g.drawString("Blood Group: "+PurchaseFXMLController.bgrp, 100, 450);
        g.drawString("Stay Safe", 100, 520);
        g.draw3DRect(20, 20, 548, 700, true);
        File f = new File("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\picPur\\"+PurSql.xx+".png");
        BufferedImage img;        
        try {
            img = ImageIO.read(f);
            g.drawImage(img, 350,150, null);
        } catch (IOException ex) {
            Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
//Image img = new Image("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\pics\\"+MysqlCon.x+".png");
        //Image mainiamge = SwingFXUtils.toFXImage(img, null);
        
        
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
   
}
