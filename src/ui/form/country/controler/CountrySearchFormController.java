/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.country.controler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import domain.Country;
import genericService.GenericService;
import serviceImpl.CountryServiceImpl;
import ui.component.table.model.CountryTableModel;
import ui.form.country.CountrySearchForm;

/**
 *
 * @author Jelena Basaric
 */
public class CountrySearchFormController {
    public static void populateTableCountries(JTable tblCountries){
         try {
            //uzmi listu svih drzava
             genericService.GenericService countryService = new CountryServiceImpl();
            List<Country> countries = countryService.getAll();
            
            TableModel tableModel = new CountryTableModel(countries);
            tblCountries.setModel(tableModel);
        
        } catch (Exception ex) {
            Logger.getLogger(CountrySearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
