/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ayush
 */
public class ModelTable {
     private final StringProperty d_id, do_name, d_gender, d_age,d_contact, d_blood,d_units,h_id, h_name,date;

    public ModelTable(String d_id, String do_name, String d_gender, String d_age, String d_contact, String d_blood, String d_units, String h_id, String h_name, String date) {
        this.d_id = new SimpleStringProperty(d_id);
        this.do_name = new SimpleStringProperty(do_name);
        this.d_gender = new SimpleStringProperty(d_gender);
        this.d_age = new SimpleStringProperty(d_age);
        this.d_contact = new SimpleStringProperty(d_contact);
        this.d_blood = new SimpleStringProperty(d_blood);
        this.d_units = new SimpleStringProperty(d_units);
        this.h_id = new SimpleStringProperty(h_id);
        this.h_name = new SimpleStringProperty(h_name);
        this.date = new SimpleStringProperty(date);
    }

    

    public String getD_id() {
        return d_id.get();
    }

    public void setD_id(String d_id) {
        this.d_id.set(d_id);
    }

    public String getDo_name() {
        return do_name.get();
    }

    public void setDo_name(String do_name) {
        this.do_name.set(do_name);
    }

    public String getD_gender() {
        return d_gender.get();
    }

    public void setD_gender(String d_gender) {
        this.d_gender.set(d_gender);
    }

    public String getD_age() {
        return d_age.get();
    }

    public void setD_age(String d_age) {
        this.d_age.set(d_age);
    }

    public String getD_contact() {
        return d_contact.get();
    }

    public void setD_contact(String d_contact) {
        this.d_contact.set(d_contact);
    }

    public String getD_blood() {
        return d_blood.get();
    }

    public void setD_blood(String d_blood) {
        this.d_blood.set(d_blood);
    }

    public String getD_units() {
        return d_units.get();
    }

    public void setD_units(String d_units) {
        this.d_units.set(d_units);
    }

    public String getH_id() {
        return h_id.get();
    }

    public void setH_id(String h_id) {
        this.h_id.set(h_id);
    }

    public String getH_name() {
        return h_name.get();
    }

    public void setH_name(String h_name) {
        this.h_name.set(h_name);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

  
    
}
