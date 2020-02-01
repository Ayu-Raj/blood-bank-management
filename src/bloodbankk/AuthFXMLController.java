/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import com.jfoenix.controls.JFXPasswordField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class AuthFXMLController implements Initializable {
    String pas;
    @FXML
    private JFXPasswordField pass;

    @FXML
    private Button auth;
     @FXML
    private Button forPass;

    @FXML
    void auth(ActionEvent event) {
        pas=pass.getText();
        if(pas.equals("heyayush")){
              try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PurchaseFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Purchase Blood");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
        }
        else{
         AlertBox.display("Result","Wrong Password");
        }
        pass.setText("");
    }

    @FXML
    void pass(ActionEvent event) {
        // pas=pass.getText();
       
    }
    
    @FXML
    void forPass(ActionEvent event) {
        HospSql.send("aditya.ayush123@gmail.com","password","ayushrajmathur@gmail.com","Forgot Blood Bank Password","Your blood bank Password is heyayush");
        AlertBox.display("Result","Plz Check your Mail for Password Details");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // @FXML
    
         
       
    
    }    
    
}
