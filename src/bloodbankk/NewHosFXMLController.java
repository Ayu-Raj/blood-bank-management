/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import static java.lang.Math.random;
import java.net.URL;
import java.util.Random;
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
public class NewHosFXMLController implements Initializable {
    static String doc_name;
    static String hos_name;
    static String password;
    static String emails;
       
    @FXML
    private JFXTextField emailid;
       @FXML
    private JFXTextField h_name;

    @FXML
    private JFXTextField d_name;

    @FXML
    private JFXPasswordField pass;

    @FXML
    void d_name(ActionEvent event) {
       // doc_name=d_name.getText();
    }
    
    @FXML
    private Button sub_reg;
    
    @FXML
    void h_name(ActionEvent event) {
       // hos_name=h_name.getText();
    }

    @FXML
    void pass(ActionEvent event) {
      //  password=pass.getText();
    }
     @FXML
    void emailid(ActionEvent event) {
      //  emails=emailid.getText();
    }
    @FXML
    void sub_reg(ActionEvent event) {
        doc_name=d_name.getText();
        hos_name=h_name.getText();
         password=pass.getText();
         emails=emailid.getText();
      
         
        HospSql.reg();
        d_name.setText("");
        h_name.setText("");
        pass.setText("");
        emailid.setText("");
       
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
