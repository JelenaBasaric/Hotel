/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.employee.controler;

import applicationSession.ApplicationSession;
import domain.Employee;
import genericService.GenericService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import serviceImpl.EmployeeServiceImpl;
import ui.component.table.model.EmployeeTableModel;
import ui.form.employee.EmployeeDetailsForm;
import ui.form.employee.EmployeeSearchForm;

/**
 *
 * @author Jelena Basaric
 */
public class EmployeeSearchFormControler {

    public static void populateTable(JTable tblEmployees) {
        try {
            GenericService employeeService = new EmployeeServiceImpl();
            List<Employee> employees = new ArrayList<>();
            employees = employeeService.getAll();
            TableModel tm = new EmployeeTableModel(employees);
            tblEmployees.setModel(tm);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeSearchFormControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void openEmployeeDetailist(JTable tblEmployees, EmployeeSearchForm employeeSearchForm) {
        int selectedRow = tblEmployees.getSelectedRow();
        if (selectedRow > -1) {
            Integer id = Integer.parseInt(tblEmployees.getValueAt(selectedRow, 0).toString());
            ApplicationSession.getInstance().setIdEmployee(id);

            JDialog form = new EmployeeDetailsForm(null, true);
            form.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(employeeSearchForm, "Niste izabrali zaposlenog");
        }
    }
}
