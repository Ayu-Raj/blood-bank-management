/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import static bloodbankk.HospSql.no;
import static bloodbankk.NewHosFXMLController.emails;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class OptFXMLController implements Initializable {
    static String ot;
    static int allow=0;
    int x;
       @FXML
    private JFXTextField otp;

    @FXML
    private Button subotp;

    @FXML
    void subotp(ActionEvent event) {
        ot=otp.getText();
        allow=1;
   HospSql ooo= new HospSql();
    String id= ooo.id;
    try{
         if(OptFXMLController.ot.equals(id)){
        
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from hospital");  
    while(rs.next())  
    x=rs.getInt(1); 
    Connection conn1=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt2=conn1.createStatement();
    x++;
    no=x;
    //System.out.println(x);
    
    //String sql = "INSERT INTO donor " +
      //             "VALUES ("+x+",'"+DonorFXMLController.x"',"+DonorFXMLController.age+");";
     String sql = "INSERT INTO `hospital`(h_id, h_name, d_name, password, email) VALUE ("+x+",'"+NewHosFXMLController.hos_name+"','"+NewHosFXMLController.doc_name+"','"+NewHosFXMLController.password+"','"+NewHosFXMLController.emails+"');";
      stmt2.executeUpdate(sql);
    
    con.close(); 
     AlertBox.display("Result","New hospital registered.\n Your Hospital Id is "+HospSql.no);
     HospSql.send("aditya.ayush123@gmail.com","password",emails,"Conformation mail","You have been sucessfully registered to your blood bank account. Your Blood Bank Account's Hospital Id is: "+HospSql.no); 
      }  
      else{
      AlertBox.display("Result","OTP did not matched, Try again with valid OTP ");
      
      }
    }catch(Exception e){
            System.out.println(e);}
    otp.setText("");
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
