/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import static bloodbankk.DonorImageFXMLController.x;
import com.jfoenix.transitions.JFXFillTransition;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class PurchaserImageFXMLController implements Initializable {
    static int x;   
    
    @FXML
    private AnchorPane anc;

    @FXML
    private TextField did;

    @FXML
    private Button find;

    @FXML
    private ImageView imgview;

    @FXML
    void find(ActionEvent event) {
    x =Integer.parseInt(did.getText());
        try{
        FileInputStream input = new FileInputStream("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\picPur\\"+x+".png");
        Image image = new Image(input);
        imgview.setImage(image);
        }catch(Exception e){
        System.out.println(e);
        AlertBox.display("Result","Image not found");}
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JFXFillTransition transition = new JFXFillTransition();
        transition.setDuration(Duration.millis(5000));
        transition.setRegion(anc);
        transition.setFromValue(javafx.scene.paint.Color.WHITE);
        transition.setToValue(javafx.scene.paint.Color.SANDYBROWN);
        transition.play();
    }    
    
}
