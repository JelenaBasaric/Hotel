/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.employee.controler;

import com.toedter.calendar.JDateChooser;
import domain.City;
import domain.Employee;
import domain.GenderEnum;
import domain.Role;
import genericService.EmployeeService;
import genericService.GenericService;
import genericService.RoleService;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import serviceImpl.EmployeeServiceImpl;
import ui.form.employee.EmployeeAddForm;

/**
 *
  * @author Jelena Basaric
 */
public class EmployeeAddFormControler {

  
    

    public static void addEmployee(JTextField txtFirstName, JTextField txtLastName, JTextField txtAdrress, JTextField txtAdrress0, JTextField txtEmail, JTextField txtPhoneNumber, JTextField txtSalary, JTextField txtError, JDateChooser txtDate, JRadioButton rbtnFemale, JRadioButton rbtnMale, JRadioButton rbtnUnknown, JComboBox<Object> cmbCity, JComboBox<Object> cmbRole, GenericService employeeService) {
        employeeService=new EmployeeServiceImpl();
      String name=txtFirstName.getText().trim();
        String lastname=txtLastName.getText().trim();
        String error="";
        boolean valid=true;
        if(name.isEmpty()|| lastname.isEmpty()){
            error="Niste uneli osnovne podatke o zaposlenom";
            valid=false;
        }
        String phoneNo = txtPhoneNumber.getText().trim();
        String email = txtEmail.getText().trim();
        City city=(City) cmbCity.getSelectedItem();
        String address = txtAdrress.getText().trim();
        if(address.isEmpty()){
            error+="Niste uneli adresu! ";
        valid=false;}
        BigDecimal salary=new BigDecimal(txtSalary.getText().trim());
        GenderEnum gender=null;
        Date date=txtDate.getDate();
        LocalDate dateOfBirth=null;
        if(date==null || date.after(new Date())){
            error+="Niste uneli pravilan datum rodjenja!";
            valid=false;           
        }
        else{
             dateOfBirth =Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        }
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
        Employee employee=new Employee(0, salary, name, lastname, gender, address, city, phoneNo, email, dateOfBirth, role);
            try {
               if(valid){
                    employeeService.saveOrUpdate(employee);
                txtError.setText("Sacuvan je zaposleni sa ID: " + employee.getEmployeeId());}
               else
                   txtError.setText(error);
            } catch (Exception ex) {
                Logger.getLogger(EmployeeAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void populateComboCity(JComboBox<Object> cmbCity, GenericService cityService) {
                   try {
                
                cmbCity.setModel(new DefaultComboBoxModel<>(cityService.getAll().toArray()));
            } catch (Exception ex) {
                Logger.getLogger(EmployeeAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void populateComboRole(RoleService roleService, JComboBox<Object> cmbRole) {
         try {                
                cmbRole.setModel(new DefaultComboBoxModel<>(roleService.getAll().toArray()));
            } catch (Exception ex) {
                Logger.getLogger(EmployeeAddForm.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
