/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class HosShowController implements Initializable {
    @FXML
    private TextField filterField;
    @FXML
    private TableView<ModelTable4> table;

    @FXML
    private TableColumn<ModelTable4, String> hid_col;

    @FXML
    private TableColumn<ModelTable4, String> hname_col;
    /**
     * Initializes the controller class.
     */
    ObservableList<ModelTable4> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
    
    //Class.forName("com.mysql.jdbc.Driver");
    Connection con=DBConnector.getConnecction();
    Statement stmt=con.createStatement();  
    
    ResultSet rs=stmt.executeQuery("select * from hospital");  
    while(rs.next()){
        oblist.add(new ModelTable4(rs.getString("h_id"),rs.getString("h_name")));
    }  
   con.close();  
}catch(Exception e){ System.out.println(e);} 
        
        hid_col.setCellValueFactory(new PropertyValueFactory<>("h_id"));
        hname_col.setCellValueFactory(new PropertyValueFactory<>("h_name"));
         table.setItems(oblist);
         
         
             ObservableList data =  table.getItems();
filterField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                table.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<ModelTable4> subentries = FXCollections.observableArrayList();

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
