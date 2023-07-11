/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.employee.controler;

import applicationSession.ApplicationSession;
import domain.City;
import domain.Employee;
import domain.GenderEnum;
import domain.Role;
import genericService.GenericService;
import genericService.RoleService;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import ui.form.employee.EmployeeAddForm;
import ui.form.employee.EmployeeDetailsForm;

/**
 *
 * @author Jelena Basaric
 */
public class EmployeeDetailsFormControler {

    public static void prepareForm(JTextField txtFirstName, JTextField txtLastName, JTextField txtAdrress, JTextField txtAdrress0, JTextField txtEmail, JTextField txtPhoneNumber, JTextField txtSalary, JTextField txtError, JTextField txtDOB, JRadioButton rbtnFemale, JRadioButton rbtnMale, JRadioButton rbtnUnknown, JComboBox<Object> cmbCity, JComboBox<Object> cmbRole, GenericService employeeService) {
        Integer idEmployee = ApplicationSession.getInstance().getIdEmployee();
        Employee e = (Employee) employeeService.findById(idEmployee);
        txtFirstName.setText(e.getFirstName());
        txtLastName.setText(e.getLastName());
        txtDOB.setText(e.getDateOfBirth().toString());
        txtAdrress.setText(e.getAddress());
        txtEmail.setText(e.getEmail());
        txtPhoneNumber.setText(e.getPhoneNumber());
        txtSalary.setText(e.getSalary().toString());
        switch (e.getGender()) {
            case MUSKI:
                rbtnMale.isSelected();
                break;
            case ZENSKI:
                rbtnFemale.isSelected();
                break;
            case NEPOZNATO:
                rbtnUnknown.isSelected();
                break;
            default:
                break;
        }
    }

    public static void populateComboRole(RoleService roleService, JComboBox<Object> cmbRole) {
        try {
            cmbRole.setModel(new DefaultComboBoxModel<>(roleService.getAll().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void populateComboCity(GenericService cityService, JComboBox<Object> cmbCity) {
               try {
                
                cmbCity.setModel(new DefaultComboBoxModel<>(cityService.getAll().toArray()));
            } catch (Exception ex) {
                Logger.getLogger(EmployeeAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void addOrUpdateEmployee(JTextField txtFirstName, JTextField txtLastName, JTextField txtAdrress, JTextField txtAdrress0, JTextField txtEmail, JTextField txtPhoneNumber, JTextField txtSalary, JTextField txtError, JTextField txtDOB, JRadioButton rbtnFemale, JRadioButton rbtnMale, JRadioButton rbtnUnknown, JComboBox<Object> cmbCity, JComboBox<Object> cmbRole, GenericService employeeService) {
      String name=txtFirstName.getText().trim();
        String lastname=txtLastName.getText().trim();
        String phoneNo = txtPhoneNumber.getText().trim();
        String email = txtEmail.getText().trim();
        City city=(City) cmbCity.getSelectedItem();
        String address = txtAdrress.getText().trim();
        BigDecimal salary=new BigDecimal(txtSalary.getText().trim());
        GenderEnum gender=null;
        String date=txtDOB.getText();
        //LocalDate dateOfBirth =Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
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
        Role role=(Role)cmbRole.getSelectedItem();
        Employee employee=new Employee(0, salary, name, lastname, gender, address, city, phoneNo, email, null, role);
            try {
               employeeService.saveOrUpdate(employee);
                txtError.setText("Sacuvan je zaposleni sa ID: " + employee.getEmployeeId());
            } catch (Exception ex) {
                Logger.getLogger(EmployeeDetailsForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    } 

}
