/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
public class ForgorPassFXMLController implements Initializable {
    static String email;  
    @FXML
    private JFXTextField mail;

    @FXML
    private JFXButton mailSub;

    @FXML
    void mail(ActionEvent event) {
        //email=mail.getText();
    }

    @FXML
    void mailSub(ActionEvent event) {
        email=mail.getText();
        HospSql.sendmail();
        mail.setText("");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
