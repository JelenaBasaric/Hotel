/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.City;

public class CityTableModel extends AbstractTableModel{
    private final List<City> cities;

    public CityTableModel(List<City> cities) {
        this.cities = cities;
    }
    
    @Override
    public int getRowCount() {
        if (cities == null) return 0;
        return cities.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        City city = cities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return city.getZipCode();
            case 1:
                return city.getCityName();
            case 2:
                return city.getCountry().getCountryName();
            default:
                break;
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "PTT";
            case 1:
                return "GRAD";
            case 2:
                return "DRZAVA";
            default:
                break;
        }
        return "n/a";
    }
 
    
}
