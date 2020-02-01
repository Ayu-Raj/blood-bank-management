/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class DonorFXMLController implements Initializable {
   
    static String name;
    static String gender;
    static int age;
    static long contact;
    static String b_group;
    static int units;
    static String weight="No";
    static String disease="No";
    static String ptr="no";
       @FXML
     private Label lab;
    @FXML
    private JFXToggleButton pt;
    @FXML
    private JFXTextField namefield;

    @FXML
    private JFXTextField agefield;

    @FXML
    private JFXTextField contactfield;

    
    @FXML
    private JFXSlider d_units;

    @FXML
    private JFXRadioButton genM;

    @FXML
    private JFXRadioButton genF;

   

   
    @FXML
    private JFXToggleButton we_yes;

    @FXML
    private JFXToggleButton di_yes;

    

    @FXML
    private RadioButton Apos;

    @FXML
    private RadioButton Bpos;

    @FXML
    private RadioButton Aneg;

    @FXML
    private RadioButton Bneg;

    @FXML
    private RadioButton Opos;

    @FXML
    private RadioButton Oneg;

    @FXML
    private RadioButton ABpos;

    @FXML
    private RadioButton ABneg;

    @FXML
    private JFXButton submit;

    @FXML
   private TextField hos_name;
   @FXML
    void pt(ActionEvent event) {
       // ptr=pt.getText();
    }
    @FXML
    void ABneg(ActionEvent event) {
        b_group=ABneg.getText();
    }

    @FXML
    void ABpos(ActionEvent event) {
         b_group=ABpos.getText();
    }

    @FXML
    void Aneg(ActionEvent event) {
         b_group=Aneg.getText();
    }

    @FXML
    void Apos(ActionEvent event) {
         b_group=Apos.getText();
    }

    @FXML
    void Bneg(ActionEvent event) {
         b_group=Bneg.getText();
    }

    @FXML
    void Bpos(ActionEvent event) {
         b_group=Bpos.getText();
    }

    @FXML
    void Oneg(ActionEvent event) {
         b_group=Oneg.getText();
    }

    @FXML
    void Opos(ActionEvent event) {
         b_group=Opos.getText();
    }

    @FXML
    void agefieldaction(ActionEvent event) {
        //age=Integer.parseInt(agefield.getText());
    }

    @FXML
    void contactfieldaction(ActionEvent event) {
        //contact=Long.parseLong(contactfield.getText());
    }

    @FXML
    void d_units(ActionEvent event) {
        //units=Integer.parseInt(d_units.getText());
    }

    @FXML
    void di_no(ActionEvent event) {
        //disease=di_no.getText();
    }

    @FXML
    void di_yes(ActionEvent event) {
        //disease=di_yes.getText();
    }

    @FXML
    void genF(ActionEvent event) {
        gender=genF.getText();
    }

    @FXML
    void genM(ActionEvent event) {
        gender=genM.getText();
    }

    @FXML
    void hos_name(ActionEvent event) {
        
        hos_name.setText(HospFXMLController.h_name_to_pass);
    }

    @FXML
    void namefieldaction(ActionEvent event) {
       // name=namefield.getText();
    }

    @FXML
    void submitaction(ActionEvent event) {
        
        CheckPhNo ch= new CheckPhNo();
        contact=Long.parseLong(contactfield.getText());
        age=Integer.parseInt(agefield.getText());
        if(ch.checkPh(contact)==0)
              AlertBox.display("Result","Enter 10 digit mobile number!!");
        
        
        else if(age<18)
         AlertBox.display("Result","Age should be 18 and above!!");
        else{
         name=namefield.getText();
           //units=Integer.parseInt(d_units.getText());
           units=(int)(d_units.getValue());
           if(pt.isSelected())
               ptr="Print Receipt";
           else ptr="No";
           if(di_yes.isSelected())
               disease="Yes";
           else disease="No";
           if(we_yes.isSelected())
               weight="Yes";
           else weight="No";
          MysqlCon.demo();
          if(MysqlCon.ok==1){
          try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WebCamPreview.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Donor Pic");
       // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();
          }catch(IOException e){
            System.out.println("Cant open new window");
        }
          }
          
          
       reset();
        }
       
    }

    @FXML
    void we_no(ActionEvent event) {
        //weight=we_no.getText();
    }

    @FXML
    void we_yes(ActionEvent event) {
       // weight=we_yes.getText();
    }
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tg = new ToggleGroup();
        Apos.setToggleGroup(tg);
        Aneg.setToggleGroup(tg);
        Bpos.setToggleGroup(tg);
        Bneg.setToggleGroup(tg);
        Opos.setToggleGroup(tg);
        Oneg.setToggleGroup(tg);
        ABpos.setToggleGroup(tg);
        ABneg.setToggleGroup(tg);
        ToggleGroup tg1 = new ToggleGroup();
        genF.setToggleGroup(tg1);
        genM.setToggleGroup(tg1);
        ToggleGroup tg2 = new ToggleGroup();
        di_yes.setToggleGroup(tg2);
        //di_no.setToggleGroup(tg2);
        ToggleGroup tg3 = new ToggleGroup();
               //we_no.setToggleGroup(tg3);  
                we_yes.setToggleGroup(tg3);
       lab.setText(HospFXMLController.h_name_to_pass);
       MysqlCon.ok=0;
    }    
  void reset(){
  namefield.setText("");
          agefield.setText("");
          contactfield.setText("");
         // d_units.setText("");
          genM.setSelected(false);
          genF.setSelected(false);
          Apos.setSelected(false);
          Aneg.setSelected(false);
          Bpos.setSelected(false);
          Bneg.setSelected(false);
          Opos.setSelected(false);
          Oneg.setSelected(false);
          ABpos.setSelected(false);
          ABneg.setSelected(false);
          we_yes.setSelected(false);
          di_yes.setSelected(false);
          pt.setSelected(false);
  }  
}
