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
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
/**
 *
 * @author ayush
 */
public class MysqlCon implements Printable {
    static int webid;
    static int ok=0;
   static int x;
   static String datep;
   static void demo(){
    try{
        if(DonorFXMLController.disease.equals("Yes")||DonorFXMLController.weight.equals("No")){
         AlertBox.display("Result","Donor not fit to donate blood.");
        }
        else{   
     ok=1;
     x = 0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from donor");  
    while(rs.next())  
    x=rs.getInt(1); 
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt1=conn.createStatement();
    x++;
    webid=x;
    //System.out.println(x);
    DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Calendar calobj = Calendar.getInstance();
    String dt=(df.format(calobj.getTime()));
    datep=dt;
    String sql = "INSERT INTO `donor`(d_id,do_name,d_gender,d_age,d_contact, d_blood, d_units, h_id, h_name, date ) VALUE ("+x+",'"+DonorFXMLController.name+"','"+DonorFXMLController.gender+"',"+DonorFXMLController.age+","+DonorFXMLController.contact+",'"+DonorFXMLController.b_group+"',"+DonorFXMLController.units+","+HospFXMLController.h_id_to_pass+",'"+HospFXMLController.h_name_to_pass+"','"+dt+"');";
    stmt1.executeUpdate(sql);
    //ResultSet rs1=stmt.executeQuery("select * from donor");  
    con.close();  
    
    
    update();
 
         }
}catch(Exception e){ System.out.println(e);} 

}
  static void callprint(){
   if(DonorFXMLController.ptr.equals("Print Receipt")){
      MysqlCon ob= new MysqlCon();
    ob.printt();}
   System.out.println("Executed");
  }
static void update(){
     try{
    float x = 0 ;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from available"); 
    while(rs.next()){
    if(DonorFXMLController.b_group.equals(rs.getString(1)))
        x=rs.getFloat(2);
    }
    float y = x + DonorFXMLController.units;
    System.out.println(y);
    String sql= "UPDATE available SET available="+y+" WHERE d_blood='"+DonorFXMLController.b_group+"';";
    stmt.executeUpdate(sql);
    System.out.println(y);
     }catch(Exception e){System.out.println(e);}
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
        g.drawString("Donor Receipt", 200, 100);
        g.drawString("Date and Time: "+MysqlCon.datep, 350, 100);
        g.drawString("Donor Id:  "+MysqlCon.x,100,150);
        g.drawString("Donor Name: "+DonorFXMLController.name,100,200);
        g.drawString("Gender: "+DonorFXMLController.gender, 100, 250);
        g.drawString("Age: "+DonorFXMLController.age,100, 300);
        g.drawString("Contact Number: "+DonorFXMLController.contact, 100, 350);
        g.drawString("Number of units donated: "+DonorFXMLController.units, 100, 400);
        g.drawString("Blood Group: "+DonorFXMLController.b_group, 100, 450);
        g.drawString("Hospital Name: "+HospFXMLController.h_name_to_pass, 100, 500);
        g.drawString("Drink extra fluids for next day or two.",100,550);
        g.drawString("Avoid strenuous physical activity or heavy lifting for next five hours.", 100, 570);
        g.drawString("If you feel lighheaded, lie down with your feet up until the feeling passes.", 100, 590);
        g.drawString("Keep the bandage on your arm and dry for five hours",100,610);
        g.drawString("Thanks for donating blood.",100,650);
        g.draw3DRect(20, 20, 548, 700, true);
        File f = new File("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\pics\\"+MysqlCon.x+".png");
        BufferedImage img;        
        try {
            img = ImageIO.read(f);
            g.drawImage(img, 350,150,null);
        } catch (IOException ex) {
            Logger.getLogger(MysqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
//Image img = new Image("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\pics\\"+MysqlCon.x+".png");
        //Image mainiamge = SwingFXUtils.toFXImage(img, null);
        
        
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}



