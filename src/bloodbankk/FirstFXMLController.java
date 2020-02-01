/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class FirstFXMLController implements Initializable {
     @FXML
    private Button purchase;

    @FXML
    private Button donate;

    @FXML
    private Button viewdonor;

    @FXML
    private Button viewpurchase;

    @FXML
    private Button bgroup;
 
    @FXML
    void bgroupaction(ActionEvent event) {
          try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("BListFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Blood Availability Status");
        
        
        
        
        
        //stage.getIcons();
        // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }

    }

    @FXML
    void donateaction(ActionEvent event) {
         try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HospFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Hospital Login");
        stage.setScene(new Scene(root1)); 
        
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }

    }

    @FXML
    void purchaseaction(ActionEvent event) {
         try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AuthFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Authentication");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }

    @FXML
    void viewdonoraction(ActionEvent event) {
         try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DViewFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Donor List");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }

    @FXML
    void viewpurchaseaction(ActionEvent event) {
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PurViewFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Purchaser List");
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
    
}
