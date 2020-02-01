/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import static bloodbankk.DonorFXMLController.ptr;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
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
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ayush
 */
public class PurchaseFXMLController implements Initializable {
    static String pname;
    static String pgender;
    static String purpose;
    static long pcon;
    static double unitreq;
    static String bgrp;
    static String ptr="no";
    
    @FXML
    private JFXSpinner spin;

    
    @FXML
    private JFXTextField p_name;

    @FXML
    private JFXTextField p_pur;

    @FXML
    private JFXTextField p_cont;

    @FXML
    private RadioButton apos;

    @FXML
    private RadioButton bpos;

    @FXML
    private RadioButton aneg;

    @FXML
    private RadioButton bneg;

    @FXML
    private RadioButton opos;

    @FXML
    private RadioButton oneg;

    @FXML
    private RadioButton abpos;

    @FXML
    private RadioButton abneg;

    @FXML
    private JFXRadioButton p_m;

    @FXML
    private JFXRadioButton p_f;

    @FXML
    private JFXSlider p_unit;


    @FXML
    private JFXButton sub;
   
     @FXML
    private JFXToggleButton pt;
     @FXML
    void pt(ActionEvent event) {
        //ptr=pt.getText();
    }

    @FXML
    void abneg(ActionEvent event) {
        bgrp=abneg.getText();
    }

    @FXML
    void abpos(ActionEvent event) {
        bgrp=abpos.getText();
    }

    @FXML
    void aneg(ActionEvent event) {
        bgrp=aneg.getText();
    }

    @FXML
    void apos(ActionEvent event) {
        bgrp=apos.getText();
    }

    @FXML
    void bneg(ActionEvent event) {
        bgrp=bneg.getText();
    }

    @FXML
    void bpos(ActionEvent event) {
        bgrp=bpos.getText();
    }

    @FXML
    void oneg(ActionEvent event) {
        bgrp=oneg.getText();
    }

    @FXML
    void opos(ActionEvent event) {
        bgrp=opos.getText();
    }

    @FXML
    void p_cont(ActionEvent event) {
    //  pcon=Long.parseLong(p_cont.getText());
    }

    @FXML
    void p_f(ActionEvent event) {
        pgender=p_f.getText();
    }

    @FXML
    void p_m(ActionEvent event) {
        pgender=p_m.getText();
    }

    @FXML
    void p_name(ActionEvent event) {
     //   pname=p_name.getText();
    }

    @FXML
    void p_pur(ActionEvent event) {
        //purpose=p_pur.getText();
    }

    @FXML
    void p_unit(ActionEvent event) { 
      // unitreq=Float.parseFloat(p_unit.getText());
    }

    @FXML
    void sub(ActionEvent event)  {
        spin.setVisible(true);
       
          pcon=Long.parseLong(p_cont.getText());
          CheckPhNo ch= new CheckPhNo();
          if(ch.checkPh(pcon)==0)
              AlertBox.display("Result","Enter 10 digit mobile number!!");
          else{
          //unitreq=Float.parseFloat(p_unit.getText());
          unitreq=(int)(p_unit.getValue());
          purpose=p_pur.getText();
           pname=p_name.getText();
           if(pt.isSelected())
               ptr="Print Receipt";
           else ptr="No";
        PurSql.demo2();
        if(PurSql.ok==1){
        try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WebCamPreview2.fxml")); 
        Parent root1 = (Parent) fxmlLoader.load(); 
        Stage stage = new Stage(); 
        stage.setTitle("Purchaser Pic");
       // stage.getIcons().add(new Icon(FirstFXMLController.class.getResourceAsStream("bb.png")));
        stage.setScene(new Scene(root1));
        stage.show();}catch(IOException e){
            System.out.println("Cant open new window");
        }
            PurSql.ok=0;
        }
        p_name.setText("");
          p_pur.setText("");
         // p_unit.setText("");
          p_cont.setText("");
          p_m.setSelected(false);
          p_f.setSelected(false);
          apos.setSelected(false);
          aneg.setSelected(false);
          bpos.setSelected(false);
          bneg.setSelected(false);
          opos.setSelected(false);
          oneg.setSelected(false);
          abpos.setSelected(false);
          abneg.setSelected(false);
          pt.setSelected(false);
          spin.setVisible(false);
          }
          
                 
       // AlertBox.display("Result","Submitted");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        spin.setVisible(false);
        ToggleGroup tg = new ToggleGroup();
        apos.setToggleGroup(tg);
        aneg.setToggleGroup(tg);
        bpos.setToggleGroup(tg);
        bneg.setToggleGroup(tg);
        opos.setToggleGroup(tg);
        oneg.setToggleGroup(tg);
        abpos.setToggleGroup(tg);
        abneg.setToggleGroup(tg);
        ToggleGroup tg1 = new ToggleGroup();
        p_f.setToggleGroup(tg1);
        p_m.setToggleGroup(tg1);
    }    
    
}
