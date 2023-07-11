/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.country.controler;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import domain.Country;
import serviceImpl.CountryServiceImpl;
import ui.form.country.CountryAddForm;

/**
 *
 * @author Jelena Basaric
 */
public class CountryAddFormController {
    public static void saveCountry(JTextField txtName,JTextField txtShortName, javax.swing.JTextArea txtError, CountryAddForm form ){
         try{
            String name = txtName.getText().trim();
            String shortname = txtShortName.getText().trim();
            
            //izvrsi validaciju
            txtError.setText("");
             
            boolean isValid = true;
            String error = "";
            if (name.isEmpty()){
                error = error+"Morate uneti naziv drzave!\n";
                isValid = false;
            }
            if (shortname.isEmpty()){
                error = error+"Morate uneti skraceni naziv drzave!";
                isValid = false;
            }
            
            if (isValid){
                Country country = new Country(0, name, shortname);
                //pozvati servis za cuvanje drzave
                genericService.GenericService countryService = new CountryServiceImpl();
                countryService.add(country);
                
                JOptionPane.showMessageDialog(form, "Drzava je uspesno sacuvana!");
            
                txtName.setText("");
                txtShortName.setText("");
            }else{
                txtError.setText(error);
            }
            
            
        }catch(Exception e){
            txtError.setText(e.getMessage());
        }
    }
}
