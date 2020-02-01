/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import com.jfoenix.transitions.JFXFillTransition;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class PurViewFXMLController implements Initializable {

    
    @FXML
    private AnchorPane anc;
    
    @FXML
    private TextField filterField;
    @FXML
    private TableView<ModelTable3> table;
    @FXML
    private TableColumn<ModelTable3, String> id_col;

    @FXML
    private TableColumn<ModelTable3, String> n_col;

    @FXML
    private TableColumn<ModelTable3, String> g_col;

    @FXML
    private TableColumn<ModelTable3, String> p_col;

    @FXML
    private TableColumn<ModelTable3, String> u_col;

    @FXML
    private TableColumn<ModelTable3, String> b_col;

    @FXML
    private TableColumn<ModelTable3, String> c_col;
     @FXML
    private TableColumn<ModelTable3, String> date;
     @FXML
    private Button search;

    @FXML
    void search(ActionEvent event) {
         try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PurchaserImageFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Purchaser Image Finder");
       // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
    /**
     * Initializes the controller class.
     */
    ObservableList<ModelTable3> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        try{
    
    //Class.forName("com.mysql.jdbc.Driver");
    Connection con=DBConnector.getConnecction();
    Statement stmt=con.createStatement();  
    
    ResultSet rs=stmt.executeQuery("select * from purchaser");  
    while(rs.next()){
        oblist.add(new ModelTable3(rs.getString("p_id"),rs.getString("p_name"),rs.getString("p_gender"),
                rs.getString("p_purpose"),rs.getString("p_units"),rs.getString("p_blood"),rs.getString("p_contact"),rs.getString("date")));
    }  
   con.close();  
}catch(Exception e){ System.out.println(e);} 
        
        id_col.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        n_col.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        g_col.setCellValueFactory(new PropertyValueFactory<>("p_gender"));
        p_col.setCellValueFactory(new PropertyValueFactory<>("p_purpose"));
        u_col.setCellValueFactory(new PropertyValueFactory<>("p_units"));
        b_col.setCellValueFactory(new PropertyValueFactory<>("p_blood"));
        c_col.setCellValueFactory(new PropertyValueFactory<>("p_contact"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        // TODO
       
           table.setItems(oblist);
           
             ObservableList data =  table.getItems();
filterField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                table.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<ModelTable3> subentries = FXCollections.observableArrayList();

            long count = table.getColumns().stream().count();
            for (int i = 0; i < table.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + table.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(table.getItems().get(i));
                        break;
                    }
                }
            }
            table.setItems(subentries);
        });
    }    
        
    
}
