/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;
import static bloodbankk.NewHosFXMLController.emails;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author ayush
 */
public class HospSql {
    static int no;
    static String id;
    static void reg(){
    try{
    int x = 0;
    String preEmail;
    int flag=0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt1=conn.createStatement();  
    ResultSet rs1=stmt1.executeQuery("select * from hospital");  
    while(rs1.next()){  
    preEmail=rs1.getString(5); 
    if(preEmail.equals(NewHosFXMLController.emails))
        flag=1;
        }
    if(flag==1)
        AlertBox.display("Result","Email ID is already registered ");
    else{
        
          Random rand = new Random();
          id = String.format("%04d", rand.nextInt(10000));
         HospSql.send("aditya.ayush123@gmail.com","password",emails,"OTP for Blood Bank Regestration","Your OTP is "+id+". Please ignore the mail if you have not registered. Thanks");  
         HospSql obj= new HospSql();   
         obj.open();
             

        
        
    
    
            }
}catch(Exception e){ System.out.println(e);} 

}
   static void sendmail(){
        String pass;
        try{
            int flag=0;
            int id;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from hospital");  
    while(rs.next()){
        if(ForgorPassFXMLController.email.equals(rs.getString(5))){
             pass=rs.getString(4);
             id=rs.getInt(1);
           send("aditya.ayush123@gmail.com","password",ForgorPassFXMLController.email,"Forgot Blood Bank Password","Your blood bank password for Hospital ID "+id+" is "+pass);
           AlertBox.display("Result","Check your Mail for Password Details");
           flag=1;
           break;
        }
            }
    if(flag==0){
    AlertBox.display("Result","Mail not found");
    }
    
    }catch(Exception e){System.out.println(e);}
}
  static  void send(String from,String password,String to,String sub,String msg){  
          //Get properties object    
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
          //compose message    
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }
void open(){
try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("optFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Enter OTP");
       // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
}  
}
