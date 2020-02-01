/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class FXMLController implements Initializable {
    @FXML
    private MediaView media;
    @FXML
    private Button button;

    @FXML
    void buttononclick(ActionEvent event) {
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("firstFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Operations");
        stage.setScene(new Scene(root1)); 
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        MediaPlayer mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("video.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        media.setMediaPlayer(mediaPlayer);
    }    
    
}
