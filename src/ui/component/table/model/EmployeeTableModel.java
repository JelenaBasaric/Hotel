/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.Country;
import domain.Employee;

/**
 *
 @author Jelena Basaric
 */
public class EmployeeTableModel extends AbstractTableModel{
    private final List<Employee> employees;

    public EmployeeTableModel(List<Employee> employees) {
        this.employees = employees;
    }
    
    @Override
    public int getRowCount() {
        if (employees == null) return 0;
        return employees.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = employees.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return employee.getEmployeeId();
            case 1:
                return employee.getFirstName();
            case 2:
                return employee.getLastName();
                case 3:
                return employee.getDateOfBirth();
            case 4:
                return employee.getGender();
            case 5:
                return employee.getCity();
            default:
                break;
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
                case 3:
                return "Datum rođenja";
            case 4:
                return "pol";
            case 5:
                return "grad";
            default:
                break;
        }
        return "n/a";
    }  
   
    
}
