/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import static bloodbankk.HospSql.no;
import java.io.IOException;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class DViewFXMLController implements Initializable {
    
    
    @FXML
    private TextField filterField;
    
    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> id;

    @FXML
    private TableColumn<ModelTable, String> name;

    @FXML
    private TableColumn<ModelTable, String> gender;

    @FXML
    private TableColumn<ModelTable, String> age;

    @FXML
    private TableColumn<ModelTable, String> no;

    @FXML
    private TableColumn<ModelTable, String> bg;

    @FXML
    private TableColumn<ModelTable, String> unit;

    @FXML
    private TableColumn<ModelTable, String> hid;

    @FXML
    private TableColumn<ModelTable, String> hname;
    
    @FXML
    private TableColumn<ModelTable, String> date;
    
    @FXML
    private Button search;
        @FXML
    void search(ActionEvent event) {
              try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DonorImageFXML.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Donor Image Finder");
       // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
    }
    /**
     * Initializes the controller class.
     */
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
 try{
    
    //Class.forName("com.mysql.jdbc.Driver");
    Connection con=DBConnector.getConnecction();
    Statement stmt=con.createStatement();  
    
    ResultSet rs=stmt.executeQuery("select * from donor");  
    while(rs.next()){
        oblist.add(new ModelTable(rs.getString("d_id"),rs.getString("do_name"),rs.getString("d_gender"),
                rs.getString("d_age"),rs.getString("d_contact"),rs.getString("d_blood"),rs.getString("d_units"),rs.getString("h_id"),rs.getString("h_name"),rs.getString("date")));
    }  
   con.close();  
}catch(Exception e){ System.out.println(e);} 
        System.out.println("df");
        id.setCellValueFactory(new PropertyValueFactory<>("d_id"));
        name.setCellValueFactory(new PropertyValueFactory<>("do_name"));
        gender.setCellValueFactory(new PropertyValueFactory<>("d_gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("d_age"));
        no.setCellValueFactory(new PropertyValueFactory<>("d_contact"));
        bg.setCellValueFactory(new PropertyValueFactory<>("d_blood"));
        unit.setCellValueFactory(new PropertyValueFactory<>("d_units"));
        hid.setCellValueFactory(new PropertyValueFactory<>("h_id"));
        hname.setCellValueFactory(new PropertyValueFactory<>("h_name"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        // TODO
       
           table.setItems(oblist);

        ObservableList data =  table.getItems();
filterField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                table.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<ModelTable> subentries = FXCollections.observableArrayList();

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
