/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.Country;

/**
 *
 * @author Jelena Basaric
 * 
 **/

public class CountryTableModel extends AbstractTableModel{
    private final List<Country> countries;

    public CountryTableModel(List<Country> countries) {
        this.countries = countries;
    }
    
    @Override
    public int getRowCount() {
        if (countries == null) return 0;
        return countries.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country country = countries.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return country.getCountryId();
            case 1:
                return country.getCountryName();
            case 2:
                return country.getShortName();
            default:
                break;
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NAZIV";
            case 2:
                return "SKRACENI NAZIV";
            default:
                break;
        }
        return "n/a";
    }
 
    
    public Country getCountry(int index){
        if (countries == null) return null;
        return countries.get(index);
    }
    
}
