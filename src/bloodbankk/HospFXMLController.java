/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class HospFXMLController implements Initializable {
    static int h_id_login;
    static String h_pass;
    static String h_name_to_pass;
    static int h_id_to_pass;
    
    
 
    
    @FXML
    private Button forPass;
   
    @FXML
    private Button forgot;
    @FXML
    private Button hosLogin;

    @FXML
    private Button hosReg;
    @FXML
    private JFXTextField h_id_log;

    @FXML
    private JFXPasswordField h_password;

    
    
       @FXML
    void h_id_log(ActionEvent event) {
       // h_id_login=Integer.parseInt(h_id_log.getText());
    }

    @FXML
    void h_password(ActionEvent event) {
       // h_pass=h_password.getText();
    }
    @FXML
    void hosLogin(ActionEvent event) {
        h_id_login=Integer.parseInt(h_id_log.getText());
         h_pass=h_password.getText();
        if(check()){
         try{
             

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonorFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Donor Form");
        stage.setScene(new Scene(root1));
        
        stage.show();
        
         }catch(IOException e){
            System.out.println("Cant open new window");
        }
         
        }
        else
            AlertBox.display("Result","Incorrect ID or Password ");
        h_id_log.setText("");
        h_password.setText("");
    }

    @FXML
    void hosReg(ActionEvent event) {
 try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewHosFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Hospital Registration");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
      @FXML
    void forgot(ActionEvent event) {
try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hosShow.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Forgot Id");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
       @FXML
    void forPass(ActionEvent event) {
try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ForgorPassFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Forgot Password");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }   
    boolean check(){
    try{
   // int x = 0;
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from hospital");  
   
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","root","ayush123");
    Statement stmt1=conn.createStatement();
 
    ResultSet rs1=stmt.executeQuery("select * from hospital");  
    while(rs1.next()) { 
       if((h_id_login==(rs1.getInt(1)))&&(h_pass.equals(rs1.getString(4)))){
           h_name_to_pass=rs1.getString(2);
           h_id_to_pass=Integer.parseInt(rs1.getString(1));
           return true;
       }
    System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+" "+rs1.getString(4));  
    }
    con.close();  
    
}catch(Exception e){ System.out.println(e);} 
    return false;
    }
}
