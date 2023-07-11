/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.city.controler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import domain.Country;
import genericService.GenericService;
import serviceImpl.CountryServiceImpl;
import ui.component.table.model.CountryTableModel;
import ui.form.country.CountrySelectForm;

/**
 *
 * @author Jelena Basaric
 */
public class CountrySelectFormController {
    public static void populateTableCountries(JTable tblCountries){
          //osvezi tabelu
        genericService.GenericService countryService = new CountryServiceImpl();
        try {
            List<Country> countries = countryService.getAll();
            tblCountries.setModel(new CountryTableModel(countries));
        } catch (Exception ex) {
            Logger.getLogger(CountrySelectForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Country getSelectedCountry(JTable tblCountries, CountrySelectForm countrySelectForm){
        //proveri da li si selektovao neki red
        int row = tblCountries.getSelectedRow();
        if (row == -1){
            JOptionPane.showMessageDialog(countrySelectForm, "Niste izabrali drzavu!");
            
            return null;
        }else{
            CountryTableModel countryTableModel = (CountryTableModel) tblCountries.getModel();
            countrySelectForm.dispose();
            return countryTableModel.getCountry(row);
          
        }
    }
}
