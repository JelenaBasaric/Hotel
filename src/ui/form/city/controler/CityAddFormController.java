/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.city.controler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import domain.City;
import domain.Country;
import genericService.GenericService;
import serviceImpl.CityServiceImpl;
import serviceImpl.CountryServiceImpl;
import ui.form.city.CityAddForm;
import ui.form.country.CountrySelectForm;

/**
 *
 * @author Jelena basaric
 */
public class CityAddFormController {
    public static void save(JTextField txtCityName,JTextField txtZipcode, JComboBox comboCountry, JTextArea txtError ){
        String error="";
       
       try{
           
           boolean isValid = true;
           
           String name = txtCityName.getText().trim();
           try{
                Long zipcode = Long.parseLong(txtZipcode.getText().trim());
                Country country = (Country) comboCountry.getSelectedItem();
                
                City city = new City(zipcode, name, country);
                
                if (name.isEmpty()){
                    error=error+"\nNiste uneli naziv grada!";
                    isValid = false;
                }
                //sacuvaj grad
                if( isValid){
                    genericService.GenericService cityService = new CityServiceImpl();
                    cityService.add(city);
                    txtError.setForeground(new java.awt.Color(0, 0, 0));
                    txtError.setText("Grad je uspesno sacuvan!");
                    
                    txtCityName.setText("");
                    txtZipcode.setText("");
                    comboCountry.setSelectedIndex(0);
               }else{
                   txtError.setText(error);
                }
                
           }catch(NumberFormatException nfe){
               isValid = false;
               error=error+"\nNiste uneli broj za PTT broj!";
               
               txtError.setText(error);
           }
       }catch(Exception e){
           error=error+"\n"+e.getMessage();
           txtError.setText(error);
       }
    }
    
    public static CountrySelectForm createCountrySelectForm(){
       CountrySelectForm countrySelectForm = new CountrySelectForm(null, true);
       return countrySelectForm;
    }
    
    public static void selectCountry(CountrySelectForm countrySelectForm, JComboBox comboCountry){
        //pokusaj da uzmes selektovanu drzavu
        if (countrySelectForm!=null){
            Country selectedCountry = (Country) countrySelectForm.getSelectedCountry();
            System.out.println(selectedCountry);
            //mozda sam kliknuo na odustani
            if (selectedCountry!=null){
                comboCountry.setSelectedItem(selectedCountry);
            }
        }
    }
    
    public static void populateComboCountry(JComboBox comboCountry){
         //popouni combo
        //ucitaj listu drzava
        genericService.GenericService countryService = new CountryServiceImpl();
        try {
            comboCountry.removeAllItems();
            
            List<Country> countries = countryService.getAll();
            //lisu zemalja postavi u combobox
            for (Country country : countries) {
                comboCountry.addItem(country);
            }
        } catch (Exception ex) {
            Logger.getLogger(CityAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
