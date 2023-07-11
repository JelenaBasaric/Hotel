/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.guest.controler;

import com.toedter.calendar.JDateChooser;
import domain.City;
import domain.GenderEnum;
import domain.Guest;
import genericService.GenericService;
import genericService.GuestService;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ui.form.guest.GuestAddForm;

/**
 *
 * @author Jelena Basaric
 */
public class GuestAddFormControler {

    public static void populateComboCity(GenericService cityService, JComboBox<Object> cmbCity) {
        try {
            cmbCity.setModel(new DefaultComboBoxModel<>(cityService.getAll().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(GuestAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void populateComboCountry(JComboBox<Object> cmbCountry, GenericService countryService) {
        try {
            cmbCountry.setModel(new DefaultComboBoxModel<>(countryService.getAll().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(GuestAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void addGuest(JTextField txtFirstName, JTextField txtLastName, JTextField txtAdrress, JDateChooser txtDate, JTextField txtEmail, JTextField txtError, JTextField txtPassportNo, JTextField txtPhoneNumber, JTextField txtRoomNo, JComboBox<Object> cmbCity, JComboBox<Object> cmbCountry, JRadioButton rbtnMale, JRadioButton rbtnFemale, JRadioButton rbtnUnknown, GuestService guestService) {
       String name=txtFirstName.getText().trim();
        String lastname=txtLastName.getText().trim();
        String error="";
        boolean valid=true;
        if(name.isEmpty()|| lastname.isEmpty()){
            error="Niste uneli osnovne podatke o gostu!";
            valid=false;
        }
        String phoneNo = txtPhoneNumber.getText().trim();
        String email = txtEmail.getText().trim();
        String passportNo = txtPassportNo.getText().trim();
        if(passportNo.isEmpty()){
            error+="Niste uneli broj pasosa!";
            valid=false;
        }
        
        City city=(City) cmbCity.getSelectedItem();
        String address = txtAdrress.getText().trim();
         if(address.isEmpty()){
            error+="Niste uneli adresu! ";
        valid=false;}
        GenderEnum gender=null;
        Date date=txtDate.getDate();
        LocalDate dateOfBirth =Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        if(date==null || date.after(new Date())){
            error+="Niste uneli pravilan datum rodjenja!";
            valid=false;           
        }
        if(rbtnFemale.isSelected())
        {
            gender=GenderEnum.ZENSKI;
        }
        else if(rbtnMale.isSelected()){
            gender=GenderEnum.MUSKI;
        }
        else{
            gender=GenderEnum.NEPOZNATO;
        }
        Guest guest=new Guest(0, passportNo, null, name, lastname, gender, address, city, phoneNo, email, dateOfBirth);
            try {
                if(valid){
                guestService.saveOrUpdate(guest);
                txtError.setText("Sacuvan je gost sa ID: " + guest.getGuestId());
                }
                else{
                    txtError.setText(error);
                }
            } catch (Exception ex) {
                Logger.getLogger(GuestAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }

}
