/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.city.controler;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import domain.City;
import genericService.GenericService;
import serviceImpl.CityServiceImpl;
import ui.component.table.model.CityTableModel;
import ui.form.city.CitySearchForm;

/**
 *
 * @author Jelena Basaric
 */
public class CitySearchFormController {
    public static void populateTableCities (JTable tblCities ){
         try {
             genericService.GenericService cityService = new CityServiceImpl();
            List<City> cities = cityService.getAll();
            
            tblCities.setModel(new CityTableModel(cities));
        } catch (Exception ex) {
            Logger.getLogger(CitySearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
