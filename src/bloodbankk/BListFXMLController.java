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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
public class BListFXMLController implements Initializable {
   @FXML 
   private TableView<ModelTable2> table;
    @FXML
    private TableColumn<ModelTable2, String> b_col;

    @FXML
    private TableColumn<ModelTable2, String> u_col;
    ObservableList<ModelTable2> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    try{
    
    //Class.forName("com.mysql.jdbc.Driver");
    Connection con=DBConnector.getConnecction();
    Statement stmt=con.createStatement();  
    
    ResultSet rs=stmt.executeQuery("select * from available");  
    while(rs.next()){
        oblist.add(new ModelTable2(rs.getString("d_blood"),rs.getString("available")));
    }  
   con.close();  
}catch(Exception e){ System.out.println(e);} 
       // System.out.println("df");
        b_col.setCellValueFactory(new PropertyValueFactory<>("d_blood"));
        u_col.setCellValueFactory(new PropertyValueFactory<>("available"));
        table.setItems(oblist);
    }    
    
}
