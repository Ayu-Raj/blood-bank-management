/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbankk;

/**
 *
 * @author ayush
 */
public class ModelTable3 {
    String p_id, p_name, p_gender, p_purpose, p_units, p_blood, p_contact,date;

    public ModelTable3(String p_id, String p_name, String p_gender, String p_purpose, String p_units, String p_blood, String p_contact, String date) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_gender = p_gender;
        this.p_purpose = p_purpose;
        this.p_units = p_units;
        this.p_blood = p_blood;
        this.p_contact = p_contact;
        this.date = date;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_gender() {
        return p_gender;
    }

    public void setP_gender(String p_gender) {
        this.p_gender = p_gender;
    }

    public String getP_purpose() {
        return p_purpose;
    }

    public void setP_purpose(String p_purpose) {
        this.p_purpose = p_purpose;
    }

    public String getP_units() {
        return p_units;
    }

    public void setP_units(String p_units) {
        this.p_units = p_units;
    }

    public String getP_blood() {
        return p_blood;
    }

    public void setP_blood(String p_blood) {
        this.p_blood = p_blood;
    }

    public String getP_contact() {
        return p_contact;
    }

    public void setP_contact(String p_contact) {
        this.p_contact = p_contact;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
}
