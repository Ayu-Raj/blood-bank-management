/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import static javafx.application.Application.launch;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.Icon;

/**
 *
 * @author Imran
 */
public class Bloodbankk extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Welcome To BBMS");
       // Image img = new Image("bicon.jpg");
      //  stage.getIcons().add(new Image("C:\\Users\\ayush\\Documents\\NetBeansProjects\\Bloodbankk\\src\\bloodbankk\\uu.png"));
        
        
        stage.setScene(scene);
        stage.show();
    }
        @FXML
    private Button start;
       @FXML
    void buttononclick(ActionEvent event) {
       try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("firstFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage();
       // stage.setTitle("Operations");
        stage.setScene(new Scene(root1)); 
        stage.setTitle("Operations");
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            launch(args);
        // TODO code application logic here
       //MysqlCon.demo();
    }
    
}
